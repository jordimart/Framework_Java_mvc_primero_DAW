package Appweb.Modules.Main.Model.Dummies.Model.DAO_Dummy;

import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin;
import Appweb.Classes.Date.ClassDate;
import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import Appweb.Modules.Users.Client.Model.BLL_Client.BLL_Client;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.User_reg.Model.BLL_User.BLL_User;
import Appweb.Modules.Users.User_reg.Model.Classes.User_reg;

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
        int posa = 0;
        int posc = 0;
        int posu = 0;
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
            posc = BLL_Client.Look_for_dni_client(aux);
            posu = BLL_User.Look_for_dni_user(aux);

            if ((posa != -1 || posc != -1 || posu != -1)) {

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
     * @return string
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
     * @return string
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
     * @return string
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
     * @param min int
     *
     * @return Classdate
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
     * @param name string
     * @param last_name string
     *
     * @return string
     */
    public static String Dummyemail(String name, String last_name) {

        String email = "";

        email = email + name + last_name + "@gmail.com";

        return email;
    }

    /**
     * Funcion que devuelve un nombre de usuario que depende del nombre y un
     * numero aleatorio ya que no debe repetirse.
     * anterior.
     *
     * @param name string
     *
     * @return string
     */
    public static String Dummyuser(String name) {

        String user = "";
        int num = (int) (Math.random() * (9999 - 1000) + 1000);

        user = user + name + num;

        return user;
    }

    /**
     * Funcion que genera un password usando el nombre delusuario e
     * introduciendo
     * numeros.
     *
     * @param name string
     *
     * @return string
     */
    public static String Dammypassword(String name) {

        String pass = "";
        int num = (int) (Math.random() * (9999 - 1000) + 1000);
        String up = name.toUpperCase();

        pass = pass + up + num + name;

        return pass;

    }

    /**
     * Funcion que devuelve la direccion de una imagen para el avatarde forma
     * aleatoria.
     *
     * @return String con direccion
     */
    public static String Dammyavatar() {

        String[] nom = {"0275.jpg", "0288.jpg", "0298.jpg", "0303.jpg", "0415.jpg", "0686.jpg", "0695.jpg", "0770.jpg", "0771.jpg",
            "0781.jpg", "0782.jpg", "0808.jpg", "0815.jpg", "0870.jpg", "0872.jpg", "0984.jpg", "0986.jpg", "1331.jpg", "1332.jpg",
            "1448.jpg", "1455.jpg", "1494.jpg", "1544.jpg", "1556.jpg", "1558.jpg", "1567.jpg", "1568.jpg", "1570.jpg", "1916.jpg",};

        int pos = (int) (Math.random() * (29 - 1) + 1);
        String avatar = "src/Appweb/Modules/Users/Img/Avatares/" + nom[pos];

        return avatar;
    }

    /**
     * Funcion que devuelve una fecha que debe estar comprendida entre un minimo
     * y un maximo de años.
     *
     * @param min int
     * @param max int
     *
     * @return Classdate
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
     * @param d Classdate
     * @param min int
     *
     * @return classdate
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
     * @param n int
     * @param m int
     *
     * @return float
     */
    public static float Dummysalary(int n, int m) {

        float valor = (float) (Math.random() * (n - m) + m);

        return (float) Math.rint(valor * 100) / 100;
    }

    /**
     * Funcion que devuelve una actividad comprendida entre dos cotas.
     *
     * @param n int
     * @param m int
     *
     * @return int
     */
    public static int Dummyactivity(int n, int m) {

        int valor = (int) (Math.random() * (n - m) + m);

        return valor;
    }

    /**
     * Esta funcion dummy rellena el objeto admin con unos datos random
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
        Password = DAO_Dummies.Dammypassword(Name);
        Avatar = DAO_Dummies.Dammyavatar();
        Status = "Conected";

        // Enter Admin attributes
        date_cont = new ClassDate(01, 01, 2006);

        salary = DAO_Dummies.Dummysalary(900, 2000);

        activity = DAO_Dummies.Dummyactivity(10, 100);

        return new Admin(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_cont, salary, activity);
    }

    /**
     * Esta funcion dummy rellena el objeto client con unos datos random.
     *
     * @return Client
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
        Name = DAO_Dummies.Dummyname();
        Last_name = DAO_Dummies.Dummylast_name();
        Mobile = DAO_Dummies.Dummymobile();
        Date_birth = DAO_Dummies.Dummydate_int_min(18);
        Email = DAO_Dummies.Dummyemail(Name, Last_name);
        User = DAO_Dummies.Dummyuser(Name);
        Password = DAO_Dummies.Dammypassword(Name);
        Avatar = DAO_Dummies.Dammyavatar();
        Status = "Conected";

        entry_date = new ClassDate(01, 01, 2006);
        purchase = DAO_Dummies.Dummysalary(900, 3000);
        premium = "Yes";
        client_type = "Bueno";

        return new Client(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, entry_date, purchase, premium,
                client_type);
    }

    /**
     * Esta funcion dummy rellena el objeto user_reg con datos random.
     *
     *
     * @return User_reg
     */
    public static User_reg DummyUser_reg() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
        String Status = "";
        int activity_u;
        ClassDate Date_birth = null;
        String Avatar = null;

        Dni = DAO_Dummies.Dummydni();
        Name = DAO_Dummies.Dummyname();
        Last_name = DAO_Dummies.Dummylast_name();
        Mobile = DAO_Dummies.Dummymobile();
        Date_birth = DAO_Dummies.Dummydate_int_min(18);
        Email = DAO_Dummies.Dummyemail(Name, Last_name);
        User = DAO_Dummies.Dummyuser(Name);
        Password = DAO_Dummies.Dammypassword(Name);
        Avatar = DAO_Dummies.Dammyavatar();
        Status = "Conected";

        activity_u = DAO_Dummies.Dummyactivity(10, 100);

        return new User_reg(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, activity_u);
    }

}
