package ui.produit;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 2;
		 gbc.gridx = 0;
		 add(new JLabel("Marque : ",JLabel.LEFT), gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 2;
		 gbc.gridx = 1;
		 marque = new JTextField(25);
		 add(marque, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 3;
		 gbc.gridx = 0;
		 add(new JLabel("Prix : ",JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 3;
		 gbc.gridx = 1;
		 prix = new JTextField(25);
		 add(prix, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 4;
		 gbc.gridx = 0;
		 add(new JLabel("Intitulé : ",JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 4;
		 gbc.gridx = 1;
		 intitule = new JTextField(25);
		 add(intitule, gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 5;
		 gbc.gridx = 0;
		 add(new JLabel("Description : ",JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 5;
		 gbc.gridx = 1;
		 description = new JTextArea(4,10);
		 add(new JScrollPane(description) , gbc);
		 
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 6;
		 gbc.gridx = 0;
		 add(new JLabel("Type de produit : ",JLabel.LEFT), gbc);
		
		 gbc.gridwidth = 1;
		 gbc.fill = GridBagConstraints.BOTH;
		 gbc.insets = new Insets(5,5,5,5);
		 gbc.gridy = 6;
		 gbc.gridx = 1;
		 add(TypeProduitJC, gbc);
		 
	
	}

	public JTextField getMarque() {
		return marque;
	}

	public void setMarque(JTextField marque) {
		this.marque = marque;
	}

	public JTextField getPrix() {
		return prix;
	}

	public void setPrix(JTextField prix) {
		this.prix = prix;
	}

	public JTextField getIntitule() {
		return intitule;
	}

	public void setIntitule(JTextField intitule) {
		this.intitule = intitule;
	}

	public JTextArea getDescription() {
		return description;
	}

	public void setDescription(JTextArea description) {
		this.description = description;
	}

	public JComboBox<TypeProduit> getTypeProduitJC() {
		return TypeProduitJC;
	}

	public void setTypeProduitJC(JComboBox<TypeProduit> typeProduitJC) {
		TypeProduitJC = typeProduitJC;
	}
	
	

}
