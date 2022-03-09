package views.splash;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import views.BankButton;

public class Test extends JFrame implements ActionListener{

	public Test() {
		setSize(1000, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setSize(400,400);
		ProgressBar bar = new ProgressBar(10000);
		BankButton button1 = new BankButton("XXX", this, "X", 100, 100, Color.PINK, Color.GREEN, false);
		new Thread(bar).start();
		//panel.add(bar);
		panel.add(button1);
		add(panel); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
