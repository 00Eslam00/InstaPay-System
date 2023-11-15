package controllers;

import classes.MoneyProvider;
import enums.PaymentStat;
import factories.ProviderFactory;
import interfaces.BalanceBehavior;
import interfaces.TransferMoneyBehavior;
import models.User;
import models.UserProvider;
import repository.DataBaseRepo;

/**
 * The {@code MoneyController} class handles operations related to user balances
 * and money transfers.
 * It implements the {@link BalanceBehavior} and {@link TransferMoneyBehavior}
 * interfaces.
 */
public class MoneyController implements BalanceBehavior, TransferMoneyBehavior {

    private DataBaseRepo db;

    /**
     * Constructs a new {@code MoneyController} with the specified
     * {@link DataBaseRepo}.
     *
     * @param _db The {@link DataBaseRepo} used for accessing data.
     */
    public MoneyController(DataBaseRepo _db) {
        this.db = _db;
    }

    /**
     * Retrieves the balance of the user associated with the provided token.
     *
     * @param token The token associated with the user.
     * @return The balance of the user. Returns 0 if the user is not found.
     */
    @Override
    public double getBalance(String token) {
        UserProvider user = db.getUserProvider(usp -> usp.mobileNum.equals(token));
        if (user == null)
            return 0;
        return user.balance;
    }

    /**
     * Transfers money from the user associated with the source token to the user
     * with the destination mobile number.
     *
     * @param token     The token associated with the source user.
     * @param desMobile The mobile number of the destination user.
     * @param amount    The amount of money to be transferred.
     * @return The {@link PaymentStat} indicating the status of the money transfer.
     */
    @Override
    public PaymentStat transferMoney(String token, String desMobile, double amount) {
        // Retrieve user provider details for the source and destination
        UserProvider source = db.getUserProvider(user -> user.mobileNum.equals(token));
        UserProvider dest = db.getUserProvider(user -> user.mobileNum.equals(desMobile));

        // Check if the destination user provider and account exist
        if (dest == null) {
            return PaymentStat.NOT_FOUND_PROVIDER;
        }
        User us = db.getUser(user -> user.getInstaAccount().getMobile().equals(desMobile));
        if (us == null) {
            return PaymentStat.NOT_FOUND_ACCOUNT;
        }

        // Create a MoneyProvider for the source user
        MoneyProvider mpSource = ProviderFactory.create(source);
        assert mpSource != null;

        // Attempt the money transfer
        PaymentStat stat = mpSource.transferMoney(source, dest, amount);

        // If the transfer is successful, update balances in the database
        if (stat == PaymentStat.DONE) {
            source.balance -= amount;
            dest.balance += amount;
            db.updateUserProvider(source);
            db.updateUserProvider(dest);
        }

        return stat;
    }
}
