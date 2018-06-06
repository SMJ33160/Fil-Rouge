package ui.commun;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErreurPane extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public ErreurPane (String Titre){
		 JLabel erreurTitre = new JLabel(Titre, JLabel.CENTER);
		 erreurTitre.setFont(erreurTitre.getFont().deriveFont(Font.BOLD, 12.0F));
		 erreurTitre.setForeground(new Color (255,0,0));
		 erreurTitre.setOpaque(false);
		 this.setBackground(new Color(245,245,245));
		 add (erreurTitre);
	 }
	
}


