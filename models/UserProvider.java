package models;

import enums.AccountType;

/**
 * The {@code UserProvider} class represents a user provider in the InstaPay
 * system.
 */
public class UserProvider {

    /** The mobile number associated with the user provider. */
    public String mobileNum;

    /** The account type associated with the user provider. */
    public AccountType accountType;

    /** The balance associated with the user provider. */
    public double balance;

    /**
     * Constructs a new {@code UserProvider} with the specified mobile number,
     * account type, and balance.
     *
     * @param mobileNum   The mobile number associated with the user provider.
     * @param accountType The account type associated with the user provider.
     * @param balance     The balance associated with the user provider.
     */
    public UserProvider(String mobileNum, AccountType accountType, double balance) {
        this.mobileNum = mobileNum;
        this.accountType = accountType;
        this.balance = balance;
    }

}
