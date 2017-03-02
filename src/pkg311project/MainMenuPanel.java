/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author zabuz
 */
public class MainMenuPanel extends JPanel {

    MainMenuViewModel model;
    MainMenuFrame n_frame;
    ContactsModel contacts_model;
    ContactsFrame contacts_frame;
    ContactsController contacts_controller;
    ContactsView contacts_view;
    MainMenuView main_view;
    LoginView log_view;

    public MainMenuPanel() {
        setLayout(new BorderLayout());
        log_view = new LoginView();
        add(log_view, BorderLayout.CENTER);
    }

    public void addLogin(LoginView log_view) {
        this.log_view = log_view;
        add(log_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void addMainMenu(MainMenuView main_view) {
        this.main_view = main_view;
        add(main_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void removeMainMenu() {
        if (this.main_view != null) {
            remove(this.main_view);
        }
    }

    public void removeLogin() {
        if (this.log_view != null) {
            remove(this.log_view);
            System.out.println("deleted");
        }
    }

    public LoginView getLog_view() {
        return log_view;
    }

    public void setLog_view(LoginView log_view) {
        this.log_view = log_view;
    }

}
