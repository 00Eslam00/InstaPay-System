package models;

import enums.AccountType;

public class UserProvider {
    public String mobileNum;
    public AccountType accountType;
    public double balance;

    public UserProvider(String mobileNum, AccountType accountType, double balance) {
        this.mobileNum = mobileNum;
        this.accountType = accountType;
        this.balance = balance;
    }

}
