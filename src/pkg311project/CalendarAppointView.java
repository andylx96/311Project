package pkg311project;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalendarAppointView extends JPanel {

    JLabel status;
    JTextField appoint_name, appoint_startTime, appoint_endTime;
    JButton createAppoint;
    JComboBox<String> am_pm_startCombo, am_pm_endCombo;
    String[] am_pmArray = {"AM", "PM"};
    GridBagConstraints gbc = new GridBagConstraints();

    public CalendarAppointView() {
        setLayout(new GridBagLayout());

        appoint_name = new JTextField("Enter Appointment Name");
        appoint_startTime = new JTextField("Start Time");
        appoint_endTime = new JTextField("End Time");
        am_pm_startCombo = new JComboBox(am_pmArray);
        am_pm_endCombo = new JComboBox(am_pmArray);
        createAppoint = new JButton("Create Appointment");

        status = new JLabel();
 
gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(appoint_name, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;

        add(appoint_startTime, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;

        add(am_pm_startCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;

        add(appoint_endTime, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;

        add(am_pm_endCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;

        add(createAppoint, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(status, gbc);
    }

    public JLabel getStatus() {
        return status;
    }

    public void setStatus(JLabel status) {
        this.status = status;
    }

    public JTextField getAppoint_name() {
        return appoint_name;
    }

    public void setAppoint_name(JTextField appoint_name) {
        this.appoint_name = appoint_name;
    }

    public JTextField getAppoint_startTime() {
        return appoint_startTime;
    }

    public void setAppoint_startTime(JTextField appoint_startTime) {
        this.appoint_startTime = appoint_startTime;
    }

    public JTextField getAppoint_endTime() {
        return appoint_endTime;
    }

    public void setAppoint_endTime(JTextField appoint_endTime) {
        this.appoint_endTime = appoint_endTime;
    }

    public JButton getCreateAppoint() {
        return createAppoint;
    }

    public void setCreateAppoint(JButton createAppoint) {
        this.createAppoint = createAppoint;
    }

    public JComboBox<String> getAm_pm_startCombo() {
        return am_pm_startCombo;
    }

    public void setAm_pm_startCombo(JComboBox<String> am_pm_startCombo) {
        this.am_pm_startCombo = am_pm_startCombo;
    }

    public JComboBox<String> getAm_pm_endCombo() {
        return am_pm_endCombo;
    }

    public void setAm_pm_endCombo(JComboBox<String> am_pm_endCombo) {
        this.am_pm_endCombo = am_pm_endCombo;
    }

    public String[] getAm_pmArray() {
        return am_pmArray;
    }

    public void setAm_pmArray(String[] am_pmArray) {
        this.am_pmArray = am_pmArray;
    }

}
