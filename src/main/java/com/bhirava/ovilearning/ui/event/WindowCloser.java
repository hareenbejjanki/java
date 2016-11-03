package com.bhirava.ovilearning.ui.event;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.bhirava.ovilearning.ui.component.MainFrame;

public class WindowCloser implements WindowListener {
	private MainFrame mainFrame;

	public WindowCloser(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowClosing(WindowEvent e) {
		mainFrame.dispose();
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

}
