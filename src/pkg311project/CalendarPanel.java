/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ajl5735
 */
public class CalendarPanel extends JPanel {

    CalendarView calendar_view;
    CalendarCreateAppointView cap_view;
    CalendarMenuPanel calendar_menuPanel;
    CalendarOverView calendar;


    public CalendarPanel() {
        setLayout(new BorderLayout());
        calendar_view = new CalendarView();
        calendar_menuPanel = new CalendarMenuPanel();
        add(calendar_view, BorderLayout.CENTER);
        add(calendar_menuPanel, BorderLayout.NORTH);
        

    }

    public CalendarCreateAppointView getCap_view() {
        return cap_view;
    }

    public void setCap_view(CalendarCreateAppointView cap_view) {
        this.cap_view = cap_view;
    }

    public CalendarMenuPanel getCalendar_menuPanel() {
        return calendar_menuPanel;
    }

    public void setCalendar_menuPanel(CalendarMenuPanel calendar_menuPanel) {
        this.calendar_menuPanel = calendar_menuPanel;
    }

    public void addCalendarView(CalendarView calendar_view) {
        this.calendar_view = calendar_view;
        add(calendar_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void removeCalendarView() {
        if (this.calendar_view != null) {
            this.remove(calendar_view);
        }
    }

    public void addCalendarAppointView(CalendarCreateAppointView cap_view) {
        this.cap_view = cap_view;
        add(cap_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    
    
    
    
    
    
    
    
      public void removeCalendar() {
        if (this.calendar != null) {
            this.remove(calendar);
        }
    }

    public void addCalendar(CalendarOverView calendar) {
        this.calendar = calendar;
        add(calendar, BorderLayout.CENTER);
        revalidate();
        repaint();
    }
    
    
    
    
    
    
    
    
    
    
    public void removeCalendarAppointView() {
        if (this.cap_view != null) {
            this.remove(cap_view);
        }
    }
    
    
    public CalendarView getCalendar_view() {
        return calendar_view;
    }

    public void setCalendar_view(CalendarView calendar_view) {
        this.calendar_view = calendar_view;
    }

}
