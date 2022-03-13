package views.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import views.Constants;

public class PanelInfoUser extends JPanel {

	private PanelPhoto photo;
	private JLabel name;
	private JLabel lastName;
	private JLabel age;
	private JLabel gender;
	private JLabel email;
	private JLabel phoneNumber;
	private GridBagConstraints gbc;
	
	public PanelInfoUser() {
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		initComponents();
	}
	
	private void initComponents() {
		photo = new PanelPhoto();
		
		name = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_NAME));
		name.setFont(Constants.FONT_LABEL);
		
		lastName = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_LAST_NAME));
		lastName.setFont(Constants.FONT_LABEL);
		
		age = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_AGE));
		age.setFont(Constants.FONT_LABEL);
		
		gender = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_GENDER));
		gender.setFont(Constants.FONT_LABEL);
		
		email = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_EMAIL));
		email.setFont(Constants.FONT_LABEL);
		
		phoneNumber = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_NUMBER_PHONE));
		phoneNumber.setFont(Constants.FONT_LABEL);
		
		Insets insets = new Insets(0,0,30, 20);
		gbc.insets = insets;
		gbc.gridwidth = 2;
		this.add(photo, gbc);
		gbc.gridwidth = 0;
		gbc.gridy = 1;
		this.add(name, gbc);
		gbc.gridy = 2;
		this.add(lastName, gbc);
		gbc.gridy = 3;
		this.add(age, gbc);
		gbc.gridy = 4;
		this.add(gender, gbc);
		gbc.gridy = 5;
		this.add(email, gbc);
		gbc.gridy = 6;
		this.add(phoneNumber, gbc);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		paintBorder(g2d);
		g2d.setColor(new Color(255, 255, 255, 80));
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}
	
	private void paintBorder(Graphics2D g2d) {
		g2d.setColor(Color.decode("#857991"));
		g2d.drawRect(0, 0, getWidth(), getHeight());
	}
}
