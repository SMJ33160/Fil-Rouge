package ui.commun;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitrePane extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public TitrePane (String Titre){
		 JLabel titre = new JLabel(Titre, JLabel.CENTER);
		 titre.setFont(titre.getFont().deriveFont(Font.BOLD, 15.0F));
		 titre.setForeground(new Color (150,150,8));
		 this.setBackground(new Color(245,245,245));
		 add (titre);
	 }
	
}


