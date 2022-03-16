package views.resgistraton;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import models.Gender;
import util.FileManager;
import views.Constants;

public class PanelRegistration extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel labelBackground;
	private PanelInfoRegistration panelInfoRegistration;
	private GridBagConstraints gbc;
	private JLabel createAccount;
	private Image imageScaled;
	
	public PanelRegistration(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		this.setSize(870, 450);
		gbc = new GridBagConstraints();
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		Image image = FileManager.loadImage(Constants.createInstance().getProperty(Constants.BAKCGROUND_LOGIN));
		imageScaled = image.getScaledInstance(870, 450, Image.SCALE_SMOOTH);
		labelBackground = new JLabel(new ImageIcon(imageScaled));
		createAccount = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_CREATE_YOUT_ACCOUNT));
		createAccount.setFont(new Font("Arial", Font.PLAIN, 36));
		panelInfoRegistration = new PanelInfoRegistration(listener);
		gbc.gridx = 0;
		gbc.gridy = 0;
		this.add(createAccount, gbc);
		gbc.gridy = 1;
		this.add(panelInfoRegistration, gbc);
		gbc.gridy = 0;
		gbc.gridheight = 2;
		this.add(labelBackground, gbc);
	}
	
	
	public String getRegistrationName() {
		return panelInfoRegistration.getRegistrationName();
	}

	public String getRegistrationLastName() {
		return panelInfoRegistration.getRegistrationLastName();
	}

	public String getRegistrationDateOfBirth() {
		return panelInfoRegistration.getRegistrationDateOfBirth();
	}

	public String getResgistrationEmail() {
		return panelInfoRegistration.getResgistrationEmail();
	}

	public String getRegistrationNumberPhone() {
		return panelInfoRegistration.getRegistrationNumberPhone();
	}

	public Gender getRegistrationGender() {
		return panelInfoRegistration.getRegistrationGender();
	}
	
	public String getRegistrationPassword() {
		return panelInfoRegistration.getRegistrationPassword();
	}
	
	public String getResgitrationId() {
		return panelInfoRegistration.getResgitrationId();
	}
	
	public void resetInfoRegistration() {
		panelInfoRegistration.resetInfoRegistration();
	}
	
	public int getWidthImageBackground() {
		return imageScaled.getWidth(this);
	}
	
	public int getHeightImageBackground() {
		return imageScaled.getHeight(this);
	}
}
