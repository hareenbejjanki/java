package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.OnHoverChangingImagePanel;
import com.bhirava.ovilearning.ui.component.basic.OnHoverChangingImageWithLabelPanel;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class BlackThemeMenuPanel extends Panel {
    private static final long serialVersionUID = 1L;

    private MainPanel mainPanel;

    public BlackThemeMenuPanel(Panel parentPanel, MainPanel mainPanel) {
        super(ChildName.BlackTheme.HeaderPanel.MENU.name(), new Rectangle(0, 0, 0, 0), parentPanel, mainPanel);

        this.mainPanel = mainPanel;
        init();
    }

    private void init() {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        int right = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_HEADER_MENU_RIGHT);
        int margin = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_MARGIN);

        OnHoverChangingImagePanel searchPanel = getSearchPanel();
        HorizantalMenuPanel textPanel = getTextPanel(margin);
        OnHoverChangingImageWithLabelPanel sideMenuTextPanel = getSideMenuTextPanel(margin);

        addChild(searchPanel);
        addChild(textPanel);
        addChild(sideMenuTextPanel);
    }

    private OnHoverChangingImageWithLabelPanel getSideMenuTextPanel(int margin) {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        Properties generalProperties = mainPanel.getPropertyValues().getGeneralProperties();

        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();

        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_COLOR);
        Color hoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_HOVER_COLOR);
        String text = generalProperties.getProperty(Constants.General.HEADER_MEDIUM_TEXT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_LABEL_X);
        Integer width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_SEARCH_ICON_WIDTH);
        Integer height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.HEADER_SEARCH_ICON_HEIGHT);

        Rectangle bounds = new Rectangle(x, 0, width, height);
        OnHoverChangingImageWithLabelPanel panel = new OnHoverChangingImageWithLabelPanel(ChildName.MainPage.HeaderPanel.SEARCH.name(), text, font, fontColor,
                UIConstants.Styles.TRANSPARENT_COLOR, hoverColor, 10, generalProperties.getProperty(Constants.General.HEADER_SEAR_ICON_WHITE),
                generalProperties.getProperty(Constants.General.HEADER_SEAR_ICON_GREY), true, bounds, this, mainPanel);
        panel.makeVerticallyCenterPositioned(x);
        return panel;
    }

    private HorizantalMenuPanel getTextPanel(int margin) {
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();

        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_COLOR);
        Color hoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.HEADER_LABEL_FONT_HOVER_COLOR);

        List<String> menu = getMenu();

        return new HorizantalMenuPanel(ChildName.BlackTheme.HeaderTextMenuPanel.TEXT_MENU.name(), new Rectangle(0, 0, this.getSize().height, 0),
                UIConstants.Styles.TRANSPARENT_COLOR, menu, font, fontColor, hoverColor, margin, this, mainPanel);
    }

    private List<String> getMenu() {
        Properties generalProperties = mainPanel.getPropertyValues().getGeneralProperties();
        List<String> menu = new ArrayList<String>();

        String registerText = generalProperties.getProperty(Constants.General.HEADER_REGISTER_TEXT);
        String loginText = generalProperties.getProperty(Constants.General.HEADER_LOGIN_TEXT);
        String tourText = generalProperties.getProperty(Constants.General.HEADER_TOUR_TEXT);
        String mediumText = generalProperties.getProperty(Constants.General.HEADER_MEDIUM_TEXT);

        menu.add(registerText);
        menu.add(loginText);
        menu.add(tourText);
        menu.add(mediumText);

        return menu;
    }

    public OnHoverChangingImagePanel getSearchPanel() {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        Properties generalProperties = mainPanel.getPropertyValues().getGeneralProperties();

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
}
