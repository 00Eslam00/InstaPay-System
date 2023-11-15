package controllers;

import classes.Bill;
import enums.BillStat;
import enums.BillType;
import interfaces.GetBillBehavior;
import interfaces.PayBillBehavior;
import models.UserProvider;
import repository.DataBaseRepo;

/**
 * The {@code BillController} class implements the behavior for paying and
 * retrieving bill details.
 * It uses a {@link DataBaseRepo} for accessing data and managing bills.
 * Implements {@link PayBillBehavior} and {@link GetBillBehavior} interfaces.
 */
public class BillController implements PayBillBehavior, GetBillBehavior {

    private DataBaseRepo db;

    /**
     * Constructs a new {@code BillController} with the specified
     * {@link DataBaseRepo}.
     *
     * @param _db The {@link DataBaseRepo} used for accessing data.
     */
    public BillController(DataBaseRepo _db) {
        this.db = _db;
    }

    /**
     * Retrieves bill details based on the provided {@link BillType} and user's
     * mobile number.
     *
     * @param billType The type of bill to retrieve.
     * @param mobile   The mobile number of the user.
     * @return The {@link Bill} details corresponding to the specified type and
     *         mobile number.
     */
    @Override
    public Bill getBillDetails(BillType billType, String mobile) {
        return db.getBill(billType, bill -> bill.getUserNum().equals(mobile));
    }

    /**
     * Pays a bill using the provided token, bill, and bill type.
     *
     * @param token     The token associated with the user.
     * @param bill      The {@link Bill} to be paid.
     * @param billtType The {@link BillType} of the bill to be paid.
     * @return The {@link BillStat} indicating the payment status (PAID or
     *         NOT_ENOUGH_MONEY).
     */
    @Override
    public BillStat payBill(String token, Bill bill, BillType billtType) {

        // Retrieve user provider details based on the provided token
        UserProvider usp = db.getUserProvider(us -> us.mobileNum.equals(token));

        // Check if the user has enough balance to pay the bill
        if (usp.balance < bill.getCost()) {
            return BillStat.NOT_ENOUGH_MONEY;
        } else {
            // Deduct the bill cost from the user's balance
            usp.balance -= bill.getCost();
            db.updateUserProvider(usp);

            // Remove the paid bill from the database
            db.removeBill(billtType, myBill -> myBill.getUserNum().equals(bill.getUserNum()));

            return BillStat.PAID;
        }
    }
}
