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

    CalendarController(CalendarModel calendar_model, CalendarFrame calendar_frame) {
        this.calendar_model = calendar_model;
        this.calendar_frame = calendar_frame;

        
        
        calendar_frame.getPanel().getCalendar_view().getAppointments().addActionListener(new AppointmentButton());
//        calendar_frame.getPanel().getCalendar_view().getCalendar().addActionListener(new AppointmentButton());

//        c_view.getCalendar().addActionListener(new CalendarButton());
    }

    public void hi() {
        System.out.println("HELLO");
    }

    class AppointmentButton implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            calendar_frame.getPanel().getCalendar_view().getAppointments().setVisible(false);
            calendar_frame.getPanel().getCalendar_view().getCalendar().setVisible(true);
            System.out.println("saved");
        }
    }

    class CalendarButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

        }
    }

}
