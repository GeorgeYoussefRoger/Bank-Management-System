public class Transaction {
    private String transactionId;
    private String accountNumber;
    private double amount;
    private TransactionType type;

    public Transaction(String transactionId, String accountNumber, double amount, TransactionType type) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.type = type;
    }

    public String getTransactionId() { return transactionId; }
    public String getAccountNumber() { return accountNumber; }
    public double getAmount() { return amount; }
    public TransactionType getType() { return type; }
}