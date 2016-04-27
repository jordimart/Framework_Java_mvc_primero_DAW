package Appweb.Modules.Main.Model.Login.model.BLL_Login;

import Appweb.Modules.Main.Model.Login.model.DAO_Login.DAO_Login;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin_BD;

/**
 *
 * @author jorge
 */
public class BLL_Login {

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
     * Funcion Login Client recoge los datos del txt del login y los guarda en
     * dos singleton user y password.
     * Compara si la entrada es estandard o es un usurio existente.
     * Busca en la base de datos mongo un Client y si existe devuelve true.
     *
     * @return boolean true/false
     */
    public static boolean Login_Client() {

        boolean ok = DAO_Login.find_and_compare_mongo();

        return ok;
    }

    /**
     * Funcion Login User recoge los datos deltxt del login y los gurada en
     * dos singleton user y password.
     * Compara si la entrada standard o es un usuario existente.
     *
     * @return
     */
    public static boolean Login_User() {

        boolean ok = DAO_Login.find_and_compare_files();

        return ok;

    }

    /**
     * Funcion que utiliza un DAO collect data que recoge los datos de los txt
     * del
     * del login.
     */
    public static void collectdata() {

        DAO_Login.collectdata();
    }

    /**
     * Funcion que utiliza un DAO que comprueba si la entrada es
     * standar,Admin,Client
     * User o Test.
     */
    public static void standard_login() {

        DAO_Login.standard_login();
    }

}
