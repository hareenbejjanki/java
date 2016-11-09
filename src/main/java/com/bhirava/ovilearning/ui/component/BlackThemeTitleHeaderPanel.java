package com.bhirava.ovilearning.ui.component;

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
        Properties generalProperties = mainPanel.getGeneralProperties();
        return generalProperties.getProperty(Constants.General.BLACK_THEAM_IMAGE_PATH);
    }

    private void init(String header1Text, String header2Text) {
        Properties uiStylesProperties = mainPanel.getUiStylesProperties();
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();

        Font header1Font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER1_FONT);
        Font header2Font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER2_FONT);

        Label header1 = new Label(this, header1Text, header1Font, PropertyUtil.getColor(
                uiStylesProperties, UIConstants.Styles.LOGIN_HEADER1_FONT_COLOR), UIConstants.Styles.TRANSPARENT_COLOR);
        header1.makeHorizantlyCenterPositioned(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_HEADER_LABEL1_Y));
        Label header2 = new Label(this, header2Text, PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.LOGIN_HEADER2_FONT), PropertyUtil.getColor(
                uiStylesProperties, UIConstants.Styles.LOGIN_HEADER2_FONT_COLOR), UIConstants.Styles.TRANSPARENT_COLOR);
        header2.makeHorizantlyCenterPositioned(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_HEADER_LABEL2_Y));

        addChild(ChildName.LoginPage.HeaderPanel.LABEL1.name(), header1);
        addChild(ChildName.LoginPage.HeaderPanel.LABEL2.name(), header2);
    }

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties positionProperties = mainPanel.getUiPositionProperties();

        return new Rectangle(0, 0, PropertyUtil.getInteger(positionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH), PropertyUtil.getInteger(
                positionProperties, UIConstants.Positions.LOGIN_HEADER_HEIGHT));
    }
}
