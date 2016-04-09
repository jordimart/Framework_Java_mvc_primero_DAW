package Appweb.Modules.Main.Model.Dummies.Model.BLL_Dummy;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Dummies.Model.DAO_Dummy.DAO_Dummies;
import Appweb.Modules.Main.Model.Dummies.View.task_Dummy_view;
import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;
import Appweb.Modules.Users.User_reg.Model.Classes.User_reg;
import Appweb.Modules.Users.User_reg.Model.Classes.singleuser_reg;
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

        } else {

            // delete all objects to the
            // arraylist
            singleadmin.Admin_array.clear();
            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("All_elements_have_been_deleted"));

        }

    }

    public static void create_Dummy_client() {
        Client a = null;
        String combo = "";
        boolean pass = false;

        combo = task_Dummy_view.comboDummy_client.getSelectedItem().toString();

        if (combo.equals("cargar")) {

            DAO_Dummies.auto_open_json_dummy_client();

        } else {

            singletonapp.num = Integer.parseInt(combo);

            for (int j = 0; j < singletonapp.num; j++) {

                try {

                    a = DAO_Dummies.DummyClient();

                    singleclient.Client_array.add(a);

                    if (0 != singleclient.Client_array.size()) {

                        task_Dummy_view.labStatus_dummie_client.setBackground(Color.GREEN);
                        task_Dummy_view.labStatus_dummie_client.setText(Lang.getInstance().getProperty("Dummies_loaded_successfully"));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    task_Dummy_view.labStatus_dummie_client.setText(Lang.getInstance().getProperty("Error_loading_dummies"));

                }
                pass = true;

            }
            if (pass == true) {

                DAO_Dummies.auto_save_json_dummy_client();
            }

        }
    }

    /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_client_dummies() {

        if (singleclient.Client_array.size() == 0) {

            task_Dummy_view.labStatus_dummie_client.setText(Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"));

        } else {

            // delete all objects to the
            // arraylist
            singleclient.Client_array.clear();
            task_Dummy_view.labStatus_dummie_client.setText(Lang.getInstance().getProperty("All_elements_have_been_deleted"));

        }

    }

    public static void create_Dummy_user() {
        User_reg a = null;
        String combo = "";
        boolean pass = false;

        combo = task_Dummy_view.comboDummy_user.getSelectedItem().toString();

        if (combo.equals("cargar")) {

            DAO_Dummies.auto_open_json_dummy_user();

        } else {

            singletonapp.num = Integer.parseInt(combo);

            for (int j = 0; j < singletonapp.num; j++) {

                try {

                    a = DAO_Dummies.DummyUser_reg();

                    singleuser_reg.User_reg_array.add(a);

                    if (0 != singleuser_reg.User_reg_array.size()) {

                        task_Dummy_view.labStatus_dummie_user.setBackground(Color.GREEN);
                        task_Dummy_view.labStatus_dummie_user.setText(Lang.getInstance().getProperty("Dummies_loaded_successfully"));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    task_Dummy_view.labStatus_dummie_user.setText(Lang.getInstance().getProperty("Error_loading_dummies"));

                }
                pass = true;

            }
            if (pass == true) {

                DAO_Dummies.auto_save_json_dummy_user();
            }

        }
    }

    /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_user_dummies() {

        if (singleuser_reg.User_reg_array.size() == 0) {

            task_Dummy_view.labStatus_dummie_user.setText(Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"));

        } else {

            // delete all objects to the
            // arraylist
            singleuser_reg.User_reg_array.clear();
            task_Dummy_view.labStatus_dummie_user.setText(Lang.getInstance().getProperty("All_elements_have_been_deleted"));

        }

    }
}
