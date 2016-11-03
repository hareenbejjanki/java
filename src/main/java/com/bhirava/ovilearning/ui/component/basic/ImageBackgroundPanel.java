package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Rectangle;

import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;

public class ImageBackgroundPanel extends LayeredPanel {
    private static final long serialVersionUID = 1L;

    public ImageBackgroundPanel(Panel parentComponent, String imagePath, Rectangle bounds) {
        super(parentComponent, bounds);
        layeredPane.setBackground(UIConstants.Styles.TRANSPARENT_COLOR);
        setBackground(UIConstants.Styles.TRANSPARENT_COLOR);
        addChild(Constants.General.BACKGROUND, new ImagePanel(this, imagePath, bounds));
    }

}
