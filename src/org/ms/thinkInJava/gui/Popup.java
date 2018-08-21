package org.ms.thinkInJava.gui;

import org.ms.thinkInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Popup extends JFrame {
    private JPopupMenu popup = new JPopupMenu();
    private JTextField t = new JTextField(10);
    public Popup(){
        setLayout(new FlowLayout());
        add(t);
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setText(((JMenuItem)e.getSource()).getText());
            }
        };
        JMenuItem m = new JMenuItem("Hither");
        m.addActionListener(al);
        popup.add(m);
        m = new JMenuItem("Yon");
        m.addActionListener(al);
        popup.add(m);
        m = new JMenuItem("Afar");
        m.addActionListener(al);
        popup.add(m);
        popup.addSeparator();
        m = new JMenuItem("Stay here");
        m.addActionListener(al);
        popup.add(m);
        PopupListener pl = new PopupListener();
        addMouseListener(pl);  //在当前对象区域右击可以弹出
        t.addMouseListener(pl);  //在文本框区域右击可以弹出
    }

    class PopupListener extends MouseAdapter {
        @Override
        public void mousePressed(MouseEvent e) {
            // System.out.println("mouse pressed");
            maybeShowPopup(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // System.out.println("mouse released");
            maybeShowPopup(e);
        }

        private void maybeShowPopup(MouseEvent e){
            if(e.isPopupTrigger()){  //判断是否应该弹出  //mousePressed()中得到的结果貌似是false
                popup.show(e.getComponent(), e.getX(), e.getY());
            }
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new Popup(), 300, 200);
    }

}
