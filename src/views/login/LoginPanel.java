package views.login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.FileManager;

public class LoginPanel extends JPanel {

	private static final String PATH_BACKGROUND = "src/res/background.jpg";
	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private LoginInformationPanel loginInformationPanel;
	private JLabel labelBackground;
	
	public LoginPanel() {
		setLayout(new GridBagLayout());
		//setOpaque(false);		
		gbc = new GridBagConstraints();
		initComponents();
	}
	
	private void initComponents() {
		Image image = FileManager.loadImage(PATH_BACKGROUND);
		Image imageScaled = image.getScaledInstance(690-6, 390-6, Image.SCALE_SMOOTH);
		labelBackground = new JLabel(new ImageIcon(imageScaled));
		loginInformationPanel = new LoginInformationPanel();
		// 668 345
		Insets insets = new Insets(0,40,0,0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = insets;
		gbc.anchor = GridBagConstraints.WEST;
		add(loginInformationPanel, gbc);
		insets = new Insets(0,0,0,0);
		gbc.insets = insets;
		gbc.anchor = GridBagConstraints.CENTER;
		add(labelBackground, gbc);
	}
}
