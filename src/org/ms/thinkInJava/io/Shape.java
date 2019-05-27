package org.ms.thinkInJava.io;


import java.io.Serializable;
import java.util.Random;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 23:02
 */
abstract class Shape implements Serializable {

    public static final int RED = 1;
    public static final int BLUE = 2;
    public static final int GREEN = 3;
    private int xPos;
    private int yPos;
    private int dimension;
    private static Random rand = new Random(47);
    private static int counter = 0;

    public abstract void setColor(int newColor);

    public abstract int getColor();

    public Shape(int xVal, int yVal, int dim) {
        xPos = xVal;
        yPos = yVal;
        dimension = dim;
    }

    @Override
    public String toString() {
        return getClass() + " color[" + getColor() + "] xPos[" + xPos + "] yPos[" + yPos + "] dim[" + dimension + "]\n";
    }

    public static Shape randomFactory() {
        int xVal = rand.nextInt(100);
        int yVal = rand.nextInt(100);
        int dim = rand.nextInt(100);
        switch (counter++ % 3) {
            default:
            case 0: return new Circle(xVal, yVal, dim);
            case 1: return new Square(xVal, yVal, dim);
            case 2: return new Line(xVal, yVal, dim);
        }
    }
}
