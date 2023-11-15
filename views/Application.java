package views;

/**
 * The abstract Application class serves as a base class for application views.
 * It includes a token to manage user authentication and provides methods to
 * access and set the token.
 * Subclasses must implement the loadView method to define the behavior of
 * loading the specific application view.
 */
abstract public class Application {
    // The authentication token for user identification
    protected String token;

    /**
     * Constructs an Application object with an initial token set to null.
     */
    Application() {
        token = null;
    }

    /**
     * Gets the authentication token associated with the user.
     *
     * @return The authentication token.
     */
    public String getToken() {
        return this.token;
    }

    /**
     * Sets the authentication token for the user.
     *
     * @param token The authentication token to set.
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Abstract method that must be implemented by subclasses to define the behavior
     * of loading the specific application view.
     */
    abstract public void loadView();
}
