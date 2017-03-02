/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author zabuz
 */
public class LoginView extends JPanel {

    JLabel hi;
    JTextArea username, password;
    JButton loginButton;

    public LoginView() {
        setLayout(new GridLayout(10, 1));
        hi = new JLabel("hi");
        loginButton = new JButton("Login");
        username = new JTextArea("Username");
        password = new JTextArea("Password");

        add(hi);
        add(username);
        add(password);
        add(loginButton);
    }

    public JLabel getHi() {
        return hi;
    }

    public void setHi(JLabel hi) {
        this.hi = hi;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(JButton loginButton) {
        this.loginButton = loginButton;
    }

}
