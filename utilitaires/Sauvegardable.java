package utilitaires;
import java.io.*;


public interface Sauvegardable {
	
	/**
	 *  les classes implémentant cette interface doivent toutes implémenter le patron singleton et, 
	 *  donc, fournir un service statique public static xxx getInstance () qui permettra de récupérer l’instance
	 *  
	 *  
	 * @param aEnregistrer
	 * @throws IOException
	 */
	
	public boolean enregistrer(ObjectOutputStream aEnregistrer) throws IOException;
	
	/**
	 * 
	 * @param aRestituer
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 */
	public boolean restituer(ObjectInputStream aRestituer) throws IOException, ClassNotFoundException;

}
