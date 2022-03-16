package models;

import java.util.ArrayList;
import java.util.Comparator;

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
	
	public void sortBankingTransactions() {
		transactions.sort(new Comparator<BankingTransaction>(){ 
			@Override
			public int compare(BankingTransaction o1, BankingTransaction o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
		});
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