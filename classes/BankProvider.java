package classes;

import enums.PaymentStat;
import models.UserProvider;

public class BankProvider extends MoneyProvider {

    @Override
    public PaymentStat transferMoney(UserProvider src, UserProvider dest, double amount) {
        throw new UnsupportedOperationException("Unimplemented method 'transferMoney'");
    }

}
