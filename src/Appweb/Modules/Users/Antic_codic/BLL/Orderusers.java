package Appweb.Modules.Users.Antic_codic.BLL;

import java.util.Collections;

import javax.swing.JOptionPane;

import Appweb.Modules.Config.Classes.Language.Lang;
import Appweb.Modules.Users.Classes.singleton;
import Appweb.Modules.Users.Classes.Order.OrderBenefits;
import Appweb.Modules.Users.Classes.Order.Orderdate_birth;
import Appweb.Modules.Users.Classes.Order.Orderlast_name;
import Appweb.Modules.Users.Classes.Order.Ordername;
import Appweb.General_tools.Menu;

/**
 * 
 * @author Jorge Martinez Frias
 *
 */
public class Orderusers {

	/**
	 * Menu combo para elegir ordenar los elementos por sus atributos. Atributos
	 * activos Dni,Name,Las_name,Date_birth,Benefits.
	 * 
	
	 * 
	 */
	public static void orderadmin() {

		String[] menuset = { "Dni", "Name", "Last_name", "Date_birth", "Benefits", Lang.getInstance().getProperty("Back") };

		String menu = "";
		// comprobamos que no esta vacio
		if (singleton.Admin_array.isEmpty()) {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_administrator_type"), "Error", JOptionPane.ERROR_MESSAGE);
		} else {

			menu = (String) Menu.menucombobox(menuset, Lang.getInstance().getProperty("Request"),
					Lang.getInstance().getProperty("Select_attribute_to_modify"));

			// order = menu.charAt(0);
			switch (menu) {

			case "Dni":

				Collections.sort(singleton.Admin_array);
				BLL_users.Print_Array_admin();

				break;
			case "Name":

				Collections.sort(singleton.Admin_array, new Ordername());
				BLL_users.Print_Array_admin();

				break;

			case "Last_name":

				Collections.sort(singleton.Admin_array, new Orderlast_name());
				BLL_users.Print_Array_admin();

				break;

			case "Date_birth":

				Collections.sort(singleton.Admin_array, new Orderdate_birth());
				BLL_users.Print_Array_admin();

				break;

			case "Benefits":

				Collections.sort(singleton.Admin_array, new OrderBenefits());
				BLL_users.Print_Array_admin();

				break;

			}
		}
	}

	/**
	 * Menu combo para elegir ordenar los elementos por sus atributos. Atributos
	 * activos Dni,Name,Las_name,Date_birth,Benefits.
	 * 
	 * @param l
	 *            (Objeto lenguage)
	 * @param a
	 *            (object tipo de elemento)
	 */
	public static void orderclient() {

		String[] menuset = { "Dni", "Name", "Last_name", "Date_birth", "Benefits", Lang.getInstance().getProperty(" Back") };

		String menu = "";

		if (singleton.Client_array.isEmpty()) {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_client_type"), "Error", JOptionPane.ERROR_MESSAGE);
		} else {

			menu = (String) Menu.menucombobox(menuset, Lang.getInstance().getProperty("Request"),
					Lang.getInstance().getProperty("Select_attribute_to_modify"));

			// order = menu.charAt(0);
			switch (menu) {

			case "Dni":

				Collections.sort(singleton.Client_array);
				BLL_users.Print_Array_client();

				break;
			case "Name":

				Collections.sort(singleton.Client_array, new Ordername());
				BLL_users.Print_Array_client();

				break;

			case "Last_name":

				Collections.sort(singleton.Client_array, new Orderlast_name());
				BLL_users.Print_Array_client();

				break;

			case "Date_birth":

				Collections.sort(singleton.Client_array, new Orderdate_birth());
				BLL_users.Print_Array_client();

				break;

			case "Benefits":

				Collections.sort(singleton.Client_array, new OrderBenefits());
				BLL_users.Print_Array_client();

				break;

			}
		}
	}

	/**
	 * Menu combo para elegir ordenar los elementos por sus atributos. Atributos
	 * activos Dni,Name,Las_name,Date_birth,Benefits.
	 * 
	 * @param l
	 *            (Objeto lenguage)
	 * @param a
	 *            (object tipo de elemento)
	 */
	public static void orderuser_reg() {

		String[] menuset = { "Dni", "Name", "Last_name", "Date_birth", "Benefits", Lang.getInstance().getProperty(" Back") };

		String menu = "";

		if (singleton.User_reg_array.isEmpty()) {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_user_registered_type"), "Error", JOptionPane.ERROR_MESSAGE);
		} else {

			menu = (String) Menu.menucombobox(menuset, Lang.getInstance().getProperty("Request"),
					Lang.getInstance().getProperty("Select_attribute_to_modify"));

			// order = menu.charAt(0);
			switch (menu) {

			case "Dni":

				Collections.sort(singleton.User_reg_array);
				BLL_users.Print_Array_user_reg();

				break;
			case "Name":

				Collections.sort(singleton.User_reg_array, new Ordername());
				BLL_users.Print_Array_user_reg();

				break;

			case "Last_name":

				Collections.sort(singleton.User_reg_array, new Orderlast_name());
				BLL_users.Print_Array_user_reg();

				break;

			case "Date_birth":

				Collections.sort(singleton.User_reg_array, new Orderdate_birth());
				BLL_users.Print_Array_user_reg();

				break;

			case "Benefits":

				Collections.sort(singleton.User_reg_array, new OrderBenefits());
				BLL_users.Print_Array_user_reg();

				break;

			}
		}
	}

}
