package produits;

/**
 * @author jeanm_000
 *
 */
public class Cahier extends Produit {
	
	
	/**
	 * serialVersionUID car Produit est Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	
	private final String couleur;
	private final int nbPage;
	private final Couture couture;
	private final int grammage;
	private final String dimension;
	private final Carroyage carroyage;
	
	public static enum Couture {
		SPIRALE,PIQUE;
		}
	
	public static enum Carroyage {
		PETIT_CARREAU,GRAND_CARREAU,SANS_CARREAU;
	}
	
	/**
	 * @param marque
	 * @param intitule
	 * @param description
	 * @param type
	 * @param prix
	 * @param complement
	 */
	public Cahier(String marque, String intitule, String description, TypeProduit type, double prix, String couleur,
			int nbPage, Couture couture, int grammage, String dimension, Carroyage carroyage) {
		super(marque, intitule, description, TypeProduit.CAHIER, prix, carroyage, couture, couleur, nbPage, grammage,
				dimension);
		this.couleur = couleur;
		this.couture = couture;
		this.dimension = dimension;
		this.grammage = grammage;
		this.nbPage = nbPage;
		this.carroyage = carroyage;

	}

	/**
	 * @return the couleur
	 */
	public final String getCouleur() {
		return couleur;
	}

	/**
	 * @return the nbPage
	 */
	public final int getNbPage() {
		return nbPage;
	}

	/**
	 * @return the couture
	 */
	public final Couture getCouture() {
		return couture;
	}

	/**
	 * @return the grammage
	 */
	public final int getGrammage() {
		return grammage;
	}

	/**
	 * @return the dimension
	 */
	public final String getDimension() {
		return dimension;
	}

	/**
	 * @return the carroyage
	 */
	public final Carroyage getCarroyage() {
		return carroyage;
	}

}
