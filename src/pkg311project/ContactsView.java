/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author ajl5735
 */
public class ContactsView extends JPanel {

        Object[][] data = {{"", "", ""}, {"", "", ""}};
        String[] columnName = {"Name", "Phone Number", "Extra"};
        DefaultTableModel model = new DefaultTableModel(data, columnName);
        JTable table = new JTable(model);
        private TableRowSorter<TableModel> rowSorter
            = new TableRowSorter<>(table.getModel());
        JScrollPane scroll;

        JLabel hi = new JLabel("hi");
        JLabel filterLabel;
        JButton save = new JButton("Save Edits");
        JButton add = new JButton("Add Contacts");
        JButton delete = new JButton("Delete Button");
        JPanel bottomPanel;
        JTextArea filter;

    public ContactsView() {
        filterLabel = new JLabel("Search Filter: ", SwingConstants.RIGHT);
        
        setLayout(new BorderLayout());
        table.setRowSorter(rowSorter);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       scroll = new JScrollPane(table);
        bottomPanel = new JPanel();
         bottomPanel.setLayout(new GridLayout(1,4));
        
        filter = new JTextArea();
        filter.setOpaque(true);
        filter.setBackground(Color.white);
        bottomPanel.add(save);
        bottomPanel.add(add);
        bottomPanel.add(delete);
        bottomPanel.add(filterLabel);
        bottomPanel.add(filter);
        add(scroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    public JButton getDelete() {
        return delete;
    }

    public void setDelete(JButton delete) {
        this.delete = delete;
    }

    public TableRowSorter<TableModel> getRowSorter() {
        return rowSorter;
    }

    public void setRowSorter(TableRowSorter<TableModel> rowSorter) {
        this.rowSorter = rowSorter;
    }

    public JButton getAdd() {
        return add;
    }

    public void setAdd(JButton add) {
        this.add = add;
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

    public JTextArea getFilter() {
        return filter;
    }

    public void setFilter(JTextArea filter) {
        this.filter = filter;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
    
}
