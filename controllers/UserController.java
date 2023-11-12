package controllers;

import enums.RegestrationStat;
import interfaces.*;
import models.*;
import repository.DataBaseRepo;

public class UserController implements RegisterBehavior, LoginBehavior {

    private DataBaseRepo db;

    public UserController(DataBaseRepo _db) {
        this.db = _db;
    }

    @Override
    public String Login(LogUser loguser) {
        System.out.println("i am login");
        return "1234 login";
    }

    @Override
    public RegestrationStat[] Register(User user) {
        System.out.println("i am register");
        return new RegestrationStat[] { RegestrationStat.DONE };
    }
}