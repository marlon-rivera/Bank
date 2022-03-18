package presenters;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import models.Account;
import models.AccountNotFoundException;
import models.BankManager;
import models.BankingTransaction;
import models.Gender;
import models.NotEnoughMoneyException;
import models.User;
import peresistence.Persistence;
import views.Constants;
import views.FrameMain;

public class Presenter implements ActionListener {

	private static final String COMMAND_CROSS = "X";
	private static final String COMMAND_BACK = "<";
	private static final String COMMAND_BACK_OPTIONS = "<<";
	private static final String COMMAND_REGISTER = "Signup";
	private static final String COMMAND_ENTER = "Enter";
	private static final String COMMAND_CREATE_ACCOUNT = "CreateAccount";
	private static final String COMMAND_TRANSFER = "transfer";
	private static final String COMMAND_WITHDRAW = "withdraw";
	private static final String COMMAND_DEPOSIT = "deposit";
	private static final String COMMAND_SHOW_TRANSACTIONS = "showtransactions";
	private static final String COMMAND_LOG_OUT = "logout";
	private static final String COMMAND_MAKE_TRANSFER = "maketransfer";
	private static final String COMMAND_MAKE_WITHDRAW = "makewithdraw";
	private static final String COMMAND_MAKE_DEPOSIT = "makedeposit";
	private static final String COMMAND_NEXT_TRANSACTION = "nexttransaction";
	private static final String COMMAND_PREVIOUS_TRANSACTION = "previostransaction";
	private static final String COMMAND_CHANGE_LANGUAGE = "changelanguage";
	private static final String COMMAND_BART_CHART = "createbartchart";

	private FrameMain frameMain;
	private BankManager bankManager;
	private Account actualAccount;
	private User actualUser;
	private int positionTransactions;
	private ArrayList<BankingTransaction> transactions;
	private BankingTransaction transaction;

