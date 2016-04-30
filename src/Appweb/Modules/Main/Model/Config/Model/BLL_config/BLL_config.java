package Appweb.Modules.Main.Model.Config.Model.BLL_config;

import Appweb.Modules.Main.Model.Config.Model.DAO_config.DAO_config;

/**
 *
 * @author ASUSG50V
 */
public class BLL_config {

    public static void Configuration_accept() {

        try {
            DAO_config.radio_button_language();
            DAO_config.radio_button_datef();
            DAO_config.radio_button_decimal();
            DAO_config.radio_button_currency();
            DAO_config.Menu_theme();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Utiliza un DAO para autocargar fichero de configuracion
     */
    public static void auto_save_config_json() {

        DAO_config.auto_save_config_json();
    }

    /**
     * Utiliza un DAO para autoabrir fichero de configuracion
     */
    public static void auto_open_config_json() {

        DAO_config.auto_open_config_json();
    }

    /**
     * Utiliza un DAO para guardar ficheros de configuracion en json
     */
    public static void save_config_json() {

        DAO_config.save_json_config();
    }

    /**
     * Utiliza un DAO para abrir ficheros de configuracion en json
     */
    public static void open_config_json() {

        DAO_config.open_json_config();
    }

    /**
     * Utiliza un DAo para cambiar el lenguaje a ingles.
     */
    public static void language_english() {
        DAO_config.language_english();

    }

    /**
     * Utiliza un DAo para cambiar el lenguaje a español.
     */
    public static void language_spanish() {
        DAO_config.language_spanish();

    }

    /**
     * Utiliza un DAo para cambiar el lenguaje a valenciano.
     */
    public static void language_valencian() {
        DAO_config.language_valencian();

    }

    /**
     * utiliza un DAOpara cargar la configuracion actual en la vista.
     */
    public static void charge_config() {

        DAO_config.charge_config();
    }
}
