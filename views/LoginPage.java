package views;

import interfaces.LoginBehavior;

public class LoginPage extends Page {

    LoginBehavior lb;

    public LoginPage(LoginBehavior _lb) {
        lb = _lb;
    }

    @Override
    public void show() {
        // LogUser userCred;
        // Scanner scanner = new Scanner(System.in);
        // String num;
        // String pass;
        // System.out.print("Enter your phone number : ");
        // num = scanner.nextLine();
        // System.out.print("Enter your password : ");
        // pass = scanner.nextLine();

        // userCred = new LogUser(num, pass);
        // System.out.println(userCred);
        // System.out.println("token is " + lb.Login(userCred));
        // app.setToken(lb.Login(userCred));
    }

}