	public Presenter() {
		frameMain = new FrameMain(this);
		bankManager = new BankManager();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
		switch (command) {
		case COMMAND_CROSS:
			Persistence.saveAccounts(bankManager.getAccounts());
			frameMain.setVisible(false);
			frameMain.dispose();
			break;
		case COMMAND_BACK:
			frameMain.hidePanelRegistration();			
			frameMain.showLoginPanel();
			frameMain.showButtonChartPanel();
			break;
		case COMMAND_REGISTER:
			frameMain.hideLoginPanel();
			frameMain.showPanelRegistration();
			frameMain.hideButtonShowBartChart();
			break;
		case COMMAND_ENTER:
			if (login()) {
				setInfoUser();
				setInfoAccount();
				transactions = actualAccount.getTransactions();
				frameMain.hideLoginPanel();
				frameMain.showMainPanel();
				frameMain.resetInfoLogin();
			}
			break;
		case COMMAND_TRANSFER:
			frameMain.hideMainPanel();
			frameMain.showTransferPanel();
			
			break;
		case COMMAND_WITHDRAW:
			frameMain.hideMainPanel();
			frameMain.showWithdrawPanel();
			break;
		case COMMAND_DEPOSIT:
			frameMain.hideMainPanel();
			frameMain.showDepositPanel();
			break;
		case COMMAND_BACK_OPTIONS:
			frameMain.hideTransferPanel();
			frameMain.hideWithdrawPanel();
			frameMain.hidePanelShowTransactions();
			frameMain.hideDepositPanel();
			frameMain.showMainPanel();
			break;
		case COMMAND_SHOW_TRANSACTIONS:
			if(transactions.size() == 0) {
				frameMain.showErrorShowTransactiions();
			}else {
				positionTransactions = 0;
				transaction = transactions.get(0);
				frameMain.setDateTransaction(transaction.getDate().toString());
				frameMain.setAmountTransaction(String.valueOf(transaction.getAmount()));
				frameMain.setTypeTransaction(transaction.getType().toString());
				frameMain.hideMainPanel();
				frameMain.showPanelShowTransactions();
			}
			break;
		case COMMAND_LOG_OUT:
			actualAccount = null;
			actualUser = null;
			frameMain.hideMainPanel();
			frameMain.hideTransferPanel();
			frameMain.hideWithdrawPanel();
			frameMain.hidePanelShowTransactions();
			frameMain.showLoginPanel();
			break;
		case COMMAND_CREATE_ACCOUNT:
			if (validateInfoRegistration()) {
				bankManager.createAccount(createAccount());
				frameMain.showAccountSuccesfullyCreated();
				frameMain.resetInfoRegistration();
			}
			break;
		case COMMAND_MAKE_TRANSFER:
			if (validateInfoTransfer() && makeTransfer()) {
				transactions = actualAccount.getTransactions();
				setInfoAccount();
				frameMain.showTransferSuccesfully();
				frameMain.resetTransferPanel();
			}
			break;
		case COMMAND_MAKE_WITHDRAW:
			if (validateInfoWithdraw() && makeWithdrawal()) {
				transactions = actualAccount.getTransactions();
				setInfoAccount();
				frameMain.showWithdrawSuccesfully();
				frameMain.resetInfoWithdrawal();
			}
			break;
		case COMMAND_MAKE_DEPOSIT:
			if(validateInfoDeposit() && makeDeposit()) {
				transactions = actualAccount.getTransactions();
				setInfoAccount();
				frameMain.showDepositSuccessfully();
				frameMain.resetInfoDeposit();
			}
			break;
		case COMMAND_NEXT_TRANSACTION:
			if (transactions != null && positionTransactions < transactions.size() - 1) {
				transaction = transactions.get(++positionTransactions);
				frameMain.setDateTransaction(transaction.getDate().toString());
				frameMain.setAmountTransaction(String.valueOf(transaction.getAmount()));
				frameMain.setTypeTransaction(transaction.getType().toString());
			}
			break;
		case COMMAND_PREVIOUS_TRANSACTION:
			if (transactions != null && positionTransactions > 0) {
				transaction = transactions.get(--positionTransactions);
				frameMain.setDateTransaction(transaction.getDate().toString());
				frameMain.setAmountTransaction(String.valueOf(transaction.getAmount()));
				frameMain.setTypeTransaction(transaction.getType().toString());
			}
			break;
		case COMMAND_CHANGE_LANGUAGE:
			String language = frameMain.getLenguage();
			if(language.equals(Constants.LENGUAGE_EN)) {
				Constants.createInstance().changeLenguageEN();
				frameMain.setVisible(false);
				frameMain.dispose();
				frameMain = new FrameMain(this);
			}else if(language.equals(Constants.LENGUAGE_ES)){
				Constants.createInstance().changeLenguageES();
				frameMain.setVisible(false);
				frameMain.dispose();
				frameMain = new FrameMain(this);
			}
			break;
		case COMMAND_BART_CHART:
			frameMain.createBartChartJDialog(bankManager.plotNumberMenAndWomen());
			break;
		}
	}

	private boolean validateInfoLogin() {
		if (!frameMain.validateUsernameLogin() || !frameMain.validatePasswordLogin()) {
			frameMain.showDataErrorBlank();
			return false;
		}
		return true;
	}

	private boolean login() {
		ArrayList<Account> accounts = bankManager.getAccounts();
		if (validateInfoLogin()) {
			long username = Long.parseLong(frameMain.getUsernameLogin());
			String password = frameMain.getPasswordLogin();
			for (Account account : accounts) {
				if (account.getUser().getId() == username) {
					if (account.getPasswordAccount().equals(password)) {
						actualAccount = account;
						actualUser = account.getUser();
						return true;
					} else {
						frameMain.showDataErrorPasswordLogin();
						return false;
					}
				}
			}
			frameMain.showDataErrorUsernameLogin();
		}
		return false;
	}

	private void setInfoAccount() {
		frameMain.setResultNumberAccount(String.valueOf(actualAccount.getNumberAccount()));
		frameMain.setResultUser(actualUser.toString());
		frameMain.setResultMoney(String.valueOf(actualAccount.getMoney()));
	}

