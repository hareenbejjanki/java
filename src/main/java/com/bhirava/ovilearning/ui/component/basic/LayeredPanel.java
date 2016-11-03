package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Component;
import java.awt.Rectangle;

import javax.swing.JLayeredPane;

public class LayeredPanel extends Panel {
    private static final long serialVersionUID = 1L;
    protected JLayeredPane layeredPane;

    public LayeredPanel(Panel parentComponent, Rectangle bounds) {
        super(parentComponent, bounds);
        layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, bounds.width, bounds.height);
        add(layeredPane);
    }

    @Override
    public void addChild(String name, Component child) {
        childComponents.put(name, child);
        layeredPane.add(child, new Integer(childComponents.size()));
    }

    public void addChild(String name, Component child, Integer position) {
        childComponents.put(name, child);
        layeredPane.add(child, position);
    }

}
