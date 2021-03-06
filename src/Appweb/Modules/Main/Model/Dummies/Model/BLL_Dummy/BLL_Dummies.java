package Appweb.Modules.Main.Model.Dummies.Model.BLL_Dummy;

import Appweb.Classes.ConectionBD;
import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Dummies.Model.DAO_Dummy.DAO_Dummies;
import Appweb.Modules.Main.Model.Dummies.View.task_Dummy_view;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin_BD;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import Appweb.Modules.Users.Client.Model.BLL_Client.BLL_Client_mongo;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;
import Appweb.Modules.Users.Client.Model.DAO_Client.DAO_Client_mongo;
import Appweb.Modules.Users.User_reg.Model.Classes.User_reg;
import Appweb.Modules.Users.User_reg.Model.Classes.singleuser_reg;
import Appweb.Modules.Users.User_reg.Model.DAO_User.DAO_User_file;
import java.awt.Color;
import java.sql.Connection;

/**
 *
 * @author ASUSG50V
 */
public class BLL_Dummies {

    /**
     * Interactua con un menu para crear administradores en la cantidad elegida
     * o cargar de base de datos.
     */
    public static void create_Dummy_admin() {

        boolean pass = false;

        Connection con = ConectionBD.getConexion();

        String combo = task_Dummy_view.comboDummy_admin.getSelectedItem().toString();

        if (combo.equals("cargar")) {

            BLL_Admin_BD.load_BD();

        } else {

            singletonapp.num = Integer.parseInt(combo);

            for (int j = 0; j < singletonapp.num; j++) {

                try {

                    int ok = BLL_Dummy_BD.create_Dummy_adminBD(con);//creamos al admin y lo metemos en la base de datos

                    if (ok == 1) {//si el admin se ha metido bien en la base de datos lo metemos en el arraylist

                        singleadmin.Admin_array.add(singleadmin.a);

                    }

                    if (0 != singleadmin.Admin_array.size()) {

                        task_Dummy_view.labStatus_dummie_admin.setBackground(Color.GREEN);
                        task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Dummies_loaded_successfully"));

                    }

                } catch (Exception e) {

                    task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Error_loading_dummies"));

                }
                pass = true;

            }
            if (pass == true) {
                ConectionBD.liberaConexion(con);

            }

        }
    }

    /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_admin_dummies() {

        if (singleadmin.Admin_array.isEmpty()) {

            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"));

        } else {

            // delete all objects to the
            // arraylist
            BLL_Admin_BD.delete_all_Admin();
            singleadmin.Admin_array.clear();
            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("All_elements_have_been_deleted"));

        }

    }

    /**
     * Interactua con un menu para crear clientes en la cantidad elegida
     * o cargar de base de datos.
     */
    public static void create_Dummy_client() {

        boolean pass = false;

        String combo = task_Dummy_view.comboDummy_client.getSelectedItem().toString();

        if (combo.equals("cargar")) {

            BLL_Client_mongo.load();

        } else {

            singleclient.Client_array.clear();
            singletonapp.num = Integer.parseInt(combo);

            for (int j = 0; j < singletonapp.num; j++) {

                try {

                    Client a = DAO_Dummies.DummyClient();

                    singleclient.Client_array.add(a);

                    if (0 != singleclient.Client_array.size()) {

                        task_Dummy_view.labStatus_dummie_client.setBackground(Color.GREEN);
                        task_Dummy_view.labStatus_dummie_client.setText(Lang.getInstance().getProperty("Dummies_loaded_successfully"));

                    }

                } catch (Exception e) {

                    task_Dummy_view.labStatus_dummie_client.setText(Lang.getInstance().getProperty("Error_loading_dummies"));

                }
                pass = true;

            }
            if (pass == true) {

                BLL_Dummy_mongo.create_Dummy_client_mongo();
            }

        }
    }

    /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_client_dummies() {

        if (singleclient.Client_array.isEmpty()) {

            task_Dummy_view.labStatus_dummie_client.setText(Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"));

        } else {

            // delete all objects to the
            // arraylist
            DAO_Client_mongo.delete_all();
            task_Dummy_view.labStatus_dummie_client.setText(Lang.getInstance().getProperty("All_elements_have_been_deleted"));

        }

    }

    /**
     * Interactua con un menu para crear usuarios registrados en la cantidad
     * elegida
     * o cargar de base de datos.
     */
    public static void create_Dummy_user() {

        boolean pass = false;

        String combo = task_Dummy_view.comboDummy_user.getSelectedItem().toString();

        if (combo.equals("cargar")) {

            DAO_User_file.auto_open_json();

        } else {

            singletonapp.num = Integer.parseInt(combo);

            for (int j = 0; j < singletonapp.num; j++) {

                try {

                    User_reg a = DAO_Dummies.DummyUser_reg();

                    singleuser_reg.User_reg_array.add(a);

                    if (0 != singleuser_reg.User_reg_array.size()) {

                        task_Dummy_view.labStatus_dummie_user.setBackground(Color.GREEN);
                        task_Dummy_view.labStatus_dummie_user.setText(Lang.getInstance().getProperty("Dummies_loaded_successfully"));

                    }

                } catch (Exception e) {

                    task_Dummy_view.labStatus_dummie_user.setText(Lang.getInstance().getProperty("Error_loading_dummies"));

                }
                pass = true;

            }
            if (pass == true) {

                DAO_User_file.auto_save_json();
            }

        }
    }

    /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_user_dummies() {

        if (singleuser_reg.User_reg_array.isEmpty()) {

            task_Dummy_view.labStatus_dummie_user.setText(Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"));

        } else {

            // delete all objects to the
            // arraylist
            singleuser_reg.User_reg_array.clear();
            DAO_User_file.auto_save_json();
            task_Dummy_view.labStatus_dummie_user.setText(Lang.getInstance().getProperty("All_elements_have_been_deleted"));

        }

    }
}
