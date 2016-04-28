package Appweb.Modules.Users.User_reg.Model.BLL_User;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Users.Admin.Controller.ControllerAdmin;
import static Appweb.Modules.Users.Admin.Model.Classes.Table_Admin_class.datos;
import Appweb.Modules.Users.Admin.View.table_Admin_view;
import Appweb.Modules.Users.Client.Controller.ControllerClient;
import Appweb.Modules.Users.Client.View.table_Client_view;
import Appweb.Modules.Users.User_reg.Controller.ControllerUser;
import static Appweb.Modules.Users.User_reg.Controller.ControllerUser.Table_User;
import Appweb.Modules.Users.User_reg.Model.Classes.Table_User_reg;
import Appweb.Modules.Users.User_reg.Model.Classes.User_reg;
import Appweb.Modules.Users.User_reg.Model.Classes.singleuser_reg;
import Appweb.Modules.Users.User_reg.Model.DAO_User.DAO_User;
import Appweb.Modules.Users.User_reg.Model.DAO_User.DAO_User_file;
import Appweb.Modules.Users.User_reg.Model.Tools.Pager.pagina_user;
import Appweb.Modules.Users.User_reg.View.edit_User_view;
import Appweb.Modules.Users.User_reg.View.show_User_view;
import Appweb.Modules.Users.User_reg.View.table_User_view;
import static Appweb.Modules.Users.User_reg.View.table_User_view.mini_Table_User;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUSG50V
 */
public class BLL_User {

    //////////BLLs del formulario create User_reg view///////
    public static void Enterdni() {
        DAO_User.booleanEnterdni();
    }

    public static void Entername() {
        DAO_User.booleanEntername();
    }

    public static void Enterlast_name() {
        DAO_User.booleanEnterlast_name();
    }

    public static void Entermobile() {
        DAO_User.booleanEntermobile();
    }

    public static void Entermail() {
        DAO_User.booleanEntermail();
    }

    public static void Enteruser() {
        DAO_User.booleanEnteruser();
    }

    public static void Enterpassword() {
        DAO_User.booleanEnterpassword();
    }

    public static void Enteractivity() {
        DAO_User.booleanEnteractivity();

    }

    public static void Enterdate_birth() {
        DAO_User.booleanEnterdate_birth();
    }

    public static void EnterAvatar() {
        DAO_User.EnterAvatar();
    }

