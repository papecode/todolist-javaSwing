package sn.swing.ui;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import sn.swing.service.BusinessLayer;
import sn.swing.service.IService;
import sn.swing.utils.Utilitaire;

import javax.swing.JPasswordField;
import java.awt.Color;

public class UILogin extends JFrame{
	private static final long serialVersionUID = 1L;
	private JTextField loginTF;
	private JPasswordField passwordField;
	private IService businessLayer;
	
	private void initComponents () {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Sign in");
		setResizable(false);
		setPreferredSize(new Dimension(300, 150));
		setSize(new Dimension(300, 150));
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelSouth, BorderLayout.SOUTH);
		
		JButton submitButton = new JButton("Submit");
		
		submitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				onSubmitClicked();
				
			}
		});
		panelSouth.add(submitButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				onQuitterCliked();
				
			}
		});
		panelSouth.add(cancelButton);
		
		JPanel panelNorth = new JPanel();
		panelNorth.setBackground(new Color(0, 115, 165));
		panelNorth.setPreferredSize(new Dimension(10, 15));
		getContentPane().add(panelNorth, BorderLayout.NORTH);
		
		JPanel panelEast = new JPanel();
		panelEast.setBackground(new Color(0, 115, 165));
		panelEast.setPreferredSize(new Dimension(30, 10));
		getContentPane().add(panelEast, BorderLayout.EAST);
		
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelWest, BorderLayout.WEST);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(new Color(0, 115, 165));
		FlowLayout flowLayoutLogin = (FlowLayout) panelLogin.getLayout();
		flowLayoutLogin.setAlignment(FlowLayout.RIGHT);
		panelCenter.add(panelLogin);
		
		JLabel loginLabel = new JLabel("Login");
		loginLabel.setForeground(new Color(255, 255, 255));
		panelLogin.add(loginLabel);
		
		loginTF = new JTextField();
		panelLogin.add(loginTF);
		loginTF.setColumns(20);
		
		JPanel panelPassword = new JPanel();
		FlowLayout flowLayoutPassword = (FlowLayout) panelPassword.getLayout();
		flowLayoutPassword.setAlignment(FlowLayout.RIGHT);
		panelPassword.setBackground(new Color(0, 115, 165));
		panelCenter.add(panelPassword);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setForeground(new Color(255, 255, 255));
		panelPassword.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		panelPassword.add(passwordField);	
		
		Utilitaire.setLookAndFeel(this);
		Utilitaire.center(this, getSize());
		
	}
	
	public UILogin() {
		businessLayer = new BusinessLayer();
		initComponents();
		
	}

	protected void onQuitterCliked() {
		if (JOptionPane.showConfirmDialog(null,"Quitter l'application ?") == JOptionPane.YES_OPTION) {
			dispose();
		}
		
	}

	protected void onSubmitClicked() {
		String login = this.loginTF.getText();
		String password = String.valueOf(this.passwordField.getPassword());
		
		boolean status = businessLayer.authentificate(login, password);
		
		if (status == true) {
			// Afficher la fenêtre des tâches
			UIList uilist = new UIList();
			uilist.start();
			
			dispose();
		}else {
			JOptionPane.showMessageDialog(null, "Echec d'authentification", "Authentification", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void start() {
		this.setVisible(true);
	}

}