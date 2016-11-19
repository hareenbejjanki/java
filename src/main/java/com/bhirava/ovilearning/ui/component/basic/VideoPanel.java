package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Rectangle;

import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.component.util.JVideoPanel;

public class VideoPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public VideoPanel(String name, String vedioPath, Rectangle bounds, Panel parentPanel, MainPanel mainPanel) {
        super(name, bounds, parentPanel, mainPanel);
        init(vedioPath, bounds);
    }

    private void init(String vedioPath, Rectangle bounds) {
        JVideoPanel videoPanel = new JVideoPanel(vedioPath, bounds.width, bounds.height);
        videoPanel.setBounds(bounds);
        add(videoPanel);
    }

}
