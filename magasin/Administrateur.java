package magasin;

public class Administrateur extends Client {

	private static final long serialVersionUID = 1L;

	public Administrateur(String genre, String nom, String prenom, String mail) {
		super(genre, nom, prenom, mail);
		this.setMotDePasse("root");
		// TODO Auto-generated constructor stub
	}

}
