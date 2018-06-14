package application;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import magasin.Administrateur;
import magasin.CarnetClientele;
import magasin.CarnetCommandeMagasin;
import magasin.Catalogue;
import magasin.Client;
import test.TestCreationCompte;
import ui.client.UtilisateurBodyPane;
import ui.loginframe.LoginFrame;
import ui.loginframe.LoginPanel;
import ui.main.MainFrame;
import utilitaires.Compteur;
import utilitaires.GestionnaireSauvegarde;


public class Systeme {
	
	static final public String FILE_NAME="Mon_Fichier_Sauvegarde";
	
	static private LoginFrame lf;
	static private MainFrame mf;
	static private Client utilisateur;
	
	static private Systeme instance; 
	
	static private void initSysteme() {
	
		Compteur.getInstance();
		Catalogue.getInstance();
		CarnetCommandeMagasin.getInstance();
		utilisateur=new Administrateur("masculin","root","root","root@root.com");
		try {
			CarnetClientele.getInstance().AjoutClient(utilisateur);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
			"Erreur lors de l'ajout de l'utilisateur",
			"Initialisation System", JOptionPane.ERROR_MESSAGE);
		}
		
		try {
			GestionnaireSauvegarde.getInstance().sauver(FILE_NAME);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
			"Erreur à la création du fichier",
			"Initialisation System", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public static MainFrame getMf () {
		return mf;
	}
	
	private Systeme() {
	}
	
	public static Systeme getInstance () {		//
		if (instance == null) {
		instance = new Systeme ();
		}
		return instance;
	}
	
	public static Client getUtilisateur() {
		return utilisateur;
	}

	public static void setUtilisateur(Client monUtilisateur) throws UtilisateurDejaConnecteException {
		
		if (utilisateur!=null){
			throw getInstance().new UtilisateurDejaConnecteException();
		}
		utilisateur = monUtilisateur;
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				mf = new MainFrame();
				mf.setVisible(true);
			}
		});
		
		//lf.dispose();
		lf=null;
	}
	
	public static void validateLogin () throws appelHorsLfException {
		Client connexionClient;
		
		if (lf==null) {
			throw getInstance().new appelHorsLfException();
		}
		else {
			connexionClient=lf.getLoginPanel().validateIdent();
			
			if (connexionClient!=null) {
				try {
					setUtilisateur(connexionClient);
				} catch (UtilisateurDejaConnecteException e) {
					
				}
				
			}
			
		}
	}
	
	public class appelHorsLfException extends Exception {
		private static final long serialVersionUID = 1L;
		
		appelHorsLfException (){
		}
		appelHorsLfException (String message){
			super(message);
		}
	}
	
	public class UtilisateurDejaConnecteException extends Exception {
		private static final long serialVersionUID = 1L;
		
		UtilisateurDejaConnecteException (){
		}
		UtilisateurDejaConnecteException (String message){
			super(message);
		}
	}
	
	//  Methode Main de la classe Systeme
	public static void main(String[] args) throws Exception   {
	
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		} catch (UnsupportedLookAndFeelException e1) {
			e1.printStackTrace();
		}
		
		try {
			GestionnaireSauvegarde.getInstance().restituer(new File (Systeme.FILE_NAME));
		}
		catch (FileNotFoundException e) {
				Systeme.initSysteme();
		} 
		
		catch (Exception e) {
				JOptionPane.showMessageDialog(null,
				"Le fichier de données est corrompu.",
				"Fichier corrompu", JOptionPane.ERROR_MESSAGE);
				throw e;
		}
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				lf= new LoginFrame();
				lf.setVisible(true);
			}
		});

	}

}





