package controllers;

import enums.PaymentStat;
import interfaces.*;
import repository.DataBaseRepo;

public class MoneyController implements BalanceBehavior, TransferMoneyBehavior {

    private DataBaseRepo db;

    public MoneyController(DataBaseRepo _db) {
        this.db = _db;
    }

    @Override
    public double getBalance(String token) {
        throw new UnsupportedOperationException("Unimplemented method 'getBalance'");
        
    }

    @Override
    public PaymentStat transferMoney(String token, String desMobile, double amount) {
        throw new UnsupportedOperationException("Unimplemented method 'transferMoney'");
    }

}
