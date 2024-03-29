package views.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import views.BankButtonIcon;
import views.Constants;

public class PanelOptions extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel labelTransfer;
	private BankButtonIcon transfer;
	private JLabel labelWithdraw;
	private BankButtonIcon withdraw;
	private JLabel labelDeposit;
	private BankButtonIcon deposit;
	private GridBagConstraints gbc;

	public PanelOptions(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		gbc = new GridBagConstraints();
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		labelTransfer = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_TRANSFER));
		labelTransfer.setFont(Constants.FONT_LABEL);
		labelTransfer.setForeground(Color.WHITE);
		transfer = new BankButtonIcon(new ImageIcon(Constants.createInstance().getProperty(Constants.ICON_TRANSFER)),
				listener, Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_TRANSFER), 55, 55, true);

		labelWithdraw = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_WITHDRAW));
		labelWithdraw.setFont(Constants.FONT_LABEL);
		labelWithdraw.setForeground(Color.WHITE);
		withdraw = new BankButtonIcon(new ImageIcon(Constants.createInstance().getProperty(Constants.ICON_WITHDRAW)),
				listener, Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_WITHDRAW), 55, 55, true);

		labelDeposit = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_DEPOSIT));
		labelDeposit.setFont(Constants.FONT_LABEL);
		labelDeposit.setForeground(Color.WHITE);
		deposit = new BankButtonIcon(new ImageIcon(Constants.createInstance().getProperty(Constants.ICON_DEPOSIT)),
				listener, Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_DEPOSIT), 55, 55, true);

		Insets insets = new Insets(0, 0, 0, 15);
		gbc.insets = insets;
		this.add(deposit, gbc);
		gbc.gridy = 1;
		this.add(labelDeposit, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(transfer, gbc);
		gbc.gridy = 1;
		this.add(labelTransfer, gbc);
		gbc.gridy = 0;
		gbc.gridx = 2;
		this.add(withdraw, gbc);
		gbc.gridy = 1;
		this.add(labelWithdraw, gbc);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		paintBorder(g2d);
	}
	
	private void paintBorder(Graphics2D g2d) {
		g2d.setColor(Color.decode("#857991"));
		g2d.drawRect(0, 0, getWidth(), getHeight());
	}
}
