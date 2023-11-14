package controllers;

import classes.Validations;
import enums.RegestrationStat;
import interfaces.*;
import models.*;
import repository.DataBaseRepo;

import java.util.Scanner;

public class UserController implements RegisterBehavior, LoginBehavior {

    private DataBaseRepo db;

    public UserController(DataBaseRepo _db) {
        this.db = _db;
    }

    @Override
    public String Login(LogUser user) {
        User foundedUser = db.getUser(usr -> usr.getInstaAccount().getUserName().equals(user.userName)
                && usr.getPassword().equals(user.password));
        if (foundedUser != null)
            return foundedUser.getInstaAccount().getMobile();
        return null;
    }

    @Override
    public RegestrationStat[] Register(User user) {
        RegestrationStat[] states = new RegestrationStat[3];
        int stateId = 0;
        if (!Validations.uniqueUsername(user.getInstaAccount().getUserName(), db))
            states[stateId++] = RegestrationStat.USERNAME_EXSITS;

        if (!Validations.validateMobile(user.getInstaAccount().getMobile()))
            states[stateId++] = RegestrationStat.INVALID_NUMBER;

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
                states[stateId] = RegestrationStat.WORNG_CODE;
        }

        return states;
    }
}