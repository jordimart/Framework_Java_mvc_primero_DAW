package Appweb.Modules.Users.Client.Model.BLL_Client;

import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Admin.Controller.ControllerAdmin;
import Appweb.Modules.Users.Admin.View.table_Admin_view;

import Appweb.Modules.Users.Client.Controller.ControllerClient;
import static Appweb.Modules.Users.Client.Controller.ControllerClient.Table_Client;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.Client.Model.Classes.Table_Client_class;
import static Appweb.Modules.Users.Client.Model.Classes.Table_Client_class.datos;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;
import Appweb.Modules.Users.Client.Model.DAO_Client.DAO_Client;
import Appweb.Modules.Users.Client.Model.Tools.Pager.pagina_client;
import Appweb.Modules.Users.Client.View.edit_Client_view;
import Appweb.Modules.Users.Client.View.show_Client_view;
import Appweb.Modules.Users.Client.View.table_Client_view;
import static Appweb.Modules.Users.Client.View.table_Client_view.mini_Table_Client;
import Appweb.Modules.Users.User_reg.Controller.ControllerUser;
import Appweb.Modules.Users.User_reg.View.table_User_view;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUSG50V
 */
public class BLL_Client {

    //////////BLLs del formulario create Admin view///////
    public static void Enterdni_client() {
        DAO_Client.booleanEnterdnic();
    }

    public static void Entername_client() {
        DAO_Client.booleanEntername_client();
    }

    public static void Enterlast_name_client() {
        DAO_Client.booleanEnterlast_name_client();
    }

    public static void Entermobile_client() {
        DAO_Client.booleanEntermobile_client();
    }

    public static void Entermail_client() {
        DAO_Client.booleanEntermail_client();
    }

    public static void Enteruser_client() {
        DAO_Client.booleanEnteruser_client();
    }

    public static void Enterpassword_client() {
        DAO_Client.booleanEnterpassword_client();
    }

    public static void Enterpurchase_client() {
        DAO_Client.booleanEnterpurchase_client();
    }

    public static void Enterdate_birth_client() {
        DAO_Client.booleanEnterdate_birth_client();
    }

    public static void Enterdate_reg_client() {
        DAO_Client.booleanEnterdate_reg_client();
    }

    public static void EnterAvatar_client() {
        DAO_Client.EnterAvatar_client();
    }

    public static boolean Enter_new_client() {

        boolean ok = false;

        Client a = DAO_Client.add_create_client();

        if (a != null) {
            singleclient.Client_array.add(a);
            DAO_Client.auto_save_json_client();
            ((Table_Client_class) mini_Table_Client.getModel()).cargar();
            pagina_client.inicializa();
            pagina_client.initLinkBox();

            JOptionPane.showMessageDialog(null, "Usuario creado");
            //create_Admin_view.lab_information_message.setText("Usuario creado");
            // create_Admin_view.labinfo_img.setIcon(singletonapp.good_data);

            ok = true;
        } else {

            // create_Admin_view.lab_information_message.setText("Revise los datos, no puede guardar si hay algun dato incorrecto");
            //create_Admin_view.labinfo_img.setIcon(singletonapp.wrong_data);
            JOptionPane.showMessageDialog(null, "Revise los datos, no puede guardar si hay algun dato incorrecto");
        }
        return ok;
    }

//////////BLLs del formulario edit Client view///////
    public static void Editname_client() {
        DAO_Client.booleanEditname_client();

    }

    public static void Editlast_name_client() {
        DAO_Client.booleanEditlast_name_client();
    }

    public static void Editmobile_client() {
        DAO_Client.booleanEditmobile_client();
    }

    public static void Editmail_client() {
        DAO_Client.booleanEditmail_client();
    }

    public static void Edituser_client() {
        DAO_Client.booleanEdituser_client();
    }

    public static void Editpassword_client() {
        DAO_Client.booleanEditpassword_client();
    }

    public static void Editsalary_client() {
        DAO_Client.booleanEditpurchase_client();
    }

    public static void Editdate_birth_client() {
        DAO_Client.booleanEditdate_birth_client();
    }

    public static void Editdate_reg_client() {
        DAO_Client.booleanEditdate_reg_client();
    }

    public static void EditAvatar_client() {
        DAO_Client.EditAvatar_client();
    }

    public static boolean Enter_edited_client() {

        boolean ok = false;

        Client c = DAO_Client.modify_edit_client();

        if (c != null) {
            singleclient.Client_array.set(singletonapp.pos, c);
            DAO_Client.auto_save_json_client();
            JOptionPane.showMessageDialog(null, "Usuario modificado");

            ok = true;
        } else {

            JOptionPane.showMessageDialog(null, "Revise los datos, no puede guardar si hay algun dato incorrecto");
        }
        return ok;
    }

