package ui.client;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import application.Systeme;
import ui.main.MainFrame;

public class CreationCompteAction extends AbstractAction {

	private static final long serialVersionUID = 1L;
	
	public CreationCompteAction () {
		super ("Création compte");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		CreationCompte nouveauCompte=new CreationCompte();
						
	}
	
}
