package classes;

import java.time.LocalDateTime;

/**
 * The {@code GasBill} class represents a gas bill, extending the {@link Bill}
 * class.
 */
public class GasBill extends Bill {

    /**
     * Constructs a new {@code GasBill} with the specified cost, user number, and
     * bill date.
     *
     * @param cost          The cost of the gas bill.
     * @param userNum       The user number associated with the gas bill.
     * @param localDateTime The date when the gas bill was generated.
     */
    public GasBill(double cost, String userNum, LocalDateTime localDateTime) {
        super(cost, userNum, localDateTime);
    }

    /**
     * Gets the content/details of the gas bill.
     *
     * @return A string representing the content/details of the gas bill.
     */
    @Override
    public String getBillContent() {
        StringBuilder billContent = new StringBuilder();
        billContent.append("Gas bill:\n");
        billContent.append("Value due: $ " + getCost() + "\n");
        billContent.append("Mobile number: " + getUserNum() + "\n");
        billContent.append("Bill Date: " + getBillDate().toString() + "\n");

        return billContent.toString();
    }

}
