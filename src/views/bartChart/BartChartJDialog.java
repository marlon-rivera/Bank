package views.bartChart;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JDialog;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import util.FileManager;
import views.Constants;

public class BartChartJDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	public BartChartJDialog(int[] values) {
		this.setLayout(new BorderLayout());
		createBartChart(values);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setIconImage(FileManager.loadImage(Constants.createInstance().getProperty(Constants.ICON_BANK)));
		this.setVisible(true);
	}

	private void createBartChart(int[] values) {
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		data.setValue(values[0], Constants.createInstance().getProperty(Constants.WOMEN), "");
		data.setValue(values[1], Constants.createInstance().getProperty(Constants.MEN), "");

		JFreeChart bartChart = ChartFactory.createBarChart(
				Constants.createInstance().getProperty(Constants.TITLE_BART_CHART), "",
				Constants.createInstance().getProperty(Constants.QUANTITY), data, PlotOrientation.VERTICAL, true, true,
				false);
		ChartPanel panel = new ChartPanel(bartChart);
		panel.setMouseWheelEnabled(true);
		panel.setPreferredSize(new Dimension(350, 250));
		this.add(panel, BorderLayout.NORTH);

		pack();
		repaint();
	}

}
