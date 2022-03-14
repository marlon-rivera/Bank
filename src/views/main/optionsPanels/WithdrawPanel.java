package views.main.optionsPanels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.TextPrompt;
import views.BankButton;
import views.Constants;
import views.PasswordTextRound;
import views.TextFieldRound;

public class WithdrawPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel amount;
	private TextFieldRound amountTxt;
	private JLabel password;
	private PasswordTextRound passwordTxt;
	private BankButton buttonMakeWithdraw;
	private GridBagConstraints gbc;

	public WithdrawPanel(ActionListener listener) {
		this.setSize(683, 384);
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		gbc = new GridBagConstraints();
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		amount = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_AMOUNT));
		amount.setFont(Constants.FONT_LABEL);
		amount.setForeground(Color.BLACK);
		amountTxt = new TextFieldRound(30);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_AMOUNT), amountTxt);

		password = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_PASSWORD));
		password.setFont(Constants.FONT_LABEL);
		password.setForeground(Color.BLACK);
		passwordTxt = new PasswordTextRound(30);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_PASSWORD), passwordTxt);

		buttonMakeWithdraw = new BankButton(Constants.createInstance().getProperty(Constants.TEXT_WITHDRAW),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_MAKE_WITHDRAW), listener,
				Constants.COLOR_BACKGROUND_S, Constants.COLOR_BACKGROUND_P, 170, 30);

		Insets insets = new Insets(0, 0, 30, 30);
		gbc.insets = insets;
		this.add(amount, gbc);
		gbc.gridx = 1;
		this.add(amountTxt, gbc);
		gbc.gridy = 1;
		gbc.gridx = 0;
		this.add(password, gbc);
		gbc.gridy = 1;
		gbc.gridx = 1;
		this.add(passwordTxt, gbc);
		gbc.gridy = 2;
		gbc.gridx = 1;
		this.add(buttonMakeWithdraw, gbc);
	}

	@Override
	public void paint(Graphics g) {
		ImageIcon image = new ImageIcon(Constants.createInstance().getProperty(Constants.BAKCGROUND_LOGIN));
		ImageIcon imageScaled = new ImageIcon(image.getImage().getScaledInstance(683, 384, Image.SCALE_SMOOTH));
		g.drawImage(imageScaled.getImage(), 0, 0, this);
		this.setBackground(new Color(0, 0, 0, 0));
		super.paint(g);
	}
}
