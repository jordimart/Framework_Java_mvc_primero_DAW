package Appweb.Modules.Main.Model.Dummies.Model.BLL_Dummy;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Dummies.Model.DAO_Dummy.DAO_Dummies;
import Appweb.Modules.Main.Model.Dummies.View.task_Dummy_view;
import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import java.awt.Color;

/**
 *
 * @author ASUSG50V
 */
public class BLL_Dummies {

    public static void create_Dummy_admin() {
        Admin a = null;
        String combo = "";
        boolean pass = false;

        combo = task_Dummy_view.comboDummy_admin.getSelectedItem().toString();

        if (combo.equals("cargar")) {

            DAO_Dummies.auto_open_json_dummy_admin();

        } else {

            singletonapp.num = Integer.parseInt(combo);

            for (int j = 0; j < singletonapp.num; j++) {

                try {

                    a = DAO_Dummies.Dummyadmin();

                    singleadmin.Admin_array.add(a);

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

                DAO_Dummies.auto_save_json_dummy_admin();
            }

        }
    }

    /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_admin_dummies() {

        if (singleadmin.Admin_array.size() == 0) {

            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"));

            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.ERROR_MESSAGE);
        } else {

            // delete all objects to the
            // arraylist
            singleadmin.Admin_array.clear();
            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("All_elements_have_been_deleted"));
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("All_elements_have_been_deleted") + "\n"
            //+ Lang.getInstance().getProperty("Remaining_number_of_elements") + singleton.Admin_array.size());
        }

    }
}
