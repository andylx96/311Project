package pkg311project;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainMenuView extends JPanel {

  
   JButton calendarButton, contactsButton, testButton;
   JLabel picture;
    public MainMenuView() {
        super();
        setLayout(new BorderLayout());
        calendarButton = new JButton("Calendar");
        contactsButton = new JButton("Contacts");
        testButton = new JButton("TEST");
        picture = new JLabel(new ImageIcon("src/pkg311project/ourApp.png"));
        
        add(calendarButton, BorderLayout.EAST);
        add(contactsButton, BorderLayout.WEST);
        add(picture, BorderLayout.CENTER);
        add(testButton, BorderLayout.SOUTH);
        
    }

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

    public JButton getTestButton() {
        return testButton;
    }

    public void setTestButton(JButton testButton) {
        this.testButton = testButton;
    }

}
