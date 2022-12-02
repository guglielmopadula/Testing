package org.dssc;

import javax.swing.*;
import java.awt.Graphics;

public class Main {

    public static void main(String[] args) {
        JFrame f = new JFrame();
        Screen screen = new Screen(20);
        for(int j=0; j<32;j++){
            screen.DrawPixel(30,j);
        }
        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(screen.snapshot(), 0, 0, this);
            }
        };
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.pack();
        f.setVisible(true);

    }


}
