package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.ImagePanel;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.OnHoverChangingImagePanel;
import com.bhirava.ovilearning.ui.component.basic.VerticallyMovingPanel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class HeaderPanel extends VerticallyMovingPanel {
    private static final long serialVersionUID = 1L;

    public HeaderPanel(MainPanel mainPanel) {
        super(ChildName.General.HEADER.name(), getBounds(mainPanel), mainPanel.getScrollPane(), new Point(0, 0), getInitialColor(mainPanel),
                getScrollColor(mainPanel), mainPanel, mainPanel);
        init();
    }

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties positionProperties = mainPanel.getPropertyValues().getPositionProperties();

        return new Rectangle(0, 0, PropertyUtil.getInteger(positionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH), PropertyUtil.getInteger(
                positionProperties, UIConstants.Positions.HEADER_HEIGHT));
    }

    private static Color getScrollColor(MainPanel mainPanel) {
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        return PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_BG_COLOR);
    }

    private static Color getInitialColor(MainPanel mainPanel) {
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        return PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_BG_INIT_COLOR);
    }

    private void init() {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        Properties generalProperties = mainPanel.getPropertyValues().getGeneralProperties();

        ImagePanel logo = new ImagePanel(ChildName.MainPage.HeaderPanel.LOGO.name(), generalProperties.getProperty(Constants.General.LOGO_PATH),
                getLogoBounds(uiPositionProperties), this, mainPanel);
        ImagePanel searchPanel = getSearchPanel(uiPositionProperties, uiStylesProperties, generalProperties);
        Label registerLabel = getRegisterLabel(uiPositionProperties, uiStylesProperties, generalProperties);
        Label loginLabel = getLoginLabel(registerLabel, uiPositionProperties, uiStylesProperties, generalProperties);
        Label tourLabel = getTourLabel(registerLabel, loginLabel, uiPositionProperties, uiStylesProperties, generalProperties);
        Label mediumLabel = getMediumLabel(registerLabel, loginLabel, tourLabel, uiPositionProperties, uiStylesProperties, generalProperties);

        addChild(logo);
        addChild(searchPanel);
        addChild(ChildName.MainPage.HeaderPanel.REGISTER.name(), registerLabel);
        addChild(ChildName.MainPage.HeaderPanel.LOGIN.name(), loginLabel);
        addChild(ChildName.MainPage.HeaderPanel.TOUR.name(), tourLabel);
        addChild(ChildName.MainPage.HeaderPanel.MEDIUM.name(), mediumLabel);

    }

    private Label getMediumLabel(Label registerLabel, Label loginLabel, Label tourLabel, Properties uiPositionProperties, Properties uiStylesProperties,
            Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_COLOR);
        Color hoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_HOVER_COLOR);
        String text = generalProperties.getProperty(Constants.General.HEADER_MEDIUM_TEXT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_X)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_SEARCH_ICON_WIDTH) + 4
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_MARGIN) + registerLabel.getSize().width
                + loginLabel.getSize().width + tourLabel.getSize().width;

        Label label = new Label(text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, hoverColor, this);
        label.makeVerticallyCenterPositioned(x);

        return label;
    }

    private Label getTourLabel(Label registerLabel, Label loginLabel, Properties uiPositionProperties, Properties uiStylesProperties,
            Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_COLOR);
        Color hoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_HOVER_COLOR);
        String text = generalProperties.getProperty(Constants.General.HEADER_TOUR_TEXT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_X)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_SEARCH_ICON_WIDTH) + 3
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_MARGIN) + registerLabel.getSize().width
                + loginLabel.getSize().width;

        Label label = new Label(text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, hoverColor, this);
        label.makeVerticallyCenterPositioned(x);

        return label;
    }

    private Label getLoginLabel(Label registerLabel, Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_COLOR);
        Color hoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_HOVER_COLOR);
        String text = generalProperties.getProperty(Constants.General.HEADER_LOGIN_TEXT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_X)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_SEARCH_ICON_WIDTH) + 2
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_MARGIN) + registerLabel.getSize().width;

        Label label = new Label(text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, hoverColor, this);
        label.makeVerticallyCenterPositioned(x);

        return label;
    }

    private Label getRegisterLabel(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_COLOR);
        Color hoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_HOVER_COLOR);
        String text = generalProperties.getProperty(Constants.General.HEADER_REGISTER_TEXT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_X)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_SEARCH_ICON_WIDTH)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_MARGIN);

        Label label = new Label(text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, hoverColor, this);
        label.makeVerticallyCenterPositioned(x);

        return label;
    }

    private ImagePanel getSearchPanel(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_X);
        Integer width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_SEARCH_ICON_WIDTH);
        Integer height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_SEARCH_ICON_HEIGHT);

        Rectangle bounds = new Rectangle(x, 0, width, height);
        ImagePanel imagePanel = new ImagePanel(ChildName.MainPage.HeaderPanel.SEARCH.name(),
                generalProperties.getProperty(Constants.General.HEADER_SEAR_ICON_WHITE), bounds, this, mainPanel);
        imagePanel.makeVerticallyCenterPositioned(x);

        return imagePanel;
    }

    public OnHoverChangingImagePanel getSearchPanel2(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_X);
        Integer width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_SEARCH_ICON_WIDTH);
        Integer height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_SEARCH_ICON_HEIGHT);

        Rectangle bounds = new Rectangle(x, 0, width, height);
        OnHoverChangingImagePanel imagePanel = new OnHoverChangingImagePanel(ChildName.MainPage.HeaderPanel.SEARCH.name(),
                generalProperties.getProperty(Constants.General.HEADER_SEAR_ICON_WHITE),
                generalProperties.getProperty(Constants.General.HEADER_SEAR_ICON_GREY), bounds, this, mainPanel);
        imagePanel.makeVerticallyCenterPositioned(x);

        return imagePanel;
    }

    private Rectangle getLogoBounds(Properties uiPositionProperties) {
        return new Rectangle(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LOGO_X), PropertyUtil.getInteger(uiPositionProperties,
                UIConstants.Positions.HEADER_LOGO_Y), PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LOGO_WIDTH),
                PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LOGO_HEIGHT));
    }
}
