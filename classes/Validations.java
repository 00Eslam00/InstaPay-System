package classes;

import enums.AccountType;
import repository.DataBaseRepo;

/**
 * The {@code Validations} class provides static methods for common validation
 * tasks.
 */
public class Validations {

    /**
     * Validates a mobile number.
     *
     * @param mob The mobile number to validate.
     * @return {@code true} if the mobile number is valid, {@code false} otherwise.
     */
    public static boolean validateMobile(String mob) {
        for (char c : mob.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return (mob.length() == 11);
    }

    /**
     * Validates a mobile number based on the account type using a
     * {@link DataBaseRepo}.
     *
     * @param mob         The mobile number to validate.
     * @param accountType The account type associated with the mobile number.
     * @param db          The {@link DataBaseRepo} used for validation.
     * @return {@code true} if the mobile number is valid for the given account
     *         type, {@code false} otherwise.
     */
    public static boolean validateMobile(String mob, AccountType accountType, DataBaseRepo db) {
        return db.getUserProvider(usr -> usr.mobileNum.equals(mob) && usr.accountType.equals(accountType)) != null;
    }

    /**
     * Checks if a username is unique using a {@link DataBaseRepo}.
     *
     * @param s  The username to check for uniqueness.
     * @param db The {@link DataBaseRepo} used for validation.
     * @return {@code true} if the username is unique, {@code false} otherwise.
     */
    public static boolean uniqueUsername(String s, DataBaseRepo db) {
        return db.getUser(usr -> usr.getInstaAccount().getUserName().equals(s)) == null;
    }

}
