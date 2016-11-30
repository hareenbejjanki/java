package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.ImagePanel;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.component.basic.VerticalTextMenuPanel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class BlackThemeFooterMenuPanel extends Panel {

    private static final long serialVersionUID = 1L;

    public BlackThemeFooterMenuPanel(Panel parentPanel, MainPanel mainPanel) {
        super(ChildName.BlackTheme.FooterPanel.MENU_PANEL.name(), new Rectangle(0, 0, UIConstants.Styles.DEFAULT_ICON_HEIGHT,
                UIConstants.Styles.DEFAULT_ICON_HEIGHT), parentPanel, mainPanel);
        init();
    }

    private void init() {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        Properties textAndPathsProperties = mainPanel.getPropertyValues().getTextAndPathsProperties();

        setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_BG_COLOR));

        VerticalTextMenuPanel menu1 = getMenu1();
        ImagePanel logo = new ImagePanel(ChildName.BlackTheme.FooterPanel.LOGO.name(), textAndPathsProperties.getProperty(UIConstants.TextAndPaths.LOGO_PATH),
                getLogoBounds(uiPositionProperties), this, mainPanel);
        VerticalTextMenuPanel menu2 = getMenu2(menu1);
        VerticalTextMenuPanel menu3 = getMenu3(menu1);
        Label infoLineLabel = getInfoLineLabel(uiPositionProperties, uiStylesProperties, textAndPathsProperties);
        Label infoLineTextLabel = getInfoLineTextLabel(infoLineLabel, uiPositionProperties, uiStylesProperties, textAndPathsProperties);
        Label emailLabel = getEmailLabel(infoLineLabel, uiPositionProperties, uiStylesProperties, textAndPathsProperties);
        Label emailTextLabel = getEmailTextLabel(infoLineLabel, emailLabel, uiPositionProperties, uiStylesProperties, textAndPathsProperties);

        addChild(logo);
        addChild(menu1);
        addChild(menu2);
        addChild(menu3);
        addChild(ChildName.BlackTheme.FooterPanel.INFO_LINE.name(), infoLineLabel);
        addChild(ChildName.BlackTheme.FooterPanel.INFO_LINE_TEXT.name(), infoLineTextLabel);
        addChild(ChildName.BlackTheme.FooterPanel.EMAIL.name(), emailLabel);
        addChild(ChildName.BlackTheme.FooterPanel.EMAIL_TEXT.name(), emailTextLabel);
    }

    private VerticalTextMenuPanel getMenu3(VerticalTextMenuPanel menu1) {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        Properties textAndPathsProperties = mainPanel.getPropertyValues().getTextAndPathsProperties();

        String heading = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU1_HEADER);
        Font headingFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_HEADER_LABEL_FONT);
        Color headingColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_HEADER_LABEL_FONT_COLOR);
        ArrayList<String> menu = new ArrayList<String>();
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU3_ITEM1));
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU3_ITEM2));
        Font menuFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_LABEL_FONT);
        Color menuColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_LABEL_FONT_COLOR);
        Color menuHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_LABEL_HOVER_FONT_COLOR);

        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_FOOTER_MENU_SUBMENU_WIDTH);
        int margin = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_FOOTER_MENU_SUBMENU_VERTICAL_MARGIN);

        Rectangle bounds = new Rectangle(0, menu1.getLocation().y, width, UIConstants.Styles.DEFAULT_ICON_HEIGHT);

        return new VerticalTextMenuPanel(ChildName.BlackTheme.FooterPanel.MENU2.name(), UIConstants.Styles.TRANSPARENT_COLOR, heading, headingFont,
                headingColor, menu, menuFont, menuColor, menuHoverColor, margin, bounds, this, mainPanel);
    }

    private VerticalTextMenuPanel getMenu2(VerticalTextMenuPanel menu1) {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        Properties textAndPathsProperties = mainPanel.getPropertyValues().getTextAndPathsProperties();

        String heading = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU1_HEADER);
        Font headingFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_HEADER_LABEL_FONT);
        Color headingColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_HEADER_LABEL_FONT_COLOR);
        ArrayList<String> menu = new ArrayList<String>();
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU2_ITEM1));
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU2_ITEM2));
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU2_ITEM3));
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU2_ITEM4));
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU2_ITEM5));
        Font menuFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_LABEL_FONT);
        Color menuColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_LABEL_FONT_COLOR);
        Color menuHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_LABEL_HOVER_FONT_COLOR);

        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_FOOTER_MENU_SUBMENU_WIDTH);
        int margin = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_FOOTER_MENU_SUBMENU_VERTICAL_MARGIN);

        Rectangle bounds = new Rectangle(0, menu1.getLocation().y, width, UIConstants.Styles.DEFAULT_ICON_HEIGHT);

        return new VerticalTextMenuPanel(ChildName.BlackTheme.FooterPanel.MENU2.name(), UIConstants.Styles.TRANSPARENT_COLOR, heading, headingFont,
                headingColor, menu, menuFont, menuColor, menuHoverColor, margin, bounds, this, mainPanel);
    }

    private VerticalTextMenuPanel getMenu1() {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        Properties textAndPathsProperties = mainPanel.getPropertyValues().getTextAndPathsProperties();

        String heading = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU1_HEADER);
        Font headingFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_HEADER_LABEL_FONT);
        Color headingColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_HEADER_LABEL_FONT_COLOR);
        ArrayList<String> menu = new ArrayList<String>();
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU1_ITEM1));
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU1_ITEM2));
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU1_ITEM3));
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU1_ITEM4));
        menu.add(textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_MENU1_ITEM5));
        Font menuFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_LABEL_FONT);
        Color menuColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_LABEL_FONT_COLOR);
        Color menuHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_LABEL_HOVER_FONT_COLOR);

        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_FOOTER_MENU_SUBMENU_WIDTH);
        int margin = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.BLACK_THEME_FOOTER_MENU_SUBMENU_VERTICAL_MARGIN);

        Rectangle bounds = new Rectangle(0, 0, width, UIConstants.Styles.DEFAULT_ICON_HEIGHT);

        VerticalTextMenuPanel verticalTextMenuPanel = new VerticalTextMenuPanel(ChildName.BlackTheme.FooterPanel.MENU1.name(), UIConstants.Styles.TRANSPARENT_COLOR, heading, headingFont,
                headingColor, menu, menuFont, menuColor, menuHoverColor, margin, bounds, this, mainPanel);
        verticalTextMenuPanel.makeVerticallyCenterPositioned(0);

        return verticalTextMenuPanel;
    }

    private Rectangle getLogoBounds(Properties uiPositionProperties) {
        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_LOGO_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_LOGO_Y);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_LOGO_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_LOGO_HEIGHT);
        return new Rectangle(x, y, width, height);
    }

    private Label getInfoLineLabel(Properties uiPositionProperties, Properties uiStylesProperties, Properties textAndPathsProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT_COLOR);
        String text = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_INFOLINE);

        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU3_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_INFOLINE_Y);

        Label label = new Label(text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, this);
        label.setLocation(x, y);

        return label;
    }

    private Label getInfoLineTextLabel(Label infoLineLabel, Properties uiPositionProperties, Properties uiStylesProperties, Properties textAndPathsProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT_COLOR);
        Color fontHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_HOVER_FONT_COLOR);
        String text = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_INFOLINE_TEXT);

        int x = infoLineLabel.getSize().width + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU3_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_INFOLINE_Y);

        Label label = new Label(text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, fontHoverColor, this);
        label.setLocation(x, y);

        return label;
    }

    private Label getEmailTextLabel(Label infoLineLabel, Label emailLabel, Properties uiPositionProperties, Properties uiStylesProperties,
            Properties textAndPathsProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT_COLOR);
        Color fontHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_HOVER_FONT_COLOR);
        String text = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_EMAIL_TEXT);

        int x = emailLabel.getSize().width + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU3_X);
        int y = infoLineLabel.getSize().height + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_MARGIN)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_INFOLINE_Y);

        Label label = new Label(text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, fontHoverColor, this);
        label.setLocation(x, y);

        return label;
    }

    private Label getEmailLabel(Label infoLineLabel, Properties uiPositionProperties, Properties uiStylesProperties, Properties textAndPathsProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT_COLOR);
        String text = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_EMAIL);

        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU3_X);
        int y = infoLineLabel.getSize().height + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_MARGIN)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_INFOLINE_Y);

        Label label = new Label(text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, this);
        label.setLocation(x, y);

        return label;
    }

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties uiPositionProperties = mainPanel.getPropertyValues().getPositionProperties();
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FRAME_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_HEIGHT);
        return new Rectangle(0, 0, width, height);
    }

}
