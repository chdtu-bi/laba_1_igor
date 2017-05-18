package com.chdtu.fet.bi;

import java.net.*;
import java.io.*;
import java.util.Date;

public class Client {

    public static void main(String[] ar) {

        int serverPort = 8080;
        String address = "127.0.0.1";

        try {
            InetAddress ipAddress = InetAddress.getByName(address);

            Socket socket = new Socket(ipAddress, serverPort);

            InputStream sIn = socket.getInputStream();
            OutputStream sOut = socket.getOutputStream();

            DataInputStream in = new DataInputStream(sIn);
            DataOutputStream out = new DataOutputStream(sOut);

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String line = keyboard.readLine();
                out.writeUTF(line);
                out.flush();
                line = in.readUTF();

                System.out.println(new Date()+ " : " + line);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}