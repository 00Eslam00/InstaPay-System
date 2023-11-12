package interfaces;

import classes.Bill;
import enums.BillStat;
import enums.BillType;

public interface PayBillBehavior {
    BillStat payBill(String token, Bill bill, BillType billtType);
}
