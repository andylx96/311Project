/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CalendarView extends JPanel {
    
    JButton appointments, calendar;

    public CalendarView() {
        appointments = new JButton("Appointments");
        calendar = new JButton("Calendar");
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
    
}
