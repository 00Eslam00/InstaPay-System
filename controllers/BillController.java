package controllers;

import classes.Bill;
import enums.BillStat;
import enums.BillType;
import interfaces.GetBillBehavior;
import interfaces.PayBillBehavior;
import models.UserProvider;
import repository.DataBaseRepo;

public class BillController implements PayBillBehavior, GetBillBehavior {

    private DataBaseRepo db;

    public BillController(DataBaseRepo _db) {
        this.db = _db;
    }

    @Override
    public Bill getBillDetails(BillType billType, String mobile) {
        return db.getBill(billType, bill -> bill.getUserNum().equals(mobile));
    }

    @Override
    public BillStat payBill(String token, Bill bill, BillType billtType) {

        UserProvider usp = db.getUserProvider(us -> us.mobileNum.equals(token));

        usp.balance -= bill.getCost();
        db.updateUserProvider(usp);
        db.removeBill(billtType, mybill -> mybill.getUserNum().equals(bill.getUserNum()));

        throw new UnsupportedOperationException("Unimplemented method 'payBill'");
    }

}
