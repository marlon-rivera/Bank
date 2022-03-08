package login;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoginFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	private static final String LOGIN_BANK = "Login Bank Center";
	private Toolkit tool;
	private LoginPanel loginPanel;
	private JPanel panel;

	public LoginFrame() {
		tool = Toolkit.getDefaultToolkit();
		Dimension dimension = tool.getScreenSize();
		this.setSize(800, 450);
		this.setTitle(LOGIN_BANK);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents(dimension);
	}

	private void initComponents(Dimension dimension) {
		loginPanel = new LoginPanel();
		this.add(loginPanel, BorderLayout.EAST);
	}
	
	public static void main(String[] args) {
		new LoginFrame();
	}
}