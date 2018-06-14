package ui.client;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javafx.scene.shape.Box;
import ui.commun.EcouteurFermeture;

public class CreationCompte extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private UtilisateurBodyPane utilisateurBodyPane;
	
	CreationCompte () {
		super ();
		this.setTitle("Création d'un compte");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new EcouteurFermeture());
		
		utilisateurBodyPane=new UtilisateurBodyPane(this);
		add(utilisateurBodyPane);
		
		pack();
		 setLocationRelativeTo(null);
		
		this.setVisible(true);
	}
	

}
