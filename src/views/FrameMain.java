package views;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;

import javax.swing.JFrame;

import util.FileManager;
import views.login.LoginPanel;

public class FrameMain extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final String LOGIN_BANK = "Bank Center";
	private LoginPanel loginPanel;
	private BankButton crossButton;

	public FrameMain() {
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
		initComponents();
		this.repaint();
		this.revalidate();
	}

	private void initComponents() {
		crossButton = new BankButton(Constants.createInstance().getProperty(Constants.BUTTON_CROSS), Constants.createInstance().getProperty(""), null, Constants.COLOR_BACKGROUND_P, Constants.COLOR_BACKGROUND_S, 20, 20);
		this.add(crossButton);
		loginPanel = new LoginPanel(null);
		System.out.println(loginPanel.getX());
		System.out.println(loginPanel.getY());
		addLoginPanel();
	}
	
	public void addLoginPanel() {
		add(loginPanel, BorderLayout.EAST);
	}
	
	public void hideLoginPanel() {
		loginPanel.setVisible(false);
	}
	
	public static void main(String[] args) {
		new FrameMain();
	}
}