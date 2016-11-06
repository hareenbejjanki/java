package com.bhirava.ovilearning;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.bhirava.ovilearning.ui.component.MainFrame;

/**
 *
 * @author Hareen Bejjanki
 */

public class App extends javax.swing.JPanel {
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Properties uiPositionProperties = new Properties();
		Properties uiStylesProperties = new Properties();
		Properties uiOtherProperties = new Properties();
		Properties generalProperties = new Properties();
		String pathPrefix = System.getenv("OVILEARNING_HOME");

		try {
			uiPositionProperties.load(new FileInputStream(new File(pathPrefix + "properties/ui.position.properties")));
			uiStylesProperties.load(new FileInputStream(new File(pathPrefix + "properties/ui.styles.properties")));
			uiOtherProperties.load(new FileInputStream(new File(pathPrefix + "properties/ui.other.properties")));
			generalProperties.load(new FileInputStream(new File(pathPrefix + "properties/general.properties")));
			MainFrame mainFrame = new MainFrame(uiPositionProperties, uiStylesProperties, uiOtherProperties, generalProperties);
			// TODO bellow line set set the Window Size to maximised, Will uncomment soon
//			mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			mainFrame.shakeOnce();
		} catch (Exception e) {
		    e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

}