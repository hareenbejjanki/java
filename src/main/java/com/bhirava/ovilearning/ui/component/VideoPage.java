package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.component.basic.VideoPanel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class VideoPage extends Panel {
    private static final long serialVersionUID = 1L;

    public VideoPage(String title, String videoPath, MainPanel mainPanel) {
        super(title, getBounds(mainPanel), mainPanel, mainPanel);
        init(title, videoPath);
    }

    private void init(String title, String videoPath) {
        setBackground(Color.GRAY);

        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        Properties uiStylesProperties = mainPanel.getUiStylesProperties();
        Properties generalProperties = mainPanel.getGeneralProperties();

        VideoPanel videoPanel = new VideoPanel("DUMMY", videoPath, getVideoBounds(), this, mainPanel);
        videoPanel.makeCenterPositioned();
        videoPanel.setLocation(videoPanel.getBounds().x, videoPanel.getBounds().y + 70);
        Label label = getTitleLabel(title, uiPositionProperties, uiStylesProperties, generalProperties);
        label.setLocation(videoPanel.getBounds().x, videoPanel.getBounds().y + 45);
        addChild("DUMMY", videoPanel);
    }

    private Label getTitleLabel(String title, Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_COLOR);

        Label label = new Label(this, title, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);

        return label;
    }

    private Rectangle getVideoBounds() {
        int x = 0;
        int y = 0;
        int width = 1323;
        int height = 556;
        return new Rectangle(x, y, width, height);
    }

    private static Rectangle getBounds(Panel mainPanel) {
        int x = 0;
        int y = 0;
        int width = 1440;
        int height = 706;
        return new Rectangle(x, y, width, height);
    }

}
