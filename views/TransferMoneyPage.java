package views;

import enums.PaymentStat;
import interfaces.TransferMoneyBehavior;

import java.util.Scanner;
/**
 * Represents a page for transferring money in the InstaPay application.
 * Extends the Page class and uses a TransferMoneyBehavior implementation for money transfer.
 */
public class TransferMoneyPage extends Page {

    private TransferMoneyBehavior tm;

    /**
     * Constructs a TransferMoneyPage with the specified TransferMoneyBehavior.
     *
     * @param tm The TransferMoneyBehavior implementation used for money transfer.
     */
    public TransferMoneyPage(TransferMoneyBehavior tm) {
        this.tm = tm;
    }

    /**
     * Displays the page for transferring money, prompts the user for transfer details, and processes the money transfer.
     * Utilizes the TransferMoneyBehavior implementation for money transfer.
     */
    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        String destMobile;
        double amount;
        System.out.print("Enter amount: ");
        amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter destination number: ");
        destMobile = scanner.nextLine();
        PaymentStat ps = tm.transferMoney(app.token, destMobile, amount);
        switch (ps) {
            case DONE -> System.out.println("Transfer Done");
            case NOT_ENOUGH_MONEY -> System.out.println("Please ensure you have enough money");
            case WRONG_PROVIDER -> System.out.println("Wrong Money Provider");
            case NOT_FOUND_ACCOUNT -> System.out.println("No account has been detected linked with this number");
            case NOT_FOUND_PROVIDER -> System.out.println("This number doesn't have bank or wallet");
        }


    }
}

