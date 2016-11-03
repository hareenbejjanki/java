package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Rectangle;

public class VideoPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public VideoPanel(Panel parentComponent, String vedioPath, Rectangle bounds) {
        super(parentComponent, bounds);
        init(vedioPath, bounds);
    }

    private void init(String vedioPath, Rectangle bounds) {
        JVideoPanel videoPanel = new JVideoPanel(vedioPath, bounds.width, bounds.height);
        videoPanel.setBounds(bounds);
        add(videoPanel);
    }

}
