package com.BankApplication.program;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ATM {
	public static void main(String[] args) throws AccountNotFoundException{
		Scanner sc = new Scanner(System.in);
		BankAccount account1 = new BankAccount(1001, 50000);
		BankAccount account2 = new BankAccount(1002, 30000);
		Customer12 customer = new Customer12("Navneet", account1);
		boolean exit = false;
		while(!exit) {
			try {
				
				System.out.println("Select an option : ");
				System.out.println("1. Deposit\n"
						+ "2. Withdraw\n"
						+ "3. Transfer\n"
						+ "4. Loan Application\n"
						+ "5. Check Balance\n"
						+ "6. Exit");
				System.out.println("Enter your option: ");
				
				int option = sc.nextInt();
				switch(option) {
				case 1:
					System.out.println("Enter deposit amount: ");
					double depAmount = sc.nextDouble();
					customer.getAccount().deposit(depAmount);
					System.out.println("Amount deposit succesfully. Current balance: "+customer.getAccount().getBalance());//method chaining
				    break;
				case 2:
					System.out.println("Enter withdraw amount: ");
					double withdAmount = sc.nextDouble();
					customer.getAccount().withdraw(withdAmount);
					System.out.println("Amoutn withdraw succesfully. current balance: "+customer.getAccount().getBalance());
					break;
				case 3:
					 System.out.print("Enter transfer amount: ");
                     double transferAmount = sc.nextDouble();
                     customer.getAccount().transfer(account2, transferAmount);
                     System.out.println("Transfer successful. Current balance: " + customer.getAccount().getBalance());
                     break;
				case 4:
					System.out.print("Enter loan amount: ");
                    double loanAmount = sc.nextDouble();
                    customer.getAccount().applyForLoan(loanAmount);
                    System.out.println("Loan approved. Current balance: " + customer.getAccount().getBalance());
                    break;
				case 5:
					 System.out.println("Current balance: " + customer.getAccount().getBalance());
                     break;  
				case 6:
                    exit = true;
                    System.out.println("Exiting application. Thank you!");
                    break;
                default :
                	System.out.println("Invalid option. Please try again.");
				}
			}
			catch(InputMismatchException  e) {
				System.out.println("Invalid input.");
			}
			catch(InsufficientFundsException | InvalidAmountException |AccountNotFoundException | LoanNotAllowedException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}		
		sc.close();
	}
}

