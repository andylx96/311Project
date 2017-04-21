/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
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
    CalendarOverView calendar;

    ArrayList<Appointment> appointmentList = new ArrayList();

    CalendarController(CalendarModel calendar_model, CalendarFrame calendar_frame) {

        this.calendar_model = calendar_model;
        this.calendar_frame = calendar_frame;
        calendar_appoint_view = new CalendarAppointView();

        calendar_frame.getPanel().getCalendar_menuPanel().getAppointments().addActionListener(new SwitchToAppointmentButtonListener());
        calendar_appoint_view.getCreateAppoint().addActionListener(new CalendarCreateButtonListener());
        calendar_frame.getPanel().getCalendar_menuPanel().getCalendar().addActionListener(new CalendarButtonListener());
        calendar_frame.getPanel().getCalendar_menuPanel().getMain().addActionListener(new SwitchToMainCalendarButtonListener());
        calendar_frame.getPanel().getCalendar_view().getSave().addActionListener(new AppointmentSaveButtonListener());
        updateArrayAndTable();
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
//            appointmentList.add(new Appointment(calendar_appoint_view.getAppoint_name().toString(), calendar_appoint_view.getAppoint_startTime().toString(),
//                    calendar_appoint_view.getAppoint_endTime().toString()));

            FileWriter fout;
            try {
                fout = new FileWriter("src/pkg311project/appointment.txt", true);
                fout.write(calendar_appoint_view.getAppoint_name().getText() + "\n");
                fout.write(calendar_appoint_view.getAppoint_startTime().getText() + "\n");
                fout.write(calendar_appoint_view.getAppoint_endTime().getText() + "\n");

                fout.close();
                fout.flush();
            } catch (IOException ex) {
            }

            updateArrayAndTable();
        }
    }

    class CalendarButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            
            calendar_frame.switchToCalendar(calendar);
            //JOptionPane.showMessageDialog(null, "Not Supported Yet");
        }
    }

    class SwitchToMainCalendarButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            calendar_frame.switchToCalendarView(calendar_frame.getPanel().getCalendar_view());
        }
    }

    class AppointmentSaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            calendar_frame.switchToCalendarView(calendar_frame.getPanel().getCalendar_view());

            tableToFile(-1);
            updateArrayAndTable();

        }
    }

    public void updateArrayAndTable() {

        String tempName, tempStart, tempEnd;
        appointmentList.clear();
        calendar_frame.getPanel().getCalendar_view().getModel().setRowCount(0);
        try {
            FileReader fin;
            fin = new FileReader("src/pkg311project/appointment.txt");
            Scanner scan = new Scanner(fin);
            while (scan.hasNextLine()) {

                tempName = scan.nextLine();
                tempStart = scan.nextLine();
                tempEnd = scan.nextLine();

                appointmentList.add(new Appointment(tempName, tempStart, tempEnd));

                calendar_frame.getPanel().getCalendar_view().getModel().addRow(new Object[]{tempName, tempStart, tempEnd});

            }
            fin.close();
            calendar_frame.getPanel().getCalendar_view().getTable().setModel(calendar_frame.getPanel().getCalendar_view().getTable().getModel());

        } catch (FileNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
        }
    }

    public void tableToFile(int tempRow) {

//        if (calendar_frame.getPanel().getCalendar_view().getTable().getSelectedRow() != -1) {
//            String tempString = calendar_frame.getPanel().getCalendar_view().getSearchArea().getText();
//            calendar_frame.getPanel().getCalendar_view().getSearchArea().setText("");
        FileWriter fout;
        try {
            fout = new FileWriter("src/pkg311project/appointment.txt");
            for (int i = 0; i < calendar_frame.getPanel().getCalendar_view().getTable().getRowCount(); i++) {

                for (int j = 0; j < calendar_frame.getPanel().getCalendar_view().getTable().getColumnCount(); j++) {

                    if (i != tempRow) {
                        fout.write(calendar_frame.getPanel().getCalendar_view().getTable().getValueAt(i, j) + "\n");
                    }
                }
            }
//                viewAll_view.getSearchArea().setText(tempString);
//                c_view.getCreateAccount().setText("Account Created");
            fout.close();
            fout.flush();
        } catch (IOException ex) {
        }

    }
//    }

}
