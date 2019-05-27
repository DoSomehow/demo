package org.ms.thinkInJava.io;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 23:45
 */
public class RecoverCADState {

    public static void main(String[] args) throws Exception {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("CADState.out"));
        //Read in the same order they were written:
        List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
        Line.deserializeStaticState(in);
        List<Shape> shapes = (List<Shape>) in.readObject();
        System.out.println(shapes);
    }

}
