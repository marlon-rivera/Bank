package views.resgistraton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.toedter.calendar.JDateChooser;

import models.Gender;
import util.TextPrompt;
import views.BankButton;
import views.Constants;
import views.PasswordTextRound;
import views.TextFieldRound;

public class PanelInfoRegistration extends JPanel {

	private static final long serialVersionUID = 1L;
	private GridBagConstraints gbc;
	private JLabel name;
	private TextFieldRound nameTxt;
	private JLabel lastName;
	private TextFieldRound lastNameTxt;
	private JDateChooser calendar;
	private JLabel dateOfBirth;
	private TextFieldRound dateOfBirthTxt;
	private JLabel idNumber;
	private TextFieldRound idNumberTxt;
	private JLabel email;
	private TextFieldRound emailTxt;
	private JLabel numberPhone;
	private TextFieldRound numberPhoneTxt;
	private JLabel gender;
	private JComboBox<Gender> genderComboBox;
	private JLabel password;
	private PasswordTextRound passwordTxt;
	private BankButton buttonCreateAccount;

	public PanelInfoRegistration(ActionListener listener) {
		this.setLayout(new GridBagLayout());
		this.setOpaque(false);
		gbc = new GridBagConstraints();
		initComponents(listener);
	}

	private void initComponents(ActionListener listener) {
		name = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_NAME));
		name.setFont(Constants.FONT_LABEL);
		nameTxt = new TextFieldRound(30);
		nameTxt.setForeground(Color.BLACK);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_NAME), nameTxt);

		lastName = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_LAST_NAME));
		lastName.setFont(Constants.FONT_LABEL);
		lastNameTxt = new TextFieldRound(30);
		lastNameTxt.setForeground(Color.BLACK);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_LAST_NAME), lastNameTxt);

		dateOfBirth = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_DATE_OF_BIRTH));
		dateOfBirth.setFont(Constants.FONT_LABEL);
		dateOfBirthTxt = new TextFieldRound(30);
		dateOfBirthTxt.setForeground(Color.BLACK);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_DATE_OF_BIRTH), dateOfBirthTxt);
		calendar = new JDateChooser();
		calendar.setPreferredSize(new Dimension(24, 20));
		calendar.getCalendarButton().setBackground(new Color(0, 0, 0, 0));
		calendar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		if (Constants.lenguageActual.equals("EN")) {
			calendar.setLocale(Locale.US);
		} else {
			calendar.setLocale(new Locale("es"));
		}
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (calendar.getDate() != null) {
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					dateOfBirthTxt.setText(simpleDateFormat.format(calendar.getDate()).toUpperCase());
				}
			}
		});
		dateOfBirthTxt.add(calendar, BorderLayout.EAST);

		idNumber = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_ID_NUMBER));
		idNumber.setFont(Constants.FONT_LABEL);
		idNumberTxt = new TextFieldRound(30);
		idNumberTxt.setForeground(Color.BLACK);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_ID_NUMBER), idNumberTxt);

		email = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_EMAIL));
		email.setFont(Constants.FONT_LABEL);
		emailTxt = new TextFieldRound(30);
		emailTxt.setForeground(Color.BLACK);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_EMAIL), emailTxt);

		numberPhone = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_NUMBER_PHONE));
		numberPhone.setFont(Constants.FONT_LABEL);
		numberPhoneTxt = new TextFieldRound(30);
		numberPhoneTxt.setForeground(Color.BLACK);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_NUMBER_PHONE), numberPhoneTxt);

		gender = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_GENDER));
		gender.setFont(Constants.FONT_LABEL);
		initGenderComboBox();

		password = new JLabel(Constants.createInstance().getProperty(Constants.TEXT_PASSWORD));
		password.setFont(Constants.FONT_LABEL);
		passwordTxt = new PasswordTextRound(30);
		passwordTxt.setForeground(Color.BLACK);
		new TextPrompt(Constants.createInstance().getProperty(Constants.PLACE_HOLDER_PASSWORD), passwordTxt);

		buttonCreateAccount = new BankButton(
				Constants.createInstance().getProperty(Constants.BUTTON_CREATE_YOUR_ACCOUNT),
				Constants.createInstance().getProperty(Constants.COMMAND_BUTTON_CREATE_YOUR_ACCOUNT), listener,
				Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 150, 40);

		gbc.gridx = 0;
		gbc.gridy = 0;
		Insets insets = new Insets(10, 50, 10, 0);
		gbc.insets = insets;
		this.add(name, gbc);
		gbc.gridy = 1;
		this.add(nameTxt, gbc);
		gbc.gridy = 2;
		this.add(lastName, gbc);
		gbc.gridy = 3;
		this.add(lastNameTxt, gbc);
		gbc.gridy = 4;
		this.add(dateOfBirth, gbc);
		gbc.gridy = 5;
		this.add(dateOfBirthTxt, gbc);
		gbc.gridy = 6;
		this.add(idNumber, gbc);
		gbc.gridy = 7;
		this.add(idNumberTxt, gbc);
		insets = new Insets(10, 50, 10, 50);
		gbc.insets = insets;
		gbc.gridx = 1;
		gbc.gridy = 0;
		this.add(email, gbc);
		gbc.gridy = 1;
		this.add(emailTxt, gbc);
		gbc.gridy = 2;
		this.add(numberPhone, gbc);
		gbc.gridy = 3;
		this.add(numberPhoneTxt, gbc);
		gbc.gridy = 4;
		this.add(gender, gbc);
		gbc.gridy = 5;
		this.add(genderComboBox, gbc);
		gbc.gridy = 6;
		this.add(password, gbc);
		gbc.gridy = 7;
		this.add(passwordTxt, gbc);
		gbc.gridy = 8;
		this.add(buttonCreateAccount, gbc);
	}

	private void initGenderComboBox() {
		genderComboBox = new JComboBox<Gender>();
		genderComboBox.setOpaque(false);
		genderComboBox.setBackground(new Color(0, 0, 0, 95));
		genderComboBox.setFont(Constants.FONT_LABEL);
		genderComboBox.setForeground(new Color(255, 255, 255));
		genderComboBox.addItem(Gender.FEMALE);
		genderComboBox.addItem(Gender.MALE);
	}

	@Override
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(255, 255, 255, 120));
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paint(g);
	}
}
