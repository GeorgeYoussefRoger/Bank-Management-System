# 🏦 Bank Management System
A console-based Java banking application that simulates core banking operations such as customer management, account handling, deposits, withdrawals and transaction tracking. This project was implemented using plain Java and Object-Oriented Programming (OOP) concepts with all data stored in memory.

## 🚀 Features

- Admin Authentication
    - Secure login with predefined credentials
    - Default credentials:
        - Username: admin
        - Password: admin123

- Customer Management
    - Add individual customers (with date of birth)
    - Add company customers (with registration details)
    - Update customer contact information
    - Delete customers
    - View customer details

- Account Management
    - Create bank accounts (Savings / Checking)
    - Delete accounts
    - Associate accounts with customers
    - Validate account existence before operations

- Transactions
    - Deposit money into accounts
    - Withdraw money with balance validation
    - Exception-based error handling for invalid operations
    - Maintain full transaction history per account

- Input Validation & Error Handling
    - Date validation using `LocalDate`
    - Prevent overdrafts and invalid amounts
    - Clear error messages for invalid operations

## 📂 Project Structure
```
Bank-Management-System/
├── src/
│   ├── Main.java                 # Application entry point & console UI
│   ├── Customer.java             # Base customer class
│   ├── IndividualCustomer.java   # Individual customer implementation
│   ├── CompanyCustomer.java      # Company customer implementation
│   ├── Account.java              # Bank account logic (deposit/withdraw)
│   ├── AccountType.java          # Enum for account types
│   ├── Transaction.java          # Transaction model
│   └── TransactionType.java      # Enum for transaction types
├── README.md
├── .gitignore
└── LICENSE 
```

## 🧰 Technologies Used
- Language: Java
- Concepts: Object-Oriented Programming (OOP), Encapsulation & Inheritance, Exception Handling, Enums

## 📦 Installation & Usage
1. Clone the repository
```
git clone https://github.com/GeorgeYoussefRoger/Bank-Management-System.git
cd Bank-Management-System
```

2. Compile the project
```
javac src/*.java
```

3. Run the application
```
java -cp src Main
```

4. Login using:
```
Username: admin
Password: admin123
```

## 📜 License
- This project is licensed under the MIT License.
- See the `LICENSE` file for more details.