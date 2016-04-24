package Appweb.Modules.Main.Model.Login.model.BLL_Login;

import Appweb.Modules.Main.Model.Login.model.DAO_Login.DAO_Login;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin_BD;
import Appweb.Modules.Users.Client.Model.BLL_Client.BLL_Client_mongo;

/**
 *
 * @author jorge
 */
public class BLL_Login {

    public static boolean Login_Admin() {

        boolean ok = false;

        DAO_Login.collectdata();//recoge los datos de la vista
        DAO_Login.standard_login();//compara entradas standard
        ok = BLL_Admin_BD.find_in_BD();

        return ok;
    }

    public static boolean Login_Client() {

        DAO_Login.collectdata();//recoge los datos de la vista
        DAO_Login.standard_login();//compara entradas standard
        boolean ok = BLL_Client_mongo.find_mongo();
           if (ok=true){
               
              ok= DAO_Login.find_and_compare_mongo();
           }

        return ok;
    }

}
