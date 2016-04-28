package Appweb.Modules.Main.Model.Login.model.DAO_Login;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.View.menu_Input;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin_BD;
import Appweb.Modules.Users.Client.Model.DAO_Client.DAO_Client_mongo;
import Appweb.Modules.Users.User_reg.Model.BLL_User.BLL_User;
import Appweb.Modules.Users.User_reg.Model.DAO_User.DAO_User_file;

/**
 *
 * @author jorge
 */
public class DAO_Login {

    /**
     * Funcion que recoge los datos de los txtfield del login y los guarda en
     * variables singleton user y password para utilizarlas despues.
     */
    public static void collectdata() {

        char[] password = menu_Input.txt_password.getPassword();

        singletonapp.user = menu_Input.txt_user.getText();
        singletonapp.password = new String(password);

    }

    /**
     * Funcion de entrada standard para entrar en cada tipo de usuario con una
     * entrada
     * sin usuario.
     */
    public static void standard_login() {

        if (singletonapp.user.equals("Admin") && singletonapp.password.equals("Admin")) {

            singletonapp.type = 0;
        } else if (singletonapp.user.equals("Client") && singletonapp.password.equals("Client")) {

            singletonapp.type = 1;
        } else if (singletonapp.user.equals("User") && singletonapp.password.equals("User")) {

            singletonapp.type = 2;
        } else if (singletonapp.user.equals("Test") && singletonapp.password.equals("Test")) {

            singletonapp.type = 3;
        } else {

            singletonapp.type = -1;
        }

    }

    /**
     * Funcion Login Admin recoge los datos del txt login y los guarda en dos
     * singleton.
     * Compara si la entrada es standard o es un usuario existente.
     * Busca en la base de datos sql un admin y si existe devuelve un true.
     *
     * @return boolean true/false
     */
    public static boolean Login_Admin() {

        boolean ok = BLL_Admin_BD.find_in_BD();

        return ok;
    }

    /**
     * Funcion que utilizaremos para comprar las entradas del login con la base
     * de
     * datos mongo y con ello saber si existe el usuario y es correcta la
     * contraseña.
     *
     * @return
     */
    public static boolean find_and_compare_mongo() {

        boolean ok = false;

        ok = DAO_Client_mongo.find_in_mongo();

        if (ok == true) {

            ok = true;

        } else {

            ok = false;
        }

        return ok;
    }

    /**
     * Funcion DAO que utilizaremos para buscar un user en ficheros y sacar sus
     * datospara comparar.
     * Cargamos en Array list.
     * Buscamos alusuario por user y si existe comprobamos sus datos con el
     * login.
     * Si es cierto devuelve true.
     *
     * @return boolean true/false.
     */
    public static boolean find_and_compare_files() {

        boolean ok = false;
        int comp = 0;

        DAO_User_file.auto_open_json();
        singletonapp.pos = BLL_User.Look_for_user();
        comp = BLL_User.Look_for_password();

        if (singletonapp.pos == comp) {

            ok = true;
        }

        return ok;
    }

}
