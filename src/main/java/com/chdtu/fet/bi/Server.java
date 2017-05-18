package com.chdtu.fet.bi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {

    public static void main(String[] args) {

        int port = 8080;

        try {
            ServerSocket ss = new ServerSocket(port);

            Socket socket = ss.accept();
            System.out.println("client connected: ");

            InputStream sIn = socket.getInputStream();
            OutputStream sOut = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sIn);
            DataOutputStream out = new DataOutputStream(sOut);

            while (true) {
                String line = in.readUTF();
                System.out.println(new Date()+ " : " + line);
                out.writeUTF(line);
                out.flush();
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}