package com.bhirava.ovilearning.ui.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.bhirava.ovilearning.constants.PageName;
import com.bhirava.ovilearning.ui.component.MainPanel;
import com.bhirava.ovilearning.ui.component.basic.TextBox;

public class LoginButtonActionListener implements ActionListener {

    private TextBox emailBox;
    private TextBox pwdBox;
    private MainPanel mainPanel;

    public LoginButtonActionListener(TextBox emailBox, TextBox pwdBox, MainPanel mainPanel) {
        this.emailBox = emailBox;
        this.pwdBox = pwdBox;
        this.mainPanel = mainPanel;
    }

    public void actionPerformed(ActionEvent e) {
        if (emailBox.getText() != null && emailBox.getText().equalsIgnoreCase("abhii4you@gmail.com") && pwdBox.getText() != null && pwdBox.getText().equalsIgnoreCase("12345678")) {
            mainPanel.setPage(PageName.VIDEO_LIST_PAGE);
        }
    }

}
