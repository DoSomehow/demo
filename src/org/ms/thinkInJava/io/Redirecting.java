package org.ms.thinkInJava.io;

import java.io.*;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/21 21:39
 */
public class Redirecting {
    public static void main(String[] args) throws IOException {
        PrintStream console = System.out;
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("G:\\MyProject\\iProject\\demo\\src\\org\\ms\\thinkInJava\\io\\Redirecting.java"));

        PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.out")));
        System.setIn(in);
        System.setOut(out);
        System.setErr(out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null){
            System.out.println(s);
        }
        out.close();  //Remember this !
        System.setOut(console);
    }

}
