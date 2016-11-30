package com.bhirava.ovilearning.ui.util;

import java.awt.Font;

import javax.swing.JLabel;

import com.bhirava.ovilearning.constants.Constants;

public class ComponentUtil {

    public static int getPreferedHeightByLabel(Font font) {
        JLabel label = new JLabel(Constants.General.DUMMY_TEXT);
        label.setFont(font);
        return label.getPreferredSize().height;
    }

}
