package Models;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

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
			laws[i] = new LehmanLawsRecord(false, "");
	 }
	
	/**
	 * Getter of the name
	 */
	public String getName() {
	 	 return name; 
	}
	
	/**
	 * Returns the number of laws that are valid 
	 */
	public int getNumberOfValidLaws() {
		int c = 0;
		for (int i = 0; i < numOfLaws; i++) {
			if (getLawValidity(i)) c++;
		}
		return c;
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
	 * Initial release has ID 1.
	 * @param releaseID >= 1
	 * @return 
	 */
	public ReleaseInfo getReleaseByID(int releaseID) { 
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
	 * Returns the data for the changes graph.
	 * Used in Law 1.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	public Map<Integer, Integer> getChangesData(boolean opOrDs) { 
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(int i = 1; i <= getNumberOfReleases(); i++) {
			ReleaseInfo rh = getReleaseByID(i);
			m.put(rh.getId(), rh.getChangesRecord(opOrDs).getChanges());
		}
		return m;
	 }
	
	/**
	 * Returns the versions per year data.
	 * Used in Law 1
	 * @return 
	 */
	@SuppressWarnings("deprecation")
	public Map<Integer, Integer> getVersionsPerYearData() { 
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		int minYear = getReleaseByID(1).getDate().getYear() + 1900; // Java's internal year numbering
		int maxYear = getReleaseByID(getNumberOfReleases()).getDate().getYear() + 1900;

		// Initializing to get 0 even if there isn't a release on a year
		for (int i = minYear; i <= maxYear; i++) {
			m.put(i, 0);
		}
		
		int year;
		for(int i = 1; i <= getNumberOfReleases(); i++) {
			year = getReleaseByID(i).getDate().getYear() + 1900; 
			m.replace(year, m.get(year) + 1);
		}
		return m;
	 }
	
	/**
	 * Returns the data for the complexity graph.
	 * Used in Law 2.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	public Map<Integer, Double> getComplexityData(boolean opOrDs) { 
		Map<Integer, Double> m = new HashMap<Integer, Double>();
		
		for(int i = 1; i <= getNumberOfReleases(); i++) {
			ReleaseInfo rh = getReleaseByID(i);
			m.put(rh.getId(), rh.getMetricsRecord(opOrDs).getComplexity());
		}
		return m;
	}
	
	/**
	 * Returns the data for the maintenance actions graph.
	 * Used in Law 2.
	 * @return 
	 */
	public Map<Integer, Integer> getMaintenanceActionsData() { 
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(int i = 1; i <= getNumberOfReleases(); i++) {
			ReleaseInfo rh = getReleaseByID(i);
			int maintenance = rh.getChangesRecord(ReleaseInfo.operations).getChanges() +
					rh.getChangesRecord(ReleaseInfo.operations).getDeletions() +
					rh.getChangesRecord(ReleaseInfo.dataStructures).getChanges() +
					rh.getChangesRecord(ReleaseInfo.dataStructures).getDeletions();
			m.put(rh.getId(), maintenance);
		}
		return m;
	 }
	
	/**
	 * Returns the growth graph data.
	 * Used in Laws 3 & 5.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	public Map<Integer, Double> getGrowthData(boolean opOrDs) { 
		Map<Integer, Double> m = new HashMap<Integer, Double>();
		
		for(int i = 1; i <= getNumberOfReleases(); i++) {
			ReleaseInfo rh = getReleaseByID(i);
			m.put(rh.getId(), rh.getMetricsRecord(opOrDs).getGrowthRate());
		}
		return m;
	 }
	
	/**
	 * Returns the work rate graph data.
	 * Used in Law 4.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	public Map<Integer, Double> getWorkRateData(boolean opOrDs) { 
		Map<Integer, Double> m = new HashMap<Integer, Double>();
		
		for(int i = 1; i <= getNumberOfReleases(); i++) {
			ReleaseInfo rh = getReleaseByID(i);
			m.put(rh.getId(), rh.getMetricsRecord(opOrDs).getWorkRate());
		}
		return m;
	 }
	
	/**
	 * Returns the total number graph data.
	 * Used in Law 6.
	 * @param opOrDs Chooses between operation or data structure graph data
	 * @return 
	 */
	public Map<Integer, Integer> getTotalNumberData(boolean opOrDs) { 
		Map<Integer, Integer> m = new HashMap<Integer, Integer>();
		
		for(int i = 1; i <= getNumberOfReleases(); i++) {
			ReleaseInfo rh = getReleaseByID(i);
			m.put(rh.getId(), rh.getMetricsRecord(opOrDs).getTotalNumber());
		}
		return m;
	 }
	
	/**
	 * Returns the number of operations estimations graph data.
	 * Uses Lehman's Inverse Square formulation.
	 * "Metrics and Laws of Software Evolution - The Nineties View", Lehman et. al.
	 * Used in Law 8.
	 * @return 
	 */
	public Map<Integer, Double> getTotalEstimatedData() { 
		Map<Integer, Double> m = new HashMap<Integer, Double>();
		
		// For the first release we can't make a prediction
		m.put(1, (double)getReleaseByID(1).getMetricsRecord(ReleaseInfo.operations).getTotalNumber());
				
		for(int iplusone = 2; iplusone <= getNumberOfReleases(); iplusone++) {
			double si = m.get(iplusone - 1);
			double siplusone = si + ( computeETilde(iplusone)/ Math.pow(si, 2));
			m.put(getReleaseByID(iplusone).getId(), siplusone);
		}
		return m;
	}
	
	/**
	 * Computes the E tilde parameter of Lehman's Inverse Square Formula
	 * @param release
	 * @return
	 */
	private double computeETilde(int release) {
		double sum = 0;
		for (int i = 1; i <= release; i++) {
			sum += computeE(i);
		}
		return sum / release;
	}
	
	/**
	 * Computes E parameter of Lehman's Inverse Square Formula.
	 * @param release
	 * @return
	 */
	private double computeE(int release) {
		double sone = (double)getReleaseByID(1).getMetricsRecord(ReleaseInfo.operations).getTotalNumber();
		double si = (double)getReleaseByID(release).getMetricsRecord(ReleaseInfo.operations).getTotalNumber();
		
		double sum = 0;
		double s = 0;
		for (int i = 1; i < release; i++) {
			s = (double)getReleaseByID(i).getMetricsRecord(ReleaseInfo.operations).getTotalNumber();
			sum += 1 / Math.pow(s, 2);
		}
		return (si - sone) == 0 ? 0.0 : (si - sone) / sum;
	}
}
