package Appweb.Tools;



import Appweb.Modules.Config.Classconfig;

/**
 * 
 * @author Jorge Martinez Frias
 * Funciones para validar parametros de entrada con formas regulares.
 */

public class Validate {

	private static final String okdni = "^([0-9]{8})[a-zA-Z]*{1}$";
	private static final String okword = "[a-zA-Z��\\s]+([ ]?)+([a-zA-Z]*)+([ ]?)+([a-zA-Z]*)+([ ]?)+([a-zA-Z]*)";
	private static final String okmobile = "^[0-9]{9}$";
	private static final String okage = "^([0-9]{2})";
	private static final String okmail = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String okwordfull = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

	/**
	 * Valida un dni devolviendo un boolean.
	 * @param dni
	 * @return
	 * true|false
	 */
	public static boolean okdni(String dni) {
		return dni.matches(okdni);
	}

	/**
	 * Valida un nombre con espacios devolviendo un boolean.
	 * @param word
	 * @return
	 * true|false
	 */
	public static boolean okword(String word) {
		return word.matches(okword);
	}

	/**
	 * Valida un numero de movil de nueve digitos devolviendo un boolean.
	 * @param mobile
	 * @return
	 * true|false
	 */
	public static boolean okmobile(String mobile) {
		return mobile.matches(okmobile);
	}

	/**
	 * Valida un formato de fecha devolviendo un boolean.
	 * Los formatos pueden ser: dd/mm/yyyy,dd-mm-yyyy,yyyy/mm/dd,yyyy-mm-dd.
	 * @param date
	 * @return
	 * true|false
	 */
	public static boolean okdate(String date) {

		String okdate = "";

		switch (Classconfig.getInstance().getdatef()) {

		case "dd/mm/yyyy":

			//okdate = "(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[1-9])[/]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";
                        okdate = "(0[1-9]|1[0-9]|3[01]|[0-9]|2[0-9])[/](0[1-9]|1[1-9]|[0-9])[/]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";
			break;

		case "dd-mm-yyyy":

			okdate = "(0[1-9]|[12][0-9]|3[01])[-](0[1-9]|1[1-9])[-]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";

			break;

		case "yyyy/mm/dd":

			okdate = "((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))[/](0[1-9]|1[1-9])[/](0[1-9]|[12][0-9]|3[01])";

			break;

		case "yyyy-mm-dd":

			okdate = "((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))[-](0[1-9]|1[1-9])[-](0[1-9]|[12][0-9]|3[01])";

			break;

		}

		return date.matches(okdate);
	}

	/**
	 * Valida un numero int de dos digitos devolviendo un boolean.
	 * @param Age
	 * @return
	 * true|false
	 */
	public static boolean okage(String age) {
		return age.matches(okage);
	}

	/**
	 * Valida un correo electronico devolviendo un boolean.
	 * @param mail
	 * @return
	 * true|false
	 */
	public static boolean okmail(String mail) {
		return mail.matches(okmail);
	}

	/**
	 * Valida una palabra con todo tipo de caracteres devolviendo un boolean.
	 * @param wordfull
	 * @return
	 * true|false
	 */
	public static boolean okwordfull(String wordfull) {
		return okwordfull.matches(okwordfull);
	}

}
