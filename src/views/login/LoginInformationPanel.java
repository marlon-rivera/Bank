package views.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.FileManager;
import util.TextPrompt;

public class LoginInformationPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel labelUserIcon;
	private JLabel username;
	private TextFieldRound usernameTxt;
	private JLabel password;
	private TextFieldRound passwordTxt;
	private GridBagConstraints gbc;
	
	public LoginInformationPanel() {
		setLayout(new GridBagLayout());
		setOpaque(false);
		gbc = new GridBagConstraints();
		setBorder(BorderFactory.createLineBorder(Color.decode("#857991")));
		initComponents();
	}
	
	private void initComponents() {
		Image image = FileManager.loadImage("src/res/iconLogin.png");
		Image imageScaled = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
		labelUserIcon = new JLabel(new ImageIcon(imageScaled));
		username = new JLabel("Nombre de usuario:");
		username.setFont(new Font("Arial", Font.PLAIN, 16));
		username.setForeground(Color.BLACK);
		username.setBackground(Color.PINK);
		usernameTxt = new TextFieldRound(15);
		new TextPrompt("Ingrese aqui su usuario", usernameTxt);
		password = new JLabel("Contrasena:");
		password.setFont(new Font("Arial", Font.PLAIN, 16));
		passwordTxt = new TextFieldRound(15);
		new TextPrompt("Ingrese aqui su contrasenia", passwordTxt);
		labelUserIcon.setOpaque(false);
		Insets insets = new Insets(10, 40, 0, 40);
		gbc.insets = insets;
		add(labelUserIcon, gbc);
		gbc.gridy = 1;
		insets = new Insets(0, 40, 0, 40);
		gbc.insets = insets;
		add(username, gbc);
		gbc.gridy = 2;
		gbc.insets = insets;
		add(usernameTxt, gbc);
		gbc.gridy = 3;
		add(password, gbc);
		gbc.gridy = 4;
		insets = new Insets(0, 40, 170, 40);
		gbc.insets = insets;
		add(passwordTxt, gbc);
	}
}