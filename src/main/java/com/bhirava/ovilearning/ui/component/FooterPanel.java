package com.bhirava.ovilearning.ui.component;

import java.awt.Rectangle;
import java.util.Properties;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.basic.Panel;
import com.bhirava.ovilearning.ui.util.PropertyUtil;

public class FooterPanel extends Panel {

	private static final long serialVersionUID = 1L;

	public FooterPanel(MainPanel mainPanel) {
		super(ChildName.General.FOOTER.name(), getBounds(mainPanel), mainPanel, mainPanel);
		init();
	}

    private static Rectangle getBounds(MainPanel mainPanel) {
        Properties positionProperties = mainPanel.getUiPositionProperties();

        return new Rectangle(0, 0, PropertyUtil.getInteger(positionProperties, UIConstants.Positions.MAIN_PANEL_WIDTH), getHeight(positionProperties));
    }

	private void init() {
		addPanels();
		initStyles();
	}

	private void addPanels() {
	    CopyRightsPanel copyRightsPanel = new CopyRightsPanel(this, mainPanel);
		FooterMenuPanel menuPanel = new FooterMenuPanel(this, mainPanel);
		addChild(copyRightsPanel);
		addChild(menuPanel);
	}

	private void initStyles() {
		Properties stylesProperties = mainPanel.getUiStylesProperties();
		Properties positionProperties = mainPanel.getUiPositionProperties();

		setBackground(PropertyUtil.getColor(stylesProperties, UIConstants.Styles.FOOTER_BG_COLOR));

		setListPanelStyles(stylesProperties, positionProperties);
	}

    private static int getHeight(Properties positionProperties) {
        return PropertyUtil.getInteger(positionProperties, UIConstants.Positions.FOOTER_MENU_HEIGHT)
                + PropertyUtil.getInteger(positionProperties, UIConstants.Positions.FOOTER_COPYRIGHTS_HEIGHT);
    }

    private void setListPanelStyles(Properties stylesProperties, Properties positionProperties) {
//		Panel panel = (Panel) getChild(listPanel);
	}
}
