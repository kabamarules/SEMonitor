package Models;

import java.util.Date;

public class ReleaseInformation {

	/**
	 * The sequential id of the release
	 */
	private int id;
	
	/**
	 * The date of the release
	 */
	private Date date;
	
	/**
	 * Change Records for operations and data structures
	 */
	private ChangeRecord[] changeRecords;
	
	/**
	 * Metrics Records for operations and data structures
	 */
	private MetricsRecord[] metricsRecords;
	
	/**
	 * Constructor
	 * @param id 
	 * @param date 
	 * @param opData 
	 * @param dsData 
	 * @param prDate 
	 */
	public ReleaseInformation(int id, Date date, ChangeRecord opChRd, ChangeRecord dsChRd, 
			MetricsRecord opMtRd, MetricsRecord dsMtRd) {
		changeRecords[1] = opChRd;
		changeRecords[2] = dsChRd;
		metricsRecords[1] = opMtRd; 
		metricsRecords[2] = dsMtRd; 
	}
	
	/**
	 * Getter of id
	 */
	public int getId() {
	 	 return id; 
	}

	/**
	 * Getter of the date
	 */
	public Date getDate() {
	 	 return date; 
	}
	
	/**
	 * Getter of the Operation Changes
	 */
	public ChangeRecord getOperationChanges() { 
		return changeRecords[1];
	 }
	
	/**
	 * Getter of the Data Structure Changes
	 */
	public ChangeRecord getDSChanges() { 
		return changeRecords[2];
	 }
	
	/**
	 * Getter of the Operation Metrics
	 */
	public MetricsRecord getOperationMetrics() { 
		return metricsRecords[1];
	 }
	
	/**
	 * Getter of the DSMetrics
	 */
	public MetricsRecord getDSMetrics() { 
		return metricsRecords[2];
	 } 

}
