/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ajl5735
 */
public class CalendarController {

    CalendarModel calendar_model;
    CalendarFrame calendar_frame;
    CalendarPanel calendar_panel;
    MainMenuController mm_controller;
    CalendarCreateAppointView calendar_appoint_view;
    CalendarOverView calendar;
    String currentUsersName;

    ArrayList<Appointment> appointmentList = new ArrayList();

    CalendarController(CalendarModel calendar_model, CalendarFrame calendar_frame, String username) {

        this.calendar_model = calendar_model;
        this.calendar_frame = calendar_frame;
        calendar_appoint_view = new CalendarCreateAppointView();
        calendar = new CalendarOverView();
        setCurrentUsersName(username);
        calendar_frame.getPanel().getCalendar_menuPanel().getAppointments().addActionListener(new SwitchToAppointmentButtonListener());
        calendar_appoint_view.getCreateAppoint().addActionListener(new CalendarCreateButtonListener());
        calendar_frame.getPanel().getCalendar_menuPanel().getCalendar().addActionListener(new CalendarButtonListener());
        calendar_frame.getPanel().getCalendar_menuPanel().getMain().addActionListener(new SwitchToMainCalendarButtonListener());
        calendar_frame.getPanel().getCalendar_view().getSave().addActionListener(new AppointmentSaveButtonListener());

        calendar_frame.getPanel().getCalendar_view().getDelete().addActionListener(new AppointmentDeleteButtonListener());
        calendar_frame.getPanel().getCalendar_view().getFilter().getDocument().addDocumentListener(new SearchDocumentListener());
        calendar.getBtnPrev().addActionListener(new btnPrev_Action());
        calendar.getBtnNext().addActionListener(new btnNext_Action());
        calendar.getCmbYear().addActionListener(new cmbYear_Action());
        updateArrayAndTable();

        //Refresh calendar
        refreshCalendar(calendar.realMonth, calendar.realYear); //Refresh calendar

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
                fout = new FileWriter(String.format("src/appointments/%s.txt", getCurrentUsersName()), true);
                fout.write(calendar_appoint_view.getAppoint_name().getText() + "\n");
                fout.write(calendar_appoint_view.getDateMonth().getText() + "\n");
                fout.write(calendar_appoint_view.getDateDay().getText() + "\n");
                fout.write(calendar_appoint_view.getDateYear().getText() + "\n");
                fout.write(calendar_appoint_view.getAppoint_startTime().getText() + "\n");
                fout.write(calendar_appoint_view.getAm_pm_startCombo().getSelectedItem().toString() + "\n");
                fout.write(calendar_appoint_view.getAppoint_endTime().getText() + "\n");
                fout.write(calendar_appoint_view.getAm_pm_endCombo().getSelectedItem().toString() + "\n");
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
//            displayTasks(appointmentList);
            //JOptionPane.showMessageDialog(null, "Not Supported Yet");
            loadAppointmentsToCal();
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
            JOptionPane.showMessageDialog(null, "Saved!");

        }
    }

    class AppointmentDeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            calendar_frame.switchToCalendarView(calendar_frame.getPanel().getCalendar_view());

            int resp = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete This Line?\nThis Will Also Save All Changes Done So Far.");
            if (resp == JOptionPane.YES_OPTION) {
                int tempRow = calendar_frame.getPanel().getCalendar_view().getTable().convertRowIndexToModel(calendar_frame.getPanel().getCalendar_view().getTable().getSelectedRow());
                tableToFile(tempRow);
                updateArrayAndTable();
            }
            JOptionPane.showMessageDialog(null, "Deleted!");

        }
    }

    public void updateArrayAndTable() {

        String tempName, tempDateMonth, tempDateDay, tempDateYear, tempStart, tempStartAmPm, tempEnd, tempEndAmPm;

        appointmentList.clear();
        calendar_frame.getPanel().getCalendar_view().getModel().setRowCount(0);
        try {
            FileReader fin;

            fin = new FileReader(String.format("src/appointments/%s.txt", getCurrentUsersName()));
            Scanner scan = new Scanner(fin);
            while (scan.hasNextLine()) {

                tempName = scan.nextLine();
                tempDateMonth = scan.nextLine();
                tempDateDay = scan.nextLine();
                tempDateYear = scan.nextLine();
                tempStart = scan.nextLine();
                tempStartAmPm = scan.nextLine();
                tempEnd = scan.nextLine();
                tempEndAmPm = scan.nextLine();

                appointmentList.add(new Appointment(tempName, tempDateMonth, tempDateDay, tempDateYear, tempStart, tempStartAmPm, tempEnd, tempEndAmPm));

                calendar_frame.getPanel().getCalendar_view().getModel().addRow(new Object[]{tempName, tempDateMonth, tempDateDay, tempDateYear, tempStart, tempStartAmPm, tempEnd, tempEndAmPm});

            }
            fin.close();
            calendar_frame.getPanel().getCalendar_view().getTable().setModel(calendar_frame.getPanel().getCalendar_view().getTable().getModel());

        } catch (FileNotFoundException ex) {

            JOptionPane.showMessageDialog(null, "No Appointments Were Found!");
        } catch (IOException ex) {
        }
    }

    public void tableToFile(int tempRow) {

//        if (calendar_frame.getPanel().getCalendar_view().getTable().getSelectedRow() != -1) {
//            String tempString = calendar_frame.getPanel().getCalendar_view().getSearchArea().getText();
//            calendar_frame.getPanel().getCalendar_view().getSearchArea().setText("");
        FileWriter fout;
        try {
            fout = new FileWriter(String.format("src/appointments/%s.txt", getCurrentUsersName()));
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

    class SearchDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e
        ) {
            String text = calendar_frame.getPanel().getCalendar_view().getFilter().getText();
            if (text.trim().length() == 0) {
                calendar_frame.getPanel().getCalendar_view().getRowSorter().setRowFilter(null);
            } else {
                calendar_frame.getPanel().getCalendar_view().getRowSorter().setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e
        ) {
            String text = calendar_frame.getPanel().getCalendar_view().getFilter().getText();
            if (text.trim().length() == 0) {
                calendar_frame.getPanel().getCalendar_view().getRowSorter().setRowFilter(null);
            } else {
                calendar_frame.getPanel().getCalendar_view().getRowSorter().setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            JOptionPane.showMessageDialog(null, "Not supported yet.");
        }
    }
//    }

    public void refreshCalendar(int month, int year) {
        //Variables
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int nod, som; //Number Of Days, Start Of Month

        //Allow/disallow buttons
        calendar.btnprev.setEnabled(true);
        calendar.btnnext.setEnabled(true);
        if (month == 0 && year <= calendar.realYear - 10) {
            calendar.btnprev.setEnabled(false);
        } //Too early
        if (month == 11 && year >= calendar.realYear + 100) {
            calendar.btnnext.setEnabled(false);
        } //Too late
        calendar.Month.setText(months[month]); //Refresh the month label (at the top)
        calendar.Month.setBounds(160 - calendar.Month.getPreferredSize().width / 2, 25, 180, 25); //Re-align label with calendar
        calendar.cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box

        //Clear table
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                calendar.mtblCalendar.setValueAt(null, i, j);
            }
        }

        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);

        //Draw calendar
        for (int i = 1; i <= nod; i++) {
            int row = new Integer((i + som - 2) / 7);
            int column = (i + som - 2) % 7;
            calendar.mtblCalendar.setValueAt(i, row, column);

        }

        //Apply renderers
        calendar.tblCalendar.setDefaultRenderer(calendar.tblCalendar.getColumnClass(0), new tblCalendarRenderer());
        loadAppointmentsToCal();
        calendar_frame.switchToCalendar(calendar);
    }

