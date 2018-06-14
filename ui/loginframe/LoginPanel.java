package ui.loginframe;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import magasin.CarnetClientele;
import magasin.Client;
import magasin.Client.ErreurConnexionException;
import ui.client.CreationCompteAction;
import ui.commun.ErreurPane;
import ui.commun.TitrePane;

public class LoginPanel extends JPanel {
	 
	private static final long serialVersionUID = 1L;
	
	private JTextField email;
	private JPasswordField motDePasse;
	private ErreurPane messageErreur;
	
	
	public Client validateIdent() {
		
		Client test;
		
		String panelLogin;
		String panelMdp;
		
		panelLogin=email.getText();
		panelMdp=new String (motDePasse.getPassword());
		
		test= CarnetClientele.getInstance().TrouveParMail(panelLogin);
		
		if (test==null){
			this.messageErreur.setText("Erreur de Mail");
			this.messageErreur.repaint();
			return null;
		}
		
		try {
				test.connexion(panelMdp);
			} catch (ErreurConnexionException e) {
				this.messageErreur.setText("Erreur de mot de passe");
				this.messageErreur.repaint();
				return null;
			}
				
		return test;
	}
	
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
	 messageErreur = new ErreurPane(" ");
	 add(messageErreur, gbc);
	
	 
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
		 
		 private AbstractAction loginAnnuler;
		 private AbstractAction loginConnexion;
		 private AbstractAction loginCreerCompte;
		
		 public LoginPanelBoutton() {
		 super();
		 setLayout(new GridLayout(0, 3));
		 
		 loginConnexion=new LoginValidation();
		 add(new JButton(loginConnexion));
		 
		 loginCreerCompte=new CreationCompteAction();
		 add(new JButton(loginCreerCompte));
		 
		 loginAnnuler = new LoginAnnulerAction();
		 add(new JButton(loginAnnuler));
		 }
	}
	 
}



