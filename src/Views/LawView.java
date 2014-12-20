package Views;

import java.util.List;

public class LawView extends View {

	/**
	 * 
	 */
	private Integer lawNumber;
	/**
	 * 
	 */
	private List<Double> graphData;
	/**
	 * 
	 */
	private static List<String> lawExplanations;
	/**
	 * Getter of lawNumber
	 */
	public Integer getLawNumber() {
	 	 return lawNumber; 
	}
	/**
	 * Setter of lawNumber
	 */
	public void setLawNumber(Integer lawNumber) { 
		 this.lawNumber = lawNumber; 
	}
	/**
	 * Getter of graphData
	 */
	public List<Double> getGraphData() {
	 	 return graphData; 
	}
	/**
	 * Setter of graphData
	 */
	public void setGraphData(List<Double> graphData) { 
		 this.graphData = graphData; 
	}
	/**
	 * Getter of lawExplanations
	 */
	public List<String> getLawExplanations() {
	 	 return lawExplanations; 
	}
	/**
	 * Setter of lawExplanations
	 */
	public void setLawExplanations(List<String> lawExplanations) { 
		 this.lawExplanations = lawExplanations; 
	}
	public void setLawData(Integer lawNum, Boolean valid, String com, List<Double> graphData) { 
		// TODO Auto-generated method
	 } 

}
