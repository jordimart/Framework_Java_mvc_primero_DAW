package Appweb.General_tools;

/**
 * @author Jorge Martinez Frias
 * 
 * 
 * 
 */

import javax.swing.JOptionPane;

import Appweb.Classes.Language.Lang;

public class Request_variable {

	////////////// FUNCIONES PARA PEDIR DATOS AL USUARIO////////////////////

	/**
	 * Peticion de un numero int mediante menu.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return numero int
	 */
	public static int dameint(String mensaje, String titulo) {
		int num = 0;
		String s = "";
		boolean pasa = false;

		do {
			try {
				// pedimos numero
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				if (s == null) {
					// JOptionPane.showMessageDialog(null, "Saliendo de la
					// aplicaci�n", "Saliendo",
					// JOptionPane.INFORMATION_MESSAGE);
					// System.exit(0);//sale de a aplicacion
					// Opcion anulada por Yolanda
				} else {
					num = Integer.parseInt(s);// pasamos de cadena a int
					pasa = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
						JOptionPane.ERROR_MESSAGE);// Si
				// no
				// es
				// correcto
				// vuelve
				pasa = false;
			}
		} while (pasa == false);

		return num;// devuelve el numero
	}

	/**
	 * Peticion de un numero int mediante menu.El numero no puede ser 0.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return numero int no 0
	 */
	public static int dameintno_0(String mensaje, String titulo) {
		int num = 0;
		String s = "";
		boolean pasa = false;

		do {// Este do while hace que se vuelva a pedir el numero en caso de ser
			// 0

			do {
				try {
					// pedimos numero
					s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
					if (s == null) {
						// JOptionPane.showMessageDialog(null, "Saliendo de la
						// aplicaci�n", "Saliendo",
						// JOptionPane.INFORMATION_MESSAGE);
						// System.exit(0);//sale de a aplicacion
						// Opcion anulada por Yolanda
					} else {
						num = Integer.parseInt(s);// pasamos de cadena a int
						pasa = true;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
							JOptionPane.ERROR_MESSAGE);// Si
					// no
					// es
					// correcto
					// vuelve
					pasa = false;
				}
			} while (pasa == false);

		} while (num == 0);// fin del while

		return num;// devuelve el numero

	}

	/**
	 * Peticion de un numero long mediante menu.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return numero long
	 */
	public static long damelong(String mensaje, String titulo) {
		long num = 0;
		String s = "";
		boolean pasa = false;

		do {
			try {
				// pedimos numero long
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				if (s == null) {
					// JOptionPane.showMessageDialog(null, "Saliendo de la
					// aplicaci�n", "Saliendo",
					// JOptionPane.INFORMATION_MESSAGE);
					// System.exit(0);//sale de a aplicacion
					// Opcion anulada por Yolanda
				} else {
					num = Long.parseLong(s);// pasamos de cadena a long
					pasa = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
						JOptionPane.ERROR_MESSAGE);// Si
				// no
				// es
				// correcto
				// vuelve
				pasa = false;
			}
		} while (pasa == false);

		return num;// devuelve el numero long
	}

	/**
	 * Peticion de un numero short mediante menu.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return numero short
	 */
	public static short dameshort(String mensaje, String titulo) {
		short num = 0;
		String s = "";
		boolean pasa = false;

		do {
			try {
				// pedimos numero
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				if (s == null) {
					// JOptionPane.showMessageDialog(null, "Saliendo de la
					// aplicaci�n", "Saliendo",
					// JOptionPane.INFORMATION_MESSAGE);
					// System.exit(0);//sale de a aplicacion
					// Opcion anulada por Yolanda
				} else {
					num = Short.parseShort(s);// pasamos de cadena a short
					pasa = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
						JOptionPane.ERROR_MESSAGE);// Si
				// no
				// es
				// correcto
				// vuelve
				pasa = false;
			}
		} while (pasa == false);

		return num;// devuelve el numero short
	}

