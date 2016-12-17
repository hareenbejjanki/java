package com.bhirava.ovilearning.ui.event;

import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Map.Entry;

import com.bhirava.ovilearning.ui.component.basic.Panel;

public class MainPanelRepainter implements MouseMotionListener, FocusListener {

    private Panel panel;

    public MainPanelRepainter(Panel panel) {
        this.panel = panel;
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
//        repaint();
    }

    public void focusGained(FocusEvent e) {
        repaint();
    }

    public void focusLost(FocusEvent e) {
        repaint();
    }

    private void repaint() {
        panel.repaint();
        panel.getMainPanel().repaint();

        for (Entry<String, Component> componentEntry : panel.getChildComponents().entrySet()) {
            System.out.println("Repainting: " + componentEntry.getKey());
            componentEntry.getValue().repaint();
        }

        System.out.println("\n\n\n");
    }

}
