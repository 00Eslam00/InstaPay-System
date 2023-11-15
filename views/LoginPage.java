package views;

import interfaces.LoginBehavior;
import models.LogUser;

import java.util.Scanner;

/**
 * Represents a page for user login in the InstaPay application.
 * Extends the Page class and uses a LoginBehavior implementation for user authentication.
 */
public class LoginPage extends Page {

    private LoginBehavior lb;

    /**
     * Constructs a LoginPage with the specified LoginBehavior.
     *
     * @param lb The LoginBehavior implementation used for user authentication.
     */
    public LoginPage(LoginBehavior lb) {
        this.lb = lb;
    }

    /**
     * Displays the login page, prompts the user for a username and password, and attempts to log in the user.
     * Sets the application token based on the result of the login attempt.
     */
    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String userName, password;
        System.out.print("Enter your username: ");
        userName = scanner.nextLine();
        System.out.print("Enter your password: ");
        password = scanner.nextLine();
        LogUser user = new LogUser(userName, password);
        app.setToken(lb.Login(user));
        if (app.getToken() == null)
            System.out.println("Invalid username or password");
        else
            System.out.println("Logged in successfully");
    }
}