//    public void displayTasks(ArrayList<Appointment> ApptList) {
//        ApptList.clear();
//        ArrayList<Appointment> AptListNull = new ArrayList<Appointment>();
//        ArrayList<Appointment> AptListDate = new ArrayList<Appointment>();
//
//        for (int i = 0; i < ApptList.size(); i++) {
//            if (ApptList.get(i).getDate() == null) {
//                AptListNull.add(ApptList.get(i));
//            } else {
//                int taskArrayYear = Integer.valueOf(ApptList.get(i).getDate().substring(0, 4));
//                int taskArrayMonth = Integer.valueOf(ApptList.get(i).getDate().substring(5, 7));
//                int taskArrayDay = Integer.valueOf(ApptList.get(i).getDate().substring(8, 10));
//                if (AptListDate.size() == 0) {
//                    AptListDate.add(ApptList.get(i));
//                }
//                for (int j = 0; j < AptListDate.size(); j++) {
//                    int taskArrayDateYear = Integer.valueOf(AptListDate.get(j).getDate().substring(0, 4));
//                    int taskArrayDateMonth = Integer.valueOf(AptListDate.get(j).getDate().substring(5, 7));
//                    int taskArrayDateDay = Integer.valueOf(AptListDate.get(j).getDate().substring(8, 10));
//                    if (taskArrayDateYear <= taskArrayYear) {
//                        if (taskArrayDateYear < taskArrayYear) {
//                            AptListDate.add(j, ApptList.get(i));
//                            break;
//                        } else {
//                            if (taskArrayDateMonth <= taskArrayMonth) {
//                                if (taskArrayDateYear < taskArrayYear) {
//                                    AptListDate.add(j, ApptList.get(i));
//                                    break;
//                                } else {
//                                    if (taskArrayDateDay <= taskArrayDay) {
//                                        AptListDate.add(j, ApptList.get(i));
//                                        break;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < AptListDate.size(); i++) {
//            calendar.mtblCalendar.setValueAt((AptListDate.get(i)), 0, i);
//        }
//        for (int i = 0; i < AptListNull.size(); i++) {
//            calendar.mtblCalendar.setValueAt((AptListNull.get(i)), 0, i);
//        }
//    }
    class tblCalendarRenderer extends DefaultTableCellRenderer {

        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6) { //Week-end
                setBackground(new Color(255, 255, 255));
            }

            if (value != null) {
                if (Integer.parseInt(value.toString()) == calendar.realDay && calendar.cMonth == calendar.realMonth && calendar.cYear == calendar.realYear) { //Today
                    setBackground(new Color(150, 255, 150));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }

    class btnPrev_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (calendar.cMonth == 0) { //Back one year
                calendar.cMonth = 11;
                calendar.cYear -= 1;
            } else { //Back one month
                calendar.cMonth -= 1;
            }
            refreshCalendar(calendar.cMonth, calendar.cYear);
        }
    }

    class btnNext_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (calendar.cMonth == 11) { //Foward one year
                calendar.cMonth = 0;
                calendar.cYear += 1;
            } else { //Foward one month
                calendar.cMonth += 1;
            }
            refreshCalendar(calendar.cMonth, calendar.cYear);
        }
    }

    class cmbYear_Action implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (calendar.cmbYear.getSelectedItem() != null) {
                String b = calendar.cmbYear.getSelectedItem().toString();

                calendar.cYear = Integer.parseInt(b);
                refreshCalendar(calendar.cMonth, calendar.cYear);
            }
        }
    }

    public String getCurrentUsersName() {
        return currentUsersName;
    }

    public void setCurrentUsersName(String currentUsersName) {
        this.currentUsersName = currentUsersName;
    }

    public void loadAppointmentsToCal() {
//                appointmentList.add(new Appointment(tempName, tempDateMonth, tempDateDay, tempDateYear, tempStart, tempStartAmPm, tempEnd, tempEndAmPm));
//
        for (int i = 0; i < appointmentList.size(); i++) {
//            System.out.println(appointmentList.get(i));
            if (calendar.getCmbYear().getSelectedItem().toString().equalsIgnoreCase(appointmentList.get(i).getDateYear())) {
//                System.out.println(calendar.getCmbYear().getSelectedItem().toString());
//                System.out.println(appointmentList.get(i).getDateYear());
                System.out.println("dupe");
                if (calendar.getMonth().getText().equalsIgnoreCase(appointmentList.get(i).getDateMonth())) {
                    System.out.println("month due");
                }

//                if(){}
//                appointmentList.get(i).getDateDay()
                for (int k = 0; k < calendar_frame.getPanel().getCalendar_view().getTable().getRowCount(); k++) {

                    for (int j = 0; j < calendar_frame.getPanel().getCalendar_view().getTable().getColumnCount(); j++) {

                        if (appointmentList.get(i).getDateDay().equalsIgnoreCase(
                                calendar_frame.getPanel().getCalendar_view().getTable().getValueAt(k, j).toString())) {
                            System.out.println("triple dubs");
                            calendar_frame.getPanel().getCalendar_view().getTable().setValueAt("Special Event",k, j);
                            
                        }
//                            fout.write(calendar_frame.getPanel().getCalendar_view().getTable().getValueAt(i, j) + "\n");
                    }
                }

            }

        }

    }
}
