package views;

public class LogoutPage extends Page {

    @Override
    public void show() {
        System.out.println("you have been logged out");
        app.token = null;
    }

}
