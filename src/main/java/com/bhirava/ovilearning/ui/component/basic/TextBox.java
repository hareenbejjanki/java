package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.bhirava.ovilearning.ui.event.OnFocusColorChanger;

public class TextBox extends JTextField {
    private static final long serialVersionUID = 1L;

    protected Panel parentPanel;
    private Color fontColor;
    private Color borderColor;
    private int borderWidth;
    private Color backgroundColor;
    private Font font;
    private Color focusColor;
    private String waterMark;

    public Component getParentPanel() {
        return parentPanel;
    }

    public TextBox(Panel parentPanel, Font font, Color fontColor, Color borderColor, int borderWidth, Color backgroundColor, Color focusColor, Rectangle bounds) {
        this(parentPanel, font, fontColor, borderColor, borderWidth, backgroundColor, focusColor, "", bounds);
    }

    public TextBox(Panel parentPanel, Font font, Color fontColor, Color borderColor, int borderWidth, Color backgroundColor, Color focusColor, String waterMark, Rectangle bounds) {
        this.parentPanel = parentPanel;
        this.fontColor = fontColor;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        this.backgroundColor = backgroundColor;
        this.focusColor = focusColor;
        this.font = font;
        this.waterMark = waterMark;
        init(bounds);
    }

    private void init(Rectangle bounds) {
        setBounds(bounds);
        Border border = BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(borderColor, borderWidth), new EmptyBorder(0, new Canvas().getFontMetrics(font).charWidth(' ') - 1, 0, 0));
        setBorder(border);
        setBackground(backgroundColor);
        setFont(font);
        setForeground(fontColor);
        setCaretColor(fontColor);
        addFocusListener(new OnFocusColorChanger(this, backgroundColor, focusColor));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (getText() == null || getText().isEmpty()) {
            g.setFont(font);
            g.drawString(waterMark, g.getFontMetrics().charWidth(' '), getSize().height / 2 + g.getFontMetrics().getHeight() / 4 + 1);
        }
    }
}