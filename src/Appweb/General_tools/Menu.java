package Appweb.General_tools;

/**
 * @author Jorge Martinez Frias
 * @version 2.0 start 2_1_2016
 * Estos menus son genericos y nos sirven para toda la aplicacion por eso estan en Tools a nivel general de la app.
 * En esta version hemos creado una clase para menus llamada M_tools.
 * Incluidos menu botones y combobox basicos.
 * Incluidos menus combobox para lenguaje,formato de fecha,moneda y numero de decimales.
 * Incluido menu para elegir que datos modificar en la configuracion.
 * 
 */

import javax.swing.JOptionPane;

import Appweb.Classes.Language.Lang;
import Appweb.Modules.Users.Classes.singleton;

public class Menu {

	/////////////////// MENUS//////////////////////

	// Basics Menus

	/**
	 * Main with bottons basic.
	 * 
	 * @param modelo
	 * @param titulo
	 * @param mensaje
	 * @return int
	 */
	public static int menubotones(String[] modelo, String titulo, String mensaje) {

		int opcion = 0;

		opcion = JOptionPane.showOptionDialog(null, mensaje, titulo, 0, JOptionPane.QUESTION_MESSAGE, null, modelo, modelo[0]);
		// if (opcion == -1)
		// JOptionPane.showMessageDialog(null, "Completed aplication", "Saliendo
		// ...", JOptionPane.INFORMATION_MESSAGE);// elige
		// salir

		return opcion;
	}

	/**
	 * Main with combobox basic.
	 * 
	 * @param modelo
	 *            modelo declarate in main
	 * @param titulo
	 *            string
	 * @param mensaje
	 *            string
	 * @return object
	 */
	public static Object menucombobox(String[] modelo, String titulo, String mensaje) {

		Object obj = null;

		obj = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE, null, modelo, modelo[0]);

		if (obj == null)

			obj = "Back";

		return obj;

	}

	/**
	 * This Main load string in the main .
	 * 
	 * @param vMenu
	 * @param s
	 * @return int
	 * 
	 */
	public static String Menu_carga_array(Object vMenu[], String s) {

		String option = "";
		Object select = JOptionPane.showInputDialog(null, s, Lang.getInstance().getProperty("Request"), JOptionPane.QUESTION_MESSAGE, null, vMenu,
				"vMenu[0]");
		if (select == null)
			option = (String) "Back";
		else
			option = (String) select;
		return option;
	}

	/**
	 * Este menu devuelve un string conected o disconected.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return string Conected or Disconected
	 */
	public static String string_status(String mensaje, String titulo) {

		String status = "";
		int option = 0;
		String[] submenu = { "Conected", "Disconected" };

		option = Menu.menubotones(submenu, titulo, mensaje);

		if (option == 0)
			status = "Conected";
		else
			status = "Disconected";

		return status;
	}

	/**
	 * Este menu devuelve un string yes o no.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return string Yes or No
	 */
	public static String string_Yes_No(String mensaje, String titulo) {

		String status = "";
		int option = 0;
		String[] submenu = { "Yes", "No" };

		option = Menu.menubotones(submenu, titulo, mensaje);

		if (option == 0)
			status = "Yes";
		else
			status = "No";

		return status;
	}

	/**
	 * Menu pque pregunta opciones con respuesta si o no.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return int 0,1
	 */
	public static int menu_Yes_No(String mensaje, String titulo) {

		int option = 0;
		String[] submenu = { "Yes", "No" };

		option = Menu.menubotones(submenu, titulo, mensaje);

		return option;
	}

	/**
	 * Este menu devuelve un string de nivel de karma High,Medium o Low
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return string High,Medium o Low
	 */
	public static String string_karma(String mensaje, String titulo) {

		String karma = "";
		int option = 0;
		String[] submenu = { "High", "Medium", "Low" };

		option = Menu.menubotones(submenu, titulo, mensaje);

		if (option == 0)

			karma = ("High level");

		else if (option == 1)

			karma = ("Medium level");

		else

			karma = ("Low level");

		return karma;
	}

	///// Menus for Main/////////////////////

	

	/**
	 * Funcion para cambiar el retono de un combobox de objet/string a numero
	 * int, con lo cual no afecta a los idiomas.
	 * 
	 * @param menu
	 * @param set
	 * @return int posicion
	 */
	public static int transform_comboobject_to_int(String[] menu, String set) {

		String s = "";
		int pos = 0;
		try {
			for (int j = 0; j < menu.length; j++) {

				s = menu[j];
				singleton.Object_array.add(s);
			}

			for (int j = 0; j < singleton.Object_array.size(); j++) {
				if (singleton.Object_array.get(j).equals(set))

					pos = j;
			}

			singleton.Object_array.clear();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print("Error al cargar");
		}

		return pos;

	}
}
