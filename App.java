import views.Application;
import views.InstaPayApplication;

/**
 * The App class serves as the entry point for the InstaPay application.
 * It initializes an instance of InstaPayApplication and calls the loadView
 * method to start the application.
 */
public class App {
    /**
     * The main method is the entry point for the InstaPay application.
     *
     * @param args Command line arguments (not used in this application).
     * @throws Exception If an exception occurs during the execution of the
     *                   application.
     */
    public static void main(String[] args) throws Exception {
        // Initialize an instance of InstaPayApplication
        Application app = new InstaPayApplication();

        // Call the loadView method to start the application
        app.loadView();
    }
}
