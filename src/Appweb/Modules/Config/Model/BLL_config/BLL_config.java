/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Config.Model.BLL_config;

import Appweb.Modules.Config.Model.DAO_config.DAO_config;

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

    public static void auto_save_config_json() {

        DAO_config.auto_save_config_json();
    }

    public static void auto_open_config_json() {

        DAO_config.auto_open_config_json();
    }

    public static void save_config_json() {

        DAO_config.save_json_config();
    }

    public static void open_config_json() {

        DAO_config.open_json_config();
    }

    public static void language_english() {
        DAO_config.language_english();

    }

    public static void language_spanish() {
        DAO_config.language_spanish();

    }

    public static void language_valencian() {
        DAO_config.language_valencian();

    }
}
