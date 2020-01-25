package org.ms.javaTest.socket;

import java.io.*;
import java.net.Socket;

public class AuthSocketClient {

    public void run() {
        OutputStream out = null;
        try {
            // String ip = "localhost";
            String ip = "10.124.44.200";
            Socket socket = new Socket(ip, 19001);
            out = socket.getOutputStream();

            ObjectOutputStream objOut = new ObjectOutputStream(out);

            String sendMsg = "request connect";
            objOut.writeObject(sendMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AuthSocketClient asc = new AuthSocketClient();
        asc.run();
    }

}
