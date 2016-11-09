package com.bhirava.ovilearning.ui.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLayeredPane;

import com.bhirava.ovilearning.ui.component.basic.Panel;

public class Page extends JLayeredPane {
    private static final long serialVersionUID = 1L;

    protected Panel header;
    protected Panel content;
    protected Panel footer;
    protected Panel leftSideMenu;
    protected Panel rightSideMenu;
    protected MainPanel mainPanel;

    public Panel getHeader() {
        return header;
    }

    public Panel getContent() {
        return content;
    }

    public Panel getFooter() {
        return footer;
    }

    public Panel getLeftSideMenu() {
        return leftSideMenu;
    }

    public Panel getRightSideMenu() {
        return rightSideMenu;
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    public Page(Panel header, Panel content, Panel footer, MainPanel mainPanel) {
        this(header, content, footer, null, null, mainPanel);
    }

    public Page(Panel header, Panel content, Panel footer, Panel leftSideMenu, Panel rightSideMenu, MainPanel mainPanel) {
        this.header = header;
        this.content = content;
        this.footer = footer;
        this.leftSideMenu = leftSideMenu;
        this.rightSideMenu = rightSideMenu;
        this.mainPanel = mainPanel;
        init();
    }

    private void init() {
        initProperties();
        initComponents();
    }

    private void initComponents() {
        add(header, new Integer(2));
        add(content, new Integer(1));

        if (leftSideMenu != null) {
            add(leftSideMenu, new Integer(1));
        }

        if (rightSideMenu != null) {
            add(rightSideMenu, new Integer(1));
        }

        add(footer, new Integer(1));
    }

    private void initProperties() {
        setLayout(null);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(mainPanel.getSize().width, content.getBounds().x + content.getBounds().height + footer.getBounds().height));
    }
}
