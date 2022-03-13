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

	private ProgressBarCircle bar;
	
	public Test() {
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		JButton button = new JButton("Iniciar");
		button.addActionListener(this);
		bar = new ProgressBarCircle();
		panel.add(button);
		panel.add(bar);
		add(panel); 
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					bar.updateProgress(i);
					bar.repaint();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				
			}
		}).start();;
		
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
