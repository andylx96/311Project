/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import javax.swing.JFrame;

/**
 *
 * @author ajl5735
 */
public class ContactsFrame extends JFrame {
   ContactsModel model;
    ContactsPanel panel;
    
    public ContactsFrame(ContactsModel model){
    super("Contacts");
    this.model = model;
    
       setSize(700, 500);
        panel = new ContactsPanel();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(panel);
    
    }

    public ContactsPanel getPanel() {
        return panel;
    }

    public void setPanel(ContactsPanel panel) {
        this.panel = panel;
    }
        public void switchToContacts(ContactsView contact_view) {
   panel.removeContactView();
   panel.addContactView(contact_view);
    }
}
