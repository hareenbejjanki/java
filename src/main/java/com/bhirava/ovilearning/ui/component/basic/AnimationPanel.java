package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Rectangle;
import java.util.ArrayList;

import com.bhirava.ovilearning.ui.util.Animation;

public class AnimationPanel extends Panel {
	private static final long serialVersionUID = 1L;

	private ArrayList<Animation> animations;

	public ArrayList<Animation> getAnimations() {
		return animations;
	}

	public void setAnimations(ArrayList<Animation> animations) {
		this.animations = animations;
	}

	public AnimationPanel(Panel parentComponent, Rectangle bounds) {
		super(parentComponent, bounds);
	}
}