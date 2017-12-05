/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lotterys;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    
    private Socket s;
    private String ipAddr;
    private int port;
    
    
    public Client(String ipAddr, int port) {
        
        try {
            s = new Socket(ipAddr, port);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        this.ipAddr = ipAddr;
        this.port = port; 
    }
    
    
    
    public void run() {
    
        try {
            
            OutputStream outStream = s.getOutputStream();
            DataOutputStream out = new DataOutputStream(outStream);
            
            Scanner in = new Scanner(System.in);
   
            while(in.hasNextLine()) {
                String line = in.nextLine();
                out.writeUTF(line);
                if (line.trim().equals("BYE")) {
                    break;
                }
            }
            s.close();
        } catch (IOException ex) {
            System.out.println(ex);
        } 
        
    }
    
}
