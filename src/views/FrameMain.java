package views;

import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import models.Gender;
import util.FileManager;
import views.login.LoginPanel;
import views.main.MainPanel;
import views.main.optionsPanels.PanelShowTransactions;
import views.main.optionsPanels.TransferPanel;
import views.main.optionsPanels.WithdrawPanel;
import views.resgistraton.PanelRegistration;

public class FrameMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String LOGIN_BANK = "Bank Center";
	private LoginPanel loginPanel;
	private PanelRegistration panelRegistration;
	private MainPanel mainPanel;
	private TransferPanel transferPanel;
	private WithdrawPanel withdrawPanel;
	private PanelShowTransactions panelShowTransactions;
	private BankButton backButtonRegister;
	private BankButton crossButton;
	private BankButton backButtonOptions;
	private BankButtonIcon buttonLogOut;

	public FrameMain(ActionListener listener) {
		setLayout(null);
		setSize(683, 384);
		setTitle(LOGIN_BANK);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image image = FileManager.loadImage(Constants.createInstance().getProperty(Constants.ICON_BANK));
		setIconImage(image);
		removeNotify();
		setUndecorated(true);
		addNotify();
		initComponents(listener);
		showLoginPanel();

	}

	private void initComponents(ActionListener listener) {

		backButtonRegister = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_BACK),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_BACK), listener,
				Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 45, 30);

		backButtonOptions = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_BACK),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_BACK_OPTIONS), listener,
				Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 45, 30);

		crossButton = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_CROSS),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_CROSS), listener,
				Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 45, 30);

		buttonLogOut = new BankButtonIcon(new ImageIcon(Constants.createInstance().getProperty(Constants.ICON_LOG_OUT)),
				listener, Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_LOG_OUT), 45, 30, true);

		loginPanel = new LoginPanel(listener);
		panelRegistration = new PanelRegistration(listener);
		mainPanel = new MainPanel(listener);
		transferPanel = new TransferPanel(listener);
		withdrawPanel = new WithdrawPanel(listener);
		panelShowTransactions = new PanelShowTransactions(listener);
	}

	public void showLoginPanel() {
		setSize(683, 384);
		crossButton.setVisible(true);
		loginPanel.setVisible(true);
		crossButton.setBounds(getWidth() - buttonLogOut.getWidthButton(), 0, buttonLogOut.getWidthButton(),
				buttonLogOut.getHeigthButton());
		add(crossButton);
		add(loginPanel).setBounds(0, 0, loginPanel.getWidthBackground(), loginPanel.getHeightBackground());
	}

	public void showPanelRegistration() {
		setSize(870, 450);
		crossButton.setVisible(true);
		panelRegistration.setVisible(true);
		backButtonRegister.setVisible(true);
		crossButton.setBounds(getWidth() - crossButton.getWidthButton(), 0, buttonLogOut.getWidthButton(),
				buttonLogOut.getHeigthButton());
		add(crossButton);

		backButtonRegister.setBounds(getWidth() - crossButton.getWidth() - backButtonRegister.getWidthButton(), 0,
				backButtonRegister.getWidthButton(), backButtonRegister.getHeightButton());

		add(backButtonRegister);

		add(panelRegistration).setBounds(0, 0, panelRegistration.getWidthImageBackground(),
				panelRegistration.getHeightImageBackground());

	}

	public void showMainPanel() {
		setSize(683, 384);
		buttonLogOut.setVisible(true);
		mainPanel.setVisible(true);
		buttonLogOut.setBounds(getWidth() - buttonLogOut.getWidthButton(), 0, buttonLogOut.getWidthButton(),
				buttonLogOut.getHeigthButton());
		add(buttonLogOut);
		add(mainPanel).setBounds(0, 0, mainPanel.getWidth(), mainPanel.getHeight());

	}

	public void showTransferPanel() {
		buttonLogOut.setVisible(true);
		backButtonOptions.setVisible(true);
		transferPanel.setVisible(true);
		buttonLogOut.setBounds(getWidth() - buttonLogOut.getWidthButton(), 0, buttonLogOut.getWidthButton(),
				buttonLogOut.getHeigthButton());
		add(buttonLogOut);

		backButtonOptions.setBounds(getWidth() - buttonLogOut.getWidth() - backButtonRegister.getWidthButton(), 0,
				backButtonRegister.getWidthButton(), backButtonRegister.getHeightButton());
		add(backButtonOptions);
		add(transferPanel).setBounds(0, 0, transferPanel.getWidth(), transferPanel.getHeight());
	}

	public void showWithdrawPanel() {
		buttonLogOut.setVisible(true);
		backButtonOptions.setVisible(true);
		withdrawPanel.setVisible(true);
		buttonLogOut.setBounds(getWidth() - buttonLogOut.getWidthButton(), 0, buttonLogOut.getWidthButton(),
				buttonLogOut.getHeigthButton());
		add(buttonLogOut);

		backButtonOptions.setBounds(getWidth() - buttonLogOut.getWidth() - backButtonRegister.getWidthButton(), 0,
				backButtonRegister.getWidthButton(), backButtonRegister.getHeightButton());
		add(backButtonOptions);
		add(withdrawPanel).setBounds(0, 0, transferPanel.getWidth(), transferPanel.getHeight());
	}

	public void showPanelShowTransactions() {
		buttonLogOut.setVisible(true);
		backButtonOptions.setVisible(true);
		panelShowTransactions.setVisible(true);
		buttonLogOut.setBounds(getWidth() - buttonLogOut.getWidthButton(), 0, buttonLogOut.getWidthButton(),
				buttonLogOut.getHeigthButton());
		add(buttonLogOut);

		backButtonOptions.setBounds(getWidth() - buttonLogOut.getWidth() - backButtonRegister.getWidthButton(), 0,
				backButtonRegister.getWidthButton(), backButtonRegister.getHeightButton());
		add(backButtonOptions);

		add(panelShowTransactions).setBounds(0, 0, transferPanel.getWidth(), transferPanel.getHeight());
	}

	public void hideLoginPanel() {
		loginPanel.setVisible(false);
		crossButton.setVisible(false);
	}

	public void hideMainPanel() {
		mainPanel.setVisible(false);
		buttonLogOut.setVisible(false);
	}

	public void hidePanelRegistration() {
		panelRegistration.setVisible(false);
		backButtonRegister.setVisible(false);
		crossButton.setVisible(false);
	}

	public void hideTransferPanel() {
		transferPanel.setVisible(false);
		buttonLogOut.setVisible(false);
		backButtonOptions.setVisible(false);
	}

	public void hideWithdrawPanel() {
		withdrawPanel.setVisible(false);
		buttonLogOut.setVisible(false);
		backButtonOptions.setVisible(false);
	}

	public void hidePanelShowTransactions() {
		buttonLogOut.setVisible(false);
		backButtonOptions.setVisible(false);
		panelShowTransactions.setVisible(false);
	}

	public void changeLenguage() {
		Constants.createInstance().changeLenguageEN();
	}

	public String getLenguage() {
		return this.loginPanel.getLenguage();
	}

	public String getUsernameLogin() {
		return loginPanel.getUsernameLogin();
	}

	public String getPasswordLogin() {
		return loginPanel.getPasswordLogin();
	}

	public void setResultName(String name) {
		mainPanel.setResultName(name);
	}

	public void setResultLastName(String lastName) {
		mainPanel.setResultLastName(lastName);
	}

	public void setResultAge(String age) {
		mainPanel.setResultAge(age);
	}

	public void setResultGender(String gender) {
		mainPanel.setResultGender(gender);
	}

	public void setResultEmail(String email) {
		mainPanel.setResultEmail(email);
	}

	public void setResultIdNumber(String idPhone) {
		mainPanel.setResultIdNumber(idPhone);
	}

	public void setResultMoney(String money) {
		mainPanel.setResultMoney(money);
	}

	public void setResultNumberAccount(String numberAccount) {
		mainPanel.setResultNumberAccount(numberAccount);
	}

	public void setResultUser(String user) {
		mainPanel.setResultUser(user);
	}

	public String getRegistrationName() {
		return panelRegistration.getRegistrationName();
	}

	public String getRegistrationLastName() {
		return panelRegistration.getRegistrationLastName();
	}

	public String getRegistrationDateOfBirth() {
		return panelRegistration.getRegistrationDateOfBirth();
	}

	public String getResgistrationEmail() {
		return panelRegistration.getResgistrationEmail();
	}

	public String getRegistrationNumberPhone() {
		return panelRegistration.getRegistrationNumberPhone();
	}

	public Gender getRegistrationGender() {
		return panelRegistration.getRegistrationGender();
	}

	public String getRegistrationPassword() {
		return panelRegistration.getRegistrationPassword();
	}

	public String getResgitrationId() {
		return panelRegistration.getResgitrationId();
	}

	public boolean validateRegistrationName() {
		if (getRegistrationName().isBlank()) {
			return false;
		}
		return true;
	}

	public boolean validateRegistrationLastName() {
		if (getRegistrationLastName().isBlank()) {
			return false;
		}
		return true;
	}

	public boolean validateRegistrationDateOfBirth() {
		if (getRegistrationDateOfBirth().isBlank()) {
			return false;
		}
		return true;
	}

	public boolean validateRegistrationEmail() {
		if (getResgistrationEmail().isBlank()) {
			return false;
		}
		return true;
	}

	public boolean validateRegistrationNumberPhone() {
		if (getRegistrationNumberPhone().isBlank()) {
			return false;
		}
		return true;
	}
	
	public boolean validateRegistrationPassword() {
		if(getRegistrationPassword().isBlank()) {
			return false;
		}
		return true;
	}

	public boolean validateRegistrationId() {
		if (getResgitrationId().isBlank()) {
			return false;
		}
		return true;
	}
	
	public String getTargetAccountTransfer() {
		return transferPanel.getTargetAccountTransfer();
	}
	
	public String getAmountTransfer() {
		return transferPanel.getAmountTransfer();
	}
	
	public String getPasswordTransfer() {
		return transferPanel.getPasswordTransfer();
	}
	
	public boolean validateTargetAccountTransfer() {
		if(getTargetAccountTransfer().isBlank()) {
			return false;
		}
		return true;
	}
	
	public boolean validateAmountTransfer() {
		if(getAmountTransfer().isBlank()) {
			return false;
		}
		return true;
	}
	
	public boolean validatePasswordTransfer() {
		if(getPasswordTransfer().isBlank()) {
			return false;
		}
		return true;
	}
	
	public boolean validateUsernameLogin() {
		if(getUsernameLogin().isBlank()) {
			return false;
		}
		return true;
	}
	
	public boolean validatePasswordLogin() {
		if(getPasswordLogin().isBlank()) {
			return false;
		}
		return true;
	}
	
	public String getAmountWithdraw() {
		return withdrawPanel.getAmountWhitdraw();
	}
	
	public boolean validateAmountWithdrawal() {
		if(getAmountWithdraw().isBlank()) {
			return false;
		}
		return true;
	}
	
	public String getPasswordWithdraw() {
		return withdrawPanel.getPasswordWithdraw();
	}
	
	public boolean validatePasswordWithdraw() {
		if(getPasswordWithdraw().isBlank()) {
			return false;
		}
		return true;
	}
	
	public void resetTransferPanel() {
		transferPanel.resetTransferPanel();
	}
	
	public void resetInfoRegistration() {
		panelRegistration.resetInfoRegistration();
	}
	
	public void resetInfoLogin() {
		loginPanel.resetInfoLogin();
	}

	public void resetInfoWithdrawal() {
		withdrawPanel.resetInfoWithdrawal();
	}
	
	public void setTypeTransaction(String typeTransaction) {
		panelShowTransactions.setResultTransactionType(typeTransaction);
	}
	
	public void setAmountTransaction(String amount) {
		panelShowTransactions.setResultAmount(amount);
	}
	
	public void setDateTransaction(String date) {
		panelShowTransactions.setResultDate(date);
	}
	
	public void showDataErrorBlank() {
		JOptionPane.showMessageDialog(null, Constants.createInstance().getProperty(Constants.ERROR_DATA_BLANK), Constants.ERROR,
				JOptionPane.ERROR_MESSAGE);
	}

	public void showDataErrorPasswordLogin() {
		JOptionPane.showMessageDialog(null, Constants.createInstance().getProperty(Constants.ERROR_DATA_PASSWORD_LOGIN),
				Constants.ERROR, JOptionPane.ERROR_MESSAGE);
	}

	public void showDataErrorUsernameLogin() {
		JOptionPane.showMessageDialog(null, Constants.createInstance().getProperty(Constants.ERROR_DATA_USERNAME_LOGIN),
				Constants.ERROR, JOptionPane.ERROR_MESSAGE);
	}
	
	public void showAccountSuccesfullyCreated() {
		JOptionPane.showMessageDialog(null, Constants.createInstance().getProperty(Constants.ACCOUNT_SUCCESSFULLY_CREATED),
				Constants.createInstance().getProperty(Constants.INFORMATION), JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void showError(String error) {
		JOptionPane.showMessageDialog(null, error,
				Constants.createInstance().getProperty(Constants.INFORMATION), JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void showTransferSuccesfully() {
		JOptionPane.showMessageDialog(null, Constants.createInstance().getProperty(Constants.TRANSFER_SUCCESSFULLY),
				Constants.createInstance().getProperty(Constants.INFORMATION), JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void showErrorShowTransactiions() {
		JOptionPane.showMessageDialog(null, Constants.createInstance().getProperty(Constants.ERROR_TRANSACTIONS),
				Constants.createInstance().getProperty(Constants.ERROR), JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void showWithdrawSuccesfully() {
		JOptionPane.showMessageDialog(null, Constants.createInstance().getProperty(Constants.WITHDRAW_SUCCESSFULLY),
				Constants.createInstance().getProperty(Constants.INFORMATION), JOptionPane.INFORMATION_MESSAGE);
	}
}