package org.ms.thinkInJava.gui;

import org.ms.thinkInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FileChooserTest extends JFrame {

    private JTextField fileName = new JTextField();
    private JTextField dir = new JTextField();
    private JButton open = new JButton("Open");
    private JButton save = new JButton("Save");

    public FileChooserTest(){
        JPanel p = new JPanel();
        open.addActionListener(new OpenL());
        p.add(open);
        save.addActionListener(new SaveL());
        p.add(save);
        add(p, BorderLayout.SOUTH);
        dir.setEditable(false);
        fileName.setEditable(false);
        p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.add(fileName);
        p.add(dir);
        add(p, BorderLayout. NORTH);
    }

    class OpenL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser();
            //Demonstrate "Open" dialog:
            int rVal = c.showOpenDialog(FileChooserTest.this);  //这个和下边那个showSaveDialog的区别是什么？
            if(rVal ==JFileChooser.APPROVE_OPTION) {
                fileName.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
            }
        }
    }
    class SaveL implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser();
            //Demonstrate "Save" dialog:
            int rVal = c.showSaveDialog(FileChooserTest.this);
            if(rVal == JFileChooser.APPROVE_OPTION){
                fileName.setText(c.getSelectedFile().getName());
                dir.setText(c.getCurrentDirectory().toString());
            }
            if(rVal == JFileChooser.CANCEL_OPTION){
                fileName.setText("You pressed cancel");
                dir.setText("");
            }
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new FileChooserTest(), 250, 150);
    }

}
