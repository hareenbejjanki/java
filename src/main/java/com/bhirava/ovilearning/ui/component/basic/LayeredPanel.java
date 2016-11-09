package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JLayeredPane;

import com.bhirava.ovilearning.ui.component.MainPanel;

public class LayeredPanel extends Panel {
    private static final long serialVersionUID = 1L;
    protected JLayeredPane layeredPane;

    public LayeredPanel(String name, Rectangle bounds, Panel parentPanel, MainPanel mainPanel) {
        super(name, bounds, parentPanel, mainPanel);
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, bounds.width, bounds.height);
        add(layeredPane);
    }

    @Override
    public void addChild(Panel panel) {
        childComponents.put(panel.getName(), panel);
        layeredPane.add(panel, new Integer(childComponents.size()));
    }

    @Override
    public void addChild(String name, Component child) {
        childComponents.put(name, child);
        layeredPane.add(child, new Integer(childComponents.size()));
    }

    public void addChild(Panel panel, Integer position) {
        childComponents.put(panel.getName(), panel);
        layeredPane.add(panel, position);
    }

    public void addChild(String name, Component child, Integer position) {
        childComponents.put(name, child);
        layeredPane.add(child, position);
    }

}
