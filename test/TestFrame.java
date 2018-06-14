package test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

public class TestFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  
  private GestionnaireFenetre gf = new GestionnaireFenetre();


   public TestFrame(String title) {
     super(title);
     addWindowListener(gf);
   }
      
   public static void main(java.lang.String[] args) {
      try {
         TestFrame tf = new TestFrame("TestFrame");       
         tf.setVisible(true);
      } catch (Throwable e) {
         System.err.println("Erreur");
         e.printStackTrace(System.out);
      }
   }
}