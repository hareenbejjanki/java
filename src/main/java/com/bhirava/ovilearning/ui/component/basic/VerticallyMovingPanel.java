package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JScrollPane;

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

    public VerticallyMovingPanel(Panel parentComponent, Rectangle bounds, JScrollPane scrollPane, Point initialLocation, Color initialColor) {
        this(parentComponent, bounds, scrollPane, initialLocation, initialColor, null);
    }

    public VerticallyMovingPanel(Panel parentComponent, Rectangle bounds, JScrollPane scrollPane, Point initialLocation, Color initialColor, Color scrollColor) {
        super(parentComponent, bounds);
        this.initialLocation = initialLocation;
        this.initialColor = initialColor;
        this.scrollColor = scrollColor;

        init(scrollPane);
    }

    private void init(JScrollPane scrollPane) {
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new MoveVerticallyWithScroll(this));
    }
}