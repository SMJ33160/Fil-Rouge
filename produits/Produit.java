package produits;

import java.io.Serializable;
import java.security.InvalidParameterException;

import utilitaires.Compteur;

/**
 * 
 * @author jean marie CORDIER
 * Class abstraite des produits
 * reference: Référence du produit composée 3 lettres en majuscules identifant le type de produit (STY, CRA, GOM, CAH ou LOT)
 * suivies d'un nombre sur exactement 6 chifres et terminée par 0, 1, 2 ou 3 caractères laissés libres et permettant de décrire le produit
 * marque : Marque du produit
 * intitule: Intitulé du produit dans le catalogue
 * description: Description du produit
 * type : Type de produit
 * prix: Prix du produit
 *  
 * @version 1.0
 */

public abstract class Produit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final String reference;
	private final String marque;
	private final String intitule;
	private final String description;
	private final TypeProduit type;
	private double prix;
	
	
	/**
	 * Constructeur de la classe
	 * @param marque
	 * @param intitule
	 * @param description
	 * @param type
	 * @param prix
	 */
	public Produit(String marque, String intitule, String description, TypeProduit type, double prix, Object... complement) {
		super();
		this.marque = marque;
		this.intitule = intitule;
		this.description = description;
		this.type = type;
		this.prix = prix;
		this.reference= createReference(complement);
	}

	
	
	private String createReference(Object[] complement) {
		
		return type.getPrefixe()+ String.format("%06d", Compteur.newValue())+ type.getSuffixe(complement);
	}
	
	public void verrouiller(){
		
	}
	
	public void deverrouiller(){
		
	}
	
	public boolean aPourReference (String reference){
		
		return reference.equals(this.reference);
	}

	// Début hashCode et equals --------------------------------------------------------------------------------------------

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reference == null) ? 0 : reference.hashCode());
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
		if (!(obj instanceof Produit)) {
			return false;
		}
		Produit other = (Produit) obj;
		if (reference == null) {
			if (other.reference != null) {
				return false;
			}
		} else if (!reference.equals(other.reference)) {
			return false;
		}
		return true;
	}
// Fin hashCode et equals --------------------------------------------------------------------------------------------

// Début Setters et Getters --------------------------------------------------------------------------------------------

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 * @throws on leve une exception si prix négatif
	 */
	public void setPrix(double prix) {
	
		// si prix négatif on lève une exception de type InvalidParameterExeption
		if (prix<0){
			throw new InvalidParameterException("Le prix ne peut pas être négatif");
		}
		
		this.prix = prix;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @return the intitule
	 */
	public String getIntitule() {
		return intitule;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the type
	 */
	public TypeProduit getType() {
		return type;
	}
	
	// Fin Setters et Getters --------------------------------------------------------------------------------------------	
	
	
}
