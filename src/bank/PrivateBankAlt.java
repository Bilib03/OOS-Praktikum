package bank;

import bank.exceptions.*;

import java.util.*;

/**
 *
 */
public class PrivateBankAlt implements Bank {
    private String name;
    private double incomingInterest; // Zinssatz bei Einzahlung
    private double outgoingInterest; // Zinssatz bei Auszahlung
    Map<String, ArrayList<Transaction>> accountsToTransactions = new HashMap<String, ArrayList<Transaction>>(); // Verknüpft Konten mit Transaktionen

    // Getter
    public String get_name(){return name;}
    public double get_incomingInterest(){return incomingInterest;}
    public double get_outgoingInterest(){return outgoingInterest;}

    // Setter
    public void set_name(String tempname){name = tempname;}
    public void set_incomingInterest(double tempinc)
    {
        if(tempinc >= 0 && tempinc <= 1) incomingInterest = tempinc;
        else System.out.println("Wert muss zwischen 0 und 1 liegen. Er bleibt gleich");
    }

    public void set_outgoingInterest(double tempout)
    {
        if(tempout >= 0 && tempout <= 1) outgoingInterest = tempout;
        else System.out.println("Wert muss zwischen 0 und 1 liegen. Er bleibt gleich");
    }

    /**
     *
     * @param name
     * @param incoming
     * @param outgoing
     */
    public PrivateBankAlt(String name, double incoming, double outgoing)
    {
        set_name(name);
        set_incomingInterest(incoming);
        set_outgoingInterest(outgoing);
    }

    /**
     *
     * @param tempBank
     */
    public PrivateBankAlt(PrivateBankAlt tempBank)
    {
        set_name(tempBank.get_name());
        set_incomingInterest(tempBank.get_incomingInterest());
        set_outgoingInterest(tempBank.get_outgoingInterest());
        accountsToTransactions = tempBank.accountsToTransactions;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
        return "Bankname: " + get_name() + " Einzahlungszinssatz: " + get_incomingInterest() + " Auszahlungszinssatz: " + get_outgoingInterest();
    }

    /**
     *
     * @param tempObj
     * @return
     */
    @Override
    public boolean equals(Object tempObj) {
        PrivateBankAlt obj = (PrivateBankAlt) tempObj;
        return name == obj.get_name() && incomingInterest == obj.get_incomingInterest() && outgoingInterest == obj.get_outgoingInterest() && accountsToTransactions == obj.accountsToTransactions;
    }


    /**
     *
     * @param account the account to be added
     * @throws AccountAlreadyExistsException
     */
    @Override
    public void createAccount(String account) throws AccountAlreadyExistsException {
        if (accountsToTransactions.containsKey(account))
            throw new AccountAlreadyExistsException();
        ArrayList<Transaction> temp = new ArrayList<Transaction>();
        accountsToTransactions.put(account, temp);
    }

    /**
     *
     * @param account      the account to be added
     * @param transactions a list of already existing transactions which should be added to the newly created account
     * @throws AccountAlreadyExistsException
     * @throws TransactionAlreadyExistException
     * @throws TransactionAttributeException
     */
    @Override
    public void createAccount(String account, ArrayList<Transaction> transactions) throws AccountAlreadyExistsException, TransactionAlreadyExistException, TransactionAttributeException {
        if (accountsToTransactions.containsKey(account))
            throw new AccountAlreadyExistsException();
        if (accountsToTransactions.get(account).contains(transactions)) {
            throw new TransactionAlreadyExistException();
        }
        for (Transaction t : transactions) {
            if (t.get_amount() < 0) {
                throw new TransactionAttributeException();
            }
        }
        accountsToTransactions.put(account, transactions);
    }

    /**
     *
     * @param account     the account to which the transaction is added
     * @param transaction the transaction which should be added to the specified account
     * @throws AccountDoesNotExistException
     * @throws TransactionAlreadyExistException
     * @throws TransactionAttributeException
     * @throws ClassAttributeException
     */
    public void addTransaction(String account, Transaction transaction) throws AccountDoesNotExistException, TransactionAlreadyExistException, TransactionAttributeException, ClassAttributeException {
        if (!accountsToTransactions.containsKey(account)) {
            throw new AccountDoesNotExistException();
        }
        if (accountsToTransactions.get(account).contains(transaction)) {
            throw new TransactionAlreadyExistException();
        }
        if (transaction.get_amount() < 0) {
            throw new TransactionAttributeException();
        }
        if (transaction instanceof Payment) {
            ((Payment) transaction).set_incomingInterest(incomingInterest);
            ((Payment) transaction).set_outgoingInterest(outgoingInterest);
        }
        accountsToTransactions.get(account).add(transaction);
    }

    /**
     *
     * @param account     the account from which the transaction is removed
     * @param transaction the transaction which is removed from the specified account
     * @throws AccountDoesNotExistException
     * @throws TransactionDoesNotExistException
     */
    public void removeTransaction(String account, Transaction transaction) throws AccountDoesNotExistException, TransactionDoesNotExistException {
        if (!accountsToTransactions.containsKey(account)) {
            throw new AccountDoesNotExistException();
        }
        if (!accountsToTransactions.get(account).contains(transaction)) {
            throw new TransactionDoesNotExistException();
        }
        ArrayList<Transaction> temp = (ArrayList<Transaction>) accountsToTransactions.get(account);
        temp.remove(transaction);
        accountsToTransactions.put(account, temp);
    }

    /**
     *
     * @param account     the account from which the transaction is checked
     * @param transaction the transaction to search/look for
     * @return
     */
    public boolean containsTransaction(String account, Transaction transaction) {
        ArrayList<Transaction> temp = (ArrayList<Transaction>) accountsToTransactions.get(account);
        return temp.contains(transaction);
    }

    /**
     *
     * @param account the selected account
     * @return
     */
    public double getAccountBalance(String account) {
        double balance = 0;
        for (Transaction t : accountsToTransactions.get(account)) {
            if (t instanceof Transfer) {
                if (((Transfer) t).get_sender().equals(account)) {
                    balance -= t.get_amount();
                } else if (((Transfer) t).get_recipient().equals(account)) {
                    balance += t.get_amount();
                }
            } else if (t instanceof Transfer)
                balance += t.get_amount();
        }
        return balance;
    }

    /**
     *
     * @param account the selected account
     * @return
     */
    public ArrayList<Transaction> getTransactions(String account) {
        return accountsToTransactions.get(account);
    }

    /**
     *
     * @param account the selected account
     * @param asc     selects if the transaction list is sorted in ascending or descending order
     * @return
     */
    public ArrayList<Transaction> getTransactionsSorted(String account, boolean asc) {
        ArrayList<Transaction> temp = accountsToTransactions.get(account);
        temp.sort(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return Double.compare(o1.calculate(), o2.calculate());
            }
        });
        if (!asc) {
            Collections.reverse(temp);
        }
        return temp;
    }

    /**
     *
     * @param account  the selected account
     * @param positive selects if positive or negative transactions are listed
     * @return
     */
    public List<Transaction> getTransactionsByType(String account, boolean positive) {
        ArrayList<Transaction> temp = accountsToTransactions.get(account);
        ArrayList<Transaction> temp2 = new ArrayList<Transaction>();
        for (Transaction t : temp) {
            if (t.calculate() > 0 && positive) {
                temp2.add(t);
            }
            if (t.calculate() < 0 && !positive) {
                temp2.add(t);
            }
        }
        return temp2;
    }
}
