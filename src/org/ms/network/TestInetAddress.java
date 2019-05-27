package org.ms.network;

import java.net.InetAddress;

public class TestInetAddress {

    public static void main(String[] args) throws Exception {

        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostName());  //获取计算机名
        System.out.println(address.getHostAddress());  //获取IP地址

        byte[] bytes = address.getAddress();  //获取字节数组形式的IP地址,以点分隔的四部分
        System.out.println(new String(bytes));

    }

}
