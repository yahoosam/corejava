public class BankAccount {
    private String accountName;
    private double balance;

    public BankAccount(String accountName, double initialBalance) {
        this.accountName = accountName;
        if (initialBalance <= 0) {
            System.out.println("Error: Initial balance is negative");
        } else {
            this.balance = initialBalance;
        }
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount should be greater than 0");
        } else {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("Error: Insufficient balance");
        } else {
            balance -= amount;
        }
    }
}
