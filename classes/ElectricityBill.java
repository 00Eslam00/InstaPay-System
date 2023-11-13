package classes;

import java.time.LocalDateTime;

public class ElectricityBill extends Bill {

    public ElectricityBill(double cost, String userNum, LocalDateTime localDateTime) {
        super(cost, userNum, localDateTime);
    }

    @Override
    public String getBillContent() {
        StringBuilder billContent = new StringBuilder();
        billContent.append("Electricity bill:\n");
        billContent.append("Value due: $ " + getCost() + "\n");
        billContent.append("Mobile number" + getUserNum() + "\n");
        billContent.append("Bill Date" + getBillDate().toString() + "\n");

        return billContent.toString();
    }

}
