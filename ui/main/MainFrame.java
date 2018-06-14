package ui.main;

import java.awt.HeadlessException;
import javax.swing.JFrame;

import ui.commun.EcouteurFermeture;
import ui.produit.ProduitBodyJPane;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainFrame() throws HeadlessException {
		 
		 // Titre de la fenêtre avec le constructeur de JFrame
		 super("GESTION MAGASIN");

		 // arrêter le programme si on ferme la fenêtre
		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 
		 // On ajoute un listener sur la fenêtre - ici on controlera la sortie
		 this.addWindowListener(new EcouteurFermeture());	
		 
		 // on change le panneau contenu
		 setContentPane((new ProduitBodyJPane()));
		 //setContentPane(new LoginPanel());
		 
		 pack ();
		 setLocationRelativeTo(null);
		 }
	
		
}
