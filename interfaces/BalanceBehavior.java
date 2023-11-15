package interfaces;

/**
 * The {@code BalanceBehavior} interface defines the behavior for retrieving the
 * balance of a user.
 * Classes implementing this interface should provide an implementation for the
 * {@link #getBalance(String)} method.
 */
public interface BalanceBehavior {

    /**
     * Retrieves the balance of the user associated with the provided token.
     *
     * @param token The token associated with the user.
     * @return The balance of the user.
     */
    double getBalance(String token);
}
