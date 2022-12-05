package bank;

public class OutgoingTransfer extends Transfer {
    public OutgoingTransfer(Transfer x) {
        super(x);
    }
    @Override
    public double calculate() {
        return -amount;
    }
}
