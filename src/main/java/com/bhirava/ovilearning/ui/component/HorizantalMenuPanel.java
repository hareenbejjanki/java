package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;

import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;

public class HorizantalMenuPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public HorizantalMenuPanel(String name, Rectangle bounds, Color background, List<String> menu, Font menuFont, Color menuColor, Color menuHoverColor, int margin, Panel parentPanel, MainPanel mainPanel) {
        super(name, bounds, parentPanel, mainPanel);
        init(background, menu, menuFont, menuColor, menuHoverColor, margin);
    }

    private void init(Color background, List<String> menu, Font menuFont, Color menuColor, Color menuHoverColor, int margin) {
        int x = 0;

        for (String menuItem : menu) {
            Label menuItemLabel = new Label(menuItem, menuFont, menuColor, UIConstants.Styles.TRANSPARENT_COLOR, menuHoverColor, this);
            menuItemLabel.makeVerticallyCenterPositioned(x);
            addChild(menuItem, menuItemLabel);
            x += menuItemLabel.getSize().width + margin;
        }

        setBackground(background);
        setSize(x - margin, getBounds().height);
    }
}