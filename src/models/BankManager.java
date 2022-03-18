package models;

import java.time.LocalDate;
import java.util.ArrayList;

import peresistence.Persistence;

public class BankManager {

	private ArrayList<Account> accounts;

	public BankManager() {
		accounts = Persistence.readAccounts();
	}

	public void createAccount(Account account) {
		this.accounts.add(account);
	}

	public ArrayList<Account> getAccounts() {
		return this.accounts;
	}

	public void transferMoney(double amount, Account accountOne, long numberAccountTarget)
			throws NotEnoughMoneyException, AccountNotFoundException {
		Account targetAccount = searchAccount(numberAccountTarget);
		if (accountOne.getMoney() >= amount) {
			targetAccount.setMoney(targetAccount.getMoney() + amount);
			accountOne.setMoney(accountOne.getMoney() - amount);
			accountOne.addTransaction(new BankingTransaction(LocalDate.now().toString(), TypeTransaction.TRANSFER_DISCOUNT, amount));
			targetAccount.addTransaction(new BankingTransaction(LocalDate.now().toString(), TypeTransaction.TRANSFER_INCREASE, amount));
			return;
		}
		throw new NotEnoughMoneyException();
	}

	public Account searchAccount(long numberAccount) throws AccountNotFoundException {
		for (Account account : accounts) {
			if (account.getNumberAccount() == numberAccount) {
				return account;
			}
		}
		throw new AccountNotFoundException();
	}

	public void withdrawMoney(Account account, double amount) throws AccountNotFoundException, NotEnoughMoneyException {
		if (account.getMoney() >= amount) {
			account.setMoney(account.getMoney() - amount);
			account.addTransaction(new BankingTransaction(LocalDate.now().toString(), TypeTransaction.WITHDRAWALS, amount));
			return;
		}
		throw new NotEnoughMoneyException();
	}
	
	public void depositMoney(Account account, double amount) {
		account.setMoney(account.getMoney() + amount);
		account.addTransaction(new BankingTransaction(LocalDate.now().toString(), TypeTransaction.DEPOSIT_MONEY, amount));
	}

	public BankingTransaction getTransaction(Account account) {
		
		return null;
	}
	
	public int[] plotNumberMenAndWomen() {
		int[] data = new int[2];
		int numberWomen = 0;
		int numberMen = 0;
		for (Account account : accounts) {
			if (account.getUser().getGender().equals(Gender.FEMALE)) {
				numberWomen++;
			} else {
				numberMen++;
			}
		}
		data[0] = numberWomen;
		data[1] = numberMen;
		return data;
	}
}
