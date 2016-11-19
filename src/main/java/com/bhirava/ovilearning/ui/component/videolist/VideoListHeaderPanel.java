package com.bhirava.ovilearning.ui.component.videolist;

import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.ImageBackgroundPanel;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class VideoListHeaderPanel extends ImageBackgroundPanel {
    private static final long serialVersionUID = 1L;

    public VideoListHeaderPanel(Panel parentPanel, MainPanel mainPanel) {
        super(ChildName.VideoListPage.Child.HEADER_PANEL.name(), getImagePath(mainPanel), getBounds(mainPanel), parentPanel, mainPanel);
        init();
    }

    private static String getImagePath(MainPanel mainPanel) {
        Properties generalProperties = mainPanel.getPropertyValues().getGeneralProperties();
        return generalProperties.getProperty(Constants.General.LOGIN_HEADER_IMAGE_PATH);
    }

    private void init() {
        Properties uiOtherProperties = mainPanel.getPropertyValues().getOtherProperties();
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();

        Label header1 = new Label(uiOtherProperties.getProperty(UIConstants.Other.VIDEOLIST_HEADER1_TEXT), PropertyUtil.getFont(uiStylesProperties,
                UIConstants.Styles.LOGIN_HEADER1_FONT), PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_HEADER1_FONT_COLOR),
                UIConstants.Styles.TRANSPARENT_COLOR, this);
        header1.makeHorizantlyCenterPositioned(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_HEADER_LABEL1_Y));
        Label header2 = new Label(uiOtherProperties.getProperty(UIConstants.Other.VIDEOLIST_HEADER2_TEXT), PropertyUtil.getFont(uiStylesProperties,
                UIConstants.Styles.LOGIN_HEADER2_FONT), PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_HEADER2_FONT_COLOR),
                UIConstants.Styles.TRANSPARENT_COLOR, this);
        header2.makeHorizantlyCenterPositioned(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_HEADER_LABEL2_Y));

        addChild(ChildName.LoginPage.HeaderPanel.LABEL1.name(), header1);
        addChild(ChildName.LoginPage.HeaderPanel.LABEL2.name(), header2);
    }

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties positionProperties = mainPanel.getPropertyValues().getPositionProperties();

        return new Rectangle(0, 0, PropertyUtil.getInteger(positionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH), PropertyUtil.getInteger(
                positionProperties, UIConstants.Positions.LOGIN_HEADER_HEIGHT));
    }
}
