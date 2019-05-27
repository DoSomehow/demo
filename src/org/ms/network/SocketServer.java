package org.ms.network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private int count = 0;  //记录客户端的数量
    private int port = -1;

    public SocketServer(int port) {
        this.port = port;
    }

    public void excute() {
        //服务器代码
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            Socket socket =null;
            while(true){
                socket = serverSocket.accept();
                SocketServerThread serverThread = new SocketServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端连接的数量："+count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws Exception {
        SocketServer server = new SocketServer(10086);
        server.excute();
    }

}
