package org.ms.network;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TestUdpSocket {

    public static void main(String[] args) throws Exception {

        // server();

        // client();

        serverAndClient();

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


    public static void server() throws Exception {
        //服务器端，实现基于UDP的用户登录
        //1、创建服务器端DatagramSocket，指定端口
        DatagramSocket socket = new DatagramSocket(10010);
        //2、创建数据报，用于接受客户端发送的数据
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        //3、接受客户端发送的数据
        socket.receive(packet);//此方法在接受数据报之前会一致阻塞
        //4、读取数据
        String info = new String(data, 0, data.length);
        System.out.println("[server]客户端说: " + info);


        //=========================================================
        //向客户端响应数据
        //1、定义客户端的地址、端口号、数据
        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        String responseMsg = "欢迎您！";
        byte[] data2 = responseMsg.getBytes();
        //2、创建数据报，包含响应的数据信息
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
        //3、响应客户端
        socket.send(packet2);
        //4、关闭资源
        socket.close();
    }


    public static void client() throws Exception {
        //客户端
        //1、定义服务器的地址、端口号、数据
        InetAddress address = InetAddress.getByName("localhost");
        int port = 10010;
        String sendMsg = "用户名：admin;密码：123";
        byte[] data = sendMsg.getBytes();
        //2、创建数据报，包含发送的数据信息
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        //3、创建DatagramSocket对象
        DatagramSocket socket = new DatagramSocket();
        //4、向服务器发送数据
        socket.send(packet);


        //接受服务器端响应数据
        //======================================
        //1、创建数据报，用于接受服务器端响应数据
        byte[] data2 = new byte[1024];
        DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
        //2、接受服务器响应的数据
        socket.receive(packet2);
        String raply = new String(data2, 0, data2.length);
        System.out.println("[client]服务器说: "+ raply);
        //4、关闭资源
        socket.close();
    }


}
