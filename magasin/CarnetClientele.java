package magasin;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;

import utilitaires.Sauvegardable;

public class CarnetClientele implements Serializable,Sauvegardable{

	
	private static final long serialVersionUID = 1L;
	
	
	// Variable
	
	HashSet <Client> mesClients;

	// Variable instance
	
	private static CarnetClientele monCarnet=null;

	// Constructeur
	
	private CarnetClientele (){
	}

	// Méthodes spécifiques
	
	public void AjoutClient (Client client){
		if (!mesClients.contains(client)){
			mesClients.add(client);
		}
	}
	
	public Client TrouveParMail (String mail){
		
		Iterator<Client> client =mesClients.iterator();
		
		while (client.hasNext()) {
			Client monClient = client.next();
			if (monClient.getMail().equals(mail)) return monClient;
		}
		
		return null;
	}

	// Exception

	// Getter Setter
	
	public static CarnetClientele GetInstance(){
		if (monCarnet == null) {
			monCarnet = new CarnetClientele();
		}
		return monCarnet;
	}

	@Override
	public void enregistrer(ObjectOutputStream aEnregistrer) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restituer(ObjectOutputStream aRestituer) throws IOException {
		// TODO Auto-generated method stub
		
	}

	// Hash code et toString
}
