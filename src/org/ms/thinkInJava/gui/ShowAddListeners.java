package org.ms.thinkInJava.gui;

import org.ms.thinkInJava.util.SwingConsole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowAddListeners extends JFrame {

    private JTextField name = new JTextField(25);
    private JTextArea results = new JTextArea(40, 65);
    private static Pattern addListener = Pattern.compile("(add\\w+?Listener\\(.*?\\))");
    private static Pattern qualifier = Pattern.compile("\\w+\\.");

    public ShowAddListeners(){
        NameListener nameListener = new NameListener();
        name.addActionListener(nameListener);
        JPanel top = new JPanel();
        top.add(new JLabel("Swing calss name (press Enter):"));
        top.add(name);
        add(BorderLayout.NORTH, top);
        add(new JScrollPane(results));

        //Initial data and test:
        name.setText("JTextArea");
        nameListener.actionPerformed(new ActionEvent("", 0, ""));
    }

    class NameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nm = name.getText().trim();
            if(nm.length() == 0){
                results.setText("No match");
                return;
            }
            Class<?> kind;
            try{
                kind = Class.forName("javax.swing." + nm);
            }catch (ClassNotFoundException ex){
                results.setText("No match");
                return;
            }
            Method[] methods = kind.getMethods();
            results.setText("");
            for(Method m : methods){
                Matcher matcher = addListener.matcher(m.toString());
                if(matcher.find()){
                    results.append(qualifier.matcher(matcher.group(1)).replaceAll("") + "\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingConsole.run(new ShowAddListeners(), 500, 400);
    }

}
