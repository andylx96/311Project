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
    
    JButton appointments;

    public CalendarView() {
        appointments = new JButton("Appointments");
        add(appointments);
    }

    public JButton getAppointments() {
        return appointments;
    }

    public void setAppointments(JButton appointments) {
        this.appointments = appointments;
    }
    
    
}
