package ui.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.Enumeration;

import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import application.Systeme;
import application.Systeme.UtilisateurDejaConnecteException;
import magasin.CarnetClientele;
import magasin.CarnetClientele.ClientExistantDansCarnet;
import magasin.Client;
import ui.commun.ErreurPane;
import ui.commun.TitrePane;
import ui.loginframe.LoginAnnulerAction;
import ui.loginframe.LoginValidation;
import ui.loginframe.LoginPanel.LoginPanelBoutton;
import utilitaires.GestionnaireSauvegarde;

public class UtilisateurBodyPane extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JDialog dialog;
	private  JTextField nom;
	private  JTextField prenom;
	private  JTextField mail;
	private ButtonGroup genre = new ButtonGroup();
	private  JRadioButton masculin;
	private  JRadioButton feminin;
	private JPasswordField motDePasse;
	private JPasswordField controleMotDePasse;
	private ErreurPane messageErreurPane; 

	public UtilisateurBodyPane(JDialog dialog) {
		super();
		this.dialog = dialog;
		
		this.setPreferredSize(new Dimension(450, 350));
		 this.setBackground(new Color(245,245,245));
		 
		 this.setLayout(new GridBagLayout());
		 GridBagConstraints gbc = new GridBagConstraints();
		 
		 
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridwidth =3;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 0;
		 gbc.gridx = 0;
		 add(new TitrePane("Création Nouveau Compte"), gbc);
		
		
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridwidth =3;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 1;
		 gbc.gridx = 0;
		 messageErreurPane = new ErreurPane("");
		 add(messageErreurPane, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 2;
		 gbc.gridx = 0;
		 add(new JLabel("Sexe : ",JLabel.LEFT), gbc);
		 
		 masculin=new JRadioButton("Masculin");
		 feminin=new JRadioButton("Féminin");
		 genre.add(masculin);
		 genre.add(feminin);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 2;
		 gbc.gridx = 1;
		 add(masculin, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 2;
		 gbc.gridx = 2;
		 add(feminin, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 3;
		 gbc.gridx = 0;
		 add(new JLabel("Nom : ",JLabel.LEFT), gbc);
		 
		 gbc.gridwidth = 2;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 3;
		 gbc.gridx = 1;
		 nom = new JTextField(25);
		 add(nom, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 4;
		 gbc.gridx = 0;
		 add(new JLabel("Prénom ",JLabel.LEFT), gbc);
		 
		 gbc.gridwidth = 2;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 4;
		 gbc.gridx = 1;
		 prenom = new JTextField(25);
		 add(prenom, gbc);
		
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 5;
		 gbc.gridx = 0;
		 add(new JLabel("E-Mail : ",JLabel.LEFT), gbc);
		 
		 gbc.gridwidth = 2;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 5;
		 gbc.gridx = 1;
		 mail = new JTextField(25);
		 add(mail, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 6;
		 gbc.gridx = 0;
		 add(new JLabel("Mot de Passe : ",JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 2;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 6;
		 gbc.gridx = 1;
		 motDePasse = new JPasswordField(25);
		 add(motDePasse, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 7;
		 gbc.gridx = 0;
		 add(new JLabel("Contrôle mot de Passe : ",JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 2;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 7;
		 gbc.gridx = 1;
		 controleMotDePasse = new JPasswordField(25);
		 add(controleMotDePasse, gbc);
		 
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.gridwidth =3;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 8;
		 gbc.gridx = 0;
		 add(new LoginPanelBoutton() , gbc);
		 
		 }
	
	public AbstractAction  newEnregistrerAction() {
		return new EnregistrerAction();
	}
	
	public AbstractAction  newAnnulerAction() {
		return new AnnulerAction();
	}
		 
		 
	 public class LoginPanelBoutton extends JPanel {
		 private static final long serialVersionUID = 1L;
		 
		 public LoginPanelBoutton() {
		 super();
		 setLayout(new GridLayout(0, 2));
		 
		 add(new JButton(newEnregistrerAction()));
		 
		 add(new JButton(newAnnulerAction()));
		 }
	}
	
	private class AnnulerAction extends AbstractAction {
		
		private static final long serialVersionUID = 1L;

		AnnulerAction (){
			super ("Quitter");
		
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			dialog.dispose();
			
		}
		
	}
	
	private class EnregistrerAction extends AbstractAction {
	
		private static final long serialVersionUID = 1L;
			
		EnregistrerAction (){
			super ("Enregistrer");
		}
	
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String messageErreur ="<html><center>";
			boolean erreurDetecte=false;
			
			Client test = null;
			String genreSelected="";
			
			if (!(masculin.isSelected())&&!(feminin.isSelected())) {
				messageErreur+= "Le champ genre n'est pas renseigné <br/>";
				erreurDetecte=true;
			}
			
					
			if (nom.getText().isEmpty()) {
				messageErreur+= "Le champ nom n'est pas renseigné <br/>";
				erreurDetecte=true;
			}
			
			if (prenom.getText().isEmpty()) {
				messageErreur+= "Le champ prénom n'est pas renseigné <br/>";
				erreurDetecte=true;
			}
			
			if (mail.getText().isEmpty()) {
				messageErreur+= "Le champ mail n'est pas renseigné <br/>";
				erreurDetecte=true;
			}
			
			if (!(mail.getText().isEmpty())) {
				test=CarnetClientele.getInstance().TrouveParMail(mail.getText());
					if (test!=null) {
						messageErreur+= "L'addresse mail correspond à un compte existant";
						erreurDetecte=true;
					}
				
			}
			
			String motDePasseString = new String (motDePasse.getPassword()); // On récupère le String du mot de passe car getPassword retourne un tableau
			String controleMotDePasseString = new String (controleMotDePasse.getPassword());
			
			if (motDePasseString.isEmpty()) {
				messageErreur+= "Le mot de passe n'est pas renseigné <br/>";
				erreurDetecte=true;
			}
			
			if (!(motDePasseString.equals(controleMotDePasseString))) {
				messageErreur+= "Le mot de passe et le contrôle sont différents <br/>";
				erreurDetecte=true;
			}
			
			if (erreurDetecte) {
				messageErreur+= "<center></html>";
				messageErreurPane.setText(messageErreur);
				messageErreurPane.repaint();
				return;
			}
			
			for (Enumeration<AbstractButton> buttons = genre.getElements(); buttons.hasMoreElements();) {
				AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	            	genreSelected= button.getText();
	            }
	        }
			
			try {
				test=new Client(genreSelected,nom.getText(),prenom.getText(),mail.getText());
				test.setMotDePasse(motDePasseString);
				CarnetClientele.getInstance().AjoutClient(test);
			} catch (ClientExistantDansCarnet e) {
				// normalement n'arrive jamais !! car on a déjà tester le mail
			}
			
			try {
				GestionnaireSauvegarde.getInstance().sauver(Systeme.FILE_NAME);
			}
			catch (Exception e) {
				JOptionPane.showMessageDialog(null,
				"Erreur à la sauvegarde du nouveau compte",
				"Sauvegarde", JOptionPane.ERROR_MESSAGE);
			}
			
			dialog.dispose();
			
			try {
				Systeme.setUtilisateur(test);
			} catch (UtilisateurDejaConnecteException e) {
				
			}
			
			
			
		}
			
	}

}
