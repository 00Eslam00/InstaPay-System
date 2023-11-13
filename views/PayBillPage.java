package views;

import classes.Bill;
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

        BillType type = BillType.valueOf(option);


        Bill myBill=gb.getBillDetails(type,app.token);
        System.out.println(myBill.getBillContent());



    }
}
