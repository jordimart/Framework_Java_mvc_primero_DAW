
package Appweb.Modules.Users.User_reg.Model.BLL_User;

import Appweb.Modules.Users.User_reg.Model.DAO_User.DAO_User_file;

/**
 *
 * @author jorge
 */
public class BLL_User_file {
    
    public static void save_json() {

        DAO_User_file.save_json();
    }

    public static void save_xml() {

        DAO_User_file.save_xml();
    }

    public static void save_txt() {

        DAO_User_file.save_txt();
    }

    public static void auto_open_json() {

        DAO_User_file.auto_open_json();
    }

    public static void auto_save_json() {

        DAO_User_file.auto_save_json();
    }
    
}
