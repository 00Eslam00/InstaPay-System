package classes;

import java.time.LocalDateTime;

/**
 * The {@code Bill} abstract class represents a generic bill with common
 * attributes and behavior.
 * Classes extending this abstract class should provide an implementation for
 * the {@link #getBillContent()} method.
 */
abstract public class Bill {

    private double cost;
    private String userNum;
    private LocalDateTime billDate;

    /**
     * Constructs a new {@code Bill} with the specified cost, user number, and bill
     * date.
     *
     * @param cost     The cost of the bill.
     * @param userNum  The user number associated with the bill.
     * @param billDate The date when the bill was generated.
     */
    public Bill(double cost, String userNum, LocalDateTime billDate) {
        this.cost = cost;
        this.userNum = userNum;
        this.billDate = billDate;
    }

    /**
     * Gets the cost of the bill.
     *
     * @return The cost of the bill.
     */
    public double getCost() {
        return this.cost;
    }

    /**
     * Gets the user number associated with the bill.
     *
     * @return The user number associated with the bill.
     */
    public String getUserNum() {
        return this.userNum;
    }

    /**
     * Gets the date when the bill was generated.
     *
     * @return The date when the bill was generated.
     */
    public LocalDateTime getBillDate() {
        return this.billDate;
    }

    /**
     * Abstract method to get the content/details of the bill.
     *
     * @return A string representing the content/details of the bill.
     */
    abstract public String getBillContent();
}
