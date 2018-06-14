package ui.commun;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import application.Systeme;
import ui.main.MainFrame;
import utilitaires.GestionnaireSauvegarde;

public class QuitterAction extends AbstractAction {


	private static final long serialVersionUID = 1L;
	
	public QuitterAction() {
		super("Quitter");
	}

	public QuitterAction(String action) {
		super(action);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		MainFrame fenetrePrincipale = Systeme.getMf();
		
		int choix = JOptionPane.showConfirmDialog(fenetrePrincipale,
				 "<html><center>Les données ont été modifiées"
				 + " et n'ont pas été sauvegardées.<br>"
				 + "Vous allez perdre vos modifications.<br><br>"
				 + "Voulez-vous vraiment faire cette opération ?<center></html>",
				 "Données modifiées",
				 JOptionPane.YES_NO_OPTION,
				 JOptionPane.WARNING_MESSAGE);

		  if (choix == JOptionPane.YES_OPTION)
		  {
		    System.exit(0);
		  }
		
	}

}
