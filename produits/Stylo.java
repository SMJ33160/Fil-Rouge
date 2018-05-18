package produits;

/**
 * @author jeanm_000
 *
 */
public class Stylo extends Produit {
	
	/**
	 * serialVersionUID car Produit est Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	private final String couleur;
	private final TypeStylo typeStylo;

	
	public static enum TypeStylo {
		PLUME,FEUTRE,BILLE;
	}

	/**
	 * @param marque
	 * @param intitule
	 * @param description
	 * @param type
	 * @param prix
	 * @param couleur
	 * @param type
	 */
	public Stylo(String marque, String intitule, String description, double prix, String couleur,TypeStylo type) {
		super(marque, intitule, description, TypeProduit.STYLO, prix, couleur,type);
		this.couleur=couleur;
		this.typeStylo=type;
	}

	/**
	 * @return the couleur
	 */
	public final String getCouleur() {
		return couleur;
	}
	
	/**
	 * @return le type de stylo
	 */
	public final TypeStylo getTypeStylo() {
		return typeStylo;
	}

	@Override
	public String toString() {
		return "Stylo : reference= " + reference + " marque= " + marque + " typeStylo=" + typeStylo + " couleur=" + couleur + " intitule= " + intitule
				+ " description= " + description + " type= " + type + " prix= "
				+ prix ;
	}
	
	

}
