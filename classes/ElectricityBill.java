package classes;

import java.time.LocalDateTime;

public class ElectricityBill extends Bill {

    public ElectricityBill(double cost, String userNum, LocalDateTime localDateTime) {
        super(cost, userNum, localDateTime);
    }

    @Override
    public String getBillContent() {
        throw new UnsupportedOperationException("Unimplemented method 'getBillContent'");
    }

}
