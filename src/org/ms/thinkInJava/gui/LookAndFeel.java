package org.ms.thinkInJava.gui;

import org.ms.thinkInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;

public class LookAndFeel extends JFrame {

    private String[] choices = "Eeny Meeny Minnie Mickey Moe Larry Curly".split(" ");
    private Component[] samples = {
            new JButton("JButton"),
            new JTextField("JTextField"),
            new JLabel("JLabel"),
            new JCheckBox("JCheckBox"),
            new JRadioButton("JRadioButton"),
            new JComboBox(choices),
            new JList(choices)
    };

    public LookAndFeel(){
        super("Look And Feel");
        setLayout(new FlowLayout());
        for(Component component : samples){
            add(component);
        }
    }

    private static void usageError(){
        System.out.println("Usage:LookAndFeel [cross|system|motif]");
        System.exit(1);
    }

    public static void main(String[] args) {
        if(args.length ==0){
            usageError();
        }
        if(args[0].equals("cross")){
            try{
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(args[0].equals("system")) {
            try{
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }else if(args[0].equals("motif")) {
            try{
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            usageError();
        }

        //Note the look & feel must be set before any components are created.
        SwingConsole.run(new LookAndFeel(), 300, 300);

        //菜单栏那儿，编译按钮后边，那个展示当前编译的类的下拉框，点一下，第一个选项“Edit configurations”即可以设置main函数的入参
    }

}
