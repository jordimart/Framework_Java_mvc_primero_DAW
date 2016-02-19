package Appweb.Modules.Users.model.DAO;

/**
 * @author Jorge Martinez Frias
 * @version 2.0 start 19_11_2015 En esta version hemos trasladado la funcion
 * Funciones_users para utilizarla en este proyecto, no se realizan cambios. En
 * estas funciones quito las peticiones de los datos que se calculan como
 * incentive,discounts y points. En la version 2.0 se ha quitado la peticion de
 * age y antiguedad porque ya se recalcula dependiendo de la fecha. Se han
 * modificado las peticiones individuales tambien.
 */
import javax.swing.JOptionPane;

import Appweb.Classes.Date.ClassDate;
import Appweb.Classes.Language.Lang;
import Appweb.Modules.Users.Admin.View.create_Admin_view;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.labAvatar_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtActivity_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtDni_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtEmail_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtLast_name_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtMobile_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtName_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtPassword_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtSalary_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtUser_create_admin;
import Appweb.Modules.Users.model.BLL.Look_for_dni;
import Appweb.Modules.Users.model.Classes.Admin;
import Appweb.Modules.Users.model.Classes.Client;
import Appweb.Modules.Users.model.Classes.User_reg;
import Appweb.Modules.Users.model.Classes.singleton;
import Appweb.Modules.Users.model.Users_tools.Core_users;
import static Appweb.Modules.Users.model.Users_tools.Core_users.real_dni;
import Appweb.Tools.Date_tools;
import static Appweb.Tools.Date_tools.Date_min_max_condition;
import static Appweb.Tools.Date_tools.Date_min_max_condition_boolean;
import static Appweb.Tools.Date_tools.Date_registered_boolean;
import Appweb.Tools.Menu;
import Appweb.Tools.Request_variable;
import Appweb.Tools.Validate;
import java.awt.Color;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

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
        Name = txtName_create_admin.getText().toString();
        Last_name = txtLast_name_create_admin.getText().toString();
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

    /**
     * User_reg request claim User_reg attributes and Users.
     *
     * @param datef string date format)
     * @param language string language
     *
     * @return object Admin
     */
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

    /**
     * Menu combobox for modify one attribute of de type of user. Attributes are
     * modified with setters.
     *
     * @param a object admin(actually attributes)
     * @param datef string format date
     *
     *
     */
    public static void Adminset(int i) {

        String Dni = " ", Name = " ", Last_name = " ", Mobile = " ", Email = " ", User = " ", Password = " ", Avatar = " ";
        String Status = " ";
        String set = "";
        int activity = 0;
        float salary = 0.000f;
        ClassDate date_cont = null;
        ClassDate Date_birth = null;
        int pos = 0;

        String[] menuset = {"Dni", Lang.getInstance().getProperty("Name"), Lang.getInstance().getProperty("Last_name"),
            Lang.getInstance().getProperty("Mobile"), Lang.getInstance().getProperty("Date_birth"), "Email",
            Lang.getInstance().getProperty("User"), Lang.getInstance().getProperty("Password"), "Avatar", "Status",
            Lang.getInstance().getProperty("Recruitment_date"), Lang.getInstance().getProperty("Salary"),
            Lang.getInstance().getProperty("Activity"), Lang.getInstance().getProperty("Back")};

        set = (String) Menu.menucombobox(menuset, Lang.getInstance().getProperty("Request"),
                Lang.getInstance().getProperty("Select_attribute_to_modify"));

        pos = Menu.transform_comboobject_to_int(menuset, set);

        switch (pos) {

            case 0:
                Dni = txtDni_create_admin.getText().toString();

                singleton.Admin_array.get(i).setDni(Dni);
                

                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 1:
                Name = Core_users.Enterword(Lang.getInstance().getProperty("Enter_Name"), Lang.getInstance().getProperty("Request"));
                singleton.Admin_array.get(i).setName(Name);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 2:
                Last_name = Core_users.Enterword(Lang.getInstance().getProperty("Enter_Last_Name"), Lang.getInstance().getProperty("Request"));
                singleton.Admin_array.get(i).setLast_name(Last_name);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 3:
                Mobile = Core_users.Entermobile(
                        Lang.getInstance().getProperty("Enter_Spanish_Mobile") + "\n" + Lang.getInstance().getProperty("Format_example") + ": 660371228",
                        Lang.getInstance().getProperty("Request"));
                singleton.Admin_array.get(i).setMobile(Mobile);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 4:
                Date_birth = Date_tools.Date_min_max_condition(16, 65);
                singleton.Admin_array.get(i).setDate_birth(Date_birth);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 5:
                Email = Core_users.Entermail(
                        Lang.getInstance().getProperty("Enter_Email") + "\n" + Lang.getInstance().getProperty("Format_example") + ": xxxx@xxxx.xxx",
                        Lang.getInstance().getProperty("Request"));
                singleton.Admin_array.get(i).setEmail(Email);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;
            case 6:
                User = Core_users.Enterwordfull(Lang.getInstance().getProperty("Enter_User"), Lang.getInstance().getProperty("Request"));
                singleton.Admin_array.get(i).setUser(User);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 7:

                Password = Core_users.Enterwordfull(Lang.getInstance().getProperty("Enter_Password"), Lang.getInstance().getProperty("Request"));
                singleton.Admin_array.get(i).setPassword(Password);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 8:
                Avatar = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Avatar"), Lang.getInstance().getProperty("Request"));
                singleton.Admin_array.get(i).setAvatar(Avatar);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;
            case 9:
                Status = Menu.string_status(Lang.getInstance().getProperty("Enter_Status"), Lang.getInstance().getProperty("Request"));
                singleton.Admin_array.get(i).setStatus(Status);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            // Enter Admin attributes
            case 10:

                date_cont = Date_tools.Date_registered(Date_birth, 18);
                singleton.Admin_array.get(i).setDate_cont(date_cont);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 11:
                salary = Request_variable.damefloat(Lang.getInstance().getProperty("Enter_salary"), Lang.getInstance().getProperty("Request"));
                singleton.Admin_array.get(i).setSalary(salary);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 12:
                activity = Request_variable.dameint(Lang.getInstance().getProperty("Enter_activity"), Lang.getInstance().getProperty("Request"));
                singleton.Admin_array.get(i).setActivity(activity);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

        }

    }

    /**
     * Menu combobox for modify one attribute of de type of user. Attributes are
     * modified with setters.
     *
     * @param a object admin(actually attributes)
     * @param datef string format date
     *
     *
     */
    public static void Clientset(int i) {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", Avatar = "", client_type = "";
        ClassDate entry_date = null;
        String premium = "";
        String Status = "";
        float purchase = 0.000f;
        ClassDate Date_birth = null;
        int pos = 0;

        String set = "";
        String[] menuset = {"Dni", Lang.getInstance().getProperty("Name"), Lang.getInstance().getProperty("Last_name"),
            Lang.getInstance().getProperty("Mobile"), Lang.getInstance().getProperty("Date_birth"), "Email",
            Lang.getInstance().getProperty("User"), Lang.getInstance().getProperty("Password"), "Avatar", "Status",
            Lang.getInstance().getProperty("Entry_date"), Lang.getInstance().getProperty("Purchase"), "Premium",
            Lang.getInstance().getProperty("Client_type"), Lang.getInstance().getProperty("Back")};

        set = (String) Menu.menucombobox(menuset, Lang.getInstance().getProperty("Request"),
                Lang.getInstance().getProperty("Select_attribute_to_modify"));

        pos = Menu.transform_comboobject_to_int(menuset, set);

        switch (pos) {

            case 0:
                Dni = Core_users.Enterdnic(
                        Lang.getInstance().getProperty("Enter_Dni") + "\n" + Lang.getInstance().getProperty("Format_example") + ": 48293555N",
                        Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setDni(Dni);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 1:
                Name = Core_users.Enterword(Lang.getInstance().getProperty("Enter_Name"), Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setName(Name);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 2:
                Last_name = Core_users.Enterword(Lang.getInstance().getProperty("Enter_Last_Name"), Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setLast_name(Last_name);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 3:
                Mobile = Core_users.Entermobile(
                        Lang.getInstance().getProperty("Enter_Spanish_Mobile") + "\n" + Lang.getInstance().getProperty("Format_example") + ": 660371228",
                        Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setMobile(Mobile);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 4:
                Date_birth = Date_tools.Date_min_condition(
                        Lang.getInstance().getProperty("Enter_Birthday_date") + "\n" + Lang.getInstance().getProperty("Format_example") + ": dd/mm/yyyy",
                        Lang.getInstance().getProperty("Request"), 18);
                singleton.Client_array.get(i).setDate_birth(Date_birth);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 5:
                Email = Core_users.Entermail(
                        Lang.getInstance().getProperty("Enter_Email") + "\n" + Lang.getInstance().getProperty("Format_example") + ": xxxx@xxxx.xxx",
                        Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setEmail(Email);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;
            case 6:
                User = Core_users.Enterwordfull(Lang.getInstance().getProperty("Enter_User"), Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setUser(User);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 7:

                Password = Core_users.Enterwordfull(Lang.getInstance().getProperty("Enter_Password"), Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setPassword(Password);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 8:
                Avatar = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Avatar"), Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setAvatar(Avatar);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;
            case 9:
                Status = Menu.string_status(Lang.getInstance().getProperty("Enter_Status"), Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setStatus(Status);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            // Enter Client attributes
            case 10:

                entry_date = Date_tools.Date_registered(Date_birth, 18);
                singleton.Client_array.get(i).setEntry_date(entry_date);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 11:
                purchase = Request_variable.damefloat(Lang.getInstance().getProperty("Enter_purchase"), Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setPurchase(purchase);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 12:
                premium = Menu.string_Yes_No(Lang.getInstance().getProperty("Enter_premium"), Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setPremium(premium);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;
            case 13:
                client_type = Request_variable.damestring(Lang.getInstance().getProperty("Enter_client_type"), Lang.getInstance().getProperty("Request"));
                singleton.Client_array.get(i).setClient_type(client_type);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

        }

    }

    /**
     * Menu combobox for modify one attribute of de type of user. Attributes are
     * modified with setters.
     *
     * @param a object admin(actually attributes)
     * @param datef string format date
     *
     *
     */
    public static void User_regset(int i) {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", Avatar = "";
        ClassDate Date_birth = null;
        String Status = "";
        int activity_u;
        int pos = 0;

        String set = "";
        String[] menuset = {"Dni", Lang.getInstance().getProperty("Name"), Lang.getInstance().getProperty("Last_name"),
            Lang.getInstance().getProperty("Mobile"), Lang.getInstance().getProperty("Date_birth"), "Email",
            Lang.getInstance().getProperty("User"), Lang.getInstance().getProperty("Password"), "Avatar", "Status",
            Lang.getInstance().getProperty("Activity"), Lang.getInstance().getProperty("Back")};

        set = (String) Menu.menucombobox(menuset, Lang.getInstance().getProperty("Request"),
                Lang.getInstance().getProperty("Select_attribute_to_modify"));

        pos = Menu.transform_comboobject_to_int(menuset, set);

        switch (pos) {

            case 0:
                Dni = Core_users.Enterdniu(
                        Lang.getInstance().getProperty("Enter_Dni") + "\n" + Lang.getInstance().getProperty("Format_example") + ": 48293555N",
                        Lang.getInstance().getProperty("Request"));
                singleton.User_reg_array.get(i).setDni(Dni);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 1:
                Name = Core_users.Enterword(Lang.getInstance().getProperty("Enter_Name"), Lang.getInstance().getProperty("Request"));
                singleton.User_reg_array.get(i).setName(Name);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 2:
                Last_name = Core_users.Enterword(Lang.getInstance().getProperty("Enter_Last_Name"), Lang.getInstance().getProperty("Request"));
                singleton.User_reg_array.get(i).setLast_name(Last_name);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 3:
                Mobile = Core_users.Entermobile(
                        Lang.getInstance().getProperty("Enter_Spanish_Mobile") + "\n" + Lang.getInstance().getProperty("Format_example") + ": 660371228",
                        Lang.getInstance().getProperty("Request"));
                singleton.User_reg_array.get(i).setMobile(Mobile);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 4:
                Date_birth = Date_tools.Date_min_condition(
                        Lang.getInstance().getProperty("Enter_Birthday_date") + "\n" + Lang.getInstance().getProperty("Format_example") + ": dd/mm/yyyy",
                        Lang.getInstance().getProperty("Request"), 18);
                singleton.User_reg_array.get(i).setDate_birth(Date_birth);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 5:
                Email = Core_users.Entermail(
                        Lang.getInstance().getProperty("Enter_Email") + "\n" + Lang.getInstance().getProperty("Format_example") + ": xxxx@xxxx.xxx",
                        Lang.getInstance().getProperty("Request"));
                singleton.User_reg_array.get(i).setEmail(Email);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;
            case 6:
                User = Core_users.Enterwordfull(Lang.getInstance().getProperty("Enter_User"), Lang.getInstance().getProperty("Request"));
                singleton.User_reg_array.get(i).setUser(User);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 7:

                Password = Core_users.Enterwordfull(Lang.getInstance().getProperty("Enter_Password"), Lang.getInstance().getProperty("Request"));
                singleton.User_reg_array.get(i).setPassword(Password);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

            case 8:
                Avatar = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Avatar"), Lang.getInstance().getProperty("Request"));
                singleton.User_reg_array.get(i).setAvatar(Avatar);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;
            case 9:
                Status = Menu.string_status(Lang.getInstance().getProperty("Enter_Status"), Lang.getInstance().getProperty("Request"));
                singleton.User_reg_array.get(i).setStatus(Status);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));
                break;

            // Enter Client attributes
            case 10:

                activity_u = Request_variable.dameint(Lang.getInstance().getProperty("Enter_activity"), Lang.getInstance().getProperty("Request"));
                singleton.User_reg_array.get(i).setActivity_u(activity_u);
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_attribute_has_been_modified"));

                break;

        }

    }

    
    
}