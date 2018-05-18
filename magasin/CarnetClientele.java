package magasin;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
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
		mesClients=new HashSet<Client>();
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
	public boolean enregistrer(ObjectOutputStream aEnregistrer) throws IOException {
		
		aEnregistrer.writeObject(mesClients);
		return true;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean restituer(ObjectInputStream aRestituer) throws IOException, ClassNotFoundException {
		
		mesClients=(HashSet<Client>) aRestituer.readObject();
	return true;	
	}

	@Override
	public String toString() {
		String retour;
		
		retour="Votre Carnet Clientele :\n";
		Iterator<Client> client =mesClients.iterator();
		
		while (client.hasNext()) {
			Client monClient = client.next();
			retour+=monClient.getGenre()+" "+monClient.getNom()+" "+monClient.getPrenom()+" "+monClient.getMail()+"\n";
		}
				
		return retour;
	}

	// Hash code et toString
	
	
}
