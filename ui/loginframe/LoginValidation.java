package ui.loginframe;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import application.Systeme;
import application.Systeme.appelHorsLfException;

public class LoginValidation extends AbstractAction{

	private static final long serialVersionUID = 1L;
	
	public LoginValidation (){
		super("Login");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Systeme.validateLogin();
		} catch (appelHorsLfException e) {
			
			}
		
	}
	
}
