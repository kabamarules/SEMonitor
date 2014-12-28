package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;

import Presenter.Presenter;

@SuppressWarnings("serial")
public class LawView extends View implements ActionListener {
	
	/**
	 * Interactive elements we need to read or change after initialization 
	 */
	private JLabel lblLawName;
	private JTextPane txtLawDescription;
	// User input
	private JRadioButton radioBtnLawTrue;
	private JRadioButton radioBtnLawFalse;
	private JTextPane txtUserComments;


	/**
	 * The number of the selected law
	 */
	private int lawNumber;
	
	/**
	 * The graph data to be presented
	 */
	private List<List<Double>> graphData;
	
	/**
	 * The previous validity and comment if existing
	 */
 	private boolean validity;
 	private String comment;
 	
	/**
	 * A static list containing the explanation of the laws
	 */
	private static String[] lawDescriptions = {
		"Ο νόμος ισχύει αν\ra. σε κάθε έκδοση του λογισμικού υπάρχουν αλλαγές " 	// Law 1
		+ "στις λειτουργίες ή στις δομές δεδομένων του εργαλείου και\rb. κάθε "
		+ "χρόνο υπάρχει τουλάχιστον μια έκδοση του λογισμικού.»\r",
		"Ο νόμος ισχύει αν\ra. η πολυπλοκότητα των λειτουργιών ή των δομών " 	// Law 2
		+ "δεδομένων τείνει να αυξάνεται ή\rβ. η πολυπλοκότητα των λειτουργιών "
		+ "και των δομών δεδομένων δεν έχει αυξητική τάση και επιπλέον στο "
		+ "ραβδόγραμμα υπάρχουν εμφανείς δραστηριότητες συντήρησης.",
		"Ο νόμος ισχύει αν η εξέλιξη γίνεται με οργανωμένο συστηματικό τρόπο ο "
		+ "οποίος αντικατοπτρίζεται στην ύπαρξη επαναλαμβανόμενων μοτίβων στα "
		+ "ραβδογράμματα. Τα μοτίβα αυτά συνήθως έχουν την μορφή κυματισμών " // Law 3
		+ "(spikes) οι κορυφές (peaks) των οποίων αντιστοιχούν σε εκδόσεις "
		+ "στις οποίες κυριαρχεί η θετική ανατροφοδότηση που οδηγεί στην αύξηση "
		+ "των λειτουργιών. Οι κοιλάδες (valleys) που ακολουθούν αντιστοιχούν "
		+ "σε εκδόσεις με μικρή, μηδενική ή μείωση των λειτουργιών.",
		"Ο νόμος ισχύει αν αν ο ρυθμός εργασιών των λειτουργιών και "			// Law 4
		+ "των δομών δεδομένων τείνει να είναι σταθερός.",
		"Ο νόμος ισχύει αν αν και στα δυο γραφήματα εκδόσεις με μεγάλη "			// Law 5
		+ "αύξηση ακολουθούνται από εκδόσεις με μικρότερη, μηδενική ή"
		+ " αρνητική αύξηση.",
		"Ο νόμος ισχύει αν αν και στα δυο γραφήματα παρατηρείται "				// Law 6
		+ "συνεχής αύξηση.",
		"Ο νόμος βασίζεται στη αποτίμηση του 2ου και 6ου νόμου.",				// Law 7
		"Ο νόμος ισχύει αν το πλήθος των λειτουργιών μιας μελλοντικής έκδοσης "	// Law 8
		+ "του συστήματος μπορεί να προβλεφτεί με ακρίβεια με βάση μια "
		+ "ανατροφοδοτούμενη φόρμουλα η οποία λαμβάνει υπόψη της το πλήθος "
		+ "των λειτουργιών του συστήματος σε προηγούμενες εκδόσεις."
	};
	
	public void setLawNumber(int n) { 
		 lawNumber = n; 
	}
	
	public void setGraphData(List<List<Double>> gd) { 
		 graphData = gd;
	}
	
	public void setValidity(boolean v) {
		validity = v;
	}
	
	public void setComment(String c) {
		comment = c;
	}
	
	/**
	 * Updates all the components of the view with the values of the variables.
	 */
	@Override
	public void redraw() {
		lblLawName.setText( (lawNumber + 1) + "ος Νόμος");
		txtLawDescription.setText(lawDescriptions[lawNumber]);
		selectRadioButton(validity);
		txtUserComments.setText(comment);
	} 

	private void selectRadioButton(boolean validity) {
		if (validity) 
			radioBtnLawTrue.setSelected(true);
		else
			radioBtnLawFalse.setSelected(true);
	}
	
	public LawView(Presenter callbackPresenter) {
		super(callbackPresenter);
		initializeView();
	}
	
	/**
	 * Called when a button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "saveEvaluation":
				boolean validity = radioBtnLawTrue.isSelected();
				String comment = txtUserComments.getText();
				callbackPresenter.saveLawEvaluation(validity, comment);
			case "goBack":
				callbackPresenter.gotoBackToMainView();
				break;
            default: 
            	Presenter.infoBox("Triggered Action", e.getActionCommand());
		}
	}
	
	private void initializeView() {
		setBounds(10, 10, 620, 500);
		setLayout(null);
		
		lblLawName = new JLabel("Xος Νόμος");
		lblLawName.setBounds(237, 6, 99, 22);
		lblLawName.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblLawName.setBackground(new Color(238, 238, 238));
		add(lblLawName);
		
		txtLawDescription = new JTextPane();
		txtLawDescription.setEditable(false);
		txtLawDescription.setBackground(SystemColor.window);
		txtLawDescription.setBounds(313, 88, 265, 168);
		txtLawDescription.setText("");
		add(txtLawDescription);
		
		JLabel lblLawDescription = new JLabel("Περιγραφή ισχύος του νόμου:");
		lblLawDescription.setBounds(313, 60, 204, 16);
		add(lblLawDescription);
		
		radioBtnLawFalse = new JRadioButton("Δεν ισχύει");
		radioBtnLawFalse.setBounds(430, 268, 99, 23);
		add(radioBtnLawFalse);
		
		radioBtnLawTrue = new JRadioButton("Ισχύει");
		radioBtnLawTrue.setSelected(true);
		radioBtnLawTrue.setBounds(322, 268, 107, 23);
		add(radioBtnLawTrue);
		
		ButtonGroup group = new ButtonGroup();
	    group.add(radioBtnLawTrue);
	    group.add(radioBtnLawFalse);
	    
		txtUserComments = new JTextPane();
		txtUserComments.setBackground(Color.WHITE);
		txtUserComments.setBounds(312, 339, 265, 114);
		add(txtUserComments);
		
		JLabel lblUserComments = new JLabel("Σχόλια & παρατηρήσεις χρήστη:");
		lblUserComments.setBounds(312, 315, 230, 16);
		add(lblUserComments);
		
		JButton btnApotimisi = new JButton("Αποτίμηση Νόμου");
		btnApotimisi.setBounds(312, 465, 152, 29);
		btnApotimisi.setActionCommand("saveEvaluation");
		add(btnApotimisi);
		
		JButton btnBack = new JButton("Επιστροφή");
		btnBack.setBounds(461, 465, 117, 29);
		btnBack.setActionCommand("goBack");
		add(btnBack);
		
		btnBack.addActionListener(this);
		btnApotimisi.addActionListener(this);

	}
}
