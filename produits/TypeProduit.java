package produits;

import produits.Cahier.Carroyage;
import produits.Cahier.Couture;
import produits.Crayon.DureteCrayon;
import produits.Stylo.TypeStylo;
import ui.produit.*;

public enum TypeProduit   {
	STYLO {
		@Override
		public String getPrefixe() {
		return "STY";
		}

		@Override
		public String getSuffixe(Object[] complement) { //Suffixe = > 1er caractère du type de stylo +
			String couleur= (String)complement[0];		// 2 premiers caractères en majuscule de la couleur
			TypeStylo type = (TypeStylo)complement[1];
			return (type.toString().charAt(0)+couleur.substring(0,2).toUpperCase()) ;
		}

		@Override
		public AbstractOptionJPane NewOptionJPane(ProduitCommunJPane newOptionPanel) {
			return new StyloJP(newOptionPanel);
		}
		
	},CRAYON {
		@Override
		public String getPrefixe() {
		return "CRA";
		}

		@Override
		public String getSuffixe(Object[] complement) {
			DureteCrayon durete = (DureteCrayon)complement[0];
			return durete.toString().substring(1);
		}

		@Override
		public AbstractOptionJPane NewOptionJPane(ProduitCommunJPane newOptionPanel) {
			return new CrayonJP(newOptionPanel);
		}
	},GOMME {
		@Override
		public String getPrefixe() {
		return "GOM";
		}

		@Override
		public String getSuffixe(Object[] complement) {
		return "";
		}

		@Override
		public AbstractOptionJPane NewOptionJPane(ProduitCommunJPane newOptionPanel) {
			return new GommeJP(newOptionPanel);
		}
	},CAHIER {
		@Override
		public String getPrefixe() {
		return "CAH";
		}

		@Override
		public String getSuffixe(Object[] complement) {		//Suffixe => 1er caractère du carroyage +
			Carroyage carroyage= (Carroyage)complement[0];	// 2 premiers caractères de la couture
			Couture couture = (Couture)complement[1];
			return (carroyage.toString().charAt(0)+couture.toString().substring(0,2)) ;
		}

		@Override
		public AbstractOptionJPane NewOptionJPane(ProduitCommunJPane newOptionPanel) {
			return new CahierJP(newOptionPanel);
		}
	},LOT {
		@Override
		public String getPrefixe() {
		return "LOT";
		}

		@Override
		public String getSuffixe(Object[] complement) {
		return "";
		}

		@Override
		public AbstractOptionJPane NewOptionJPane(ProduitCommunJPane newOptionPanel) {
			return new LotJP(newOptionPanel);
		}
	};

	public abstract String getPrefixe() ;

	public abstract String getSuffixe(Object[] complement) ;
	
	public abstract AbstractOptionJPane NewOptionJPane (ProduitCommunJPane newOptionPanel);

	

}
