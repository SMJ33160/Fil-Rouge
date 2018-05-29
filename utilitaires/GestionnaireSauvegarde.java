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
	 * Cette variable d'instance permet de collecter toutes les classes �
	 * sauvegarder. Il suffit d'ajouter � cette liste chacune des classes �
	 * sauvegarder et � restituer dans le constructeur
	 *
	 * @see GestionnaireSauvegarde#GestionnaireSauvegarde()
	 */
	private LinkedList<Class<? extends Sauvegardable>> aSauver;
	
	static boolean modifie;
	
	private GestionnaireSauvegarde(){
		// cr�ation de la liste
		aSauver = new LinkedList<>();
		modifie = false;
		// ajout des classes � sauvegarder � la liste aSauver. Si de nouvelles
		// classes sont � ajouter, il n'y a qu'� les mettre apr�s CarnetCommandeMagasin.class.
		// Compteur.class est un objet de type Class d�crivant le contenu de la
		// classe Compteur. C'est une syntaxe classique de Java. Il en va de
		// m�me pour les trois autres classes.
		
		Collections.addAll(aSauver, Compteur.class, Catalogue.class,CarnetClientele.class, CarnetCommandeMagasin.class);
		
	}
	
	public static void marquer(){
		modifie=true;
	}
	 
	public static boolean isModifie() {
		return modifie;
	}

	/**
	 * permet de r�cup�rer l'unique instance de la classe dont le descripteur
	 * est donn� par le param�tre {@code clazz}. La classe doit offrir une
	 * m�thode {@code getInstance} statique et sans param�tre.
	 *
	 * @param clazz
	 * la classe dont on veut une instance.
	 * @return l'unique instance de la classe.
	 * @throws IllegalAccessException
	 * si les droits d'acc�s � getInstance ne sont pas suffisants.
	 * @throws IllegalArgumentException
	 * si les param�tres de {@code getInstance} ne conviennent pas.
	 * Ceci ne devrait jamais se produire.
	 * @throws InvocationTargetException
	 * si la m�thode getInstance l�ve une exception particuli�re.
	 * @throws NoSuchMethodException
	 * si la classe ne d�finit de m�thode getInstance()
	 * @throws SecurityException
	 * si il y a un probl�me d'acc�s au package de la classe li� �
	 * la s�curit�.
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
