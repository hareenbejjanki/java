package com.bhirava.ovilearning.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.bhirava.ovilearning.constants.PageName;
import com.bhirava.ovilearning.ui.component.MainPanel;

public class VideoPageNavigator implements ActionListener {

    private MainPanel mainPanel;
    private String titile;
    private String videoPath;

    public VideoPageNavigator(MainPanel mainPanel, String titile, String videoPath) {
        this.mainPanel = mainPanel;
        this.titile = titile;
        this.videoPath = videoPath;
    }

    public void actionPerformed(ActionEvent e) {
        mainPanel.setPage(PageName.VIDEO_PAGE, titile, videoPath);
        mainPanel.repaint();
    }

}