	/**
	 * Peticion de un numero byte mediante menu.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return numero byte
	 */
	public static byte damebyte(String mensaje, String titulo) {
		byte num = 0;
		String s = "";
		boolean pasa = false;

		do {
			try {
				// pedimos numero
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				if (s == null) {
					// JOptionPane.showMessageDialog(null, "Saliendo de la
					// aplicaci�n", "Saliendo",
					// JOptionPane.INFORMATION_MESSAGE);
					// System.exit(0);//sale de a aplicacion
					// Opcion anulada por Yolanda
				} else {
					num = Byte.parseByte(s);// pasamos de cadena a byte
					pasa = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
						JOptionPane.ERROR_MESSAGE);// Si
				// no
				// es
				// correcto
				// vuelve
				pasa = false;
			}
		} while (pasa == false);

		return num;// devuelve el numero byte
	}

	/**
	 * Peticion de un numero float mediante menu.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return numero float
	 */
	public static float damefloat(String mensaje, String titulo) {

		float numf = 0.0f;
		String s;
		boolean pasa = true;

		do {
			try {

				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);

				if (s == null) {
					// JOptionPane.showMessageDialog(null, "Saliendo de la
					// aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					// System.exit(0);
					// Opcion anulada por Yolanda

				} else {

					numf = Float.parseFloat(s);
					pasa = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
						JOptionPane.ERROR_MESSAGE);

				pasa = false;
			}
		} while (pasa == false);

		return numf;// devuelve el numero float

	}

	/**
	 * Peticion de un numero float mediante menu.El numero no sera 0.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return numero float diferente a 0.
	 */
	public static float damefloat_no_0(String mensaje, String titulo) {

		float numf = 0.0f;
		String s;
		boolean pasa = true;

		do {// Este do while hace que se vuelva a pedir el numero en caso de ser
			// 0

			do {
				try {

					s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);

					if (s == null) {
						// JOptionPane.showMessageDialog(null, "Saliendo de la
						// aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
						// System.exit(0);
						// Opcion anulada por Yolanda

					} else {

						numf = Float.parseFloat(s);
						pasa = true;
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
							JOptionPane.ERROR_MESSAGE);

					pasa = false;
				}
			} while (pasa == false);

		} while (numf == 0.00);// fin del while

		return numf;// devuelve el numero float diferente a 0

	}

	/**
	 * Peticion de un numero double mediante menu.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return numero double
	 */
	public static double damedouble(String mensaje, String titulo) {
		double num = 0;
		String s = "";
		boolean pasa = false;

		do {
			try {
				// pedimos numero
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				if (s == null) {
					// JOptionPane.showMessageDialog(null, "Saliendo de la
					// aplicaci�n", "Saliendo",
					// JOptionPane.INFORMATION_MESSAGE);
					// System.exit(0);//sale de a aplicacion
					// Opcion anulada por Yolanda
				} else {
					num = Double.parseDouble(s);// pasamos de cadena a double
					pasa = true;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
						JOptionPane.ERROR_MESSAGE);// Si
				// no
				// es
				// correcto
				// vuelve
				pasa = false;
			}
		} while (pasa == false);

		return num;// devuelve el numero double
	}

	/**
	 * Peticion de un char mediante menu.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return char
	 */
	public static char damechar(String mensaje, String titulo) {

		char car = ' ';
		String s;
		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);

				if (s == null) {
					// JOptionPane.showMessageDialog(null, "Saliendo de la
					// aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE);
					// System.exit(0);//al usuario pulsar cancelar o cerrar la
					// vtna del showinputdialog, acaba la ejecuci�n
					// anulado por Yolanda
				} else {
					car = s.charAt(0);

					correcto = true;
				}
			} catch (Exception e) {

				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
						JOptionPane.ERROR_MESSAGE);

				correcto = false;
			}
		} while (correcto == false);

		return car;// devuelve el caracter
	}

	/**
	 * Peticion de un string mediante menu.
	 * 
	 * @param mensaje
	 * @param titulo
	 * @return string
	 */
	public static String damestring(String mensaje, String titulo) {

		String s = "";
		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				correcto = true;
				if (s == null) {
					// );JOptionPane.showMessageDialog(null, "Saliendo de la
					// aplicaci�n","Saliendo",JOptionPane.INFORMATION_MESSAGE
					// System.exit(0);//al usuario pulsar cancelar o cerrar la
					// vtna del showinputdialog, acaba la ejecuci�n
					// anulado por Yolanda
				}
				if (s.equals("")) {
					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
							JOptionPane.ERROR_MESSAGE);
					correcto = false;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"), "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);

		return s;// devuelve el string
	}

}
