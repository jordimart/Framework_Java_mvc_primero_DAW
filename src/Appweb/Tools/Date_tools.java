package Appweb.Tools;

import javax.swing.JOptionPane;

import Appweb.Modules.Config.Classconfig;
import Appweb.Classes.Date.ClassDate;
import Appweb.Classes.Language.Lang;

/**
 * 
 * @author Jorge Martinez Frias
 *
 *
 */

public class Date_tools {

	/**
	 * Menu para introducir una fecha con un parametro minimo que puede servir
	 * para determinar la edad minma. Valida que sea una fecha correcta en
	 * dias,meses y a�os. Calcula los a�os y lo compara con el minimo para
	 * dejarlo pasar o no. Valida el formato correcto.
	 * 
	 * @param message
	 * @param title
	 * @param min
	 *            numero int minimo
	 * @return objeto de tipo fecha.
	 * 
	 */
	public static ClassDate Date_min_condition(String message, String title, int min) {

		String date = "";
		boolean val1 = false;
		int age = 0;

		do {

			switch (Classconfig.getInstance().getdatef()) {

			case "dd/mm/yyyy":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Birthday_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": dd/mm/yyyy", title);
				break;
			case "dd-mm-yyyy":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Birthday_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": dd-mm-yyyy", title);
				break;
			case "yyyy/mm/dd":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Birthday_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": yyyy/mm/dd", title);
				break;
			case "yyyy-mm-dd":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Birthday_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": yyyy-mm-dd", title);
				break;

			}

			// validamos el formato con forma regular.
			val1 = Validate.okdate(date);

			if (val1 == true) {

				ClassDate c = new ClassDate(date);

				if (c.okdate() == true) {

					val1 = true;

					// calculamos la edad
					age = c.Diference_system_date();

				} else {

					val1 = false;

					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
				}

				if (age >= min) {

					val1 = true;

				} else {
					val1 = false;

					JOptionPane.showMessageDialog(null,
							Lang.getInstance().getProperty("You_can_not_register,_you_must_be") + min + Lang.getInstance().getProperty("years"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
				}
			} // end first if

			else {

				val1 = false;

				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
			}
		} while (val1 == false);

		return new ClassDate(date);
	}

	/**
	 * Menu para introducir una fecha con un parametro minimo y uno maximo de
	 * a�os que puede servir para determinar la edad minma o maxima. Valida que
	 * sea una fecha correcta en dias,meses y a�os. Calcula los a�os y lo
	 * compara con el minimo y el maximo para dejarlo pasar o no. Valida el
	 * formato correcto.
	 * 
	 * @param message
	 * @param title
	 * @param min
	 *            numero int minimo
	 * @return objeto de tipo fecha.
	 * 
	 */
	public static ClassDate Date_min_max_condition(String message, String title, int min, int max) {

		String date = "";
		int age = 0;

		boolean val1 = false;

		do {

			switch (Classconfig.getInstance().getdatef()) {

			case "dd/mm/yyyy":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Birthday_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": dd/mm/yyyy", title);
				break;
			case "dd-mm-yyyy":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Birthday_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": dd-mm-yyyy", title);
				break;
			case "yyyy/mm/dd":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Birthday_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": yyyy/mm/dd", title);
				break;
			case "yyyy-mm-dd":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_Birthday_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": yyyy-mm-dd", title);
				break;

			}

			val1 = Validate.okdate(date);

			if (val1 == true) {

				ClassDate c = new ClassDate(date);

				// aplicamos metodo de validar fecha existente
				if (c.okdate() == true) {

					val1 = true;
					// calculamos la edad
					age = c.Diference_system_date();
				} // fin okdate

				else {

					val1 = false;

					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
				}
				// Controlamos que la edad este entre 16 y 18 a�os
				if ((age >= min) && (age <= max)) {

					val1 = true;

				} else {

					val1 = false;
					JOptionPane.showMessageDialog(null,
							Lang.getInstance().getProperty("The_working_age_must_be_between") + min + Lang.getInstance().getProperty("and") + max
									+ Lang.getInstance().getProperty("years"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);

				}

			} // fin del if 1

			else {

				val1 = false;

				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
			}
		} while (val1 == false);

		return new ClassDate(date);
	}

	/**
	 * Funcion que valida una fecha de registro de un usuario o producto. La
	 * debe ser valida. La fecha debe tner el formato correcto. La fecha no
	 * puede ser posterior al sistema. La fecha no puede ser anterior a la fecha
	 * de creacion del objeto o persona. La fecha en el momento del registro
	 * valida si el usuario tenia la edad minima en ese momento.
	 * 
	 * @param message
	 * @param title
	 * @param d
	 *            fecha de creacion o nacimiento.
	 * @param min
	 * @return objeto fecha.
	 */
	public static ClassDate Date_registered(String message, String title, ClassDate d, int min) {

		String date = "";
		boolean val1 = false;
		boolean valok = true;
		boolean valcomps = true;
		boolean valcomp = true;
		boolean valadult = true;
		int age = 0;

		do {

			switch (Classconfig.getInstance().getdatef()) {

			case "dd/mm/yyyy":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_recruitment_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": dd/mm/yyyy", Lang.getInstance().getProperty("Request"));
				break;
			case "dd-mm-yyyy":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_recruitment_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": dd-mm-yyyy", Lang.getInstance().getProperty("Request"));
				break;
			case "yyyy/mm/dd":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_recruitment_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": yyyy/mm/dd", Lang.getInstance().getProperty("Request"));
				break;
			case "yyyy-mm-dd":
				date = Request_variable.damestring(Lang.getInstance().getProperty("Enter_recruitment_date") + "\n"
						+ Lang.getInstance().getProperty("Format_example") + ": yyyy-mm-dd", Lang.getInstance().getProperty("Request"));
				break;

			}
			// validamos el formato con forma regular.
			val1 = Validate.okdate(date);

			if (val1 == true) {

				ClassDate c = new ClassDate(date);

				// aplicamos los metodos de validar la fecha,comparar que no sea
				// posterior a la del sistema y compara que no sea anterior a la
				// fecha de nacimiento

				if (c.okdate() == false) {

					valok = false;
					// calculamos la edad

					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
				} else {

					age = c.Diference_two_dates(d);
				}

				if (c.Date_compare_system_date() == 2) {

					valcomps = false;
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_date_may_not_be_later_than_the_system"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
				}
				if (c.Date_compare_two_dates(d) == 0) {

					valcomp = false;
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_record_date_may_not_be_earlier_wing_of_birth"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
				}
				if (age < min) {

					valadult = false;

					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("On_this_date_you_were_not_of_legal_age"),
							Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);

				}

				if ((valok == true) && (valcomps == true) && (valcomp == true) && (valadult) == true) {

					val1 = true;

				} else {
					val1 = false;
				}

			} // fin del if 1

			else {

				val1 = false;

				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"),
						Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
			}

		} while (val1 == false);

		return new ClassDate(date);
	}

}// fin del funciones
