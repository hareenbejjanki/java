package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.event.OnHoverImageChanger;

public class OnHoverChangingImagePanel extends Panel {
    private static final long serialVersionUID = 1L;

    private Image image;
    private Image hoverImage;
    
    private Rectangle bounds;

    public Image getImage() {
        return image;
    }

    public Image getHoverImage() {
        return hoverImage;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public OnHoverChangingImagePanel(String name, String imagePath, String hoverImagePath, Rectangle bounds, Panel parentPanel, MainPanel mainPanel) {
        super(name, bounds, parentPanel, mainPanel);
        this.bounds = bounds;
        try {
            image = ImageIO.read(new File(System.getenv("OVILEARNING_HOME"), imagePath));
            hoverImage = ImageIO.read(new File(System.getenv("OVILEARNING_HOME"), hoverImagePath));
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            addMouseListener(new OnHoverImageChanger(this, image, hoverImage));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        setLayout(null);
    }

    @Override
    public void paint(Graphics g) {
        setBackground(UIConstants.Styles.TRANSPARENT_COLOR);
        super.paint(g);
        g.drawImage(image, 0, 0, bounds.width, bounds.height, this);
    }
}