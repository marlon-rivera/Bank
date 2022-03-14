package views.login;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.FileManager;
import views.Constants;

public class LoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private LoginInformationPanel loginInformationPanel;
	private JLabel labelBackground;
	private Image imageScaled;
	
	public LoginPanel(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);		
		gbc = new GridBagConstraints();
		initComponents(listener);
	}
	
	private void initComponents(ActionListener listener) {
		Image image = FileManager.loadImage(Constants.createInstance().getProperty(Constants.BAKCGROUND_LOGIN));
		imageScaled = image.getScaledInstance(684, 384, Image.SCALE_SMOOTH);
		labelBackground = new JLabel(new ImageIcon(imageScaled));
		loginInformationPanel = new LoginInformationPanel(listener);
		Insets insets = new Insets(0,20,0,0);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = insets;
		gbc.anchor = GridBagConstraints.WEST;
		this.add(loginInformationPanel, gbc);
		insets = new Insets(0,0,0,0);
		gbc.insets = insets;
		gbc.anchor = GridBagConstraints.CENTER;
		this.add(labelBackground, gbc);
	}
	
	public int getWidthBackground() {
		return imageScaled.getWidth(this);  
	}
	
	public int getHeightBackground() {
		return imageScaled.getHeight(this);
	}
	
	public String getLenguage() {
		return loginInformationPanel.getLenguage();
	}
	
}
