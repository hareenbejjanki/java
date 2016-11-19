package com.bhirava.ovilearning.ui.event;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.bhirava.ovilearning.ui.component.basic.OnHoverChangingImagePanel;

public class OnHoverImageChanger implements MouseListener {

    private OnHoverChangingImagePanel onHoverChangingImagePanel;
    private Image image;
    private Image hoverImage;

    public OnHoverImageChanger(OnHoverChangingImagePanel onHoverChangingImagePanel, Image image, Image hoverImage) {
        this.onHoverChangingImagePanel = onHoverChangingImagePanel;
        this.image = image;
        this.hoverImage = hoverImage;
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        onHoverChangingImagePanel.setImage(hoverImage);
        onHoverChangingImagePanel.repaint();
    }

    public void mouseExited(MouseEvent e) {
        onHoverChangingImagePanel.setImage(image);
        onHoverChangingImagePanel.repaint();
    }
}
