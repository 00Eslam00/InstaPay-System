package views;

import interfaces.LoginBehavior;
import models.LogUser;

import java.util.Scanner;

public class LoginPage extends Page {

    LoginBehavior lb;

    public LoginPage(LoginBehavior _lb) {
        lb = _lb;
    }

    @Override
    public void show() {
         Scanner scanner = new Scanner(System.in);
         String userName, password;
         System.out.print("Enter your username number : ");
         userName = scanner.nextLine();
         System.out.print("Enter your password : ");
         password = scanner.nextLine();
         LogUser user = new LogUser(userName, password);
         app.setToken(lb.Login(user));
         if(app.token == null)
             System.out.print("Invalid username or password");
         else
             System.out.print("Logged in successfully");
    }

}