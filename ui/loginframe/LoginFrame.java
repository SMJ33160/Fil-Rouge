package ui.loginframe;

import java.awt.HeadlessException;
import javax.swing.JFrame;

import ui.produit.CahierJP;
import ui.produit.CrayonJP;
import ui.produit.GommeJP;
import ui.produit.ProduitCommunJPane;
public class LoginFrame extends JFrame {
 private static final long serialVersionUID = 1L;

	 public LoginFrame() throws HeadlessException {
	 super("Identification");
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	 // on change le panneau contenu
	 setContentPane(new CahierJP(new ProduitCommunJPane()));
	 //setContentPane(new LoginPanel());
	 
	 pack ();
	 setLocationRelativeTo(null);
	 }
}