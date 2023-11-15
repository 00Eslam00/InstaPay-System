package interfaces;

import enums.PaymentStat;

/**
 * The {@code TransferMoneyBehavior} interface defines the behavior for
 * transferring money between users.
 * Classes implementing this interface should provide an implementation for the
 * {@link #transferMoney(String, String, double)} method.
 */
public interface TransferMoneyBehavior {

    /**
     * Transfers money from the user associated with the source token to the user
     * with the destination mobile number.
     *
     * @param token     The token associated with the source user.
     * @param desMobile The mobile number of the destination user.
     * @param amount    The amount of money to be transferred.
     * @return The {@link PaymentStat} indicating the status of the money transfer.
     */
    PaymentStat transferMoney(String token, String desMobile, double amount);
}
