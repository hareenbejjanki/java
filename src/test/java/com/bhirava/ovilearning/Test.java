package com.bhirava.ovilearning;

import java.awt.Dimension;
import java.awt.Rectangle;

import javax.swing.JFrame;

import com.bhirava.ovilearning.ui.component.basic.ImageBackgroundPanel;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        ImageBackgroundPanel panel = new ImageBackgroundPanel("test", "images/welcome_page_sample.gif", new Rectangle(0, 0, 200, 200), null, null);
        frame.add(panel);
        frame.setSize(new Dimension(200, 200));
        frame.setVisible(true);
    }
}
