//package com.BankApplication.program;
//
//import java.util.InputMismatchException;
////import java.util.Objects;
//import java.util.Scanner;
//
//// Custom Exceptions
//class InsufficientFundsException extends Exception {
//    public InsufficientFundsException(String message) {
//        super(message);
//    }
//}
//
//class InvalidAmountException extends RuntimeException {
//    public InvalidAmountException(String message) {
//        super(message);
//    }
//}
//
//class AccountNotFoundException extends Exception {
//    public AccountNotFoundException(String message) {
//        super(message);
//    }
//}
//
//class LoanNotAllowedException extends RuntimeException {
//    public LoanNotAllowedException(String message) {
//        super(message);
//    }
//}
//
//// Bank Interface
//interface Bank {
//    void deposit(double amount) throws InvalidAmountException;
//
//    void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException;
//
//    void transfer(BankAccount toAccount, double amount) throws InsufficientFundsException, AccountNotFoundException, InvalidAmountException;
//
//    void applyForLoan(double amount) throws LoanNotAllowedException, InvalidAmountException;
//
//    double getBalance();
//}
//
//// BankAccount Class
//class BankAccount implements Bank {
//    private long accountNumber;
//    private double balance;
//
//    public BankAccount(long accountNumber, double initialBalance) {
//        this.accountNumber = accountNumber;
//        this.balance = initialBalance;
//    }
//
//    @Override
//    public void deposit(double amount) throws InvalidAmountException {
//        if (amount <= 0) {
//            throw new InvalidAmountException("Deposit amount must be greater than zero.");
//        }
//        balance += amount;
//    }
//
//    @Override
//    public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
//        if (amount <= 0) {
//            throw new InvalidAmountException("Withdrawal amount must be greater than zero.");
//        }
//        if (amount > balance) {
//            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
//        }
//        balance -= amount;
//    }
//
//    @Override
//    public void transfer(BankAccount toAccount, double amount) throws InsufficientFundsException, AccountNotFoundException, InvalidAmountException {
//        if (toAccount == null) {
//            throw new AccountNotFoundException("Target account not found.");
//        }
//        if (amount <= 0) {
//            throw new InvalidAmountException("Transfer amount must be greater than zero.");
//        }
//        if (amount > balance) {
//            throw new InsufficientFundsException("Insufficient funds for transfer.");
//        }
//        this.withdraw(amount);
//        toAccount.deposit(amount);
//    }
//
//    @Override
//    public void applyForLoan(double amount) throws LoanNotAllowedException, InvalidAmountException {
//        if (amount <= 0) {
//            throw new InvalidAmountException("Loan amount must be greater than zero.");
//        }
//        if (amount > 50000) {
//            throw new LoanNotAllowedException("Loan amount exceeds the allowed limit of 50000.");
//        }
//        if (balance < 50000) {
//            throw new LoanNotAllowedException("Loan not allowed for accounts with balance less than 50000.");
//        }
//        balance += amount;
//    }
//
//    @Override
//    public double getBalance() {
//        return balance;
//    }
//}
//
//// Customer Class
//class Customer {
//    private String name;
//    private BankAccount account;
//
//    public Customer(String name, BankAccount account) {
//        this.name = name;
//        this.account = account;
//    }
//
//    public BankAccount getAccount() {
//        return account;
//    }
//}
//
//// ATM Class
//public class BankApplication {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        BankAccount account1 = new BankAccount(1001, 10000);
//        BankAccount account2 = new BankAccount(1002, 5000);
//        Customer customer = new Customer("John Doe", account1);
//
//        boolean exit = false;
//
//        while (!exit) {
//            try {
//                System.out.println("Select an option:");
//                System.out.println("1. Deposit");
//                System.out.println("2. Withdraw");
//                System.out.println("3. Transfer");
//                System.out.println("4. Loan Application");
//                System.out.println("5. Check Balance");
//                System.out.println("6. Exit");
//                System.out.print("Enter your option: ");
//
//                int option = scanner.nextInt();
//                switch (option) {
//                    case 1:
//                        System.out.print("Enter deposit amount: ");
//                        double depositAmount = scanner.nextDouble();
//                        customer.getAccount().deposit(depositAmount);
//                        System.out.println("Deposit successful. Current balance: " + customer.getAccount().getBalance());
//                        break;
//
//                    case 2:
//                        System.out.print("Enter withdrawal amount: ");
//                        double withdrawalAmount = scanner.nextDouble();
//                        customer.getAccount().withdraw(withdrawalAmount);
//                        System.out.println("Withdrawal successful. Current balance: " + customer.getAccount().getBalance());
//                        break;
//
//                    case 3:
//                        System.out.print("Enter transfer amount: ");
//                        double transferAmount = scanner.nextDouble();
//                        customer.getAccount().transfer(account2, transferAmount);
//                        System.out.println("Transfer successful. Current balance: " + customer.getAccount().getBalance());
//                        break;
//
//                    case 4:
//                        System.out.print("Enter loan amount: ");
//                        double loanAmount = scanner.nextDouble();
//                        customer.getAccount().applyForLoan(loanAmount);
//                        System.out.println("Loan approved. Current balance: " + customer.getAccount().getBalance());
//                        break;
//
//                    case 5:
//                        System.out.println("Current balance: " + customer.getAccount().getBalance());
//                        break;
//
//                    case 6:
//                        exit = true;
//                        System.out.println("Exiting application. Thank you!");
//                        break;
//
//                    default:
//                        System.out.println("Invalid option. Please try again.");
//                }
//            } catch (InputMismatchException e) {
//                System.out.println("Invalid input. Please enter a valid number.");
//                scanner.next(); // clear invalid input
//            } catch (InvalidAmountException | InsufficientFundsException | AccountNotFoundException | LoanNotAllowedException e) {
//                System.out.println("Error: " + e.getMessage());
//            }
//        }
//
//        scanner.close();
//    }
//}
