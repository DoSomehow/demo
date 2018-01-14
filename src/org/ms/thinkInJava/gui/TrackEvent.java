package org.ms.thinkInJava.gui;

import org.ms.thinkInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class TrackEvent extends JFrame{
    private HashMap<String, JTextField> h = new HashMap<>();

    private String[] event = {
            "focusGained", "focusLost", "keyPressed",
            "keyReleased", "keyTyped", "mouseClicked",
            "mouseEntered", "mouseExited", "mousePressed",
            "mouseReleased", "mouseDragged", "mouseMoved",
    };

    private MyButton b1 = new MyButton(Color.BLUE, "test1");
    private MyButton b2 = new MyButton(Color.RED, "test2");

    public TrackEvent(){
        setLayout(new GridLayout(event.length + 1, 2));
        for(String evt : event){
            JTextField t = new JTextField();
            t.setEditable(false);
            add(new JLabel(evt, JLabel.RIGHT));
            add(t);
            h.put(evt, t);
        }
        add(b1);
        add(b2);
    }

    public static void main(String[] args) {
        SwingConsole.run(new TrackEvent(), 700, 500);
    }

    class MyButton extends JButton{

        public MyButton(Color color, String label){
            super(label);
            setBackground(color);
            addFocusListener(fl);
            addKeyListener(kl);
            addMouseListener(ml);
            addMouseMotionListener(mml);
        }

        void report(String field, String msg){
            h.get(field).setText(msg);
        }

        FocusListener fl = new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                report("focusGained", e.paramString());
            }

            @Override
            public void focusLost(FocusEvent e) {
                report("focusLost", e.paramString());
            }
        };

        KeyListener kl = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        MouseListener ml = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        MouseMotionListener mml = new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };
    }
}
