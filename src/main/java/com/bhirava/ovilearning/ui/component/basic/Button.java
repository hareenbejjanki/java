package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.Border;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.ui.event.OnFocusBorderChanger;
import com.bhirava.ovilearning.ui.event.OnHoverBackgroundChanger;

public class Button extends Panel {
    private static final long serialVersionUID = 1L;

    private Color fontColor;
    private Color borderColor;
    private int borderWidth;
    private Color backgroundColor;
    private Color backgroundHoverColor;
    private Font font;
    private Color borderFocusColor;
    private JButton button;

    public void addActionListener(ActionListener actionListener) {
        button.addActionListener(actionListener);
    }

    public Button(Panel parentComponent, String text, Font font, Color fontColor, Color borderColor, int borderWidth, Color borderFocusColor,
            Color backgroundColor, Rectangle bounds) {
        this(parentComponent, text, font, fontColor, borderColor, borderWidth, borderFocusColor, backgroundColor, null, bounds);
    }

    public Button(Panel parentComponent, String text, Font font, Color fontColor, Color borderColor, int borderWidth, Color borderFocusColor,
            Color backgroundColor, Color backgroundHoverColor, Rectangle bounds) {
        super(parentComponent, bounds);
        this.parentComponent = parentComponent;
        this.fontColor = fontColor;
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        this.backgroundColor = backgroundColor;
        this.backgroundHoverColor = backgroundHoverColor;
        this.borderFocusColor = borderFocusColor;
        this.font = font;
        init(bounds, text);
    }

    private void init(Rectangle bounds, String text) {
        setBackground(backgroundColor);

        button = new JButton();
        button.setText(text);
        button.setFont(font);
        button.setForeground(fontColor);
        button.setBounds(new Rectangle(0, 0, bounds.width, bounds.height));
        Border border = BorderFactory.createLineBorder(borderColor, borderWidth, true);
        button.setBorder(border);

        if (borderFocusColor != null) {
            Border focusBorder = BorderFactory.createLineBorder(borderFocusColor, borderWidth, true);
            button.addFocusListener(new OnFocusBorderChanger(button, border, focusBorder));
        }

        if (backgroundHoverColor != null) {
            addMouseListener(new OnHoverBackgroundChanger(this, backgroundColor, backgroundHoverColor));
        }

        addChild(ChildName.General.BUTTON.name(), button);
    }
}