/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

/**
 *
 * @author Kiad
 */
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarOverView extends JPanel {

    JLabel Month, Year;
    JButton btnprev, btnnext;
    JTable tblCalendar;
    JComboBox cmbYear;
    DefaultTableModel mtblCalendar; //Table model
    JScrollPane stblCalendar; //The scrollpane
    JPanel pnlCalendar, topMenu;
    int realYear, realMonth, realDay, cYear, cMonth;

    CalendarOverView() {
        //Create controls
        Month = new JLabel("January");
        Year = new JLabel("");
        cmbYear = new JComboBox();
        btnprev = new JButton("<<");
        btnnext = new JButton(">>");
        mtblCalendar = new DefaultTableModel();

        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        topMenu = new JPanel();

        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        setLayout(new BorderLayout());

        topMenu.add(btnprev);

        topMenu.add(Month);
        topMenu.add(Year);
        topMenu.add(cmbYear);
        topMenu.add(btnnext);
        add(topMenu, BorderLayout.NORTH);
        add(stblCalendar, BorderLayout.CENTER);

        //Set bounds
        pnlCalendar.setBounds(0, 0, 320, 335);
        Month.setBounds(160 - Month.getPreferredSize().width / 2, 25, 100, 25);
        Year.setBounds(10, 305, 80, 20);
        cmbYear.setBounds(230, 305, 80, 20);
        btnprev.setBounds(10, 25, 50, 25);
        btnnext.setBounds(260, 25, 50, 25);
        stblCalendar.setBounds(10, 50, 300, 250);

        //Get real month/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        realMonth = cal.get(GregorianCalendar.MONTH); //Get month
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        cMonth = realMonth; //Match month and year
        cYear = realYear;
//		
//		//Add headers
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i = 0; i < 7; i++) {
            mtblCalendar.addColumn(headers[i]);
        }

        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background

        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);

        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //uneditable
//        tblCalendar.setDefaultEditor(Object.class, null);

        //Set row/column count
        tblCalendar.setRowHeight(58);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);

        //Populate table
        for (int i = realYear - 100; i <= realYear + 100; i++) {
            cmbYear.addItem(String.valueOf(i));
        }

    }

    public JLabel getMonth() {
        return Month;
    }

    public void setMonth(JLabel Month) {
        this.Month = Month;
    }

    public JLabel getYear() {
        return Year;
    }

    public void setYear(JLabel Year) {
        this.Year = Year;
    }

    public JButton getBtnprev() {
        return btnprev;
    }

    public void setBtnprev(JButton btnprev) {
        this.btnprev = btnprev;
    }

    public JButton getBtnnext() {
        return btnnext;
    }

    public void setBtnnext(JButton btnnext) {
        this.btnnext = btnnext;
    }

    public JPanel getTopMenu() {
        return topMenu;
    }

    public void setTopMenu(JPanel topMenu) {
        this.topMenu = topMenu;
    }

    public int getcYear() {
        return cYear;
    }

    public void setcYear(int cYear) {
        this.cYear = cYear;
    }

    public int getcMonth() {
        return cMonth;
    }

    public void setcMonth(int cMonth) {
        this.cMonth = cMonth;
    }

    public JLabel getLblMonth() {
        return Month;
    }

    public void setLblMonth(JLabel Month) {
        this.Month = Month;
    }

    public JLabel getLblYear() {
        return Year;
    }

    public void setLblYear(JLabel Year) {
        this.Year = Year;
    }

    public JButton getBtnPrev() {
        return btnprev;
    }

    public void setBtnPrev(JButton btnprev) {
        this.btnprev = btnprev;
    }

    public JButton getBtnNext() {
        return btnnext;
    }

    public void setBtnNext(JButton btnnext) {
        this.btnnext = btnnext;
    }

    public JTable getTblCalendar() {
        return tblCalendar;
    }

    public void setTblCalendar(JTable tblCalendar) {
        this.tblCalendar = tblCalendar;
    }

    public JComboBox getCmbYear() {
        return cmbYear;
    }

    public void setCmbYear(JComboBox cmbYear) {
        this.cmbYear = cmbYear;
    }

    public DefaultTableModel getMtblCalendar() {
        return mtblCalendar;
    }

    public void setMtblCalendar(DefaultTableModel mtblCalendar) {
        this.mtblCalendar = mtblCalendar;
    }

    public JScrollPane getStblCalendar() {
        return stblCalendar;
    }

    public void setStblCalendar(JScrollPane stblCalendar) {
        this.stblCalendar = stblCalendar;
    }

    public JPanel getPnlCalendar() {
        return pnlCalendar;
    }

    public void setPnlCalendar(JPanel pnlCalendar) {
        this.pnlCalendar = pnlCalendar;
    }

    public int getRealYear() {
        return realYear;
    }

    public void setRealYear(int realYear) {
        this.realYear = realYear;
    }

    public int getRealMonth() {
        return realMonth;
    }

    public void setRealMonth(int realMonth) {
        this.realMonth = realMonth;
    }

    public int getRealDay() {
        return realDay;
    }

    public void setRealDay(int realDay) {
        this.realDay = realDay;
    }

    public int getCurrentYear() {
        return cYear;
    }

    public void setCurrentYear(int cYear) {
        this.cYear = cYear;
    }

    public int getCurrentMonth() {
        return cMonth;
    }

    public void setCurrentMonth(int cMonth) {
        this.cMonth = cMonth;
    }

}
