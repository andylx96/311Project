package pkg311project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {

    MainMenuViewModel n_model;
    MainMenuFrame n_frame;
    ContactsModel contacts_model;
    ContactsFrame contacts_frame;
    ContactsController contacts_controller;
    ContactsView contacts_view;
    MainMenuView n_view;

    public MainMenuController(MainMenuViewModel n_model, MainMenuFrame n_frame) throws Throwable {
        this.n_model = n_model;
        this.n_frame = n_frame;
        n_frame.getnVpanel().getContactsButton().addActionListener(new ContactsButtonListener());

    }

    class ContactsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            {

                contacts_model = new ContactsModel();
                contacts_frame = new ContactsFrame(contacts_model);
                contacts_controller = new ContactsController(contacts_model, contacts_frame);

                contacts_frame.setVisible(true);

            }
        }

    }
}
