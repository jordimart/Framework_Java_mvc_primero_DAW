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
import Appweb.Modules.Users.View.create_Admin;
import static Appweb.Modules.Users.View.create_Admin.labAvatar_create_admin;
import static Appweb.Modules.Users.View.create_Admin.txtActivity_create_admin;
import static Appweb.Modules.Users.View.create_Admin.txtDni_create_admin;
import static Appweb.Modules.Users.View.create_Admin.txtEmail_create_admin;
import static Appweb.Modules.Users.View.create_Admin.txtLast_name_create_admin;
import static Appweb.Modules.Users.View.create_Admin.txtMobile_create_admin;
import static Appweb.Modules.Users.View.create_Admin.txtName_create_admin;
import static Appweb.Modules.Users.View.create_Admin.txtPassword_create_admin;
import static Appweb.Modules.Users.View.create_Admin.txtSalary_create_admin;
import static Appweb.Modules.Users.View.create_Admin.txtStatus_create_admin;
import static Appweb.Modules.Users.View.create_Admin.txtUser_create_admin;
import Appweb.Modules.Users.model.BLL.Look_for_dni;
import Appweb.Modules.Users.model.Classes.Admin;
import Appweb.Modules.Users.model.Classes.Client;
import Appweb.Modules.Users.model.Classes.User_reg;
import Appweb.Modules.Users.model.Classes.singleton;
import Appweb.Modules.Users.model.Users_tools.Core_users;
import static Appweb.Modules.Users.model.Users_tools.Core_users.real_dni;
import Appweb.Tools.Date_tools;
import Appweb.Tools.Menu;
import Appweb.Tools.Request_variable;
import Appweb.Tools.Validate;
import java.awt.Color;

/**
 *
 * @author Jorge Martinez Frias
 *
 */
public class Dao_users {

    /**
     * Admin request claim Admins attributes and Users.
     *
     * @param datef string date format)
     * @param language string language
     *
     * @return object Admin
     */
    public static Admin Adminrequest() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", Avatar = "";
        ClassDate date_cont = null;
        String Status = "";
        int activity = 0;
        float salary = 0.000f;
        ClassDate Date_birth = null;

        // Enter User atributtes
        Dni = txtDni_create_admin.getText().toString();

        Name = txtName_create_admin.getText().toString();
        Last_name = txtLast_name_create_admin.getText().toString();
        Mobile = txtMobile_create_admin.getText().toString();
        Date_birth = Date_tools.Date_min_max_condition(16, 65);
        Email = txtEmail_create_admin.getText().toString();
        User = txtUser_create_admin.getText().toString();
        Password = txtPassword_create_admin.getPassword().toString();
        Avatar = labAvatar_create_admin.getText().toString();
        Status = txtStatus_create_admin.getText().toString();

        // Enter Admin attributes
        date_cont = Date_tools.Date_registered(Date_birth, 16);
        salary = Float.parseFloat(txtSalary_create_admin.getText().toString());
        activity = Integer.parseInt(txtActivity_create_admin.getText().toString());

