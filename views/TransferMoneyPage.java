package views;

import enums.PaymentStat;
import interfaces.TransferMoneyBehavior;

import java.util.Scanner;

public class TransferMoneyPage extends Page {

    private TransferMoneyBehavior tm;

    public TransferMoneyPage(TransferMoneyBehavior tm) {
        this.tm = tm;
    }

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

