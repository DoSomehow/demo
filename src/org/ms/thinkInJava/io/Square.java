package org.ms.thinkInJava.io;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 23:09
 */
public class Square extends Shape {
    private static int color;

    public Square(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
        color = RED;
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}
