package views;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import util.FileManager;
import views.login.LoginPanel;
import views.main.MainPanel;
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
	private BankButton crossButton;
	private BankButton backButtonRegister;
	private BankButton backButtonOptions;

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
		crossButton = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_CROSS),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_CROSS), listener,
				Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 45, 30);
		crossButton.setFont(new Font("Arial", Font.PLAIN, 10));

		backButtonRegister = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_BACK),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_BACK), listener,
				Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 45, 30);

		backButtonOptions = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_BACK),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_BACK_OPTIONS), listener,
				Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 45, 30);

		loginPanel = new LoginPanel(listener);
		panelRegistration = new PanelRegistration(listener);
		mainPanel = new MainPanel(listener);
		transferPanel = new TransferPanel(listener);
		withdrawPanel = new WithdrawPanel(listener);
	}

	public void showLoginPanel() {
		setSize(683, 384);
		crossButton.setVisible(true);
		loginPanel.setVisible(true);
		crossButton.setBounds(getWidth() - crossButton.getWidthButton(), 0, crossButton.getWidthButton(),
				crossButton.getHeightButton());
		add(crossButton);
		add(loginPanel).setBounds(0, 0, loginPanel.getWidthBackground(), loginPanel.getHeightBackground());
	}

	public void showPanelRegistration() {
		setSize(870, 450);
		crossButton.setVisible(true);
		panelRegistration.setVisible(true);
		crossButton.setBounds(getWidth() - crossButton.getWidthButton(), 0, crossButton.getWidthButton(),
				crossButton.getHeightButton());
		add(crossButton);

		backButtonRegister.setBounds(getWidth() - crossButton.getWidth() - backButtonRegister.getWidthButton(), 0,
				backButtonRegister.getWidthButton(), backButtonRegister.getHeightButton());

		add(backButtonRegister);

		add(panelRegistration).setBounds(0, 0, panelRegistration.getWidthImageBackground(),
				panelRegistration.getHeightImageBackground());

	}

	public void showMainPanel() {
		setSize(683, 384);
		crossButton.setVisible(true);
		mainPanel.setVisible(true);
		crossButton.setBounds(getWidth() - crossButton.getWidthButton(), 0, crossButton.getWidthButton(),
				crossButton.getHeightButton());
		add(crossButton);
		add(mainPanel).setBounds(0, 0, mainPanel.getWidth(), mainPanel.getHeight());

	}

	public void showTransferPanel() {
		crossButton.setVisible(true);
		backButtonOptions.setVisible(true);
		transferPanel.setVisible(true);
		crossButton.setBounds(getWidth() - crossButton.getWidthButton(), 0, crossButton.getWidthButton(),
				crossButton.getHeightButton());
		add(crossButton);

		backButtonOptions.setBounds(getWidth() - crossButton.getWidth() - backButtonRegister.getWidthButton(), 0,
				backButtonRegister.getWidthButton(), backButtonRegister.getHeightButton());
		add(backButtonOptions);
		add(transferPanel).setBounds(0, 0, transferPanel.getWidth(), transferPanel.getHeight());
	}

	public void showWithdrawPanel() {
		crossButton.setVisible(true);
		backButtonOptions.setVisible(true);
		withdrawPanel.setVisible(true);
		crossButton.setBounds(getWidth() - crossButton.getWidthButton(), 0, crossButton.getWidthButton(),
				crossButton.getHeightButton());
		add(crossButton);

		backButtonOptions.setBounds(getWidth() - crossButton.getWidth() - backButtonRegister.getWidthButton(), 0,
				backButtonRegister.getWidthButton(), backButtonRegister.getHeightButton());
		add(backButtonOptions);
		add(withdrawPanel).setBounds(0, 0, transferPanel.getWidth(), transferPanel.getHeight());
	}

	public void hideLoginPanel() {
		loginPanel.setVisible(false);
		crossButton.setVisible(false);
	}

	public void hideMainPanel() {
		mainPanel.setVisible(false);
		crossButton.setVisible(false);
	}

	public void hidePanelRegistration() {
		panelRegistration.setVisible(false);
		crossButton.setVisible(false);
	}

	public void hideTransferPanel() {
		transferPanel.setVisible(false);
		crossButton.setVisible(false);
		backButtonOptions.setVisible(false);
	}

	public void hideWithdrawPanel() {
		withdrawPanel.setVisible(false);
		crossButton.setVisible(false);
		backButtonOptions.setVisible(false);
	}
	
	public void changeLenguage() {
		Constants.createInstance().changeLenguageEN();
	}

	public String getLenguage() {
		return this.loginPanel.getLenguage();
	}
}