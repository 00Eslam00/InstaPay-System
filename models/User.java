package models;

import enums.AccountType;

/**
 * The {@code User} class represents a user in the InstaPay system.
 */
public class User {

    /** The InstaPay account associated with the user. */
    private InstaPayAccount instaAccount;

    /** The password for authentication. */
    private String password;

    /**
     * Constructs a new {@code User} with the specified mobile number, username,
     * account type, email, and password.
     *
     * @param mobile   The mobile number associated with the user.
     * @param userName The username associated with the user.
     * @param acctype  The account type associated with the user.
     * @param email    The email associated with the user.
     * @param password The password for authentication.
     */
    public User(String mobile, String userName, AccountType acctype, String email, String password) {
        this.instaAccount = new InstaPayAccount(mobile, userName, email, acctype);
        this.password = password;
    }

    /**
     * Gets the InstaPay account associated with the user.
     *
     * @return The InstaPay account associated with the user.
     */
    public InstaPayAccount getInstaAccount() {
        return this.instaAccount;
    }

    /**
     * Sets the InstaPay account associated with the user.
     *
     * @param instaAccount The new InstaPay account.
     */
    public void setInstaAccount(InstaPayAccount instaAccount) {
        this.instaAccount = instaAccount;
    }

    /**
     * Gets the password for authentication.
     *
     * @return The password for authentication.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the password for authentication.
     *
     * @param password The new password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

}
