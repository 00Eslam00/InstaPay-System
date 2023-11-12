package models;

import enums.AccountType;

public class User {
    private InstaPayAccount instaAccount;
    private String password;

    public User(String mobile, String userName, AccountType acctype, String email, String password) {
        this.instaAccount = new InstaPayAccount(mobile, userName, email, acctype);
        this.password = password;
    }


    public InstaPayAccount getInstaAccount() {
        return this.instaAccount;
    }

    public void setInstaAccount(InstaPayAccount instaAccount) {
        this.instaAccount = instaAccount;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}