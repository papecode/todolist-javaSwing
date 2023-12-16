package sn.swing.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.DateTimeException;
import java.time.LocalDate;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import sn.swing.entities.Criticite;
import sn.swing.utils.Utilitaire;

import javax.swing.border.EtchedBorder;

public class UITask extends JFrame {
	private static final long serialVersionUID = 1L;
	private UIList uiList;
	private JButton validerButton;
	private JTextArea descriptionTA;
	private JComboBox<String > criticiteCB;
	private JFormattedTextField dateEcheanceTF;
	
	public UITask(UIList uiList) {
			this();
			
			this.uiList = uiList;
		}
	
	public UITask() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		iniComponents();
	}
	
	private void iniComponents () {
		setTitle("Gestion des tâches - version 1.0.2");
		setResizable(false);
		setPreferredSize(new Dimension(500, 250));
		setSize(new Dimension(500, 250));
		
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
		
		JButton validerButton = new JButton("Valider");
		validerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onValiderClicked();
				
			}
		}); 
		
		panelSouth.add(validerButton);
		
		JButton quitterButton = new JButton("Quitter");
		quitterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onQuitterClicked();
				
			}
		});
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
		
		 descriptionTA = new JTextArea();
		scrollPane.setViewportView(descriptionTA);
		
		JPanel panelDateEcheance = new JPanel();
		panelDateEcheance.setBackground(new Color(0, 115, 165));
		FlowLayout fl_panelDateEcheance = (FlowLayout) panelDateEcheance.getLayout();
		fl_panelDateEcheance.setAlignment(FlowLayout.RIGHT);
		panelCenter.add(panelDateEcheance);
		
		JLabel labelDateEcheance = new JLabel("Date échéance :");
		labelDateEcheance.setForeground(new Color(255, 255, 255));
		panelDateEcheance.add(labelDateEcheance);
		
		try {
			MaskFormatter maskFormater = new MaskFormatter("####-##-##"); 
			dateEcheanceTF = new JFormattedTextField(maskFormater);
			dateEcheanceTF.setToolTipText("yyyy-mm-dd");
			dateEcheanceTF.setColumns(10);
			panelDateEcheance.add(dateEcheanceTF);
			
		} catch (ParseException ignored) {}
		
		
		
		JPanel panelCriticite = new JPanel();
		panelCriticite.setBackground(new Color(0, 115, 165));
		FlowLayout fl_panelCriticite = (FlowLayout) panelCriticite.getLayout();
		fl_panelCriticite.setAlignment(FlowLayout.RIGHT);
		panelCenter.add(panelCriticite);
		
		JLabel criticiteLabel = new JLabel("Criticité :");
		criticiteLabel.setForeground(new Color(255, 255, 255));
		panelCriticite.add(criticiteLabel);
		
		criticiteCB = new JComboBox<>();
		criticiteCB.setModel(new DefaultComboBoxModel<>(new String[] 
				{
						Criticite.FAIBLE.getName(),
						Criticite.NORMAL.getName(), 
						Criticite.URGENT.getName()
				}));
		criticiteCB.setPreferredSize(new Dimension(85, 22));
		criticiteCB.setOpaque(false);
		criticiteCB.setSize(new Dimension(0, 22));
		panelCriticite.add(criticiteCB);
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());
	}

	
	
	protected void onValiderClicked() {
		String description = this.descriptionTA.getText();
		if (description.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Veuillez renseigner la description", "Invalid input", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				LocalDate dateEcheance = LocalDate.parse(this.dateEcheanceTF.getText());
				Criticite criticite = Criticite.valueOf(this.criticiteCB.getSelectedItem().toString());
				
			} catch (DateTimeException e) {
				JOptionPane.showMessageDialog(null, "Date écheance invalide", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				
			}
		}
				
	}

	protected void onQuitterClicked() {
		this.dispose();
		
		uiList.start();
	}

	public void start() {
		this.setVisible(true);
		
	}

}
