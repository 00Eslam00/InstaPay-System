package views;

import interfaces.RegisterBehavior;

public class RegisterationPage extends Page {

    RegisterBehavior re;

    public RegisterationPage(RegisterBehavior _re) {
        re = _re;
    }

    @Override
    public void show() {
        System.out.println("i am registeration page");
    }

}