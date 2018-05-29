package utilitaires;

import magasin.*;
import magasin.Catalogue.ErreurAjoutProduitException;
import magasin.Client.ErreurConnexionException;
import magasin.Panier.ProduitAbsentPanierException;
import magasin.Panier.QuantiteNulleException;
import produits.*;
import produits.Crayon.DureteCrayon;
import produits.Stylo.TypeStylo;

/** Programme de test du fil rouge
 * 
 * @author Jm 
 *
 */

public class TestCata {

	public static void main(String[] args) throws ProduitAbsentPanierException,QuantiteNulleException, ErreurAjoutProduitException {
		
		
		/** Création d'un Carnet Client
		 * 
		 */
		
		CarnetClientele monCarnetClient = CarnetClientele.GetInstance();
		
		for (int i=0; i<5;i++){
		
		Client monClient =new Client("Mr","Dupont"+i,"Jean","Jean.Dupont"+i+"@toto.fr");
		monClient.setMotDePasse("toto");
		monCarnetClient.AjoutClient(monClient);
		}
				
		System.out.print(monCarnetClient.toString());
		
		/** Création de produit et du catalogue
		 * 
		 */
		Produit maGomme = new Gomme ("Cordier","Gomme crayon","Une Super Gomme",5.2);
		Produit monStylo = new Stylo ("Cordier", "Mon Stylo", "un super stylo", 1.2, "Rouge", TypeStylo.PLUME);
		Produit monCrayon= new Crayon ("Cordier","Mon Crayon","un Super Crayon",2.3,DureteCrayon._HB);
		
		Catalogue monCatalogue=Catalogue.getInstance();
		
		
		monCatalogue.ajouter(maGomme);
		monCatalogue.ajouter(monStylo);
		monCatalogue.ajouter (monCrayon);
		
		System.out.print(monCatalogue.toString());
		
		
		/**
		
		monClient.setMotDePasse("toto");
		try {
			monClient.connexion("toto");
		}
		catch (ErreurConnexionException e){
			System.out.println(e.getMessage());
		}
		
		Commande maCommande;
		Panier monPanier;
		 
		
		monPanier=new Panier();
		
		
		monClient.ajouterProduit(maGomme, 15);
		monClient.ajouterProduit(monStylo, 10);
		
		System.out.print(monClient.getPanierClient().toString());
		System.out.println("Montant du panier: "+monClient.montantPanier()+ " €");
		
		
		try {
			monClient.suprimerProduit(monStylo, 5);
		}
		catch (QuantiteNulleException e){
			System.out.println(e.getMessage());
		}
		catch (ProduitAbsentPanierException e){
			System.out.println(e.getMessage());
		}
		
		System.out.print(monClient.getPanierClient().toString());
		System.out.println(monClient.montantPanier());	
		
		monClient.ajouterProduit(maGomme, 5);
		System.out.print(monClient.getPanierClient().toString());
		System.out.println(monClient.montantPanier());	
		
		try {
			monClient.suprimerProduit(maGomme, 5);
		}
		catch (QuantiteNulleException e){
			System.out.println(e.getMessage());
		}
		catch (ProduitAbsentPanierException e){
			System.out.println(e.getMessage());
		}
		
		System.out.print(monClient.getPanierClient().toString());
		System.out.println(monClient.montantPanier());	
		
		monClient.ajouterProduit(monCrayon, 5);
		System.out.print(monClient.getPanierClient().toString());
		System.out.println(monClient.montantPanier());
		
		maCommande=monClient.commanderPanier();
		System.out.print(monClient.getPanierClient().toString());
		System.out.println(monClient.montantPanier());
		
		System.out.print(maCommande.toString());
		
		
		**/
	
	}

}
