package pkg311project;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class NavViewPanel extends JPanel {

    NavViewBottomMenuPanel menu;

    public NavViewBottomMenuPanel getMenu() {
        return menu;
    }

    public void setMenu(NavViewBottomMenuPanel menu) {
        this.menu = menu;
    }
   
    public NavViewPanel() {
        super();
        setLayout(new BorderLayout());
        menu = new NavViewBottomMenuPanel();
        

        add(menu, BorderLayout.SOUTH);
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


}
