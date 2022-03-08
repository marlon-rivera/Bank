package models;

import java.util.ArrayList;

public class BankManager {

	private ArrayList<Account> accounts;
	
	public BankManager() {
		accounts = new ArrayList<>();
	}
	
	public void createAccount(User user, String password) {
		accounts.add(new Account(user, user.getNumberPhone(), password, 0.0));
	}
	
	public boolean transferMoney(double amount, Account accountOne, Account targetAccount) {
		boolean flag = false;
		if(accountOne.getMoney() >= amount) {
			targetAccount.setMoney(targetAccount.getMoney() + amount);
			accountOne.setMoney(accountOne.getMoney() - amount);
			flag = true;
		}
		return flag;
	}
	
	public Account searchAccount(long numberAccount) throws UserNotFoundException {
		for (Account account : accounts) {
			if(account.getNumberAccount() == numberAccount) {
				return account;
			}
		}
		throw new UserNotFoundException();
	}
	
	public boolean withdrawMoney(long numberAccount, double amount) throws UserNotFoundException {
		boolean flag = false;
		Account account = searchAccount(numberAccount);
		if(account.getMoney() >= amount) {
			account.setMoney(account.getMoney() - amount);
		}
		return flag;
	}
	
	public int[] plotNumberMenAndWomen() {
		int[] data = new int[2];
		int numberWomen = 0;
		int numberMen = 0;
		for (Account account : accounts) {
			if(account.getUser().getGender().equals(Gender.FEMALE)) {
				numberWomen++;
			}else {
				numberMen++;
			}
		}
		data[0] = numberWomen;
		data[1] = numberMen;
		return data;
	}
}
