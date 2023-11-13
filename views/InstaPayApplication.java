package views;

import java.util.List;
import java.util.Scanner;

import factories.PageFactory;

public class InstaPayApplication extends Application {

    private PageFactory pageFactory;

    public InstaPayApplication() {
        this.pageFactory = new PageFactory();
    }

    @Override
    public void loadView() {
        Scanner scanner = new Scanner(System.in);
        String option = null;
        Page p = null;

        do {
            List<String> options = pageFactory.createOptions(token);
            for (String op : options) {
                System.out.println(op);
            }
            System.out.print("\nChoose option : ");
            option = scanner.nextLine();
            p = pageFactory.createPage(option, token);

            if (p == null)
                break;

            p.setApp(this);
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("--------------- " + option + " ---------------");
            p.show();
            System.out.print("\npress Enter to return to main menu: ");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();

        } while (p != null);
        scanner.close();
    }
}