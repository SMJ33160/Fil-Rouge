package ui.loginframe;

import java.awt.HeadlessException;
import javax.swing.JFrame;

import ui.client.UtilisateurBodyPane;
import ui.commun.EcouteurFermeture;


public class LoginFrame extends JFrame {
	
 private static final long serialVersionUID = 1L;
 
 // private LoginPanel loginPanel;
 
 private LoginPanel loginPanel;
 
  public LoginFrame() throws HeadlessException {
	
		 super("Identification");
	
		 this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		 
		 this.addWindowListener(new EcouteurFermeture());	
	 
		 // on change le panneau contenu
		loginPanel=new LoginPanel(); 
		setContentPane(loginPanel);
	
	 
	 pack ();
	 setLocationRelativeTo(null);
	 }

	public LoginPanel getLoginPanel() {
		return loginPanel;
	}

}