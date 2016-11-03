package com.bhirava.ovilearning.ui.event;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.border.Border;

public class OnFocusBorderChanger implements FocusListener {

    private JButton button;
    private Border normalBorder;
    private Border focusBorder;

    public OnFocusBorderChanger(JButton button, Border normalBorder, Border focusBorder) {
        this.button = button;
        this.normalBorder = normalBorder;
        this.focusBorder = focusBorder;
    }

    public void focusLost(FocusEvent e) {
        button.setBorder(normalBorder);
    }

    public void focusGained(FocusEvent e) {
        button.setBorder(focusBorder);
    }
}
