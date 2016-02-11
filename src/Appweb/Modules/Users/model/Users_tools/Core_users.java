package Appweb.Modules.Users.model.Users_tools;

import javax.swing.JOptionPane;

import Appweb.Classes.Language.Lang;
import Appweb.Modules.Users.model.BLL.Look_for_dni;
import Appweb.Tools.Request_variable;
import Appweb.Tools.Validate;

/**
 * 
 * @author Jorge Martinez Frias
 * @version 1.0
 *
 */

public class Core_users {

	/**
	 * Fucion que valida que el dni pueda existir.Valida para dni generico.
	 * 
	 * @param message
	 * @param title
	 * @return string dni
	 */
	public static String Enterdni(String message, String title) {

		int num = 0, rest = 0;
		char letter = ' ', pass = ' ';
		String dni = "", aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";
		boolean ok = false;

		do {

			dni = Request_variable.damestring(message, title);
			dni = dni.toUpperCase();
			ok = Validate.okdni(dni);

			if (ok == false)
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
			else {

				aux = "";

				for (int i = 0; i < 8; i++) {
					aux += dni.charAt(i);
				}

				letter = dni.charAt(8);
				num = Integer.parseInt(aux);
				rest = num % 23;

				pass = car.charAt(rest);

				if (pass == letter) {
					ok = true;
				} else {
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_Dni_don't_exist"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
					ok = false;
				}
			} // end else

		} while (ok == false);

		return dni;
	}

	/**
	 * Fucion que valida que el dni pueda existir.Pero ademas comprueba que no
	 * este repetido en los Admin.
	 * 
	 * @param message
	 * @param title
	 * @return string dni
	 */
	public static String Enterdnia(String message, String title) {

		int num = 0, rest = 0;
		char letter = ' ', pass = ' ';
		String dni = "", aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";
		boolean ok = false;
		int pos = -1;

		do {

			dni = Request_variable.damestring(message, title);
			dni = dni.toUpperCase();
			ok = Validate.okdni(dni);
			if (ok == false)
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
			else {

				aux = "";

				for (int i = 0; i < 8; i++) {
					aux += dni.charAt(i);
				}

				letter = dni.charAt(8);
				num = Integer.parseInt(aux);
				rest = num % 23;

				pass = car.charAt(rest);

				if (pass == letter) {
					ok = true;
				} else {
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_Dni_don't_exist"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
					ok = false;
				}
			} // end else

			if (ok == true) {

				pos = Look_for_dni.Look_for_dni_admin(dni);

				if (pos != -1) {

					ok = false;
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_repeat_dni"));
				} else {

					ok = true;
				}

			}

		} while (ok == false);

		return dni;
	}

	/**
	 * Fucion que valida que el dni pueda existir.Pero ademas comprueba que no
	 * este repetido en los Client.
	 * 
	 * @param message
	 * @param title
	 * @return string dni
	 */
	public static String Enterdnic(String message, String title) {

		int num = 0, rest = 0;
		char letter = ' ', pass = ' ';
		String dni = "", aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";
		boolean ok = false;
		int pos = -1;

		do {

			dni = Request_variable.damestring(message, title);
			dni = dni.toUpperCase();
			ok = Validate.okdni(dni);
			if (ok == false)
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
			else {

				aux = "";

				for (int i = 0; i < 8; i++) {
					aux += dni.charAt(i);
				}

				letter = dni.charAt(8);
				num = Integer.parseInt(aux);
				rest = num % 23;

				pass = car.charAt(rest);

				if (pass == letter) {
					ok = true;
				} else {
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_Dni_don't_exist"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
					ok = false;
				}
			} // end else

			if (ok == true) {

				pos = Look_for_dni.Look_for_dni_client(dni);

				if (pos != -1) {

					ok = false;

					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_repeat_dni"));
				} else {

					ok = true;
				}

			}

		} while (ok == false);

		return dni;
	}

	/**
	 * Fucion que valida que el dni pueda existir.Pero ademas comprueba que no
	 * este repetido en los User_reg.
	 * 
	 * @param message
	 * @param title
	 * @return string dni
	 */
	public static String Enterdniu(String message, String title) {

		int num = 0, rest = 0;
		char letter = ' ', pass = ' ';
		String dni = "", aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";
		boolean ok = false;
		int pos = -1;

		do {

			dni = Request_variable.damestring(message, title);
			dni = dni.toUpperCase();
			ok = Validate.okdni(dni);
			if (ok == false)
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
			else {

				aux = "";

				for (int i = 0; i < 8; i++) {
					aux += dni.charAt(i);
				}

				letter = dni.charAt(8);
				num = Integer.parseInt(aux);
				rest = num % 23;

				pass = car.charAt(rest);

				if (pass == letter) {
					ok = true;
				} else {
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_Dni_don't_exist"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
					ok = false;
				}
			} // end else

			if (ok == true) {

				pos = Look_for_dni.Look_for_dni_user_reg(dni);

				if (pos != -1) {

					ok = false;
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_repeat_dni"));
				} else {

					ok = true;
				}

			}

		} while (ok == false);

		return dni;
	}

	/**
	 * Menu que pise una palabra como un nombre o nombre compuesto.Solo letras.
	 * 
	 * @param message
	 * @param title
	 * @return string palabra
	 */
	public static String Enterword(String message, String title) {

		String s = "";
		boolean ok = false;

		do {

			s = Request_variable.damestring(message, title);
			ok = Validate.okword(s);
			if (ok == false)
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
		} while (ok == false);

		return s;
	}

	/**
	 * Menu que pise un numero de telefono movil con nueve digitos.
	 * 
	 * @param message
	 * @param title
	 * @return string movil
	 */
	public static String Entermobile(String message, String title) {

		String s = "";
		boolean ok = false;

		do {

			s = Request_variable.damestring(message, title);
			ok = Validate.okmobile(s);
			if (ok == false)
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
		} while (ok == false);

		return s;
	}

	/**
	 * Menu que pide una edad de dos digitos maximo.
	 * 
	 * @param message
	 * @param title
	 * @return
	 */
	public static String Enterage(String message, String title) {

		String num = "";
		boolean ok = false;

		do {

			num = Request_variable.damestring(message, title);
			ok = Validate.okage(num);
			if (ok == false)
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
		} while (ok == false);

		return num;
	}

	/**
	 * Menu que pide un email y valida su formato.
	 * 
	 * @param message
	 * @param title
	 * @return
	 */
	public static String Entermail(String message, String title) {

		String cad = "";
		boolean ok = false;

		do {

			cad = Request_variable.damestring(message, title);
			ok = Validate.okmail(cad);
			if (ok == false)
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
		} while (ok == false);

		return cad;
	}

	/**
	 * Menu que pide una palabra que puede tener todo tipo de caracteres.
	 * 
	 * @param message
	 * @param title
	 * @return
	 */
	public static String Enterwordfull(String message, String title) {

		String cad = "";
		boolean ok = false;

		do {

			cad = Request_variable.damestring(message, title);
			ok = Validate.okwordfull(cad);
			if (ok == false)
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
		} while (ok == false);

		return cad;
	}

}