    //////////BLLs de la parte del table///////////
    public static boolean modifity_select_client() {
        String dni = "";
        boolean ok = false;
        int selection, inicio, selection1;

        if (((Table_Client_class) table_Client_view.mini_Table_Client.getModel()).getRowCount() != 0) {
            int selec = table_Client_view.mini_Table_Client.getSelectedRow();

            if (selec == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);

            } else {

                inicio = (pagina_client.currentPageIndex - 1) * pagina_client.itemsPerPage; //nos situamos al inicio de la pÃ¡gina en cuestiÃ³n
                selection = mini_Table_Client.getSelectedRow(); //nos situamos en la fila
                selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pÃ¡gina

                dni = (String) mini_Table_Client.getModel().getValueAt(selection1, 0);

                singletonapp.pos = Look_for_dni_client(dni);

                Table_Client.dispose();
                new ControllerClient(new edit_Client_view(), 2).Start(2);
                DAO_Client.Load_edit_client();
                ((Table_Client_class) mini_Table_Client.getModel()).cargar();
                pagina_client.inicializa();
                pagina_client.initLinkBox();

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacia", "Error!", 2);

            ok = false;
        }
        return ok;
    }

    public static boolean delete_select_client() {
        String dni = "";
        boolean ok = false;
        int selection, inicio, selection1;

        if (((Table_Client_class) table_Client_view.mini_Table_Client.getModel()).getRowCount() != 0) {
            //int selec = table_Admin_view.mini_Table_Admin.getSelectedRow();

            inicio = (pagina_client.currentPageIndex - 1) * pagina_client.itemsPerPage; //nos situamos al inicio de la pÃ¡gina en cuestiÃ³n
            selection = mini_Table_Client.getSelectedRow(); //nos situamos en la fila
            selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pÃ¡gina

            if (selection1 == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);

            } else {

                dni = (String) mini_Table_Client.getModel().getValueAt(selection1, 0);
                singletonapp.pos = Look_for_dni_client(dni);

                ((Table_Client_class) mini_Table_Client.getModel()).removeRow(selection1);
                singleclient.Client_array.remove(singletonapp.pos);
                DAO_Client.auto_save_json_client();

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacia", "Error!", 2);

            ok = false;
        }
        return ok;
    }

    /**
     * Borra todos los usuarios admin
     */
    public static void Delete_all_client() {

        if (singleclient.Client_array.isEmpty()) {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"),
                    Lang.getInstance().getProperty("Information"), JOptionPane.ERROR_MESSAGE);
        } else {

            // delete all objects to the
            // arraylist
            singleclient.Client_array.clear();
            DAO_Client.auto_save_json_client();
            ((Table_Client_class) mini_Table_Client.getModel()).cargar();
            table_Client_view.jLabel3.setText(String.valueOf(datos.size()));
            pagina_client.inicializa();
            pagina_client.initLinkBox();

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("All_elements_have_been_deleted") + "\n"
                    + Lang.getInstance().getProperty("Remaining_number_of_elements") + singleclient.Client_array.size());
        }

    }

    public static boolean show_select_client() {
        String dni = "";
        boolean ok = false;
        int selection, inicio, selection1;

        if (((Table_Client_class) table_Client_view.mini_Table_Client.getModel()).getRowCount() != 0) {
            int selec = table_Client_view.mini_Table_Client.getSelectedRow();

            if (selec == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada");

            } else {
                inicio = (pagina_client.currentPageIndex - 1) * pagina_client.itemsPerPage; //nos situamos al inicio de la pagina en cuestiÃ³n
                selection = mini_Table_Client.getSelectedRow(); //nos situamos en la fila
                selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pagina

                dni = (String) mini_Table_Client.getModel().getValueAt(selection1, 0);

                singletonapp.pos = Look_for_dni_client(dni);

                Table_Client.dispose();
                new ControllerClient(new show_Client_view(), 3).Start(3);

                DAO_Client.Load_show_client();

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacia");

            ok = false;
        }
        return ok;
    }

    /**
     * Busca un dni introducido en una arraylist Client y nos devuelve la
     * posicion.
     *
     * @param dni (string)
     *
     * @return pos (int posicion en el array)
     */
    public static int Look_for_dni_client(String dni) {

        int pos = -1;

        for (int i = 0; i < singleclient.Client_array.size(); i++) {

            if (singleclient.Client_array.get(i).getDni().equals(dni)) {
                pos = i;
            }

        }

        return pos;

    }

    public static void save_json_client() {

        DAO_Client.save_json_client();
    }

    public static void save_xml_client() {

        DAO_Client.save_xml_client();
    }

    public static void save_txt_client() {

        DAO_Client.save_txt_client();
    }

    public static void auto_open_json_client() {

        DAO_Client.auto_open_json_client();
    }

    public static void auto_save_json_client() {

        DAO_Client.auto_save_json_client();
    }

    public static void change_table_user() {

        int i = Table_Client.combouser.getSelectedIndex();

        switch (i) {

            case 0:
                Table_Client.dispose();
                new ControllerAdmin(new table_Admin_view(), 1).Start(1);

                break;

            case 1:
                JOptionPane.showMessageDialog(null, "Ya esta gestionando Clientes");

                break;

            case 2:

                Table_Client.dispose();
                new ControllerUser(new table_User_view(), 0).Start(0);

                break;
        }

    }
}
