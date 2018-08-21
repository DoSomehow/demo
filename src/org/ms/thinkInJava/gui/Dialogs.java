package org.ms.thinkInJava.gui;

import org.ms.thinkInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialogs extends JFrame {

    private JButton b1 = new JButton("Dialog Box");
    private MyDialog dlg = new MyDialog(null);

    public Dialogs(){
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlg.setVisible(true);
            }
        });
        add(b1);
    }

    public static void main(String[] args) {
        SwingConsole.run(new Dialogs(), 125, 75);
    }

}
