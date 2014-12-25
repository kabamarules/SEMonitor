package Models;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class ReleaseHistory {

	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private List<ReleaseInformation> releases;
	/**
	 * 
	 */
	private LehmanLawsRecord laws;
	/**
	 * 
	 * @return 
	 */
	public String getName() {
	 	 return name; 
	}
	/**
	 * Setter of name
	 */
	public void setName(String name) { 
		 this.name = name; 
	}
	/**
	 * 
	 * @return 
	 */
	public List<ReleaseInformation> getReleases() {
	 	 return releases; 
	}
	/**
	 * Setter of releases
	 */
	public void setReleases(List<ReleaseInformation> releases) { 
		 this.releases = releases; 
	}
	/**
	 * Getter of laws
	 */
	public LehmanLawsRecord getLaws() {
	 	 return laws; 
	}
	/**
	 * Setter of laws
	 */
	public void setLaws(LehmanLawsRecord laws) { 
		 this.laws = laws; 
	}
	/**
	 * 
	 * @param name 
	 */
	public ReleaseHistory(String name) { 
		this.name = name;
	 }
	/**
	 * 
	 * @param id 
	 * @param date 
	 * @param funData 
	 * @param dsData 
	 * @param prDate 
	 */
	public void addRelease(int id, Date date, int funData, int dsData, Date prDate) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param releaseID 
	 * @return 
	 */
	public List<ReleaseInformation> getRelease(int releaseID) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param lawNumber 
	 * @param validity 
	 * @param comment 
	 */
	public void setLawEvaluation(int lawNumber, Boolean validity, String comment) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param lawNumber 
	 * @return 
	 */
	public Boolean getLawValidity(int lawNumber) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param lawNumber 
	 * @return 
	 */
	public String getLawComment(int lawNumber) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param lawNumber 
	 * @return 
	 */
	public double getLawGraphData(int lawNumber) { 
		// TODO Auto-generated method
		return 0;
	 }
	/**
	 * 
	 * @param opOrDs 
	 * @return 
	 */
	public List<Double> getComplexityData(Boolean opOrDs) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param opOrDs 
	 * @return 
	 */
	public List<Double> getChangesData(Boolean opOrDs) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public List<Double> getMaintananceActionsData() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public List<Double> getVersionsPerYearData() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param opOrDs 
	 * @return 
	 */
	public double getGrowthData(Boolean opOrDs) { 
		// TODO Auto-generated method
		return 0;
	 }
	/**
	 * 
	 * @param opOrDs 
	 * @return 
	 */
	public double getWorkRateData(boolean opOrDs) { 
		// TODO Auto-generated method
		return 0;
	 }
	/**
	 * 
	 * @param opOrDs 
	 * @return 
	 */
	public double getNumberData(boolean opOrDs) { 
		// TODO Auto-generated method
		return 0;
	 }
	/**
	 * 
	 * @return 
	 */
	public List<Double> getNumOpEstData() { 
		// TODO Auto-generated method
		return null;
	 } 

}
