package interfaces;

import classes.Bill;
import enums.BillType;

/**
 * The {@code GetBillBehavior} interface defines the behavior for retrieving
 * details of a bill.
 * Classes implementing this interface should provide an implementation for the
 * {@link #getBillDetails(BillType, String)} method.
 */
public interface GetBillBehavior {

    /**
     * Retrieves the details of a bill based on the specified bill type and user's
     * mobile number.
     *
     * @param billType The type of bill to retrieve.
     * @param mobile   The mobile number of the user.
     * @return The {@link Bill} details corresponding to the specified type and
     *         mobile number.
     */
    Bill getBillDetails(BillType billType, String mobile);
}
