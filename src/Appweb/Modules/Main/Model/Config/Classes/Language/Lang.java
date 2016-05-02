package Appweb.Modules.Main.Model.Config.Classes.Language;

import java.io.IOException;
import java.util.Properties;

import Appweb.Modules.Main.Model.Config.Classes.Classconfig;

/**
 * 
 * @author Jorge Martinez Frias
 *
 */
public class Lang extends Properties {

	private static Lang instance;

	/**
	 * Instanciamos el lenguage para que este en toda la aplicacion.
	 * 
	 * @return instance
	 */
	public static Lang getInstance() {

		if (instance == null) {

			instance = new Lang();

		}
		return instance;

	}

	

	private String language;

        /**
         * Constructor vacio
         */
	public Lang() {

		// Modificar si quieres a�adir mas idiomas
		// Cambia el nombre de los ficheros o a�ade los necesarios
		switch (Classconfig.getInstance().getLanguage()) {

		case "english":
			getProperties("english.properties");
			break;
		case "español":
			getProperties("espanol.properties");
			break;
		case "valencia":
			getProperties("valencia.properties");
			break;
		default:
			getProperties("english.properties");
		}

	}

        /**
         * Obtiene el valor de language.
         * @return language
         */
	public String getLanguage() {
		return language;
	}

        /**
         * Modifica el valor de language.
         */
	public void setLanguage() {

		switch (Classconfig.getInstance().getLanguage()) {
		case "english":
			getProperties("english.properties");
			break;
		case "español":
			getProperties("espanol.properties");
			break;
		case "valencia":
			getProperties("valencia.properties");
			break;
		default:
			getProperties("english.properties");
		}
	}

	private void getProperties(String language) {
		try {
			this.load(getClass().getResourceAsStream(language));
		} catch (IOException ex) {

		}
	}

}
