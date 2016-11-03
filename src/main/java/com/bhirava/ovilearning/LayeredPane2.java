package com.bhirava.ovilearning;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class LayeredPane2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(10, 10, 200, 200);
        layeredPane.setBackground(Color.BLACK);
        layeredPane.setLayout(null);
        JLayeredPane layeredPane_1 = new JLayeredPane();
        layeredPane_1.setBounds(10, 10, 100, 100);
        layeredPane_1.setBackground(Color.BLUE);
        layeredPane_1.setLayout(null);
        JLayeredPane layeredPane_2 = new JLayeredPane();
        layeredPane_2.setBounds(60, 60, 100, 100);
        layeredPane_2.setBackground(Color.CYAN);
        layeredPane_2.setLayout(null);

        layeredPane.add(layeredPane_1);
        layeredPane.add(layeredPane_2);

        JLayeredPane layeredPane1 = new JLayeredPane();
        layeredPane1.setBounds(110, 110, 200, 200);
        layeredPane1.setBackground(Color.DARK_GRAY);
        layeredPane1.setLayout(null);
        JLayeredPane layeredPane1_1 = new JLayeredPane();
        layeredPane1_1.setBounds(10, 10, 100, 100);
        layeredPane1_1.setBackground(Color.GREEN);
        layeredPane1_1.setLayout(null);
        JLayeredPane layeredPane1_2 = new JLayeredPane();
        layeredPane1_2.setBounds(60, 60, 100, 100);
        layeredPane1_2.setBackground(Color.MAGENTA);
        layeredPane1_2.setLayout(null);
        layeredPane1.add(layeredPane1_1);
        layeredPane1.add(layeredPane1_2);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.add(layeredPane);
        frame.add(layeredPane1);

        frame.setVisible(true);

    }

}
