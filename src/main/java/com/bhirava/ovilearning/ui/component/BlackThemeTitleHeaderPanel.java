package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.ImageBackgroundPanel;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class BlackThemeTitleHeaderPanel extends ImageBackgroundPanel {
    private static final long serialVersionUID = 1L;

    public BlackThemeTitleHeaderPanel(String header1Text, String header2Text, Panel parentPanel, MainPanel mainPanel) {
        super("", getImagePath(mainPanel), getBounds(mainPanel), parentPanel, mainPanel);
        init(header1Text, header2Text);
    }

    private static String getImagePath(MainPanel mainPanel) {
        Properties generalProperties = mainPanel.getPropertyValues().getGeneralProperties();
        return generalProperties.getProperty(Constants.General.BLACK_THEME_IMAGE_PATH);
    }

    private void init(String header1Text, String header2Text) {
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();

        Font header1Font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER1_FONT);
        Font header2Font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER2_FONT);
        Color header1Color = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER1_FONT_COLOR);
        Color header2Color = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER2_FONT_COLOR);

        Label header1 = new Label(header1Text, header1Font, header1Color, UIConstants.Styles.TRANSPARENT_COLOR, this);
        Label header2 = new Label(header2Text, header2Font, header2Color, UIConstants.Styles.TRANSPARENT_COLOR, this);

        header1.makeHorizantlyCenterPositioned(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_HEADER_LABEL1_Y));
        header2.makeHorizantlyCenterPositioned(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_HEADER_LABEL2_Y));

        addChild(ChildName.BlackTheme.TitleHeaderPanel.LABEL1.name(), header1);
        addChild(ChildName.BlackTheme.TitleHeaderPanel.LABEL2.name(), header2);
    }

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties positionProperties = mainPanel.getPropertyValues().getPositionProperties();

        return new Rectangle(0, 0, PropertyUtil.getInteger(positionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH), PropertyUtil.getInteger(
                positionProperties, UIConstants.Positions.BLACK_THEME_HEADER_HEIGHT));
    }
}
