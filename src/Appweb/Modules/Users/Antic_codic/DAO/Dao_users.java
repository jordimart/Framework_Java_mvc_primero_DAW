package Appweb.Modules.Users.Antic_codic.DAO;

/**
 * @author Jorge Martinez Frias
 * @version 2.0 start 19_11_2015 En esta version hemos trasladado la funcion
 * Funciones_users para utilizarla en este proyecto, no se realizan cambios. En
 * estas funciones quito las peticiones de los datos que se calculan como
 * incentive,discounts y points. En la version 2.0 se ha quitado la peticion de
 * age y antiguedad porque ya se recalcula dependiendo de la fecha. Se han
 * modificado las peticiones individuales tambien.
 */

import Appweb.Classes.Date.ClassDate;
import Appweb.Modules.Config.Classes.Language.Lang;
import Appweb.Modules.Users.Classes.Client;
import Appweb.Modules.Users.Classes.User_reg;
import Appweb.Modules.Users.Users_tools.Core_users;
import Appweb.General_tools.Date_tools;
import Appweb.General_tools.Menu;
import Appweb.General_tools.Request_variable;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtName;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtLast_name;

/**
 *
 * @author Jorge Martinez Frias
 *
 */
public class Dao_users {

   

    /**
     * Client request claim Client attributes and Users.
     *
     * @param datef string date format)
     * @param language string language
     *
     * @return object Admin
     */
    
    /**
    public static Client Clientrequest() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", Avatar = "", client_type = "";
        ClassDate entry_date = null;
        String premium = "";
        String Status = "";
        float purchase = 0.000f;
        ClassDate Date_birth = null;

        // Enter User atributtes
        Dni = Core_users.Enterdnic(
                Lang.getInstance().getProperty("Enter_Dni") + "\n" + Lang.getInstance().getProperty("Format_example") + ": 48293555N",
                Lang.getInstance().getProperty("Request"));
        Name = txtName.getText().toString();
        Last_name = txtLast_name.getText().toString();
        Mobile = Core_users.Entermobile(
                Lang.getInstance().getProperty("Enter_Spanish_Mobile") + "\n" + Lang.getInstance().getProperty("Format_example") + ": 660371228",
                Lang.getInstance().getProperty("Request"));
        Date_birth = Date_tools.Date_min_condition(
                Lang.getInstance().getProperty("Enter_Birthday_date") + "\n" + Lang.getInstance().getProperty("Format_example") + ": dd/mm/yyyy",
                Lang.getInstance().getProperty("Request"), 18);
        Email = Core_users.Entermail(
                Lang.getInstance().getProperty("Enter_Email") + "\n" + Lang.getInstance().getProperty("Format_example") + ": xxxx@xxxx.xxx",
                Lang.getInstance().getProperty("Request"));
        User = Core_users.Enterwordfull(Lang.getInstance().getProperty("Enter_User"), Lang.getInstance().getProperty("Request"));
        Password = Core_users.Enterwordfull(Lang.getInstance().getProperty("Enter_Password"), Lang.getInstance().getProperty("Request"));
        Avatar = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Avatar"), Lang.getInstance().getProperty("Request"));
        Status = Menu.string_status(Lang.getInstance().getProperty("Enter_Status"), Lang.getInstance().getProperty("Request"));

        // Enter Client attributes
        entry_date = Date_tools.Date_registered(Date_birth, 18);
        purchase = Request_variable.damefloat(Lang.getInstance().getProperty("Enter_purchase"), Lang.getInstance().getProperty("Request"));
        premium = Menu.string_Yes_No(Lang.getInstance().getProperty("Enter_premium"), Lang.getInstance().getProperty("Request"));
        client_type = Request_variable.damestring(Lang.getInstance().getProperty("Enter_client_type"), Lang.getInstance().getProperty("Request"));

        return new Client(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, entry_date, purchase, premium,
                client_type);

    }
*/
    /**
     * User_reg request claim User_reg attributes and Users.
     *
     * @param datef string date format)
     * @param language string language
     *
     * @return object Admin
     */
    /**
    public static User_reg User_regrequest() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", Avatar = "";
        String Status = "";
        int activity_u = 0;
        ClassDate Date_birth = null;

        // Enter User atributtes
        Dni = Core_users.Enterdniu(
                Lang.getInstance().getProperty("Enter_Dni") + "\n" + Lang.getInstance().getProperty("Format_example") + ": 48293555N",
                Lang.getInstance().getProperty("Request"));
        Name = Core_users.Enterword(Lang.getInstance().getProperty("Enter_Name"), Lang.getInstance().getProperty("Request"));
        Last_name = Core_users.Enterword(Lang.getInstance().getProperty("Enter_Last_Name"), Lang.getInstance().getProperty("Request"));
        Mobile = Core_users.Entermobile(
                Lang.getInstance().getProperty("Enter_Spanish_Mobile") + "\n" + Lang.getInstance().getProperty("Format_example") + ": 660371228",
                Lang.getInstance().getProperty("Request"));
        Date_birth = Date_tools.Date_min_condition(
                Lang.getInstance().getProperty("Enter_Birthday_date") + "\n" + Lang.getInstance().getProperty("Format_example") + ": dd/mm/yyyy",
                Lang.getInstance().getProperty("Request"), 18);
        Email = Core_users.Entermail(
                Lang.getInstance().getProperty("Enter_Email") + "\n" + Lang.getInstance().getProperty("Format_example") + ": xxxx@xxxx.xxx",
                Lang.getInstance().getProperty("Request"));
        User = Core_users.Enterwordfull(Lang.getInstance().getProperty("Enter_User"), Lang.getInstance().getProperty("Request"));
        Password = Core_users.Enterwordfull(Lang.getInstance().getProperty("Enter_Password"), Lang.getInstance().getProperty("Request"));
        Avatar = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Avatar"), Lang.getInstance().getProperty("Request"));
        Status = Menu.string_status(Lang.getInstance().getProperty("Enter_Status"), Lang.getInstance().getProperty("Request"));

        // Enter User_reg attributes
        activity_u = Request_variable.dameint(Lang.getInstance().getProperty("Enter_activity"), Lang.getInstance().getProperty("Request"));

        return new User_reg(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, activity_u);
    }
*/
   

    
    
}
