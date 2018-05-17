/**
 * 
 */
package utilitaires;

import java.io.IOException;
import java.io.ObjectOutputStream;
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
	
	
	public static int newValue () {		//
	if (instance == null) {
	instance = new Compteur ();
	}
	return instance.increment ();
	}
	
	/**
	 * incrémente le compteur
	 * @return
	 */
	
	private int increment() {
	return suivant++;
	}

	@Override
	public void enregistrer(ObjectOutputStream aEnregistrer) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restituer(ObjectOutputStream aRestituer) throws IOException {
		// TODO Auto-generated method stub
		
	}
}
