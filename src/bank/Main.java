package bank;
public class Main {
    public static void main(String[] args) {
        Payment p=new Payment("10.20.3000","Deine mama",-20);
        Payment p2=new Payment(p);
        Payment p3=new Payment("16.05.2003","Überweisung",3000,3000,2000);
        Transfer t = new Transfer("30.50.5555", "Dein papa", -30);
        Transfer t2=new Transfer(t);
        Transfer t3=new Transfer("10.10.2003","Transfer 3",300,"Der Papst","King Henry");

        p2.set_incomingInterest(99);
        t2.set_recipient("Roy");

        t.printObject();
        t2.printObject();
        t3.printObject();
        p.printObject();
        p2.printObject();
        p3.printObject();
    }
}