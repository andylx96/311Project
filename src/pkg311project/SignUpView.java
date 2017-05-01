/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author zabuz
 */
public class SignUpView extends JPanel {

    JTextArea username, password;
    JButton signUpButton;

    GridBagConstraints gbc = new GridBagConstraints();

    SignUpView() {

        setLayout(new GridBagLayout());
        username = new JTextArea("Username");
        password = new JTextArea("Password");
        signUpButton = new JButton("Sign Up");

        setBackground(Color.WHITE);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        
        username.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        password.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        gbc.insets = new Insets(1, 1, 1, 1);

        gbc.fill = GridBagConstraints.HORIZONTAL;

       
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(username, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(password, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.ipady = 10;
        add(signUpButton, gbc);

    }


    public JTextArea getUsername() {
        return username;
    }

    public void setUsername(JTextArea username) {
        this.username = username;
    }

    public JTextArea getPassword() {
        return password;
    }

    public void setPassword(JTextArea password) {
        this.password = password;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }
    
    
}

