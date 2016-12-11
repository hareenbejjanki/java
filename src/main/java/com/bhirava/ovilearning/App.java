package com.bhirava.ovilearning;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import com.bhirava.ovilearning.ui.component.MainFrame;
import com.bhirava.ovilearning.ui.util.PropertyValues;

/**
 *
 * @author Hareen Bejjanki
 */

public class App extends javax.swing.JPanel {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        try {
            MainFrame mainFrame = new MainFrame(getPropertyValues());
            // TODO bellow line set set the Window Size to maximised, Will uncomment soon
            // mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            mainFrame.shakeOnce();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static PropertyValues getPropertyValues() throws FileNotFoundException, IOException {
        String pathPrefix = System.getenv("OVILEARNING_HOME");

        if (pathPrefix == null || pathPrefix.isEmpty()) {
            throw new IllegalStateException("Environment variable 'OVILEARNING_HOME' not set!");
        }

        Properties positionProperties = new Properties();
        Properties stylesProperties = new Properties();
        Properties otherProperties = new Properties();
        Properties textAndPathsProperties = new Properties();
        Properties generalProperties = new Properties();
        positionProperties.load(new FileInputStream(new File(pathPrefix + "properties/ui.position.properties")));
        stylesProperties.load(new FileInputStream(new File(pathPrefix + "properties/ui.styles.properties")));
        textAndPathsProperties.load(new FileInputStream(new File(pathPrefix + "properties/ui.text.path.properties")));
        otherProperties.load(new FileInputStream(new File(pathPrefix + "properties/ui.other.properties")));
        generalProperties.load(new FileInputStream(new File(pathPrefix + "properties/general.properties")));

        return new PropertyValues(positionProperties, stylesProperties, textAndPathsProperties, otherProperties, generalProperties);
    }

}