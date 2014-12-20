package Models;

public class ChangeRecord {

	/**
	 * 
	 */
	private Integer additions;
	/**
	 * 
	 */
	private Integer deletions;
	/**
	 * 
	 */
	private Integer changes;
	/**
	 * 
	 * @return 
	 */
	public Integer getAdditions() {
	 	 return additions; 
	}
	/**
	 * Setter of additions
	 */
	public void setAdditions(Integer additions) { 
		 this.additions = additions; 
	}
	/**
	 * 
	 * @return 
	 */
	public Integer getDeletions() {
	 	 return deletions; 
	}
	/**
	 * Setter of deletions
	 */
	public void setDeletions(Integer deletions) { 
		 this.deletions = deletions; 
	}
	/**
	 * Getter of changes
	 */
	public Integer getChanges() {
	 	 return changes; 
	}
	/**
	 * Setter of changes
	 */
	public void setChanges(Integer changes) { 
		 this.changes = changes; 
	}
	/**
	 * 
	 * @param additions 
	 * @param del 
	 * @param chg 
	 */
	public void ChangeRecord(Integer additions, Integer del, Integer chg) { 
		// TODO Auto-generated method
	 }


}
