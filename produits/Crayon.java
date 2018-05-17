/**
 * 
 */
package produits;

/**
 * @author jeanm_000
 *
 */
public class Crayon extends Produit {
	
	/**
	 * serialVersionUID car Produit est Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	private final DureteCrayon durete;
	
	/**
	 * @author jeanm_000
	 *
	 */
	public static enum DureteCrayon {
	_4B,_2B,_B,_H,_HB,_2H,_4H;
	}
	
	
	/**
	 * @param marque
	 * @param intitule
	 * @param description
	 * @param type
	 * @param prix
	 * @param durete
	 */
	
	public Crayon(String marque, String intitule, String description, double prix,
			DureteCrayon durete) {
		super(marque, intitule, description, TypeProduit.CRAYON, prix, durete);
		this.durete=durete;
		
	}
			
	/**
	 * @return the durete
	 */
	public final DureteCrayon getDurete() {
		return durete;
	}
	
	
	

}
