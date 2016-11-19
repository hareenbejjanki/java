package com.bhirava.ovilearning.ui.component.basic;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;

import com.bhirava.ovilearning.constants.ChildName;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.event.OnHoverColorChanger;
import com.bhirava.ovilearning.ui.event.OnHoverImageChanger;

public class OnHoverChangingImageWithLabelPanel extends Panel {
    private static final long serialVersionUID = 1L;

    public OnHoverChangingImageWithLabelPanel(String name, String text, Font font, Color foreground, Color background, Color onHoverColor, int margin,
            String imagePath, String hoverImagePath, boolean imageSizeAsLabel, Rectangle bounds, Panel parentPanel, MainPanel mainPanel) {
        super(name, bounds, parentPanel, mainPanel);
        init(text, font, foreground, background, onHoverColor, margin, imagePath, hoverImagePath, imageSizeAsLabel, bounds);
    }

    private void init(String text, Font font, Color foreground, Color background, Color onHoverColor, int margin, String imagePath, String hoverImagePath, boolean imageSizeAsLabel, Rectangle bounds) {
        Label label = new Label(text, font, foreground, background, onHoverColor, this);
        setBounds(bounds, imageSizeAsLabel, label);
        OnHoverChangingImagePanel imagePanel = new OnHoverChangingImagePanel(ChildName.General.IMAGE.name(), imagePath, hoverImagePath, bounds, this, mainPanel);

        initProperties(imagePanel, label, bounds, margin);
        initEvents(imagePanel, label, foreground, onHoverColor);

        addChild(ChildName.General.LABEL.name(), label);
        addChild(ChildName.General.IMAGE.name(), imagePanel);
    }

    private void setBounds(Rectangle bounds, boolean imageSizeAsLabel, Label label) {
        if (imageSizeAsLabel) {
            bounds.height = label.getSize().height;
            bounds.width = label.getSize().height;
        }
    }

    private void initEvents(OnHoverChangingImagePanel imagePanel, Label label, Color foreground, Color onHoverColor) {
        addMouseListener(new OnHoverColorChanger(label, foreground, onHoverColor));
        imagePanel.addMouseListener(new OnHoverColorChanger(label, foreground, onHoverColor));
        addMouseListener(new OnHoverImageChanger(imagePanel, imagePanel.getImage(), imagePanel.getHoverImage()));
        label.addMouseListener(new OnHoverImageChanger(imagePanel, imagePanel.getImage(), imagePanel.getHoverImage()));
    }

    private void initProperties(OnHoverChangingImagePanel imagePanel, Label label, Rectangle bounds, int margin) {
        int height = label.getSize().height > bounds.height ? label.getSize().height : bounds.height;
        int imagePanelX = label.getSize().width + margin;
        imagePanel.makeVerticallyCenterPositioned(imagePanelX);
        label.makeVerticallyCenterPositioned(0);
        setSize(imagePanelX + bounds.width, height);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}
