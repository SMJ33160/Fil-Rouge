package magasin;

import java.io.Serializable;

import magasin.Panier.ProduitAbsentPanierException;
import magasin.Panier.QuantiteNulleException;
import produits.Produit;
import utilitaires.GestionnaireSauvegarde;

public class Client implements Serializable{
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;

	public class ErreurConnexionException extends Exception {
		private static final long serialVersionUID = 1L;
		
		ErreurConnexionException (){
		}
		ErreurConnexionException (String message){
			super(message);
		}
	}

	private final String nom;
	private final String prenom;
	private final String mail;
	private final String genre;
	
	
	private String motDePasse;
	private Boolean connected=false;
	
	private Panier panierClient;
	private final CarnetCommande carnetCommandeClient;
	
		/**
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @param genre
	 */
	public Client( String genre, String nom, String prenom, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.genre = genre;
		this.carnetCommandeClient=new CarnetCommande();
		GestionnaireSauvegarde.marquer();
	}

	public final void setMotDePasse(String motDePasse) {
			this.motDePasse = motDePasse;
			GestionnaireSauvegarde.marquer();
		}

	public void connexion (String motDePasse) throws ErreurConnexionException {
		if (this.motDePasse.equals(motDePasse)){
			panierClient=new Panier();
			connected=true;
			}
		else {
			throw new ErreurConnexionException ("Mot de passe incorrect");
			}
	}
	
	public void deconnexion (){
		panierClient=null;
		connected=false;
	}
	
	/**
	 * @param produit
	 * @param quantite
	 * @see magasin.Panier#ajouterProduit(produits.Produit, int)
	 */
	public void ajouterProduit(Produit produit, int quantite) {
		if (connected)  panierClient.ajouterProduit(produit, quantite);
		
	}

	/**
	 * @param produit
	 * @param quantite
	 * @throws ProduitAbsentPanier
	 * @throws QuantiteNulleException
	 * @see magasin.Panier#suprimerProduit(produits.Produit, int)
	 */
	public void suprimerProduit(Produit produit, int quantite) throws ProduitAbsentPanierException, QuantiteNulleException {
		if (connected) panierClient.suprimerProduit(produit, quantite);
	}

	/**
	 * 
	 * @see magasin.Panier#viderPanier()
	 */
	public void viderPanier() {
		if (connected) panierClient.viderPanier();
	}

	/**
	 * 
	 * @see magasin.Panier#commanderPanier()
	 */
	public Commande commanderPanier() {
		Commande maCommande=null;
		if (connected) maCommande=panierClient.commanderPanier(this);
		return maCommande;
			}
	
	public void ajoutCommande(Commande maCommande) {
		carnetCommandeClient.ajoutCommande(maCommande);
	}

	public Commande commandeParNumero(int numCommande) {
		return carnetCommandeClient.commandeParNumero(numCommande);
	}

	/**
	 * @return
	 * @see magasin.Panier#montantPanier()
	 */
	public double montantPanier() {
		if (connected) return panierClient.montantPanier();
		return 0;
	}

	public final Panier getPanierClient() {
		return panierClient;
	}
	
	
	public final String getNom() {
		return nom;
	}

	public final String getPrenom() {
		return prenom;
	}

	public final String getMail() {
		return mail;
	}

	public final String getGenre() {
		return genre;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
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
		Client other = (Client) obj;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		return true;
	}

	
	
	

}
