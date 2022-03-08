package models;

import java.util.ArrayList;

public class Account {

	private User user;
	private long numberAccount;
	private String passwordAccount;
	private double money;
	private ArrayList<BankingTransaction> transactions;
	
	public Account(User user, long numberAccount, String passwordAccount, double money) {
		this.user = user;
		this.numberAccount = numberAccount;
		this.passwordAccount = passwordAccount;
		this.money = money;
		transactions = new ArrayList<>();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(long numberAccount) {
		this.numberAccount = numberAccount;
	}

	public String getPasswordAccount() {
		return passwordAccount;
	}

	public void setPasswordAccount(String passwordAccount) {
		this.passwordAccount = passwordAccount;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public ArrayList<BankingTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<BankingTransaction> transactions) {
		this.transactions = transactions;
	}
	
	public void addTransaction(BankingTransaction transaction) {
		this.transactions.add(transaction);
	}
	
}