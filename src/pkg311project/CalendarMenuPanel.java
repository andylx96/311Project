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

    JButton appointments, calendar, main;

    CalendarMenuPanel() {

        appointments = new JButton("Appointments");
        calendar = new JButton("Calendar");
        main = new JButton("Main");
        add(main);
        add(appointments);

        add(calendar);
    }

    public JButton getAppointments() {
        return appointments;
    }

    public void setAppointments(JButton appointments) {
        this.appointments = appointments;
    }

    public JButton getCalendar() {
        return calendar;
    }

    public void setCalendar(JButton calendar) {
        this.calendar = calendar;
    }

    public JButton getMain() {
        return main;
    }

    public void setMain(JButton main) {
        this.main = main;
    }
}
