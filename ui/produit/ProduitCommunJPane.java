package ui.produit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import produits.TypeProduit;
import ui.commun.TitrePane;

public class ProduitCommunJPane extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JTextField marque;
	private JTextField prix;
	private JTextField intitule;
	private JTextArea description;
	private JComboBox<TypeProduit>  TypeProduitJC = new JComboBox<TypeProduit>(TypeProduit.values());
	
	// Contructeur de Classe qui bati le formulaire de base
	public ProduitCommunJPane() {
		
		super();
		this.setPreferredSize(new Dimension(350, 250));
		this.setBackground(new Color(245,245,245));
		 
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.gridwidth =2;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 0;
		 gbc.gridx = 0;
		 add(new TitrePane("Ajout Produit"), gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 2;
		 gbc.gridx = 0;
		 add(new JLabel("Marque : ",JLabel.LEFT), gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 2;
		 gbc.gridx = 1;
		 marque = new JTextField(25);
		 add(marque, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 3;
		 gbc.gridx = 0;
		 add(new JLabel("Prix : ",JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 3;
		 gbc.gridx = 1;
		 prix = new JTextField(25);
		 add(prix, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 4;
		 gbc.gridx = 0;
		 add(new JLabel("Intitul� : ",JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 4;
		 gbc.gridx = 1;
		 intitule = new JTextField(25);
		 add(intitule, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 5;
		 gbc.gridx = 0;
		 add(new JLabel("Description : ",JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 5;
		 gbc.gridx = 1;
		 description = new JTextArea(4,10);
		 add(new JScrollPane(description) , gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 6;
		 gbc.gridx = 0;
		 add(new JLabel("Type de produit : ",JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.HORIZONTAL;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 6;
		 gbc.gridx = 1;
		 add(TypeProduitJC, gbc);
		 
	
	}
	
	// m�thode permettant d'enregistrer le formulaire comme observateur de la liste d�roulante.
	public void addTypeProduitChangeListener(ActionListener listener) {
	
		// une simple d�l�gation vers la JComboBox  
		
		TypeProduitJC.addActionListener(listener);
	}
	
	// m�thode qui permet de r�cup�rer le type de produit s�lectionn� par l'utilisateur
	public TypeProduit getSelectedTypeProduit() {
	
		// de Nouveau une simple d�l�gation avec un casting de type Notez getSelectedItem qui retourne l'objet correspondant au choix de l'utilisateur
		
		return (TypeProduit) TypeProduitJC.getSelectedItem();
	}
	
}
