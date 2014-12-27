package Views;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

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

import Presenter.Presenter;

@SuppressWarnings("serial")
public class MainView extends View {

	/**
	 * The names list of the loaded software systems data 
	 */
	private DefaultListModel rhNames;

	public void addRH(String name) { 
		 rhNames.addElement(name);
	}

	public void setLawsValidity(Boolean validities) { 
		// TODO Auto-generated method
	 }

	@Override
	public void redraw() {
		
	} 

	public MainView(Presenter callbackPresenter) {
		super(callbackPresenter);
		rhNames = new DefaultListModel();
		
		initializeView();
	}
	
	private void initializeView() {
		setBounds(10, 10, 620, 440);
		setLayout(null);
		
		JPanel MainButtonsPanel = new JPanel();
		MainButtonsPanel.setBackground(new Color(230, 230, 250));
		MainButtonsPanel.setBounds(314, 34, 272, 342);
		add(MainButtonsPanel);
		MainButtonsPanel.setLayout(null);
		
		JButton btnLaw1 = new JButton("1ος Νόμος");
		btnLaw1.setBounds(0, 46, 112, 29);
		MainButtonsPanel.add(btnLaw1);
		btnLaw1.setActionCommand("law1");
		
		JButton btnLaw2 = new JButton("2ος Νόμος");
		btnLaw2.setBounds(0, 87, 112, 29);
		MainButtonsPanel.add(btnLaw2);
		btnLaw2.setActionCommand("law2");
		
		JButton btnLaw3 = new JButton("3ος Νόμος");
		btnLaw3.setBounds(0, 128, 112, 29);
		MainButtonsPanel.add(btnLaw3);
		btnLaw3.setActionCommand("law3");
		
		JButton btnLaw4 = new JButton("4ος Νόμος");
		btnLaw4.setBounds(0, 169, 112, 29);
		MainButtonsPanel.add(btnLaw4);
		btnLaw4.setFocusPainted(false);
		btnLaw4.setActionCommand("law4");
		
		JButton btnLaw5 = new JButton("5ος Νόμος");
		btnLaw5.setBounds(135, 46, 112, 29);
		MainButtonsPanel.add(btnLaw5);
		btnLaw5.setActionCommand("law5");
		
		JButton btnLaw6 = new JButton("6ος Νόμος");
		btnLaw6.setBounds(135, 87, 112, 29);
		MainButtonsPanel.add(btnLaw6);
		btnLaw6.setActionCommand("law6");
		
		JButton btnLaw7 = new JButton("7ος Νόμος");
		btnLaw7.setBounds(135, 128, 112, 29);
		MainButtonsPanel.add(btnLaw7);
		btnLaw7.setActionCommand("law7");
		
		JButton btnLaw8 = new JButton("8ος Νόμος");
		btnLaw8.setBounds(135, 169, 112, 29);
		btnLaw7.setActionCommand("law8");
		MainButtonsPanel.add(btnLaw8);
		
		JButton btnReport = new JButton("Δημιουργία Αναφοράς");
		btnReport.setBounds(0, 307, 272, 29);
		MainButtonsPanel.add(btnReport);
		btnReport.setActionCommand("createReport");
		
		JLabel lblApotimisi = new JLabel("Αποτίμηση Νόμων του Lehman");
		lblApotimisi.setHorizontalAlignment(SwingConstants.CENTER);
		lblApotimisi.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblApotimisi.setBounds(0, 0, 272, 34);
		MainButtonsPanel.add(lblApotimisi);
		lblApotimisi.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(106, 46, 28, 23);
		MainButtonsPanel.add(checkBox);
		checkBox.setEnabled(false);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(106, 88, 28, 23);
		MainButtonsPanel.add(checkBox_1);
		checkBox_1.setEnabled(false);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(106, 129, 28, 23);
		MainButtonsPanel.add(checkBox_2);
		checkBox_2.setEnabled(false);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setBounds(106, 170, 28, 23);
		MainButtonsPanel.add(checkBox_3);
		checkBox_3.setEnabled(false);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		checkBox_4.setBounds(244, 46, 28, 23);
		MainButtonsPanel.add(checkBox_4);
		checkBox_4.setEnabled(false);
		
		JCheckBox checkBox_5 = new JCheckBox("");
		checkBox_5.setBounds(244, 88, 28, 23);
		MainButtonsPanel.add(checkBox_5);
		checkBox_5.setEnabled(false);
		
		JCheckBox checkBox_6 = new JCheckBox("");
		checkBox_6.setBounds(244, 128, 28, 23);
		MainButtonsPanel.add(checkBox_6);
		checkBox_6.setEnabled(false);
		
		JCheckBox checkBox_7 = new JCheckBox("");
		checkBox_7.setBounds(244, 169, 28, 23);
		MainButtonsPanel.add(checkBox_7);
		checkBox_7.setEnabled(false);
		
		JScrollPane SoftwareToolsListScrollPane = new JScrollPane();
		SoftwareToolsListScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		SoftwareToolsListScrollPane.setBounds(26, 74, 222, 261);
	
		JList SoftwareToolsList = new JList(rhNames);
		SoftwareToolsList.setVisibleRowCount(100);
		SoftwareToolsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		SoftwareToolsListScrollPane.setColumnHeaderView(SoftwareToolsList);
		add(SoftwareToolsListScrollPane);

		JLabel lblSystems = new JLabel("Ιστορικά Συστημ. Λογ.");
		lblSystems.setHorizontalAlignment(SwingConstants.CENTER);
		lblSystems.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblSystems.setAlignmentX(0.5f);
		lblSystems.setBounds(26, 34, 222, 34);
		add(lblSystems);
		
		JButton btnNewSystem = new JButton("Νέο Ιστορικό");
		btnNewSystem.setFocusPainted(false);
		btnNewSystem.setActionCommand("newRH");
		btnNewSystem.setBounds(23, 347, 225, 29);
		add(btnNewSystem);
		
		btnNewSystem.addActionListener(callbackPresenter);
		btnLaw1.addActionListener(callbackPresenter);
		btnLaw2.addActionListener(callbackPresenter);
		btnLaw3.addActionListener(callbackPresenter);
		btnLaw4.addActionListener(callbackPresenter);
		btnLaw5.addActionListener(callbackPresenter);
		btnLaw6.addActionListener(callbackPresenter);
		btnLaw7.addActionListener(callbackPresenter);
		btnLaw8.addActionListener(callbackPresenter);
		btnReport.addActionListener(callbackPresenter);
		SoftwareToolsList.addListSelectionListener(callbackPresenter);
	}
}
