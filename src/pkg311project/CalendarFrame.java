/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import javax.swing.JFrame;

/**
 *
 * @author ajl5735
 */
public class CalendarFrame extends JFrame {

    CalendarModel model;
    CalendarPanel panel;

    public CalendarFrame(CalendarModel model) {
        super("Calendar");
        this.model = model;

        setSize(700, 500);
        panel = new CalendarPanel();
        setLocationRelativeTo(null);
        add(panel);

    }

    public CalendarPanel getPanel() {
        return panel;
    }

    public void setPanel(CalendarPanel panel) {
        this.panel = panel;
    }

    public void switchToCalendarView(CalendarView calendar_view) {

        panel.removeCalendarAppointView();
        panel.removeCalendarView();
        panel.addCalendarView(calendar_view);
    }

    public void switchToCalendarAppointView(CalendarAppointView cap_view) {

        panel.removeCalendarAppointView();
        panel.removeCalendarView();
        panel.addCalendarAppointView(cap_view);
    }

    public void switchToCalendar(CalendarOverView calendar) {

        panel.removeCalendarAppointView();
        panel.removeCalendarView();
        panel.addCalendar(calendar);
    }

}
