package bank;

public class Transfer extends Transaction {
    /**
     *  private attribut sender
     */
    private String sender;
    /**
     *  private attribut recipient
     */
    private String recipient;

    /**
     * @return sender attribut
     */
    public String get_sender(){return sender;}
    /**
     * sets the value of the private attribut sender
     * @param new sender value
     */
    public void set_sender(String tempsend){sender=tempsend;}

    /**
     * @return recipient attribut
     */
    public String get_recipient(){return recipient;}
    /**
     * sets the value of the private attribut recipient
     * @param new recipient value
     */
    public void set_recipient(String temprec){recipient=temprec;}

    /**
     * sets the value of the protected attribut amount
     * @param new amount value must be greater than 0
     */
    public void set_amount(double tempamount)
    {
        if(tempamount>=0) amount = tempamount;
        else System.out.println("Es werden nur Positive werte als Amount akzeptiert. Wert bleibt gleich");
    }

    /**
     * constructs new Transfer Object
     * @param temp_date
     * @param temp_description
     * @param temp_amount must be greater than 0
     */
    //Konstruktor
    public Transfer(String temp_date, String temp_description, double temp_amount)
    {
        super(temp_date,temp_description,temp_amount);
    }

    /**
     * @param temp_date
     * @param temp_description
     * @param temp_amount must be greater than 0
     * @param temp_sender
     * @param temp_recipient
     */
    public Transfer(String temp_date, String temp_description, double temp_amount, String temp_sender, String temp_recipient)
    {
        this(temp_date,temp_description,temp_amount);
        set_recipient(temp_recipient);
        set_sender(temp_sender);
    }

    /**
     * @param Constructs new Tranfer Object identical to param x
     */
    public Transfer(Transfer x)
    {
        super(x);
        sender=x.sender;
        recipient=x.recipient;
    }

    /**
     * @return Returns all Variables in a String
     */
    @Override
    public String toString()
    {
        return (super.toString()+"  Sender "+ sender+"     Recipient "+ recipient);
    }

    /**
     * @return Calculated amount
     */
    @Override
    public double calculate() {
        return amount;
    }

    /**
     * Compares param temp Object with itself
     * @param temp_obj
     * @return returns true if all values are identical
     */
    @Override
    public boolean equals(Object temp_obj)
    {
        Transfer obj=(Transfer) temp_obj;
        if(super.equals(obj)&&sender.equals(obj.get_sender())&&recipient.equals(get_recipient()))return true;
        return false;
    }


}
