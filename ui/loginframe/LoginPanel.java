package ui.loginframe;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ui.commun.ErreurPane;
import ui.commun.TitrePane;

public class LoginPanel extends JPanel {
	 
	private static final long serialVersionUID = 1L;
	
	private JTextField email;
	private JPasswordField motDePasse;
	
	public LoginPanel() {
	super();
	 
	 this.setPreferredSize(new Dimension(350, 160));
	 this.setBackground(new Color(245,245,245));
	 
	 this.setLayout(new GridBagLayout());
	 GridBagConstraints gbc = new GridBagConstraints();
	 
	 gbc.fill = GridBagConstraints.HORIZONTAL;
	 gbc.gridwidth =2;
	 gbc.insets = new Insets(5,5,5,5);
	 gbc.gridy = 0;
	 gbc.gridx = 0;
	 add(new TitrePane("Identification"), gbc);
	 
	 gbc.fill = GridBagConstraints.HORIZONTAL;
	 gbc.gridwidth =2;
	 gbc.insets = new Insets(5,5,5,5);
	 gbc.gridy = 1;
	 gbc.gridx = 0;
	 add(new ErreurPane("Email non reconnue ou mot de passe non valide"), gbc);
	 
	 gbc.gridwidth = 1;
	 gbc.fill = GridBagConstraints.BOTH;
	 gbc.insets = new Insets(5,5,5,5);
	 gbc.gridy = 2;
	 gbc.gridx = 0;
	 add(new JLabel("E-Mail : ",JLabel.LEFT), gbc);
	 
	 gbc.gridwidth = 1;
	 gbc.fill = GridBagConstraints.BOTH;
	 gbc.insets = new Insets(5,5,5,5);
	 gbc.gridy = 2;
	 gbc.gridx = 1;
	 email = new JTextField(25);
	 add(email, gbc);
	 
	 gbc.gridwidth = 1;
	 gbc.fill = GridBagConstraints.BOTH;
	 gbc.insets = new Insets(5,5,5,5);
	 gbc.gridy = 3;
	 gbc.gridx = 0;
	 add(new JLabel("Mot de Passe : ",JLabel.LEFT), gbc);
	
	 gbc.gridwidth = 1;
	 gbc.fill = GridBagConstraints.BOTH;
	 gbc.insets = new Insets(5,5,5,5);
	 gbc.gridy = 3;
	 gbc.gridx = 1;
	 motDePasse = new JPasswordField(25);
	 add(motDePasse, gbc);
	 
	 gbc.fill = GridBagConstraints.BOTH;
	 gbc.gridwidth =2;
	 gbc.insets = new Insets(5,5,5,5);
	 gbc.gridy = 4;
	 gbc.gridx = 0;
	 add(new LoginPanelBoutton() , gbc);
	 
	 }
	 
	 
	 public class LoginPanelBoutton extends JPanel {
		 private static final long serialVersionUID = 1L;
		
		 public LoginPanelBoutton() {
		 super();
		 setLayout(new GridLayout(0, 3));
		 add(new JButton("Connexion"));
		 add(new JButton("Créer un compte"));
		 add(new JButton("Annuler"));
		 }
	}
	 
}



