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
    CalendarView c_view;
    MainMenuController mm_controller;
    
    CalendarController(CalendarModel calandar_model, CalendarFrame calandar_frame){
        c_view = new CalendarView();
        
        c_view.getAppointments().addActionListener(new AppointmentViewButton());
    }
    
    }
    class AppointmentViewButton implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            
        }
    
}
