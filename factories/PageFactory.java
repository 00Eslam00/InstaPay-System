package factories;

import java.util.LinkedList;
import java.util.List;

import controllers.BillController;
import controllers.MoneyController;
import controllers.UserController;
import repository.DataBaseRepo;
import repository.DataBaseV1;
import views.BalancePage;
import views.LoginPage;
import views.LogoutPage;
import views.NotFoundPage;
import views.Page;
import views.PayBillPage;
import views.RegisterationPage;
import views.TransferMoneyPage;

/**
 * Factory class for creating different pages based on user input.
 * Manages the creation of pages and options based on the provided parameters.
 */
public class PageFactory {

    /**
     * Checks if the provided token is valid.
     *
     * @param token The token to be checked for validity.
     * @return True if the token is not null, otherwise false.
     */
    boolean isValidToken(String token) {
        return token != null;
    }

    /**
     * Creates a page based on the given page name and token.
     *
     * @param pageName The name of the page to be created.
     * @param token    The user token for authentication.
     * @return The created page instance.
     */
    public Page createPage(String pageName, String token) {

        if ("exit".equals(pageName))
            return null;

        DataBaseRepo db = DataBaseV1.getDB();

        if (isValidToken(token)) {
            if ("balance".equals(pageName))
                return new BalancePage(new MoneyController(db));

            if ("bills".equals(pageName))
                return new PayBillPage(new BillController(db), new BillController(db));

            if ("money".equals(pageName))
                return new TransferMoneyPage(new MoneyController(db));

            if ("logout".equals(pageName))
                return new LogoutPage();

        } else {
            if ("signup".equals(pageName))
                return new RegisterationPage(new UserController(db));

            if ("login".equals(pageName))
                return new LoginPage(new UserController(db));
        }

        return new NotFoundPage();
    }

    /**
     * Creates a list of options based on the provided token.
     *
     * @param token The user token for authentication.
     * @return A list of options available to the user.
     */
    public List<String> createOptions(String token) {
        List<String> options = new LinkedList<>();

        if (isValidToken(token)) {
            options.add("(balance) show your balance");
            options.add("(bills) pay bills from your balance");
            options.add("(money) transfer money from your balance");
            options.add("(logout) logout from this account");
        } else {
            options.add("(signup) create a new account");
            options.add("(login) login with your account");
        }

        options.add("(exit) exit from the application");
        return options;
    }
}
