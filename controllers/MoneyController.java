package controllers;

import classes.MoneyProvider;
import enums.PaymentStat;
import factories.ProviderFactory;
import interfaces.*;
import models.User;
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
        return user.balance;
    }

    @Override
    public PaymentStat transferMoney(String token, String desMobile, double amount) {
        UserProvider source = db.getUserProvider(user -> user.mobileNum.equals(token));
        UserProvider dest = db.getUserProvider(user -> user.mobileNum.equals(desMobile));
        if (dest == null) {
            return PaymentStat.NOT_FOUND_PROVIDER;
        }
        User us = db.getUser(user -> user.getInstaAccount().getMobile().equals(desMobile));
        if (us == null) {
            return PaymentStat.NOT_FOUND_ACCOUNT;
        }
        MoneyProvider mpSource = ProviderFactory.create(source);
        assert mpSource != null;
        PaymentStat stat = mpSource.transferMoney(source, dest, amount);
        if (stat == PaymentStat.DONE) {
            source.balance -= amount;
            dest.balance += amount;
            db.updateUserProvider(source);
            db.updateUserProvider(dest);
        }
        return stat;
    }

}
