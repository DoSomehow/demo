package org.ms.thinkInJava.generics;

import java.util.ArrayList;
import java.util.List;

public class ApplyTest {

    public static void main(String[] args) throws Exception{
        List<Shape> shapes = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            shapes.add(new Shape());
        }
        Apply.apply(shapes, Shape.class.getMethod("rotate"));
        Apply.apply(shapes, Shape.class.getMethod("resize", int.class), 5);

        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            squares.add(new Square());
        }
        Apply.apply(squares, Square.class.getMethod("rotate"));
        Apply.apply(squares, Square.class.getMethod("resize", int.class), 5);

        Apply.apply(new FilledList<Shape>(Shape.class, 10), Shape.class.getMethod("rotate"));
        Apply.apply(new FilledList<Shape>(Square.class, 10), Shape.class.getMethod("rotate"));

        SimpleQueue<Shape> shapeQ = new SimpleQueue<>();
        for (int i = 0; i < 5; i++) {
            shapeQ.add(new Shape());
            shapeQ.add(new Square());
        }
        Apply.apply(shapeQ, Shape.class.getMethod("rotate"));

    }

}
