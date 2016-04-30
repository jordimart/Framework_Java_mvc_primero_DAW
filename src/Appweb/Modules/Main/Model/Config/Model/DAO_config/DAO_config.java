package Appweb.Modules.Main.Model.Config.Model.DAO_config;

import static Appweb.Modules.Main.Controller.ControllerMain.Settings;
import Appweb.Modules.Main.Model.Config.Classes.Classconfig;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.Combo_Theme;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_curr_dollar;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_curr_euro;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_curr_pound;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_day_bar;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_day_bar2;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_lang_en;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_lang_es;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_lang_val;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_one_d;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_three_d;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_two_d;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_year_bar;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_year_bar2;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueSteelLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaGreenDreamLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaMauveMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaOrangeMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSilverMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSimple2DLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaSkyMetallicLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaWhiteVisionLookAndFeel;

public class DAO_config {

    private static final String ENCODING = "UTF-8";

   

    /**
     * Funcion que guarda la configuracion actual a json donde quiera el
     * usuario.
     */
    public static void save_json_config() {

        String PATH = " ";
        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("Config", Classconfig.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH + ".json";

                Gson gson = new Gson();
                String json = gson.toJson(Classconfig.getInstance());
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(json.toString());
                fileXml.close();

                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Config_file_saved") + "json",
                        Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_file") + "json", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Funcion que carga la configuracion actual a xml donde quiera el usuario.
     */
    public static void open_json_config() {

        String PATH = " ";
        Classconfig config = null;

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Config", Classconfig.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();

                JsonReader lector = new JsonReader(new FileReader(PATH));
                JsonParser parseador = new JsonParser();
                JsonElement raiz = parseador.parse(lector);

                String json = raiz.toString();
                Gson gson = new Gson();
                config = gson.fromJson(json, Classconfig.class);

                Classconfig.getInstance().setCurrency(config.getCurrency());
                Classconfig.getInstance().setdatef(config.getdatef());
                Classconfig.getInstance().setFile(config.getFile());
                Classconfig.getInstance().setLanguage(config.getLanguage());
                Classconfig.getInstance().setnum_dec(config.getnum_dec());
                Classconfig.getInstance().setTheme(config.getTheme());

            }
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Loaded_settings_file") + "json",
                    Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_file") + "json", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Autogurada los parametros de configuracion en un fichero Json.
     */
    public static void auto_save_config_json() {

        String PATH = " ";

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Main/Model/Config/Model/Files_config/appconfig";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("Config", Classconfig.class);

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();
            PATH = PATH + ".json";

            Gson gson = new Gson();
            String json = gson.toJson(Classconfig.getInstance());
            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(json.toString());
            fileXml.close();

            System.out.print(Lang.getInstance().getProperty("Config_file_saved") + " json\n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(Lang.getInstance().getProperty("Failed_to_save_config") + " json\n");

        }

    }

    /**
     * Abre automaticamente un fichero de configuracion previamente guardado.
     */
    public static void auto_open_config_json() {

        String PATH = " ";
        Classconfig config = null;

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Config", Classconfig.class);

            try {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Main/Model/Config/Model/Files_config/appconfig.json";
            } catch (IOException e) {
                e.printStackTrace();
            }

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();

            JsonReader lector = new JsonReader(new FileReader(PATH));
            JsonParser parseador = new JsonParser();
            JsonElement raiz = parseador.parse(lector);

            String json = raiz.toString();
            Gson gson = new Gson();
            config = gson.fromJson(json, Classconfig.class);

            Classconfig.getInstance().setCurrency(config.getCurrency());
            Classconfig.getInstance().setdatef(config.getdatef());
            Classconfig.getInstance().setFile(config.getFile());
            Classconfig.getInstance().setLanguage(config.getLanguage());
            Classconfig.getInstance().setnum_dec(config.getnum_dec());
            Classconfig.getInstance().setTheme(config.getTheme());

            System.out.print(Lang.getInstance().getProperty("Loaded_settings_file") + " json\n");

        } catch (Exception e) {
            System.out.print(Lang.getInstance().getProperty("Error_loading_file") + " json\n");
        }

    }

    /**
     * Funcion que modifica la apariencia de la aplicacion dependiendo de lo que
     * haya en configuracion.Implementada en Grafica faltan mas looks.
     */
    public static void Function_theme() {

        try {
            switch (Classconfig.getInstance().getTheme()) {

                case "Metal":// Metal
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

                    break;

                case "System":// GTK - WINDOWS
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;

                case "Motif":// CDE/Motif
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;

                case "Nimbus":// Nimbus

                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

                    break;// Windows Clasic

                case "Windows classic":

                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");

                    break;
                case "Synthetica":

                    UIManager.setLookAndFeel("de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel");
                    break;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_appearance_failed_to_change"), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    //// Funciones Configuracion//////
    /**
     * Modifica el lenguage dependiendo de la selccion delradiobutton.
     */
    public static void radio_button_language() {

        if (chk_lang_en.isSelected()) {
            Classconfig.getInstance().setLanguage(chk_lang_en.getText());
        }

        if (chk_lang_es.isSelected()) {
            Classconfig.getInstance().setLanguage(chk_lang_es.getText());
        }
        if (chk_lang_val.isSelected()) {
            Classconfig.getInstance().setLanguage(chk_lang_val.getText());
        }

    }

    /**
     * Modifica la configuracion de la fecha dependiendo de la seleccion del
     * radio button
     */
    public static void radio_button_datef() {

        if (chk_day_bar.isSelected()) {
            Classconfig.getInstance().setdatef(chk_day_bar.getText());
        }

        if (chk_day_bar2.isSelected()) {
            Classconfig.getInstance().setdatef(chk_day_bar2.getText());
        }
        if (chk_year_bar.isSelected()) {
            Classconfig.getInstance().setdatef(chk_year_bar.getText());
        }
        if (chk_year_bar2.isSelected()) {
            Classconfig.getInstance().setdatef(chk_year_bar2.getText());
        }

    }

    /**
     * Modifica la configuracion de decimales dependiendo de la seleccion del
     * radio button
     */
    public static void radio_button_decimal() {

        if (chk_one_d.isSelected()) {
            Classconfig.getInstance().setnum_dec(chk_one_d.getText());
        }

        if (chk_two_d.isSelected()) {
            Classconfig.getInstance().setnum_dec(chk_two_d.getText());
        }
        if (chk_three_d.isSelected()) {
            Classconfig.getInstance().setnum_dec(chk_three_d.getText());
        }

    }

    /**
     * Modifica la configuracion de moneda dependiendo de la seleccion del
     * radio button
     */
    public static void radio_button_currency() {

        if (chk_curr_euro.isSelected()) {
            Classconfig.getInstance().setCurrency(chk_curr_euro.getText());
        }

        if (chk_curr_dollar.isSelected()) {
            Classconfig.getInstance().setCurrency(chk_curr_dollar.getText());
        }
        if (chk_curr_pound.isSelected()) {
            Classconfig.getInstance().setCurrency(chk_curr_pound.getText());
        }

    }

    /**
     * This function changes the appearance of the application. Options
     * Metal,System,Motif,Nimbus and Windows classic
     *
     *
     */
    public static void Menu_theme() {

        String s = " ";

        s = (String) Combo_Theme.getSelectedItem().toString();

        try {
            switch (s) {

                case "Metal":// Metal
                    Classconfig.getInstance().setTheme("Metal");
                    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

                    break;

                case "System":// GTK - WINDOWS
                    Classconfig.getInstance().setTheme("System");
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;

                case "Motif":// CDE/Motif
                    Classconfig.getInstance().setTheme("Motif");
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                    break;

                case "Nimbus":// Nimbus

                    Classconfig.getInstance().setTheme("Nimbus");
                    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

                    break;// Windows Clasic

                case "Windows classic":

                    Classconfig.getInstance().setTheme("Windows classic");
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");

                    break;

                case "S Blackeye":

                    Classconfig.getInstance().setTheme("S Blackeye");

                    UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());

                    break;

                case "S Blackmoon":

                    Classconfig.getInstance().setTheme("S Blackmoon");

                    UIManager.setLookAndFeel(new SyntheticaBlackMoonLookAndFeel());

                    break;

                case "S Blueice":

                    Classconfig.getInstance().setTheme("S Blueice");

                    UIManager.setLookAndFeel(new SyntheticaBlueIceLookAndFeel());

                    break;

                case "S Bluemoon":

                    Classconfig.getInstance().setTheme("S Bluemoon");

                    UIManager.setLookAndFeel(new SyntheticaBlueMoonLookAndFeel());

                    break;

                case "S Bluesteel":

                    Classconfig.getInstance().setTheme("S Bluesteel");

                    UIManager.setLookAndFeel(new SyntheticaBlueSteelLookAndFeel());

                    break;

                case "S Greendream":

                    Classconfig.getInstance().setTheme("S Greendream");

                    UIManager.setLookAndFeel(new SyntheticaGreenDreamLookAndFeel());

                    break;

                case "S Mauvemetallic":

                    Classconfig.getInstance().setTheme("S Mauvemetallic");

                    UIManager.setLookAndFeel(new SyntheticaMauveMetallicLookAndFeel());

                    break;

                case "S Orangemetallic":

                    Classconfig.getInstance().setTheme("S Orangemetallic");

                    UIManager.setLookAndFeel(new SyntheticaOrangeMetallicLookAndFeel());

                    break;

                case "S Silvermoon":

                    Classconfig.getInstance().setTheme("S Silvermoon");

                    UIManager.setLookAndFeel(new SyntheticaSilverMoonLookAndFeel());

                    break;

                case "S Simple2d":

                    Classconfig.getInstance().setTheme("S Simple2d");

                    UIManager.setLookAndFeel(new SyntheticaSimple2DLookAndFeel());

                    break;

                case "S Skymetallic":

                    Classconfig.getInstance().setTheme("S Skymetallic");

                    UIManager.setLookAndFeel(new SyntheticaSkyMetallicLookAndFeel());

                    break;

                case "S Whitevision":

                    Classconfig.getInstance().setTheme("S Whitevision");

                    UIManager.setLookAndFeel(new SyntheticaWhiteVisionLookAndFeel());

                    break;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_appearance_failed_to_change"), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Modifica el lenguaje a ingles(solo para el main)
     */
    public static void language_english() {
        Classconfig.getInstance().setLanguage("english");

    }

    /**
     * Modifica el lenguaje a español(solo para el main)
     */
    public static void language_spanish() {
        Classconfig.getInstance().setLanguage("español");

    }

    /**
     * Modifica el lenguaje a valenciano(solo para el main)
     */
    public static void language_valencian() {
        Classconfig.getInstance().setLanguage("valencia");

    }

    /**
     * Esta funcion carga la configuracion actual en la vista.
     */
    public static void charge_config() {

        String d = Classconfig.getInstance().getdatef();
        String dec = Classconfig.getInstance().getnum_dec();
        String c = Classconfig.getInstance().getCurrency();
        String l = Classconfig.getInstance().getLanguage();

        switch (d) {

            case "dd/MM/yyyy":
                Settings.chk_day_bar.setSelected(true);
                break;
            case "dd-MM-yyyy":
                Settings.chk_day_bar2.setSelected(true);
                break;
            case "yyyy/MM/dd":
                Settings.chk_year_bar.setSelected(true);
                break;
            case "yyyy-MM-dd":
                Settings.chk_year_bar2.setSelected(true);
                break;
        }

        switch (dec) {

            case "0.0":
                Settings.chk_one_d.setSelected(true);
                break;
            case "0.00":
                Settings.chk_two_d.setSelected(true);
                break;
            case "0.000":
                Settings.chk_three_d.setSelected(true);
                break;

        }

        switch (c) {

            case "euro":
                Settings.chk_curr_euro.setSelected(true);
                break;
            case "dolar":
                Settings.chk_curr_dollar.setSelected(true);
                break;
            case "pound":
                Settings.chk_curr_pound.setSelected(true);
                break;

        }

        switch (l) {

            case "english":
                Settings.chk_lang_en.setSelected(true);
                break;
            case "español":
                Settings.chk_lang_es.setSelected(true);
                break;
            case "valencia":
                Settings.chk_lang_val.setSelected(true);
                break;

        }

    }
}
