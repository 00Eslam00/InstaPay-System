package factories;

import classes.BankProvider;
import classes.MoneyProvider;
import classes.WalletProvider;
import models.UserProvider;

public class ProviderFactory {

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
