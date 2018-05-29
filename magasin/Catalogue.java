package magasin;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

import produits.Produit;
import utilitaires.Sauvegardable;


/**
 * @author jeanm_000
 *
 */
public class Catalogue implements Serializable, Sauvegardable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HashSet <Produit> contenu;
	
	public class ErreurAjoutProduitException extends Exception {

		private static final long serialVersionUID = 1L;
	}
	
	public class ErreurSuppressionProduitException extends Exception {

		private static final long serialVersionUID = 1L;
	}
	
	/**
	 * Instance static Catalogue
	 */
	private static Catalogue instance;

	/**
	 * Constructeur privé pour faire un singleton
	 */
	private Catalogue() {
		contenu = new HashSet<>();
	}
	
  public void ajouter (Produit produit) throws ErreurAjoutProduitException {
		
		if (produit ==null){
			throw new NullPointerException();
		}
		
		if (this.contenu.add(produit)){
			produit.verrouiller();
		}
		else
		{
			throw new ErreurAjoutProduitException();
		}
		
	}
  
  public void supprimer (Produit produit) throws ErreurSuppressionProduitException {
		
		if (produit ==null){
			throw new NullPointerException();
		}
		
		if (this.contenu.remove(produit)){
			produit.deverrouiller();
		}
		else
		{
			throw new ErreurSuppressionProduitException();
		}
		
	}
  
  public Produit recherche (String reference){

	for (Produit produit:this.contenu){
		if (produit.aPourReference(reference)){
			return produit;
		}
	}
	return null;
 
  }
	/**
	 * Static getter methode pour recupérer l'instance
	 */
	public static Catalogue getInstance() {
		if (instance == null) {
			instance = new Catalogue();
		}
		return instance;
	}

	@Override
	public boolean enregistrer(ObjectOutputStream aEnregistrer) throws IOException {
		aEnregistrer.writeObject(contenu);
	return true;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean restituer(ObjectInputStream aRestituer) throws IOException, ClassNotFoundException {
		contenu=(HashSet<Produit>) aRestituer.readObject();
	return true;	
	}

	@Override
	public String toString() {
		
		String retour;
		
		retour="Votre catalogue :\n";
		Iterator<Produit> monContenu =contenu.iterator();
		
		while (monContenu.hasNext()) {
			Produit monProduit = monContenu.next();
			retour+=monProduit.toString()+"\n";
		}
				
		return retour;
	}
	
	

}