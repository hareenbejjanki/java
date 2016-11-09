package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.HashMap;

import javax.swing.JPanel;

import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.event.OnClickFocus;

public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;

	private String panelName;
	protected Panel parentPanel;	
	protected MainPanel mainPanel;
	protected HashMap<String, Component> childComponents;

	public String getPanelName() {
        return panelName;
    }

	public Panel getParentPanel() {
		return parentPanel;
	}

	public MainPanel getMainPanel() {
        return mainPanel;
    }

	public HashMap<String, Component> getChildComponents() {
		return childComponents;
	}

    public void addChild(String name, Component child) {
		childComponents.put(name, child);
		add(child);
	}

	public Component getChild(String name) {
		return childComponents.get(name);
	}

	public void removeChild(String name) {
		if (childComponents.containsKey(name)) {
			remove(childComponents.remove(name));
		}
	}

	public Panel(String panelName, Rectangle bounds, Panel parentPanel, MainPanel mainPanel) {
        this.panelName = panelName;
        this.mainPanel = mainPanel;
        this.parentPanel = parentPanel;
        this.childComponents = new HashMap<String, Component>();

        setLayout(null);
        if (bounds != null) {
            setBounds(bounds);
        }
        addMouseListener(new OnClickFocus(this));
    }

    public void makeVerticallyCenterPositioned(int x) {
        Dimension size = getPreferredSize();
        int y = (int) parentPanel.getHeight() / 2 - size.height / 2;
        setBounds(x, y, size.width, size.height);
    }

	public void makeCenterPositioned() {
	    Dimension size = getSize();
        int x = (int) parentPanel.getWidth() / 2 - size.width / 2;
        int y = (int) parentPanel.getHeight() / 2 - size.height / 2;
        setBounds(x, y, size.width, size.height);
	}

	public void distroy() {
	    for (String childKey : childComponents.keySet()) {
            Component child = childComponents.get(childKey);
            if (child instanceof Panel) {
                ((Panel) child).distroy();
            } else {
                remove(child);
            }
        }

	    if (parentPanel != null) {
	        parentPanel.childComponents.remove(panelName);
	        parentPanel.remove(this);
	    }
	}
}