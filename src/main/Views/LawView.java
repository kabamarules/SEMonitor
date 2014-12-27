package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import Presenter.Presenter;

public class LawView extends View {
	
	/**
	 * The number of the selected law
	 */
	private Integer lawNumber;
	
	/**
	 * The graph data to be presented
	 */
	private List<Double> graphData;
	
	/**
	 * A static list containing the explanation of the laws
	 */
	@SuppressWarnings("serial")
	private static List<String> lawExplanations = new ArrayList<String>() {{
	    add("law 1 expl");
	    add("law 2 expl");
	    add("law 3 expl");
	}};

	
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
	 * Setter of graphData
	 */
	public void setGraphData(List<Double> graphData) { 
		 this.graphData = graphData; 
	}

	/**
	 * Setter of lawExplanations
	 */
	public void setLawExplanations(List<String> lawExplanations) { 
		 LawView.lawExplanations = lawExplanations; 
	}
	
	public void setLawData(Integer lawNum, Boolean valid, String com, List<Double> graphData) { 
		// TODO Auto-generated method
	 }
	
	@Override
	public void redraw() {
		// TODO Auto-generated method stub
		
	} 

	public LawView(Presenter callbackPresenter) {
		super(callbackPresenter);
		initializeView();
	}
	
	private void initializeView() {
		setBounds(10, 10, 620, 440);
		setLayout(null);
		
		JLabel lblLawName = new JLabel("1ος Νόμος");
		lblLawName.setBounds(237, 6, 99, 22);
		lblLawName.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblLawName.setBackground(new Color(238, 238, 238));
		add(lblLawName);
		
		JTextPane txtLawDescription = new JTextPane();
		txtLawDescription.setEditable(false);
		txtLawDescription.setBackground(SystemColor.window);
		txtLawDescription.setBounds(313, 88, 265, 114);
		txtLawDescription.setText("Ο νόμος ισχύει αν\ra. σε κάθε έκδοση του λογισμικού υπάρχουν αλλαγές στις λειτουργίες ή στις δομές δεδομένων του εργαλείου και\rb. κάθε χρόνο υπάρχει τουλάχιστον μια έκδοση του λογισμικού.»\r");
		add(txtLawDescription);
		
		JLabel lblLawDescription = new JLabel("Περιγραφή ισχύος του νόμου:");
		lblLawDescription.setBounds(313, 60, 204, 16);
		add(lblLawDescription);
		
		JRadioButton radioBtnLawFalse = new JRadioButton("Δεν ισχύει");
		radioBtnLawFalse.setBounds(431, 203, 99, 23);
		add(radioBtnLawFalse);
		
		JRadioButton radioBtnLawTrue = new JRadioButton("Ισχύει");
		radioBtnLawTrue.setSelected(true);
		radioBtnLawTrue.setBounds(323, 203, 107, 23);
		add(radioBtnLawTrue);
		
		JTextPane txtUserComments = new JTextPane();
		txtUserComments.setBackground(Color.WHITE);
		txtUserComments.setBounds(313, 274, 265, 114);
		add(txtUserComments);
		
		JLabel lblUserComments = new JLabel("Σχόλια & παρατηρήσεις χρήστη:");
		lblUserComments.setBounds(313, 250, 230, 16);
		add(lblUserComments);
		
		JButton btnApotimisi = new JButton("Αποτίμηση Νόμου");
		btnApotimisi.setBounds(313, 400, 152, 29);
		btnApotimisi.setActionCommand("saveEvaluation");
		add(btnApotimisi);
		
		JButton btnBack = new JButton("Επιστροφή");
		btnBack.setBounds(462, 400, 117, 29);
		btnBack.setActionCommand("goBack");
		add(btnBack);
		
		btnBack.addActionListener(callbackPresenter);
		btnApotimisi.addActionListener(callbackPresenter);

	}
}
