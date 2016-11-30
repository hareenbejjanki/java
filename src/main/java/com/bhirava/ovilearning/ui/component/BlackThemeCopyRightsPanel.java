package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class BlackThemeCopyRightsPanel extends Panel {

    private static final long serialVersionUID = 1L;

    public BlackThemeCopyRightsPanel(Panel parentPanel, MainPanel mainPanel) {
        super(ChildName.BlackTheme.FooterPanel.COPY_RIGHTS_PANEL.name(), new Rectangle(0, 0, UIConstants.Styles.DEFAULT_ICON_HEIGHT, UIConstants.Styles.DEFAULT_ICON_HEIGHT), parentPanel, mainPanel);
        init();
    }

    private void init() {
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();

        setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_COPYRIGHTS_BG_COLOR));

        Label label = getLabel();
        int margin = PropertyUtil.getInteger(uiStylesProperties, UIConstants.Positions.BLACK_THEME_FOOTER_COPYRIGHTS_VERTICAL_MARGIN);
        setBounds(0, mainPanel.getChild(ChildName.BlackTheme.FooterPanel.MENU_PANEL.name()).getSize().height, mainPanel.getSize().width, label.getSize().height + 2 * margin);
        label.makeCenterPositioned();

        addChild(ChildName.General.LABEL.name(), label);
    }

    private Label getLabel() {
        Properties uiStylesProperties = mainPanel.getPropertyValues().getStylesProperties();
        Properties textAndPathsProperties = mainPanel.getPropertyValues().getTextAndPathsProperties();

        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_COPYRIGHTS_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.BLACK_THEME_FOOTER_COPYRIGHTS_FONT_COLOR);
        String text = textAndPathsProperties.getProperty(UIConstants.TextAndPaths.BLACK_THEME_FOOTER_COPYRIGHTS_TEXT);

        Label label = new Label(text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, this);

        return label;
    }
}
