package views;

import java.util.List;
import java.util.Scanner;

import factories.PageFactory;

/**
 * Represents the main application for the InstaPay system.
 * Manages the user interface and navigation through different pages.
 * Extends the Application class.
 */
public class InstaPayApplication extends Application {

    private PageFactory pageFactory;

    /**
     * Constructs an InstaPayApplication with a default PageFactory.
     */
    public InstaPayApplication() {
        this.pageFactory = new PageFactory();
    }

    /**
     * Loads and manages the user interface for the InstaPay application.
     * Displays a menu of options, processes user input, and navigates through different pages accordingly.
     */
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
            System.out.print("\nPress Enter to return to the main menu: ");
            scanner.nextLine();
            System.out.print("\033[H\033[2J");
            System.out.flush();

        } while (p != null);
        scanner.close();
    }
}
