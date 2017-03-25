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
    CalendarAppointView cap_view;

    public CalendarPanel() {
        setLayout(new BorderLayout());
        calendar_view = new CalendarView();
        add(calendar_view, BorderLayout.CENTER);

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

    public void addCalendarAppointView(CalendarAppointView cap_view) {
        this.cap_view = cap_view;
        add(cap_view, BorderLayout.CENTER);
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
