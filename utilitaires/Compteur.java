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
	 * incr�mente le compteur
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
