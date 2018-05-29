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
		 
		 // Titre de la fenêtre avec le constructeur de JFrame
		 super("GESTION MAGASIN");

		 // arrêter le programme si on ferme la fenêtre
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		// création d'une barre de menu
		 JMenuBar mbVerte = new JMenuBar();
		 mbVerte.setOpaque(true);
		 mbVerte.setBackground(new Color(154, 255, 127));
		 mbVerte.setPreferredSize(new Dimension(200, 200));
		 // ajout de la barre de menu à la fenêtre
		 setJMenuBar(mbVerte);

		 // création d'une étiquette (texte affiché)
		 JLabel etiquetteJaune = new JLabel("Un JLabel");
		 etiquetteJaune.setOpaque(true);
		 etiquetteJaune.setBackground(new Color(255, 255, 120));
		 etiquetteJaune.setPreferredSize(new Dimension(300, 180));
		 // on récupère le paneau de la fenêtre et on y ajoute l'étiquette
		 getContentPane().add(etiquetteJaune, BorderLayout.CENTER);

		 // on dimensionne la fenêtre au mieux
		 pack ();
		 }
	
	
}
