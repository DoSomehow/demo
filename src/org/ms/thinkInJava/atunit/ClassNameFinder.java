package org.ms.thinkInJava.atunit;

import org.ms.thinkInJava.util.BinaryFile;
import org.ms.thinkInJava.util.Directory;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/4/1 23:51
 */
public class ClassNameFinder {

    public static String thisClass(byte[] classBytes) {
        Map<Integer, Integer> offsetTable = new HashMap<>();
        Map<Integer, String> classNameTable = new HashMap<>();

        try {
            DataInputStream data = new DataInputStream(new ByteArrayInputStream(classBytes));
            int magic = data.readInt();  //0xcafebabe
            int minorVersion = data.readShort();
            int majorVersion = data.readShort();
            int constant_pool_count = data.readShort();
            int[] constant_pool = new int[constant_pool_count];

            for (int i = 1; i < constant_pool_count; i++) {
                int tag = data.read();
                int tableSize;
                switch (tag) {
                    case 1:  //UTF
                        int length = data.readShort();
                        char[] bytes = new char[length];
                        for (int k = 0; k < bytes.length; k++) {
                            bytes[k] = (char) data.read();
                        }
                        String className = new String(bytes);
                        classNameTable.put(i, className);
                        break;
                    case 5:  //LONG
                    case 6: //DOUBLE
                        data.readLong();  //discard 8 bytes
                        i++;  //Special skip necessary
                        break;
                    case 7:  //CLASS
                        int offset = data.readShort();
                        offsetTable.put(i, offset);
                        break;
                    case 8:  //String
                        data.readShort();  //discard 2 bytes
                        break;
                    case 3:  //INTEGER
                    case 4:  //FLOAT
                    case 9:  //FIELD_REF
                    case 10:  //METHOD_REF
                    case 11:  //INTERFACE_METHOD_REF
                    case 12:  //NAME_AND_TYPE
                        data.readInt();  //discard 4 bytes;
                        break;
                    default:
                        throw new RuntimeException("Bad tag " + tag);
                }
            }

            short access_flags = data.readShort();
            int this_class = data.readShort();
            int super_class = data.readShort();
            return classNameTable.get(offsetTable.get(this_class)).replace('/', '.');

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Demonstration:
    public static void main(String[] args) throws Exception {

        args = new String[1];
        args[0] = "G:\\MyProject\\iProject\\demo\\web\\WEB-INF\\classes\\org\\ms\\thinkInJava\\atunit\\Test.class";

        if (args.length > 0) {
            for (String arg : args) {
                System.out.println(thisClass(BinaryFile.read(new File(arg))));
            }
        } else {
            //Walk the entire tree:
            for (File klass : Directory.walk(".", ".*\\.class")) {
                System.out.println(thisClass(BinaryFile.read(klass)));
            }
        }
    }


}
