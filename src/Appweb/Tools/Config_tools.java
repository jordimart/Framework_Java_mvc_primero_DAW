package Appweb.Tools;

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

import Appweb.Modules.Config.Classconfig;
import Appweb.Classes.Language.Lang;
import de.javasoft.plaf.synthetica.SyntheticaBlackEyeLookAndFeel;

public class Config_tools {

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

    /**
     * Funcion que guarda la configuracion actual en los tres formatos de forma
     * automatica.
     */
    public static void save_all_file_config_format() {

        String PATH = " ";

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Tools/Files_config/appconfig";
        } catch (IOException e) {
            e.printStackTrace();
        }
/**
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

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();
            PATH = PATH + ".xml";

            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(xml.toString());
            fileXml.close();
            osw.close();
            os.close();
            System.out.print(Lang.getInstance().getProperty("Config_file_saved") + " xml\n");

        } catch (Exception e1) {
            e1.printStackTrace();
            System.out.print(Lang.getInstance().getProperty("Failed_to_save_config") + " xml\n");
        }

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Tools/Files_config/appconfig";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            File f;

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();
            PATH = PATH + ".txt";
            f = new File(PATH);

            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(Classconfig.getInstance());
            o.close();
            System.out.print(Lang.getInstance().getProperty("Config_file_saved") + " txt\n");

        } catch (Exception e) {
            System.out.print(Lang.getInstance().getProperty("Failed_to_save_config") + " txt\n");
        }

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Tools/Files_config/appconfig";
        } catch (IOException e) {
            e.printStackTrace();
        }
*/
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
     * Funcion que carga la configuracion actual en los tres formatos de forma
     * automatica.
     */
    public static void open_all_file_config_format() {

        String PATH = " ";
        Classconfig config = null;
/**
        try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, Classconfig.class);

            try {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Tools/Files_config/appconfig.xml";
            } catch (IOException e) {
                e.printStackTrace();
            }

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();
            config = (Classconfig) xstream.fromXML(new FileReader(PATH));

            Classconfig.getInstance().setCurrency(config.getCurrency());
            Classconfig.getInstance().setdatef(config.getdatef());
            Classconfig.getInstance().setDummy(config.getDummy());
            Classconfig.getInstance().setFile(config.getFile());
            Classconfig.getInstance().setLanguage(config.getLanguage());
            Classconfig.getInstance().setnum_dec(config.getnum_dec());
            Classconfig.getInstance().setTheme(config.getTheme());

            System.out.print(Lang.getInstance().getProperty("Loaded_settings_file") + " xml\n");

        } catch (Exception e1) {
            System.out.print(Lang.getInstance().getProperty("Error_loading_file") + " xml\n");
        }

        try {
            File f;

            try {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Tools/Files_config/appconfig.txt";
            } catch (IOException e) {
                e.printStackTrace();
            }
            File JFC = new File(PATH);
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

            System.out.print(Lang.getInstance().getProperty("Loaded_settings_file") + " txt\n");
        } catch (Exception e) {
            System.out.print(Lang.getInstance().getProperty("Error_loading_file") + " xml\n");
        }
*/
        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Config", Classconfig.class);

            try {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Tools/Files_config/appconfig.json";
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
            System.out.print(Lang.getInstance().getProperty("Error_loading_file") + " xml\n");
        }
    }

    /**
     * Funcion que modifica la apariencia de la aplicacion dependiendo de lo que
     * haya en configuracion.
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(new SyntheticaBlackEyeLookAndFeel());
                    break;
                }
            }
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            
        }

                    break;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_appearance_failed_to_change"), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

    }
}
