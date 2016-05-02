
import Appweb.Modules.Main.Controller.ControllerMain;
import static Appweb.Modules.Main.Controller.ControllerMain.Login;
import Appweb.Modules.Main.Model.Config.Classes.Classconfig;
import Appweb.Modules.Main.Model.Login.View.menu_Input;

/**
 *Rama login
 * @author ASUSG50V
 */
public class ppal {

    public static void main(String args[]) {
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            Classconfig.getInstance();

            new ControllerMain(new menu_Input(), 0).Start(0);
            Login.setVisible(true);
            
        });
    }
}
