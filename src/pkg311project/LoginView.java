/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author zabuz
 */
public class LoginView extends JPanel {

    JLabel hi;
    JButton loginButton;

    public LoginView() {
        hi = new JLabel("hi");
        loginButton = new JButton("Login");
        
        add(hi);
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
