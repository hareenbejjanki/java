package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.bhirava.ovilearning.constants.UIConstants;

public class ImagePanel extends Panel {
    private static final long serialVersionUID = 1L;

    private Image image;
    private Rectangle bounds;

    public Image getImage() {
        return image;
    }

    public ImagePanel(Panel parentComponent, String imagePath, Rectangle bounds) {
        super(parentComponent, bounds);
        this.bounds = bounds;
        try {
            this.image = ImageIO.read(new File(System.getenv("OVILEARNING_HOME"), imagePath));
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