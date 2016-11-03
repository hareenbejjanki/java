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

    public VideoListTopicsPanel(Panel parentComponent) {
        super(parentComponent, getBounds(parentComponent));
        init();
    }

    private void init() {
        MainPanel mainPanel = (MainPanel) parentComponent.getParentComponent().getParentComponent();
        Properties uiStylesProperties = mainPanel.getUiStylesProperties();
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        Properties generalProperties = mainPanel.getGeneralProperties();

        setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_MAIN_BG_COLOR));

        Panel headerPanel = new Panel(this, getTopicsHeaderBounds(uiPositionProperties));
        headerPanel.setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_BG_COLOR));
        Label topicsLabel = getTopicsLabel(headerPanel, uiPositionProperties, uiStylesProperties, generalProperties);
        headerPanel.addChild(ChildName.General.LABEL.name(), topicsLabel);
        addChild(ChildName.VideoListPage.MainPanel.TOPICS_HEADING_PANEL.name(), headerPanel);

        initTopics();
    }

    private void initTopics() {
        TopicPanel topicPanel1 = new TopicPanel(this, 1);
        TopicPanel topicPanel2 = new TopicPanel(this, 2);
        TopicPanel topicPanel3 = new TopicPanel(this, 3);
        TopicPanel topicPanel4 = new TopicPanel(this, 4);
        addChild(ChildName.VideoListPage.MainPanel.TOPICS_PANEL.name() + 1, topicPanel1);
        addChild(ChildName.VideoListPage.MainPanel.TOPICS_PANEL.name() + 2, topicPanel2);
        addChild(ChildName.VideoListPage.MainPanel.TOPICS_PANEL.name() + 3, topicPanel3);
        addChild(ChildName.VideoListPage.MainPanel.TOPICS_PANEL.name() + 4, topicPanel4);
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

    private static Rectangle getBounds(Panel parentComponent) {
        MainPanel mainPanel = (MainPanel) parentComponent.getParentComponent().getParentComponent();
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();

        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_Y);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_HEIGHT);

        return new Rectangle(x, y, width, height);
    }

}
