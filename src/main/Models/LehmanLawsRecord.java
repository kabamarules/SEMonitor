package Models;

public class LehmanLawsRecord {

	/**
	 * Holds the validity of the law
	 */
	private boolean validity;
	
	/**
	 * Holds the comment for the law
	 */
	private String comment;

	/**
	 * Validity getter
	 */
	public boolean getValidity() {
	 	 return validity; 
	}
	
	/**
	 * Validity setter
	 */
	public void setValidity(boolean validity) { 
		 this.validity = validity; 
	}
	
	/**
	 * Comment getter
	 */
	public String getComment() {
	 	 return comment; 
	}
	
	/**
	 * Comment setter
	 */
	public void setComment(String comment) { 
		 this.comment = comment; 
	}

	/**
	 * Constructor
	 * @param validity 
	 * @param comment 
	 */
	public LehmanLawsRecord(boolean validity, String comment) { 
		this.validity = validity;
		this.comment = comment;
	 } 

}
