package Appweb.Tools;

import javax.swing.JOptionPane;


import Appweb.Classes.Config.Classconfig;
import Appweb.Classes.Language.Lang;
import Appweb.Modules.Users.model.BLL.Dummy_array_add_users;
import Appweb.Modules.Users.model.Users_tools.User_files.json;
import Appweb.Modules.Users.model.Users_tools.User_files.txt;
import Appweb.Modules.Users.model.Users_tools.User_files.xml;

/**
 * 
 * @author Jorge Martinez Frias
 *
 */
public class Menus_config {
	//// Menus de combobox individuales para configuracion de parametros//////

	/**
	 * Main combox for select language
	 * 
	 * @param titulo
	 *            String
	 * @param mensaje
	 *            String
	 * 
	 * @return object
	 */
	public static Object menucomboboxl(String titulo, String mensaje) {

		Object obj = null;

		String[] combo = { "english", "español", "valencia" };

		obj = JOptionPane.showInputDialog(null, Lang.getInstance().getProperty("Select_language"), Lang.getInstance().getProperty("Request"),
				JOptionPane.QUESTION_MESSAGE, null, combo, combo[0]);
		if (obj == null)

			obj = Lang.getInstance().getProperty("english");

		return obj;

	}

	/**
	 * Main combox for select format date
	 * 
	 * @param titulo
	 *            String
	 * @param mensaje
	 *            String
	 * 
	 * @return object
	 */
	public static Object menucomboboxd(String titulo, String mensaje) {

		Object obj = null;

		String[] combo = { "dd/mm/yyyy", "dd-mm-yyyy", "yyyy/mm/dd", "yyyy-mm-dd" };

		obj = JOptionPane.showInputDialog(null, Lang.getInstance().getProperty("Select_format_date"), Lang.getInstance().getProperty("Request"),
				JOptionPane.QUESTION_MESSAGE, null, combo, combo[0]);

		if (obj == null)

			obj = Lang.getInstance().getProperty("dd/mm/yyyy");

		return obj;

	}

	/**
	 * Main combox for select currency
	 * 
	 * @param titulo
	 *            String
	 * @param mensaje
	 *            String
	 * 
	 * @return object
	 */
	public static Object menucomboboxc(String titulo, String mensaje) {

		Object obj = null;

		String[] combo = { "euro", "dolar", "pound" };
		obj = JOptionPane.showInputDialog(null, Lang.getInstance().getProperty("Select_currency"), Lang.getInstance().getProperty("Request"),
				JOptionPane.QUESTION_MESSAGE, null, combo, combo[0]);

		if (obj == null)

			obj = Lang.getInstance().getProperty("euro");

		return obj;

	}

	/**
	 * Main combox for select number of decimal
	 * 
	 * @param titulo
	 *            String
	 * @param mensaje
	 *            String
	 *
	 * @return object
	 */
	public static Object menucomboboxdec(String titulo, String mensaje) {

		Object obj = null;

		String[] combo = { "0.0", "0.00", "0.000" };
		obj = JOptionPane.showInputDialog(null, Lang.getInstance().getProperty("Select_number_of_decimals"),
				Lang.getInstance().getProperty("Request"), JOptionPane.QUESTION_MESSAGE, null, combo, combo[0]);

		if (obj == null)

			obj = Lang.getInstance().getProperty("0.00");

		return obj;

	}

	/**
	 * Main combox for select file type
	 * 
	 * @param titulo
	 *            String
	 * @param mensaje
	 *            String
	 *
	 * @return object
	 */
	public static Object menucomboboxfile(String titulo, String mensaje) {

		Object obj = null;

		String[] combo = { "xml", "txt", "json" };
		obj = JOptionPane.showInputDialog(null, Lang.getInstance().getProperty("Select_format_file"), Lang.getInstance().getProperty("Request"),
				JOptionPane.QUESTION_MESSAGE, null, combo, combo[0]);

		if (obj == null)

			obj = Lang.getInstance().getProperty("json");

		return obj;

	}

