package classes;

import java.time.LocalDateTime;

abstract public class Bill {
    private double cost;
    private String userNum;
    private LocalDateTime billDate;

    public Bill(double cost, String userNum, LocalDateTime billDate) {
        this.cost = cost;
        this.userNum = userNum;
        this.billDate = billDate;
    }

    public double getCost() {
        return this.cost;
    }

    public String getUserNum() {
        return this.userNum;
    }

    public LocalDateTime getBillDate() {
        return this.billDate;
    }

    abstract public String getBillContent();
}
