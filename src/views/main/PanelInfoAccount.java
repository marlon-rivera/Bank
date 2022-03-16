package views.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import views.BankButton;
import views.Constants;

public class PanelInfoAccount extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel numberAccount;
	private JLabel resultNumberAccount;
	private JLabel money;
	private JLabel resultMoney;
	private JLabel user;
	private JLabel resultUser;
	private BankButton transactions;
	private GridBagConstraints gbc;

	public PanelInfoAccount(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		gbc = new GridBagConstraints();
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		numberAccount = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_NUMBER_ACCOUNT));
		numberAccount.setFont(Constants.FONT_LABEL);
		numberAccount.setForeground(Color.BLACK);
		resultNumberAccount = new JLabel();
		resultNumberAccount.setFont(Constants.FONT_LABEL);
		resultNumberAccount.setForeground(Color.BLACK);
		
		
		money = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_MONEY));
		money.setFont(Constants.FONT_LABEL);
		money.setForeground(Color.BLACK);
		resultMoney = new JLabel();
		resultMoney.setFont(Constants.FONT_LABEL);
		resultMoney.setForeground(Color.BLACK);
		
		user = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_USER));
		user.setFont(Constants.FONT_LABEL);
		user.setForeground(Color.BLACK);
		resultUser = new JLabel();
		resultUser.setFont(Constants.FONT_LABEL);
		resultUser.setForeground(Color.BLACK);
		
		transactions = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_SHOW_TRANSACTIONS), Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_SHOW_TRANSACTIONS), listener, Constants.COLOR_BACKGROUND_P,
				Constants.COLOR_BACKGROUND_S, 200, 30);

		Insets insets = new Insets(0, 0, 25, 100);
		gbc.insets = insets;
		this.add(numberAccount, gbc);
		gbc.gridy = 1;
		this.add(resultNumberAccount, gbc);
		gbc.gridy = 0;
		gbc.gridx = 1;
		this.add(user, gbc);
		gbc.gridy = 1;
		this.add(resultUser, gbc);
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(money, gbc);
		gbc.gridy = 3;
		this.add(resultMoney, gbc);
		gbc.gridwidth = 0;
		gbc.gridy = 4;
		this.add(transactions, gbc);
	}
	
	public void setResultMoney(String money) {
		resultMoney.setText(money);
	}
	
	public void setResultNumberAccount(String numberAccount) {
		resultNumberAccount.setText(numberAccount);
	}
	
	public void setResultUser(String user) {
		resultUser.setText(user);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(255, 255, 255, 30));
		g.fillRect(0, 0, getWidth(), getHeight());
		Graphics2D g2d = (Graphics2D)g;
		paintBorder(g2d);
	}
	
	private void paintBorder(Graphics2D g2d) {
		g2d.setColor(Color.decode("#857991"));
		g2d.drawRect(0, 0, getWidth(), getHeight());
	}
}
