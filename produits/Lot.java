/**
 * 
 */
package produits;

import java.util.HashMap;

import utilitaires.GestionnaireSauvegarde;

/**
 * @author jeanm_000
 *
 */
public class Lot extends Produit {
	
	/**
	 * serialVersionUID car Produit est Serializable
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param marque
	 * @param intitule
	 * @param description
	 * @param prix
	 */
	
	private boolean verrouille; // variable qui permet de verouiller les lots
	
	HashMap<Produit, Integer> contenu;
	
	public class LotVerrouilleException extends Exception {

	 private static final long serialVersionUID = 1L;

	}
	
	public class ProduitExistantDansLeLot extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	}
	
		
	public Lot(String marque, String intitule, String description, double prix) {
		super(marque, intitule, description, TypeProduit.LOT, prix);
		this.verrouille=false;
		contenu=new HashMap<>();
	}
	
	public void ajouter (Produit produit, int quantite) throws LotVerrouilleException, ProduitExistantDansLeLot {
		
		if (verrouille){
			throw new LotVerrouilleException();
		}
		
		if (contenu.containsKey(produit)){
			throw new ProduitExistantDansLeLot();
		}
		
		contenu.put(produit, quantite);
		GestionnaireSauvegarde.getInstance().marquer();
	}


	/* (non-Javadoc)
	 * @see produits.Produit#verouiller()
	 */
	@Override
	public void verrouiller() {
		super.verrouiller();
		this.verrouille=true;
	}
	
	@Override
	public void deverrouiller() {
		super.deverrouiller();
		this.verrouille=false;
	}

	@Override
	public String toString() {
		return "Lot: reference=" + reference + " verrouille= " + verrouille + " contenu= " + contenu + " marque= "
				+ marque + " intitule= " + intitule + " description= " + description + " type= " + type + " prix= "
				+ prix ;
	}
	

}
