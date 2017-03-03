/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author zabuz
 */
public class LoginView extends JPanel {

    JLabel loginStatus, hint;
    JTextArea username, password;
    JButton loginButton;
    JComboBox<String> usernameCombo;
    
    
    public LoginView() {
        setLayout(new GridLayout(10, 3));
        loginStatus = new JLabel("Please Login.");
        loginButton = new JButton("Login");
        username = new JTextArea("Username");
        password = new JTextArea("Password");
        hint = new JLabel("The Default Username and Password is, Username/Password");
        usernameCombo = new JComboBox();
     
        
        add(loginStatus);
        add(hint);
        add(username);
        add(password);
        add(loginButton);
        add(usernameCombo);
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

    public JComboBox getUsernameCombo() {
        return usernameCombo;
    }

    public void setUsernameCombo(JComboBox usernameCombo) {
        this.usernameCombo = usernameCombo;
    }

}
