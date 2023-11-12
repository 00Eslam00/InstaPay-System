package views;

abstract public class Application {
    protected String token;

    Application() {
        token = null;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    abstract public void loadView();

}
