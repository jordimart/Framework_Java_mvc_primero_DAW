package Appweb.Modules.Users.model.BLL;

import java.util.Iterator;

import javax.swing.JOptionPane;

import Appweb.Classes.Language.Lang;
import Appweb.Modules.Users.model.Classes.Admin;
import Appweb.Modules.Users.model.Classes.Client;
import Appweb.Modules.Users.model.Classes.User_reg;
import Appweb.Modules.Users.model.Classes.singleton;
import Appweb.Modules.Users.model.DAO.Dao_users;
import Appweb.Tools.Menu;

/**
 * 
 * @author Jorge Martinez Frias
 *
 */
public class BLL_users {

	

	/**
	 * This function asks client data and enters them into an array
	 * 
	 */
	public static void Create_client_and_add_array() {

		Client c = null;

		c = Dao_users.Clientrequest();

		singleton.Client_array.add(c);
	}

	/**
	 * This function asks user_reg data and enters them into an array
	 * 
	 */
	public static void Create_user_reg_and_add_array() {

		User_reg u = null;

		u = Dao_users.User_regrequest();

		singleton.User_reg_array.add(u);
	}

	public static void Print_Array_admin_dni() {

		String s = " ";

		Admin a = null;
		int pos = 0;

		if (singleton.Admin_array.size() != 0) {

			Iterator<Admin> it = singleton.Admin_array.iterator();
			while (it.hasNext()) {
				Object objeto = it.next();
				a = (Admin) objeto;

				s = s + a.toString(pos);

			}

			JOptionPane.showMessageDialog(null, s);

		} else

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_administrator_type"));

	}

	/**
	 * Prints the selected attribute of all clients
	 */
	public static void Print_Array_client_dni() {

		String s = " ";
		Client c = null;

		int pos = 0;

		if (singleton.Client_array.size() != 0) {

			Iterator<Client> it = singleton.Client_array.iterator();
			while (it.hasNext()) {
				Object objeto = it.next();
				c = (Client) objeto;

				s = s + c.toString(pos);

			}

			JOptionPane.showMessageDialog(null, s);

		} else
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_client_type"));

	}

	/**
	 * Prints the selected attribute of all user_reg
	 */
	public static void Print_Array_user_reg_dni() {

		String s = " ";
		User_reg u = null;

		int pos = 0;

		if (singleton.User_reg_array.size() != 0) {

			Iterator<User_reg> it = singleton.User_reg_array.iterator();
			while (it.hasNext()) {
				Object objeto = it.next();
				u = (User_reg) objeto;

				s = s + u.toString(pos);

			}

			JOptionPane.showMessageDialog(null, s);

		} else
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_user_registered_type"));

	}

	public static void Print_Array_admin() {

		Admin a = null;

		if (singleton.Admin_array.size() != 0) {

			Iterator<Admin> it = singleton.Admin_array.iterator();
			while (it.hasNext()) {
				Object objeto = it.next();
				a = (Admin) objeto;

				JOptionPane.showMessageDialog(null, a.toString());
			}

		} else
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_administrator_type"));

	}

	/**
	 * Print all elements into Arraylist.
	 * 
	 * @param a
	 */
	public static void Print_Array_client() {

		Client c = null;

		if (singleton.Client_array.size() != 0) {

			Iterator<Client> it = singleton.Client_array.iterator();
			while (it.hasNext()) {
				Object objeto = it.next();
				c = (Client) objeto;

				JOptionPane.showMessageDialog(null, c.toString());
			}

		} else
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_client_type"));

	}

	/**
	 * Print all elements into Arraylist.
	 * 
	 * @param a
	 */
	public static void Print_Array_user_reg() {

		User_reg u = null;

		if (singleton.User_reg_array.size() != 0) {

			Iterator<User_reg> it = singleton.User_reg_array.iterator();
			while (it.hasNext()) {
				Object objeto = it.next();
				u = (User_reg) objeto;

				JOptionPane.showMessageDialog(null, u.toString());
			}

		} else
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_user_registered_type"));

	}

