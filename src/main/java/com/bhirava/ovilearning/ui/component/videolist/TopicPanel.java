package com.bhirava.ovilearning.ui.component.videolist;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.component.basic.Button;
import com.bhirava.ovilearning.ui.component.basic.ImagePanel;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.event.VideoPageNavigator;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class TopicPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public TopicPanel(int count, Panel parentPanel, MainPanel mainPanel) {
        super(ChildName.VideoListPage.MainPanel.TOPICS_PANEL.name() + count, getBounds(mainPanel, count), parentPanel, mainPanel);
        init(count);
    }

    private void init(int count) {
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        Properties uiStylesProperties = mainPanel.getUiStylesProperties();
        Properties generalProperties = mainPanel.getGeneralProperties();

        setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_BG_COLOR));

        Panel countPanel = getCountPanel(count, uiPositionProperties, uiStylesProperties);
        ImagePanel icon = new ImagePanel(ChildName.VideoListPage.TopicPanel.LOGO.name(),
                generalProperties.getProperty(Constants.General.VIDEOLIST_TOPIC_ICON_PATH), new Rectangle(0, 0, PropertyUtil.getInteger(uiPositionProperties,
                        UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_ICON_WIDTH), PropertyUtil.getInteger(uiPositionProperties,
                        UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_ICON_HEIGHT)), this, mainPanel);
        icon.makeVerticallyCenterPositioned(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_ICON_X));
        Label titleLabel = getTitleLabel(count, icon, uiPositionProperties, uiStylesProperties, generalProperties);
        Label durationLabel = getDurationLabel(count, icon, uiPositionProperties, uiStylesProperties, generalProperties);
        Button button = getButton(count, uiPositionProperties, uiStylesProperties, generalProperties);
        button.addActionListener(new VideoPageNavigator(mainPanel, generalProperties.getProperty(Constants.General.VIDEOLIST_TOPIC + count), PropertyUtil
                .getPathAsURI(generalProperties, Constants.General.VIDEOLIST_TOPIC + count + Constants.General.VIDEOLIST_TOPIC_VIDEO_PATH_POSTFIX)));

        addChild(countPanel);
        addChild(icon);
        addChild(ChildName.VideoListPage.TopicPanel.TOPIC_NAME.name(), titleLabel);
        addChild(ChildName.VideoListPage.TopicPanel.TOPIC_DURATION.name(), durationLabel);
        addChild(button);
    }

    private Button getButton(int count, Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_BUTTON_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_BUTTON_FONT_COLOR);
        Color backgroundColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_BUTTON_BG_COLOR);
        Color backgroundHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_BUTTON_BG_HOVER_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_TOPIC_BUTTON_TEXT);

        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_BUTTON_X);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_BUTTON_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_BUTTON_HEIGHT);

        Button button = new Button(ChildName.VideoListPage.TopicPanel.BUTTON.name(), text, font, fontColor, backgroundColor, 0, null, backgroundColor,
                backgroundHoverColor, new Rectangle(x, 0, width, height), this, mainPanel);
        button.makeVerticallyCenterPositioned(x);

        return button;
    }

    private Panel getCountPanel(int count, Properties uiPositionProperties, Properties uiStylesProperties) {
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_COUNT_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_HEIGHT);
        Panel panel = new Panel(ChildName.VideoListPage.TopicPanel.NUMBER_PANEL.name(), new Rectangle(0, 0, width, height), this, mainPanel);
        panel.setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_COUNT_BG_COLOR));

        Label countLabel = getCountLabel(count, panel, uiPositionProperties, uiStylesProperties);
        panel.addChild(ChildName.General.LABEL.name(), countLabel);

        return panel;
    }

    private Label getDurationLabel(int count, Panel iconPanel, Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_DURATION_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_DURATION_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_TOPIC + count + Constants.General.VIDEOLIST_TOPIC_DURATION_POSTFIX);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        int x = iconPanel.getBounds().x + iconPanel.getBounds().width
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_MARGIN_FROM_ICON);
        int y = iconPanel.getBounds().y + iconPanel.getBounds().height
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_MARGIN_FROM_ICON);
        label.setLocation(x, y);

        return label;
    }

    private Label getTitleLabel(int count, Panel iconPanel, Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_TITLE_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_TITLE_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_TOPIC + count);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        int x = iconPanel.getBounds().x + iconPanel.getBounds().width
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_MARGIN_FROM_ICON);
        int y = iconPanel.getBounds().y - label.getSize().height
                - PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_MARGIN_FROM_ICON);
        label.setLocation(x, y);

        return label;
    }

    private Label getCountLabel(int count, Panel countPanel, Properties uiPositionProperties, Properties uiStylesProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_COUNT_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_TOPICS_COUNT_FONT_COLOR);

        Label label = new Label(countPanel, count + "", font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.makeCenterPositioned();

        return label;
    }

    private static Rectangle getBounds(MainPanel mainPanel, int count) {
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();

        int x = 0;
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_HEADER_HEIGHT) + (count - 1)
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_HEIGHT) + (count - 1)
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_MARGIN);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPICS_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_TOPIC_HEIGHT);

        return new Rectangle(x, y, width, height);
    }
}
