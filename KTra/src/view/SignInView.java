package view;

import util.AlertUtil;
import util.EventUtil;
import util.MenuUtil;

import java.util.Locale;
import java.util.Scanner;

public class SignInView {
    public void signInView(){
        Scanner input = new Scanner(System.in);
        MenuUtil menuUtil = new MenuUtil();
        AlertUtil alertUtil = new AlertUtil();
        EventUtil eventUtil = new EventUtil();
        try{
            menuUtil.menuUtil("Sign-In-Menu");
            while (true){
                alertUtil.alertUtil("Sign-In-Confirm");
                System.out.println("■ Input : ");
                String selectOption = input.nextLine().toLowerCase().replaceAll("\\s", "");
                switch (selectOption){
                    case "y":
                        eventUtil.signInUtil();
                        break;
                    case "n":
                    case "r":
                        eventUtil.returnUtil("Authenticate-Return");
                        break;
                    case "e":
                        eventUtil.exitUtil("Sign-In-Exit");
                        break;
                    default:
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
