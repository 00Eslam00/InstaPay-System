package classes;

import enums.AccountType;
import enums.PaymentStat;
import models.UserProvider;

public class WalletProvider extends MoneyProvider {

    @Override
    public PaymentStat transferMoney(UserProvider src, UserProvider dest, double amount) {
        if (dest.accountType == AccountType.WALLLET) {
            if (src.balance >= amount) {
                return PaymentStat.DONE;
            }
            return PaymentStat.NOT_ENOUGH_MONEY;
        }
        return PaymentStat.WRONG_PROVIDER;
    }

}
