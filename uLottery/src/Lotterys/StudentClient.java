package Lotterys;


import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class StudentClient {
    private Socket s;
    private String ipAddr;
    private int port;

    public StudentClient(String ipAddr, int port) {

        try {
            s = new Socket(ipAddr, port);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        this.ipAddr = ipAddr;
        this.port = port;
    }

    public static void main(String[] args) {

        StudentClient client = new StudentClient("127.0.0.1", 8190);

        client.sendAuth(new AuthResult(true));

        client = new StudentClient("127.0.0.1", 8190);

        Student student = client.findStudent("123");


//        client.run(new User("user0", "123456"));
    }

    public AuthResult sendAuth(AuthResult result) {

        try {

            OutputStream outStream = s.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outStream);

            out.writeObject(result);

            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Student> getResult() {
        //TODO
        try {

            OutputStream outStream = s.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outStream);
            InputStream inStream = s.getInputStream();
            ObjectInputStream in = new ObjectInputStream(inStream);

            out.writeObject(new Operation("list", ""));


            Object nextObject = in.readObject();

            List<Student> results = new LinkedList<>();
            while (!nextObject.equals(new Integer(0))) {

                Student student = (Student) nextObject;
                results.add(student);
                nextObject = in.readObject();

            }


            s.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        return null;
    }

    public void addStudent(Student student) {
        try {

            OutputStream outStream = s.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outStream);

            out.writeObject(new Operation("add", student));


            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student findStudent(String puid) {
        try {

            OutputStream outStream = s.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outStream);

            InputStream inStream = s.getInputStream();
            ObjectInputStream in = new ObjectInputStream(inStream);

            out.writeObject(new Operation("search", puid));
            Object obj = in.readObject();

            Student student;
            if (obj == null) {
                student = null;
            } else {
                student = (Student) obj;
            }


            s.close();
            return student;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
