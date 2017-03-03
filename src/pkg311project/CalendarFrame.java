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
    
    public CalendarFrame(CalendarModel model){
    super("Calendar");
    this.model = model;
    
       setSize(700, 500);
        panel = new CalendarPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panel);
    
    }

    public CalendarPanel getPanel() {
        return panel;
    }

    public void setPanel(CalendarPanel panel) {
        this.panel = panel;
    }
        public void switchToCalendar(CalendarView calendar_view) {
   panel.removeCalendarView();
   panel.addCalendarView(calendar_view);
    }
}