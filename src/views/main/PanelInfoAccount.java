package views.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import views.Constants;

public class PanelInfoAccount extends JPanel {

	private JLabel numberAccount;
	private JLabel money;
	private JLabel user;
	private GridBagConstraints gbc;

	public PanelInfoAccount() {
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		initComponents();
	}

	private void initComponents() {
		numberAccount = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_NUMBER_ACCOUNT));
		numberAccount.setFont(Constants.FONT_LABEL);

		money = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_MONEY));
		money.setFont(Constants.FONT_LABEL);

		user = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_USER));
		user.setFont(Constants.FONT_LABEL);
		Insets insets = new Insets(0, 0, 25, 100);
		gbc.insets = insets;
		this.add(numberAccount, gbc);
		gbc.gridx = 1;
		this.add(user, gbc);
		gbc.gridy = 1;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		this.add(money, gbc);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(new Color(0,0,0,0));
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
