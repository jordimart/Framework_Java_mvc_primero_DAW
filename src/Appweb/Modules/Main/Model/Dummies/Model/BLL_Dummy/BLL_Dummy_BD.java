package Appweb.Modules.Main.Model.Dummies.Model.BLL_Dummy;

import Appweb.Classes.ConectionBD;
import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Dummies.Model.DAO_Dummy.DAO_Dummy_BD;
import Appweb.Modules.Main.Model.Dummies.View.task_Dummy_view;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin_BD;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import java.awt.Color;
import java.sql.Connection;

/**
 *
 * @author jorge
 */
public class BLL_Dummy_BD {

    public static void create_Dummy_admin() {

        String combo = "";
        boolean pass = false;
        int ok = 0;

        Connection con = null;
        con = ConectionBD.getConexion();

        combo = task_Dummy_view.comboDummy_admin.getSelectedItem().toString();

        if (combo.equals("cargar")) {

            BLL_Admin_BD.load_BD();

        } else {

            singletonapp.num = Integer.parseInt(combo);

            for (int j = 0; j < singletonapp.num; j++) {

                try {

                    ok = DAO_Dummy_BD.create_Dummy_adminBD(con);//creamos al admin y lo metemos en la base de datos

                    if (ok == 1) {//si el admin se ha metido bien en la base de datos lo metemos en el arraylist

                        singleadmin.Admin_array.add(singleadmin.a);

                    }

                    if (0 != singleadmin.Admin_array.size()) {

                        task_Dummy_view.labStatus_dummie_admin.setBackground(Color.GREEN);
                        task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Dummies_loaded_successfully"));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Error_loading_dummies"));

                }
                pass = true;

            }
            if (pass == true) {
                ConectionBD.liberaConexion(con);

            }

        }
    }

    public static void Delete_all_admin_dummies_BD() {

        if (singleadmin.Admin_array.size() == 0) {

            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"));

        } else {

            // delete all objects to the
            // arraylist
            BLL_Admin_BD.delete_all_Admin();
            singleadmin.Admin_array.clear();
            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("All_elements_have_been_deleted"));

        }

    }

}
