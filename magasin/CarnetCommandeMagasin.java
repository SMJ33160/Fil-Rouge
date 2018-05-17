package magasin;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import utilitaires.Sauvegardable;

public class CarnetCommandeMagasin implements Serializable, Sauvegardable {
	
	
	private static final long serialVersionUID = 1L;

	private CarnetCommande monCarnetDeCommande;
	
	private static CarnetCommandeMagasin instance=null;
	
	/**
	 * Constructeur privé pour faire un singleton
	 */
	private CarnetCommandeMagasin() {
		monCarnetDeCommande = new CarnetCommande();
	}
	
	/**
	 * Static getter methode pour recupérer l'instance
	 */
	public static CarnetCommandeMagasin getInstance() {
		if (instance == null) {
			instance = new CarnetCommandeMagasin();
		}
		return instance;
	}

	public void ajoutCommande(Commande maCommande) {
		monCarnetDeCommande.ajoutCommande(maCommande);
	}

	public Commande commandeParNumero(int numCommande) {
		return monCarnetDeCommande.commandeParNumero(numCommande);
	}

	@Override
	public boolean enregistrer(ObjectOutputStream aEnregistrer) throws IOException {
		monCarnetDeCommande.enregistrer(aEnregistrer);
	return true;	
	}

	@Override
	public boolean restituer(ObjectInputStream aRestituer) throws IOException, ClassNotFoundException {
		monCarnetDeCommande.restituer(aRestituer);
	return true;	
	}
	
	
	
	

}
