package com.bhirava.ovilearning.ui.component.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.Constants;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.component.basic.ImageBackgroundPanel;
import com.bhirava.ovilearning.ui.component.basic.Label;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.component.basic.TextBox;
import com.bhirava.ovilearning.ui.component.basic.Button;
import com.bhirava.ovilearning.ui.event.LoginButtonActionListener;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class LoginPanel extends ImageBackgroundPanel {

    private static final long serialVersionUID = 1L;

    public LoginPanel(Panel parentPanel, MainPanel mainPanel) {
        super(ChildName.LoginPage.LoginPanel.LOGIN_PANEL.name(), getImagePath(mainPanel), getBounds(mainPanel), parentPanel, mainPanel);
        init();
    }

    private void init() {
        Properties generalProperties = mainPanel.getGeneralProperties();
        Properties uiStylesProperties = mainPanel.getUiStylesProperties();
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();

        TextBox emailBox = getEmailTextBox(uiPositionProperties, uiStylesProperties, generalProperties);
        TextBox pwdBox = getPWDTextBox(uiPositionProperties, uiStylesProperties, generalProperties);
        Label label = getLabel(uiPositionProperties, uiStylesProperties, generalProperties);
        Button button = getButton(uiPositionProperties, uiStylesProperties, generalProperties);
        button.addActionListener(new LoginButtonActionListener(emailBox, pwdBox, mainPanel));

        addChild(ChildName.LoginPage.LoginPanel.EMAIL.name(), emailBox);
        addChild(ChildName.LoginPage.LoginPanel.PWD.name(), pwdBox);
        addChild(ChildName.LoginPage.LoginPanel.LABEL.name(), label);
        addChild(ChildName.LoginPage.LoginPanel.BUTTON.name(), button);
    }

    private Button getButton(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.LOGIN_BUTTON_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_BUTTON_FONT_COLOR);
        Color bgColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_BUTTON_BG_COLOR);
        Color borderColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_BUTTON_BORDER_COLOR);
        Integer borderSize = PropertyUtil.getInteger(uiStylesProperties, UIConstants.Styles.LOGIN_BUTTON_BORDER_SIZE);
        Color borderFocusColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_BUTTON_BORDER_FOCUS_COLOR);
        String text = generalProperties.getProperty(Constants.General.LOGIN_PANEL_BUTTON_TEXT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_BUTTON_X);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_EMAIL_Y) + 3
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_TEXTBOX_HEIGHT) + 3
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_MARGIN);
        Integer width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_BUTTON_WIDTH);
        Integer height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_BUTTON_HEIGHT);

        Rectangle bounds = new Rectangle(x, y, width, height);

        return new Button(ChildName.LoginPage.LoginPanel.BUTTON.name(), text, font, fontColor, borderColor, borderSize, borderFocusColor, bgColor, bounds, this, mainPanel);
    }

    private Label getLabel(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.LOGIN_LABEL_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_LABEL_FONT_COLOR);
        Color hoverColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_LABEL_FONT_HOVER_COLOR);
        String text = generalProperties.getProperty(Constants.General.LOGIN_PANEL_LABEL_TEXT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_LABEL_X);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_EMAIL_Y) + 2
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_TEXTBOX_HEIGHT) + 2
                * PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_MARGIN);

        Label label = new Label(this, text, font, fontColor, UIConstants.Styles.TRANSPARENT_COLOR, hoverColor);
        label.setLocation(x, y);

        return label;
    }

    private TextBox getPWDTextBox(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.LOGIN_TEXTBOX_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_TEXTBOX_FONT_COLOR);
        Color borderColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_TEXTBOX_BORDER_COLOR);
        Integer borderSize = PropertyUtil.getInteger(uiStylesProperties, UIConstants.Styles.LOGIN_TEXTBOX_BORDER_SIZE);
        Color focusColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_TEXTBOX_BG_FOCUS_COLOR);
        String text = generalProperties.getProperty(Constants.General.LOGIN_PANEL_PWD_TEXT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_TEXTBOX_X);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_EMAIL_Y)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_TEXTBOX_HEIGHT)
                + PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_MARGIN);
        Integer width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_TEXTBOX_WIDTH);
        Integer height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_TEXTBOX_HEIGHT);

        Rectangle bounds = new Rectangle(x, y, width, height);

        return new TextBox(this, font, fontColor, borderColor, borderSize, UIConstants.Styles.TRANSPARENT_COLOR, focusColor, text, bounds);
    }

    private TextBox getEmailTextBox(Properties uiPositionProperties, Properties uiStylesProperties, Properties generalProperties) {
        Font font = PropertyUtil.getFont(uiStylesProperties, UIConstants.Styles.LOGIN_TEXTBOX_FONT);
        Color fontColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_TEXTBOX_FONT_COLOR);
        Color borderColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_TEXTBOX_BORDER_COLOR);
        Integer borderSize = PropertyUtil.getInteger(uiStylesProperties, UIConstants.Styles.LOGIN_TEXTBOX_BORDER_SIZE);
        Color focusColor = PropertyUtil.getColor(uiStylesProperties, UIConstants.Styles.LOGIN_TEXTBOX_BG_FOCUS_COLOR);
        String text = generalProperties.getProperty(Constants.General.LOGIN_PANEL_EMAIL_TEXT);

        Integer x = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_TEXTBOX_X);
        Integer y = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_EMAIL_Y);
        Integer width = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_TEXTBOX_WIDTH);
        Integer height = PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_TEXTBOX_HEIGHT);

        Rectangle bounds = new Rectangle(x, y, width, height);

        return new TextBox(this, font, fontColor, borderColor, borderSize, UIConstants.Styles.TRANSPARENT_COLOR, focusColor, text, bounds);
    }

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties uiPositionProperties = mainPanel.getUiPositionProperties();
        return new Rectangle(0, 0, PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_WIDTH), PropertyUtil.getInteger(
                uiPositionProperties, UIConstants.Positions.LOGIN_LOGIN_PANEL_HEIGHT));
    }

    private static String getImagePath(MainPanel mainPanel) {
        Properties generalProperties = mainPanel.getGeneralProperties();
        return generalProperties.getProperty(Constants.General.LOGIN_PANEL_IMAGE_PATH);
    }
}
