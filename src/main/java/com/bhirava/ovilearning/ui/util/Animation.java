package com.bhirava.ovilearning.ui.util;

import java.awt.Dimension;

public class Animation {
	private AnimationType animationType;
	private AnimationMode animationMode;
	private Dimension size;
	private Dimension animateToSize;

	public AnimationType getAnimationType() {
		return animationType;
	}

	public void setAnimationType(AnimationType animationType) {
		this.animationType = animationType;
	}

	public AnimationMode getAnimationMode() {
		return animationMode;
	}

	public void setAnimationMode(AnimationMode animationMode) {
		this.animationMode = animationMode;
	}

	public Dimension getSize() {
		return size;
	}

	public void setSize(Dimension size) {
		this.size = size;
	}

	public Dimension getAnimateToSize() {
		return animateToSize;
	}

	public void setAnimateToSize(Dimension animateToSize) {
		this.animateToSize = animateToSize;
	}
}
