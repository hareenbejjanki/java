package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Properties;

import javax.swing.JScrollPane;

import com.bhirava.ovilearning.constants.PageName;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.component.login.LoginPage;
import com.bhirava.ovilearning.ui.component.videolist.VideoListPage;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class MainPanel extends Panel {
    private static final long serialVersionUID = 1L;

    private Properties uiPositionProperties;
    private Properties uiStylesProperties;
    private Properties uiOtherProperties;
    private Properties generalProperties;
    private Panel header;
    private Panel currentPage;
    private Panel footer;
    private JScrollPane scrollPane;
    private Panel sideMenu;

    private MainFrame mainFrame;

    public Properties getUiPositionProperties() {
        return uiPositionProperties;
    }

    public Properties getUiOtherProperties() {
        return uiOtherProperties;
    }

    public Properties getUiStylesProperties() {
        return uiStylesProperties;
    }

    public Properties getGeneralProperties() {
        return generalProperties;
    }

    public Panel getCurrentPage() {
        return currentPage;
    }

    public void setPage(PageName page) {
        setPage(page, null);
    }

    public void setPage(PageName page, Object param1) {
        setPage(page, param1, null);
    }

    public void setPage(PageName page, Object param1, Object param2) {
        if (currentPage != null) {
            currentPage.distroy();
        }

        switch (page) {
            case LOGIN_PAGE:
                currentPage = new LoginPage(this);
                break;
            case VIDEO_LIST_PAGE:
                currentPage = new VideoListPage(this);
                break;
            case VIDEO_PAGE:
                currentPage = new VideoPage((String) param1, (String) param2, this);
                break;
            default:
                break;
        }

        footer.setLocation(0, currentPage.getHeight());
        scrollPane.setPreferredSize(new Dimension(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH), currentPage
                .getHeight() + footer.getHeight()));
        setPreferredSize(new Dimension(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH), currentPage.getHeight()
                + footer.getHeight()));
        add(currentPage);
        mainFrame.shakeOnce();
    }

    public MainPanel(MainFrame mainFrame, Properties uiPositionProperties, Properties uiStylesProperties, Properties uiOtherProperties, Properties generalProperties) {
        super("MainPanel", null, null, null);
        this.mainFrame = mainFrame;
        this.uiPositionProperties = uiPositionProperties;
        this.uiStylesProperties = uiStylesProperties;
        this.uiOtherProperties = uiOtherProperties;
        this.generalProperties = generalProperties;
    }

    private void init() {
        initProperties();
        initComponents();
        initEvents();
    }

    private void initEvents() {
    }

    private void initComponents() {
        header = new HeaderPanel(this);
        footer = new FooterPanel(this);
        add(header);
        setPage(PageName.LOGIN_PAGE);
        add(footer);
        setBackground(Color.WHITE);
    }

    private void initProperties() {
        setLayout(null);
        setOpaque(false);
        setPreferredSize(new Dimension(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH), 3000));
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
        init();
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void shakeOnce() {
        mainFrame.shakeOnce();
    }
}
