
import Appweb.Modules.Config.Classconfig;
import static Appweb.Modules.Config.Config_tools.auto_open_config_json;
import Appweb.Modules.Main.Menu_entrada;
import java.text.ParseException;
import javax.swing.ImageIcon;

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
                 auto_open_config_json();
               
                new Menu_entrada().setVisible(true);
                 

               
            }
        });
    }
}
