package org.ms.thinkInJava.gui;

import org.ms.thinkInJava.util.SwingConsole;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class Borders extends JFrame {

    static JPanel showBorder(Border b){
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        String nm = b.getClass().toString();
        nm = nm.substring(nm.lastIndexOf(".") + 1);
        jp.add(new JLabel(nm, JLabel.CENTER), BorderLayout.CENTER);
        jp.setBorder(b);
        return jp;
    }

    public Borders(){
        setLayout(new GridLayout(2,4));
        add(showBorder(new TitledBorder("Title")));
        add(showBorder(new EtchedBorder()));  // etched: adj. 被侵蚀的；风化的
        add(showBorder(new LineBorder(Color.BLUE)));
        add(showBorder(new MatteBorder(5, 5, 30, 30, Color.GREEN)));  //matte: adj. 无光泽的；不光滑的
        add(showBorder(new BevelBorder(BevelBorder.RAISED)));  //bevel: adj. 成斜面的
        add(showBorder(new SoftBevelBorder(BevelBorder.LOWERED)));
        add(showBorder(new CompoundBorder(new EtchedBorder(), new LineBorder(Color.RED))));  //compound: adj. 复合的；混合的
    }

    public static void main(String[] args) {
        SwingConsole.run(new Borders(), 500, 300);
    }

}
