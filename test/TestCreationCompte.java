package test;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import application.Systeme;
import ui.client.UtilisateurBodyPane;
import ui.commun.EcouteurFermeture;
import ui.loginframe.LoginFrame;
import ui.loginframe.LoginPanel;
import utilitaires.GestionnaireSauvegarde;



public class TestCreationCompte extends JFrame {
	
	private static final long serialVersionUID = 1L;
	 
	 // private LoginPanel loginPanel;
	 
	 private UtilisateurBodyPane loginPanel;
	
	 
	  public TestCreationCompte() throws HeadlessException {
		
			 super("Nouveau Compte Client");
		
			 this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			 
			 this.addWindowListener(new EcouteurFermeture());	
		 
			 // on change le panneau contenu
			loginPanel=new UtilisateurBodyPane(); 
			setContentPane(loginPanel);
		
		 
		 pack ();
		 setLocationRelativeTo(null);
		 }

		public UtilisateurBodyPane getLoginPanel() {
			return loginPanel;
		}

		public static void main(String[] args) throws Exception   {
			
			 TestCreationCompte testCC=new TestCreationCompte();
							
								
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					
					testCC.setVisible(true);
				}
			});
						
			
			
		}		
		
}
