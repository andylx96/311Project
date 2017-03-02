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
    MainMenuView main_view;
    LoginView log_view;
    CalendarModel calendar_model;
    CalendarFrame calendar_frame;
    CalendarController calendar_controller;
    CalendarView calendar_view;
    
    
    

    public MainMenuController(MainMenuViewModel n_model, MainMenuFrame n_frame) throws Throwable {
        this.n_model = n_model;
        this.n_frame = n_frame;
        main_view = new MainMenuView();
//        log_view = new LoginView();

  
        main_view.getContactsButton().addActionListener(new ContactsButtonListener());
        n_frame.getMain_panel().getLog_view().getLoginButton().addActionListener(new LoginButtonListener());
        main_view.getCalendarButton().addActionListener(new CalendarButtonListener());
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
    
        class CalendarButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            {

                calendar_model = new CalendarModel();
                calendar_frame = new CalendarFrame(calendar_model);
                calendar_controller = new CalendarController(calendar_model, calendar_frame);
                calendar_frame.setVisible(true);

            }
        }

    }

    class LoginButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            {
                n_frame.switchToMainView(main_view);

            }
        }

    }

}
