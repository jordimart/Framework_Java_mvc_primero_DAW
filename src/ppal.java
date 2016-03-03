
import Appweb.Modules.Config.Classes.Classconfig;
import static Appweb.Modules.Config.Model.DAO_config.DAO_config.auto_open_config_json;
import Appweb.Modules.Main.Menu_entrada;
import Appweb.Modules.Users.Users_tools.User_files.json;
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
            json.auto_open_json_file();

            new Menu_entrada().setVisible(true);
        });
    }
}
