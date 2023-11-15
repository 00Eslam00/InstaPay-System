package controllers;

import classes.Validations;
import enums.RegestrationStat;
import interfaces.LoginBehavior;
import interfaces.RegisterBehavior;
import models.LogUser;
import models.User;
import repository.DataBaseRepo;

import java.util.Scanner;

/**
 * The {@code UserController} class handles user registration and login operations.
 * It implements the {@link RegisterBehavior} and {@link LoginBehavior} interfaces.
 */
public class UserController implements RegisterBehavior, LoginBehavior {

    private DataBaseRepo db;

    /**
     * Constructs a new {@code UserController} with the specified {@link DataBaseRepo}.
     *
     * @param _db The {@link DataBaseRepo} used for accessing data.
     */
    public UserController(DataBaseRepo _db) {
        this.db = _db;
    }

    /**
     * Logs in a user based on the provided {@link LogUser} information.
     *
     * @param user The {@link LogUser} containing login information (username and password).
     * @return The mobile number associated with the logged-in user, or {@code null} if login fails.
     */
    @Override
    public String Login(LogUser user) {
        User foundedUser = db.getUser(usr -> usr.getInstaAccount().getUserName().equals(user.userName)
                && usr.getPassword().equals(user.password));
        if (foundedUser != null)
            return foundedUser.getInstaAccount().getMobile();
        return null;
    }

    /**
     * Registers a new user based on the provided {@link User} information.
     *
     * @param user The {@link User} to be registered.
     * @return An array of {@link RegestrationStat} indicating the registration status.
     */
    @Override
    public RegestrationStat[] Register(User user) {
        RegestrationStat[] states = new RegestrationStat[3];
        int stateId = 0;

        // Check if the username is unique
        if (!Validations.uniqueUsername(user.getInstaAccount().getUserName(), db))
            states[stateId++] = RegestrationStat.USERNAME_EXSITS;

        // Validate the mobile number format
        if (!Validations.validateMobile(user.getInstaAccount().getMobile()))
            states[stateId++] = RegestrationStat.INVALID_NUMBER;

        // Validate the mobile number and account type combination
        if (!Validations.validateMobile(user.getInstaAccount().getMobile(), user.getInstaAccount().getAccountType(),
                db))
            states[stateId++] = RegestrationStat.NOT_EXISTING_NUMBER;

        if (stateId == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Verification Code: 1234");
            String code = scanner.nextLine();
            if (code.equals("1234")) {
                db.addUser(user);
                states[stateId] = RegestrationStat.DONE;
            } else
                states[stateId] = RegestrationStat.WRONG_CODE;
        }

        return states;
    }
}
