package bank;

public class Payment extends Transaction{
    /**
     * private Variable incomingInterest
     */
    private double incomingInterest;
    /**
     *  private Variable outgoingInterest
     */
    private double outgoingInterest;

    /**
     * @return Variable incomingInterest
     */
    //Getter
    public double get_incomingInterest(){return incomingInterest;}

    /**
     * @return Variable outgoingInterest
     */
    public double get_outgoingInterest(){return outgoingInterest;}

    /**
     * @param tempinc
     */
    //Setter
    public void set_incomingInterest(double tempinc)
    {
        if(tempinc>=0&&tempinc<=1) incomingInterest=tempinc;
        else System.out.println("Wert muss zwischen 0 und 1 liegen. Er bleibt gleich");
    }

    /**
     * @param tempout
     */
    public void set_outgoingInterest(double tempout)
    {
        if(tempout>=0&&tempout<=1) outgoingInterest=tempout;
        else System.out.println("Wert muss zwischen 0 und 1 liegen. Er bleibt gleich");
    }

    /**
     * @param temp_date
     * @param temp_description
     * @param temp_amount
     */
    //Konstruktor
    public Payment(String temp_date, String temp_description, double temp_amount)
    {
        super(temp_date,temp_description,temp_amount);
    }

    /**
     * @param temp_date
     * @param temp_description
     * @param temp_amount
     * @param temp_incoming Value between 0 and 1
     * @param temp_outgoing Value betwwen 0 and 1
     */
    public Payment(String temp_date, String temp_description, double temp_amount, double temp_incoming, double temp_outgoing)
    {
        this(temp_date,temp_description,temp_amount);
        set_incomingInterest(temp_incoming);
        set_outgoingInterest(temp_outgoing);
    }

    /**
     * Constructs new Payment Object identical to param x
     */
    //Copy-Konstruktor
    public Payment(Payment x)
    {
        super(x);
        incomingInterest=x.incomingInterest;
        outgoingInterest=x.outgoingInterest;
    }

    /**
     * @returns all Variable in a String
     */
    //Print all infos
    @Override
    public String toString()
    {
        return (super.toString()+"      Incoming Interest "+ incomingInterest+"     Outgoint Interest "+ outgoingInterest);
    }

    /**
     * @return Calculated amount with Interest
     */
    @Override
    public double calculate() {
        if(amount>=0)
        {
            return amount-amount*incomingInterest;
        }
        return amount+amount*outgoingInterest;
    }

    /**
     * Compares param temp Object with itself
     * @param temp_obj
     * @return returns true if all values are identical
     */
    @Override
    public boolean equals(Object temp_obj)
    {

        Payment obj=(Payment) temp_obj;
        if(super.equals(obj)&&incomingInterest==obj.get_incomingInterest()&&outgoingInterest==obj.get_outgoingInterest())return true;
        return false;
    }
}

