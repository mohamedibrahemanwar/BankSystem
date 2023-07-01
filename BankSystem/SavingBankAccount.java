package Sessoin_6;

public class SavingBankAccount extends BankAccount{
    private double minimumBalance;

    public SavingBankAccount(double balance, double minimumBalance) {
        super(balance);
        this.minimumBalance = minimumBalance;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(double minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount < minimumBalance) {
            return false;
        } else {
            setBalance(getBalance() - amount);
            return true;
        }
    }

    @Override
    public boolean deposit(double amount) {
        if (amount >= 100) {
            setBalance(getBalance() + amount);
            return true;
        }
        return false;
    }
}

