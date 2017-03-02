/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author ajl5735
 */
public class ContactsPanel extends JPanel {

    ContactsView contact_view;

    public ContactsPanel() {
        setLayout(new BorderLayout());
        contact_view = new ContactsView();
        add(contact_view, BorderLayout.CENTER);
        
        
        
    }

    public void addContactView(ContactsView contact_view) {
        this.contact_view = contact_view;
        add(contact_view, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void removeContactView() {
        if (this.contact_view != null) {
            this.remove(contact_view);
        }
    }
}
