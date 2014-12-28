package Models;

import java.util.Date;

public class MetricsRecord {

	/**
	 * A data structure that holds the changes of the release
	 */
	private ChangeRecord changeRecord;

	private int previousTotal;
	private Date previousDate;
	
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
	
	public ChangeRecord getChangeRecord() {
	 	 return changeRecord; 
	}

	public int getPreviousTotal() {
	 	 return previousTotal; 
	}

	public Date getPreviousDate() {
	 	 return previousDate; 
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
	 * If the additions are zero it divides by 1.
	 * @return 
	 */
	public double getComplexity() { 
		double divider = changeRecord.getAdditions() > 0 ? (double)changeRecord.getAdditions() : 1;
		return ((double)changeRecord.getChanges() + (double)changeRecord.getDeletions()) / divider;
	 }
	
	/**
	 * Returns the task rate of the current release
	 * If the elapsed time is 0 returns zero
	 * @return 
	 */
	public double getTaskRate() { 
		double allChanges = (double)(changeRecord.getChanges() + changeRecord.getDeletions() + changeRecord.getAdditions());
		return getTimeSinceLastRelease() == 0 ? 0 : allChanges / getTimeSinceLastRelease();
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
}
