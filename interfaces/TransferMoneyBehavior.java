package interfaces;

import enums.PaymentStat;

public interface TransferMoneyBehavior {
    PaymentStat transferMoney(String token, String desMobile, double amount);
}
