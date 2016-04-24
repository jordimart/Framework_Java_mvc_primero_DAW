
package Appweb.Modules.Users.User_reg.Model.DAO_User;

import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Users.User_reg.Model.Classes.User_reg;
import Appweb.Modules.Users.User_reg.Model.Classes.singleuser_reg;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jorge
 */
public class DAO_User_file {
    
     private static final String ENCODING = "UTF-8";
    
     public static void save_json() {

        if (singleuser_reg.User_reg_array.size() != 0) {

            String PATH = null;
            try {
                XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
                xstreamjson.setMode(XStream.NO_REFERENCES);
                xstreamjson.alias("User_reg", User_reg.class);

                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

                int seleccion = fileChooser.showSaveDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File JFC = fileChooser.getSelectedFile();
                    PATH = JFC.getAbsolutePath();
                    PATH = PATH + ".json";

                    Gson gson = new Gson();
                    String json = gson.toJson(singleuser_reg.User_reg_array);
                    FileWriter fileXml = new FileWriter(PATH);
                    fileXml.write(json.toString());
                    fileXml.close();

                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("User_file_saved") + " User registered json",
                            Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Failed_to_save_user") + " User registered json", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("No_data_to_save"), Lang.getInstance().getProperty("File") + " json",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void save_txt() {

        if (singleuser_reg.User_reg_array.size() != 0) {

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
                    o.writeObject(singleuser_reg.User_reg_array);
                    o.close();
                    JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            JOptionPane.showMessageDialog(null, "No hay datos para guardar", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void save_xml() {

        if (singleuser_reg.User_reg_array.size() != 0) {

            String PATH = " ";

            try {
                OutputStream os = new ByteArrayOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                XStream xstream = new XStream();
                Annotations.configureAliases(xstream, User_reg.class);

                String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
                xstream.toXML(singleuser_reg.User_reg_array, osw);
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
                    JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "No hay datos para guardar", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void auto_save_json() {

        String PATH = " ";

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/User_reg/Model/User_reg_files/useregusers";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("User_reg", User_reg.class);

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();
            PATH = PATH + ".json";

            Gson gson = new Gson();
            String json = gson.toJson(singleuser_reg.User_reg_array);
            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(json.toString());
            fileXml.close();

            System.out.print(Lang.getInstance().getProperty("User_file_saved") + " User_registered json \n");

        } catch (Exception e) {
            System.out.print(Lang.getInstance().getProperty("Failed_to_save_user") + " User registered json" + " \n");
        }
    }

    public static void auto_open_json() {

        String PATH = " ";
        User_reg a = new User_reg("");

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/User_reg/Model/User_reg_files/useregusers.json";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("User_reg", User_reg.class);

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();

            singleuser_reg.User_reg_array.clear();

            JsonReader lector = new JsonReader(new FileReader(PATH));
            JsonParser parseador = new JsonParser();
            JsonElement raiz = parseador.parse(lector);

            Gson json = new Gson();
            JsonArray lista = raiz.getAsJsonArray();
            for (JsonElement elemento : lista) {
                a = json.fromJson(elemento, User_reg.class);
                singleuser_reg.User_reg_array.add(a);

            }
            System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " User registered json" + " \n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(Lang.getInstance().getProperty("Error_loading_user_file") + "User registered json" + " \n");
        }
    }
    
}
