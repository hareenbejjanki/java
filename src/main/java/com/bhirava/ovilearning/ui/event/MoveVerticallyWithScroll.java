package com.bhirava.ovilearning.ui.event;

import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import com.bhirava.ovilearning.ui.component.basic.VerticallyMovingPanel;

public class MoveVerticallyWithScroll implements AdjustmentListener {

    private VerticallyMovingPanel panel;

    public MoveVerticallyWithScroll(VerticallyMovingPanel panel) {
        this.panel = panel;
    }

    public void adjustmentValueChanged(AdjustmentEvent evt) {
        if (evt.getValueIsAdjusting()) {
            return;
        }
        Adjustable source = evt.getAdjustable();
        if (source.getOrientation() == Adjustable.VERTICAL && evt.getAdjustmentType() == AdjustmentEvent.TRACK) {
            int oldX = (int) panel.getInitialLocation().getX();
            int oldY = (int) panel.getInitialLocation().getY();
            panel.setLocation(oldX, oldY + evt.getValue());
            if (evt.getValue() == 0) {
                panel.setBackground(panel.getInitialColor());
            } else if (panel.getScrollColor() != null) {
                panel.setBackground(panel.getScrollColor());
            }
        }
    }

}
