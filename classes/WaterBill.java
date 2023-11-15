package classes;

import java.time.LocalDateTime;

/**
 * The {@code WaterBill} class represents a water bill, extending the
 * {@link Bill} class.
 */
public class WaterBill extends Bill {

    /**
     * Constructs a new {@code WaterBill} with the specified cost, user number, and
     * bill date.
     *
     * @param cost          The cost of the water bill.
     * @param userNum       The user number associated with the water bill.
     * @param localDateTime The date when the water bill was generated.
     */
    public WaterBill(double cost, String userNum, LocalDateTime localDateTime) {
        super(cost, userNum, localDateTime);
    }

    /**
     * Gets the content/details of the water bill.
     *
     * @return A string representing the content/details of the water bill.
     */
    @Override
    public String getBillContent() {
        StringBuilder billContent = new StringBuilder();
        billContent.append("Water bill:\n");
        billContent.append("Value due: $ " + getCost() + "\n");
        billContent.append("Mobile number: " + getUserNum() + "\n");
        billContent.append("Bill Date: " + getBillDate().toString() + "\n");

        return billContent.toString();
    }

}
