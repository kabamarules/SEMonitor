package Models;

import java.util.Date;

public class ReleaseInformation {

	/**
	 * 
	 */
	private Integer id;
	/**
	 * 
	 */
	private Date date;
	/**
	 * 
	 */
	private ChangeRecord changeRecord;
	/**
	 * 
	 */
	private MetricsRecord metricsRecord;
	/**
	 * 
	 * @return 
	 */
	public Integer getId() {
	 	 return id; 
	}
	/**
	 * Setter of id
	 */
	public void setId(Integer id) { 
		 this.id = id; 
	}
	/**
	 * 
	 * @return 
	 */
	public Date getDate() {
	 	 return date; 
	}
	/**
	 * Setter of date
	 */
	public void setDate(Date date) { 
		 this.date = date; 
	}
	/**
	 * Getter of changeRecord
	 */
	public ChangeRecord getChangeRecord() {
	 	 return changeRecord; 
	}
	/**
	 * Setter of changeRecord
	 */
	public void setChangeRecord(ChangeRecord changeRecord) { 
		 this.changeRecord = changeRecord; 
	}
	/**
	 * Getter of metricsRecord
	 */
	public MetricsRecord getMetricsRecord() {
	 	 return metricsRecord; 
	}
	/**
	 * Setter of metricsRecord
	 */
	public void setMetricsRecord(MetricsRecord metricsRecord) { 
		 this.metricsRecord = metricsRecord; 
	}
	/**
	 * 
	 * @param id 
	 * @param date 
	 * @param funData 
	 * @param dsData 
	 * @param prDate 
	 */
	public ReleaseInformation(Integer id, Date date, Integer funData, Integer dsData, Date prDate) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @return 
	 */
	public ChangeRecord getOperationChanges() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public ChangeRecord getDSChanges() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public MetricsRecord getOperationMetrics() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public MetricsRecord getDSMetrics() { 
		// TODO Auto-generated method
		return null;
	 } 

}
