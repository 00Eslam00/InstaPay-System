package views;

import classes.Bill;
import enums.BillStat;
import enums.BillType;
import interfaces.GetBillBehavior;
import interfaces.PayBillBehavior;

import java.util.Scanner;

/**
 * Represents a page for paying bills in the InstaPay application.
 * Extends the Page class and uses PayBillBehavior and GetBillBehavior implementations for bill payment.
 */
public class PayBillPage extends Page {

    private PayBillBehavior pb;
    private GetBillBehavior gb;

    /**
     * Constructs a PayBillPage with the specified PayBillBehavior and GetBillBehavior.
     *
     * @param pb The PayBillBehavior implementation used for bill payment.
     * @param gb The GetBillBehavior implementation used for retrieving bill details.
     */
    public PayBillPage(PayBillBehavior pb, GetBillBehavior gb) {
        this.pb = pb;
        this.gb = gb;
    }

    /**
     * Displays the page for paying bills, prompts the user for the bill type, and processes the payment.
     * Utilizes the PayBillBehavior and GetBillBehavior implementations.
     */
    @Override
    public void show() {
        System.out.println("Enter the bill type");
        Scanner in = new Scanner(System.in);
        String option = in.nextLine().toUpperCase();

        BillType type;
        try {
            type = BillType.valueOf(option);
        } catch (Exception e) {
            System.out.println("Unsupported bill type");
            return;
        }

        Bill myBill = gb.getBillDetails(type, app.getToken());

        if (myBill == null) {
            System.out.println("There are no bills");
            return;
        }
        System.out.println(myBill.getBillContent());

        System.out.println("Do you want to pay? Press 'y'");
        String confirmation = in.nextLine().toUpperCase();
        if (confirmation.equals("Y")) {
            BillStat state = pb.payBill(app.getToken(), myBill, type);
            switch (state) {
                case PAID:
                    System.out.println("Bill has been paid successfully");
                    break;
                case NOT_ENOUGH_MONEY:
                    System.out.println("Sorry, your balance is not enough to pay");
                    break;
                default:
                    break;
            }
        }
    }
}
