package ui.produit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ui.commun.TitrePane;

public abstract class AbstractOptionJPane extends JPanel {
	
	private static final long serialVersionUID = 1L;

	final ProduitCommunJPane communJP;
	
	protected GridBagConstraints gbc;

	public AbstractOptionJPane(ProduitCommunJPane communJP) {
		super();
		this.communJP = communJP;
		
		this.setPreferredSize(new Dimension(350, 250));
		this.setBackground(new Color(245,245,245));
		 
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		 gbc.gridy = 7;
		 gbc.gridx = 0;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
	}
	
	/**
	 * 	méthode protected nommée addLine pour ajouter une ligne au panneau
		courant. Cette ligne est formée d’un JLabel dont le contenu de type String est pris en
		paramètre et d’un champ de saisie lui aussi pris en paramètre. 
		Cette méthode est déclarée protected car on souhaite que seules les héritières de la
		classe aient le droit d’ajouter une ligne à ce formulaire.
	 * @param intitule pour le JLabel
	 * @param composant le composant à insérer
	 */
	
	protected void AddLine (String intitule, JComponent composant) {
		
		 gbc.gridy ++; // on décale de 1 en Y pour ajouter la ligne
		 
		 gbc.gridwidth = 1;
		
		 gbc.gridx = 0;
		 add(new JLabel(intitule,JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 1;
		 gbc.gridx = 1;
		 add(composant, gbc);
		
	}
	
	
}
