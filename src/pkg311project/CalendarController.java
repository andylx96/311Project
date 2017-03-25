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
    CalendarView Calendar_view;
    CalendarModel calendar_model;
    CalendarFrame calendar_frame;
//    MainMenuController mm_controller;
    
    CalendarController(CalendarModel calandar_model, CalendarFrame calandar_frame){
        this.calendar_model = calendar_model;
        this.calendar_frame = calendar_frame;
        Calendar_view = new CalendarView();
        
//        Calendar_view.getAppointments().addActionListener(new AppointmentButton());
//        c_view.getCalendar().addActionListener(new CalendarButton());
    }
    
    }

//    class AppointmentButton implements ActionListener {
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            Calendar_view.getAppointments().setVisible(false);
//            Calendar_view.getCalendar().setVisible(true);
//            System.out.println("saved");
//        }
//    }

    class CalendarButton implements ActionListener {
        public void actionPerformed(ActionEvent e){
            
        }
    }

