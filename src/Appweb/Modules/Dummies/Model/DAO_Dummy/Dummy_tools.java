package Appweb.Modules.Dummies.Model.DAO_Dummy;

import Appweb.Classes.Date.ClassDate;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin;
import Appweb.Modules.Users.Antic_codic.BLL.Look_for_dni;
import Appweb.Modules.Users.Classes.Admin;
import Appweb.Modules.Users.Classes.Client;
import Appweb.Modules.Users.Classes.User_reg;

public class Dummy_tools {

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
			posc = Look_for_dni.Look_for_dni_client(aux);
			posu = Look_for_dni.Look_for_dni_user_reg(aux);

			if ((posa != -1) || (posc != -1) || (posu != -1)) {

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
		String[] nom = { "Jorge", "Jose", "Javi", "Alejandro", "David", "Antonio", "Candy", "Ruben", "Dani", "Juan", "Rosana", "Elena", "Veronica",
				"Anabel", "Paula", "Noelia", "Cristina", "Silvia", "Estefania", "Raquel", "Sara", "Andres", "Leo", "Luis", "Paco", "Vicent", "Xavi",
				"Aron", "Santi", "Salva", "Elsa", "Penelope", "Lena", "Adel" };

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
		String[] nom = { "Martinez", "Frias", "Garcia", "Lopez", "Perez", "Gonzalez", "Romero", "Torres", "Ramirez", "Navarro", "Ramos", "Morrell",
				"Mendez", "Sanchez", "Rodriquez", "Fernandez", "Gomez", "Martin", "Hernandez", "Sanz", "Suarez", "Vazquez", "Dominguez", "Castro",
				"Delgado", "Castillo", "Marquez", "Ruiz", "Diaz", "Alvarez", "Jimenez", "Moreno", "Alonso", "Gutierrez" };

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
		String[] nom = { "667429926", "667459926", "667406926", "667400926", "667408926", "667209926", "667439926", "667449926", "667809926",
				"667459926", "667408926", "667406926", "667429926", "667489926", "667406926", "667449926", "667409226", "667409726", "667409920",
				"667409926", "667489926", "667409526", "669409926", "668409926", "667109926", "667309926", "667404926", "667409026", "667404926",
				"667409926", "667489926", "667479926", "667409626", "667405926" };

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
			// JOptionPane.showMessageDialog(null, "Años: " + years);
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

		user = user + name + "_user";

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
     * @return 
	 */
	public static Admin Dummyadmin() {

		String Dni = " ", Name = " ", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
		ClassDate date_cont = null;
		String Status = "";
		int activity = 0;
		float salary = 0.000f;
		ClassDate Date_birth = null;
                String Avatar=null;

		Dni = Dummy_tools.Dummydni();
		Name = Dummy_tools.Dummyname();
		Last_name = Dummy_tools.Dummylast_name();
		Mobile = Dummy_tools.Dummymobile();
		Date_birth = Dummy_tools.Dummydate_int_min_max(16, 65);
		Email = Dummy_tools.Dummyemail(Name, Last_name);
		User = Dummy_tools.Dummyuser(Name);
		Password = "Contrasena";
		Avatar = "src/Appweb/Modules/Users/Img/Avatares/images.jpg";
		Status = "Conected";

		// Enter Admin attributes
		date_cont = new ClassDate("01/01/2006");
		salary = Dummy_tools.Dummysalary(500, 2000);
		activity = Dummy_tools.Dummyactivity(10, 100);

		return new Admin(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_cont, salary, activity);
	}

	/**
	 * Esta funcion dummy rellena el objeto client con unos datos predefinidos.
     * @return 
	 */
	public static Client DummyClient() {

		String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", client_type = "";
		ClassDate entry_date = null;
		String premium = "";
		String Status = "";
		float purchase = 0.000f;
		ClassDate Date_birth = null;
                String Avatar=null;

		Dni = Dummy_tools.Dummydni();
		;
		Name = Dummy_tools.Dummyname();
		;
		Last_name = Dummy_tools.Dummylast_name();
		Mobile = Dummy_tools.Dummymobile();
		Date_birth = Dummy_tools.Dummydate_int_min(18);
		Email = Dummy_tools.Dummyemail(Name, Last_name);
		User = Dummy_tools.Dummyuser(Name);
		Password = "Rox150902";
		Avatar = "src/Appweb/Modules/Users/Img/Avatares/images.jpg";
		Status = "Conected";

		// Enter Admin attributes
		entry_date = new ClassDate("01/01/2006");
		purchase = Dummy_tools.Dummysalary(500, 1000);
		premium = "Yes";
		client_type = "Bueno";

		return new Client(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, entry_date, purchase, premium,
				client_type);
	}

	/**
	 * Esta funcion dummy rellena el objeto user_reg con unos datos
	 * predefinidos.
     * @return 
	 */
	public static User_reg DummyUser_reg() {

		String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
		String Status = "";
		int activity_u;
		ClassDate Date_birth = null;
                String Avatar=null;

		Dni = Dummy_tools.Dummydni();
		;
		Name = Dummy_tools.Dummyname();
		;
		Last_name = Dummy_tools.Dummylast_name();
		Mobile = Dummy_tools.Dummymobile();
		Date_birth = Dummy_tools.Dummydate_int_min(18);
		Email = Dummy_tools.Dummyemail(Name, Last_name);
		User = Dummy_tools.Dummyuser(Name);
		Password = "Juanpa";
		Avatar = "src/Appweb/Modules/Users/Img/Avatares/images.jpg";
		Status = "Conected";

		// Enter Admin attributes
		activity_u = Dummy_tools.Dummyactivity(10, 100);

		return new User_reg(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, activity_u);
	}

}
