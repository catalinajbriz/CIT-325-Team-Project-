/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lotterys;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StudentServer {

    private ServerSocket s;
    private boolean over;
    private int port;
    private boolean notAuth = true;

    private List<Student> list;


    public StudentServer(int port) {
        try {
            s = new ServerSocket(port);
            list = new LinkedList<>();
        } catch (IOException ex) {
            System.out.println(ex);
        }
        over = false;
        this.port = port;
    }

    public static void main(String[] args) {

        StudentServer studentServer = new StudentServer(8190);

        studentServer.run();
    }

    public void run() {
        while (!over) {

            try {
                Socket incoming = s.accept();

                ObjectInputStream input = new ObjectInputStream(incoming.getInputStream());
                ObjectOutputStream output = new ObjectOutputStream(incoming.getOutputStream());

                if (notAuth) {
                    AuthResult authResult = (AuthResult) input.readObject();
                    if (authResult.isAuthentication()) {
                        notAuth = false;
                    }
                    incoming.close();
                } else {
                    Operation operation = (Operation) input.readObject();
                    if (Objects.equals(operation.getOperation(), "list")) {
                        for (Student student : list) {
                            output.writeObject(student);
                        }
                        output.writeObject(new Integer(0));
                    }

                    if (Objects.equals(operation.getOperation(), "search")) {
                        String puid = (String) operation.getExtra();
                        boolean found = false;
                        for (Student student : list) {
                            if (student.getPUID().equals(puid)) {
                                found = true;
                                output.writeObject(student);
                                break;
                            }

                        }
                        if (!found) {
                            output.writeObject(null);
                        }
                    }
                    if (Objects.equals(operation.getOperation(), "add")) {
                        Student newStudent = (Student) operation.getExtra();
                        boolean found = false;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getPUID().equals(newStudent.getPUID())) {
                                list.set(i, newStudent);
                                found = true;
                            }
                        }
                        if (!found) {
                            list.add(newStudent);
                        }
                    }
                }


                //TODO: send object data based on request

            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }

        try {
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(StudentServer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
