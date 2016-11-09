package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JScrollPane;

import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.event.MoveVerticallyWithScroll;

public class VerticallyMovingPanel extends Panel {
    private static final long serialVersionUID = 1L;

    private Point initialLocation;
    private Color initialColor;
    private Color scrollColor;

    public Point getInitialLocation() {
        return initialLocation;
    }

    public Color getInitialColor() {
        return initialColor;
    }

    public Color getScrollColor() {
        return scrollColor;
    }

    public VerticallyMovingPanel(String name, Rectangle bounds, JScrollPane scrollPane, Point initialLocation, Color initialColor, Panel parentComponent, MainPanel mainPanel) {
        this(name, bounds, scrollPane, initialLocation, initialColor, null, parentComponent, mainPanel);
    }

    public VerticallyMovingPanel(String name, Rectangle bounds, JScrollPane scrollPane, Point initialLocation, Color initialColor, Color scrollColor, Panel parentComponent, MainPanel mainPanel) {
        super(name, bounds, parentComponent, mainPanel);
        this.initialLocation = initialLocation;
        this.initialColor = initialColor;
        this.scrollColor = scrollColor;

        init(scrollPane);
    }

    private void init(JScrollPane scrollPane) {
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new MoveVerticallyWithScroll(this));
    }
}