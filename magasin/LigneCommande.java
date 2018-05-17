package magasin;

import java.io.Serializable;

import produits.Produit;

public class LigneCommande implements Serializable{

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	final Produit produitLigne;
	final int quantiteligne;
	final double prixUnitaireLigne;
	
	
	LigneCommande (Produit produit, int quantite)  {
		produitLigne=produit;
		quantiteligne=quantite;
		prixUnitaireLigne = produitLigne.getPrix();
	}


	public final Produit getProduitLigne() {
		return produitLigne;
	}


	public final int getQuantiteligne() {
		return quantiteligne;
	}


	public final double getPrixUnitaireLigne() {
		return prixUnitaireLigne;
	}
	
	public final double getPrixTotalLigne() {
		return this.prixUnitaireLigne*this.quantiteligne;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produitLigne == null) ? 0 : produitLigne.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneCommande other = (LigneCommande) obj;
		if (produitLigne == null) {
			if (other.produitLigne != null)
				return false;
		} else if (!produitLigne.equals(other.produitLigne))
			return false;
		return true;
	}
	
	
	
}
