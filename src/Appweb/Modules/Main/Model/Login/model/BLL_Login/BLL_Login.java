package Appweb.Modules.Main.Model.Login.model.BLL_Login;

import Appweb.Modules.Main.Model.Login.model.DAO_Login.DAO_Login;

/**
 *
 * @author jorge
 */
public class BLL_Login {

    /**
     * Funcion Login Admin recoge los datos del txt login y los guarda en dos
     * singleton.
     * Utiliza un DAO que busca al usuario y su pasword en sql y nos dice si
     * existe.
     *
     * @return boolean true/false
     */
    public static boolean Login_Admin() {

        boolean ok = DAO_Login.Login_Admin();

        return ok;
    }

    /**
     * Funcion Login Client recoge los datos del txt del login y los guarda en
     * dos singleton user y password.
     * Compara si la entrada es estandard o es un usurio existente.
     * Utiliza un DAO que busca al usuario y su pasword en mongo y nos dice si
     * existe.
     *
     * @return boolean true/false
     */
    public static boolean Login_Client() {

        boolean ok = DAO_Login.find_and_compare_mongo();

        return ok;
    }

    /**
     * Funcion Login User recoge los datos del txt del login y los gurada en
     * dos singleton user y password.
     * Compara si la entrada standard o es un usuario existente.
     * Utiliza un Daoque busca en ficheros si existe el usuario con ese usuario
     * y el password.
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
