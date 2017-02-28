package pkg311project;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuView extends JPanel {

  
   JButton calendarButton, contactsButton;
   JLabel picture;
    public MainMenuView() {
        super();
        setLayout(new BorderLayout());
        calendarButton = new JButton("Calendar");
        contactsButton = new JButton("Contacts");
        picture = new JLabel(new ImageIcon("src/pkg311project/ourApp.png"));
        
        add(calendarButton, BorderLayout.EAST);
        add(contactsButton, BorderLayout.WEST);
        add(picture, BorderLayout.CENTER);
        
    }

//    public void addCreate(CreateView create_view) {
//        this.create_view = create_view;  //maintain handle to this view so we can remove it
//        add(create_view, BorderLayout.CENTER);
//        revalidate();
//        repaint();
//    }
//
//
//    public void removeCreate() {
//        if (this.create_view != null) {
//            remove(this.create_view);
//        }
//    }

    public JButton getCalendarButton() {
        return calendarButton;
    }

    public void setCalendarButton(JButton calendarButton) {
        this.calendarButton = calendarButton;
    }

    public JButton getContactsButton() {
        return contactsButton;
    }

    public void setContactsButton(JButton contactsButton) {
        this.contactsButton = contactsButton;
    }


}
