package views;

import interfaces.BalanceBehavior;

public class BalancePage extends Page {

    private BalanceBehavior bb;

    public BalancePage(BalanceBehavior bb) {
        this.bb = bb;
    }

    @Override
    public void show() {
        System.out.println("Your balance is " + bb.getBalance(app.getToken()));
        System.out.println("have a nice day, sir :)");
    }

}
