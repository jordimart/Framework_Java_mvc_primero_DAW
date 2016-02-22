package Appweb.Modules.Users.Users_tools;

import javax.swing.JOptionPane;

import Appweb.Classes.Language.Lang;
import Appweb.Modules.Users.Classes.singleton;

/**
 * 
 * @author Jorge Martinez Frias
 *
 */
public class Menu_users {

	//// Menus de botones para users con eleccion de lenguajes//////

	/**
	 * Menu para opciones de tipo de usuario. Solo hay que a�adir en el main
	 * string vacio, ya carga tiulo,mensaje y su idioma Elegimos el tipo de
	 * usuario con el que vamos a trabajar.
	 * 
	 * @param titulo
	 *            string
	 * @param mensaje
	 *            string
	 * @param l
	 *            (pasamos objeto con idioma)
	 * @return int con la opcion escogida(retornamos un int)
	 */
	public static int menubotonesusers(String titulo, String mensaje) {

		int opcion = 0;
		String[] menu = { Lang.getInstance().getProperty("Admin"), Lang.getInstance().getProperty("Client"),
				Lang.getInstance().getProperty("Registered_User"), Lang.getInstance().getProperty("Back") };

		opcion = JOptionPane.showOptionDialog(null, Lang.getInstance().getProperty("Select_one_option"), Lang.getInstance().getProperty("Main_menu"),
				0, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);

		return opcion;
	}

	/**
	 * Menu de tareas a realizar en el usuario elegido. Solo hay que a�adir
	 * string en el main vacio y carga las frases. Elegimos que tareas vamos a
	 * realizar, crear,modificar un dato o mostrar datos.
	 * 
	 * @param titulo
	 *            string
	 * @param mensaje
	 *            string
	 * @param l
	 *            (pasamos objeto con idioma)
	 * @return int con la opcion escogida(retornamos un int)
	 */
	public static int menubotonestask_users(String titulo, String mensaje) {

		int opcion = 0;
		String[] menu = { Lang.getInstance().getProperty("Create_user"), Lang.getInstance().getProperty("Edit_attribute"),
				Lang.getInstance().getProperty("Print"), Lang.getInstance().getProperty("Delete"), Lang.getInstance().getProperty("Order"),
				Lang.getInstance().getProperty("Open_file"), Lang.getInstance().getProperty("Save_file"), Lang.getInstance().getProperty("Back") };

		opcion = JOptionPane.showOptionDialog(null, Lang.getInstance().getProperty("What_would_you_like_to_do?"), titulo, 0,
				JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);

		return opcion;
	}

	/**
	 * Menu para elegir si queremos borrar todos los elementos o uno apeticion.
	 * @param titulo
	 * @param mensaje
	 * @return
	 * int
	 */
	public static int menu_delete(String titulo, String mensaje) {

		int opcion = 0;

		String[] menu = { Lang.getInstance().getProperty("Delete_all_elements"), Lang.getInstance().getProperty("Delete_user_with_dni_request"),
				Lang.getInstance().getProperty("Back") };

		opcion = JOptionPane.showOptionDialog(null, Lang.getInstance().getProperty("What_would_you_like_to_do?"),
				Lang.getInstance().getProperty("Delete"), 0, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
		if (opcion == -1)
			opcion = 2;

		return opcion;
	}

	/**
	 * Menu para elegir si queremos imprimir solo clave primaria,todos los elementos,todos los atributos a peticion o un elemento con selecion previa.
	 * @param titulo
	 * @param mensaje
	 * @return
	 * int
	 */
	public static int menu_print(String titulo, String mensaje) {

		int opcion = 0;

		String[] menu = { Lang.getInstance().getProperty("Print_key_element_from_all_users"),
				Lang.getInstance().getProperty("Print_all_elements_from_all_users"), Lang.getInstance().getProperty("Print_element_to_request"),
				Lang.getInstance().getProperty("Print_chosen_user"), Lang.getInstance().getProperty("Back") };

		opcion = JOptionPane.showOptionDialog(null, Lang.getInstance().getProperty("What_would_you_like_to_print?"),
				Lang.getInstance().getProperty("Print"), 0, JOptionPane.QUESTION_MESSAGE, null, menu, menu[0]);
		if (opcion == -1)
			opcion = 4;

		return opcion;
	}

	/**
	 * Menu para elegir un usuario que este en el arraylist.
	 * @param titulo
	 * @param mensaje
	 * @return
	 * Objeto/string
	 */
	public static Object menucomboboxl(String titulo, String mensaje) {

		Object obj = null;

		String[] combo = { singleton.Admin_array.toString() };

		obj = JOptionPane.showInputDialog(null,Lang.getInstance().getProperty( "Select_user"), Lang.getInstance().getProperty("Request"), JOptionPane.QUESTION_MESSAGE, null,
				combo, combo[0]);
		if (obj == null)

			obj = Lang.getInstance().getProperty("Back");

		return obj;

	}
}