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

public class PanelInfoUser extends JPanel {

	private static final long serialVersionUID = 1L;
	private PanelPhoto photo;
	private JLabel name;
	private JLabel resultName;
	private JLabel lastName;
	private JLabel resultLastName;
	private JLabel age;
	private JLabel resultAge;
	private JLabel gender;
	private JLabel resultGender;
	private JLabel email;
	private JLabel resultEmail;
	private JLabel idNumber;
	private JLabel resultIdNumber;
	private GridBagConstraints gbc;

	public PanelInfoUser() {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		gbc = new GridBagConstraints();
		initComponents();
	}

	private void initComponents() {
		photo = new PanelPhoto();

		name = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_NAME));
		name.setFont(Constants.FONT_LABEL);
		name.setForeground(Color.WHITE);
		resultName = new JLabel();
		resultName.setFont(Constants.FONT_LABEL);
		resultName.setForeground(Color.WHITE);

		lastName = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_LAST_NAME));
		lastName.setFont(Constants.FONT_LABEL);
		lastName.setForeground(Color.WHITE);
		resultLastName = new JLabel();
		resultLastName.setFont(Constants.FONT_LABEL);
		resultLastName.setForeground(Color.WHITE);
		
		age = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_AGE));
		age.setFont(Constants.FONT_LABEL);
		age.setForeground(Color.WHITE);
		resultAge = new JLabel();
		resultAge.setFont(Constants.FONT_LABEL);
		resultAge.setForeground(Color.WHITE);

		gender = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_GENDER));
		gender.setFont(Constants.FONT_LABEL);
		gender.setForeground(Color.WHITE);
		resultGender = new JLabel();
		resultGender.setFont(Constants.FONT_LABEL);
		resultGender.setForeground(Color.WHITE);
		
		email = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_EMAIL));
		email.setFont(Constants.FONT_LABEL);
		email.setForeground(Color.WHITE);
		resultEmail = new JLabel();
		resultEmail.setFont(Constants.FONT_LABEL);
		resultEmail.setForeground(Color.WHITE);
		
		idNumber = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_ID_NUMBER));
		idNumber.setFont(Constants.FONT_LABEL);
		idNumber.setForeground(Color.WHITE);
		resultIdNumber = new JLabel();
		resultIdNumber.setFont(Constants.FONT_LABEL);
		resultIdNumber.setForeground(Color.WHITE);
		
		Insets insets = new Insets(0, 0, 15, 5);
		gbc.insets = insets;
		this.add(photo, gbc);
		gbc.gridy = 1;
		this.add(name, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(resultName, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(lastName, gbc);
		gbc.gridx = 1;
		this.add(resultLastName, gbc);
		gbc.gridx = 0;
		gbc.gridy = 3;
		this.add(age, gbc);
		gbc.gridx = 1;
		this.add(resultAge, gbc);
		gbc.gridx = 0;
		gbc.gridy = 4;
		this.add(gender, gbc);
		gbc.gridx = 1;
		this.add(resultGender, gbc);
		gbc.gridx = 0;
		gbc.gridy = 5;
		this.add(email, gbc);
		gbc.gridx = 1;
		this.add(resultEmail, gbc);
		gbc.gridx = 0;
		gbc.gridy = 6;
		this.add(idNumber, gbc);
		gbc.gridx = 1;
		this.add(resultIdNumber, gbc);
		
		
	}
	
	public void setResultName(String name) {
		resultName.setText(name);
	}
	
	public void setResultLastName(String lastName) {
		resultLastName.setText(lastName);
	}
	
	public void setResultAge(String age) {
		resultAge.setText(age);
	}
	
	public void setResultGender(String gender) {
		resultGender.setText(gender);
	}
	
	public void setResultEmail(String email) {
		resultEmail.setText(email);
	}
	
	public void setResultIdNumber(String idNumber) {
		resultIdNumber.setText(idNumber);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		paintBorder(g2d);
		g2d.setColor(new Color(0, 0, 0, 50));
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

	private void paintBorder(Graphics2D g2d) {
		g2d.setColor(Color.decode("#857991"));
		g2d.drawRect(0, 0, getWidth(), getHeight());
	}
}
