package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.UIConstants;

public class VerticalTextMenuPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public VerticalTextMenuPanel(Panel parentComponent, Color background, String heading, Font headingFont, Color headingColor, List<String> menu, Font menuFont, Color menuColor, Color menuHoverColor, int margin, Rectangle bounds) {
        super(parentComponent, bounds);
        init(background, heading, headingFont, headingColor, menu, menuFont, menuColor, menuHoverColor, margin);
    }

    private void init(Color background, String heading, Font headingFont, Color headingColor, List<String> menu, Font menuFont, Color menuColor, Color menuHoverColor, int margin) {
        Label headingLabel = new Label(this, heading, headingFont, headingColor, UIConstants.Styles.TRANSPARENT_COLOR);
        headingLabel.setLocation(0, 0);
        int y = headingLabel.getSize().height + margin;
        Panel line = new Panel(this, new Rectangle(0, y, getBounds().width, 1));
        y += margin;

        addChild(ChildName.General.HEADING.name(), headingLabel);
        addChild(ChildName.General.SPLIT.name(), line);
        for (String menuItem : menu) {
            Label menuItemLabel = new Label(this, menuItem, menuFont, menuColor, UIConstants.Styles.TRANSPARENT_COLOR, menuHoverColor);
            menuItemLabel.setLocation(0, y);
            addChild(menuItem, menuItemLabel);
            y += menuItemLabel.getSize().height + margin;
        }

        setBackground(background);
        setBounds(getBounds().x, getBounds().y, getBounds().width, y + margin);
    }
}
