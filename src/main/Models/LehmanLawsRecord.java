package Models;

public class LehmanLawsRecord {

	// Constants, we don't like magic numbers
	public final static int LAW_1 = 0;
	public final static int LAW_2 = 1;
	public final static int LAW_3 = 2;
	public final static int LAW_4 = 3;
	public final static int LAW_5 = 4;
	public final static int LAW_6 = 5;
	public final static int LAW_7 = 6;
	public final static int LAW_8 = 7;
	
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
