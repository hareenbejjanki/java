package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Rectangle;

import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.component.util.JLoopVideoPanel;

public class LoopVideoPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public LoopVideoPanel(String name, String vedioPath, Rectangle bounds, Panel parentPanel, MainPanel mainPanel) {
        super(name, bounds, parentPanel, mainPanel);
        init(vedioPath, bounds);
    }

    private void init(String vedioPath, Rectangle bounds) {
        setLayout(null);
        JLoopVideoPanel loopVideoPanel = new JLoopVideoPanel(vedioPath, bounds.width, bounds.height);
        loopVideoPanel.setBounds(bounds);
        add(loopVideoPanel);
    }

}
