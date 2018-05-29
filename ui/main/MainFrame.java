package ui.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;

public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MainFrame() throws HeadlessException {
		 
		 // Titre de la fen�tre avec le constructeur de JFrame
		 super("GESTION MAGASIN");

		 // arr�ter le programme si on ferme la fen�tre
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		// cr�ation d'une barre de menu
		 JMenuBar mbVerte = new JMenuBar();
		 mbVerte.setOpaque(true);
		 mbVerte.setBackground(new Color(154, 255, 127));
		 mbVerte.setPreferredSize(new Dimension(200, 200));
		 // ajout de la barre de menu � la fen�tre
		 setJMenuBar(mbVerte);

		 // cr�ation d'une �tiquette (texte affich�)
		 JLabel etiquetteJaune = new JLabel("Un JLabel");
		 etiquetteJaune.setOpaque(true);
		 etiquetteJaune.setBackground(new Color(255, 255, 120));
		 etiquetteJaune.setPreferredSize(new Dimension(300, 180));
		 // on r�cup�re le paneau de la fen�tre et on y ajoute l'�tiquette
		 getContentPane().add(etiquetteJaune, BorderLayout.CENTER);

		 // on dimensionne la fen�tre au mieux
		 pack ();
		 }
	
	
}
