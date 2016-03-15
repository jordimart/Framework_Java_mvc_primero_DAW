
import Appweb.Modules.Config.Classes.Classconfig;
import static Appweb.Modules.Config.Model.DAO_config.DAO_config.auto_open_config_json;
import Appweb.Modules.Main.Menu_entrada;
import Appweb.Modules.Users.Admin.Model.DAO_Admin.DAO_Admin;

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
            DAO_Admin.auto_open_json_admin();

            new Menu_entrada().setVisible(true);
        });
    }
}
