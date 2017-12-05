/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lotterys;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AuthenticationServer {

    private ServerSocket s;
    private boolean over;
    private int port;

    private User user;

    public AuthenticationServer(int port) {


        try {
            File currentDirFile = new File(".");
            String filePath = currentDirFile.getAbsolutePath();
            filePath += "/resource/credential.txt";
            BufferedReader br = Files.newBufferedReader(Paths.get(filePath));
            String name = br.readLine();
            String password = br.readLine();
            user = new User(name, password);

            s = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        over = false;
        this.port = port;
    }

    public static void main(String[] args) {

        AuthenticationServer authenticationServer = new AuthenticationServer(8189);

        authenticationServer.run();
    }

    public void run() {
        while (!over) {

            try {
                Socket incoming = s.accept();

                ObjectInputStream input = new ObjectInputStream(incoming.getInputStream());
                ObjectOutputStream output = new ObjectOutputStream(incoming.getOutputStream());

                boolean done = false;
                while (!done) {
                    User testUser = (User) input.readObject();
                    if (testUser.getName().equals(user.getName())
                            &&
                            testUser.getPassword().equals(user.getPassword())) {
                        output.writeObject(new AuthResult(true));

                        StudentClient client = new StudentClient("127.0.0.1", 8190);
                        client.sendAuth(new AuthResult(true));

                    } else {
                        output.writeObject(new AuthResult(false));

                    }
                    done = true;
                }
                incoming.close();

            } catch (IOException ex) {
                System.out.println(ex);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }

        try {
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(AuthenticationServer.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

}
