package magasin;

import java.io.Serializable;
import java.util.LinkedHashMap;

import utilitaires.Compteur;

public class CarnetCommande implements Serializable{
	
	// Variable
	
	private static final long serialVersionUID = 1L;
	
	LinkedHashMap<Integer,Commande> monCarnetCommande;


	
	// Variable instance

	// Constructeur
	
	public CarnetCommande() {
			}
	
	// M�thodes sp�cifiques
	
	public void ajoutCommande (Commande maCommande){
		monCarnetCommande.put(Compteur.newValue(), maCommande);
	}
	
	public Commande commandeParNumero (int numCommande){
		
		for (Commande commande: monCarnetCommande.values()){
			if (commande.getNumCommande()==numCommande) return commande;
		}
		
		return null;
	}

	// Exception

	// Getter Setter

	// Hash code et toString
}
