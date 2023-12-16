package sn.swing.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import sn.swing.utils.Utilitaire;
import javax.swing.border.EtchedBorder;

public class UIList extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTable tableTasks;
	private JTable table;
	public UIList() {
		
		iniCompenents();
	}
	
	
	private void iniCompenents() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Gestion des tâches - version 1.0.2");
		setPreferredSize(new Dimension(500, 325));
		setResizable(false);
		setSize(new Dimension(500, 325));
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(new Color(0, 115, 165));
		panelWest.setPreferredSize(new Dimension(50, 10));
		getContentPane().add(panelWest, BorderLayout.WEST);
		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(new Color(0, 115, 165));
		panelEast.setPreferredSize(new Dimension(50, 10));
		getContentPane().add(panelEast, BorderLayout.EAST);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		JLabel labelTitle = new JLabel();
		labelTitle.setForeground(new Color (0, 115, 165));
		labelTitle.setFont(new Font("Tahoma",Font.BOLD, 16 ));
		panelNorth.add(labelTitle);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(new Color (0, 115, 165));
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		JButton ajouterButton = new JButton("Ajouter");
		ajouterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onAjouterClicked();
				
			}
		});
		panelSouth.add(ajouterButton);
		
		JButton modifierButton = new JButton("Modifier");
		modifierButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onModifierClicked();
				
			}
		});
		panelSouth.add(modifierButton);
		
		JButton quitterButton = new JButton("Quitter");
		quitterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onWindowClosing();
				
			}
		});
		panelSouth.add(quitterButton);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00E2ches", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelCenter.setBackground(new Color (0, 115, 165));
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelCenter.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"R\u00E9f\u00E9rence", "Description", "Date Ech\u00E9ance", "Criticit\u00E9"
			}
		));
		scrollPane.setViewportView(table);
		
		tableTasks = new JTable();
		tableTasks.setModel(new DefaultTableModel (
				new Object[][] {
				},
				new String[] {
						"R\u00E9f\u00E9rence", "Description", "Date \u00E9ch\u009ance", "Criticit\u00E9"
				}
				));
		
		tableTasks.getColumnModel().getColumn(0).setPreferredWidth(61);
		tableTasks.getColumnModel().getColumn(1).setPreferredWidth(334);
		tableTasks.getColumnModel().getColumn(2).setPreferredWidth(133);
		tableTasks.getColumnModel().getColumn(3).setPreferredWidth(94);
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				onWindowClosing();
			}
		});
		
		
	}


	protected void onModifierClicked() {
		
		
	}


	protected void onAjouterClicked() {
		
		UITask uitask = new UITask(this);
		uitask.start();
		
		this.end();
		
	}


	private void end() {
		this.setVisible(false);
		
	}


	protected void onWindowClosing() {
		if (JOptionPane.showConfirmDialog(null,"Quitter l'application ?") == JOptionPane.YES_OPTION) {
			dispose();
		}
		
		
	}


	public void start() {
		this.setVisible(true);
		
	}

}
