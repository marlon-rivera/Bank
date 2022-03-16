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

import views.BankButton;
import views.Constants;

public class PanelShowTransactions extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel transactionAmount;
	private JLabel resultAmount;
	private JLabel transactionDate;
	private JLabel resultDate;
	private JLabel transactionType;
	private JLabel resultTransactionType;
	private JLabel transaction;
	private BankButton nextTransaction;
	private BankButton preivousTransaction;
	private GridBagConstraints gbc;

	public PanelShowTransactions(ActionListener listener) {
		this.setSize(683, 384);
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		initComponents(listener);
		System.out.println(Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_NEXT_TRANSACTION));
		System.out.println(Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_PREVIOUS_TRANSACTION));
	}

	private void initComponents(ActionListener listener) {

		transaction = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_TRANSACTIONS));
		transaction.setFont(Constants.FONT_LABEL);

		transactionAmount = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_TRANSACTION_AMOUNT));
		transactionAmount.setFont(Constants.FONT_LABEL);
		resultAmount = new JLabel();
		resultAmount.setFont(Constants.FONT_LABEL);

		transactionDate = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_TRANSACTION_DATE));
		transactionDate.setFont(Constants.FONT_LABEL);
		resultDate = new JLabel();
		resultDate.setFont(Constants.FONT_LABEL);

		transactionType = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_TRANSACTION_TYPE));
		transactionType.setFont(Constants.FONT_LABEL);
		resultTransactionType = new JLabel();
		resultTransactionType.setFont(Constants.FONT_LABEL);

		nextTransaction = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_NEXT_TRANSACTION),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_NEXT_TRANSACTION), listener,
				Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 200, 30);

		preivousTransaction = new BankButton(
				Constants.createInstance().getProperty(Constants.BUTTON_PREVIOUS_TRANSACTION),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_PREVIOUS_TRANSACTION), listener,
				Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 200, 30);
		Insets insets = new Insets(0, 0, 30, 150);
		gbc.insets = insets;
		this.add(transaction, gbc);
		gbc.gridwidth = 0;
		gbc.gridy = 1;
		this.add(transactionAmount, gbc);
		gbc.gridx = 1;
		this.add(resultAmount, gbc);
		gbc.gridy = 2;
		gbc.gridx = 0;
		this.add(transactionDate, gbc);
		gbc.gridx = 1;
		this.add(resultDate, gbc);
		gbc.gridy = 3;
		gbc.gridx = 0;
		this.add(transactionType, gbc);
		gbc.gridx = 1;
		gbc.insets = new Insets(0, 0, 30, -30);
		this.add(resultTransactionType, gbc);
		gbc.gridy = 4;
		gbc.gridx = 0;
		insets = new Insets(0, 0, 30, 170);
		gbc.insets = insets;
		this.add(preivousTransaction, gbc);
		gbc.gridx = 1;
		insets = new Insets(0, 25, 30, 0);
		gbc.insets = insets;
		this.add(nextTransaction, gbc);
	}
	
	public void setResultAmount(String amount) {
		resultAmount.setText(amount);
	}

	public void setResultTransactionType(String typeTransaction) {
		resultTransactionType.setText(typeTransaction);
	}
	
	public void setResultDate(String date) {
		resultDate.setText(date);
	}
	
	public void resetInfoTransactions() {
		resultAmount.setText("");
		resultTransactionType.setText("");
		resultDate.setText("");
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
	}
}
