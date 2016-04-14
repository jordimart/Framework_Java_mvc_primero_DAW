package Appweb.Modules.Users.Admin.Model.BLL_Admin;

import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Users.Admin.Model.DAO_Admin.DAO_Admin;
import Appweb.Modules.Users.Admin.View.edit_Admin_view;
import Appweb.Modules.Users.Admin.View.table_Admin_view;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Admin.Controller.ControllerAdmin;
import static Appweb.Modules.Users.Admin.Controller.ControllerAdmin.Table_Admin;
import static Appweb.Modules.Users.Admin.Controller.ControllerAdmin.sorter;
import Appweb.Modules.Users.Admin.View.show_Admin_view;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.mini_Table_Admin;
import Appweb.Modules.Users.Admin.Model.Classes.Table_Admin_class;
import Appweb.Modules.Users.Admin.Model.Tools.Pager.pagina;
import Appweb.Modules.Users.Client.Controller.ControllerClient;
import Appweb.Modules.Users.Client.View.table_Client_view;
import Appweb.Modules.Users.User_reg.Controller.ControllerUser;
import Appweb.Modules.Users.User_reg.View.table_User_view;
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

    /**
     * BLL que utiliza un DAO para crear un Administrador con los datos
     * introducidos por un usuario.Añade al Administrador al arraylist y
     * mediante
     * un BLL de Base de datos lo inserta en la base de datos.
     * Retorna un boolean el Administrador se ha insertado con exito.
     *
     * @return boolean
     */
    public static boolean Enter_new_admin() {

        boolean pass = false;
        int ok = 0;

        singleadmin.a = DAO_Admin.add_create_Admin();

        if (singleadmin.a != null) {

            singleadmin.Admin_array.add(singleadmin.a);//introduce en el arrayadmin
            ok = BLL_Admin_BD.save_Admin();//inserta en BD

            if (ok == 1) {

                pass = true;
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("User_created"));

            }
        } else {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Check_data,cannot_save_if_there_is_any_incorrect_data"));
        }
        return pass;
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

    /**
     * BLL que utiliza un DAO para modificar un Administrador con los datos
     * introducidos por un usuario.Añade al Administrador al arraylist en
     * lugar del modificado y mediante
     * un BLL de Base de datos lo modifica en la base de datos.
     * Retorna un boolean el Administrador se ha insertado con exito.
     *
     * @return
     */
    public static boolean Enter_edited_admin() {

        boolean pass = false;
        int ok = 0;

        singleadmin.a = DAO_Admin.modify_edit_Admin();

        if (singleadmin.a != null) {

            ok = BLL_Admin_BD.save_modified_Admin();//modificamos alusuario en la BD
            BLL_Admin_BD.load_BD();// cargamos de BD
            //singleadmin.Admin_array.set(singletonapp.pos, singleadmin.a);

            if (ok == 1) {

                pass = true;
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Modified_user"));

            }
        } else {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Check_data,cannot_save_if_there_is_any_incorrect_data"));
        }
        return pass;
    }

    //////////BLLs de la parte del table///////////
    /**
     * BLL que recoge un dni de Administrador de la fila seleccionada por el
     * usuario y busca si existe, en caso de existir carga la vista de editar y
     * utiliza un DAO para cargar los datos en la vista y poder modificarlos.
     * Retorna un boolean true si se ha encontrado el usuario.
     *
     * @return boolean
     */
    public static boolean modifity_select_admin() {

        String dni = "";
        boolean ok = false;
        int selection, inicio, selection1;

        if (((Table_Admin_class) table_Admin_view.mini_Table_Admin.getModel()).getRowCount() != 0) {
            int selec = table_Admin_view.mini_Table_Admin.getSelectedRow();

            if (selec == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_is_not_a_selected_user"), "Error!", 2);

            } else {

                inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage; //nos situamos al inicio de la pÃ¡gina en cuestiÃ³n
                selection = mini_Table_Admin.getSelectedRow(); //nos situamos en la fila
                selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pÃ¡gina

                dni = (String) mini_Table_Admin.getModel().getValueAt(selection1, 0);//cogemos el valor del dni de la tabla

                singletonapp.pos = Look_for_dni_admin(dni);//buscamos la posicion en el arraylist

                new ControllerAdmin(new edit_Admin_view(), 3).Start(3);//llamamos a la vista de editar
                DAO_Admin.Load_edit_admin();//cargamos los datos del administrador en la vista

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("List_empty"), "Error!", 2);

            ok = false;
        }
        return ok;
    }

    /**
     * BLL que recoge un dni de Administrador de la fila seleccionada por el
     * usuario y busca si existe, en este caso borra alusuario directamente de
     * la BD con el BLL de BD y si se ha ejecutado correctamente carga y
     * actualiza
     * la tabla.
     *
     * @return
     */
    public static boolean delete_select_admin() {

        String dni = "";
        boolean pass = false;
        int selection, inicio, selection1, ok;

        if (((Table_Admin_class) table_Admin_view.mini_Table_Admin.getModel()).getRowCount() != 0) {

            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage; //nos situamos al inicio de la pÃ¡gina en cuestiÃ³n
            selection = mini_Table_Admin.getSelectedRow(); //nos situamos en la fila
            selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pÃ¡gina

            if (selection1 == -1) {
                pass = false;
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_is_not_a_selected_user"), "Error!", 2);

            } else {

                dni = (String) mini_Table_Admin.getModel().getValueAt(selection1, 0);
                singletonapp.pos = Look_for_dni_admin(dni);

                int opc = JOptionPane.showConfirmDialog(null, "Deseas borrar a la persona con DNI: " + dni,
                        "Info", JOptionPane.WARNING_MESSAGE);
                if (opc == 0) {

                    ((Table_Admin_class) mini_Table_Admin.getModel()).removeRow(selection1);

                    ok = BLL_Admin_BD.delete_Admin();

                    if (ok == 1) {

                        ((Table_Admin_class) mini_Table_Admin.getModel()).cargar();
                        pagina.inicializa();
                        pagina.initLinkBox();

                        pass = true;
                    }
                }

            }
        } else {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("List_empty"), "Error!", 2);

            pass = false;
        }
        return pass;
    }

    /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_admin() {

        int ok = 0;

        if (singleadmin.Admin_array.isEmpty()) {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"),
                    Lang.getInstance().getProperty("Information"), JOptionPane.ERROR_MESSAGE);
        } else {

            ok = BLL_Admin_BD.delete_all_Admin();//Borramos de la base de datos todos los Admin

            if (ok != -1) {

                singleadmin.Admin_array.clear();
                ((Table_Admin_class) mini_Table_Admin.getModel()).cargar();
                Table_Admin.mini_Table_Admin.setFillsViewportHeight(true);
                Table_Admin.mini_Table_Admin.setRowSorter(sorter);
                pagina.inicializa();
                pagina.initLinkBox();

                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("All_elements_have_been_deleted") + "\n");
            }
        }

    }

    public static boolean show_select_admin() {

        String dni = "";
        boolean ok = false;
        int selection, inicio, selection1;

        if (((Table_Admin_class) table_Admin_view.mini_Table_Admin.getModel()).getRowCount() != 0) {
            int selec = table_Admin_view.mini_Table_Admin.getSelectedRow();

            if (selec == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_is_not_a_selected_user"));

            } else {
                inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage; //nos situamos al inicio de la pagina en cuestiÃ³n
                selection = mini_Table_Admin.getSelectedRow(); //nos situamos en la fila
                selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pagina

                dni = (String) mini_Table_Admin.getModel().getValueAt(selection1, 0);

                singletonapp.pos = Look_for_dni_admin(dni);

                Table_Admin.dispose();
                new ControllerAdmin(new show_Admin_view(), 4).Start(4);

                DAO_Admin.Load_show_admin();

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("List_empty"));

            ok = false;
        }
        return ok;
    }

    /**
     * Busca un dni introducido en una arraylist Admin y nos devuelve la
     * posicion.
     *
     * @param dni (string)
     *
     * @return pos (int posicion en el array)
     */
    public static int Look_for_dni_admin(String dni) {

        int pos = -1;

        for (int i = 0; i < singleadmin.Admin_array.size(); i++) {

            if (singleadmin.Admin_array.get(i).getDni().equals(dni)) {
                pos = i;
            }

        }

        return pos;

    }

    public static void save_json_admin() {

        DAO_Admin.save_json_admin();
    }

    public static void save_xml_admin() {

        DAO_Admin.save_xml_admin();
    }

    public static void save_txt_admin() {

        DAO_Admin.save_txt_admin();
    }

    public static void auto_open_json_admin() {

        DAO_Admin.auto_open_json_admin();
    }

    public static void auto_save_json_admin() {

        DAO_Admin.auto_save_json_admin();
    }

    public static void change_table_user() {

        int i = Table_Admin.combouser.getSelectedIndex();

        switch (i) {

            case 0:

                JOptionPane.showMessageDialog(null, "Ya esta gestionando administradores");
                break;

            case 1:

                Table_Admin.dispose();
                new ControllerClient(new table_Client_view(), 0).Start(0);
                break;

            case 2:

                Table_Admin.dispose();
                new ControllerUser(new table_User_view(), 0).Start(0);

                break;
        }

    }
}
