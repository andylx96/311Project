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
    
    ArrayList<Appointment> contactsList = new ArrayList();
    
    ContactsController(ContactsModel contacts_model, ContactsFrame contacts_frame){
        this.contacts_model = contacts_model;
        this.contacts_frame = contacts_frame;
        
        contacts_frame.getPanel().getContact_view().getAdd().addActionListener(new ContactsController.AddButtonListener());
        updateArrayAndTable();
    }
    
    class AddButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JOptionPane.showMessageDialog(null, "Not Supported Yet");
        }
    }
    
    public void updateArrayAndTable() {

        String tempName, tempNum, tempExtra;
        contactsList.clear();
        contacts_frame.getPanel().getContact_view().getModel().setRowCount(0);
        try {
            FileReader fin;
            fin = new FileReader("src/pkg311project/contact.txt");
            Scanner scan = new Scanner(fin);
            while (scan.hasNextLine()) {

                tempName = scan.nextLine();
                tempNum = scan.nextLine();
                tempExtra = scan.nextLine();

                contactsList.add(new Appointment(tempName, tempNum, tempExtra));

                contacts_frame.getPanel().getContact_view().getModel().addRow(new Object[]{tempName, tempNum, tempExtra});

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
                        fout.write(contacts_frame.getPanel().getContact_view().getTable().getValueAt(i, j) + "\n");
                    }
                }
            }
            fout.close();
            fout.flush();
        } catch (IOException ex) {
        }

    }
}
