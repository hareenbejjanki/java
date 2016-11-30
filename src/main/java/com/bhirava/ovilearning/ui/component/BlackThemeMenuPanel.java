package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.OnHoverChangingImagePanel;
import com.bhirava.ovilearning.ui.component.basic.OnHoverChangingImageWithLabelPanel;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.ComponentUtil;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class BlackThemeMenuPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public BlackThemeMenuPanel(Panel parentPanel, MainPanel mainPanel) {
        super(ChildName.BlackTheme.HeaderPanel.MENU.name(),
                new Rectangle(0, 0, UIConstants.Styles.DEFAULT_ICON_HEIGHT, UIConstants.Styles.DEFAULT_ICON_HEIGHT), parentPanel, mainPanel);
        init();
    }

    private void init() {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        int margin = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_HEADER_MENU_MARGIN);

        OnHoverChangingImagePanel searchPanel = getSearchPanel();
        HorizantalMenuPanel textPanel = getTextPanel(margin, searchPanel);
        OnHoverChangingImageWithLabelPanel sideMenuTextPanel = getSideMenuTextPanel(margin, searchPanel, textPanel);

        addChild(searchPanel);
        addChild(textPanel);
        addChild(sideMenuTextPanel);
    }

    private OnHoverChangingImageWithLabelPanel getSideMenuTextPanel(int margin, OnHoverChangingImagePanel searchPanel, HorizantalMenuPanel textPanel) {
        Properties textAndPathsProperties = mainPanel.getPropertyValues().getTextAndPathsProperties();
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();

        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER_LABEL_FONT_COLOR);
        Color hoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER_LABEL_FONT_HOVER_COLOR);
        String text = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_HEADER_MENU_TEXT);

        Rectangle bounds = new Rectangle(0, 0, UIConstants.Styles.DEFAULT_ICON_HEIGHT, UIConstants.Styles.DEFAULT_ICON_HEIGHT);
        OnHoverChangingImageWithLabelPanel panel = new OnHoverChangingImageWithLabelPanel(ChildName.BlackTheme.HeaderTextMenuPanel.SIDE_MENU_ITEM.name(), text,
                font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, hoverColor, 10,
                textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_HEADER_MENU_ICON_WHITE),
                textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_HEADER_MENU_ICON_GRAY), true, bounds, this, mainPanel);
        panel.makeVerticallyCenterPositioned(searchPanel.getSize().width + margin + textPanel.getSize().width + margin);
        return panel;
    }

    private HorizantalMenuPanel getTextPanel(int margin, OnHoverChangingImagePanel searchPanel) {
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();

        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER_LABEL_FONT_COLOR);
        Color hoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER_LABEL_FONT_HOVER_COLOR);

        List<String> menu = getMenu();
        HorizantalMenuPanel panel = new HorizantalMenuPanel(ChildName.BlackTheme.HeaderTextMenuPanel.TEXT_MENU.name(), new Rectangle(0, 0,
                this.getSize().height, 0), UIConstants.Styles.TRANSPARENT_COLOR, menu, font, fontColor, hoverColor, margin, this, mainPanel);
        panel.makeVerticallyCenterPositioned(searchPanel.getSize().width + margin);

        return panel;
    }

    private List<String> getMenu() {
        Properties textAndPathsProperties = mainPanel.getPropertyValues().getTextAndPathsProperties();
        List<String> menu = new ArrayList<String>();

        if (mainPanel.getUser() != null) {
            String registerText = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_HEADER_REGISTER_TEXT);
            String loginText = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_HEADER_LOGIN_TEXT);
            menu.add(registerText);
            menu.add(loginText);
        } else {
            String loginText = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_HEADER_LOGOUT_TEXT);
            menu.add(loginText);
        }
        String tourText = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_HEADER_TOUR_TEXT);
        String mediumText = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_HEADER_MEDIUM_TEXT);

        menu.add(tourText);
        menu.add(mediumText);

        return menu;
    }

    public OnHoverChangingImagePanel getSearchPanel() {
        Properties textAndPathsProperties = mainPanel.getPropertyValues().getTextAndPathsProperties();
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();

        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_HEADER_LABEL_FONT);

        Integer height = ComponentUtil.getPreferedHeightByLabel(font);

        Rectangle bounds = new Rectangle(0, 0, height, height);
        OnHoverChangingImagePanel imagePanel = new OnHoverChangingImagePanel(ChildName.BlackTheme.HeaderTextMenuPanel.SEARCH_MENU_ITEM.name(),
                textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_HEADER_SEARCH_ICON_WHITE),
                textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_HEADER_SEARCH_ICON_GREY), bounds, this, mainPanel);
        imagePanel.makeVerticallyCenterPositioned(0);

        return imagePanel;
    }
}
