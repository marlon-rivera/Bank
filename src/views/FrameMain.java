package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

import util.FileManager;
import views.login.LoginPanel;
import views.resgistraton.PanelInfoRegistration;
import views.resgistraton.PanelRegistration;

public class FrameMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final String LOGIN_BANK = "Bank Center";
	private LoginPanel loginPanel;
	private PanelRegistration panelRegistration;
	private BankButton crossButton;

	public FrameMain() {
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
		initComponents();
	}

	private void initComponents() {
		crossButton = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_CROSS),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_CROSS), null, Constants.COLOR_BACKGROUND_P,
				Constants.COLOR_BACKGROUND_S, 45, 30);
		crossButton.setFont(new Font("Arial", Font.PLAIN, 10));
		loginPanel = new LoginPanel(null);
		panelRegistration = new PanelRegistration(null);
		//addPanelRegistration();
		addLoginPanel();
	}

	public void addLoginPanel() {
		crossButton.setBounds(getWidth() - crossButton.getWidthButton(), 0, crossButton.getWidthButton(), crossButton.getHeightButton());
		add(crossButton);
		add(loginPanel).setBounds(0, 0, loginPanel.getWidthBackground(), loginPanel.getHeightBackground());
	}
	
	public void addPanelRegistration() {
		setSize(870,  450);		
		crossButton.setBounds(getWidth() - crossButton.getWidthButton(), 0, crossButton.getWidthButton(), crossButton.getHeightButton());
		add(crossButton);
		add(panelRegistration).setBounds(0, 0, panelRegistration.getWidthImageBackground(), panelRegistration.getHeightImageBackground());;
	}

	public void hideLoginPanel() {
		loginPanel.setVisible(false);
	}

	public static void main(String[] args) {
		new FrameMain();
	}
}