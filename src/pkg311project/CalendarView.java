/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CalendarView extends JPanel {

    Object[][] data = {{"Task", "DateStart", "AM", "DateEnd", "PM"}, {"Task", "DateStart", "AM", "DateEnd", "PM"}};
    String[] columnName = {"Name", "Start", "AM/PM", "End", "AM/PM"};
    DefaultTableModel model = new DefaultTableModel(data, columnName);
    JTable table = new JTable(model);
    private TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(table.getModel());
    JScrollPane scroll;

    JButton save, delete;
    JLabel hi;

    JPanel bottomPanel;

    public CalendarView() {
        setLayout(new BorderLayout());

        table.setRowSorter(rowSorter);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        bottomPanel = new JPanel();

        save = new JButton("Save Edits");
        delete = new JButton("Delete Button");
        bottomPanel.add(save);
        bottomPanel.add(delete);
        hi = new JLabel("hi");
        scroll = new JScrollPane(table);
        add(scroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    public JButton getSave() {
        return save;
    }

    public void setSave(JButton save) {
        this.save = save;
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public JPanel getBottomPanel() {
        return bottomPanel;
    }

    public void setBottomPanel(JPanel bottomPanel) {
        this.bottomPanel = bottomPanel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}
