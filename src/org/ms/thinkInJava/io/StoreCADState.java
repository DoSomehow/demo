package org.ms.thinkInJava.io;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 23:12
 */
public class StoreCADState {

    public static void main(String[] args) throws Exception {
        List<Class<? extends Shape>> shapeTypes = new ArrayList<>();
        //Add references to the class objects:
        shapeTypes.add(Circle.class);
        shapeTypes.add(Square.class);
        shapeTypes.add(Line.class);

        List<Shape> shapes = new ArrayList<>();
        //Make some shapes:
        for (int i = 0; i < 10; i++) {
            shapes.add(Shape.randomFactory());
        }
        //Set all the static colors to GREEN:
        for (int i = 0; i < 10; i++) {
            shapes.get(i).setColor(Shape.GREEN);
        }
        //Save the state vector:
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("CADState.out"));
        out.writeObject(shapeTypes);
        Line.serializeStaticState(out);
        out.writeObject(shapes);
        //Display the shapes:
        System.out.println(shapes);
    }

}
