package classes;

import enums.AccountType;
import enums.PaymentStat;
import models.UserProvider;

/**
 * The {@code WalletProvider} class represents a money provider with
 * wallet-specific transfer behavior.
 * It extends the {@link MoneyProvider} class.
 */
public class WalletProvider extends MoneyProvider {

    /**
     * Transfers money from the source user provider to the destination user
     * provider.
     * Wallet-specific behavior is implemented here.
     *
     * @param src    The source {@link UserProvider}.
     * @param dest   The destination {@link UserProvider}.
     * @param amount The amount of money to be transferred.
     * @return The {@link PaymentStat} indicating the status of the money transfer.
     */
    @Override
    public PaymentStat transferMoney(UserProvider src, UserProvider dest, double amount) {
        // Wallet-specific transfer logic
        if (dest.accountType == AccountType.WALLET) {
            if (src.balance >= amount) {
                return PaymentStat.DONE;
            }
            return PaymentStat.NOT_ENOUGH_MONEY;
        }
        return PaymentStat.WRONG_PROVIDER;
    }

}
