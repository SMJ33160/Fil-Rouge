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
		 
		 // Titre de la fen�tre avec le constructeur de JFrame
		 super("GESTION MAGASIN");

		 // arr�ter le programme si on ferme la fen�tre
		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 
		 // On ajoute un listener sur la fen�tre - ici on controlera la sortie
		 this.addWindowListener(new EcouteurFermeture());	
		 
		 // on change le panneau contenu
		 setContentPane((new ProduitBodyJPane()));
		 //setContentPane(new LoginPanel());
		 
		 pack ();
		 setLocationRelativeTo(null);
		 }
	
		
}
