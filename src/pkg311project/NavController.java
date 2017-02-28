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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class NavController {

    NavModel n_model;
    NavViewFrame n_view;

 

    public NavController(NavModel n_model, NavViewFrame n_view) throws Throwable {
        this.n_model = n_model;
        this.n_view = n_view;

          }

 

}
