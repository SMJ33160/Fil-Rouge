package produits;

/**
 * @author jeanm_000
 *
 */


public class Gomme extends Produit {
	
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

	public Gomme(String marque, String intitule, String description, double prix) {
		super(marque, intitule, description, TypeProduit.GOMME, prix);
		
	}

}
