package views.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import views.Constants;

public class PanelInfoAccount extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel numberAccount;
	private JLabel money;
	private JLabel user;
	private GridBagConstraints gbc;

	public PanelInfoAccount() {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		gbc = new GridBagConstraints();
		initComponents();
	}

	private void initComponents() {
		numberAccount = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_NUMBER_ACCOUNT));
		numberAccount.setFont(Constants.FONT_LABEL);
		numberAccount.setForeground(Color.BLACK);

		money = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_MONEY));
		money.setFont(Constants.FONT_LABEL);
		money.setForeground(Color.BLACK);

		user = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_USER));
		user.setFont(Constants.FONT_LABEL);
		user.setForeground(Color.BLACK);

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
