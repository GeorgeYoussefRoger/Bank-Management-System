public class Account {
    private String accountNumber;
    private double balance;
    private AccountType type;
    private Customer owner;

    public Account(String accountNumber, AccountType type, Customer owner, double balance) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.owner = owner;
        this.balance = balance;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }
    public AccountType getType() { return type; }
    public Customer getOwner() { return owner; }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalStateException("Insufficient funds");
        }
        balance -= amount;
    }
}