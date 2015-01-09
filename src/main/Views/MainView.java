package Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Models.ReleaseHistory;
import Presenter.Presenter;

@SuppressWarnings("serial")
public class MainView extends View implements ActionListener, ListSelectionListener{

	/**
	 * The list of the Release Histories
	 */
	@SuppressWarnings("rawtypes")
	private JList SoftwareToolsList;
	
	/**
	 * The names list of the loaded software systems data 
	 */
	@SuppressWarnings("rawtypes")
	private DefaultListModel rhNames;

	private JCheckBox[] checkBoxes;
	
	@SuppressWarnings("unchecked")
	public void addRH(String name) { 
		 rhNames.addElement(name);
	}

	@Override
	public void redraw() {
		// TODO implement redrawing the ticking boxes
	} 

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MainView(Presenter callbackPresenter) {
		super(callbackPresenter);
		rhNames = new DefaultListModel();
		SoftwareToolsList = new JList(rhNames);
		
		checkBoxes = new JCheckBox[8];
		initializeView();
	}
	
	/**
	 * Called when a button is pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "newRH":
				callbackPresenter.createNewRH();
				break;
			case "law1":
				callbackPresenter.evaluateLaw(ReleaseHistory.LAW_1);
				break;
			case "law2":
				callbackPresenter.evaluateLaw(ReleaseHistory.LAW_2);
				break;
			case "law3":
				callbackPresenter.evaluateLaw(ReleaseHistory.LAW_3);
				break;
			case "law4":
				callbackPresenter.evaluateLaw(ReleaseHistory.LAW_4);
				break;
			case "law5":
				callbackPresenter.evaluateLaw(ReleaseHistory.LAW_5);
				break;
			case "law6":
				callbackPresenter.evaluateLaw(ReleaseHistory.LAW_6);
				break;
			case "law7":
				callbackPresenter.evaluateLaw(ReleaseHistory.LAW_7);
				break;
			case "law8":
				callbackPresenter.evaluateLaw(ReleaseHistory.LAW_8);
				break;
			case "createReport":
				callbackPresenter.createReport();
				break;
		}
	}
	
	/** 
	 * Called when a Release History is selected from the list
	 */
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getValueIsAdjusting() == false) {
			callbackPresenter.setSelectedRH(SoftwareToolsList.getSelectedIndex());
		}
	}
	
	private void initializeView() {
		setBounds(5, 5, 630, 525);
		setLayout(null);
		
		JPanel MainButtonsPanel = new JPanel();
		MainButtonsPanel.setBackground(new Color(230, 230, 250));
		MainButtonsPanel.setBounds(314, 34, 272, 446);
		add(MainButtonsPanel);
		MainButtonsPanel.setLayout(null);
		
		JButton btnLaw1 = new JButton("Law No. 1");
		btnLaw1.setBounds(36, 46, 112, 29);
		MainButtonsPanel.add(btnLaw1);
		btnLaw1.setActionCommand("law1");
		
		JButton btnLaw2 = new JButton("Law No. 2");
		btnLaw2.setBounds(36, 87, 112, 29);
		MainButtonsPanel.add(btnLaw2);
		btnLaw2.setActionCommand("law2");
		
		JButton btnLaw3 = new JButton("Law No. 3");
		btnLaw3.setBounds(36, 128, 112, 29);
		MainButtonsPanel.add(btnLaw3);
		btnLaw3.setActionCommand("law3");
		
		JButton btnLaw4 = new JButton("Law No. 4");
		btnLaw4.setBounds(36, 169, 112, 29);
		MainButtonsPanel.add(btnLaw4);
		btnLaw4.setFocusPainted(false);
		btnLaw4.setActionCommand("law4");
		
		JButton btnLaw5 = new JButton("Law No. 5");
		btnLaw5.setBounds(36, 210, 112, 29);
		MainButtonsPanel.add(btnLaw5);
		btnLaw5.setActionCommand("law5");
		
		JButton btnLaw6 = new JButton("Law No. 6");
		btnLaw6.setBounds(36, 251, 112, 29);
		MainButtonsPanel.add(btnLaw6);
		btnLaw6.setActionCommand("law6");
		
		JButton btnLaw7 = new JButton("Law No. 7");
		btnLaw7.setBounds(36, 292, 112, 29);
		MainButtonsPanel.add(btnLaw7);
		btnLaw7.setActionCommand("law7");
		
		JButton btnLaw8 = new JButton("Law No. 8");
		btnLaw8.setBounds(36, 333, 112, 29);
		btnLaw8.setActionCommand("law8");
		MainButtonsPanel.add(btnLaw8);
		
		JButton btnReport = new JButton("Create Report");
		btnReport.setBounds(0, 411, 272, 29);
		MainButtonsPanel.add(btnReport);
		btnReport.setActionCommand("createReport");
		
		JLabel lblApotimisi = new JLabel("Evaluation of Lehman's Laws");
		lblApotimisi.setHorizontalAlignment(SwingConstants.CENTER);
		lblApotimisi.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblApotimisi.setBounds(0, 0, 272, 34);
		MainButtonsPanel.add(lblApotimisi);
		lblApotimisi.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		for (int i = 0; i < checkBoxes.length; i++) {
			checkBoxes[i] = new JCheckBox("");
			MainButtonsPanel.add(checkBoxes[i]);
			checkBoxes[i].setEnabled(false);
		}

		checkBoxes[0].setBounds(160, 46, 28, 23);
		checkBoxes[1].setBounds(160, 87, 28, 23);
		checkBoxes[2].setBounds(160, 128, 28, 23);
		checkBoxes[3].setBounds(160, 169, 28, 23);
		checkBoxes[4].setBounds(160, 210, 28, 23);
		checkBoxes[5].setBounds(160, 251, 28, 23);
		checkBoxes[6].setBounds(160, 292, 28, 23);
		checkBoxes[7].setBounds(160, 333, 28, 23);
		
		JScrollPane SoftwareToolsListScrollPane = new JScrollPane();
		SoftwareToolsListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		SoftwareToolsListScrollPane.setBounds(26, 74, 222, 365);
	
		SoftwareToolsList.setVisibleRowCount(100);
		SoftwareToolsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		SoftwareToolsListScrollPane.setColumnHeaderView(SoftwareToolsList);
		add(SoftwareToolsListScrollPane);

		JLabel lblSystems = new JLabel("Histories of Soft. Systems");
		lblSystems.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystems.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSystems.setAlignmentX(0.5f);
		lblSystems.setBounds(26, 34, 222, 34);
		add(lblSystems);
		
		JButton btnNewSystem = new JButton("Load new history");
		btnNewSystem.setFocusPainted(false);
		btnNewSystem.setActionCommand("newRH");
		btnNewSystem.setBounds(25, 445, 225, 29);
		add(btnNewSystem);
		
		btnNewSystem.addActionListener(this);
		btnLaw1.addActionListener(this);
		btnLaw2.addActionListener(this);
		btnLaw3.addActionListener(this);
		btnLaw4.addActionListener(this);
		btnLaw5.addActionListener(this);
		btnLaw6.addActionListener(this);
		btnLaw7.addActionListener(this);
		btnLaw8.addActionListener(this);
		btnReport.addActionListener(this);
		SoftwareToolsList.addListSelectionListener(this);
	}
}
