package utilitaires;

import magasin.*;
import magasin.Client.ErreurConnexionException;
import magasin.Panier.ProduitAbsentPanierException;
import magasin.Panier.QuantiteNulleException;
import produits.*;
import produits.Crayon.DureteCrayon;
import produits.Stylo.TypeStylo;

public class TestCata {

	public static void main(String[] args) throws ProduitAbsentPanierException,QuantiteNulleException {
		
		Client monClient =new Client("Mr","Dupont","Jean","Jean.Dupont@toto.fr");
		
		monClient.setMotDePasse("toto");
		try {
			monClient.connexion("toto");
		}
		catch (ErreurConnexionException e){
			System.out.println(e.getMessage());
		}
		
		Commande maCommande;
	//	Panier monPanier;
		 
		Produit maGomme = new Gomme ("Cordier","Gomme crayon","Une Super Gomme",5.2);
		Produit monStylo = new Stylo ("Cordier", "Mon Stylo", "un super stylo", 1.2, "Rouge", TypeStylo.PLUME);
		Produit monCrayon= new Crayon ("Cordier","Mon Crayon","un Super Crayon",2.3,DureteCrayon._HB);
		//monPanier=new Panier();
		
		
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
		
		
		
	
	}

}
