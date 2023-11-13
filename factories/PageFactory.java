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
import views.NotFoundPage;
import views.Page;
import views.PayBillPage;
import views.RegisterationPage;
import views.TransferMoneyPage;

public class PageFactory {

    boolean isValidToekn(String token) {
        if (token == null)
            return false;
        return true;
    }

    public Page createPage(String pageName, String token) {

        if (pageName.equals("exit"))
            return null;

        DataBaseRepo db = DataBaseV1.getDB();

        if (isValidToekn(token)) {
            if (pageName.equals("balance"))
                return new BalancePage(new MoneyController(db));

            if (pageName.equals("bills"))
                return new PayBillPage(new BillController(db), new BillController(db));

            if (pageName.equals("money"))
                return new TransferMoneyPage(new MoneyController(db));

        } else {
            if (pageName.equals("signup"))
                return new RegisterationPage(new UserController(db));

            if (pageName.equals("login"))
                return new LoginPage(new UserController(db));
        }

        return new NotFoundPage();
    }

    public List<String> createOptions(String Token) {
        List<String> options = new LinkedList<String>();

        if (isValidToekn(Token)) {
            options.add("(balance) show your balance");
            options.add("(bills) pay bills your balance");
            options.add("(money) transfer money  your balance");
        } else {
            options.add("(signup) create new account");
            options.add("(login) login with your account");
        }

        options.add("(exit) exit from application");
        return options;
    }

}
