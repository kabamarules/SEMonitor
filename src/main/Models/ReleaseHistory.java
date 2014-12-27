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
	private List<ReleaseInformation> releases;
	
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
		releases = new ArrayList<ReleaseInformation>();
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

		ReleaseInformation ri = new ReleaseInformation(id, date, opCr, dsCr, opMr, dsMr);
		releases.add(ri);
	}
	
	/**
	 * Alternative way of adding a release to the history
	 * @param ri
	 */
	public void addRelease(ReleaseInformation ri) {
		releases.add(ri);
	}
	
	/**
	 * Gets a release by id.
	 * Initial release has id 1.
	 * @param releaseID 
	 * @return 
	 */
	public ReleaseInformation getReleaseInformation(int releaseID) { 
		return releases.get(releaseID - 1);
	 }
	
	/**
	 * Getter of all the releases
	 */
	public List<ReleaseInformation> getReleases() {
	 	 return releases; 
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
	public double getLawGraphData(int lawNumber) { 
		// TODO Auto-generated method
		return 0;
	 }
	
	/**
	 * Returns the data for the changes graph.
	 * Used in Law 1.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	private List<Double> getChangesData(boolean opOrDs) { 
		// TODO Auto-generated method
		return null;
	 }
	
	/**
	 * Returns the versions per year data.
	 * Used in Law 1
	 * @return 
	 */
	private List<Double> getVersionsPerYearData() { 
		// TODO Auto-generated method
		return null;
	 }
	
	/**
	 * Returns the data for the complexity graph.
	 * Used in Law 2.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	private List<Double> getComplexityData(boolean opOrDs) { 
		// TODO Auto-generated method
		return null;
	 }
	
	/**
	 * Returns the data for the maintenance actions graph.
	 * Used in Law 2.
	 * @return 
	 */
	private List<Double> getMaintananceActionsData() { 
		// TODO Auto-generated method
		return null;
	 }
	
	/**
	 * Returns the growth graph data.
	 * Used in Laws 3 & 5.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	private double getGrowthData(boolean opOrDs) { 
		// TODO Auto-generated method
		return 0;
	 }
	
	/**
	 * Returns the work rate graph data.
	 * Used in Law 4.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	private double getWorkRateData(boolean opOrDs) { 
		// TODO Auto-generated method
		return 0;
	 }
	
	/**
	 * Returns the total number graph data.
	 * Used in Law 6.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	private double getNumberData(boolean opOrDs) { 
		// TODO Auto-generated method
		return 0;
	 }
	
	/**
	 * Returns the number of operations estimations graph data.
	 * Used in Law 8.
	 * @return 
	 */
	private List<Double> getNumOpEstData() { 
		// TODO Auto-generated method
		return null;
	 } 
}
