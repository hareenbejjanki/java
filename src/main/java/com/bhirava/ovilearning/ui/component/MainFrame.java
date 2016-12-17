package com.bhirava.ovilearning.ui.component;

import java.awt.Dimension;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.event.WindowCloser;
import com.bhirava.ovilearning.ui.util.PropertyUtil;
import com.bhirava.ovilearning.ui.util.PropertyValues;

public class MainFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private JScrollPane scrollPane;

    public MainFrame(PropertyValues propertyValues) throws IOException {
        init(propertyValues);
        setVisible(true);
    }

    private void init(PropertyValues propertyValues) throws IOException {
        Properties textAndPathsProperties = propertyValues.getTextAndPathsProperties();
        setIconImage(PropertyUtil.getImage(textAndPathsProperties, UIConstants.TextAndPaths.LOGO_PATH));
        initProperties(propertyValues.getPositionProperties());
        initComponents(propertyValues);
        initEvents();
    }

    private void initEvents() {
        addWindowListener(new WindowCloser(this));
    }

    private void initComponents(PropertyValues propertyValues) {
        MainPanel mainPanel = new MainPanel(this, propertyValues);
        scrollPane = new JScrollPane(mainPanel);
        mainPanel.setScrollPane(scrollPane);
        setScrollPaneProperties(scrollPane, propertyValues.getPositionProperties());
        add(scrollPane);
    }

    private void setScrollPaneProperties(JScrollPane scrollPane, Properties uiPositionProperties) {
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FRAME_WIDTH), PropertyUtil.getInteger(
                uiPositionProperties, UIConstants.Positions.FRAME_HEIGHT)));
    }

    private void initProperties(Properties uiPositionProperties) {
        setResizable(false);
        // setLocation(0, 0);
        setBounds(0, 0, PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FRAME_WIDTH),
                PropertyUtil.getInteger(uiPositionProperties, UIConstants.Positions.FRAME_HEIGHT));
    }

    public void shakeOnce() {
        scrollPane.getVerticalScrollBar().setValue(10);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scrollPane.getVerticalScrollBar().setValue(0);
    }

}
