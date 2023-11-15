package models;

import enums.AccountType;

/**
 * The {@code InstaPayAccount} class represents an InstaPay user account.
 */
public class InstaPayAccount {

    private String mobile;
    private String userName;
    private String email;
    private AccountType accountType;

    /**
     * Constructs a new {@code InstaPayAccount} with the specified mobile number,
     * username, email, and account type.
     *
     * @param mobile      The mobile number associated with the account.
     * @param userName    The username associated with the account.
     * @param email       The email associated with the account.
     * @param accountType The account type of the account.
     */
    public InstaPayAccount(String mobile, String userName, String email, AccountType accountType) {
        this.mobile = mobile;
        this.userName = userName;
        this.email = email;
        this.accountType = accountType;
    }

    /**
     * Gets the mobile number associated with the account.
     *
     * @return The mobile number associated with the account.
     */
    public String getMobile() {
        return this.mobile;
    }

    /**
     * Sets the mobile number associated with the account.
     *
     * @param mobile The new mobile number.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the username associated with the account.
     *
     * @return The username associated with the account.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Sets the username associated with the account.
     *
     * @param userName The new username.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the email associated with the account.
     *
     * @return The email associated with the account.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email associated with the account.
     *
     * @param email The new email.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the account type of the account.
     *
     * @return The account type of the account.
     */
    public AccountType getAccountType() {
        return this.accountType;
    }

    /**
     * Sets the account type of the account.
     *
     * @param accountType The new account type.
     */
    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

}
