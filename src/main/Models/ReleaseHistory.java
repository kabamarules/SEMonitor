package Models;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ReleaseHistory {

	/**
	 * The name of the software system
	 */
	private String name;
	
	/**
	 * The list of the release
	 */
	private List<ReleaseInfo> releases; // Indexed by 0
	
	/**
	 * The holder of the laws validity and comments
	 */
	private LehmanLawsRecord[] laws;

	/**
	 * The total number of Lehman's laws
	 */
	private int numOfLaws = 8;
	
	/**
	 * Constructor
	 * @param name 
	 */
	public ReleaseHistory(String name) { 
		this.name = name;
		releases = new ArrayList<ReleaseInfo>();
		laws = new LehmanLawsRecord[numOfLaws];
		for (int i = 0; i < numOfLaws; i++)
			laws[i] = new LehmanLawsRecord(false, "Insert comment");
	 }
	
	/**
	 * Getter of the name
	 */
	public String getName() {
	 	 return name; 
	}
	
	/**
	 * Adding a release to the history
	 * @param id Release Id
	 * @param date Release Date
	 * @param opData Operations Additions/deletions/changes
	 * @param dsData Data structures Additions/deletions/changes
	 * @param opPrTot Previous total of operations
	 * @param dsPrTot Previous total of data structures
	 * @param prDate 
	 */
	public void addRelease(int id, Date date, int[] opData, int[] dsData, int opPrTot, int dsPrTot, Date prDate) {
		// Creating the change and metrics records for the operations
		ChangeRecord opCr = new ChangeRecord(opData[0], opData[1], opData[2], date);
		MetricsRecord opMr = new MetricsRecord(opCr, opPrTot, prDate);
		// Creating the change metrics records for the data structures
		ChangeRecord dsCr = new ChangeRecord(dsData[0], dsData[1], dsData[2], date);
		MetricsRecord dsMr = new MetricsRecord(dsCr, dsPrTot, prDate);

		ReleaseInfo ri = new ReleaseInfo(id, date, opCr, dsCr, opMr, dsMr);
		releases.add(ri);
	}
	
	/**
	 * Gets a release by id.
	 * Initial release has ID 1 and index 0.
	 * @param releaseID 
	 * @return 
	 */
	public ReleaseInfo getReleaseInformation(int releaseID) { 
		return releases.get(releaseID - 1);
	 }
	
	public int getNumberOfReleases() {
	 	 return releases.size(); 
	}
	
	/**
	 * Sets the evaluation and comment of a specific law.
	 * @param lawNumber 
	 * @param validity 
	 * @param comment 
	 */
	public void setLawEvaluation(int lawNumber, boolean validity, String comment) throws ArrayIndexOutOfBoundsException {
		if (lawNumber >=0 && lawNumber < numOfLaws ) {
			laws[lawNumber].setValidity(validity);
			laws[lawNumber].setComment(comment);;
		} else {
			throw new ArrayIndexOutOfBoundsException(lawNumber);
		}
	 }
	
	/**
	 * Gets the validity of a specific law
	 * @param lawNumber 
	 */
	public boolean getLawValidity(int lawNumber) { 
		return laws[lawNumber].getValidity();
	 }
	
	/**
	 * Gets the comment of a specific law 
	 * @param lawNumber 
	 */
	public String getLawComment(int lawNumber) { 
		return laws[lawNumber].getComment();
	 }
	
	/**
	 * Getter of all the laws
	 */
	public LehmanLawsRecord[] getLaws() {
	 	 return laws; 
	}
	
	/**
	 * Gets the graph data for a law.
	 * The return value might be of different dimensionality according to the law number.
	 * @param lawNumber 
	 * @return 
	 */
	public List<List<Double>> getLawGraphData(int lawNumber) { 
		List<List<Double>> graphList = new ArrayList<List<Double>>();
		
		switch (lawNumber) {
			case LehmanLawsRecord.LAW_1:
				graphList.add(getChangesData(ReleaseInfo.operations));
				graphList.add(getChangesData(ReleaseInfo.dataStructures));
				graphList.add(getVersionsPerYearData());
				break;
			case LehmanLawsRecord.LAW_2:
				graphList.add(getComplexityData(ReleaseInfo.operations));
				graphList.add(getComplexityData(ReleaseInfo.dataStructures));
				graphList.add(getMaintananceActionsData());
				break;
			case LehmanLawsRecord.LAW_3:
				graphList.add(getGrowthData(ReleaseInfo.operations));
				graphList.add(getGrowthData(ReleaseInfo.dataStructures));
				break;
			case LehmanLawsRecord.LAW_4:
				graphList.add(getWorkRateData(ReleaseInfo.operations));
				graphList.add(getWorkRateData(ReleaseInfo.dataStructures));
				break;
			case LehmanLawsRecord.LAW_5:
				graphList.add(getGrowthData(ReleaseInfo.operations));
				graphList.add(getGrowthData(ReleaseInfo.dataStructures));
				break;
			case LehmanLawsRecord.LAW_6:
				graphList.add(getTotalNumberData(ReleaseInfo.operations));
				graphList.add(getTotalNumberData(ReleaseInfo.dataStructures));
				break;
			case LehmanLawsRecord.LAW_7:
				// No graphs
				break;
			case LehmanLawsRecord.LAW_8:
				graphList.add(getTotalNumberData(ReleaseInfo.operations));
				graphList.add(getTotalEstimatedData());
				break;
		}
		return graphList;
	 }
	
	/**
	 * Returns the data for the changes graph.
	 * Used in Law 1.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	private List<Double> getChangesData(boolean opOrDs) { 
		return null;
	 }
	
	/**
	 * Returns the versions per year data.
	 * Used in Law 1
	 * @return 
	 */
	private List<Double> getVersionsPerYearData() { 
		return null;
	 }
	
	/**
	 * Returns the data for the complexity graph.
	 * Used in Law 2.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	private List<Double> getComplexityData(boolean opOrDs) { 
		return null;
	 }
	
	/**
	 * Returns the data for the maintenance actions graph.
	 * Used in Law 2.
	 * @return 
	 */
	private List<Double> getMaintananceActionsData() { 
		// TODO Implement
		return null;
	 }
	
	/**
	 * Returns the growth graph data.
	 * Used in Laws 3 & 5.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	private List<Double> getGrowthData(boolean opOrDs) { 
		// TODO Implement
		return null;
	 }
	
	/**
	 * Returns the work rate graph data.
	 * Used in Law 4.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	private List<Double> getWorkRateData(boolean opOrDs) { 
		// TODO Implement
		return null;
	 }
	
	/**
	 * Returns the total number graph data.
	 * Used in Law 6.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	private List<Double> getTotalNumberData(boolean opOrDs) { 
		// TODO Implement
		return null;
	 }
	
	/**
	 * Returns the number of operations estimations graph data.
	 * Used in Law 8.
	 * @return 
	 */
	private List<Double> getTotalEstimatedData() { 
		// TODO Implement
		return null;
	 } 
}
