package classes;

import enums.PaymentStat;
import models.UserProvider;

public class BankProvider extends MoneyProvider {

    @Override
    public PaymentStat transferMoney(UserProvider src, UserProvider dest, double amount) {

        if (src.balance >= amount) {
            return PaymentStat.DONE;
        }
        return PaymentStat.NOT_ENOUGH_MONEY;

    }

}
