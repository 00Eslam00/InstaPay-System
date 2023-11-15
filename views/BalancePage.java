package views;

import interfaces.BalanceBehavior;

/**
 * Represents a page displaying the user's balance.
 * Extends the Page class and uses a BalanceBehavior implementation to retrieve and display the balance.
 */
public class BalancePage extends Page {

    private BalanceBehavior bb;

    /**
     * Constructs a BalancePage with the specified BalanceBehavior.
     *
     * @param bb The BalanceBehavior implementation to be used for retrieving the balance.
     */
    public BalancePage(BalanceBehavior bb) {
        this.bb = bb;
    }

    /**
     * Displays the user's balance using the provided BalanceBehavior implementation.
     * Prints the balance and a friendly message.
     */
    @Override
    public void show() {
        System.out.println("Your balance is " + bb.getBalance(app.getToken()));
        System.out.println("Have a nice day, sir :)");
    }

}
