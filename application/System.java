package application;

import ui.main.MainFrame;
import utilitaires.*;
import magasin.*;




public class System {
	
	static final public String FILE_NAME="Mon_Fichier_Sauvegarde";
	
	static private LoginFrame lf;
	static private MainFrame mf;
	static private Client utilisateur;
	
	static private void initSysteme(){
	
	Compteur.getInstance();
	Catalogue.getInstance();
	CarnetCommandeMagasin.getInstance();
	CarnetClientele.getInstance().AjoutClient(new Administrateur("root","root","root","root@root.com"));
	
	GestionnaireSauvegarde.getInstance().sauver(FILE_NAME);
	
	}

	public static Client getUtilisateur() {
		return utilisateur;
	}

	public static void setUtilisateur(Client utilisateur) {
		
		if (utilisateur==null){
			throw new UtilisateurDejaConnecteException("Utilisateur déjà connecté !");
		}
		System.utilisateur = utilisateur;
		
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
}


