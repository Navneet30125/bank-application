package com.BankApplication.program;

	@SuppressWarnings("serial")
	class InsufficientFundsException extends Exception{
		public InsufficientFundsException(String message) {
			super(message);
		}
	}
	@SuppressWarnings("serial")
	class InvalidAmountException extends RuntimeException{
		public InvalidAmountException(String message) {
			super(message);
		}
	}
	@SuppressWarnings("serial")
	class AccountNotFoundException extends Exception{
		public AccountNotFoundException(String message){
			super(message);
		}
	}
	@SuppressWarnings("serial")
	class LoanNotAllowedException extends RuntimeException{
		public LoanNotAllowedException(String message){
			super(message);
		}
	}
