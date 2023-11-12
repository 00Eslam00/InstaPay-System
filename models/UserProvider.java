package models;

import enums.AccountType;

public class UserProvider {
    public String mobileNum;
    public AccountType accountType;
    public double balane;

    public UserProvider(String mobileNum, AccountType accountType, double balane) {
        this.mobileNum = mobileNum;
        this.accountType = accountType;
        this.balane = balane;
    }

}
