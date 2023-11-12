package classes;

import java.time.LocalDateTime;

public class GasBill extends Bill {

    public GasBill(double cost, String userNum, LocalDateTime localDateTime) {
        super(cost, userNum, localDateTime);
    }

    @Override
    public String getBillContent() {
        throw new UnsupportedOperationException("Unimplemented method 'getBillContent'");
    }

}
