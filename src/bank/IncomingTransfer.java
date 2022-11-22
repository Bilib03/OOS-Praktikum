package bank;

import java.util.List;

public class IncomingTransfer extends Transfer {
    public IncomingTransfer(Transfer x) {
        super(x);
    }
    @Override
    public double calculate() {
        return amount;
    }
}
