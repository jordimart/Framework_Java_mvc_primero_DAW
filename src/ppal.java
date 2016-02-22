
import Appweb.Modules.Config.Classconfig;
import static Appweb.Modules.Config.Config_tools.auto_open_config_json;
import Appweb.Modules.Main.Menu_entrada;
import java.text.ParseException;



/**
 *
 * @author ASUSG50V
 */
public class ppal {
    
   
   
     public static void main(String args[]) throws ParseException {
       
      

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Classconfig.getInstance();
            auto_open_config_json();
            
            new Menu_entrada().setVisible(true);
        });
    }
}
