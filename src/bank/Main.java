package bank;
import bank.exceptions.*;

public class Main {
    public static void main (String[] args) throws AccountAlreadyExistsException, AccountDoesNotExistException, TransactionAttributeException, TransactionAlreadyExistException, TransactionDoesNotExistException, ClassAttributeException {
        PrivateBank pb1 = new PrivateBank("pb1", 0.1, 0.2);
        PrivateBank pb2 = new PrivateBank(pb1);

        PrivateBankAlt pba1 = new PrivateBankAlt("pba1", 0.1, 0.2);
        PrivateBankAlt pba2 = new PrivateBankAlt("pba2", 1.1, 1.2);

        Transfer t1 = new Transfer("t1", "desc", 100, "account1", "account2");
        Transfer t2 = new Transfer("t2", "desc2", 100, "account2", "account1");
        Transfer t5 = new Transfer("t5", "desc5", 200, "account1", "account2");

        OutgoingTransfer t3 = new OutgoingTransfer(t2);
        OutgoingTransfer t4 = new OutgoingTransfer(t5);
        // Payment p1 = new Payment("p1", "desc", 100, 1.1, 1.2);

        System.out.println("copyconstructor and equals() --- Expected: true");
        System.out.println(pb1.equals(pb2));

        pb1.createAccount("account1");
        pba1.createAccount("account1");


        System.out.println("PrivateBank Test Cases:");
        pb1.addTransaction("account1", t1);
        System.out.println("addTransactions(), getTransactions() --- Expected: Contents of t1");
        System.out.println(pb1.getTransactions("account1"));

        System.out.println("containsTransaction() ---  Expected: true");
        System.out.println(pb1.containsTransaction("account1", t1));

        pb1.addTransaction("account1", t3);
        System.out.println("getAccountBalance() ---  Expected: 0");
        System.out.println(pb1.getAccountBalance("account1"));

        pb1.addTransaction("account1", t5);
        System.out.println("getTransactionsSorted() ---  Expected: Contents of t5, t2, t1");
        System.out.println(pb1.getTransactionsSorted("account1", true));
        System.out.println("getTransactionsSorted() ---  Expected: Contents of t2, t1");
        System.out.println(pb1.getTransactionsSorted("account1", false));

        System.out.println("getTransactionsByType() ---  Expected: Contents of t1");
        System.out.println(pb1.getTransactionsByType("account1", true));
        System.out.println("getTransactionsByType() ---  Expected: Contents of t2");
        System.out.println(pb1.getTransactionsByType("account1", false));

        pb1.removeTransaction("account1", t1);
        pb1.removeTransaction("account1", t2);
        pb1.removeTransaction("account1", t5);
        System.out.println("removeTransaction() ---  Expected: []");
        System.out.println(pb1.getTransactions("account1"));


        System.out.println("\n\nPrivateBankAlt Test Cases:");
        pba1.addTransaction("account1", t1);
        pba1.addTransaction("account1", t2);
        pba1.addTransaction("account1", t5);
        System.out.println("getAccountBalance() ---  Expected: -200");
        System.out.println(pba1.getAccountBalance("account1"));



        // Exception Tests:

        //pb1.createAccount("account1");

        //pb1.getAccountBalance("account2");

        //pb1.addTransaction("account1", t1);
        //pb1.addTransaction("account1", t1);

        //ClassAttributeException
        //Transfer t6 = new Transfer("t6", "desc6", -10, "account2", "account1");
        //pb1.addTransaction("account1", t6);

        //pb1.removeTransaction("account1", t5);
    }
}