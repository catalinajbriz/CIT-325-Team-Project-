package Lotterys;


import java.io.*;
import java.net.Socket;

public class AuthenticationClient {
    private Socket s;
    private String ipAddr;
    private int port;

    public AuthenticationClient(String ipAddr, int port) {

        try {
            s = new Socket(ipAddr, port);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        this.ipAddr = ipAddr;
        this.port = port;
    }

    public AuthResult run(User user) {

        try {

            OutputStream outStream = s.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outStream);

            InputStream inputStream = s.getInputStream();
            ObjectInputStream in = new ObjectInputStream(inputStream);

            out.writeObject(user);
            AuthResult result = (AuthResult) in.readObject();


            s.close();
            return result;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {

        AuthenticationClient client = new AuthenticationClient("127.0.0.1", 8189);

        AuthResult result = client.run(new User("user0", "123456"));

    }


}
