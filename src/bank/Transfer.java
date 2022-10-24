package bank;

public class Transfer {
    //Variablen
    private String date;
    private String description;
    private String sender;
    private String recipient;
    private double amount;

    //Getter
    public String get_date() {return date;}
    public String get_description() {return description;}
    public String get_sender(){return sender;}
    public String get_recipient(){return recipient;}
    public double get_amount() {return amount;}

    //Setter
    public void set_date(String tempdate){date=tempdate;}
    public void set_description(String tempdesc){description=tempdesc;}
    public void set_sender(String tempsend){sender=tempsend;}
    public void set_recipient(String temprec){recipient=temprec;}
    public void set_amount(double tempamount)
    {
        if(tempamount>=0) amount = tempamount;
        else System.out.println("Es werden nur Positive werte als Amount akzeptiert. Wert bleibt gleich");
    }

    //Konstruktor
    public Transfer(String temp_date, String temp_description, double temp_amount)
    {
        date=temp_date;
        description=temp_description;
        if(temp_amount>=0) amount = temp_amount;
        else System.out.println("Es werden nur Positive werte als Amount akzeptiert. Wert wird auf 0 gesetzt");
    }
    public Transfer(String temp_date, String temp_description, double temp_amount, String temp_sender, String temp_recipient)
    {
        this(temp_date,temp_description,temp_amount);
        recipient=temp_recipient;
        sender=temp_sender;
    }

    //Copy-Konstruktor
    public Transfer(Transfer x)
    {
        date=x.date;
        amount=x.amount;
        description=x.description;
        sender=x.sender;
        recipient=x.recipient;
    }

    //Methode
    public void printObject()
    {
        System.out.println(date);
        System.out.println(description);
        System.out.println(amount);
        System.out.println(sender);
        System.out.println(recipient +"\r\n");
    }
}
