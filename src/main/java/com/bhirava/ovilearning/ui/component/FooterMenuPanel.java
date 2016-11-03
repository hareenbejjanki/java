package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.ImagePanel;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.component.basic.VerticalTextMenuPanel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class FooterMenuPanel extends Panel {

    private static final long serialVersionUID = 1L;

    public FooterMenuPanel(Panel parentComponent) {
        super(parentComponent, getBounds(parentComponent));
        init();
    }

    private void init() {
        MainPanel mainPanel = (MainPanel) parentComponent.getParentComponent();
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        Properties uiStylesProperties = mainPanel.getUiStylesProperties();
        Properties generalProperties = mainPanel.getGeneralProperties();

        setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_BG_COLOR));

        ImagePanel logo = new ImagePanel(this, generalProperties.getProperty(Constants.General.LOGO_PATH), getLogoBounds(uiPositionProperties));
        VerticalTextMenuPanel menu1 = getMenu1(uiPositionProperties, uiStylesProperties, generalProperties);
        VerticalTextMenuPanel menu2 = getMenu2(uiPositionProperties, uiStylesProperties, generalProperties);
        VerticalTextMenuPanel menu3 = getMenu3(uiPositionProperties, uiStylesProperties, generalProperties);
        Label infoLineLabel = getInfoLineLabel(uiPositionProperties, uiStylesProperties, generalProperties);
        Label infoLineTextLabel = getInfoLineTextLabel(infoLineLabel, uiPositionProperties, uiStylesProperties, generalProperties);
        Label emailLabel = getEmailLabel(infoLineLabel, uiPositionProperties, uiStylesProperties, generalProperties);
        Label emailTextLabel = getEmailTextLabel(infoLineLabel, emailLabel, uiPositionProperties, uiStylesProperties, generalProperties);

        addChild(ChildName.MainPage.FooterPanel.LOGO.name(), logo);
        addChild(ChildName.MainPage.FooterPanel.MENU1.name(), menu1);
        addChild(ChildName.MainPage.FooterPanel.MENU2.name(), menu2);
        addChild(ChildName.MainPage.FooterPanel.MENU3.name(), menu3);
        addChild(ChildName.MainPage.FooterPanel.INFO_LINE.name(), infoLineLabel);
        addChild(ChildName.MainPage.FooterPanel.INFO_LINE_TEXT.name(), infoLineTextLabel);
        addChild(ChildName.MainPage.FooterPanel.EMAIL.name(), emailLabel);
        addChild(ChildName.MainPage.FooterPanel.EMAIL_TEXT.name(), emailTextLabel);
    }

    private VerticalTextMenuPanel getMenu3(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        String heading = generalProperties.getProperty(Constants.General.FOOTER_MENU3_HEADER);
        Font headingFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT);
        Color headingColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT_COLOR);
        ArrayList<String> menu = new ArrayList<String>();
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU3_ITEM1));
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU3_ITEM2));
        Font menuFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT);
        Color menuColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT_COLOR);
        Color menuHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_HOVER_FONT_COLOR);

        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU3_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_Y);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_WIDTH);
        int margin = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_MARGIN);

        Rectangle bounds = new Rectangle(x, y, width, 10);

        return new VerticalTextMenuPanel(this, UIConstants.Styles.TRANSPARENT_COLOR, heading, headingFont, headingColor, menu, menuFont, menuColor,
                menuHoverColor, margin, bounds);
    }

    private VerticalTextMenuPanel getMenu2(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        String heading = generalProperties.getProperty(Constants.General.FOOTER_MENU2_HEADER);
        Font headingFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT);
        Color headingColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT_COLOR);
        ArrayList<String> menu = new ArrayList<String>();
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU2_ITEM1));
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU2_ITEM2));
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU2_ITEM3));
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU2_ITEM4));
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU2_ITEM5));
        Font menuFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT);
        Color menuColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT_COLOR);
        Color menuHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_HOVER_FONT_COLOR);

        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU2_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_Y);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_WIDTH);
        int margin = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_MARGIN);

        Rectangle bounds = new Rectangle(x, y, width, 10);

        return new VerticalTextMenuPanel(this, UIConstants.Styles.TRANSPARENT_COLOR, heading, headingFont, headingColor, menu, menuFont, menuColor,
                menuHoverColor, margin, bounds);
    }

    private VerticalTextMenuPanel getMenu1(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        String heading = generalProperties.getProperty(Constants.General.FOOTER_MENU1_HEADER);
        Font headingFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT);
        Color headingColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT_COLOR);
        ArrayList<String> menu = new ArrayList<String>();
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU1_ITEM1));
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU1_ITEM2));
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU1_ITEM3));
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU1_ITEM4));
        menu.add(generalProperties.getProperty(Constants.General.FOOTER_MENU1_ITEM5));
        Font menuFont = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT);
        Color menuColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT_COLOR);
        Color menuHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_HOVER_FONT_COLOR);

        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU1_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_Y);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_WIDTH);
        int margin = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_MARGIN);

        Rectangle bounds = new Rectangle(x, y, width, 10);

        return new VerticalTextMenuPanel(this, UIConstants.Styles.TRANSPARENT_COLOR, heading, headingFont, headingColor, menu, menuFont, menuColor,
                menuHoverColor, margin, bounds);
    }

    private Rectangle getLogoBounds(Properties uiPositionProperties) {
        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_LOGO_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_LOGO_Y);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_LOGO_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_LOGO_HEIGHT);
        return new Rectangle(x, y, width, height);
    }

    private Label getInfoLineLabel(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.FOOTER_INFOLINE);

        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU3_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_INFOLINE_Y);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.setLocation(x, y);

        return label;
    }

    private Label getInfoLineTextLabel(Label infoLineLabel, Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT_COLOR);
        Color fontHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_HOVER_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.FOOTER_INFOLINE_TEXT);

        int x = infoLineLabel.getSize().width + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU3_X);
        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_INFOLINE_Y);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, fontHoverColor);
        label.setLocation(x, y);

        return label;
    }

    private Label getEmailTextLabel(Label infoLineLabel, Label emailLabel, Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_FONT_COLOR);
        Color fontHoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_LABEL_HOVER_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.FOOTER_EMAIL_TEXT);

        int x = emailLabel.getSize().width + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU3_X);
        int y = infoLineLabel.getSize().height + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_MARGIN)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_INFOLINE_Y);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, fontHoverColor);
        label.setLocation(x, y);

        return label;
    }

    private Label getEmailLabel(Label infoLineLabel, Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_HEADER_LABEL_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.FOOTER_EMAIL);

        int x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU3_X);
        int y = infoLineLabel.getSize().height + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_SUBMENU_MARGIN)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_INFOLINE_Y);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.setLocation(x, y);

        return label;
    }

    private static Rectangle getBounds(Panel parentComponent) {
        MainPanel mainPanel = (MainPanel) parentComponent.getParentComponent();
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FRAME_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_HEIGHT);
        return new Rectangle(0, 0, width, height);
    }

}
