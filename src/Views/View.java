package Views;


import Presenter.Presenter;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.CardLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextPane;

import java.awt.FlowLayout;

import javax.swing.JRadioButton;

import java.awt.SystemColor;

public abstract class View extends JPanel {

	private Presenter callbackPresenter;

	/**
	 * Getter of callbackPresenter
	 */
	public Presenter getCallbackPresenter() {
	 	 return callbackPresenter; 
	}

	/**
	 * Setter of callbackPresenter
	 */
	public void setCallbackPresenter(Presenter callbackPresenter) { 
		 this.callbackPresenter = callbackPresenter; 
	}

	/**
	 * 
	 * @param callbackPresenter 
	 */
	public View(Presenter callbackPresenter) { 
		 this.callbackPresenter = callbackPresenter; 
	 }

	/**
	 * Redraws the view with the updated data
	 */
	abstract public void redraw();

}
