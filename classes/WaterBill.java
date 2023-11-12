package classes;

import java.time.LocalDateTime;

public class WaterBill extends Bill {

    public WaterBill(double cost, String userNum, LocalDateTime localDateTime) {
        super(cost, userNum, localDateTime);
    }

    @Override
    public String getBillContent() {
        throw new UnsupportedOperationException("Unimplemented method 'getBillContent'");
    }

}
