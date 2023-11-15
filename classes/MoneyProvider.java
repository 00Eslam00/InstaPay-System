package classes;

import enums.PaymentStat;
import models.UserProvider;

/**
 * The {@code MoneyProvider} abstract class represents a generic money provider
 * with transfer behavior.
 * Classes extending this abstract class should provide an implementation for
 * the
 * {@link #transferMoney(UserProvider, UserProvider, double)} method.
 */
abstract public class MoneyProvider {

    /**
     * Transfers money from the source user provider to the destination user
     * provider.
     *
     * @param src    The source {@link UserProvider}.
     * @param dest   The destination {@link UserProvider}.
     * @param amount The amount of money to be transferred.
     * @return The {@link PaymentStat} indicating the status of the money transfer.
     */
    abstract public PaymentStat transferMoney(UserProvider src, UserProvider dest, double amount);
}
