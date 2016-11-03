package com.bhirava.ovilearning.ui.event;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class OnFocusBackgroundChanger implements FocusListener {

    private Component component;
    private Color normalColor;
    private Color focusColor;

    public OnFocusBackgroundChanger(Component component, Color normalColor, Color focusColor) {
        this.component = component;
        this.normalColor = normalColor;
        this.focusColor = focusColor;
    }

    public void focusLost(FocusEvent e) {
        component.setBackground(normalColor);
    }

    public void focusGained(FocusEvent e) {
        component.setBackground(focusColor);
    }
}
