package interfaces;

import models.LogUser;

/**
 * The {@code LoginBehavior} interface defines the behavior for user login.
 * Classes implementing this interface should provide an implementation for the
 * {@link #Login(LogUser)} method.
 */
public interface LoginBehavior {

    /**
     * Attempts to log in a user based on the provided login information.
     *
     * @param loguser The {@link LogUser} containing login information (username and
     *                password).
     * @return The mobile number associated with the logged-in user, or {@code null}
     *         if login fails.
     */
    String Login(LogUser loguser);
}
