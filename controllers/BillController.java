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
        throw new UnsupportedOperationException("Unimplemented method 'getBillDetails'");
    }

    @Override
    public BillStat payBill(String token, Bill bill, BillType billtType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'payBill'");
    }

}
