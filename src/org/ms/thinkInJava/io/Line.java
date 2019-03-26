package org.ms.thinkInJava.io;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Author Ryan
 * @Description
 * @Date Created in 2019/3/25 23:09
 */
public class Line extends Shape {
    private static int color = RED;
    public static void serializeStaticState(ObjectOutputStream os) throws IOException {
        os.writeInt(color);
    }
    public static void deserializeStaticState(ObjectInputStream os) throws IOException {
        color = os.readInt();
    }

    public Line(int xVal, int yVal, int dim) {
        super(xVal, yVal, dim);
    }

    public void setColor(int newColor) {
        color = newColor;
    }

    public int getColor() {
        return color;
    }
}
