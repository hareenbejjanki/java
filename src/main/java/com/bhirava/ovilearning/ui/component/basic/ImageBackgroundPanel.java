package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Rectangle;

import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.MainPanel;

public class ImageBackgroundPanel extends LayeredPanel {
    private static final long serialVersionUID = 1L;

    public ImageBackgroundPanel(String name, String imagePath, Rectangle bounds, Panel parentComponent, MainPanel mainPanel) {
        super(name, bounds, parentComponent, mainPanel);
        layeredPane.setBackground(UIConstants.Styles.TRANSPARENT_COLOR);
        setBackground(UIConstants.Styles.TRANSPARENT_COLOR);
        addChild(Constants.General.BACKGROUND, new ImagePanel(Constants.General.BACKGROUND, imagePath, bounds, this, mainPanel));
    }

}
