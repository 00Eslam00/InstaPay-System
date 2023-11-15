package views;

import enums.AccountType;
import enums.RegestrationStat;
import interfaces.RegisterBehavior;
import models.LogUser;
import models.User;

import java.util.Scanner;

/**
 * Represents a page for user registration in the InstaPay application.
 * Extends the Page class and uses a RegisterBehavior implementation for user registration.
 */
public class RegisterationPage  extends Page {

    private RegisterBehavior re;

    /**
     * Constructs a RegistrationPage with the specified RegisterBehavior.
     *
     * @param re The RegisterBehavior implementation used for user registration.
     */
    public RegisterationPage (RegisterBehavior re) {
        this.re = re;
    }

    /**
     * Displays the registration page, prompts the user for registration details, and processes the registration.
     * Utilizes the RegisterBehavior implementation for registration.
     */
    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Telephone Number: ");
        String telephone = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Account type (BANK) or (WALLET): ");
        String type = scanner.nextLine().toUpperCase();
        AccountType accountType;
        try {
            accountType = AccountType.valueOf(type);
        } catch (Exception e) {
            System.out.println("Not supported account type");
            return;
        }
        User newUser = new User(telephone, username, accountType, email, password);
        RegestrationStat[] states = re.Register(newUser);
        if (states[0] == RegestrationStat.DONE)
            System.out.println("Registration successful");
        else {
            System.out.println("Your information has the following issues:");
            for (RegestrationStat r : states) {
                if (r == RegestrationStat.INVALID_NUMBER)
                    System.out.println("Incorrect mobile number");
                else if (r == RegestrationStat.USERNAME_EXSITS)
                    System.out.println("Username already exists");
                else if (r == RegestrationStat.NOT_EXISTING_NUMBER)
                    System.out.println("This number doesn't contain " + accountType.toString() + " Account");
                else if (r == RegestrationStat.WRONG_CODE)
                    System.out.println("Incorrect verification code");
            }
        }
    }
}
