package com.bhirava.ovilearning.ui.component;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.event.WindowCloser;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private JScrollPane scrollPane;

    public MainFrame(Properties uiPositionProperties, Properties uiStylesProperties, Properties otherProperties, Properties generalProperties) {
        init(uiPositionProperties, uiStylesProperties, otherProperties, generalProperties);
        setVisible(true);
    }

    private void init(Properties uiPositionProperties, Properties uiStylesProperties, Properties otherProperties, Properties generalProperties) {
        initProperties(uiPositionProperties);
        initComponents(uiPositionProperties, uiStylesProperties, otherProperties, generalProperties);
        initEvents();
    }

    private void initEvents() {
        addWindowListener(new WindowCloser(this));
    }

    private void initComponents(Properties uiPositionProperties, Properties uiStylesProperties, Properties otherProperties, Properties generalProperties) {
        MainPanel mainPanel = new MainPanel(uiPositionProperties, uiStylesProperties, otherProperties, generalProperties);
        scrollPane = new JScrollPane(mainPanel);
        mainPanel.setScrollPane(scrollPane);
        setScrollPaneProperties(scrollPane, uiPositionProperties);
        add(scrollPane);
    }

    private void setScrollPaneProperties(JScrollPane scrollPane, Properties uiPositionProperties) {
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FRAME_WIDTH), PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FRAME_HEIGHT)));
    }

    private void initProperties(Properties uiPositionProperties) {
        setResizable(false);
        setBounds(0, 0, PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FRAME_WIDTH), PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FRAME_HEIGHT));
    }

    public void shakeOnce() {
        Rectangle visible = scrollPane.getVisibleRect();
        visible.y = 10;
        scrollPane.scrollRectToVisible(visible);
//        visible.y = 0;
//        scrollPane.scrollRectToVisible(visible);
    }

}