	/**
	 * Prints the selected attribute of all admins
	 */
	public static void Print_Array_admin_all() {

		String s = " ";
		String set = "";
		Admin a = null;
		int pos = 0;

		String[] menuset = { "Dni", Lang.getInstance().getProperty("Name"), Lang.getInstance().getProperty("Last_name"),
				Lang.getInstance().getProperty("Mobile"), Lang.getInstance().getProperty("Date_birth"), Lang.getInstance().getProperty("Age"),
				"Email", Lang.getInstance().getProperty("User"), Lang.getInstance().getProperty("Password"), "Avatar", "Status",
				Lang.getInstance().getProperty("Benefits"), Lang.getInstance().getProperty("Recruitment_date"),
				Lang.getInstance().getProperty("Antique"), Lang.getInstance().getProperty("Salary"), Lang.getInstance().getProperty("Activity") };

		set = (String) Menu.menucombobox(menuset, Lang.getInstance().getProperty("Request"),
				Lang.getInstance().getProperty("Select_attribute_to_modify"));

		pos = Menu.transform_comboobject_to_int(menuset, set);

		if (singleton.Admin_array.size() != 0) {

			Iterator<Admin> it = singleton.Admin_array.iterator();
			while (it.hasNext()) {
				Object objeto = it.next();
				a = (Admin) objeto;

				s = s + a.toString(pos);

			}

			JOptionPane.showMessageDialog(null, s);

		} else

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_administrator_type"));

	}

	/**
	 * Prints the selected attribute of all clients
	 */
	public static void Print_Array_client_all() {

		String s = " ";
		Client c = null;
		String set = "";
		int pos = 0;

		String[] menuset = { "Dni", Lang.getInstance().getProperty("Name"), Lang.getInstance().getProperty("Last_name"),
				Lang.getInstance().getProperty("Mobile"), Lang.getInstance().getProperty("Date_birth"), Lang.getInstance().getProperty("Age"),
				"Email", Lang.getInstance().getProperty("User"), Lang.getInstance().getProperty("Password"), "Avatar", "Status",
				Lang.getInstance().getProperty("Benefits"), Lang.getInstance().getProperty("Entry_date"), Lang.getInstance().getProperty("Antique"),
				Lang.getInstance().getProperty("Purchase"), "Premium", Lang.getInstance().getProperty("Client_type") };

		set = (String) Menu.menucombobox(menuset, Lang.getInstance().getProperty("Request"),
				Lang.getInstance().getProperty("Select_attribute_to_modify"));

		pos = Menu.transform_comboobject_to_int(menuset, set);

		if (singleton.Client_array.size() != 0) {

			Iterator<Client> it = singleton.Client_array.iterator();
			while (it.hasNext()) {
				Object objeto = it.next();
				c = (Client) objeto;

				s = s + c.toString(pos);

			}

			JOptionPane.showMessageDialog(null, s);

		} else
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_client_type"));

	}

	/**
	 * Prints the selected attribute of all user_reg
	 */
	public static void Print_Array_user_reg_all() {

		String s = " ";
		User_reg u = null;
		String set = "";
		int pos = 0;

		String[] menuset = { "Dni", Lang.getInstance().getProperty("Name"), Lang.getInstance().getProperty("Last_name"),
				Lang.getInstance().getProperty("Mobile"), Lang.getInstance().getProperty("Date_birth"), Lang.getInstance().getProperty("Age"),
				"Email", Lang.getInstance().getProperty("User"), Lang.getInstance().getProperty("Password"), "Avatar", "Status",
				Lang.getInstance().getProperty("Benefits"), Lang.getInstance().getProperty("Activity"), "Karma" };

		set = (String) Menu.menucombobox(menuset, Lang.getInstance().getProperty("Request"),
				Lang.getInstance().getProperty("Select_attribute_to_modify"));

		pos = Menu.transform_comboobject_to_int(menuset, set);

		if (singleton.User_reg_array.size() != 0) {

			Iterator<User_reg> it = singleton.User_reg_array.iterator();
			while (it.hasNext()) {
				Object objeto = it.next();
				u = (User_reg) objeto;

				s = s + u.toString(pos);

			}

			JOptionPane.showMessageDialog(null, s);

		} else
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_user_registered_type"));

	}

	

