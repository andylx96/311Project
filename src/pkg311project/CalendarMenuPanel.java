/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author zabuz
 */
public class CalendarMenuPanel extends JPanel {

    JButton createAppt, calendar, appointment;

    CalendarMenuPanel() {

        createAppt = new JButton("Create Appointment");
        calendar = new JButton("Calendar");
        appointment = new JButton("Appointments");
        add(appointment);
        add(createAppt);

        add(calendar);
    }

    public JButton getAppointments() {
        return createAppt;
    }

    public void setAppointments(JButton appointments) {
        this.createAppt = appointments;
    }

    public JButton getCalendar() {
        return calendar;
    }

    public void setCalendar(JButton calendar) {
        this.calendar = calendar;
    }

    public JButton getMain() {
        return appointment;
    }

    public void setMain(JButton main) {
        this.appointment = main;
    }
}
