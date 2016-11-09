package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

import com.bhirava.ovilearning.ui.event.OnHoverColorChanger;

public class Label extends JLabel {
    private static final long serialVersionUID = 1L;
    private Panel parentPanel;

    public Label(Panel parentPanel, String text, Font font, Color foreground, Color background) {
        this(parentPanel, text, font, foreground, background, null);
    }

    public Label(Panel parentPanel, String text, Font font, Color foreground, Color background, Color onHoverColor) {
        super(text);
        this.parentPanel = parentPanel;
        setFont(font);
        setForeground(foreground);
        setBackground(background);
        Dimension size = getPreferredSize();
        setSize(size.width, size.height);
        if (onHoverColor != null) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            addMouseListener(new OnHoverColorChanger(this, foreground, onHoverColor));
        }
    }

    public void makeHorizantlyCenterPositioned(int y) {
        Dimension size = getPreferredSize();
        int x = (int) parentPanel.getWidth() / 2 - size.width / 2;
        setBounds(x, y, size.width, size.height);
    }

    public void makeVerticallyCenterPositioned(int x) {
        Dimension size = getPreferredSize();
        int y = (int) parentPanel.getHeight() / 2 - size.height / 2;
        setBounds(x, y, size.width, size.height);
    }

    public void makeCenterPositioned() {
        Dimension size = getPreferredSize();
        int x = (int) parentPanel.getWidth() / 2 - size.width / 2;
        int y = (int) parentPanel.getHeight() / 2 - size.height / 2;
        setBounds(x, y, size.width, size.height);
    }
}
