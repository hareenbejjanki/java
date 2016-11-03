package com.bhirava.ovilearning.ui.event;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class OnFocusColorChanger implements FocusListener {

    private Component component;
    private Color backgroundColor;
    private Color focusColor;

    public OnFocusColorChanger(Component component, Color backgroundColor, Color focusColor) {
        this.component = component;
        this.backgroundColor = backgroundColor;
        this.focusColor = focusColor;
    }

    public void focusLost(FocusEvent e) {
        component.setBackground(backgroundColor);
    }

    public void focusGained(FocusEvent e) {
        component.setBackground(focusColor);
    }
}
