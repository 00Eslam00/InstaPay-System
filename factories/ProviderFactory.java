package factories;

import classes.BankProvider;
import classes.MoneyProvider;
import classes.WalletProvider;
import models.UserProvider;

/**
 * Factory class for creating MoneyProvider instances based on the account type of a UserProvider.
 * Supports creating BankProvider and WalletProvider instances.
 */
public class ProviderFactory {

    /**
     * Creates a MoneyProvider instance based on the account type of the provided UserProvider.
     *
     * @param srcProvider The UserProvider instance for which the MoneyProvider is created.
     * @return A MoneyProvider instance corresponding to the account type of the UserProvider.
     */
    public static MoneyProvider create(UserProvider srcProvider) {

        switch (srcProvider.accountType) {
            case BANK:
                return new BankProvider();
            case WALLET:
                return new WalletProvider();
            default:
                return null;
        }
    }
}
