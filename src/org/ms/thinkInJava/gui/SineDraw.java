package org.ms.thinkInJava.gui;

import javax.swing.*;
import java.awt.*;

public class SineDraw extends JPanel {

    public static final int SCALEFACTOR = 200;
    private int cycles;
    private int points;
    private double[] sines;
    private int[] pts;

    public SineDraw(){
        setCycles(5);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int maxWidth = getWidth();
        double hsetp = (double)maxWidth / (double)points;
        int maxHeight = getHeight();
        pts = new int[points];
        for (int i = 0; i < points; i++){
            pts[i] = (int)(sines[i] * maxHeight / 2 * 0.95 + maxHeight / 2);
        }
        g.setColor(Color.RED);
        for(int i = 1; i < points; i++){
            int x1 = (int)((i - 1) * hsetp);
            int x2 = (int)(i * hsetp);
            int y1 = pts[i - 1];
            int y2 = pts[i];
            g.drawLine(x1, y1, x2, y2);
        }
    }

    public void setCycles(int newCycles) {
        this.cycles = newCycles;
        points = SCALEFACTOR * cycles * 2;
        sines = new double[points];
        for(int i = 0; i < points; i++){
            double radians = (Math.PI / SCALEFACTOR) * i;
            sines[i] = Math.sin(radians);
        }
        repaint();
    }
}
