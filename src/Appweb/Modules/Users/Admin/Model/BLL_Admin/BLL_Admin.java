package Appweb.Modules.Users.Admin.Model.BLL_Admin;

import Appweb.Modules.Config.Classes.Language.Lang;
import Appweb.Modules.Users.Admin.Model.DAO_Admin.DAO_Admin;
import Appweb.Modules.Users.Admin.View.edit_Admin_view;
import Appweb.Modules.Users.Admin.View.table_Admin_view;
import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import Appweb.Modules.Users.Classes.singleton;
import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Admin.View.create_Admin_view;
import Appweb.Modules.Users.Admin.View.show_Admin_view;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.mini_Table_Admin;
import Appweb.Modules.Users.Admin.Model.Classes.Table_Admin;
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

    public static boolean Enter_new_admin() throws InterruptedException {

        boolean ok = false;

        Admin a = DAO_Admin.add_create_Admin();

        if (a != null) {
            singleton.Admin_array.add(a);
            json.auto_save_json_file();

            create_Admin_view.Information_dialog.setVisible(true);
            create_Admin_view.lab_information_message.setText("Usuario modificado");
            create_Admin_view.labinfo_img.setIcon(singletonapp.good_data);

            Thread.sleep(5000);
            create_Admin_view.Information_dialog.setVisible(false);
            // JOptionPane.showMessageDialog(null, "Usuario añadidio");

            ok = true;
        } else {

            create_Admin_view.Information_dialog.setVisible(true);
            create_Admin_view.lab_information_message.setText("Revise los datos, no puede guardar si hay algun dato incorrecto");
            create_Admin_view.labinfo_img.setIcon(singletonapp.wrong_data);

            //Thread.sleep(5000);
            //create_Admin_view.Information_dialog.setVisible(false);
            JOptionPane.showMessageDialog(null, "Revise los datos, no puede guardar si hay algun dato incorrecto");
        }
        return ok;
    }

    //////////BLLs del formulario edit Admin view///////
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
    public static boolean modifity_select_admin() {
        String dni = "";
        boolean ok = false;

        if (((Table_Admin) table_Admin_view.mini_Table_Admin.getModel()).getRowCount() != 0) {
            int selec = table_Admin_view.mini_Table_Admin.getSelectedRow();

            if (selec == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);

            } else {

                dni = (String) table_Admin_view.mini_Table_Admin.getModel().getValueAt(selec, 0);

                singletonapp.pos = Look_for_dni_admin(dni);

                new edit_Admin_view().setVisible(true);
                DAO_Admin.Load_edit_admin();

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);

            ok = false;
        }
        return ok;
    }

    public static boolean delete_select_admin() {
        String dni = "";
        boolean ok = false;

        if (((Table_Admin) table_Admin_view.mini_Table_Admin.getModel()).getRowCount() != 0) {
            int selec = table_Admin_view.mini_Table_Admin.getSelectedRow();

            if (selec == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);

            } else {

                dni = (String) table_Admin_view.mini_Table_Admin.getModel().getValueAt(selec, 0);

                singletonapp.pos = Look_for_dni_admin(dni);

                singleton.Admin_array.remove(singletonapp.pos);
                json.auto_save_json_file();
                ((Table_Admin) mini_Table_Admin.getModel()).cargar();

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacía", "Error!", 2);

            ok = false;
        }
        return ok;
    }
    
     /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_admin() {

        if (singleton.Admin_array.isEmpty()) {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"),
                    Lang.getInstance().getProperty("Information"), JOptionPane.ERROR_MESSAGE);
        } else {

            // delete all objects to the
            // arraylist
            
            singleton.Admin_array.clear();
            json.auto_save_json_file();
            ((Table_Admin) mini_Table_Admin.getModel()).cargar();

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("All_elements_have_been_deleted") + "\n"
                    + Lang.getInstance().getProperty("Remaining_number_of_elements") + singleton.Admin_array.size());
        }

    }

    public static boolean show_select_admin() {
        String dni = "";
        boolean ok = false;

        if (((Table_Admin) table_Admin_view.mini_Table_Admin.getModel()).getRowCount() != 0) {
            int selec = table_Admin_view.mini_Table_Admin.getSelectedRow();

            if (selec == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada");

            } else {

                dni = (String) table_Admin_view.mini_Table_Admin.getModel().getValueAt(selec, 0);

                singletonapp.pos = Look_for_dni_admin(dni);

                show_Admin_view menu = new show_Admin_view();
                menu.setVisible(true);
                DAO_Admin.Load_show_admin();

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacía");

            ok = false;
        }
        return ok;
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

   
}
