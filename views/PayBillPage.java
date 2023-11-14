package views;

import classes.Bill;
import enums.BillStat;
import enums.BillType;
import interfaces.GetBillBehavior;
import interfaces.PayBillBehavior;

import java.util.Scanner;

public class PayBillPage extends Page {

    private PayBillBehavior pb;
    private GetBillBehavior gb;

    public PayBillPage(PayBillBehavior pb, GetBillBehavior gb) {
        this.pb = pb;
        this.gb = gb;
    }

    @Override
    public void show() {
        System.out.println("Enter the bill type");
        Scanner in = new Scanner(System.in);
        String option = in.nextLine().toUpperCase();

        BillType type;
        try {
            type = BillType.valueOf(option);
        } catch (Exception e) {
            System.out.println("unsupported bill type");
            return;
        }

        Bill myBill = gb.getBillDetails(type, app.token);

        if (myBill == null) {
            System.out.println("there are no bills");
            return;
        }
        System.out.println(myBill.getBillContent());

        System.out.println("Do you want to pay? press y");
        String confirmation = in.nextLine().toUpperCase();
        if (confirmation.equals("Y")) {
            BillStat state = pb.payBill(app.token, myBill, type);
            switch (state) {
                case PAID:
                    System.out.println("bill has been paid successfully");
                    break;
                case NOT_ENOUGH_MONEY:
                    System.out.println("sorry your balance not enough to pay");
                default:
                    break;
            }

        }

    }
}