	private void setInfoUser() {
		frameMain.setResultName(actualUser.getName());
		frameMain.setResultLastName(actualUser.getLastName());
		Period age = Period.between(LocalDate.parse(actualUser.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy")), LocalDate.now());
		frameMain.setResultAge(String.valueOf(age.getYears())); 
		frameMain.setResultGender(String.valueOf(actualUser.getGender()));
		frameMain.setResultEmail(actualUser.getEmail());
		frameMain.setResultIdNumber(String.valueOf(actualUser.getId()));
	}

	private boolean validateInfoRegistration() {
		if (!frameMain.validateRegistrationName() || !frameMain.validateRegistrationLastName()
				|| !frameMain.validateRegistrationDateOfBirth() || !frameMain.validateRegistrationEmail()
				|| !frameMain.validateRegistrationNumberPhone() || !frameMain.validateRegistrationId()
				|| !frameMain.validateRegistrationPassword()) {
			frameMain.showDataErrorBlank();
		} else {
			return true;
		}
		return false;
	}

	private Account createAccount() {
		String name = frameMain.getRegistrationName();
		String lastName = frameMain.getRegistrationLastName();
		String dateOfBirth = frameMain.getRegistrationDateOfBirth();
		String email = frameMain.getResgistrationEmail();
		long numberPhone = Long.parseLong(frameMain.getRegistrationNumberPhone());
		Gender gender = frameMain.getRegistrationGender();
		long idNumber = Long.parseLong(frameMain.getResgitrationId());
		User user = new User(name, lastName, dateOfBirth, idNumber, email, numberPhone, gender);
		return new Account(user, numberPhone, frameMain.getRegistrationPassword(), 0);
	}

	public boolean validateInfoTransfer() {
		if (!frameMain.validateAmountTransfer() || !frameMain.validatePasswordTransfer()
				|| !frameMain.validateTargetAccountTransfer()) {
			frameMain.showDataErrorBlank();
		} else {
			return true;
		}
		return false;
	}

	private boolean makeTransfer() {
		try {
			double amount = Double.parseDouble(frameMain.getAmountTransfer());
			long numberAccountTarget = Long.parseLong(frameMain.getTargetAccountTransfer());
			if (actualAccount.getPasswordAccount().equals(frameMain.getPasswordTransfer())) {
				bankManager.transferMoney(amount, actualAccount, numberAccountTarget);
			} else {
				frameMain.showDataErrorPasswordLogin();
				return false;
			}
			return true;
		} catch (AccountNotFoundException | NotEnoughMoneyException e) {
			frameMain.showError(e.getMessage());
			return false;
		}
	}

	private boolean validateInfoWithdraw() {
		if (!frameMain.validateAmountWithdrawal() || !frameMain.validatePasswordWithdraw()) {
			frameMain.showDataErrorBlank();
		} else {
			return true;
		}
		return false;
	}

	private boolean makeWithdrawal() {
		double amount = Double.parseDouble(frameMain.getAmountWithdraw());
		try {
			if (frameMain.getPasswordWithdraw().equals(actualAccount.getPasswordAccount())) {
				bankManager.withdrawMoney(actualAccount, amount);
				return true;
			} else {
				frameMain.showDataErrorPasswordLogin();
				return false;
			}
		} catch (AccountNotFoundException | NotEnoughMoneyException e) {
			frameMain.showError(e.getMessage());
			return false;
		}
	}
	
	private boolean validateInfoDeposit() {
		if(!frameMain.validateAmountDeposit() || !frameMain.validatePasswordDeposit()) {
			frameMain.showDataErrorBlank();
			return false;
		}
		return true;
	}
	
	private boolean makeDeposit() {
		double amount = Double.parseDouble(frameMain.getAmountDeposit());
		if(actualAccount.getPasswordAccount().equals(frameMain.getPasswordDeposit())) {			
			bankManager.depositMoney(actualAccount, amount);
			return true;
		}
		frameMain.showDataErrorPasswordLogin();
		return false;
	}
}