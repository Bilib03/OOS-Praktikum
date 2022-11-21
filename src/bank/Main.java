package bank;
public class Main {
    public static void main (String[] args) {
        Payment p=new Payment("10.20.3000","Felix",-20);
        Payment p2=new Payment(p);
        Payment p3=new Payment("16.05.2003","Überweisung",1000,0.05,0.1);
        Payment p4=new Payment("16.05.2003","Überweisung",-1000,0.1,0.1);
        Transfer t = new Transfer("30.50.5555", "Paul", 30);
        Transfer t2=new Transfer(t);
        Transfer t3=new Transfer("10.10.2003","Transfer 3",300,"Roy","Jimmy");

       // p2.set_incomingInterest(99);
        t2.set_amount(-30);

        System.out.println(p.toString());

        System.out.println(p3.equals(p4));
        System.out.println(p3.calculate());
        System.out.println(p4.calculate());
    }
}