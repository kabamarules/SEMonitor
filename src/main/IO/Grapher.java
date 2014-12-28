package IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

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
				graphs.add(barChart(rh.getChangesData(ReleaseInfo.operations)));
				graphs.add(barChart(rh.getChangesData(ReleaseInfo.dataStructures)));
				graphs.add(barChart(rh.getVersionsPerYearData()));
				break;
			case LehmanLawsRecord.LAW_2:
				graphs.add(lineChart(rh.getComplexityData(ReleaseInfo.operations)));
				graphs.add(lineChart(rh.getComplexityData(ReleaseInfo.dataStructures)));
				graphs.add(barChart(rh.getMaintananceActionsData()));
				break;
			case LehmanLawsRecord.LAW_3:
				graphs.add(lineChart(rh.getGrowthData(ReleaseInfo.operations)));
				graphs.add(lineChart(rh.getGrowthData(ReleaseInfo.dataStructures)));
				break;
			case LehmanLawsRecord.LAW_4:
				graphs.add(lineChart(rh.getWorkRateData(ReleaseInfo.operations)));
				graphs.add(lineChart(rh.getWorkRateData(ReleaseInfo.dataStructures)));
				break;
			case LehmanLawsRecord.LAW_5:
				graphs.add(lineChart(rh.getGrowthData(ReleaseInfo.operations)));
				graphs.add(lineChart(rh.getGrowthData(ReleaseInfo.dataStructures)));
				break;
			case LehmanLawsRecord.LAW_6:
				graphs.add(lineChart(rh.getTotalNumberData(ReleaseInfo.operations)));
				graphs.add(lineChart(rh.getTotalNumberData(ReleaseInfo.dataStructures)));
				break;
			case LehmanLawsRecord.LAW_7:
				// No graphs
				break;
			case LehmanLawsRecord.LAW_8:
				graphs.add(lineChart(rh.getTotalNumberData(ReleaseInfo.operations)));
				graphs.add(lineChart(rh.getTotalEstimatedData()));
				break;
		}
		return graphs;
	 }
	
	private static JPanel barChart(Map<? extends Number, ? extends Number> m) {
		return null;
	}
	
	private static JPanel lineChart(Map<? extends Number, ? extends Number> m) {
		return null;
	}
}
