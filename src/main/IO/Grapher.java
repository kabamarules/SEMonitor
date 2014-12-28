package IO;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import Models.LehmanLawsRecord;
import Models.ReleaseHistory;
import Models.ReleaseInfo;

public class Grapher {

	/**
	 * Gets the graph data for a law.
	 * The return value might be of different dimensionality according to the law number.
	 * @param lawNumber 
	 * @return 
	 */
	public static List<JPanel> getLawGraphs(ReleaseHistory rh, int lawNumber) { 
		List<JPanel> graphs = new ArrayList<JPanel>();
		
		switch (lawNumber) {
			case LehmanLawsRecord.LAW_1:
				graphs.add(barChart(rh.getChangesData(ReleaseInfo.operations), "Operation changes"));
				graphs.add(barChart(rh.getChangesData(ReleaseInfo.dataStructures), "DS Changes"));
				graphs.add(barChart(rh.getVersionsPerYearData(), "Versions per year"));
				break;
			case LehmanLawsRecord.LAW_2:
				graphs.add(lineChart(rh.getComplexityData(ReleaseInfo.operations), "Operations Complexity"));
				graphs.add(lineChart(rh.getComplexityData(ReleaseInfo.dataStructures), "DS Complexity"));
				graphs.add(barChart(rh.getMaintenanceActionsData(), "Maintenance actions"));
				break;
			case LehmanLawsRecord.LAW_3:
				graphs.add(lineChart(rh.getGrowthData(ReleaseInfo.operations), "Operations Growth"));
				graphs.add(lineChart(rh.getGrowthData(ReleaseInfo.dataStructures), "DS Growth"));
				break;
			case LehmanLawsRecord.LAW_4:
				graphs.add(lineChart(rh.getWorkRateData(ReleaseInfo.operations), "Operations Work Rate"));
				graphs.add(lineChart(rh.getWorkRateData(ReleaseInfo.dataStructures), "DS Work Rate"));
				break;
			case LehmanLawsRecord.LAW_5:
				graphs.add(lineChart(rh.getGrowthData(ReleaseInfo.operations), "Operations Growth"));
				graphs.add(lineChart(rh.getGrowthData(ReleaseInfo.dataStructures), "DS Growth"));
				break;
			case LehmanLawsRecord.LAW_6:
				graphs.add(lineChart(rh.getTotalNumberData(ReleaseInfo.operations), "Total operations"));
				graphs.add(lineChart(rh.getTotalNumberData(ReleaseInfo.dataStructures), "Total DS"));
				break;
			case LehmanLawsRecord.LAW_7:
				// No graphs
				break;
			case LehmanLawsRecord.LAW_8:
				graphs.add(lineChart(rh.getTotalNumberData(ReleaseInfo.operations), "Total operations"));
				//graphs.add(lineChart(rh.getTotalEstimatedData(), "Estimated operations"));
				break;
		}
		return graphs;
	 }
	
	private static JPanel barChart(Map<? extends Number, ? extends Number> data, String title) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for (Map.Entry<? extends Number, ? extends Number> entry : data.entrySet()) {
            dataset.setValue(entry.getValue(), "id", (Comparable) entry.getKey());
        }        
        JFreeChart chart = ChartFactory.createBarChart(title,
        "", "", dataset, PlotOrientation.VERTICAL,
        false, false, false);
        
        CategoryPlot p = chart.getCategoryPlot(); 
        CategoryAxis axisX = p.getDomainAxis();

        Font fontX = new Font("Dialog", Font.PLAIN, 8);;
        axisX.setTickLabelFont(fontX);

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;
	}
	
	private static JPanel lineChart(Map<? extends Number, ? extends Number> data, String title) {
        XYSeries series = new XYSeries("Data");
        
        for (Map.Entry<? extends Number, ? extends Number> entry : data.entrySet()) {
            series.add(entry.getKey(), entry.getValue());
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        JFreeChart chart = ChartFactory.createXYLineChart(
            title, "", "", dataset,
            PlotOrientation.VERTICAL,  // Plot Orientation
            false,                      // Show Legend
            false,                      // Use tooltips
            false                      // Configure chart to generate URLs
            );
        
        // Integer ticks for x axis
        XYPlot plot = chart.getXYPlot();
        NumberAxis numberAxis = (NumberAxis)plot.getDomainAxis();
        numberAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        ChartPanel chartPanel = new ChartPanel(chart);
        return chartPanel;	
   }
}
