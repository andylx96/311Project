/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ajl5735
 */
public class ContactsView extends JPanel {

    JLabel label;

    public ContactsView() {
        label = new JLabel("Contact Stuff");
        add(label);
    }

}
