package utilitaires;
import java.io.*;


public interface Sauvegardable {
	
	/**
	 *  les classes impl�mentant cette interface doivent toutes impl�menter le patron singleton et, 
	 *  donc, fournir un service statique public static xxx getInstance () qui permettra de r�cup�rer l�instance
	 *  
	 *  
	 * @param aEnregistrer
	 * @throws IOException
	 */
	
	public void enregistrer(ObjectOutputStream aEnregistrer) throws IOException;
	
	/**
	 * 
	 * @param aRestituer
	 * @throws IOException
	 */
	public void restituer(ObjectOutputStream aRestituer) throws IOException;

}
