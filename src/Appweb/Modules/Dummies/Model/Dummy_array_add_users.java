package Appweb.Modules.Dummies.Model;

import Appweb.Modules.Dummies.Model.DAO_Dummy.Dummy_tools;
import javax.swing.JOptionPane;

import Appweb.Modules.Config.Classes.Classconfig;
import Appweb.Modules.Config.Classes.Language.Lang;
import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import Appweb.Modules.Users.Classes.Client;
import Appweb.Modules.Users.Classes.User_reg;
import Appweb.Modules.Users.Classes.singleton;
import Appweb.Modules.Users.Users_tools.User_files.json;
import Appweb.Modules.Users.Users_tools.User_files.txt;
import Appweb.Modules.Users.Users_tools.User_files.xml;
import Appweb.General_tools.Menu;

/**
 *
 * @author Jorge Martinez Frias
 *
 */
public class Dummy_array_add_users {

   

    /**
     * This function asks if the user wants to work with dummies . Creates 1-10
     * dummies with random data . When the dummies are created save data in
     * three types of files.
     *
     */
    public static void Dummyrequest() {

        int quest = 0;
        Admin a = null;
        Client c = null;
        User_reg u = null;

        quest = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_work_with_dummies?"), "Menu dummies");

        if (quest == 0) {

            Classconfig.getInstance().setDummy(true);

            singleton.Admin_array.clear();
            singleton.Client_array.clear();
            singleton.User_reg_array.clear();
            int num = 0;
            String numero = " ";
            String[] menu = {Lang.getInstance().getProperty("Upload_files"), "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
            boolean pass = false;

            numero = (String) Menu.menucombobox(menu, Lang.getInstance().getProperty("How_many_do_you_want_to_create_dummies?"), "Dummies");

            if (numero.equals(Lang.getInstance().getProperty("Upload_files"))) {

                json.auto_open_json_file_dummy();

            } else {

                num = Integer.parseInt(numero);

                for (int j = 0; j < num; j++) {

                    try {

                        a = Dummy_tools.Dummyadmin();
                        singleton.Admin_array.add(a);

                        c = Dummy_tools.DummyClient();
                        singleton.Client_array.add(c);

                        u = Dummy_tools.DummyUser_reg();
                        singleton.User_reg_array.add(u);

                    } catch (Exception e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_dummies"), "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    pass = true;

                }

                if (pass == true) {

                    json.auto_save_json_file_dummy_admin();

                }
            }

        } else {

            Classconfig.getInstance().setDummy(false);

        }//fin del else cuando es falso

    }

    /**
     * Creates 10 dummies with random data . When the dummies are created save
     * data in three types of files.
     *
     */
    public static void Dummyrequest_init_10() {

        Admin a = null;
        Client c = null;
        User_reg u = null;

        singleton.Admin_array.clear();
        singleton.Client_array.clear();
        singleton.User_reg_array.clear();
        boolean pass = false;

        for (int j = 0; j < 10; j++) {

            try {

                a = Dummy_tools.Dummyadmin();
                singleton.Admin_array.add(a);

                c = Dummy_tools.DummyClient();
                singleton.Client_array.add(c);

                u = Dummy_tools.DummyUser_reg();
                singleton.User_reg_array.add(u);

            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_dummies"), "Error", JOptionPane.ERROR_MESSAGE);
            }

            pass = true;

        }

        if (pass == true) {

            xml.auto_save_xml_file_dummy();
            txt.auto_save_txt_file_dummy();
            json.auto_save_json_file_dummy_admin();

        }

    }

}
