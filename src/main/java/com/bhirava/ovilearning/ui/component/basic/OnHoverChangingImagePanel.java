package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.constants.UIConstants;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.event.OnHoverImageChanger;

public class OnHoverChangingImagePanel extends Panel {
    private static final long serialVersionUID = 1L;

    public OnHoverChangingImagePanel(String name, String imagePath, String hoverImagePath, Rectangle bounds, Panel parentPanel, MainPanel mainPanel) {
        super(name, bounds, parentPanel, mainPanel);
        setBackground(UIConstants.Styles.TRANSPARENT_COLOR);
        Icon image = new ImageIcon(Toolkit.getDefaultToolkit().createImage(imagePath));
        Icon hoverImage = new ImageIcon(Toolkit.getDefaultToolkit().createImage(hoverImagePath));
        JLabel imageLabel = new JLabel(image);
        imageLabel.setBounds(0, 0, bounds.width, bounds.height);
        imageLabel.setBackground(UIConstants.Styles.TRANSPARENT_COLOR);
        addChild(ChildName.General.IMAGE.name(), imageLabel);
        addMouseListener(new OnHoverImageChanger(imageLabel, image, hoverImage));
    }
}