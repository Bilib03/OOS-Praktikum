package bank;

import java.security.cert.TrustAnchor;

public abstract class Transaction implements CalculateBill{
    /**
     * Attribut Datum
     */
    protected String date;
    /**
     * Attribut Beschreibung
     */
    protected String description;
    /**
     * Attribut Menge
     */
    protected double amount;

    /**
     * @return date
     */
    public String get_date() {return date;}

    /**
     * @param tempdate
     */
    public void set_date(String tempdate){date=tempdate;}

    /**
     * @param tempamount
     */
    public void set_amount(double tempamount){amount=tempamount;}

    /**
     * @return amount
     */
    public double get_amount() {return amount;}

    /**
     * @param tempdesc
     */
    public void set_description(String tempdesc){description=tempdesc;}
    /**
     * @return description
     */
    public String get_description() {return description;}


    /**
     * @param temp_date
     * @param temp_description
     * @param temp_amount
     */
    public Transaction(String temp_date, String temp_description, double temp_amount)
    {
        set_date(temp_date);
        set_description(temp_description);
        set_amount(temp_amount);
    }

    /**
     * Constructs new Transaction Object identical to param x
     * @param x
     */
    public Transaction(Transaction x)
    {
        date=x.date;
        description=x.description;
        amount=x.amount;
    }

    /**
     * @return Returns all Variables in a String
     */
    @Override
    public String toString()
    {
        return ("Date "+date+"   Description "+description+"     Amount " +amount );
    }

    /**
     * Compares param temp Object with itself
     * @param temp_obj
     * @return returns true if all values are identical
     */
    @Override
    public boolean equals(Object temp_obj) {
        Transaction obj=(Transaction) temp_obj;
        if(date.equals(obj.get_date())&&description.equals(obj.get_description())&&amount==obj.get_amount())return true;
        return false;
    }
}
