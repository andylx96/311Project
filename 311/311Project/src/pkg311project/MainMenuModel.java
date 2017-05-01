package pkg311project;

import java.util.ArrayList;

public class MainMenuModel {

    ArrayList<ArrayList> accounts;

    public MainMenuModel() {
        accounts = new ArrayList();
        accounts.add(new ArrayList<String>());
        accounts.add(new ArrayList<String>());

    }

    public ArrayList<ArrayList> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<ArrayList> accounts) {
        this.accounts = accounts;
    }
}
