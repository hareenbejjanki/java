package com.bhirava.ovilearning.ui.component.videolist;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.component.basic.ImagePanel;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class VideoListPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public VideoListPanel(Panel parentComponent, MainPanel mainPanel) {
        super(ChildName.VideoListPage.Child.MAIN_PANEL.name(), getBounds(parentComponent), parentComponent, mainPanel);
        init();
    }

    private void init() {
        initLeft();
        VideoListTopicsPanel topicsPanel = new VideoListTopicsPanel(this, mainPanel);
        addChild(ChildName.VideoListPage.MainPanel.TOPICS_PANEL.name(), topicsPanel);
    }

    private void initLeft() {
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        Properties uiStylesProperties = mainPanel.getUiStylesProperties();
        Properties generalProperties = mainPanel.getGeneralProperties();

        Label progressLabel = getProgressLabel(uiPositionProperties, uiStylesProperties, generalProperties);
        Label progressValueLabel = getProgressValueLabel(uiPositionProperties, uiStylesProperties, generalProperties);
        Panel progressBar = new Panel(ChildName.VideoListPage.MainPanel.PROGRESS_BAR.name(), getProgressBarBounds(progressLabel, uiPositionProperties), this,
                mainPanel);
        progressBar.setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_PROGRESS_BAR_BG_COLOR));
        Label quizzValueLabel = getQuizzValueLabel(progressLabel, progressBar, uiPositionProperties, uiStylesProperties, generalProperties);
        Label quizzLabel = getQuizzLabel(quizzValueLabel, progressLabel, progressBar, uiPositionProperties, uiStylesProperties, generalProperties);
        Label assignmentValueLabel = getAssignmentValueLabel(quizzValueLabel, quizzLabel, progressLabel, progressBar, uiPositionProperties, uiStylesProperties,
                generalProperties);
        Label assignmentLabel = getAssignmentLabel(quizzValueLabel, quizzLabel, assignmentValueLabel, progressLabel, progressBar, uiPositionProperties,
                uiStylesProperties, generalProperties);
        ImagePanel imagePanel = new ImagePanel(ChildName.VideoListPage.MainPanel.IMAGE.name(),
                generalProperties.getProperty(Constants.General.VIDEOLIST_IMAGE_PATH), getImageBounds(progressLabel, progressBar, quizzLabel,
                        uiPositionProperties), this, mainPanel);

        addChild(ChildName.VideoListPage.MainPanel.PROGRESS_LABEL.name(), progressLabel);
        addChild(ChildName.VideoListPage.MainPanel.PROGRESS_VALUE_LABEL.name(), progressValueLabel);
        addChild(ChildName.VideoListPage.MainPanel.PROGRESS_BAR.name(), progressBar);
        addChild(ChildName.VideoListPage.MainPanel.QUIZZ_VALUE_LABEL.name(), quizzValueLabel);
        addChild(ChildName.VideoListPage.MainPanel.QUIZZ_LABEL.name(), quizzLabel);
        addChild(ChildName.VideoListPage.MainPanel.ASSIGNMENT_VALUE_LABEL.name(), assignmentValueLabel);
        addChild(ChildName.VideoListPage.MainPanel.ASSIGNMENT_LABEL.name(), assignmentLabel);
        addChild(ChildName.VideoListPage.MainPanel.IMAGE.name(), imagePanel);
    }

    private Rectangle getImageBounds(Label progressLabel, Panel progressBar, Label quizzLabel, Properties uiPositionProperties) {
        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_X);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_PROGRESS_Y) + progressLabel.getSize().height
                + progressBar.getSize().height + quizzLabel.getSize().height + 3
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_MARGIN);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_IMAGE_HEIGHT);
        return new Rectangle(x, y, width, height);
    }

    private Rectangle getProgressBarBounds(Label progressLabel, Properties uiPositionProperties) {
        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_X);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_PROGRESS_Y) + progressLabel.getSize().height
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_MARGIN);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_PROGRESS_BAR_HEIGHT);
        return new Rectangle(x, y, width, height);
    }

    private Label getAssignmentLabel(Label quizzValueLabel, Label quizzLabel, Label assignmentValueLabel, Label progressLabel, Panel progressBar,
            Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_QUIZZ_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_QUIZZ_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_ASSIGNMENT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_X) + quizzValueLabel.getSize().width
                + quizzLabel.getSize().width + assignmentValueLabel.getSize().width + 6
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_QUIZZ_MARZIN);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_PROGRESS_Y) + progressLabel.getSize().height
                + progressBar.getSize().height + 2 * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_MARGIN);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.setLocation(x, y);

        return label;
    }

    private Label getAssignmentValueLabel(Label quizzValueLabel, Label quizzLabel, Label progressLabel, Panel progressBar, Properties uiPositionProperties,
            Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_QUIZZ_VALUE_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_QUIZZ_VALUE_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_ASSIGNMENT_VALUE);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_X) + quizzValueLabel.getSize().width
                + quizzLabel.getSize().width + 5 * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_QUIZZ_MARZIN);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_PROGRESS_Y) + progressLabel.getSize().height
                + progressBar.getSize().height + 2 * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_MARGIN);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.setLocation(x, y);

        return label;
    }

    private Label getQuizzLabel(Label quizzValueLabel, Label progressLabel, Panel progressBar, Properties uiPositionProperties, Properties uiStylesProperties,
            Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_QUIZZ_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_QUIZZ_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_QUIZZ);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_X) + quizzValueLabel.getSize().width
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_QUIZZ_MARZIN);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_PROGRESS_Y) + progressLabel.getSize().height
                + progressBar.getSize().height + 2 * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_MARGIN);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.setLocation(x, y);

        return label;
    }

    private Label getQuizzValueLabel(Label progressLabel, Panel progressBar, Properties uiPositionProperties, Properties uiStylesProperties,
            Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_QUIZZ_VALUE_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_QUIZZ_VALUE_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_QUIZZ_VALUE);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_X);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_PROGRESS_Y) + progressLabel.getSize().height
                + progressBar.getSize().height + 2 * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_MARGIN);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.setLocation(x, y);

        return label;
    }

    private Label getProgressValueLabel(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_PROGRESS_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_PROGRESS_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_PROGRESS_VALUE);

        Integer width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_WIDTH);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_PROGRESS_Y);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.setLocation(width - label.getSize().width, y);

        return label;
    }

    private Label getProgressLabel(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_PROGRESS_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.VIDEOLIST_MAIN_PANEL_PROGRESS_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.VIDEOLIST_PROGRESS);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_LEFT_X);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_PROGRESS_Y);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.setLocation(x, y);

        return label;
    }

    private static Rectangle getBounds(Panel parentComponent) {
        MainPanel mainPanel = (MainPanel) parentComponent.getParentPanel();
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        int x = 0;
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_HEADER_HEIGHT)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_NAVIGATION_HEIGHT);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.VIDEOLIST_MAIN_PANEL_HEIGHT);
        return new Rectangle(x, y, width, height);
    }
}
