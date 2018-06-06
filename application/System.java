package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import magasin.Administrateur;
import magasin.CarnetClientele;
import magasin.CarnetClientele.ClientExistantDansCarnet;
import magasin.CarnetCommandeMagasin;
import magasin.Catalogue;
import magasin.Client;
import ui.loginframe.LoginFrame;
import ui.main.MainFrame;
import utilitaires.Compteur;
import utilitaires.GestionnaireSauvegarde;


public class System {
	
	static final public String FILE_NAME="Mon_Fichier_Sauvegarde";
	
	static private LoginFrame lf;
	static private MainFrame mf;
	static private Client utilisateur;
	
	static private System instance; 
	
	static private void initSysteme() {
	
		Compteur.getInstance();
		Catalogue.getInstance();
		CarnetCommandeMagasin.getInstance();
		utilisateur=new Administrateur("root","root","root","root@root.com");
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
	
	private System() {
	}
	
	public static System getInstance () {		//
		if (instance == null) {
		instance = new System ();
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
		
		lf.dispose();
		lf=null;
	}
	
	public class UtilisateurDejaConnecteException extends Exception {
		private static final long serialVersionUID = 1L;
		
		UtilisateurDejaConnecteException (){
		}
		UtilisateurDejaConnecteException (String message){
			super(message);
		}
	}

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
		GestionnaireSauvegarde.getInstance().restituer(new File (System.FILE_NAME));
	}
		catch (FileNotFoundException e) {
			System.initSysteme();
			} 
	
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,
			"Le fichier de données est corrompu.",
			"Fichier corrompu", JOptionPane.ERROR_MESSAGE);
			throw e;
			}
	
		
	lf=new LoginFrame();
	lf.setVisible(true);
	
	
	
	
	}
}





