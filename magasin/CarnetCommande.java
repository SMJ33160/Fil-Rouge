package magasin;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;

import utilitaires.Compteur;
import utilitaires.GestionnaireSauvegarde;
import utilitaires.Sauvegardable;

public class CarnetCommande implements Serializable, Sauvegardable{
	
	// Variable
	
	private static final long serialVersionUID = 1L;
	
	LinkedHashMap<Integer,Commande> monCarnetCommande;


	
	// Variable instance

	// Constructeur
	
	public CarnetCommande() {
			}
	
	// Méthodes spécifiques
	
	public void ajoutCommande (Commande maCommande){
		monCarnetCommande.put(Compteur.newValue(), maCommande);
		GestionnaireSauvegarde.marquer();
	}
	
	public Commande commandeParNumero (int numCommande){
		
		for (Commande commande: monCarnetCommande.values()){
			if (commande.getNumCommande()==numCommande) return commande;
		}
		
		return null;
	}
	
	@Override
	public boolean enregistrer(ObjectOutputStream aEnregistrer) throws IOException {
		aEnregistrer.writeObject(monCarnetCommande);
	return true;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean restituer(ObjectInputStream aRestituer) throws IOException, ClassNotFoundException {
		monCarnetCommande=(LinkedHashMap<Integer,Commande>) aRestituer.readObject();
	return true;	
	}

	// Exception

	// Getter Setter

	// Hash code et toString
}
