package interfaces;

import classes.Bill;
import enums.BillType;

public interface GetBillBehavior {

    Bill getBillDetails(BillType billType, String mobile);
}
