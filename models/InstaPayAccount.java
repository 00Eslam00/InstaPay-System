package models;

import enums.AccountType;

public class InstaPayAccount {
    private String mobile;
    private String userName;
    private String email;
    private AccountType accountType;

    public InstaPayAccount(String mobile, String userName, String email, AccountType accountType) {
        this.mobile = mobile;
        this.userName = userName;
        this.email = email;
        this.accountType = accountType;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}
