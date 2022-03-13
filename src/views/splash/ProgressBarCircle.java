package views.splash;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class ProgressBarCircle extends JPanel {

	private static final long serialVersionUID = 1L;
	private int progress;

	public void updateProgress(int progressValue) {
		progress = progressValue;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setSize(600, 600);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
		g2d.rotate(Math.toRadians(270));
		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		Ellipse2D circle = new Ellipse2D.Float(0, 0, 110, 110);
		arc.setFrameFromCenter(new Point(0, 0), new Point(120, 120));
		circle.setFrameFromCenter(new Point(0, 0), new Point(110, 110));
		arc.setAngleStart(1);
		arc.setAngleExtent(-progress * 3.6);
		g2d.setPaint(new GradientPaint(0, 0, new Color(65, 119, 224).darker(), getWidth(), 0,
				new Color(57, 255, 193).darker()));

		g2d.draw(arc);
		g2d.fill(arc);
		g2d.setColor(new Color(0, 0, 0, 0));
		g2d.draw(circle);
		g2d.fill(circle);
		g2d.setPaint(new GradientPaint(0, 0, new Color(65, 119, 224).darker(), getWidth(), 0,
				new Color(57, 255, 193).darker()));

		g2d.rotate(Math.toRadians(90));
		g2d.setFont(new Font("Arial", Font.ITALIC, 36));
		FontMetrics fontg2d = g2d.getFontMetrics();
		Rectangle2D r = fontg2d.getStringBounds(progress + "%", g);
		int x = (int) (0 - r.getWidth() / 2);
		int y = (int) (0 - r.getHeight() / 2 + fontg2d.getAscent());
		g2d.drawString(progress + "%", x, y);
	}
}
