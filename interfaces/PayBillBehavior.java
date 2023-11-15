package interfaces;

import classes.Bill;
import enums.BillStat;
import enums.BillType;

/**
 * The {@code PayBillBehavior} interface defines the behavior for paying bills.
 * Classes implementing this interface should provide an implementation for the
 * {@link #payBill(String, Bill, BillType)} method.
 */
public interface PayBillBehavior {

    /**
     * Pays a bill using the provided token, bill, and bill type.
     *
     * @param token    The token associated with the user.
     * @param bill     The {@link Bill} to be paid.
     * @param billType The {@link BillType} of the bill to be paid.
     * @return The {@link BillStat} indicating the status of the bill payment.
     */
    BillStat payBill(String token, Bill bill, BillType billType);
}
