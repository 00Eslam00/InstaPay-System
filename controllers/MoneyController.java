package controllers;

import enums.PaymentStat;
import interfaces.*;
import models.UserProvider;
import repository.DataBaseRepo;

public class MoneyController implements BalanceBehavior, TransferMoneyBehavior {

    private DataBaseRepo db;

    public MoneyController(DataBaseRepo _db) {
        this.db = _db;
    }

    @Override
    public double getBalance(String token) {
        UserProvider user = db.getUserProvider(usp -> usp.mobileNum.equals(token));
        if (user == null)
            return 0;
        return user.balane;
    }

    @Override
    public PaymentStat transferMoney(String token, String desMobile, double amount) {
        throw new UnsupportedOperationException("Unimplemented method 'transferMoney'");
    }

}