	/**
	 * Imprime un usuario seleccionado client
	 */
	public static void Print_select_client() {

		Client c;
		String s = " ";
		String dni = "";
		int pos = 0;
		int n = singleton.Client_array.size();
		String cli[] = new String[n];

		
		if (singleton.Client_array.size() != 0) {
		for (int i = 0; i < n; i++) {
			c = (Client) singleton.Client_array.get(i);
			s = c.getDni() + " - " + c.getName() + " " + c.getLast_name();
			cli[i] = s;
		}
		String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));

		for (int j = 0; j < 9; j++) {

			dni += se.charAt(j);
		}

		pos = Look_for_dni.Look_for_dni_client(dni);

		JOptionPane.showMessageDialog(null, singleton.Client_array.get(pos));

		} else {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_client_type"));
		}
	}

	/**
	 * Imprime un usuario seleccionado user_reg
	 */
	public static void Print_select_user_reg() {

		User_reg u;
		String s = " ";
		String dni = "";
		int pos = 0;
		int n = singleton.User_reg_array.size();
		String cli[] = new String[n];

		
		if (singleton.User_reg_array.size() != 0) {
		for (int i = 0; i < n; i++) {
			u = (User_reg) singleton.User_reg_array.get(i);
			s = u.getDni() + " - " + u.getName() + " " + u.getLast_name();
			cli[i] = s;
		}
		String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));

		for (int j = 0; j < 9; j++) {

			dni += se.charAt(j);
		}

		pos = Look_for_dni.Look_for_dni_user_reg(dni);

		JOptionPane.showMessageDialog(null, singleton.User_reg_array.get(pos));

		} else {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_user_registered_type"));
		}
	}

	

	/**
	 * Modifica un usuario seleccionado client
	 */
	public static void Modify_select_client() {

		Client c;
		String s = " ";
		String dni = "";
		int pos = 0;
		int n = singleton.Client_array.size();
		String cli[] = new String[n];

		if (singleton.Client_array.size() != 0) {
			for (int i = 0; i < n; i++) {
				c = (Client) singleton.Client_array.get(i);
				s = c.getDni() + " - " + c.getName() + " " + c.getLast_name();
				cli[i] = s;
			}
			String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));

			for (int j = 0; j < 9; j++) {

				dni += se.charAt(j);
			}

			pos = Look_for_dni.Look_for_dni_client(dni);

			Dao_users.Clientset(pos);
		} else {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_client_type"));
		}
	}

	/**
	 * Modifica un usuario seleccionado user_reg
	 */
	public static void Modify_select_user_reg() {

		User_reg u;
		String s = " ";
		String dni = "";
		int pos = 0;
		int n = singleton.User_reg_array.size();
		String cli[] = new String[n];

		if (singleton.User_reg_array.size() != 0) {
			for (int i = 0; i < n; i++) {
				u = (User_reg) singleton.User_reg_array.get(i);
				s = u.getDni() + " - " + u.getName() + " " + u.getLast_name();
				cli[i] = s;
			}
			String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));

			for (int j = 0; j < 9; j++) {

				dni += se.charAt(j);
			}

			pos = Look_for_dni.Look_for_dni_user_reg(dni);

			Dao_users.User_regset(pos);

		} else {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_user_registered_type"));
		}
	}

	/**
	 * Borra todos los usuarios admin
	 */
	public static void Delete_all_admin() {

		if (singleton.Admin_array.size() == 0) {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"),
					Lang.getInstance().getProperty("Information"), JOptionPane.ERROR_MESSAGE);
		} else {

			// delete all objects to the
			// arraylist
			singleton.Admin_array.clear();
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("All_elements_have_been_deleted") + "\n"
					+ Lang.getInstance().getProperty("Remaining_number_of_elements") + singleton.Admin_array.size());
		}

	}

	/**
	 * Borra todos los usuarios client
	 */
	public static void Delete_all_client() {

		if (singleton.Client_array.size() == 0) {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"),
					Lang.getInstance().getProperty("Information"), JOptionPane.ERROR_MESSAGE);
		} else {

			// delete all objects to the
			// arraylist
			singleton.Client_array.clear();
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("An_element_has_been_deleted") + "\n"
					+ Lang.getInstance().getProperty("Remaining_number_of_elements") + singleton.Client_array.size());
		}

	}

	/**
	 * Borra todos los usuarios user_reg
	 */
	public static void Delete_all_user_reg() {

		if (singleton.User_reg_array.size() == 0) {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_erase_because_no_elements"),
					Lang.getInstance().getProperty("Information"), JOptionPane.ERROR_MESSAGE);
		} else {

			// delete all objects to the
			// arraylist
			singleton.User_reg_array.clear();
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("An_element_has_been_deleted") + "\n"
					+ Lang.getInstance().getProperty("Remaining_number_of_elements") + singleton.User_reg_array.size());
		}

	}

	/**
	 * Borra el usuario seleccionado admin.
	 */
	public static void Delete_select_admin() {

		Admin a;
		String s = " ";
		String dni = "";
		int pos = 0;
		int n = singleton.Admin_array.size();
		String cli[] = new String[n];

		if (singleton.Admin_array.size() != 0) {
			for (int i = 0; i < n; i++) {
				a = (Admin) singleton.Admin_array.get(i);
				s = a.getDni() + " - " + a.getName() + " " + a.getLast_name();
				cli[i] = s;
			}
			String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));

			for (int j = 0; j < 9; j++) {

				dni += se.charAt(j);

			}

			pos = Look_for_dni.Look_for_dni_admin(dni);

			singleton.Admin_array.remove(pos);

		} else {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_administrator_type"));
		}
	}

	/**
	 * Borra el usuario seleccionado client.
	 */
	public static void Delete_select_client() {

		Client c;
		String s = " ";
		String dni = "";
		int pos = 0;
		int n = singleton.Client_array.size();
		String cli[] = new String[n];

		if (singleton.Client_array.size() != 0) {
			for (int i = 0; i < n; i++) {
				c = (Client) singleton.Client_array.get(i);
				s = c.getDni() + " - " + c.getName() + " " + c.getLast_name();
				cli[i] = s;
			}
			String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));

			for (int j = 0; j < 9; j++) {

				dni += se.charAt(j);
			}

			pos = Look_for_dni.Look_for_dni_client(dni);

			singleton.Client_array.remove(pos);

		} else {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_client_type"));
		}
	}

	/**
	 * Borra el usuario seleccionado user_reg.
	 */
	public static void Delete_select_user_reg() {

		User_reg u;
		String s = " ";
		String dni = "";
		int pos = 0;
		int n = singleton.User_reg_array.size();
		String cli[] = new String[n];

		if (singleton.User_reg_array.size() != 0) {
			for (int i = 0; i < n; i++) {
				u = (User_reg) singleton.User_reg_array.get(i);
				s = u.getDni() + " - " + u.getName() + " " + u.getLast_name();
				cli[i] = s;
			}
			String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));

			for (int j = 0; j < 9; j++) {

				dni += se.charAt(j);
			}

			pos = Look_for_dni.Look_for_dni_user_reg(dni);

			singleton.User_reg_array.remove(pos);

		} else {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_user_registered_type"));
		}
	}

}
