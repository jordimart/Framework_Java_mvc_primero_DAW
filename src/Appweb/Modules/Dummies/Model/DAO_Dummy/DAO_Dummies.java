package Appweb.Modules.Dummies.Model.DAO_Dummy;

import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin;
import Appweb.Classes.Date.ClassDate;
import Appweb.Modules.Config.Classes.Language.Lang;
import Appweb.Modules.Dummies.View.task_Dummy_view;
import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.User_reg.Model.Classes.User_reg;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class DAO_Dummies {

    /**
     * Funcion que genera un dni valido y comprueba que no este repetido en
     * ningun usuario.
     *
     * @return string dni
     */
    public static String Dummydni() {

        String car = "TRWAGMYFPDXBNJZSQVHLCKET";
        String s = "";
        String aux = " ";
        int n = 0;
        int num = 0;
        int rest = 0;
        int posa = 0, posc = 0, posu = 0;
        char pass = ' ';
        boolean ok = true;

        do {

            for (int i = 0; i < 8; i++) {

                n = (int) Math.floor(Math.random() * 10);

                s = s + n;

            }
            aux = "";

            for (int i = 0; i < 8; i++) {
                aux += s.charAt(i);
            }
            num = Integer.parseInt(aux);
            rest = num % 23;
            pass = car.charAt(rest);
            s = s + pass;

            posa = BLL_Admin.Look_for_dni_admin(aux);
            //posc = Look_for_dni.Look_for_dni_client(aux);
            //posu = Look_for_dni.Look_for_dni_user_reg(aux);

            if ((posa != -1)) {

                ok = false;

            } else {

                ok = true;
            }
        } while (ok == false);

        return s;

    }

    /**
     * Funcion que devuelve nombres de forma aleatoria.
     *
     * @return
     */
    public static String Dummyname() {

        // String nombre = "";
        String[] nom = {"Jorge", "Jose", "Javi", "Alejandro", "David", "Antonio", "Candy", "Ruben", "Dani", "Juan", "Rosana", "Elena", "Veronica",
            "Anabel", "Paula", "Noelia", "Cristina", "Silvia", "Estefania", "Raquel", "Sara", "Andres", "Leo", "Luis", "Paco", "Vicent", "Xavi",
            "Aron", "Santi", "Salva", "Elsa", "Penelope", "Lena", "Adel"};

        int pos = (int) (Math.random() * (33 - 1) + 1);// Genera posiciones

        return nom[pos];
    }

    /**
     * Funcion que devuelve apellidos de forma aleatoria.
     *
     * @return
     */
    public static String Dummylast_name() {

        // String nombre = "";
        String[] nom = {"Martinez", "Frias", "Garcia", "Lopez", "Perez", "Gonzalez", "Romero", "Torres", "Ramirez", "Navarro", "Ramos", "Morrell",
            "Mendez", "Sanchez", "Rodriquez", "Fernandez", "Gomez", "Martin", "Hernandez", "Sanz", "Suarez", "Vazquez", "Dominguez", "Castro",
            "Delgado", "Castillo", "Marquez", "Ruiz", "Diaz", "Alvarez", "Jimenez", "Moreno", "Alonso", "Gutierrez"};

        int pos = (int) (Math.random() * (33 - 1) + 1);// Genera posiciones

        return nom[pos];
    }

    /**
     * Funcion que devuelve numeros de telefono de forma aleatoria.
     *
     * @return
     */
    public static String Dummymobile() {

        // String nombre = "";
        String[] nom = {"667429926", "667459926", "667406926", "667400926", "667408926", "667209926", "667439926", "667449926", "667809926",
            "667459926", "667408926", "667406926", "667429926", "667489926", "667406926", "667449926", "667409226", "667409726", "667409920",
            "667409926", "667489926", "667409526", "669409926", "668409926", "667109926", "667309926", "667404926", "667409026", "667404926",
            "667409926", "667489926", "667479926", "667409626", "667405926"};

        int pos = (int) (Math.random() * (33 - 1) + 1);
        // Genera posiciones

        return nom[pos];
    }

    /**
     * Funcion que devuelve una fecha que debe cumplir que los años sean igual o
     * mayores al parametro min.
     *
     * @param min
     * @return
     */
    public static ClassDate Dummydate_int_min(int min) {

        // ClassDate date = new ClassDate("26/05/1920");
        int years = 0;
        ClassDate date = null;

        do {
            int day = (int) (Math.random() * (31 - 1) + 1);
            int month = (int) (Math.random() * (12 - 1) + 1);
            int year = (int) (Math.random() * (2040 - 1940) + 1940);

            date = new ClassDate(day, month, year);
            years = date.Diference_system_date();

        } while (years < min);

        return date;

    }

    /**
     * Funcion que devuelve correos que dependen del nombre y el apellido del
     * usuario.
     *
     * @param name
     * @param last_name
     * @return
     */
    public static String Dummyemail(String name, String last_name) {

        String email = "";

        email = email + name + last_name + "@gmail.com";

        return email;
    }

    /**
     * Funcion que devuelve un nombre de usuario que depende del nombre
     * anterior.
     *
     * @param name
     * @return
     */
    public static String Dummyuser(String name) {

        String user = "";

        user = user + name + "user";

        return user;
    }

    /**
     * Funcion que devuelve una fecha que debe estar comprendida entre un minimo
     * y un maximo de años.
     *
     * @param min
     * @param max
     * @return
     */
    public static ClassDate Dummydate_int_min_max(int min, int max) {

        int years = 0;
        ClassDate date = null;

        do {
            int day = (int) (Math.random() * (31 - 1) + 1);
            int month = (int) (Math.random() * (12 - 1) + 1);
            int year = (int) (Math.random() * (2040 - 1940) + 1940);

            date = new ClassDate(day, month, year);
            years = date.Diference_system_date();

        } while ((years < min) || (years > max));

        return date;

    }

    /**
     * Funcion que devuelve una fecha de registro para calcular la antiguedad,
     * debe ser anterior al sistema,compara que no sea anterior a la de creacion
     * o nacimiento del usuario,compara que cuando se registro el producto el
     * usuario era mayor de edad.
     *
     * @param d
     * @param min
     * @return
     */
    public static ClassDate Dummy_date_entry(ClassDate d, int min) {

        int years = 0;
        ClassDate date = null;
        boolean valcomps = true;
        boolean valcomp = true;
        boolean valadult = true;
        boolean val1 = false;

        do {
            int day = (int) (Math.random() * (31 - 1) + 1);
            int month = (int) (Math.random() * (12 - 1) + 1);
            int year = (int) (Math.random() * (2014 - 1980) + 1980);

            date = new ClassDate(day, month, year);

            years = date.Diference_two_dates(d);

            if (date.Date_compare_system_date() == 2) {

                valcomps = false;

            } else {

                valcomps = true;

            }
            if (date.Date_compare_two_dates(d) == 0) {

                valcomp = false;

            } else {

                valcomp = true;
            }

            if (years < min) {

                valadult = false;

            } else {
                valadult = true;
            }

            if ((valcomps == true) && (valcomp == true) && (valadult == true)) {

                val1 = true;

            } else {

                val1 = false;
            }

        } while (val1 == false);

        return date;
    }

    /**
     * Funcion que devuelve un salario comprendido entre dos cotas.
     *
     * @param n
     * @param m
     * @return
     */
    public static float Dummysalary(int n, int m) {

        float valor = (float) (Math.random() * (n - m) + m);

        return (float) Math.rint(valor * 100) / 100;
    }

    /**
     * Funcion que devuelve una actividad comprendida entre dos cotas.
     *
     * @param n
     * @param m
     * @return
     */
    public static int Dummyactivity(int n, int m) {

        int valor = (int) (Math.random() * (n - m) + m);

        return valor;
    }

    /**
     * Esta funcion dummy rellena el objeto admin con unos datos predefinidos.
     *
     * @return
     */
    public static Admin Dummyadmin() {

        String Dni = " ", Name = " ", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
        ClassDate date_cont = null;
        String Status = "";
        int activity = 0;
        float salary = 0.000f;
        ClassDate Date_birth = null;
        String Avatar = null;

        Dni = DAO_Dummies.Dummydni();
        Name = DAO_Dummies.Dummyname();
        Last_name = DAO_Dummies.Dummylast_name();
        Mobile = DAO_Dummies.Dummymobile();
        Date_birth = DAO_Dummies.Dummydate_int_min_max(16, 65);
        Email = DAO_Dummies.Dummyemail(Name, Last_name);
        User = DAO_Dummies.Dummyuser(Name);
        Password = "Jorge150902";
        Avatar = "src/Appweb/Modules/Users/Img/Avatares/images.jpg";
        Status = "Conected";

        // Enter Admin attributes
        date_cont = new ClassDate(01,01,2006);

        salary = DAO_Dummies.Dummysalary(500, 2000);

        activity = DAO_Dummies.Dummyactivity(10, 100);

        return new Admin(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_cont, salary, activity);
    }

    /**
     * Esta funcion dummy rellena el objeto client con unos datos predefinidos.
     *
     * @return
     */
    public static Client DummyClient() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", client_type = "";
        ClassDate entry_date = null;
        String premium = "";
        String Status = "";
        float purchase = 0.000f;
        ClassDate Date_birth = null;
        String Avatar = null;

        Dni = DAO_Dummies.Dummydni();
        ;
        Name = DAO_Dummies.Dummyname();
        ;
        Last_name = DAO_Dummies.Dummylast_name();
        Mobile = DAO_Dummies.Dummymobile();
        Date_birth = DAO_Dummies.Dummydate_int_min(18);
        Email = DAO_Dummies.Dummyemail(Name, Last_name);
        User = DAO_Dummies.Dummyuser(Name);
        Password = "Rox150902";
        Avatar = "src/Appweb/Modules/Users/Img/Avatares/images.jpg";
        Status = "Conected";

        // Enter Admin attributes
        entry_date = new ClassDate("01/01/2006");
        purchase = DAO_Dummies.Dummysalary(500, 1000);
        premium = "Yes";
        client_type = "Bueno";

        return new Client(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, entry_date, purchase, premium,
                client_type);
    }

    /**
     * Esta funcion dummy rellena el objeto user_reg con unos datos
     * predefinidos.
     *
     * @return
     */
    public static User_reg DummyUser_reg() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
        String Status = "";
        int activity_u;
        ClassDate Date_birth = null;
        String Avatar = null;

        Dni = DAO_Dummies.Dummydni();
        ;
        Name = DAO_Dummies.Dummyname();
        ;
        Last_name = DAO_Dummies.Dummylast_name();
        Mobile = DAO_Dummies.Dummymobile();
        Date_birth = DAO_Dummies.Dummydate_int_min(18);
        Email = DAO_Dummies.Dummyemail(Name, Last_name);
        User = DAO_Dummies.Dummyuser(Name);
        Password = "Juanpa";
        Avatar = "src/Appweb/Modules/Users/Img/Avatares/images.jpg";
        Status = "Conected";

        // Enter Admin attributes
        activity_u = DAO_Dummies.Dummyactivity(10, 100);

        return new User_reg(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, activity_u);
    }

    public static void auto_save_json_dummy_admin() {

        String PATH = " ";

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Dummies/files/Admin_files/dummyadminusers";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("Admin", Admin.class);

            if (singleadmin.Admin_array.size() != 0) {
                File JFC = new File(PATH);
                PATH = JFC.getAbsolutePath();
                PATH = PATH + ".json";

                Gson gson = new Gson();
                String json = gson.toJson(singleadmin.Admin_array);
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(json.toString());
                fileXml.close();

                System.out.print(Lang.getInstance().getProperty("User_file_saved") + " Dummy  Admin json \n");
            }

        } catch (Exception e) {
            System.out.print("Error_save_user_file " + "json dummy Admin" + " \n");
        }
    }

    public static void auto_open_json_dummy_admin() {

        String PATH = " ";
        Admin a = null;
        Client c = null;
        User_reg u = null;

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Dummies/files/Admin_files/dummyadminusers.json";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Admin", Admin.class);

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();

            singleadmin.Admin_array.clear();

            JsonReader lector = new JsonReader(new FileReader(PATH));
            JsonParser parseador = new JsonParser();
            JsonElement raiz = parseador.parse(lector);

            Gson json = new Gson();
            JsonArray lista = raiz.getAsJsonArray();
            for (JsonElement elemento : lista) {
                a = json.fromJson(elemento, Admin.class);
                singleadmin.Admin_array.add(a);

            }
            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Loaded_user_file") + " Dummy  Admin json" + " \n");
            //System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " Dummy  Admin json"+" \n");

        } catch (Exception e) {
            //System.out.print(Lang.getInstance().getProperty("Error_loading_user_file")+ "json"+" \n");
            task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Error_loading_user_file") + "json" + " \n");
        }
    }
}
