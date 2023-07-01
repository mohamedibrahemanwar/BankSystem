package Sessoin_6;

public class BankAccount {
    protected double balance;
    protected double accountID;
    private static int ID_GENERATOR = 1000;

    public double getBalance() {
        return balance;
    }

    public double getAccountId() {
        return accountID;
    }

    public void setAccountId(double accountID) {
        this.accountID = accountID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public BankAccount(double balance){
        this.balance =balance;
        accountID += ID_GENERATOR;
    }
    public BankAccount(){
        this(0);
    }
    public boolean deposit (double amount){
        if (amount < 0){
            System.out.println("error , no money enough");
            return false;
        }
        if(amount > balance){
            System.out.println("error , too much");
            return false;
        }
        balance -= amount;
        return true;
    }
    public boolean withdraw(double amount){
        if (amount < 0){
            System.out.println("error , no money enough");
            return false;
        }
        balance += amount;
        return true;
    }

    public void viewDetalis(){
        System.out.println("Account Id : " + accountID);
        System.out.println("Account Balance : " + balance);
    }
}
