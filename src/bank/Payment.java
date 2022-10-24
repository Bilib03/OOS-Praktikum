package bank;

public class Payment {
    //Variablen
    private String date;
    private String description;
    private double amount;
    private double incomingInterest;
    private double outgoingInterest;

    //Getter
    public String get_date() {return date;}
    public String get_description() {return description;}
    public double get_amount() {return amount;}
    public double get_incomingInterest(){return incomingInterest;}
    public double get_outgoingInterest(){return outgoingInterest;}

    //Setter
    public void set_date(String tempdate){date=tempdate;}
    public void set_description(String tempdesc){description=tempdesc;}
    public void set_amount(double tempamount){amount=tempamount;}
    public void set_incomingInterest(double tempinc)
    {
        if(tempinc>=0&&tempinc<=1) incomingInterest=tempinc;
        else System.out.println("Wert muss zwischen 0 und 1 liegen. Er bleibt gleich");
    }
    public void set_outgoingInterest(double tempout)
    {
        if(tempout>=0&&tempout<=1) outgoingInterest=tempout;
        else System.out.println("Wert muss zwischen 0 und 1 liegen. Er bleibt gleich");
    }

    //Konstruktor
    public Payment(String temp_date, String temp_description, double temp_amount)
    {
        date=temp_date;
        description=temp_description;
        amount=temp_amount;
    }
    public Payment(String temp_date, String temp_description, double temp_amount, double temp_incoming, double temp_outgoing)
    {
        this(temp_date,temp_description,temp_amount);
        if(temp_incoming>=0&&temp_incoming<=1) incomingInterest=temp_incoming;
        else System.out.println("Wert muss zwischen 0 und 1 liegen. Er wird auf 0 gesetzt");
        if(temp_outgoing>=0&&temp_outgoing<=1) outgoingInterest=temp_outgoing;
        else System.out.println("Wert muss zwischen 0 und 1 liegen. Er wird auf 0 gesetzt");
    }

    //Copy-Konstruktor
    public Payment(Payment x)
    {
        date=x.date;
        amount=x.amount;
        description=x.description;
        incomingInterest=x.incomingInterest;
        outgoingInterest=x.outgoingInterest;
    }

    //Print all infos
    public void printObject()
    {
        System.out.println(date);
        System.out.println(description);
        System.out.println(amount);
        System.out.println(incomingInterest);
        System.out.println(outgoingInterest+"\r\n");
    }
}