        return new Admin(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_cont, salary, activity);
    }

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

    /**
     * Fucion que valida que el dni pueda existir.Pero ademas comprueba que no
     * este repetido en los Admin.Implementada en grafica para validar etiqueta
     * de color.
     *
     * @return boolean ok.
     */
    public static boolean Enterdnia() {

        String dni = "";
        boolean ok = false;
        int pos = -1;

        dni = create_Admin.txtDni_create_admin.getText().toString();
        dni = dni.toUpperCase();
        ok = Validate.okdni(dni);

        if (ok == false) {
            create_Admin.labDni_create_admin.setText("wrong data");
            create_Admin.txtDni_create_admin.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {

            pos = Look_for_dni.Look_for_dni_admin(dni);
            if (real_dni(dni) != true) {

                ok = false;
                create_Admin.labDni_create_admin.setText("wrong data");
                create_Admin.txtDni_create_admin.setBackground(Color.RED);
                //JOptionPane.showMessageDialog(null,
                //Lang.getInstance().getProperty("You_can_not_repeat_dni"));
            } else {
                pos = Look_for_dni.Look_for_dni_admin(dni);

                if (pos != -1) {
                    ok = false;
                    create_Admin.labDni_create_admin.setText("wrong data");
                    create_Admin.txtDni_create_admin.setBackground(Color.RED);

                } else {

                    ok = true;
                    create_Admin.labDni_create_admin.setText("ok");
                    create_Admin.txtDni_create_admin.setBackground(Color.GREEN);
                }
            }

        }
        return ok;
    }

    public static boolean Entername_admin() {

        boolean ok = false;
        String name = create_Admin.txtName_create_admin.getText().toString();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Admin.labName_create_admin.setText("wrong data");
            create_Admin.txtName_create_admin.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labName_create_admin.setText("ok");
            create_Admin.txtName_create_admin.setBackground(Color.GREEN);

        }

        return ok;
    }

    public static boolean Enterlast_name_admin() {

        boolean ok = false;
        String name = create_Admin.txtName_create_admin.getText().toString();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Admin.labLast_name_create_admin.setText("wrong data");
            create_Admin.txtLast_name_create_admin.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labLast_name_create_admin.setText("ok");
            create_Admin.txtLast_name_create_admin.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pise un numero de telefono movil con nueve digitos.
     *
     * @return string movil
     */
    public static boolean Entermobile_admin() {

        String s = "";
        boolean ok = false;

        s = create_Admin.txtMobile_create_admin.getText();
        ok = Validate.okmobile(s);
        if (ok == false) {
            create_Admin.labMobile_create_admin.setText("wrong data");
            create_Admin.txtMobile_create_admin.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labMobile_create_admin.setText("ok");
            create_Admin.txtMobile_create_admin.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide un email y valida su formato.
     *
     * @return
     */
    public static boolean Entermail_admin() {

        String cad = "";
        boolean ok = false;

        cad = create_Admin.txtEmail_create_admin.getText();
        ok = Validate.okmail(cad);
        if (ok == false) {
            create_Admin.labEmail_create_admin.setText("wrong data");
            create_Admin.txtEmail_create_admin.setBackground(Color.red);

            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labEmail_create_admin.setText("ok");
            create_Admin.txtEmail_create_admin.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean Enteruser_admin() {

        String cad = "";
        boolean ok = false;

        cad = create_Admin.txtUser_create_admin.getText();
        ok = Validate.okwordfull(cad);
        if (ok == false) {
            create_Admin.labUser_create_admin.setText("wrong data");
            create_Admin.txtUser_create_admin.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labUser_create_admin.setText("ok");
            create_Admin.txtUser_create_admin.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean Enterpassword_admin() {

        String cad = "";
        boolean ok = false;

        cad = create_Admin.txtPassword_create_admin.getPassword().toString();
        ok = Validate.okwordfull(cad);
        if (ok == false) {
            create_Admin.labPassword_create_admin.setText("wrong data");
            create_Admin.txtPassword_create_admin.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labPassword_create_admin.setText("ok");
            create_Admin.txtPassword_create_admin.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean Entersalary_admin() {

        String s = "";
        float sal = 0.0f;

        boolean ok = false;

        s = create_Admin.txtSalary_create_admin.getText();

        sal = Float.parseFloat(s);

        if ((sal > 800) && (sal < 2500)) {
            create_Admin.labSalary_create_admin.setText("ok");
            create_Admin.txtSalary_create_admin.setBackground(Color.GREEN);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labSalary_create_admin.setText("wrong data");
            create_Admin.txtSalary_create_admin.setBackground(Color.RED);
        }

        return ok;
    }

    public static boolean Enteractivity_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;

        s = create_Admin.txtActivity_create_admin.getText();
        act = Integer.parseInt(s);

        if ((act > 0) && (act < 100)) {
            create_Admin.labActivity_create_admin.setText("ok");
            create_Admin.txtActivity_create_admin.setBackground(Color.GREEN);
        } else {

            create_Admin.labActivity_create_admin.setText("wrong data");
            create_Admin.txtActivity_create_admin.setBackground(Color.red);
        }

        return ok;
    }
}