    public static boolean Enter_new() {

        boolean ok = false;

        User_reg a = DAO_User.add_create();

        if (a != null) {
            singleuser_reg.User_reg_array.add(a);
            DAO_User_file.auto_save_json();
            ((Table_User_reg) mini_Table_User.getModel()).cargar();
            pagina_user.inicializa();
            pagina_user.initLinkBox();

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

//////////BLLs del formulario edit User_reg view///////
    public static void Editname() {
        DAO_User.booleanEditname();

    }

    public static void Editlast_name() {
        DAO_User.booleanEditlast_name();
    }

    public static void Editmobile() {
        DAO_User.booleanEditmobile();
    }

    public static void Editmail() {
        DAO_User.booleanEditmail();
    }

    public static void Edituser() {
        DAO_User.booleanEdituser();
    }

    public static void Editpassword() {
        DAO_User.booleanEditpassword();
    }

    public static void Editactivity() {
        DAO_User.booleanEditactivity();

    }

    public static void Editdate_birth() {
        DAO_User.booleanEditdate_birth();
    }

    public static void EditAvatar() {
        DAO_User.EditAvatar();
    }

    public static boolean Enter_edited() {

        boolean ok = false;

        User_reg a = DAO_User.modify_edit();

        if (a != null) {
            singleuser_reg.User_reg_array.set(singletonapp.pos, a);
            DAO_User_file.auto_save_json();
            JOptionPane.showMessageDialog(null, "Usuario modificado");

            ok = true;
        } else {

            JOptionPane.showMessageDialog(null, "Revise los datos, no puede guardar si hay algun dato incorrecto");
        }
        return ok;
    }

    //////////BLLs de la parte del table///////////
    public static boolean modifity_select() {
        String dni = "";
        boolean ok = false;
        int selection, inicio, selection1;

        if (((Table_User_reg) table_User_view.mini_Table_User.getModel()).getRowCount() != 0) {
            inicio = (pagina_user.currentPageIndex - 1) * pagina_user.itemsPerPage; //nos situamos al inicio de la pÃ¡gina en cuestiÃ³n
            selection = mini_Table_User.getSelectedRow(); //nos situamos en la fila
            selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pÃ¡gina

            if (selection1 == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);

            } else {

                inicio = (pagina_user.currentPageIndex - 1) * pagina_user.itemsPerPage; //nos situamos al inicio de la pÃ¡gina en cuestiÃ³n
                selection = mini_Table_User.getSelectedRow(); //nos situamos en la fila
                selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pÃ¡gina

                dni = (String) mini_Table_User.getModel().getValueAt(selection1, 0);

                singletonapp.pos = Look_for_dni_user(dni);

                Table_User.dispose();
                new ControllerUser(new edit_User_view(), 2).Start(2);
                DAO_User.Load_edit_user();
                //((Table_User_reg) mini_Table_User.getModel()).cargar();
                //pagina_user.inicializa();
               // pagina_user.initLinkBox();

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacia", "Error!", 2);

            ok = false;
        }
        return ok;
    }

    public static boolean delete_select() {
        String dni = "";
        boolean ok = false;
        int selection, inicio, selection1;

        if (((Table_User_reg) table_User_view.mini_Table_User.getModel()).getRowCount() != 0) {

            inicio = (pagina_user.currentPageIndex - 1) * pagina_user.itemsPerPage; //nos situamos al inicio de la pÃ¡gina en cuestiÃ³n
            selection = mini_Table_User.getSelectedRow(); //nos situamos en la fila
            selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pÃ¡gina

            if (selection1 == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada", "Error!", 2);

            } else {

                dni = (String) mini_Table_User.getModel().getValueAt(selection1, 0);
                singletonapp.pos = Look_for_dni_user(dni);

                ((Table_User_reg) mini_Table_User.getModel()).removeRow(selection1);
                singleuser_reg.User_reg_array.remove(singletonapp.pos);
                DAO_User_file.auto_save_json();
                ((Table_User_reg) mini_Table_User.getModel()).cargar();

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
    public static void Delete_all() {

        if (singleuser_reg.User_reg_array.isEmpty()) {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"),
                    Lang.getInstance().getProperty("Information"), JOptionPane.ERROR_MESSAGE);
        } else {

            // delete all objects to the
            // arraylist
            singleuser_reg.User_reg_array.clear();
            DAO_User_file.auto_save_json();
            ((Table_User_reg) mini_Table_User.getModel()).cargar();
            table_User_view.jLabel3.setText(String.valueOf(datos.size()));
            pagina_user.inicializa();
            pagina_user.initLinkBox();

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("All_elements_have_been_deleted") + "\n"
                    + Lang.getInstance().getProperty("Remaining_number_of_elements") + singleuser_reg.User_reg_array.size());
        }

    }

    public static boolean show_select() {
        String dni = "";
        boolean ok = false;
        int selection, inicio, selection1;

        if (((Table_User_reg) table_User_view.mini_Table_User.getModel()).getRowCount() != 0) {
            inicio = (pagina_user.currentPageIndex - 1) * pagina_user.itemsPerPage; //nos situamos al inicio de la pÃ¡gina en cuestiÃ³n
            selection = mini_Table_User.getSelectedRow(); //nos situamos en la fila
            selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pÃ¡gina

            if (selection1 == -1) {
                ok = false;
                JOptionPane.showMessageDialog(null, "No hay una persona seleccionada");

            } else {
                inicio = (pagina_user.currentPageIndex - 1) * pagina_user.itemsPerPage; //nos situamos al inicio de la pagina en cuestiÃ³n
                selection = mini_Table_User.getSelectedRow(); //nos situamos en la fila
                selection1 = inicio + selection; //nos situamos en la fila correspondiente de esa pagina

                dni = (String) mini_Table_User.getModel().getValueAt(selection1, 0);

                singletonapp.pos = Look_for_dni_user(dni);

                Table_User.dispose();
                new ControllerUser(new show_User_view(), 3).Start(3);

                DAO_User.Load_show();

                ok = true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "lista vacia");

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
    public static int Look_for_dni_user(String dni) {

        int pos = -1;

        for (int i = 0; i < singleuser_reg.User_reg_array.size(); i++) {

            if (singleuser_reg.User_reg_array.get(i).getDni().equals(dni)) {
                pos = i;
            }

        }

        return pos;

    }
    
    public static int Look_for_user(){
        int pos=-1;
        
        for (int i = 0; i < singleuser_reg.User_reg_array.size(); i++) {

            if (singleuser_reg.User_reg_array.get(i).getUser().equals(singletonapp.user)) {
                pos = i;
            }

        }
        return pos;
    }
    
    public static int Look_for_password(){
        int pos=-2;
        
        for (int i = 0; i < singleuser_reg.User_reg_array.size(); i++) {

            if (singleuser_reg.User_reg_array.get(i).getPassword().equals(singletonapp.password)) {
                pos = i;
            }

        }
        return pos;
    }

    

    public static void change_table_user() {

        int i = Table_User.combouser.getSelectedIndex();

        switch (i) {

            case 0:
                Table_User.dispose();
                new ControllerAdmin(new table_Admin_view(), 1).Start(1);

                break;

            case 1:
                Table_User.dispose();
                new ControllerClient(new table_Client_view(), 0).Start(0);

                break;

            case 2:

                JOptionPane.showMessageDialog(null, "Ya esta gestionando Usuarios registrados");

                break;
        }

    }
}
