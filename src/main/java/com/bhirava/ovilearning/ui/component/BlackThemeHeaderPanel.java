package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.ImagePanel;
import com.bhirava.ovilearning.ui.component.basic.VerticallyMovingPanel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class BlackThemeHeaderPanel extends VerticallyMovingPanel {
    private static final long serialVersionUID = 1L;

    private MainPanel mainPanel;

    public BlackThemeHeaderPanel(MainPanel mainPanel) {
        super(ChildName.General.HEADER.name(), getBounds(mainPanel), mainPanel.getScrollPane(), new Point(0, 0), getInitialColor(mainPanel),
                getScrollColor(mainPanel), mainPanel, mainPanel);
        this.mainPanel = mainPanel;
        init();
    }

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties positionProperties = mainPanel.getPropertyValues().getPositionProperties();

        return new Rectangle(0, 0, mainPanel.getWidth(), PropertyUtil.getInteger(positionProperties, UIConstants.Positions.BLACK_THEME_HEADER_HEIGHT));
    }

    private static Color getScrollColor(MainPanel mainPanel) {
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        return PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER_BG_COLOR);
    }

    private static Color getInitialColor(MainPanel mainPanel) {
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        return PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER_BG_INIT_COLOR);
    }

    private void init() {
        Properties textAndPathsProperties = mainPanel.getPropertyValues().getTextAndPathsProperties();
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        int logoX = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_HEADER_LOGO_X);
        int right = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_HEADER_MENU_RIGHT);
        int menuX = this.getSize().width - right;

        ImagePanel logo = new ImagePanel(ChildName.BlackTheme.HeaderPanel.LOGO.name(), textAndPathsProperties.getProperty(UIConstants.TextAndPaths.LOGO_PATH),
                getLogoBounds(), this, mainPanel);
        logo.makeVerticallyCenterPositioned(logoX);

        BlackThemeMenuPanel blackThemeMenuPanel = new BlackThemeMenuPanel(this, mainPanel);
        blackThemeMenuPanel.makeVerticallyCenterPositioned(menuX - blackThemeMenuPanel.getSize().width);

        addChild(logo);
        addChild(blackThemeMenuPanel);
    }

    private Rectangle getLogoBounds() {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();

        return new Rectangle(0, 0, PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_HEADER_LOGO_WIDTH), PropertyUtil.getInteger(
                uiPositionProperties, UIConstants.Positions.BLACK_THEME_HEADER_LOGO_HEIGHT));
    }
}