	/// Menu for select app configuration////

	/**
	 * Main bottons for select submenu format date,currency,num decimals and
	 * language
	 * 
	 * @param titulo
	 *            String
	 * @param mensaje
	 *            String
	 * 
	 * @return int
	 */
	public static int menubotones_config(String titulo, String mensaje) {

		int opcion = 0;

		String[] menu = { Lang.getInstance().getProperty("Select_format_date"), Lang.getInstance().getProperty("Select_currency"),
				Lang.getInstance().getProperty("Select_number_of_decimals"), Lang.getInstance().getProperty("Select_language"),
				Lang.getInstance().getProperty("File_format"), Lang.getInstance().getProperty("Open/Save"), Lang.getInstance().getProperty("Print"),
				Lang.getInstance().getProperty("Back") };

		opcion = JOptionPane.showOptionDialog(null, Lang.getInstance().getProperty("What_would_you_like_to_do?"),
				Lang.getInstance().getProperty("Select_one_option"), 0, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
		if (opcion == -1)
			
			opcion=7;

		return opcion;
	}

	/**
	 * Main bottons for select submenu Parameter settings and graphics settings
	 * 
	 * 
	 * @param titulo
	 *            String
	 * @param mensaje
	 *            String
	 *
	 * @return int
	 */
	public static int menuselect_type_config(String titulo, String mensaje) {

		int option = 0;

		String[] menu = { Lang.getInstance().getProperty("Parameter_Settings"), Lang.getInstance().getProperty("Graphics_settings"),
				Lang.getInstance().getProperty("Back") };

		option = JOptionPane.showOptionDialog(null, Lang.getInstance().getProperty("What_would_you_like_to_do?"),
				Lang.getInstance().getProperty("Select_one_option"), 0, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
		if (option == -1)
			option=2;

		return option;
	}

	/**
	 * Main bottons for select load settings or save settings in file.
	 * 
	 * 
	 * @param titulo
	 *            String
	 * @param mensaje
	 *            String
	 *
	 * @return int
	 */
	public static void menuselect_open_save_config(String titulo, String mensaje) {

		int option = 0;

		String[] menu = { Lang.getInstance().getProperty("Load_settings"),Lang.getInstance().getProperty("Save_configuration"), Lang.getInstance().getProperty("Back") };

		option = JOptionPane.showOptionDialog(null, Lang.getInstance().getProperty("What_would_you_like_to_do?"),
				Lang.getInstance().getProperty("Select_one_option"), 0, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
		if (option == -1) {
			option=2;
			
		}

		switch (option) {
		case 0:

			if (Classconfig.getInstance().getFile() == "json") {
				Config_tools.open_json_config();
			}
			if (Classconfig.getInstance().getFile() == "txt") {
				Config_tools.open_txt_config();
			}
			if (Classconfig.getInstance().getFile() == "xml") {
				Config_tools.open_xml_config();
			}
			break;
		case 1:
			if (Classconfig.getInstance().getFile() == "json") {
				Config_tools.save_json_config();
			}
			if (Classconfig.getInstance().getFile() == "txt") {
				Config_tools.save_txt_config();
			}
			if (Classconfig.getInstance().getFile() == "xml") {
				Config_tools.save_xml_config();
			}
			break;

		}

	}

	/**
	 * Function menu that contains the configuration of basic parameters of the
	 * app. In the menu data such as date format , currency , number of decimals
	 * and language of the application they are configured.
	 * 
	 * @param clas
	 *            (config object)
	 *
	 * @return (config object modified)
	 */
	public static void Menu_pack_config() {

		/**
		 * String datef = clas.getdatef(); String currency = clas.getCurrency();
		 * String num_dec = clas.getnum_dec(); String language =
		 * clas.getLanguage();
		 */
		String string = " ";
		int sec = 0;
		String set = " ";

		do {

			sec = Menus_config.menubotones_config(string, string);

			switch (sec) {

			case 0:// Date format//

				Classconfig.getInstance().setdatef((String) Menus_config.menucomboboxd(string, string));

				break;

			case 1:// Currency//

				Classconfig.getInstance().setCurrency((String) Menus_config.menucomboboxc(string, string));

				break;

			case 2:// Number of decimal//

				Classconfig.getInstance().setnum_dec((String) Menus_config.menucomboboxdec(string, string));

				break;

			case 3:// Language//

				set = (String) Menus_config.menucomboboxl(string, string);

				switch (set) {

				case "english":
					Classconfig.getInstance().setLanguage("english");
					
					break;
				case "español":
					Classconfig.getInstance().setLanguage("español");
					
					break;
				case "valencia":
					Classconfig.getInstance().setLanguage("valencia");
					
					break;

				}

				break;

			case 4:// Format file

				Classconfig.getInstance().setFile((String) Menus_config.menucomboboxfile(string, string));

				break;

			case 5:// Print configure attributes

				Menus_config.menuselect_open_save_config(string, string);

				break;
			case 6:// Print configure attributes

				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Configuration") + ":\n " + Classconfig.getInstance().tostring(),
						Lang.getInstance().getProperty("Current_configuration"), JOptionPane.INFORMATION_MESSAGE);

				break;

			}

		} while (sec != 7);// al finalizar la opcion vuelve a
							// preguntar
		sec = 3;

	}

	/**
	 * This function changes the appearance of the application. Options
	 * Metal,System,Motif,Nimbus and Windows classic
	 * 
	
	 */
	public static void Menu_theme() {

		String s = " ";

		String[] combo = { "Metal", "System", "Motif", "Nimbus", "Windows classic", Lang.getInstance().getProperty("Back") };

		s = (String) Menu.menucombobox(combo, "Theme", Lang.getInstance().getProperty("Select_theme"));

		try {
			switch (s) {

			case "Metal":// Metal
				Classconfig.getInstance().setTheme("Metal");

				break;

			case "System":// GTK - WINDOWS
				Classconfig.getInstance().setTheme("System");
				break;

			case "Motif":// CDE/Motif
				Classconfig.getInstance().setTheme("Motif");
				break;

			case "Nimbus":// Nimbus

				Classconfig.getInstance().setTheme("Nimbus");

				break;// Windows Clasic

			case "Windows classic":

				Classconfig.getInstance().setTheme("Windows classic");

				break;

			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_appearance_failed_to_change"), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Function to start aplication with some settings.
	 * 
	 * Open last settings.
	 * Open files of users.
	 * Question to start with dummies or not.
	 * If dummy is press tehe dummy configuration will be save true.
	 */
	public static void Main_start_1() {

		int option = 0;

		Config_tools.open_all_file_config_format();

		
		xml.auto_open_xml_file();
		txt.auto_open_txt_file();
		json.auto_open_json_file();

		if (Classconfig.getInstance().getDummy() == true) {

			option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Dummy_information_start"), Lang.getInstance().getProperty("Boot"));

			if (option == 0) {
				Dummy_array_add_users.Dummyrequest_init_10();
			} else {

				Classconfig.getInstance().setDummy(false);
			}
		}
	}

	/**
	 * Function to exit aplication.
	 * 
	 * Question to save or not save settings configuration.
	 * Question to save users modification or no.
	 * Exit the aplication.
	 */
	public static void Main_exit_and_save() {

		int option = 0;

		option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_save_the_settings?"), Lang.getInstance().getProperty("Menu_output"));

		if (option == 0) {
			Config_tools.save_all_file_config_format();
		}

		option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_Want_to_save_the_changes_to_users?"),
				Lang.getInstance().getProperty("Menu_output"));

		if (option == 0) {
			xml.auto_save_xml_file();
			txt.auto_save_txt_file();
			json.auto_save_json_file();
		}

		JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
				JOptionPane.INFORMATION_MESSAGE);
		System.exit(0);

	}

}
