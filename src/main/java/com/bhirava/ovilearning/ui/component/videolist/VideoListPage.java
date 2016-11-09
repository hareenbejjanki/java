package com.bhirava.ovilearning.ui.component.videolist;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.PageName;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class VideoListPage extends Panel {
    private static final long serialVersionUID = 1L;

    public VideoListPage(MainPanel mainPanel) {
        super(PageName.VIDEO_LIST_PAGE.name(), getBounds(mainPanel), mainPanel, mainPanel);
        init();
    }

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties positionProperties = mainPanel.getUiPositionProperties();

        return new Rectangle(0, 0, PropertyUtil.getInteger(positionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH), getHeight(positionProperties));
    }

    private static int getHeight(Properties positionProperties) {
        return PropertyUtil.getInteger(positionProperties, UIConstants.Positions.LOGIN_HEADER_HEIGHT)
                + PropertyUtil.getInteger(positionProperties, UIConstants.Positions.VIDEOLIST_NAVIGATION_HEIGHT)
                + PropertyUtil.getInteger(positionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_HEIGHT);
    }

    private void init() {
        addPanels();
        initStyles();
    }

    private void addPanels() {
        addChild(getHeaderPanel());
        addChild(getNavigationPanel());
        addChild(getVideoMainPanel());
    }

    private Panel getNavigationPanel() {
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        Properties uiStylesProperties = mainPanel.getUiStylesProperties();
        Properties generalProperties = mainPanel.getGeneralProperties();

        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_HEADER_HEIGHT);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_NAVIGATION_HEIGHT);
        
        Rectangle bounds = new Rectangle(0, y, width, height);
        Panel panel = new Panel(ChildName.VideoListPage.Child.NAVIGATION_PANEL.name(), bounds, this, mainPanel);
        panel.setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_NAVIGATION_BG_COLOR));

        Label navigationLabel = getNavigationLabel(panel, uiPositionProperties, uiStylesProperties, generalProperties);
        panel.addChild(ChildName.General.LABEL.name(), navigationLabel);

        return panel;
    }

    private Label getNavigationLabel(Panel panel, Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_NAVIGATION_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_NAVIGATION_LABEL_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_NAVIGATION_LABEL_TEXT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_NAVIGATION_LABEL_X);

        Label label = new Label(panel, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.makeVerticallyCenterPositioned(x);

        return label;
    }

    private Panel getVideoMainPanel() {
        return new VideoListPanel(this, mainPanel);
    }

    private Panel getHeaderPanel() {
        return new VideoListHeaderPanel(this, mainPanel);
    }

    private void initStyles() {
        setBackground(UIConstants.Styles.DEFAULT_COLOR);
    }
}
