package magasin;

import java.util.LinkedHashMap;

import magasin.Commande.CommandeVerrouilleException;
import magasin.Commande.ProduitExistantException;
import produits.Produit;

public class Panier {
	
	LinkedHashMap <Produit , LignePanier > monPanier;
	
	public Panier(){
		monPanier=new LinkedHashMap<>();
	}
	
	public void ajouterProduit (Produit produit, int quantite){
		
		if (monPanier.containsKey(produit)){
			LignePanier ajoutLigne=monPanier.get(produit);	
			ajoutLigne.ajouter(quantite);
		}
		else {
			LignePanier ajoutLigne =new LignePanier(produit,quantite);
			monPanier.put(produit, ajoutLigne);
		}
		
	}
	
	public void suprimerProduit (Produit produit,int quantite) throws ProduitAbsentPanierException,QuantiteNulleException{
		if (monPanier.containsKey(produit)){
			LignePanier ajoutLigne=monPanier.get(produit);
			 if (!ajoutLigne.retirer(quantite)){
				 monPanier.remove(produit, ajoutLigne);
				 throw new QuantiteNulleException ("On supprime "+produit.getReference()+" car qt=0");
			}
		}
		else {
			throw new ProduitAbsentPanierException("Produit absent du panier");
		}
		
	}
	
	public void viderPanier (){
		monPanier.clear();
		
	}
	
	public Commande commanderPanier(Client client) {
		Commande maCommande=new Commande(client);
		
		for (LignePanier maLignePanier : monPanier.values()){
			LigneCommande maLigneCommande= maLignePanier.creerLigneCommande();
			try {
				maCommande.ajouterLigneCommande(maLigneCommande);
			}
			catch (ProduitExistantException e){
			}
			catch (CommandeVerrouilleException e){
				
			}
		}
		this.viderPanier();
		
		return maCommande;
		
	}
	
	public double montantPanier(){
		double montantTotal=0;
		
		for (LignePanier maLigne : monPanier.values()){
			montantTotal+=maLigne.montantLigne();
		}
		
		return montantTotal;
	}
	
	public class ProduitAbsentPanierException extends Exception {
		
		private static final long serialVersionUID = 1L;
		
		ProduitAbsentPanierException (){
		}
		ProduitAbsentPanierException (String message){
			super(message);
		}

	}
	
	public class QuantiteNulleException extends Exception {
		private static final long serialVersionUID = 1L;
		
		QuantiteNulleException (){
		}
		QuantiteNulleException (String message){
			super(message);
		}
		
	}

	/**
	 * @return the monPanier
	 */
	public final LinkedHashMap<Produit, LignePanier> getMonPanier() {
		return monPanier;
	}

	/**
	 * @param monPanier the monPanier to set
	 */
	public final void setMonPanier(LinkedHashMap<Produit, LignePanier> monPanier) {
		this.monPanier = monPanier;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String message="";
		for (LignePanier maLigne : monPanier.values()){
			message+="Reference: " +maLigne.produitLigne.getReference()+" Qt: "+maLigne.quantiteligne+"\n";
		}
		return message;
	}


}
