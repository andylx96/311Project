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

    JLabel lblMonth, lblYear;
    JButton btnPrev, btnNext;
    JTable tblCalendar;
    JComboBox cmbYear;
    DefaultTableModel mtblCalendar; //Table model
    JScrollPane stblCalendar; //The scrollpane
    JPanel pnlCalendar;
    int realYear, realMonth, realDay, currentYear, currentMonth;

//	public static void main (String args[]){
    //Look and feel
//		try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
//		catch (ClassNotFoundException e) {}
//		catch (InstantiationException e) {}
//		catch (IllegalAccessException e) {}
//		catch (UnsupportedLookAndFeelException e) {}
    //Prepare frame
//		frmMain = new JFrame ("Gestionnaire de clients"); //Create frame
//		frmMain.setSize(330, 375); //Set size to 400x400 pixels
//		pane = frmMain.getContentPane(); //Get content pane
//		pane.setLayout(null); //Apply null layout
//		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked
    CalendarOverView() {
        //Create controls
        lblMonth = new JLabel("January");
        lblYear = new JLabel("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton("<<");
        btnNext = new JButton(">>");
        mtblCalendar = new DefaultTableModel();
//                {public boolean isCellEditable(int rowIndex, int mColIndex){return false;
//                }
//                };
		tblCalendar = new JTable(mtblCalendar);
		stblCalendar = new JScrollPane(tblCalendar);
		pnlCalendar = new JPanel(null);

		//Set border
		pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
//

		
		//Add controls to pane
//		pane.add(pnlCalendar);
        add(lblMonth);
        add(lblYear);
        add(cmbYear);
        add(btnPrev);
        add(btnNext);
add(stblCalendar);
//		
		//Set bounds
		pnlCalendar.setBounds(0, 0, 320, 335);
		lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 100, 25);
		lblYear.setBounds(10, 305, 80, 20);
		cmbYear.setBounds(230, 305, 80, 20);
		btnPrev.setBounds(10, 25, 50, 25);
		btnNext.setBounds(260, 25, 50, 25);
		stblCalendar.setBounds(10, 50, 300, 250);
//		
//		//Make frame visible
//		frmMain.setResizable(false);
//		frmMain.setVisible(true);
//		
		//Get real month/year
		GregorianCalendar cal = new GregorianCalendar(); //Create calendar
		realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
		realMonth = cal.get(GregorianCalendar.MONTH); //Get month
		realYear = cal.get(GregorianCalendar.YEAR); //Get year
		currentMonth = realMonth; //Match month and year
		currentYear = realYear;
//		
//		//Add headers
		String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
		for (int i=0; i<7; i++){
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

		//Set row/column count
		tblCalendar.setRowHeight(58);
		mtblCalendar.setColumnCount(7);
		mtblCalendar.setRowCount(6);
		
		//Populate table
		for (int i=realYear-100; i<=realYear+100; i++){
			cmbYear.addItem(String.valueOf(i));
		}
		
    }

    public JLabel getLblMonth() {
        return lblMonth;
    }

    public void setLblMonth(JLabel lblMonth) {
        this.lblMonth = lblMonth;
    }

    public JLabel getLblYear() {
        return lblYear;
    }

    public void setLblYear(JLabel lblYear) {
        this.lblYear = lblYear;
    }

    public JButton getBtnPrev() {
        return btnPrev;
    }

    public void setBtnPrev(JButton btnPrev) {
        this.btnPrev = btnPrev;
    }

    public JButton getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(JButton btnNext) {
        this.btnNext = btnNext;
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
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public int getCurrentMonth() {
        return currentMonth;
    }

    public void setCurrentMonth(int currentMonth) {
        this.currentMonth = currentMonth;
    }

}
