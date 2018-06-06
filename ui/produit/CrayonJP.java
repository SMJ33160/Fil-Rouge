package ui.produit;
import javax.swing.JComboBox;

import produits.Crayon;
import produits.Crayon.DureteCrayon;

public class CrayonJP extends AbstractOptionJPane {
	
	private static final long serialVersionUID = 1L;

	public CrayonJP(ProduitCommunJPane communJP) {
		super(communJP);
		this.AddLine("Dureté", new JComboBox<Crayon.DureteCrayon>(DureteCrayon.values()));
		
	}

}
