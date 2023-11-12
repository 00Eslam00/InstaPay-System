package views;

import interfaces.TransferMoneyBehavior;

public class TransferMoneyPage extends Page {

    private TransferMoneyBehavior tm;

    public TransferMoneyPage(TransferMoneyBehavior tm) {
        this.tm = tm;
    }

    @Override
    public void show() {
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

}
