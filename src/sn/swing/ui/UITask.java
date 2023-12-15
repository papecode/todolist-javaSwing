package sn.swing.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class UITask extends JFrame {
	public UITask() {
		setTitle("Gestion des tâches - version 1.0.2");
		setResizable(false);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		JLabel titleLabel = new JLabel("Ajouter / Modifier une tâche");
		titleLabel.setForeground(new Color(255, 255, 255));
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		panelNorth.add(titleLabel);
		
		JPanel panelWest = new JPanel();
		panelWest.setPreferredSize(new Dimension(60, 10));
		panelWest.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelWest, BorderLayout.WEST);
		
		JPanel panelEast = new JPanel();
		panelEast.setPreferredSize(new Dimension(60, 10));
		panelEast.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelEast, BorderLayout.EAST);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		validerButton = new JButton("Valider");
		panelSouth.add(validerButton);
		
		JButton quitterButton = new JButton("Quitter");
		panelSouth.add(quitterButton);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(0, 115, 165));
		panelCenter.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "D\u00E9tails", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panelDescription = new JPanel();
		panelDescription.setBackground(new Color(0, 115, 165));
		panelCenter.add(panelDescription);
		panelDescription.setLayout(new BorderLayout(0, 0));
		
		JLabel labelDescription = new JLabel("Description :");
		labelDescription.setForeground(new Color(255, 255, 255));
		panelDescription.add(labelDescription, BorderLayout.WEST);
		
		JScrollPane scrollPane = new JScrollPane();
		panelDescription.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JPanel panelDateEcheance = new JPanel();
		panelDateEcheance.setBackground(new Color(0, 115, 165));
		FlowLayout fl_panelDateEcheance = (FlowLayout) panelDateEcheance.getLayout();
		fl_panelDateEcheance.setAlignment(FlowLayout.RIGHT);
		panelCenter.add(panelDateEcheance);
		
		JLabel labelDateEcheance = new JLabel("Date échéance :");
		labelDateEcheance.setForeground(new Color(255, 255, 255));
		panelDateEcheance.add(labelDateEcheance);
		
		JFormattedTextField dateEcheanceTF = new JFormattedTextField();
		dateEcheanceTF.setColumns(10);
		panelDateEcheance.add(dateEcheanceTF);
		
		JPanel panelCriticite = new JPanel();
		panelCriticite.setBackground(new Color(0, 115, 165));
		FlowLayout fl_panelCriticite = (FlowLayout) panelCriticite.getLayout();
		fl_panelCriticite.setAlignment(FlowLayout.RIGHT);
		panelCenter.add(panelCriticite);
		
		JLabel criticiteLabel = new JLabel("Criticité :");
		criticiteLabel.setForeground(new Color(255, 255, 255));
		panelCriticite.add(criticiteLabel);
		
		JComboBox <String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Faible", "Normal", "Urgent"}));
		comboBox.setPreferredSize(new Dimension(85, 22));
		comboBox.setOpaque(false);
		comboBox.setSize(new Dimension(0, 22));
		panelCriticite.add(comboBox);
	}

	private static final long serialVersionUID = 1L;
	private JButton validerButton;

}
