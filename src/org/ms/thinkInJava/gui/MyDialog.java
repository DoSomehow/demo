package org.ms.thinkInJava.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDialog extends JDialog {

    public MyDialog(JFrame parent){
        super(parent, "My dialog", true);
        setLayout(new FlowLayout());
        add(new Label("Here is my dialog"));
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();  //Closes the dialog
            }
        });
        add(ok);
        setSize(150, 225);
    }

}
