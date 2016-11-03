package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.HashMap;

import javax.swing.JPanel;

import com.bhirava.ovilearning.ui.event.OnClickFocus;

public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;

	protected Panel parentComponent;
	protected HashMap<String, Component> childComponents;

	public Panel getParentComponent() {
		return parentComponent;
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

	public Panel(Panel parentComponent, Rectangle bounds) {
	    this.parentComponent = parentComponent;
	    setLayout(null);
        this.childComponents = new HashMap<String, Component>();
        if (bounds != null) {
            setBounds(bounds);
        }
        addMouseListener(new OnClickFocus(this));
	}

    public void makeVerticallyCenterPositioned(int x) {
        Dimension size = getPreferredSize();
        int y = (int) parentComponent.getHeight() / 2 - size.height / 2;
        setBounds(x, y, size.width, size.height);
    }

	public void makeCenterPositioned() {
	    Dimension size = getSize();
        int x = (int) parentComponent.getWidth() / 2 - size.width / 2;
        int y = (int) parentComponent.getHeight() / 2 - size.height / 2;
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

	    if (parentComponent != null) {
	        parentComponent.remove(this);
	    }
	}
}