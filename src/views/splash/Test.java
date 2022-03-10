package views.splash;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
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
		BankButton button1 = new BankButton("X", "X", this, new Color(0, 0, 0, 80), new Color(0,0,0,0), 50, 50);
		new Thread(bar).start();
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
