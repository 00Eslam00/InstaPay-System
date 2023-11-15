package models;

/**
 * The {@code LogUser} class represents a user for authentication purposes.
 */
public class LogUser {

    /** The username of the user. */
    public String userName;

    /** The password of the user. */
    public String password;

    /**
     * Constructs a new {@code LogUser} with the specified username and password.
     *
     * @param userName The username of the user.
     * @param password The password of the user.
     */
    public LogUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Returns a string representation of the {@code LogUser} object.
     *
     * @return A string representation of the object.
     */
    @Override
    public String toString() {
        return "{" +
                " userName='" + userName + "'" +
                ", password='" + password + "'" +
                "}";
    }

}
