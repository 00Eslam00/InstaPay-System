package classes;

import java.time.LocalDateTime;

/**
 * The {@code ElectricityBill} class represents an electricity bill, extending
 * the {@link Bill} class.
 */
public class ElectricityBill extends Bill {

    /**
     * Constructs a new {@code ElectricityBill} with the specified cost, user
     * number, and bill date.
     *
     * @param cost          The cost of the electricity bill.
     * @param userNum       The user number associated with the electricity bill.
     * @param localDateTime The date when the electricity bill was generated.
     */
    public ElectricityBill(double cost, String userNum, LocalDateTime localDateTime) {
        super(cost, userNum, localDateTime);
    }

    /**
     * Gets the content/details of the electricity bill.
     *
     * @return A string representing the content/details of the electricity bill.
     */
    @Override
    public String getBillContent() {
        StringBuilder billContent = new StringBuilder();
        billContent.append("Electricity bill:\n");
        billContent.append("Value due: $ " + getCost() + "\n");
        billContent.append("Mobile number: " + getUserNum() + "\n");
        billContent.append("Bill Date: " + getBillDate().toString() + "\n");

        return billContent.toString();
    }

}
