package Appweb.Modules.Config.Model.DAO_config;

import Appweb.Modules.Config.Classes.Classconfig;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import Appweb.Modules.Config.Classes.Language.Lang;
import static Appweb.Modules.Config.View.menu_Settings.Combo_Theme;
import static Appweb.Modules.Config.View.menu_Settings.chk_curr_dollar;
import static Appweb.Modules.Config.View.menu_Settings.chk_curr_euro;
import static Appweb.Modules.Config.View.menu_Settings.chk_curr_pound;
import static Appweb.Modules.Config.View.menu_Settings.chk_day_bar;
import static Appweb.Modules.Config.View.menu_Settings.chk_day_bar2;
import static Appweb.Modules.Config.View.menu_Settings.chk_lang_en;
import static Appweb.Modules.Config.View.menu_Settings.chk_lang_es;
import static Appweb.Modules.Config.View.menu_Settings.chk_lang_val;
import static Appweb.Modules.Config.View.menu_Settings.chk_one_d;
import static Appweb.Modules.Config.View.menu_Settings.chk_three_d;
import static Appweb.Modules.Config.View.menu_Settings.chk_two_d;
import static Appweb.Modules.Config.View.menu_Settings.chk_year_bar;
import static Appweb.Modules.Config.View.menu_Settings.chk_year_bar2;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;

public class DAO_config {

    private static final String ENCODING = "UTF-8";

    /**
     * Funcion que guarda la configuracion actual a xml donde quiera el usuario.
     */
    public static void save_xml_config() {

        String PATH = " ";

        try {
            OutputStream os = new ByteArrayOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, Classconfig.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(Classconfig.getInstance(), osw);
            StringBuffer xml = new StringBuffer();
            xml.append(header);
            xml.append(os.toString());

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

            int seleccion = fileChooser.showSaveDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH + ".xml";

                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Config_file_saved") + "xml",
                        Lang.getInstance().getProperty("File") + " xml", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Failed_to_save_config") + "xml", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Funcion que carga la configuracion actual a xml donde quiera el usuario.
     */
    public static void open_xml_config() {
        String PATH = " ";
        Classconfig config = null;

        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, Classconfig.class);

            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                config = (Classconfig) xstream.fromXML(new FileReader(PATH));

                Classconfig.getInstance().setCurrency(config.getCurrency());
                Classconfig.getInstance().setdatef(config.getdatef());
                Classconfig.getInstance().setDummy(config.getDummy());
                Classconfig.getInstance().setFile(config.getFile());
                Classconfig.getInstance().setLanguage(config.getLanguage());
                Classconfig.getInstance().setnum_dec(config.getnum_dec());
                Classconfig.getInstance().setTheme(config.getTheme());

                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Loaded_settings_file") + "xml",
                        Lang.getInstance().getProperty("File") + " xml", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (Exception e1) {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_file") + "xml", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Funcion que guarda la configuracion actual a txt donde quiera el usuario.
     */
    public static void save_txt_config() {

        String PATH = " ";
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Texto (*.txt)", "txt"));

            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH + ".txt";
                f = new File(PATH);

                FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream o = new ObjectOutputStream(fo);
                o.writeObject(Classconfig.getInstance());
                o.close();
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Config_file_saved") + "txt",
                        Lang.getInstance().getProperty("File") + " txt", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_file") + "txt", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    /**
     * Funcion que carga la configuracion actual a txt donde quiera el usuario.
     */
    public static void open_txt_config() {
        String PATH = " ";
        Classconfig config = null;

        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();

            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Texto (*.txt)", "txt"));

            int seleccion = fileChooser.showOpenDialog(null);

            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                f = new File(PATH);

                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);
                config = (Classconfig) oi.readObject();
                oi.close();

                Classconfig.getInstance().setCurrency(config.getCurrency());
                Classconfig.getInstance().setdatef(config.getdatef());
                Classconfig.getInstance().setDummy(config.getDummy());
                Classconfig.getInstance().setFile(config.getFile());
                Classconfig.getInstance().setLanguage(config.getLanguage());
                Classconfig.getInstance().setnum_dec(config.getnum_dec());
                Classconfig.getInstance().setTheme(config.getTheme());
            }
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Loaded_settings_file") + "txt",
                    Lang.getInstance().getProperty("File") + " txt", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_file") + "txt", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

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
                Classconfig.getInstance().setDummy(config.getDummy());
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

    public static void auto_save_config_json() {

        String PATH = " ";
        

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Config/Files_config/appconfig";
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

    public static void auto_open_config_json() {

        String PATH = " ";
        Classconfig config = null;
      

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Config", Classconfig.class);

            try {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Config/Files_config/appconfig.json";
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
            Classconfig.getInstance().setDummy(config.getDummy());
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

                    try {

                        UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());

                    } catch (javax.swing.UnsupportedLookAndFeelException ex) {

                    }

                    break;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_appearance_failed_to_change"), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    //// Funciones Configuracion//////
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

                    break;

                case "System":// GTK - WINDOWS
                    Classconfig.getInstance().setTheme("System");
                    break;

                case "Motif":// CDE/Motif
                    Classconfig.getInstance().setTheme("Motif");
                    break;

                case "Nimbus":// Nimbus

                    Classconfig.getInstance().setTheme("Nimbus");

                    break;// Windows Clasic

                case "Windows classic":

                    Classconfig.getInstance().setTheme("Windows classic");

                    break;

                case "Synthetica":

                    Classconfig.getInstance().setTheme("Synthetica");

                    break;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_appearance_failed_to_change"), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

}
