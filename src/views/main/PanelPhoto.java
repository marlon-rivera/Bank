package views.main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import views.Constants;

public class PanelPhoto extends JPanel {
	private ImageIcon imagePhoto;

	public PanelPhoto() {
		this.imagePhoto = new ImageIcon(Constants.createInstance().getProperty(Constants.DEFAULT_PHOTO));
		try {
			initComponents();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initComponents() throws IOException {
		this.setOpaque(false);
		this.setPreferredSize(new Dimension(60, 60));
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				String path = "";
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

					JFileChooser chooser = new JFileChooser();
					FileFilter filtroImagen = new FileNameExtensionFilter("Archivos JPG, PNG, JPEG, BMP, GIF, TIFF",
							"jpg", "png", "jpeg", "bmp", "gif", "tiff");
					chooser.setFileFilter(filtroImagen);
					int option = chooser.showOpenDialog(chooser);
					if (option == JFileChooser.APPROVE_OPTION) {
						path = chooser.getSelectedFile().getAbsolutePath();
						imagePhoto = new ImageIcon(path);
						repaint();
					}

				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException | NullPointerException e1) {
				}
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics2d.setColor(new Color(0, 0, 0, 0));
		graphics2d.setClip(new Ellipse2D.Double(0, 0, getWidth(), getHeight()));
		graphics2d.drawImage(imagePhoto.getImage(), 0, 0, getWidth(), getHeight(), this);

	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new PanelPhoto());
	}
}
