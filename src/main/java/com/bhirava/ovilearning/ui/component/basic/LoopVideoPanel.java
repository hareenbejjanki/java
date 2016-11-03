package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Rectangle;

public class LoopVideoPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public LoopVideoPanel(Panel parentComponent, String vedioPath, Rectangle bounds) {
        super(parentComponent, bounds);
        init(vedioPath, bounds);
    }

    private void init(String vedioPath, Rectangle bounds) {
        setLayout(null);
        JLoopVideoPanel loopVideoPanel = new JLoopVideoPanel(vedioPath, bounds.width, bounds.height);
        loopVideoPanel.setBounds(bounds);
        add(loopVideoPanel);
    }

}
