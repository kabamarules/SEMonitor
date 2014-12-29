package Presenter;

import Models.ReleaseHistory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Views.MainView;
import Views.LawView;
import IO.Grapher;
import IO.RHParser;
import IO.ReportGenerator;

@SuppressWarnings("deprecation")
public class Presenter{

	/** 
	 * Main window frame to hold the views
	 */
	private JFrame frmSEMonitor;

	private List<ReleaseHistory> releaseHistories;
	private int selectedRH; // Starting at 0
	private int selectedLaw; // Starting at 0
	private MainView mainView;
	private LawView lawView;
	
	public List<ReleaseHistory> getReleaseHistories() {
	 	 return releaseHistories; 
	}
	
	public void setSelectedRH(int selectedRH) { 
		 this.selectedRH = selectedRH; 
	}
	
	public void setSelectedLaw(int selectedLaw) { 
		 this.selectedLaw = selectedLaw; 
	}
	
	/**
	 * Main view callback function for opening a new file and 
	 * adding a new release history to the list
	 */
	public void createNewRH() { 
		JFileChooser c = new JFileChooser();
		c.setFileSelectionMode(JFileChooser.FILES_ONLY);  
	    int rVal = c.showOpenDialog(mainView);
	      
	    if (rVal == JFileChooser.APPROVE_OPTION) {
	    	String fname = c.getSelectedFile().getAbsolutePath();
	    	try {
	    		ReleaseHistory rh = RHParser.getReleaseHistory(fname);
	    		releaseHistories.add(rh);
	    		mainView.addRH(rh.getName());
			} catch (Exception e) {
				infoBox("Error", "Wrong file format.");
				e.printStackTrace();
			}
	    } else {
			infoBox("Error", "Please choose another file.");
	    }
	 }

	/**
	 * Main view callback that opens the law view for the
	 * selected release history and the given law.
	 * @param lawIndex
	 */
	public void evaluateLaw(int lawIndex) {
		if (releaseHistories.size() == 0) {
			infoBox("Error", "Please add at least one release history to the list.");
			return;
		}
		if (selectedRH < 0) {
			infoBox("Error", "Please select a system's release history.");
			return;
		}
		setSelectedLaw(lawIndex);
		
		lawView.setLawNumber(lawIndex);
		ReleaseHistory rh = releaseHistories.get(selectedRH);
		lawView.setValidity(rh.getLawValidity(selectedLaw));
		lawView.setComment(rh.getLawComment(selectedLaw));
		lawView.setGraphs(Grapher.getLawGraphs(rh, selectedLaw));
		lawView.redraw();
		
		mainView.hide();
		lawView.show();
	}
	
	public void createReport() { 
		JFileChooser c = new JFileChooser();
		c.setFileSelectionMode(JFileChooser.FILES_ONLY);  

	    int rVal = c.showSaveDialog(mainView);
	    
	    if (rVal == JFileChooser.APPROVE_OPTION) {
	    	String fname = c.getSelectedFile().getAbsolutePath();
	    	
	    	try {
	    		ReleaseHistory rh = releaseHistories.get(selectedRH);
	    		ReportGenerator.saveReport(rh, fname);
			} catch (Exception e) {
				infoBox("Error", "Couldn't save the report.");
				e.printStackTrace();
			}
	    } else {
			infoBox("Error", "Please choose another file.");
	    }
	}

	/**
	 * Law view callback function. Saving evaluation and comment for law.
	 * @param validity
	 * @param comment
	 */
	public void saveLawEvaluation(Boolean validity, String comment) { 
		releaseHistories.get(selectedRH).setLawEvaluation(selectedLaw, validity, comment);
	}
	
	/**
	 * Law view callback to get back to main menu.
	 */
	public void gotoBackToMainView() { 
		mainView.show();
		lawView.hide();
	}
	
	/**
	 * Create the main window.
	 */
	public Presenter() {
		releaseHistories = new ArrayList<ReleaseHistory>();
		selectedRH = -1;
		selectedLaw = -1;
		
		initializeFrame();
		lawView = new LawView(this);
		frmSEMonitor.getContentPane().add(lawView);
		lawView.hide();
		
		mainView = new MainView(this);
		frmSEMonitor.getContentPane().add(mainView);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeFrame() {
		frmSEMonitor = new JFrame();
		frmSEMonitor.setTitle("Software Evolution Monitor Tool");
		frmSEMonitor.setSize(new Dimension(640, 557));
		frmSEMonitor.setResizable(false);
		frmSEMonitor.getContentPane().setBackground(new Color(0, 0, 64));
		frmSEMonitor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSEMonitor.getContentPane().setLayout(null);
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Presenter window = new Presenter();
					window.frmSEMonitor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void infoBox(String label, String message)
    {
        JOptionPane.showMessageDialog(null, message, label, JOptionPane.INFORMATION_MESSAGE);
    }
}
