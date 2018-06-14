package ui.produit;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import produits.Stylo;
import produits.Stylo.*;

public class StyloJP extends AbstractOptionJPane {
	
	private static final long serialVersionUID = 1L;

	public StyloJP(ProduitCommunJPane communJP) {
		super(communJP);
		
		this.AddLine("Type de Stylo :", new JComboBox<Stylo.TypeStylo>(TypeStylo.values()));
		this.AddLine("Couleur", new JTextField(25));
		
	}

}
