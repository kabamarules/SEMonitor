package Presenter;

import Models.ReleaseHistory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Views.MainView;
import Views.LawView;
import IO.RHParser;

public class Presenter implements ActionListener, ListSelectionListener{

	/** 
	 * Main window frame to hold the views
	 */
	private JFrame frmSEMonitor;

	private List<ReleaseHistory> releaseHistories;
	private int selectedRH;
	private int selectedLaw;
	private MainView mainView;
	private LawView lawView;
	
	public List<ReleaseHistory> getReleaseHistories() {
	 	 return releaseHistories; 
	}
	
	public void setReleaseHistories(List<ReleaseHistory> releaseHistories) { 
		 this.releaseHistories = releaseHistories; 
	}
	
	public Integer getSelectedRH() {
	 	 return selectedRH; 
	}
	
	public void setSelectedRH(Integer selectedRH) { 
		 this.selectedRH = selectedRH; 
	}
	
	public Integer getSelectedLaw() {
	 	 return selectedLaw; 
	}
	
	public void setSelectedLaw(Integer selectedLaw) { 
		 this.selectedLaw = selectedLaw; 
	}

	void createNewRH() { 
	      JFileChooser c = new JFileChooser();
	      int rVal = c.showOpenDialog(mainView);
	      
	      if (rVal == JFileChooser.APPROVE_OPTION) {
	    	  String file = c.getSelectedFile().getAbsolutePath();
	    	  
	    	  try {
				ReleaseHistory rh = RHParser.getReleaseHistory(file);
				releaseHistories.add(rh);
				mainView.addRH(rh.getName());
				mainView.redraw();
			} catch (Exception e) {
				infoBox("Error", "Could not parse the file.");
				e.printStackTrace();
			}
	      }
	 }

	public void createReport(String filename) { 
		// TODO Auto-generated method
	 }

	public void showLawView(int lawIndex) { 
		// TODO Auto-generated method
	 }

	public void showMainView() { 
		// TODO Auto-generated method
	 }

	public void saveReport(String filename) { 
		// TODO Auto-generated method
	 }

	public void saveLawEvaluation(Boolean validity, String comment) { 
		// TODO Auto-generated method
	 }


	public void selectRH(Integer rhIndex) { 
		// TODO Auto-generated method
	 } 
	
	/**
	 * Create the main window.
	 */
	public Presenter() {
		releaseHistories = new ArrayList<ReleaseHistory>();
		
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
		frmSEMonitor.setSize(new Dimension(640, 480));
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
	
	/**
	 * Called when a button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "newRH":
				createNewRH();
				break;
			case "law1":
				selectedLaw = 1;
				break;
			default: 
				infoBox("Triggered Action", e.getActionCommand());
		}
	}
	
	/** 
	 * Called when a Release History is selected from the list
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {
			selectedRH = e.getLastIndex();
		}
	}
	
	public static void infoBox(String label, String message)
    {
        JOptionPane.showMessageDialog(null, message, label, JOptionPane.INFORMATION_MESSAGE);
    }
}
