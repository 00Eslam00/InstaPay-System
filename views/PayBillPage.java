package views;

import interfaces.GetBillBehavior;
import interfaces.PayBillBehavior;

public class PayBillPage extends Page {

    private PayBillBehavior pb;
    private GetBillBehavior gb;

    public PayBillPage(PayBillBehavior pb, GetBillBehavior gb) {
        this.pb = pb;
        this.gb = gb;
    }

    @Override
    public void show() {
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

}
