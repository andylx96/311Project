package pkg311project;

import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainMenuFrame extends JFrame {

    MainMenuViewModel model;
    MainMenuView nVpanel;

    MainMenuFrame(MainMenuViewModel model) {
        super("Contact Manager And Calender");
        this.model = model;

        setSize(700, 500);
        nVpanel = new MainMenuView();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(nVpanel);
    }

//    public void switchToCreateMasterLoginViewPanel(CreateMasterLoginView createMasterLogin_view) {
//        nVpanel.removeSplash();
//        nVpanel.removeMaster();
//        nVpanel.removeCreate();
//        nVpanel.removeSearch();
//        nVpanel.removeViewAll();
//        nVpanel.removeCreateMasterLoginView();
//        nVpanel.addCreateMasterLoginView(createMasterLogin_view);
//    }
//
//    public void addMasterButtonListener(ActionListener al) {
//        nVpanel.menu.loginButton.addActionListener(al);
//    }
}
