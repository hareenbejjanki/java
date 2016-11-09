package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class CopyRightsPanel extends Panel {

    private static final long serialVersionUID = 1L;

    public CopyRightsPanel(Panel parentPanel, MainPanel mainPanel) {
        super(ChildName.MainPage.FooterPanel.COPY_RIGHTS_PANEL.name(), getBounds(mainPanel), parentPanel, mainPanel);
        init();
    }

    private void init() {
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        Properties uiStylesProperties = mainPanel.getUiStylesProperties();
        Properties generalProperties = mainPanel.getGeneralProperties();

        setBackground(PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_COPYRIGHTS_BG_COLOR));

        Label label = getLabel(uiPositionProperties, uiStylesProperties, generalProperties);

        addChild(ChildName.General.LABEL.name(), label);
    }

    private Label getLabel(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.FOOTER_COPYRIGHTS_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.FOOTER_COPYRIGHTS_FONT_COLOR);
        String text = generalProperties.getProperty(Constants.General.FOOTER_COPYRIGHTS_TEXT);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR);
        label.makeCenterPositioned();

        return label;
    }

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();

        int y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_MENU_HEIGHT);
        int width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FRAME_WIDTH);
        int height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FOOTER_COPYRIGHTS_HEIGHT);
        return new Rectangle(0, y, width, height);
    }

}
