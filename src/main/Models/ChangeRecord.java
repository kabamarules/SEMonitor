package Models;

import java.util.Date;

public class ChangeRecord {

	/**
	 *  Holds the additions of the release
	 */
	private int additions;
	/**
	 *  Holds the deletions of the release
	 */
	private int deletions;
	/**
	 * Holds the changes of the release
	 */
	private int changes;
	
	/**
	 * Holds the date of the  changes
	 */
	private Date date;
	
	/**
	 *
	 * @return additions 
	 */
	public int getAdditions() {
	 	 return additions; 
	}
	/**
	 * Setter of additions
	 */
	public void setAdditions(int additions) { 
		 this.additions = additions; 
	}
	/**
	 * 
	 * @return deletions
	 */
	public int getDeletions() {
	 	 return deletions; 
	}
	/**
	 * Setter of deletions
	 */
	public void setDeletions(int deletions) { 
		 this.deletions = deletions; 
	}
	/**
	 * Getter of changes
	 */
	public int getChanges() {
	 	 return changes; 
	}
	/**
	 * Setter of changes
	 */
	public void setChanges(int changes) { 
		 this.changes = changes; 
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Add/Del/Chgs: " + additions + "," + deletions + "," + changes;
	}
	
	/**
	 * 
	 * @param additions 
	 * @param del 
	 * @param chg 
	 */
	public ChangeRecord(int add, int del, int chg, Date dt) { 
		this.additions = add;
		this.deletions = del;
		this.changes = chg;
		this.date = dt;
	 }
}
