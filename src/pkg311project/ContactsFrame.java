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
    ContactsView view;
    
    public ContactsFrame(ContactsModel model){
    super("Hi");
    this.model = model;
    
       setSize(700, 500);
        view = new ContactsView();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(view);
    
    }
    
}
