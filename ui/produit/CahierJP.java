package ui.produit;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import produits.Cahier;
import produits.Cahier.*;

public class CahierJP extends AbstractOptionJPane {
	
	private static final long serialVersionUID = 1L;

	public CahierJP(ProduitCommunJPane communJP) {
		super(communJP);
		
		this.AddLine("Dimension", new JTextField());
		this.AddLine("Nombre de page", new JTextField());
		this.AddLine("Carroyage", new JComboBox<Cahier.Carroyage>(Carroyage.values()));
		this.AddLine("Couture", new JComboBox<Cahier.Couture>(Couture.values()));
		this.AddLine("Couleur", new JTextField());
		this.AddLine("Grammage", new JTextField());
	}

}
