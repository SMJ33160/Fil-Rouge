package ui.produit;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import application.Systeme;
import produits.TypeProduit;

public class ProduitBodyJPane extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	ProduitCommunJPane communJP;
	AbstractOptionJPane optionJP;
	
	public ProduitBodyJPane() {
		
		communJP=new ProduitCommunJPane();
		this.add(communJP);
		communJP.addTypeProduitChangeListener(this); 
		
		
	}
	
	@Override
	// méthode permettant de changer la partie variable du formulaire quand l'utilisateur change de type de produit.
	public void actionPerformed(ActionEvent event) {
	
		// on détruit la partie variable actuelle du formulaire.
		if (optionJP != null) {
			remove(optionJP);
		}
	
		// on récupère le type de produit selectionné par l'utilisateur.
		TypeProduit tp = communJP.getSelectedTypeProduit();
	
		// on crée la partie variable qui correspond au choix de l'utilisateur.
		optionJP = tp.NewOptionJPane(communJP);
	
		// pour positionner correctement la partie variable du formulaire en son sein.
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.WEST;
	
		// on ajoute la partie variable au formulaire.
		add(optionJP,gbc);
		
		// on adapte la fenêtre au nouveau contenu.
		Systeme.getMf().pack();
	}
	

}
