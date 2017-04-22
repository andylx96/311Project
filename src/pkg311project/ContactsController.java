/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

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
public class ContactsController {
    ContactsModel contacts_model;
    ContactsFrame contacts_frame;
    String tempC;
    
    ArrayList<Contacts> contactsList = new ArrayList();
    
    ContactsController(ContactsModel contacts_model, ContactsFrame contacts_frame){
        this.contacts_model = contacts_model;
        this.contacts_frame = contacts_frame;
        
        contacts_frame.getPanel().getContact_view().getAdd().addActionListener(new ContactsController.AddButtonListener());
        contacts_frame.getPanel().getContact_view().getDelete().addActionListener(new ContactsController.ContactDeleteButtonListener());
        updateArrayAndTable();
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
    
    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            FileWriter fout;
            try {
                fout = new FileWriter("src/pkg311project/contact.txt", true);
                tempC = JOptionPane.showInputDialog(null, "Contact Name: ");
                fout.write("\n" + tempC + ",");
                tempC = JOptionPane.showInputDialog(null, "Phone Number: ");
                fout.write(tempC + ",");
                tempC = JOptionPane.showInputDialog(null, "Extra Info: ");
                fout.write(tempC);

                fout.close();
                fout.flush();
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
            fin = new FileReader("src/pkg311project/contact.txt");
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
            fout = new FileWriter("src/pkg311project/contact.txt");
            for (int i = 0; i < contacts_frame.getPanel().getContact_view().getTable().getRowCount(); i++) {
                for (int j = 0; j < contacts_frame.getPanel().getContact_view().getTable().getColumnCount(); j++) {

                    if (i != tempRow) {
                        if(j ==  2){
                            fout.write(contacts_frame.getPanel().getContact_view().getTable().getValueAt(i, j) + "");
                            }
                        else {
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
}
