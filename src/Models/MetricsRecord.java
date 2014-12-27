package Models;

import java.util.Date;

public class MetricsRecord {

	/**
	 * A data structure that holds the changes of the release
	 */
	private ChangeRecord changeRecord;
	/**
	 * The previous total of the changes
	 */
	private int previousTotal;
	/**
	 * The previous release date
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
	public int getPreviousTotal() {
	 	 return previousTotal; 
	}
	/**
	 * Setter of previousTotal
	 */
	public void setPreviousTotal(int previousTotal) { 
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
	 * Return the total number of changes up to now
	 * @return 
	 */
	public int getTotalNumber() { 
		return previousTotal + changeRecord.getAdditions() - changeRecord.getDeletions();
	 }
	
	/**
	 * Returns the growth rate of changes for the current release
	 * @return 
	 */
	public int getGrowthRate() { 
		return changeRecord.getAdditions() - changeRecord.getDeletions();
	 }
	
	/**
	 * Returns the complexity of the current release
	 * @return 
	 */
	public double getComplexity() { 
		return ((double)changeRecord.getChanges() + (double)changeRecord.getDeletions())/(double)changeRecord.getAdditions();
	 }
	
	/**
	 * Returns the task rate of the current release
	 * @return 
	 */
	public double getTaskRate() { 
		double allChanges = (double)(changeRecord.getChanges() + changeRecord.getDeletions() + changeRecord.getAdditions());
		return allChanges / getTimeSinceLastRelease();
	 }
	
	/**
	 * Returns the elapsed time in days since the last release
	 */
	private double getTimeSinceLastRelease() { 
        double diff = previousDate.getTime() - changeRecord.getDate().getTime();
        return diff / 1000.0 / 60.0 / 60.0 / 24.0;
	 } 
	
	@Override
	public String toString() {
		return "Total/Growth/Compl/TaskRate: " + getTotalNumber() + "," + getGrowthRate() + "," + getComplexity() +
				"," + getTaskRate();
	}

	/**
	 * Constructor
	 * @param cr ChangeRecord
	 * @param prFun Previous total of changes
	 * @param prDate Previous date
	 */
	public MetricsRecord(ChangeRecord cr, int prTot, Date prDate) { 
		this.changeRecord = cr;
		this.previousTotal = prTot;
		this.previousDate = prDate;
	 }
}
