package com.bhirava.ovilearning;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TransparentPanels {
    public static void main(String[] args) {

        JPanel p = new JPanel();
        // setting layout to null so we can make panels overlap
        p.setLayout(null);

        JPanel topPanel = new JPanel();
        // drawing should be in blue
//        topPanel.setForeground(Color.blue);
        // background should be black, except it's not opaque, so
        // background will not be drawn
        topPanel.setBackground(new Color(0, 0, 0, 255));
        // set opaque to false - background not drawn
        topPanel.setOpaque(false);
        topPanel.setBounds(50, 50, 100, 100);
        // add topPanel - components paint in order added,
        // so add topPanel first
        p.add(topPanel);

        JPanel bottomPanel = new JPanel();
        // drawing in green
        bottomPanel.setForeground(Color.green);
        // background in cyan
        bottomPanel.setBackground(new Color(0, 0, 0, 100));
        // and it will show this time, because opaque is true
        bottomPanel.setOpaque(true);
        bottomPanel.setBounds(30, 30, 100, 100);
        // add bottomPanel last...
        p.add(bottomPanel);

        // frame handling code...
        JFrame f = new JFrame("Two Panels");
        f.setContentPane(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
