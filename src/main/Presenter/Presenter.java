package Presenter;

import Models.ReleaseHistory;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Views.MainView;
import Views.LawView;
import IO.RHParser;

public class Presenter {

	/** 
	 * Main window frame to hold the views
	 */
	private JFrame frmSEMonitor;

	/**
	 * 
	 */
	private List<ReleaseHistory> releaseHistories;
	/**
	 * 
	 */
	private Integer selectedRH;
	/**
	 * 
	 */
	private Integer selectedLaw;
	/**
	 * 
	 */
	private MainView mainView;
	/**
	 * 
	 */
	private LawView lawView;
	/**
	 * 
	 */
	private RHParser inputParser;
	/**
	 * Getter of releaseHistories
	 */
	public List<ReleaseHistory> getReleaseHistories() {
	 	 return releaseHistories; 
	}
	/**
	 * Setter of releaseHistories
	 */
	public void setReleaseHistories(List<ReleaseHistory> releaseHistories) { 
		 this.releaseHistories = releaseHistories; 
	}
	/**
	 * Getter of selectedRH
	 */
	public Integer getSelectedRH() {
	 	 return selectedRH; 
	}
	/**
	 * Setter of selectedRH
	 */
	public void setSelectedRH(Integer selectedRH) { 
		 this.selectedRH = selectedRH; 
	}
	/**
	 * Getter of selectedLaw
	 */
	public Integer getSelectedLaw() {
	 	 return selectedLaw; 
	}
	/**
	 * Setter of selectedLaw
	 */
	public void setSelectedLaw(Integer selectedLaw) { 
		 this.selectedLaw = selectedLaw; 
	}
	/**
	 * Getter of mainView
	 */
	public MainView getMainView() {
	 	 return mainView; 
	}
	/**
	 * Setter of mainView
	 */
	public void setMainView(MainView mainView) { 
		 this.mainView = mainView; 
	}
	/**
	 * Getter of lawView
	 */
	public LawView getLawView() {
	 	 return lawView; 
	}
	/**
	 * Setter of lawView
	 */
	public void setLawView(LawView lawView) { 
		 this.lawView = lawView; 
	}
	/**
	 * Getter of inputParser
	 */
	public RHParser getInputParser() {
	 	 return inputParser; 
	}
	/**
	 * Setter of inputParser
	 */
	public void setInputParser(RHParser inputParser) { 
		 this.inputParser = inputParser; 
	}
	/**
	 * 
	 * @param filename 
	 */
	public void createNewHistory(String filename) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param filename 
	 */
	public void createReport(String filename) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param lawIndex 
	 */
	public void showLawView(Integer lawIndex) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 */
	public void showMainView() { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param filename 
	 */
	public void saveReport(String filename) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param validity 
	 * @param comment 
	 */
	public void saveLawEvaluation(Boolean validity, String comment) { 
		// TODO Auto-generated method
	 }
	/**
	 * 
	 * @param rhIndex 
	 */
	public void selectRH(Integer rhIndex) { 
		// TODO Auto-generated method
	 } 
	
	/**
	 * Create the main window.
	 */
	public Presenter() {
		initializeFrame();
		lawView = new LawView(this);
		frmSEMonitor.getContentPane().add(lawView);
		lawView.hide();
		
		mainView = new MainView(this);
		frmSEMonitor.getContentPane().add(mainView);
		//mainView.show();
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

}
