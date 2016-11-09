package com.bhirava.ovilearning.ui.component.videolist;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class VideoListTopicsPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public VideoListTopicsPanel(Panel parentPanel, MainPanel mainPanel) {
        super(ChildName.VideoListPage.MainPanel.TOPICS_PANEL.name(), getBounds(mainPanel), parentPanel, mainPanel);
        init();
    }

    private void init() {
        Properties uiStylesProperties = mainPanel.getUiStylesProperties();
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        Properties generalProperties = mainPanel.getGeneralProperties();

        setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_MAIN_BG_COLOR));

        Panel headerPanel = new Panel(ChildName.VideoListPage.MainPanel.TOPICS_HEADING_PANEL.name(), getTopicsHeaderBounds(uiPositionProperties), this, mainPanel);
        headerPanel.setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_BG_COLOR));
        Label topicsLabel = getTopicsLabel(headerPanel, uiPositionProperties, uiStylesProperties, generalProperties);
        headerPanel.addChild(ChildName.General.LABEL.name(), topicsLabel);
        addChild(headerPanel);

        initTopics();
    }

    private void initTopics() {
        TopicPanel topicPanel1 = new TopicPanel(1, this, mainPanel);
        TopicPanel topicPanel2 = new TopicPanel(2, this, mainPanel);
        TopicPanel topicPanel3 = new TopicPanel(3, this, mainPanel);
        TopicPanel topicPanel4 = new TopicPanel(4, this, mainPanel);
        addChild(topicPanel1);
        addChild(topicPanel2);
        addChild(topicPanel3);
        addChild(topicPanel4);
    }

    private Label getTopicsLabel(Panel headerPanel, Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_TOPICS);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_HEADER_X);

        Label label = new Label(headerPanel, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.makeVerticallyCenterPositioned(x);

        return label;
    }

    private static Rectangle getTopicsHeaderBounds(Properties uiPositionProperties) {
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_HEADER_HEIGHT);

        return new Rectangle(0, 0, width, height);
    }

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();

        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_Y);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_HEIGHT);

        return new Rectangle(x, y, width, height);
    }

}
