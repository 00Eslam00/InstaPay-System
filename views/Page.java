package views;

/**
 * The abstract Page class represents a page within an application. It includes
 * a reference to the associated Application
 * and provides methods to get and set the application.
 * Subclasses must implement the show method to define the behavior of
 * displaying the specific page.
 */
abstract public class Page {
    // The application associated with the page
    protected Application app;

    /**
     * Gets the associated Application.
     *
     * @return The Application object.
     */
    public Application getApp() {
        return this.app;
    }

    /**
     * Sets the associated Application for the page.
     *
     * @param app The Application object to set.
     */
    public void setApp(Application app) {
        this.app = app;
    }

    /**
     * Abstract method that must be implemented by subclasses to define the behavior
     * of displaying the specific page.
     */
    abstract public void show();
}
