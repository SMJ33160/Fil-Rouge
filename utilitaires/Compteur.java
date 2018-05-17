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
	
	private static Compteur instance = null; // instance de class qui sera partag� par l'instance cr��e par new value
	private int suivant = 1;
	
	private Compteur () { // constructeur priv�, on ne peut pas cr�er d'instance en dehors de la classe 
	}
	
	/**
	 * M�thode de class
	 * retourne une valeur de compteur
	 * si pas d'instance compteur on en cr�e une
	 * on retourne le nombre incr�menter du compteur
	 * @return instance.increment ()
	 */
	
	
	public static int newValue () {		//
	if (instance == null) {
	instance = new Compteur ();
	}
	return instance.increment ();
	}
	
	/**
	 * incr�mente le compteur
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
