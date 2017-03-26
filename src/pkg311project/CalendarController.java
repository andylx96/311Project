/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ajl5735
 */
public class CalendarController {

    CalendarModel calendar_model;
    CalendarFrame calendar_frame;
    CalendarPanel calendar_panel;
    MainMenuController mm_controller;
    CalendarAppointView calendar_appoint_view;

    CalendarController(CalendarModel calendar_model, CalendarFrame calendar_frame) {
        this.calendar_model = calendar_model;
        this.calendar_frame = calendar_frame;
        calendar_appoint_view = new CalendarAppointView();

        calendar_frame.getPanel().getCalendar_view().getAppointments().addActionListener(new AppointmentButtonListener());
        calendar_appoint_view.getCreateAppoint().addActionListener(new CalendarCreateButtonListener());
        
//        c_view.getCalendar().addActionListener(new CalendarButton());
    }

    public void hi() {
        System.out.println("HELLO");
    }

    class AppointmentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            calendar_frame.getPanel().getCalendar_view().getAppointments().setVisible(false);
            calendar_frame.getPanel().getCalendar_view().getCalendar().setVisible(true);
            System.out.println("saved");

            calendar_frame.switchToCalendarAppointView(calendar_appoint_view);

        }
    }

    class CalendarCreateButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            calendar_appoint_view.getStatus().setText("Account Created!");
        }
    }

}
