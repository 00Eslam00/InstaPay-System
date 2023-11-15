package views;

/**
 * Represents a page displayed when a requested page is not found in the InstaPay application.
 * Extends the Page class and provides a visually distinctive message.
 */
public class NotFoundPage extends Page {

    /**
     * Displays the not found page with a visually distinctive message.
     */
    @Override
    public void show() {
        System.out.println(" _  _    ___  _  _     _   _       _     _____                     _ ");
        System.out.println("| || |  / _ \\| || |   | \\ | | ___ | |_  |  ___|__  _   _ _ __   __| |");
        System.out.println("| || |_| | | | || |_  |  \\| |/ _ \\| __| | |_ / _ \\| | | | '_ \\ / _` |");
        System.out.println("|__   _| |_| |__   _| | |\\  | (_) | |_  |  _| (_) | |_| | | | | (_| |");
        System.out.println("   |_|  \\___/   |_|   |_| \\_|\\___/ \\__| |_|  \\___/ \\__,_|_| |_|\\__,_|");
    }

}
