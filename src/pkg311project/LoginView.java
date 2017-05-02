/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
public class LoginView extends JPanel {

    JLabel loginStatus, hint;
    JTextArea username, password;
    JButton loginButton, signUpButton;
    JLabel userLabel, passLabel;

    GridBagConstraints gbc = new GridBagConstraints();

    public LoginView() {

        setLayout(new GridBagLayout());
        userLabel = new JLabel("Username");
        passLabel = new JLabel("Password");
        loginStatus = new JLabel("Please Login.");
        loginButton = new JButton("Login");
        username = new JTextArea("");
        password = new JTextArea("");
        hint = new JLabel("The Default Username and Password is, Username/Password");
        signUpButton = new JButton("Sign Up");

        setBackground(Color.WHITE);

        Border border = BorderFactory.createLineBorder(Color.BLACK);
        username.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        password.setBorder(BorderFactory.createCompoundBorder(border,
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        gbc.insets = new Insets(1, 1, 1, 1);

        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(loginStatus, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(hint, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(userLabel,gbc);
        gbc.gridx = 1;
        add(username, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(passLabel,gbc);
        gbc.gridx = 1;
        add(password, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.ipady = 10;
        add(loginButton, gbc);

        gbc.gridy = 5;
        add(signUpButton, gbc);
    }

    public JLabel getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(JLabel loginStatus) {
        this.loginStatus = loginStatus;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
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

    public JLabel getHint() {
        return hint;
    }

    public void setHint(JLabel hint) {
        this.hint = hint;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public void setSignUpButton(JButton signUpButton) {
        this.signUpButton = signUpButton;
    }

}
