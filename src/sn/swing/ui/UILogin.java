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
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

public class UILogin extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	public UILogin() {
		setTitle("Sign in");
		setResizable(false);
		setSize(new Dimension(300, 150));
		
		JPanel panelSud = new JPanel();
		panelSud.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelSud, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Submit");
		panelSud.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Bonjour");
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("Cancel");
		panelSud.add(btnNewButton_1);
		
		JPanel panelNord = new JPanel();
		panelNord.setBackground(new Color(0, 115, 165));
		panelNord.setPreferredSize(new Dimension(10, 15));
		getContentPane().add(panelNord, BorderLayout.NORTH);
		
		JPanel panelEast = new JPanel();
		panelEast.setSize(new Dimension(30, 10));
		panelEast.setBackground(new Color(0, 115, 165));
		panelEast.setPreferredSize(new Dimension(30, 10));
		getContentPane().add(panelEast, BorderLayout.EAST);
		panelEast.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panelWest = new JPanel();
		panelWest.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelWest, BorderLayout.WEST);
		
		JPanel panelCentre = new JPanel();
		panelCentre.setBackground(new Color(0, 115, 165));
		getContentPane().add(panelCentre, BorderLayout.CENTER);
		panelCentre.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel_1.setBackground(new Color(0, 115, 165));
		panelCentre.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(20);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.setBackground(new Color(0, 115, 165));
		panelCentre.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		panel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(20);
		panel.add(passwordField);
		
		
		
	}
	
	public void star() {
		this.setVisible(true);

	}
	

}