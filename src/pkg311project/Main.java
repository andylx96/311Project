/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg311project;

/**
 *
 * @author ajl5735
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Throwable {
        // TODO code application logic here

        MainMenuViewModel model = new MainMenuViewModel();
        MainMenuFrame view = new MainMenuFrame(model);
        MainMenuViewController controller = new MainMenuViewController(model, view);

        view.setVisible(true);
    }

}
