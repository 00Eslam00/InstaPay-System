import views.Application;
import views.InstaPayApplication;

public class App {
    public static void main(String[] args) throws Exception {
        Application app = new InstaPayApplication();
        app.loadView();
    }
}
