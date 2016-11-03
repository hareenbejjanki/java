package com.bhirava.ovilearning.ui.event;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OnHoverColorChanger implements MouseListener {

    private Component component;
    private Color foregroundColor;
    private Color hoverColor;

    public OnHoverColorChanger(Component component, Color foregroundColor, Color hoverColor) {
        this.component = component;
        this.foregroundColor = foregroundColor;
        this.hoverColor = hoverColor;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        component.setForeground(hoverColor);
    }

    public void mouseExited(MouseEvent e) {
        component.setForeground(foregroundColor);
    }
}
