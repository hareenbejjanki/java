package com.bhirava.ovilearning.ui.event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;

public class OnHoverImageChanger implements MouseListener {

    private JLabel label;
    private Icon backgroundIcon;
    private Icon hoverIcon;

    public OnHoverImageChanger(JLabel label, Icon backgroundIcon, Icon hoverIcon) {
        this.label = label;
        this.backgroundIcon = backgroundIcon;
        this.hoverIcon = hoverIcon;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        label.setIcon(hoverIcon);
    }

    public void mouseExited(MouseEvent e) {
        label.setIcon(backgroundIcon);
    }
}
