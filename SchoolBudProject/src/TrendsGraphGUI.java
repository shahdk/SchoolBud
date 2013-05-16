import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import javax.swing.JFrame;

public class TrendsGraphGUI {
	private XYSeriesCollection dataset;
	private GradeTrendGraph graph;
	private String type;

	public TrendsGraphGUI(Course course, int difficulty, int rate, int caseNum) {
		dataset = new XYSeriesCollection();
		XYSeries data = new XYSeries("data");
		
			graph = new GradeTrendGraph(course, difficulty, rate);
			graph.updateAll();
			double len = 0;
			System.out.println("Here");
			switch (caseNum) {
			case 0:
				type = "Best Case";
				for (DataPoint d : graph.getBestGradePredictionCurvePoints()) {
					len++;
					data.add(len, d.getY());
				}
				break;
			case 1:
				type = "Medium Case";
				for (DataPoint d : graph.getGradePredictionCurvePoints()) {
					len++;
					data.add(len, d.getY());
				}
				break;
			default:
				type = "Worst Case";
				for (DataPoint d : graph.getWorstGradePredictionCurvePoints()) {
					len++;
					data.add(len, d.getY());
				}
				break;
			}
			dataset.addSeries(data);
		
	}

	public ChartPanel showGraph() {
		final JFreeChart chart = createChart(dataset, type);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		return chartPanel;
	}

	private JFreeChart createChart(final XYDataset dataset, String type) {
		final JFreeChart chart = ChartFactory.createScatterPlot(
				"Trends Graph - " + type, // chart
				// title
				"Weeks", // x axis label
				"Percent Points", // y axis label
				dataset, // data
				PlotOrientation.VERTICAL, false, // include legend
				true, // tooltips
				false // urls
				);
		XYPlot plot = (XYPlot) chart.getPlot();
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesLinesVisible(0, true);
		plot.setRenderer(renderer);
		return chart;
	}

}