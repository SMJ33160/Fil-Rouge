package magasin;

import java.io.Serializable;
import java.util.Calendar;
import java.util.LinkedHashMap;

import produits.Produit;
import utilitaires.Compteur;

public class Commande implements Serializable{
	
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	private LinkedHashMap <Produit , LigneCommande > maCommande;
	private Client client;
	private Calendar dateCommande;
	private int numCommande;
	private boolean valide;
	
	public Commande (Client client){
		maCommande=new LinkedHashMap<>();
		this.client=client;
		dateCommande= Calendar.getInstance();
		numCommande=Compteur.newValue();
		valide=false;
	}
	
public void ajouterLigneCommande (LigneCommande ligneCommande) throws ProduitExistantException,CommandeVerrouilleException{
		if (valide){
			throw new CommandeVerrouilleException("Commande validée");
		}
		if (maCommande.containsKey(ligneCommande.produitLigne)){
			throw new ProduitExistantException("Produit déjà existant dans la commande") ;
		}
		else {
			maCommande.put(ligneCommande.produitLigne, ligneCommande);
		}
		
	}

public double montantCommande(){
	double montantTotal=0;
	
	for (LigneCommande maLigne : maCommande.values()){
		montantTotal+=maLigne.getPrixTotalLigne();
	}
	
	return montantTotal;
}

public class ProduitExistantException extends Exception {

	private static final long serialVersionUID = 1L;
	
	ProduitExistantException (){
	}
	ProduitExistantException (String message){
		super(message);
	}

}

public void verrouiller() {
	this.valide=true;
}

public void deverrouiller() {
	this.valide=false;
}

public class CommandeVerrouilleException extends Exception {
	private static final long serialVersionUID = 1L;
		
	CommandeVerrouilleException (){
		}
	CommandeVerrouilleException (String message){
			super(message);
		}
}

	public final Client getClient() {
		return client;
	}

	public final Calendar getDateCommande() {
		return dateCommande;
	}

	public final int getNumCommande() {
		return numCommande;
	}

	public final boolean isValide() {
		return valide;
	}
	
	@Override
	public String toString() {
		String message="Numero Commande: "+this.numCommande+"\n";
		for (LigneCommande maLigne : maCommande.values()){
			message+="Reference: " +maLigne.produitLigne.getReference()+" Qt: "+maLigne.quantiteligne+"\n";
		}
		return message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numCommande;
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
		Commande other = (Commande) obj;
		if (numCommande != other.numCommande)
			return false;
		return true;
	}	
	
	

}
