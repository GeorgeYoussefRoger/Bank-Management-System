import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    private static void adminLogin(Scanner in) {
        // Hardcoded default admin credentials
        final String USERNAME = "admin";
        final String PASSWORD = "admin123";

        while (true) {
            System.out.println("=== Admin Login ===");
            System.out.print("Username: ");
            String user = in.nextLine();
            System.out.print("Password: ");
            String pass = in.nextLine();

            if (USERNAME.equals(user) && PASSWORD.equals(pass)) {
                System.out.println("Login successful.\n");
                break;
            } 
            else {
                System.out.println("Invalid credentials.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        adminLogin(in);

        List<Customer> customers = new ArrayList<>();
        List<Account> accounts = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();
        
        while (true) {
            System.out.println("=== Welcome to the Bank Management System ===");
            System.out.println("1. Add Individual Customer");
            System.out.println("2. Add Company Customer");
            System.out.println("3. Update Customer Contact Info");
            System.out.println("4. Delete Customer");
            System.out.println("5. Create Account");
            System.out.println("6. Delete Account");
            System.out.println("7. Deposit");
            System.out.println("8. Withdraw");
            System.out.println("9. Customer Info");
            System.out.println("10. Transaction History");
            System.out.println("11. Exit");
            System.out.print("Choose: ");

            int choice = Integer.parseInt(in.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String individualName = in.nextLine();
                    
                    System.out.print("Date of Birth (yyyy-MM-dd): ");
                    LocalDate dob;
                    while (true) {
                        try {
                            dob = LocalDate.parse(in.nextLine());
                            break;
                        } catch (DateTimeParseException e) {
                            System.out.print("Invalid format. Try again (yyyy-MM-dd): ");
                        }
                    }

                    System.out.print("Phone: ");
                    String individualPhone = in.nextLine();
                    System.out.print("Email: ");
                    String individualEmail = in.nextLine();
                    String individualId = "CUST" + ThreadLocalRandom.current().nextInt(10000, 99999);

                    Customer ic = new IndividualCustomer(individualId, individualName, dob, individualPhone, 
                                                         individualEmail);
                    customers.add(ic);
                    System.out.println("Created customer with ID: " + ic.getCustomerId());
                    break;

                case 2:
                    System.out.print("Company Name: ");
                    String companyName = in.nextLine();
                    System.out.print("Phone: ");
                    String companyPhone = in.nextLine();
                    System.out.print("Email: ");
                    String companyEmail = in.nextLine();
                    System.out.print("Registration Number: ");
                    String regNo = in.nextLine();
                    System.out.print("Business Type: ");
                    String businessType = in.nextLine();
                    String companyId = "CUST" + ThreadLocalRandom.current().nextInt(10000, 99999);

                    Customer cc = new CompanyCustomer(companyId, companyName, companyPhone, companyEmail, regNo, businessType);
                    customers.add(cc);
                    System.out.println("Created company with ID: " + cc.getCustomerId());
                    break;

                case 3:  
                    System.out.print("Enter Customer ID to Edit: ");
                    String editCustId = in.nextLine();

                    for (Customer e : customers) {
                        if (e.getCustomerId().equalsIgnoreCase(editCustId)) {
                            System.out.println("Editing " + e.getName() + "'s details:");
                            System.out.print("Enter new phone: ");
                            String newPhone = in.nextLine();
                            System.out.print("Enter new email: ");
                            String newEmail = in.nextLine();
                            if (!newPhone.isEmpty() && !newEmail.isEmpty()) {
                                e.updateContact(newPhone, newEmail);
                            }
                            else {
                                System.out.println(e.getName() + "'s details have been updated.");
                            }
                        }
                        else {
                            System.out.println("Customer not found.");
                        }
                    }              
                    break;

                case 4:
                    System.out.print("Enter Customer ID to Delete: ");
                    String deleteCustId = in.nextLine(); 
                    customers.removeIf(customer -> customer.getCustomerId().equalsIgnoreCase(deleteCustId));
                    System.out.println("Customer with ID " + deleteCustId + " has been removed from the system.");
                    break;

                case 5:
                    System.out.print("Customer ID: ");
                    String custId = in.nextLine();

                    Customer cust = null;
                    for (Customer i : customers) {
                        if (i.getCustomerId().equalsIgnoreCase(custId)) {
                            cust = i;
                            break;
                        }
                    }
                    if (cust == null) {
                        System.out.println("Customer not found.");
                        return;
                    }

                    System.out.print("Account Type (1 = SAVINGS, 2 = CHECKING): ");
                    int typeChoice = Integer.parseInt(in.nextLine());
                    AccountType accType = (typeChoice == 1) ? AccountType.SAVINGS : AccountType.CHECKING;
                    System.out.print("Initial Balance: ");
                    double balance = Double.parseDouble(in.nextLine());
                    String accountId = "ACC" + ThreadLocalRandom.current().nextInt();

                    Account a = new Account(accountId, accType, cust, balance);
                    accounts.add(a);
                    System.out.println("Account created: " + a.getAccountNumber());                    
                    break;

                case 6:
                    System.out.print("Enter Account Number to Delete: ");
                    String deleteAccNo = in.nextLine();
                    accounts.removeIf(account -> account.getAccountNumber().equalsIgnoreCase(deleteAccNo));
                    System.out.println("Account with Number " + deleteAccNo + " has been removed from the system.");
                    break;

                case 7:
                    System.out.print("Account Number: ");
                    String depAccNo = in.nextLine();
                    System.out.print("Amount: ");
                    double depAmount = Double.parseDouble(in.nextLine());
                    String depTrnId = "TRN" + ThreadLocalRandom.current().nextInt(10000, 99999);

                    Account depAccount = null;
                    for (Account i : accounts) {
                        if (i.getAccountNumber().equalsIgnoreCase(depAccNo)) {
                            depAccount = i;
                            break;
                        }
                    }
                    if (depAccount == null) {
                        System.out.println("Account not found.");
                        return;
                    }

                    depAccount.deposit(depAmount);
                    Transaction dt = new Transaction(depTrnId, depAccNo, depAmount, TransactionType.DEPOSIT);
                    transactions.add(dt);
                    break;

                case 8:
                    System.out.print("Account Number: ");
                    String withAccNo = in.nextLine();
                    System.out.print("Amount: ");
                    double withAmount = Double.parseDouble(in.nextLine());
                    String withTrnId = "TRN" + ThreadLocalRandom.current().nextInt(10000, 99999);

                    Account withAccount = null;
                    for (Account j : accounts) {
                        if (j.getAccountNumber().equalsIgnoreCase(withAccNo)) {
                            withAccount = j;
                            break;
                        }
                    }
                    if (withAccount == null) {
                        System.out.println("Account not found.");
                        return;
                    }

                    try {
                        withAccount.withdraw(withAmount);
                        Transaction wt = new Transaction(withTrnId, withAccNo, withAmount, TransactionType.WITHDRAW);
                        transactions.add(wt);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 9:
                    System.out.print("Customer ID: ");
                    String infoCustId = in.nextLine();
                    for (Customer customer : customers) {
                        if (customer.getCustomerId().equalsIgnoreCase(infoCustId)) {
                            System.out.println(customer.getDetails());
                        }
                        else {
                            System.out.println("Customer not found.");
                        }
                    }
                    break;

                case 10:
                    System.out.print("Account Number: ");
                    String accNo = in.nextLine();

                    System.out.println("Transaction History for Account: " + accNo);
                    for (Transaction t : transactions) {
                        if (t.getAccountNumber().equalsIgnoreCase(accNo)) {
                            System.out.println(t);
                        }
                    }
                    break;

                case 11:
                    System.out.println("Goodbye!");
                    in.close();
                    return;
        
                default: 
                    System.out.println("Invalid choice");
                    continue;
            }
        }
    }
}