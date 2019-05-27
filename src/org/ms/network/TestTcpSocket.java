package org.ms.network;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTcpSocket {

    public static void main(String[] args) throws Exception {

        //可以在cmd中使用telnet，如 telnet 192.168.20.251 10086，然后就可以向服务端发送信息了。
        //进入telnet后，使用 ctrl + ] ，然后输入 quit 可以退出telnet。
        //退出telnet后，服务端会自动终止。
        server();

        //用本机 192.168.20.251 telnet服务端，调用以下几个方法，获取的结果
        // System.out.println(socket.getLocalSocketAddress().toString());  //192.168.20.251:10086
        // System.out.println(socket.getInetAddress().toString());  //192.168.20.251
        // System.out.println(socket.getLocalAddress().toString());  //192.168.20.251
        // System.out.println(socket.getRemoteSocketAddress().toString());  //192.168.20.251:63520
        // System.out.println(socket.getLocalSocketAddress().toString());  //192.168.20.251:10086


        // client();

        //由于服务端的accept方法会阻塞进程，所以不能直接在一个进程里执行server()和client()，需要使用多线程来处理
        // serverAndClient();

    }

    public static void serverAndClient() {
        Thread server = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread client = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        server.start();
        client.start();
    }

    /**
     * 基于TCP协议的Socket通信，实现用户登录，服务端
     */
    public static void server() throws Exception {
        System.out.println("[server]开始启动服务端...");
        //1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
        ServerSocket serverSocket = new ServerSocket(10086);//1024-65535的某个端口
        //2、调用accept()方法开始监听，等待客户端的连接
        Socket socket = serverSocket.accept();
        System.out.println("[server]开始监听...");
        //3、获取输入流，并读取客户端信息
        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String info =null;
        while((info=br.readLine())!=null){
            System.out.println("[server]客户端说："+info);
        }
        socket.shutdownInput();//关闭输入流
        //4、获取输出流，响应客户端的请求
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("欢迎您！");
        pw.flush();


        //5、关闭资源
        System.out.println("[server]服务端关闭...");
        pw.close();
        os.close();
        br.close();
        isr.close();
        is.close();
        socket.close();
        serverSocket.close();
    }


    //客户端
    public static void client() throws Exception {
        System.out.println("[client]启动客户端...");
        //1、创建客户端Socket，指定服务器地址和端口
        Socket socket = new Socket("192.168.20.251",10086);
        //2、获取输出流，向服务器端发送信息
        OutputStream os = socket.getOutputStream();//字节输出流
        PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
        pw.write("用户名：admin；密码：123");
        pw.flush();
        socket.shutdownOutput();
        System.out.println("[client]向服务端发送数据...");
        //3、获取输入流，并读取服务器端的响应信息
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String info = null;
        while((info=br.readLine())!=null){
            System.out.println("[client]服务器说："+info);
        }

        //4、关闭资源
        System.out.println("[client]客户端关闭...");
        br.close();
        is.close();
        pw.close();
        os.close();
        socket.close();
    }

}
