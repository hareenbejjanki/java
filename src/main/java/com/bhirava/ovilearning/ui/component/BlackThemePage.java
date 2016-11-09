package com.bhirava.ovilearning.ui.component;

import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.component.basic.VerticallyMovingPanel;
import com.bhirava.ovilearning.ui.event.MoveVerticallyWithScroll;

public class BlackThemePage extends Page {
    private static final long serialVersionUID = 1L;

    public BlackThemePage(Panel content, MainPanel mainPanel) {
        super(new HeaderPanel(mainPanel), content, new FooterPanel(null), null, null, mainPanel);
        init();
    }

    private void init() {
        initHeader();
        initEvents();
    }

    private void initHeader() {
        
    }

    private void initEvents() {
        mainPanel.getScrollPane().getVerticalScrollBar().addAdjustmentListener(new MoveVerticallyWithScroll((VerticallyMovingPanel) header));
    }
}
