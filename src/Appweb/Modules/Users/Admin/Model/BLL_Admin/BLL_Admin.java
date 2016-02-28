package Appweb.Modules.Users.Admin.Model.BLL_Admin;

import Appweb.Classes.Language.Lang;
import Appweb.Modules.Users.Admin.Model.DAO_Admin.DAO_Admin;
import Appweb.Modules.Users.Admin.View.edit_Admin_view;
import Appweb.Modules.Users.Admin.View.table_Admin_view;
import Appweb.Modules.Users.Classes.Admin;
import Appweb.Modules.Users.Classes.singleton;
import Appweb.General_tools.Menu;
import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Admin.View.show_Admin_view;
import Appweb.Modules.Users.Users_tools.User_files.json;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUSG50V
 */
public class BLL_Admin {

    //////////BLLs del formulario create Admin view///////
    public static void Enterdni_admin() {
        DAO_Admin.booleanEnterdnia();
    }

    public static void Entername_admin() {
        DAO_Admin.booleanEntername_admin();
    }

    public static void Enterlast_name_admin() {
        DAO_Admin.booleanEnterlast_name_admin();
    }

    public static void Entermobile_admin() {
        DAO_Admin.booleanEntermobile_admin();
    }

    public static void Entermail_admin() {
        DAO_Admin.booleanEntermail_admin();
    }

    public static void Enteruser_admin() {
        DAO_Admin.booleanEnteruser_admin();
    }

    public static void Enterpassword_admin() {
        DAO_Admin.booleanEnterpassword_admin();
    }

    public static void Entersalary_admin() {
        DAO_Admin.booleanEntersalary_admin();
    }

    public static void Enteractivity_admin() {
        DAO_Admin.booleanEnteractivity_admin();

    }

    public static void Enterdate_birth_admin() {
        DAO_Admin.booleanEnterdate_birth_admin();
    }

    public static void Enterdate_contr_admin() {
        DAO_Admin.booleanEnterdate_contr_admin();
    }

    public static void EnterAvatar_admin() {
        DAO_Admin.EnterAvatar_admin();
    }

    public static boolean Enter_new_admin() {

        boolean ok = false;

        Admin a = DAO_Admin.add_create_Admin();

        if (a != null) {
            singleton.Admin_array.add(a);
            json.auto_save_json_file();
            JOptionPane.showMessageDialog(null, "Usuario añadidio");

            ok = true;
        } else {

            JOptionPane.showMessageDialog(null, "Revise los datos, no puede guardar si hay algun dato incorrecto");
        }
        return ok;
    }

    //////////BLLs del formulario edit Admin view///////
    public static void Editdni_admin() {

    }

    public static void Editname_admin() {
        DAO_Admin.booleanEditname_admin();

    }

    public static void Editlast_name_admin() {
        DAO_Admin.booleanEditlast_name_admin();
    }

    public static void Editmobile_admin() {
        DAO_Admin.booleanEditmobile_admin();
    }

    public static void Editmail_admin() {
        DAO_Admin.booleanEditmail_admin();
    }

    public static void Edituser_admin() {
        DAO_Admin.booleanEdituser_admin();
    }

    public static void Editpassword_admin() {
        DAO_Admin.booleanEditpassword_admin();
    }

    public static void Editsalary_admin() {
        DAO_Admin.booleanEditsalary_admin();
    }

    public static void Editactivity_admin() {
        DAO_Admin.booleanEditactivity_admin();

    }

    public static void Editdate_birth_admin() {
        DAO_Admin.booleanEditdate_birth_admin();
    }

    public static void Editdate_contr_admin() {
        DAO_Admin.booleanEditdate_contr_admin();
    }

    public static void EditAvatar_admin() {
        DAO_Admin.EditAvatar_admin();
    }

