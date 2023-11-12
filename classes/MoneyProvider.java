package classes;

import enums.PaymentStat;
import models.UserProvider;

abstract public class MoneyProvider {
    abstract public PaymentStat transferMoney(UserProvider src, UserProvider dest, double amount);
}
