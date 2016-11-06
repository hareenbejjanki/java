package com.bhirava.ovilearning;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class S {
    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Test");
        JLayeredPane layeredPane = new JLayeredPane();
        JPanel jPanel = new JPanel() {
            BufferedImage image = ImageIO.read(new URL("https://www.gravatar.com/avatar/660f20665a9e1e7077b885654fd91863?s=32&d=identicon&r=PG&f=1"));

            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, 300, 300, this);
            }
        };

        frame.setLayout(null);
        layeredPane.setBounds(0, 0, 300, 300);
        jPanel.setBounds(0, 0, 300, 300);
        layeredPane.add(jPanel, new Integer(0));
        JButton jButton = new JButton("Test Button");
        jButton.setBounds(30, 30, 100, 30);
        layeredPane.add(jButton, new Integer(1));
        frame.add(layeredPane);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
