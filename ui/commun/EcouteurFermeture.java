package ui.commun;

import java.awt.event.*;
import javax.swing.JOptionPane;

public class EcouteurFermeture extends WindowAdapter {
	
    public void windowClosing(WindowEvent e) {
    	
    	int confirm = JOptionPane.showOptionDialog(null,
                "Voulez vous vraiement quitter l'aplication ?",
                "Confirmation", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if (confirm == JOptionPane.YES_OPTION) {
        
            System.exit(1);
        }
    
    }

}
