package views;

import enums.AccountType;
import enums.RegestrationStat;
import interfaces.RegisterBehavior;
import models.LogUser;
import models.User;

import java.util.Scanner;

public class RegisterationPage extends Page {

    RegisterBehavior re;

    public RegisterationPage(RegisterBehavior _re) {
        re = _re;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Telephone Number:");
        String telephone = scanner.nextLine();
        System.out.println("Username");
        String username = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        AccountType accountType = AccountType.valueOf("BANK");
        User newUser = new User(telephone, username, accountType, email, password);
        RegestrationStat[] states = re.Register(newUser);
        if(states[0] == RegestrationStat.DONE)
            System.out.println("Registration successfully");
        else
        {
            System.out.println("Your information has the following issues:");
            for (RegestrationStat r : states)
            {
                if(r == RegestrationStat.INVALID_NUMBER)
                    System.out.println("Incorrect mobile number");
                else if(r == RegestrationStat.USERNAME_EXSITS)
                    System.out.println("Username already exist");
                else if(r == RegestrationStat.NOT_EXISTING_NUMBER)
                    System.out.println("This number doesn't contain " + accountType.toString() + " Account");
                else if(r == RegestrationStat.WORNG_CODE)
                    System.out.println("Incorrect verification code");
            }
        }
    }
}