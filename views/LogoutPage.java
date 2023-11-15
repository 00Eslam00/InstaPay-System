package views;

/**
 * Represents a page for user logout in the InstaPay application.
 * Extends the Page class and handles the logout operation.
 */
public class LogoutPage extends Page {

    /**
     * Displays the logout page and logs out the user.
     */
    @Override
    public void show() {
        System.out.println("You have been logged out");
        app.setToken(null);
    }

}
