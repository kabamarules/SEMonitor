package Models;

import java.util.Date;

public class MetricsRecord {

	/**
	 * 
	 */
	private ChangeRecord changeRecord;
	/**
	 * 
	 */
	private Integer previousTotal;
	/**
	 * 
	 */
	private Date previousDate;
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
	 * Getter of previousTotal
	 */
	public Integer getPreviousTotal() {
	 	 return previousTotal; 
	}
	/**
	 * Setter of previousTotal
	 */
	public void setPreviousTotal(Integer previousTotal) { 
		 this.previousTotal = previousTotal; 
	}
	/**
	 * Getter of previousDate
	 */
	public Date getPreviousDate() {
	 	 return previousDate; 
	}
	/**
	 * Setter of previousDate
	 */
	public void setPreviousDate(Date previousDate) { 
		 this.previousDate = previousDate; 
	}
	/**
	 * 
	 * @param cr 
	 * @param prFun 
	 * @param prDate 
	 */
	public void MetricsRecord(ChangeRecord cr, Integer prFun, Date prDate) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @return 
	 */
	public Integer getTotalNumber() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public Double getGrowthRate() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public Double getComplexity() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 * @return 
	 */
	public Double getTaskRate() { 
		// TODO Auto-generated method
		return null;
	 }
	/**
	 * 
	 */
	private Double getTimeSinceLastRelease() { 
		// TODO Auto-generated method
		return null;
	 } 

}
