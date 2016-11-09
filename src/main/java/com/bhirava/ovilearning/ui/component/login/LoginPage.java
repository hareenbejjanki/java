package com.bhirava.ovilearning.ui.component.login;

import java.awt.Component;
import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.PageName;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.component.basic.ImageBackgroundPanel;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class LoginPage extends Panel {
    private static final long serialVersionUID = 1L;

    public LoginPage(MainPanel mainPanel) {
        super(PageName.LOGIN_PAGE.name(), getBounds(mainPanel), mainPanel, mainPanel);
        init();
    }

    private static Rectangle getBounds(Panel parentComponent) {
        MainPanel mainPanel = (MainPanel) parentComponent;
        Properties positionProperties = mainPanel.getUiPositionProperties();

        return new Rectangle(0, 0, PropertyUtil.getInteger(positionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH), getHeight(positionProperties));
    }

    private static int getHeight(Properties positionProperties) {
        return PropertyUtil.getInteger(positionProperties, UIConstants.Positions.LOGIN_HEADER_HEIGHT)
                + PropertyUtil.getInteger(positionProperties, UIConstants.Positions.LOGIN_VOID_PANEL_HEIGHT);
    }

    private void init() {
        addPanels();
        initStyles();
    }

    private void addPanels() {
        addChild(ChildName.LoginPage.Child.HEADER_PANEL.name(), getHeaderPanel());
        addChild(ChildName.LoginPage.Child.VOID_LOGIN_PANEL.name(), getVoidLoginPanel());
    }

    private Component getVoidLoginPanel() {
        Panel panel = new Panel(ChildName.LoginPage.Child.VOID_LOGIN_PANEL.name(), getVoidLoginPanelBounds(), this, mainPanel);
        ImageBackgroundPanel loginPanel = new LoginPanel(panel, mainPanel);
        loginPanel.makeCenterPositioned();
        panel.addChild(ChildName.LoginPage.LoginPanel.LOGIN_PANEL.name(), loginPanel);
        return panel;
    }

    private Rectangle getVoidLoginPanelBounds() {
        MainPanel mainFrame = (MainPanel) parentPanel;
        Properties positionProperties = mainFrame.getUiPositionProperties();

        Rectangle bounds = new Rectangle(0, PropertyUtil.getInteger(positionProperties, UIConstants.Positions.LOGIN_HEADER_HEIGHT), PropertyUtil.getInteger(
                positionProperties, UIConstants.Positions.FRAME_WIDTH), PropertyUtil.getInteger(positionProperties,
                UIConstants.Positions.LOGIN_VOID_PANEL_HEIGHT));

        return bounds;
    }

    private Component getHeaderPanel() {
        return new LoginHeaderPanel(this, mainPanel);
    }

    private void initStyles() {
        setBackground(UIConstants.Styles.DEFAULT_COLOR);
    }
}
