package views.main.optionsPanels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.FilterInteger;
import models.HidePassword;
import util.TextPrompt;
import views.BankButton;
import views.BankButtonIcon;
import views.Constants;
import views.PasswordTextRound;
import views.TextFieldRound;

public class TransferPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel targetAccount;
	private TextFieldRound targetAccountTxt;
	private JLabel amount;
	private TextFieldRound amountTxt;
	private JLabel password;
	private PasswordTextRound passwordTxt;
	private BankButtonIcon buttonShowPassword;
	private GridBagConstraints gbc;
	private BankButton makeTransferButton;

	public TransferPanel(ActionListener listener) {
		this.setSize(683, 384);
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		gbc = new GridBagConstraints();
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {

		targetAccount = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_TARGET_ACCOUNT));
		targetAccount.setFont(Constants.FONT_LABEL);
		targetAccount.setForeground(Color.BLACK);
		targetAccountTxt = new TextFieldRound(30);
		targetAccountTxt.addKeyListener(new FilterInteger(targetAccountTxt));
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_TARGE_ACCOUNT), targetAccountTxt);

		amount = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_AMOUNT));
		amount.setFont(Constants.FONT_LABEL);
		amount.setForeground(Color.BLACK);
		amountTxt = new TextFieldRound(30);
		amountTxt.addKeyListener(new FilterInteger(amountTxt));
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_AMOUNT), amountTxt);

		password = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_PASSWORD));
		password.setFont(Constants.FONT_LABEL);
		password.setForeground(Color.BLACK);
		passwordTxt = new PasswordTextRound(30);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_PASSWORD), passwordTxt);
		
		makeTransferButton = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_MAKE_TRANSFER),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_MAKE_TRANSFER), listener,
				Constants.COLOR_BACKGROUND_S, Constants.COLOR_BACKGROUND_P, 170, 30);
		
		ImageIcon imagePass = new ImageIcon(Constants.createInstance().getProperty(Constants.SHOW_PASS));
		ImageIcon imageScaledPass = new ImageIcon(imagePass.getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonShowPassword = new BankButtonIcon(imageScaledPass,new HidePassword(passwordTxt), "", 18, 18, false);

		Insets insets = new Insets(0, 0, 30, 30);
		gbc.insets = insets;

		this.add(targetAccount, gbc);
		gbc.gridx = 1;
		this.add(targetAccountTxt, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(amount, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(amountTxt, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(password, gbc);
		gbc.gridx = 1;
		this.add(passwordTxt, gbc);
		gbc.gridx = 2;
		gbc.insets = new Insets(0, -90, 30, 0);
		this.add(buttonShowPassword, gbc);
		gbc.insets = insets;
		gbc.gridy = 3;
		gbc.gridx = 1;
		this.add(makeTransferButton, gbc);
	}

	public String getTargetAccountTransfer() {
		return targetAccountTxt.getText();
	}
	
	public String getAmountTransfer() {
		return amountTxt.getText();
	}
	
	public String getPasswordTransfer() {
		return String.valueOf(passwordTxt.getPassword());
	}
	
	public void resetTransferPanel() {
		targetAccountTxt.setText("");
		amountTxt.setText("");
		passwordTxt.setText("");
	}
	
	@Override
	public void paint(Graphics g) {
		ImageIcon image = new ImageIcon(Constants.createInstance().getProperty(Constants.BAKCGROUND_LOGIN));
		ImageIcon imageScaled = new ImageIcon(image.getImage().getScaledInstance(683, 384, Image.SCALE_SMOOTH));
		g.drawImage(imageScaled.getImage(), 0, 0, this);
		this.setBackground(new Color(0, 0, 0, 0));
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(255, 255, 255, 120));
		g2d.fillRoundRect(25, 33, getWidth() - 50, getHeight() - 50, 15, 15);
		super.paint(g);
		super.paint(g);
	}
}
