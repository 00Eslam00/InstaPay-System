package repository;

import java.util.function.Function;

import classes.Bill;
import enums.BillType;
import models.User;
import models.UserProvider;

/**
 * The {@code DataBaseRepo} abstract class represents a data repository for the
 * InstaPay system.
 * Classes extending this abstract class should provide implementations for
 * various data operations.
 */
abstract public class DataBaseRepo {

    /**
     * Adds a user to the data repository.
     *
     * @param user The user to be added.
     * @return {@code true} if the user is successfully added, {@code false}
     *         otherwise.
     */
    abstract public Boolean addUser(User user);

    /**
     * Gets a user from the data repository based on the provided function.
     *
     * @param func The function used to search for the user.
     * @return The user found, or {@code null} if not found.
     */
    abstract public User getUser(Function<User, Boolean> func);

    /**
     * Gets a bill from the data repository based on the bill type and provided
     * function.
     *
     * @param billtype The type of the bill to retrieve.
     * @param func     The function used to search for the bill.
     * @return The bill found, or {@code null} if not found.
     */
    abstract public Bill getBill(BillType billtype, Function<Bill, Boolean> func);

    /**
     * Removes a bill from the data repository based on the bill type and provided
     * function.
     *
     * @param billtype The type of the bill to remove.
     * @param func     The function used to search for the bill to be removed.
     * @return {@code true} if the bill is successfully removed, {@code false}
     *         otherwise.
     */
    abstract public Boolean removeBill(BillType billtype, Function<Bill, Boolean> func);

    /**
     * Gets a user provider from the data repository based on the provided function.
     *
     * @param func The function used to search for the user provider.
     * @return The user provider found, or {@code null} if not found.
     */
    abstract public UserProvider getUserProvider(Function<UserProvider, Boolean> func);

    /**
     * Updates a user provider in the data repository.
     *
     * @param user The updated user provider.
     * @return {@code true} if the user provider is successfully updated,
     *         {@code false} otherwise.
     */
    abstract public Boolean updateUserProvider(UserProvider user);

}
