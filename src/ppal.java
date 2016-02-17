
import Appweb.Modules.Config.Classconfig;
import Appweb.Modules.Main.Menu_entrada;
import java.text.ParseException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUSG50V
 */
public class ppal {
     public static void main(String args[]) throws ParseException {
       
      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Classconfig.getInstance();
               
                new Menu_entrada().setVisible(true);
                 

               
            }
        });
    }
}
