package org.ms.thinkInJava.util;

import javax.swing.*;
import java.awt.*;

public class SwingConsole {
    public static void run(final JFrame f, final int width, final int height){
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                f.setTitle(f.getClass().getSimpleName());
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(width, height);

                //屏幕居中
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                Dimension frameSize = f.getSize();
                if (frameSize.height > screenSize.height){
                    frameSize.height = screenSize.height;
                }
                if (frameSize.width > screenSize.width){
                    frameSize.width = screenSize.width;
                }
                f.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

                f.setVisible(true);
            }
        });
    }
}
