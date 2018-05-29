package utilitaires;

import java.util.LinkedList;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import magasin.*;
import java.io.File;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class GestionnaireSauvegarde {
	
	/**
	 * Cette variable d'instance permet de collecter toutes les classes à
	 * sauvegarder. Il suffit d'ajouter à cette liste chacune des classes à
	 * sauvegarder et à restituer dans le constructeur
	 *
	 * @see GestionnaireSauvegarde#GestionnaireSauvegarde()
	 */
	private LinkedList<Class<? extends Sauvegardable>> aSauver;
	
	static boolean modifie;
	
	private GestionnaireSauvegarde(){
		// création de la liste
		aSauver = new LinkedList<>();
		modifie = false;
		// ajout des classes à sauvegarder à la liste aSauver. Si de nouvelles
		// classes sont à ajouter, il n'y a qu'à les mettre après CarnetCommandeMagasin.class.
		// Compteur.class est un objet de type Class décrivant le contenu de la
		// classe Compteur. C'est une syntaxe classique de Java. Il en va de
		// même pour les trois autres classes.
		
		Collections.addAll(aSauver, Compteur.class, Catalogue.class,CarnetClientele.class, CarnetCommandeMagasin.class);
		
	}
	
	public static void marquer(){
		modifie=true;
	}
	 
	public static boolean isModifie() {
		return modifie;
	}

	/**
	 * permet de récupérer l'unique instance de la classe dont le descripteur
	 * est donné par le paramètre {@code clazz}. La classe doit offrir une
	 * méthode {@code getInstance} statique et sans paramètre.
	 *
	 * @param clazz
	 * la classe dont on veut une instance.
	 * @return l'unique instance de la classe.
	 * @throws IllegalAccessException
	 * si les droits d'accès à getInstance ne sont pas suffisants.
	 * @throws IllegalArgumentException
	 * si les paramètres de {@code getInstance} ne conviennent pas.
	 * Ceci ne devrait jamais se produire.
	 * @throws InvocationTargetException
	 * si la méthode getInstance lève une exception particulière.
	 * @throws NoSuchMethodException
	 * si la classe ne définit de méthode getInstance()
	 * @throws SecurityException
	 * si il y a un problème d'accès au package de la classe lié à
	 * la sécurité.
	 * @see Sauvegardable
	 */
	private Sauvegardable getInstance(Class<? extends Sauvegardable> clazz)	throws IllegalAccessException, IllegalArgumentException,InvocationTargetException,
	NoSuchMethodException, SecurityException {
	return (Sauvegardable) clazz.getMethod("getInstance").invoke(null);
	}
	
	public void sauver (File fichier) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		try {
		fos = new FileOutputStream(fichier);
		bos = new BufferedOutputStream(fos);
		oos = new ObjectOutputStream(bos);
		for (Class<? extends Sauvegardable> clazz : aSauver) {
			getInstance(clazz).enregistrer(oos) ;
			}
		} 
		catch (IOException e) {
		e.printStackTrace();
		} 
		
		finally {
			try {
				if (oos != null) oos.close();
				else if (bos != null) bos.close();
				else if (fos != null)fos.close();
			} 
			catch (IOException e) {
			e.printStackTrace();
			}
		modifie=false;
		
		}

	}
	
	public void sauver (String cheminAccesFichier) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException{
		
		File fichier = new File(cheminAccesFichier);
		sauver(fichier);
		
	}
	
public void restituer (File fichier) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		FileInputStream fos = null;
		BufferedInputStream bos = null;
		ObjectInputStream oos = null;
		try {
		fos = new FileInputStream(fichier);
		bos = new BufferedInputStream(fos);
		oos = new ObjectInputStream(bos);
		for (Class<? extends Sauvegardable> clazz : aSauver) {
			getInstance(clazz).restituer(oos) ;
			}
		} 
		catch (IOException e) {
		e.printStackTrace();
		} 
		
		finally {
			try {
				if (oos != null) oos.close();
				else if (bos != null) bos.close();
				else if (fos != null)fos.close();
			} 
			catch (IOException e) {
			e.printStackTrace();
			}
		modifie=false;
		
		}

	}
	
	public void restituer (String cheminAccesFichier) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, IOException, ClassNotFoundException{
		
		File fichier = new File(cheminAccesFichier);
		restituer(fichier);
		
	}
	
	
}
