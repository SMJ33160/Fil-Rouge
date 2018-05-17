/**
 * 
 */
package utilitaires;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

/**
 * @author jean marie CORDIER
 *
 */
public class Compteur implements Serializable, Sauvegardable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static Compteur instance = null; // instance de class qui sera partagé par l'instance créée par new value
	private int suivant = 1;
	
	private Compteur () { // constructeur privé, on ne peut pas créer d'instance en dehors de la classe 
	}
	
	/**
	 * Méthode de class
	 * retourne une valeur de compteur
	 * si pas d'instance compteur on en crée une
	 * on retourne le nombre incrémenter du compteur
	 * @return instance.increment ()
	 */
	public static int newValue() {
		return getInstance().increment();
		}
	
	public static Compteur getInstance () {		//
	if (instance == null) {
	instance = new Compteur ();
	}
	return instance;
	}
	
	/**
	 * incrémente le compteur
	 * @return
	 */
	
	private int increment() {
	GestionnaireSauvegarde.marquer();
	return suivant++;
	}

	@Override
	public boolean enregistrer(ObjectOutputStream aEnregistrer) throws IOException {
		// TODO Auto-generated method stub
		aEnregistrer.writeObject(instance);
	return true;	
	}

	@Override
	public boolean restituer(ObjectInputStream aRestituer) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		instance=(Compteur) aRestituer.readObject();
		return true;	
	}
}
