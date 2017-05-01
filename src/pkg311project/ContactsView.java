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
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    JButton export = new JButton("Excport");
    JPanel bottomPanel;
    JTextArea filter;
    JButton importButton = new JButton("Import");
    
    JFileChooser importChooser = new JFileChooser();
    FileNameExtensionFilter importFileFilter = new FileNameExtensionFilter(
            "CSV files (*csv)", "csv");
    
    JFileChooser exportChooser = new JFileChooser();
    
    public ContactsView() {
        filterLabel = new JLabel("Search Filter: ", SwingConstants.RIGHT);
        
        setLayout(new BorderLayout());
        table.setRowSorter(rowSorter);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll = new JScrollPane(table);
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 7));
        
        filter = new JTextArea();
        filter.setOpaque(true);
        filter.setBackground(Color.white);
        bottomPanel.add(save);
        bottomPanel.add(add);
        bottomPanel.add(delete);
        bottomPanel.add(importButton);
        bottomPanel.add(export);
        bottomPanel.add(filterLabel);
        bottomPanel.add(filter);
        add(scroll, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        importChooser.setFileFilter(importFileFilter);
        importChooser.setDialogTitle("Import CSV");
        exportChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        exportChooser.setDialogTitle("Export CSV");
        
    }
    
    public JButton getImportButton() {
        return importButton;
    }
    
    public void setImportButton(JButton importButton) {
        this.importButton = importButton;
    }
    
    public JFileChooser getImportChooser() {
        return importChooser;
    }
    
    public void setImportChooser(JFileChooser importChooser) {
        this.importChooser = importChooser;
    }
    
    public FileNameExtensionFilter getImportFileFilter() {
        return importFileFilter;
    }
    
    public void setImportFileFilter(FileNameExtensionFilter importFileFilter) {
        this.importFileFilter = importFileFilter;
    }
    
    public JFileChooser getExportChooser() {
        return exportChooser;
    }
    
    public void setExportChooser(JFileChooser exportChooser) {
        this.exportChooser = exportChooser;
    }
    
    public JButton getSave() {
        return save;
    }

    public JButton getExport() {
        return export;
    }

    public void setExport(JButton export) {
        this.export = export;
    }
    
    public void setSave(JButton save) {
        this.save = save;
    }

//    public FileNameExtensionFilter getFileFilter() {
//        return fileFilter;
//    }
//
//    public void setFileFilter(FileNameExtensionFilter fileFilter) {
//        this.fileFilter = fileFilter;
//    }
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
