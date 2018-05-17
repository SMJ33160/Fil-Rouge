/**
 * 
 */
package magasin;

import produits.Produit;

/**
 * @author jeanm_000
 *
 */
public class LignePanier {

	Produit produitLigne=null;
	int quantiteligne=0;	
	
	

	LignePanier (Produit produit, int quantite)  {
		produitLigne=produit;
		quantiteligne=quantite;
	}

	public void ajouter (int quantite){
		this.quantiteligne+=quantite;
	}
	
	public boolean retirer (int quantite)  {
		boolean quantitePositiveEtNonNulle= true;
		this.quantiteligne-=quantite;
		if (this.quantiteligne<=0){
			quantitePositiveEtNonNulle=false;
			
		}
		return quantitePositiveEtNonNulle;
	}
	
	public double montantLigne(){
		return this.quantiteligne*this.produitLigne.getPrix();
	}
	
	public LigneCommande creerLigneCommande(){
		return new LigneCommande(this.produitLigne,this.quantiteligne);
		
	}
	
	/**
	 * @return produitLigne
	 */
	public final Produit getProduitLigne() {
		return produitLigne;
	}
	
	/**
	 * @return quantiteligne
	 */
	public final int getQuantiteligne() {
		return quantiteligne;
	}
	
	/**
	 * @param produitLigne  produitLigne to set
	 */
	public final void setProduitLigne(Produit produitLigne) {
		this.produitLigne = produitLigne;
	}
	
	/**
	 * @param quantiteligne quantiteligne to set
	 */
	public final void setQuantiteligne(int quantiteligne) {
		this.quantiteligne = quantiteligne;
	}
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((produitLigne == null) ? 0 : produitLigne.hashCode());
		result = prime * result + quantiteligne;
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LignePanier)) {
			return false;
		}
		LignePanier other = (LignePanier) obj;
		if (produitLigne == null) {
			if (other.produitLigne != null) {
				return false;
			}
		} else if (!produitLigne.equals(other.produitLigne)) {
			return false;
		}
		
		return true;
	}

}
