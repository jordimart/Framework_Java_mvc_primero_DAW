package Appweb.Modules.Users.model.BLL;

import Appweb.Modules.Users.model.Classes.singleton;

/**
 * 
 * @author Jorge Martinez Frias
 *
 */
public class Look_for_dni {

	

	/**
	 * Busca un dni introducido en una arraylist Client y nos devuelve la
	 * posicion.
	 * 
	 * @param dni
	 *            (string)
	 * @return pos (int posicion en el array)
	 */
	public static int Look_for_dni_client(String dni) {

		int pos = -1;

		for (int i = 0; i < singleton.Client_array.size() ; i++) {

			if (singleton.Client_array.get(i).getDni().equals(dni))

				pos = i;

		}

		return pos;

	}

	/**
	 * Busca un dni introducido en una arraylist User_reg y nos devuelve la
	 * posicion.
	 * 
	 * @param dni
	 *            (string)
	 * @return pos (int posicion en el array)
	 */
	public static int Look_for_dni_user_reg(String dni) {

		int pos = -1;

		for (int i = 0; i < singleton.User_reg_array.size() ; i++) {

			if (singleton.User_reg_array.get(i).getDni().equals(dni))

				pos = i;

		}

		return pos;

	}

}
