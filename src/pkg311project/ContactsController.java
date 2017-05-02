/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author ajl5735
 */
public class ContactsController {

    ContactsModel contacts_model;
    ContactsFrame contacts_frame;
    String tempC, tempA, tempB;

    ArrayList<Contacts> contactsList = new ArrayList<Contacts>();
    String currentUsersName;

    ContactsController(ContactsModel contacts_model, ContactsFrame contacts_frame, String username) {
        this.contacts_model = contacts_model;
        this.contacts_frame = contacts_frame;
        setCurrentUsersName(username);
        contacts_frame.getPanel().getContact_view().getAdd().addActionListener(new AddButtonListener());
        contacts_frame.getPanel().getContact_view().getDelete().addActionListener(new ContactDeleteButtonListener());
        updateArrayAndTable();
        contacts_frame.getPanel().getContact_view().getFilter().getDocument().addDocumentListener(new SearchDocumentListener());
        contacts_frame.getPanel().getContact_view().getImportButton().addActionListener(new ImportButtonListener());

        contacts_frame.getPanel().getContact_view().getSave().addActionListener(new SaveButtonListener());
        contacts_frame.getPanel().getContact_view().getExport().addActionListener(new ExportButtonListener());

    }

    class ContactDeleteButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int resp = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Delete This Line?\nThis Will Also Save All Changes Done So Far.");
            if (resp == JOptionPane.YES_OPTION) {
                int tempRow = contacts_frame.getPanel().getContact_view().getTable().convertRowIndexToModel(contacts_frame.getPanel().getContact_view().getTable().getSelectedRow());
                tableToFile(tempRow);
                updateArrayAndTable();
            }
            JOptionPane.showMessageDialog(null, "Deleted!");

        }
    }

    class SaveButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            int resp = JOptionPane.showConfirmDialog(null, "Are You Sure You Want To Save All Changes?");
            if (resp == JOptionPane.YES_OPTION) {
//                int tempRow = contacts_frame.getPanel().getContact_view().getTable().convertRowIndexToModel(contacts_frame.getPanel().getContact_view().getTable().getSelectedRow());
                tableToFile(-1);
                updateArrayAndTable();
            }
            JOptionPane.showMessageDialog(null, "Saved");

        }
    }

    class ImportButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int returnVal = contacts_frame.getPanel().getContact_view().getImportChooser().showOpenDialog(null);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File f = contacts_frame.getPanel().getContact_view().getImportChooser().getSelectedFile();
                String importDir = f.getAbsolutePath();
                System.out.println(importDir);

                String tempName;
                contactsList.clear();
                contacts_frame.getPanel().getContact_view().getModel().setRowCount(0);
                try {
                    FileReader fin;
                    fin = new FileReader(importDir);
                    Scanner scan = new Scanner(fin);
                    while (scan.hasNext()) {

                        tempName = scan.next();
                        String[] InArray = tempName.split(",");

                        contactsList.add(new Contacts(InArray[0], InArray[1], InArray[2]));

                        contacts_frame.getPanel().getContact_view().getModel().addRow(new Object[]{InArray[0], InArray[1], InArray[2]});

                    }
                    fin.close();
                    contacts_frame.getPanel().getContact_view().getTable().setModel(contacts_frame.getPanel().getContact_view().getTable().getModel());

                } catch (FileNotFoundException ex) {

                    JOptionPane.showMessageDialog(null, ex);
                } catch (IOException ex) {
                }

            }
        }
    }

    class ExportButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int returnVal = contacts_frame.getPanel().getContact_view().getExportChooser().showOpenDialog(null);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File f = contacts_frame.getPanel().getContact_view().getExportChooser().getSelectedFile();
                String exportDir = f.getAbsolutePath();
                System.out.println(exportDir);
                int confirm = -1;
//                if (f.exists() && !f.isDirectory()) {
                confirm = JOptionPane.showConfirmDialog(null, "This WILL overwrite a file if it already exist. \nDo You Wish To Continue?");
