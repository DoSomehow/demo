package org.ms.thinkInJava.gui;

import org.ms.thinkInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Faces extends JFrame {

    private static Icon[] faces;
    private JButton jb, jb2 = new JButton("Disable");
    private boolean mad = false;

    public Faces(){
        faces = new Icon[]{
                new ImageIcon(getClass().getResource("img/add.png")),
                new ImageIcon(getClass().getResource("img/minus.png")),
                new ImageIcon(getClass().getResource("img/multiply.png")),
                new ImageIcon(getClass().getResource("img/ok.png")),
                new ImageIcon(getClass().getResource("img/search.png"))
        };

        jb = new JButton("JButton", faces[3]);
        setLayout(new FlowLayout());
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(mad){
                    jb.setIcon(faces[3]);
                    mad = false;
                }else{
                    jb.setIcon(faces[0]);
                    mad = true;
                }
                jb.setVerticalAlignment(JButton.TOP);
                jb.setHorizontalAlignment(JButton.LEFT);
            }
        });

        jb.setRolloverEnabled(true);
        jb.setRolloverIcon(faces[1]);  //从按钮上经过时
        jb.setPressedIcon(faces[2]);  //按下按钮时
        jb.setDisabledIcon(faces[4]);  //按钮禁用时
        jb.setToolTipText("Yow!");  //提示
        add(jb);
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(jb.isEnabled()){
                    jb.setEnabled(false);
                    jb2.setText("Enable");
                }else{
                    jb.setEnabled(true);
                    jb2.setText("Disable");
                }
            }
        });
        add(jb2);

    }


    public static void main(String[] args) {
        SwingConsole.run(new Faces(), 250, 125);
    }

}
