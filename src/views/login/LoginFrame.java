package views.login;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;

import util.FileManager;

public class LoginFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final String LOGIN_BANK = "Login Bank Center";
	private LoginPanel loginPanel;

	public LoginFrame() {
		setSize(683, 384);
		setTitle(LOGIN_BANK);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image image = FileManager.loadImage("src/res/iconBank.png");
		setIconImage(image);
		removeNotify();
		setUndecorated(true);
		addNotify();
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
		
		initComponents();
	}

	private void initComponents() {
		loginPanel = new LoginPanel();
		add(loginPanel, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}
}