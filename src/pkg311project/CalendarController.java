/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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

        calendar_frame.getPanel().getCalendar_menuPanel().getAppointments().addActionListener(new SwitchToAppointmentButtonListener());
        calendar_appoint_view.getCreateAppoint().addActionListener(new CalendarCreateButtonListener());
        calendar_frame.getPanel().getCalendar_menuPanel().getCalendar().addActionListener(new CalendarButtonListener());
        calendar_frame.getPanel().getCalendar_menuPanel().getMain().addActionListener(new SwitchToMainCalendarButtonListener());
        
    }


    class SwitchToAppointmentButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {


            calendar_frame.switchToCalendarAppointView(calendar_appoint_view);


        }
    }


    class CalendarCreateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
            calendar_appoint_view.getStatus().setText("Account Created!");
        }
    }

    class CalendarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            JOptionPane.showMessageDialog(null, "Not Supported Yet");
        }
    }
    
        class SwitchToMainCalendarButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            calendar_frame.switchToCalendar(calendar_frame.getPanel().getCalendar_view());
        }
    }

    }