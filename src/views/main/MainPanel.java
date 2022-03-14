package views.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import views.Constants;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelInfoUser infoUser;
	private PanelInfoAccount infoAccount;
	private PanelOptions options;
	private JLabel labelBackground;
	private JLabel labelMain;

	public MainPanel(ActionListener listener) {
		this.setLayout(null);
		this.setSize(683, 384);
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		ImageIcon imageScaled = new ImageIcon(
				new ImageIcon(Constants.createInstance().getProperty(Constants.BAKCGROUND_LOGIN)).getImage()
						.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH));
		labelBackground = new JLabel(imageScaled);

		labelMain = new JLabel(Constants.createInstance()
				.getProperty(Constants.TEXT_MAIN_MENU));
		labelMain.setSize(440, 30);
		labelMain.setFont(new Font("Arial", Font.PLAIN, 20));
		labelMain.setForeground(Color.WHITE);

		infoAccount = new PanelInfoAccount();
		infoAccount.setSize(new Dimension(440, 230));

		infoUser = new PanelInfoUser();
		infoUser.setSize(new Dimension(243, 354));

		options = new PanelOptions(listener);
		options.setSize(new Dimension(440, 124));

		this.add(labelMain).setBounds(0, 0, labelMain.getWidth(), labelMain.getHeight());

		this.add(infoAccount).setBounds(0, getHeight() - infoAccount.getHeight() - options.getHeight(),
				infoAccount.getWidth(), infoAccount.getHeight());

		this.add(infoUser).setBounds(getWidth() - infoUser.getWidth(), getHeight() - infoUser.getHeight(),
				infoUser.getWidth(), infoUser.getHeight());

		this.add(options).setBounds(0, getHeight() - options.getHeight(), options.getWidth(), options.getHeight());

		this.add(labelBackground).setBounds(0, 0, imageScaled.getIconWidth(), imageScaled.getIconHeight());

	}
}
