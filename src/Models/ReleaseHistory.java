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
	public void ReleaseHistory(String name) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param id 
	 * @param date 
	 * @param funData 
	 * @param dsData 
	 * @param prDate 
	 */
	public void addRelease(Integer id, Date date, Integer funData, Integer dsData, Date prDate) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param releaseID 
	 * @return 
	 */
	public List<ReleaseInformation> getRelease(Integer releaseID) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param lawNumber 
	 * @param validity 
	 * @param comment 
	 */
	public void setLawEvaluation(Integer lawNumber, Boolean validity, String comment) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param lawNumber 
	 * @return 
	 */
	public Boolean getLawValidity(Integer lawNumber) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param lawNumber 
	 * @return 
	 */
	public String getLawComment(Integer lawNumber) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param lawNumber 
	 * @return 
	 */
	public Double getLawGraphData(Integer lawNumber) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param opOrDs 
	 * @return 
	 */
	private List<Double> getComplexityData(Boolean opOrDs) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param opOrDs 
	 * @return 
	 */
	private List<Double> getChangesData(Boolean opOrDs) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	private List<Double> getMaintananceActionsData() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	private List<Double> getVersionsPerYearData() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param opOrDs 
	 * @return 
	 */
	private Double getGrowthData(Boolean opOrDs) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param opOrDs 
	 * @return 
	 */
	private Double getWorkRateData(Boolean opOrDs) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @param opOrDs 
	 * @return 
	 */
	private Double getNumberData(Boolean opOrDs) { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	private List<Double> getNumOpEstData() { 
		// TODO Auto-generated method
		return null;
	 } 

}
