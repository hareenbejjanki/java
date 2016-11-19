package com.bhirava.ovilearning;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JFrame;

import com.bhirava.ovilearning.ui.component.basic.OnHoverChangingImageWithLabelPanel;

public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        OnHoverChangingImageWithLabelPanel panel = new OnHoverChangingImageWithLabelPanel("test", "text", new Font("Sanserif", Font.BOLD, 36), Color.WHITE, Color.RED, Color.CYAN, 10, "images/welcome_page_sample.gif", "images/logo_2x.png", true, new Rectangle(0, 0, 200, 200), null, null);
//        OnHoverChangingImagePanel panel = new OnHoverChangingImagePanel("test", "images/welcome_page_sample.gif", "images/logo_2x.png", new Rectangle(0, 0, 200, 200), null, null);
//        ImageBackgroundPanel panel = new ImageBackgroundPanel("test", "images/welcome_page_sample.gif", new Rectangle(0, 0, 200, 200), null, null);
        frame.add(panel);
        frame.setSize(new Dimension(200, 200));
        frame.setVisible(true);
    }
}
