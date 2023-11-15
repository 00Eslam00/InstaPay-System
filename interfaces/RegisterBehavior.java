package interfaces;

import enums.RegestrationStat;
import models.User;

/**
 * The {@code RegisterBehavior} interface defines the behavior for user
 * registration.
 * Classes implementing this interface should provide an implementation for the
 * {@link #Register(User)} method.
 */
public interface RegisterBehavior {

    /**
     * Registers a new user based on the provided {@link User} information.
     *
     * @param user The {@link User} to be registered.
     * @return An array of {@link RegestrationStat} indicating the registration
     *         status.
     */
    RegestrationStat[] Register(User user);
}
