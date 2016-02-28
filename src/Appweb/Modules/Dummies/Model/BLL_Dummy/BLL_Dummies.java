/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Dummies.Model.BLL_Dummy;

import Appweb.Classes.Language.Lang;
import Appweb.General_tools.singletonapp;
import Appweb.Modules.Dummies.Model.DAO_Dummy.Dummy_tools;
import Appweb.Modules.Dummies.View.task_Dummy_view;
import Appweb.Modules.Users.Classes.Admin;
import Appweb.Modules.Users.Classes.singleton;
import Appweb.Modules.Users.Users_tools.User_files.json;
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

            json.auto_open_json_file_dummy();

        } else {

            singletonapp.num = Integer.parseInt(combo);

            for (int j = 0; j < singletonapp.num; j++) {

                try {

                    a = Dummy_tools.Dummyadmin();
                    singleton.Admin_array.add(a);

                    if (0 != singleton.Admin_array.size()) {

                        task_Dummy_view.labStatus_dummie_admin.setBackground(Color.GREEN);
                        task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Dummies_loaded_successfully"));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Error_loading_dummies"));
                    //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_dummies"), "Error", JOptionPane.ERROR_MESSAGE);
                }
                pass = true;
            }
            if (pass == true) {

                json.auto_save_json_file_dummy_admin();

            }

        }
    }

    /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_admin_dummies() {

        if (singleton.Admin_array.size() == 0) {

            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"));

            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.ERROR_MESSAGE);
        } else {

            // delete all objects to the
            // arraylist
            singleton.Admin_array.clear();
            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("All_elements_have_been_deleted"));
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("All_elements_have_been_deleted") + "\n"
            //+ Lang.getInstance().getProperty("Remaining_number_of_elements") + singleton.Admin_array.size());
        }

    }
}
