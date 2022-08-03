package view;

import util.AlertUtil;
import util.EventUtil;
import util.MenuUtil;

import java.util.Locale;
import java.util.Scanner;

public class AuthenticateView {
    public void authenticateView() {
        Scanner input = new Scanner(System.in);
        MenuUtil menuUtil = new MenuUtil();
        AlertUtil alertUtil = new AlertUtil();
        EventUtil eventUtil = new EventUtil();
        SignInView signInView = new SignInView();
        try {
            while (true) {
                menuUtil.menuUtil("Authenticate-Menu");
                System.out.println("■ Select : ");
                String choice = input.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (choice) {
                    case "1":
                        signInView.signInView();
                        break;
                    case "2":
                        alertUtil.alertUtil("Admin");
                        break;
                    case "e":
                        eventUtil.exitUtil("Authenticate-Exit");
                        break;
                }
            }
        } catch (Exception e) {
            alertUtil.alertUtil("Invalid-Select");
        }
    }
}
