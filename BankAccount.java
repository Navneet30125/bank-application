package com.BankApplication.program;

public class BankAccount implements Bank{
private long accountNumber;
private double balance;

public BankAccount(long accountNumber, double balance) {
	super();
	this.accountNumber = accountNumber;
	this.balance = balance;
}
public long getAccountNumber() {
	return accountNumber;
}
public void setAccountNumber(long accountNumber) {
	this.accountNumber = accountNumber;
}
public double getBalance1() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}

@Override
public void deposit(double amount) throws InvalidAmountException{
	if(amount<=0) {
		throw new InvalidAmountException("Invalid amount.");
	}
		balance = balance+amount;
		System.out.println("Balance after deposite: "+balance);
}
@Override
public void withdraw(double amount) throws InsufficientFundsException, InvalidAmountException {
	if(amount<=0) {
		throw new InvalidAmountException("Deposit amount must be greater than zero.");
	}
	if(amount>balance){
		throw new InsufficientFundsException("Insufficient funds for withdrawal.");
	}
		balance = balance-amount;
		System.out.println("Balance after withdraw: "+balance);
}
@Override
public void transfer(BankAccount toAccount, double amount) throws InsufficientFundsException, AccountNotFoundException, InvalidAmountException,InvalidAmountException {
	if(amount<=0) {
		throw new InvalidAmountException("Withdraw amount must be greater than zero.");
	}
	if(amount>balance) {
		throw new InsufficientFundsException("Insufficient balance.");
	}
	if(toAccount == null) {
		throw new AccountNotFoundException("Account not found.");
	}
	    this.withdraw(amount);
		toAccount.deposit(amount);
}
@Override
public void applyForLoan(double amount) throws LoanNotAllowedException, InvalidAmountException {
	if(amount>50000) {
		throw new LoanNotAllowedException("You are not allowed to get more than 50000 loan.");
	}
	if(amount<=0) {
		throw new InvalidAmountException("Loan Amount must be greater than zero.");
	}
	if(balance<50000) {
		throw new LoanNotAllowedException("Balance must be equal or greater than 50000.");
	}
		double balance =+ amount;
		System.out.println("Loan is approved. total balance is "+balance+" rupay.");
}
@Override
public double getBalance() {
	return balance;
}
}
