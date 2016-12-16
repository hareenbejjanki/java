package com.bhirava.ovilearning.ui.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.bhirava.ovilearning.ui.component.basic.Panel;

public class OnClickFocus implements MouseListener {

    private Panel panel;

    public OnClickFocus(Panel panel2) {
        this.panel = panel2;
    }

    public void mouseClicked(MouseEvent e) {
        panel.requestFocus();
        panel.getMainPanel().repaint();
    }

    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

}
