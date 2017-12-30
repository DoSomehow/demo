package org.ms.thinkInJava.generics;

import java.awt.*;

/**
 * Created by Ryan on 2017/10/23.
 */
public class Bounded extends Dimension implements HasColor, Weight {

    @Override
    public int weight() {
        return 0;
    }

    @Override
    public Color getColor() {
        return null;
    }
}
