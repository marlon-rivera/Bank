package views.login;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.FileManager;
import util.TextPrompt;
import views.BankButton;
import views.Constants;
import views.TextFieldRound;

public class LoginInformationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel labelUserIcon;
	private JLabel username;
	private TextFieldRound usernameTxt;
	private JLabel password;
	private TextFieldRound passwordTxt;
	private BankButton buttonEnter;
	//private BankButton buttonForgotPassword;
	private BankButton buttonRegister;
	private JLabel language;
	private JComboBox<String> comboLanguage;
	
	private GridBagConstraints gbc;
	
	public LoginInformationPanel(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		gbc = new GridBagConstraints();
		this.setBorder(BorderFactory.createLineBorder(Color.decode("#857991")));
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		Image image = FileManager.loadImage(Constants.createInstance().getProperty(Constants.ICON_LOGIN));
		Image imageScaled = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		labelUserIcon = new JLabel(new ImageIcon(imageScaled));
		username = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_USERNMAE));
		username.setFont(Constants.FONT_LABEL);
		username.setForeground(Color.BLACK);
		usernameTxt = new TextFieldRound(15);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_USERNMAE), usernameTxt);
		password = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_PASSWORD));
		password.setFont(Constants.FONT_LABEL);
		password.setForeground(Color.BLACK);
		passwordTxt = new TextFieldRound(15);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_PASSWORD), passwordTxt);
		labelUserIcon.setOpaque(false);
		buttonEnter = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_ENTER), Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_ENTER), listener, Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 100, 25);
		//buttonForgotPassword = new BankButton(Constants.createInstance().getProperty(""), Constants.createInstance().getProperty(""), listener, Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 100, 100);
		buttonRegister = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_REGISTER), Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_REGISTER), listener, Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 170, 30);
		language = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_LANGUAGE));
		language.setOpaque(false);
		language.setFont(Constants.FONT_LABEL);
		language.setForeground(Color.WHITE);
		initComboLenguage();
		Insets insets = new Insets(10, 40, 0, 40);
		gbc.insets = insets;
		this.add(labelUserIcon, gbc);
		gbc.gridy = 1;
		insets = new Insets(10, 40, 0, 40);
		gbc.insets = insets;
		this.add(username, gbc);
		gbc.gridy = 2;
		gbc.insets = insets;
		this.add(usernameTxt, gbc);
		gbc.gridy = 3;
		this.add(password, gbc);
		gbc.gridy = 4;
		insets = new Insets(10, 40, 0, 40);
		gbc.insets = insets;
		this.add(passwordTxt, gbc);
		insets = new Insets(10, 40, 0, 40);
		gbc.insets = insets;
		gbc.gridy = 5;
		this.add(buttonEnter, gbc);
		insets = new Insets(10, 0, 0, 0);
		gbc.insets = insets;
		gbc.gridy = 6;
		this.add(buttonRegister, gbc);
		gbc.gridy = 8;
		insets = new Insets(15, 0, 10, 0);
		gbc.insets = insets;
		this.add(comboLanguage, gbc);
		insets = new Insets(10, 15, 0, 0);
		gbc.insets = insets;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridy = 7;
		this.add(language, gbc);
	}
	
	private void initComboLenguage() {
		comboLanguage = new JComboBox<>();
		comboLanguage.setOpaque(false);
		comboLanguage.setBackground(Constants.COLOR_BACKGROUND_P);
		comboLanguage.setForeground(Color.WHITE);
		comboLanguage.addItem(Constants.LENGUAGE_ES);
		comboLanguage.addItem(Constants.LENGUAGE_EN);
	}
}