    public static boolean Enter_edited_admin() {

        boolean ok = false;

        Admin a = DAO_Admin.modify_edit_Admin();

        if (a != null) {
            singleton.Admin_array.set(singletonapp.pos, a);
            json.auto_save_json_file();
            JOptionPane.showMessageDialog(null, "Usuario añadidio");

            ok = true;
        } else {

            JOptionPane.showMessageDialog(null, "Revise los datos, no puede guardar si hay algun dato incorrecto");
        }
        return ok;
    }

    //////////BLLs de la parte del table///////////
    /**
     * Imprime un usuario seleccionado admin
     */
    public static void Print_select_admin() {

        Admin a;
        String s = " ";
        String dni = "";
       // int pos = 0;
        int n = singleton.Admin_array.size();
        String cli[] = new String[n];

        if (0 != singleton.Admin_array.size()) {
            for (int i = 0; i < n; i++) {
                a = (Admin) singleton.Admin_array.get(i);
                s = a.getDni() + " - " + a.getName() + " " + a.getLast_name();
                cli[i] = s;
            }
            String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));

            for (int j = 0; j < 9; j++) {

                try {
                    dni += se.charAt(j);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            singletonapp.pos = Look_for_dni_admin(dni);
            show_Admin_view menu = new show_Admin_view();
            menu.setVisible(true);
            DAO_Admin.Load_show_admin();

        } else {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_administrator_type"));
        }
    }

    /**
     * Busca un dni introducido en una arraylist Admin y nos devuelve la
     * posicion.
     *
     * @param dni (string)
     * @return pos (int posicion en el array)
     */
    public static int Look_for_dni_admin(String dni) {

        int pos = -1;

        for (int i = 0; i < singleton.Admin_array.size(); i++) {

            if (singleton.Admin_array.get(i).getDni().equals(dni)) {
                pos = i;
            }

        }

        return pos;

    }

    /**
     * Carga los datos del usuario admin selecionado en el formulario modify
     * admin.
     */
    public static void Modify_select_admin() {

        Admin a;
        String s = " ";
        String dni = "";
        //int pos = 0;
        int n = singleton.Admin_array.size();
        String cli[] = new String[n];
        if (!singleton.Admin_array.isEmpty()) {
            for (int i = 0; i < n; i++) {
                a = (Admin) singleton.Admin_array.get(i);
                s = a.getDni() + " - " + a.getName() + " " + a.getLast_name();
                cli[i] = s;
            }
            String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));

            for (int j = 0; j < 9; j++) {

                dni += se.charAt(j);
            }

            singletonapp.pos = Look_for_dni_admin(dni);

            new edit_Admin_view().setVisible(true);
            DAO_Admin.Load_edit_admin();

        } else {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_administrator_type"));
            new table_Admin_view().setVisible(true);
        }

    }

    /**
     * Borra el usuario seleccionado admin.
     */
    public static void Delete_select_admin() {

        Admin a;
        String s = " ";
        String dni = "";
        // int pos = 0;
        int n = singleton.Admin_array.size();
        String cli[] = new String[n];

        if (!singleton.Admin_array.isEmpty()) {
            for (int i = 0; i < n; i++) {
                a = (Admin) singleton.Admin_array.get(i);
                s = a.getDni() + " - " + a.getName() + " " + a.getLast_name();
                cli[i] = s;
            }
            String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));

            for (int j = 0; j < 9; j++) {

                try {
                    dni += se.charAt(j);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            singletonapp.pos = Look_for_dni_admin(dni);

            singleton.Admin_array.remove(singletonapp.pos);
            json.auto_save_json_file();

        } else {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_administrator_type"));
        }
    }

    /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_admin() {

        if (singleton.Admin_array.isEmpty()) {

            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.ERROR_MESSAGE);
        } else {

            // delete all objects to the
            // arraylist
            singleton.Admin_array.clear();
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("All_elements_have_been_deleted") + "\n"
            //+ Lang.getInstance().getProperty("Remaining_number_of_elements") + singleton.Admin_array.size());
        }

    }
}
