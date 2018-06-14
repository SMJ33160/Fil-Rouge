package test;

import java.awt.event.*;

class GestionnaireFenetre extends WindowAdapter {

   public void windowClosing(WindowEvent e) {
      System.exit(0);
   }
}