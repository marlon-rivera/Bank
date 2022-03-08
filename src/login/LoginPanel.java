package login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import util.FileManager;

public class LoginPanel extends JPanel {

	private static final String PATH_BACKGROUND = "src/res/background.jpg";
	private static final long serialVersionUID = 1L;
	private BackgroundPanel backgroundPanel;
	private GridBagConstraints gbc;
	private LoginInformationPanel loginInformationPanel;
	
	public LoginPanel() {
		setLayout(new GridBagLayout());
		setOpaque(false);		
		gbc = new GridBagConstraints();
		
		initComponents();
	}
	
	private void initComponents() {
		backgroundPanel = new BackgroundPanel(FileManager.loadImage(PATH_BACKGROUND));
		loginInformationPanel = new LoginInformationPanel();
		Insets insets = new Insets(0,100,0,0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = insets;
		gbc.anchor = GridBagConstraints.WEST;
		add(loginInformationPanel, gbc);
		gbc.insets = new Insets(0,0,0,0);
		gbc.anchor = GridBagConstraints.EAST;
		add(backgroundPanel, gbc);
	}
}