//                }
                if (confirm == JOptionPane.YES_OPTION) {
                    FileWriter fout;
                    try {
                        fout = new FileWriter(String.format(exportDir + "/%s.csv", getCurrentUsersName()));
                        for (int i = 0; i < contacts_frame.getPanel().getContact_view().getTable().getRowCount(); i++) {
                            for (int j = 0; j < contacts_frame.getPanel().getContact_view().getTable().getColumnCount(); j++) {

                                if (j == 2) {
                                    fout.write(contacts_frame.getPanel().getContact_view().getTable().getValueAt(i, j) + "");
                                } else {
                                    fout.write(contacts_frame.getPanel().getContact_view().getTable().getValueAt(i, j) + ",");
                                }

                            }
                            fout.write("\n");
                        }
                        fout.close();
                        fout.flush();
                    } catch (IOException ex) {
                    }

                }
            }
        }
    }

    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FileWriter fout;
            try {
                fout = new FileWriter(String.format("src/contacts/%s.csv", getCurrentUsersName()), true);
                tempA = JOptionPane.showInputDialog(null, "Contact Name: ");
                tempB = JOptionPane.showInputDialog(null, "Phone Number: ");
                tempC = JOptionPane.showInputDialog(null, "Extra Info: ");
                if (tempA == null) {
                    JOptionPane.showMessageDialog(null, "There was an error. Try Again");
                } else if (tempB == null) {
                    JOptionPane.showMessageDialog(null, "There was an error. Try Again");
                } else if (tempC == null) {
                    JOptionPane.showMessageDialog(null, "There was an error. Try Again");
                } else {
                    fout.write("\n" + tempA + ",");
                    fout.write(tempB + ",");
                    fout.write(tempC);
                    fout.close();
                    fout.flush();
                }
            } catch (IOException ex) {
            }

            updateArrayAndTable();
        }
    }

    public void updateArrayAndTable() {

        String tempName;
        contactsList.clear();
        contacts_frame.getPanel().getContact_view().getModel().setRowCount(0);
        try {
            FileReader fin;
            fin = new FileReader(String.format("src/contacts/%s.csv", getCurrentUsersName()));
            Scanner scan = new Scanner(fin);
            while (scan.hasNext()) {

                tempName = scan.next();
                String[] InArray = tempName.split(",");

                contactsList.add(new Contacts(InArray[0], InArray[1], InArray[2]));

                contacts_frame.getPanel().getContact_view().getModel().addRow(new Object[]{InArray[0], InArray[1], InArray[2]});

            }
            fin.close();
            contacts_frame.getPanel().getContact_view().getTable().setModel(contacts_frame.getPanel().getContact_view().getTable().getModel());

        } catch (FileNotFoundException ex) {

            JOptionPane.showMessageDialog(null, ex);
        } catch (IOException ex) {
        }
    }

    public void tableToFile(int tempRow) {
        FileWriter fout;
        try {
            fout = new FileWriter(String.format("src/contacts/%s.csv", getCurrentUsersName()));
            for (int i = 0; i < contacts_frame.getPanel().getContact_view().getTable().getRowCount(); i++) {
                for (int j = 0; j < contacts_frame.getPanel().getContact_view().getTable().getColumnCount(); j++) {

                    if (i != tempRow) {
                        if (j == 2) {
                            fout.write(contacts_frame.getPanel().getContact_view().getTable().getValueAt(i, j) + "");
                        } else {
                            fout.write(contacts_frame.getPanel().getContact_view().getTable().getValueAt(i, j) + ",");
                        }
                    }
                }
                fout.write("\n");
            }
            fout.close();
            fout.flush();
        } catch (IOException ex) {
        }

    }

    class SearchDocumentListener implements DocumentListener {

        @Override
        public void insertUpdate(DocumentEvent e
        ) {
            String text = contacts_frame.getPanel().getContact_view().getFilter().getText();
            if (text.trim().length() == 0) {
                contacts_frame.getPanel().getContact_view().getRowSorter().setRowFilter(null);
            } else {
                contacts_frame.getPanel().getContact_view().getRowSorter().setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }

        @Override
        public void removeUpdate(DocumentEvent e
        ) {
            String text = contacts_frame.getPanel().getContact_view().getFilter().getText();
            if (text.trim().length() == 0) {
                contacts_frame.getPanel().getContact_view().getRowSorter().setRowFilter(null);
            } else {
                contacts_frame.getPanel().getContact_view().getRowSorter().setRowFilter(RowFilter.regexFilter("(?i)" + text));
            }
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            JOptionPane.showMessageDialog(null, "Not supported yet.");
        }
    }

    public String getCurrentUsersName() {
        return currentUsersName;
    }

    public void setCurrentUsersName(String currentUsersName) {
        this.currentUsersName = currentUsersName;
    }

}
