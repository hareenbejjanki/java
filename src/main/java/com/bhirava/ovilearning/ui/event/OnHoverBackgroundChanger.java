package com.bhirava.ovilearning.ui.event;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OnHoverBackgroundChanger implements MouseListener {

    private Component component;
    private Color backgroundColor;
    private Color hoverColor;

    public OnHoverBackgroundChanger(Component component, Color backgroundColor, Color hoverColor) {
        this.component = component;
        this.backgroundColor = backgroundColor;
        this.hoverColor = hoverColor;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        component.setBackground(hoverColor);
    }

    public void mouseExited(MouseEvent e) {
        component.setBackground(backgroundColor);
    }
}
