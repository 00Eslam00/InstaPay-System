package models;
public class LogUser {
    public String userName;
    public String password;

    public LogUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
                " userName='" + userName + "'" +
                ", password='" + password + "'" +
                "}";
    }

}
