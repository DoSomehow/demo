package org.ms.thinkInJava.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/24 23:27
 */
public class ZipCompress {

    public static void main(String[] args) throws IOException {

        args = new String[]{
                "C:\\Users\\Administrator\\Desktop\\file1.txt",
                "C:\\Users\\Administrator\\Desktop\\file2.txt",
                "C:\\Users\\Administrator\\Desktop\\file3.txt"
        };

        FileOutputStream f = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\test.zip");
        CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
        ZipOutputStream zos = new ZipOutputStream(csum);
        BufferedOutputStream out = new BufferedOutputStream(zos);
        zos.setComment("A test of Java Zipping");
        //No corresponding getComment(), though
        for (String arg : args) {
            System.out.println("Writing file " + arg);
            BufferedReader in = new BufferedReader(new FileReader(arg));
            zos.putNextEntry(new ZipEntry(arg));
            // zos.putNextEntry(new ZipEntry(arg.substring(arg.length() - 9, arg.length())));
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
            in.close();
            out.flush();
        }
        out.close();

        //Checksum valid only after the file has been closed!
        System.out.println("Checksum: " + csum.getChecksum().getValue());
        //Now extract the files:
        System.out.println("Reading file");
        FileInputStream fi = new FileInputStream("C:\\Users\\Administrator\\Desktop\\test.zip");
        CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
        ZipInputStream in2 = new ZipInputStream(csumi);
        BufferedInputStream bis = new BufferedInputStream(in2);
        ZipEntry ze;
        while ((ze = in2.getNextEntry()) != null) {
            System.out.println("Reading file " + ze);
            int x;
            while ((x = bis.read()) != -1) {
                System.out.write(x);
            }
        }

        if (args.length == 1) {
            System.out.println("Checksum: " + csumi.getChecksum().getValue());
        }
        bis.close();

        //Alternative way to open and read Zip files:
        ZipFile zf = new ZipFile("C:\\Users\\Administrator\\Desktop\\test.zip");
        Enumeration e = zf.entries();
        while (e.hasMoreElements()) {
            ZipEntry ze2 = (ZipEntry) e.nextElement();
            System.out.println("File: " + ze2);
            //...and extract the data as before
        }
        /* if(args.length == 1) */
    }

}
