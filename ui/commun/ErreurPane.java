package ui.commun;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ErreurPane extends JLabel {
	
	private static final long serialVersionUID = 1L;
	
	public ErreurPane (String Titre){
		 this.setText(Titre);
		 this.setHorizontalAlignment(CENTER);
		 this.setFont(this.getFont().deriveFont(Font.BOLD, 12.0F));
		 this.setForeground(new Color (255,0,0));
		 this.setOpaque(false);
		 this.setBackground(new Color(245,245,245));
		 
	 }
	
}


