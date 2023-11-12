package views;

abstract public class Page {

    protected Application app;

    public Application getApp() {
        return this.app;
    }

    public void setApp(Application app) {
        this.app = app;
    }

    abstract public void show();
}