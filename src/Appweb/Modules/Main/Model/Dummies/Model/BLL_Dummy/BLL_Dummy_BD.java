package Appweb.Modules.Main.Model.Dummies.Model.BLL_Dummy;

import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Dummies.Model.DAO_Dummy.DAO_Dummy_BD;
import Appweb.Modules.Main.Model.Dummies.View.task_Dummy_view;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin_BD;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import java.sql.Connection;

/**
 *
 * @author jorge
 */
public class BLL_Dummy_BD {

    public static int create_Dummy_adminBD(Connection con) {

        int resultado = 0;

        resultado = DAO_Dummy_BD.create_Dummy_adminBD(con);

        return resultado;
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
