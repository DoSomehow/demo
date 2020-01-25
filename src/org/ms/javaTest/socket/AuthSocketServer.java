package org.ms.javaTest.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class AuthSocketServer {

    private int centerPort = 19001;

    public void run(){
        ServerSocket serverSocket = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            serverSocket = new ServerSocket(centerPort);
            while(true){
                Socket socket = serverSocket.accept();
                if (socket != null) {
                    in = socket.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(in);
                    String inContent = (String) ois.readObject();
                    System.out.println("receive msg: " + inContent);
                    socket.shutdownInput();//关闭输入流

                    System.out.println("getLocalSocketAddress:" + String.valueOf(socket.getLocalSocketAddress()));
                    System.out.println("getInetAddress:" + String.valueOf(socket.getInetAddress()));
                    System.out.println("getLocalAddress:" + String.valueOf(socket.getLocalAddress()));
                    System.out.println("getRemoteSocketAddress:" + String.valueOf(socket.getRemoteSocketAddress()));

                    // String msg = "[server]:" + inContent;
                    // out = socket.getOutputStream();
                    // ObjectOutputStream objOut = new ObjectOutputStream(out);
                    // objOut.writeObject(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        AuthSocketServer ass = new AuthSocketServer();
        ass.run();
    }

}
