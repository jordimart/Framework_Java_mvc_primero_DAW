package Appweb.Modules.Users.model.Users_tools.User_files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import Appweb.Modules.Config.Classconfig;
import Appweb.Classes.Language.Lang;
import Appweb.Modules.Users.model.Classes.Admin;
import Appweb.Modules.Users.model.Classes.singleton;
import Appweb.Tools.Menu;

public class Function_files {

	private static final String ENCODING = "UTF-8";

	/**
	 * Menu que carga ficheros Admin a peticion de usuario con el formato que
	 * haya en configuracion. Antes pregunta si quiere guardar lo actual.
	 */
	public static void Admin_open_files() {

		String file = " ";
		int option = 0;

		file = Classconfig.getInstance().getFile();

		switch (file) {

		case "xml":

			option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_save_the_data_before_opening_another_file?"),
					Lang.getInstance().getProperty("Open_file"));

			if (option == 0) {

				xml.save_xml_admin();
				xml.open_xml_admin();

			} else {
				xml.open_xml_admin();
			}

			break;
		case "txt":

			option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_save_the_data_before_opening_another_file?"),
					Lang.getInstance().getProperty("Open_file"));

			if (option == 0) {

				txt.save_txt_admin();
				txt.open_txt_admin();

			} else {
				txt.open_txt_admin();
			}

			break;
		case "json":

			option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_save_the_data_before_opening_another_file?"),
					Lang.getInstance().getProperty("Open_file"));

			if (option == 0) {

				json.save_json_admin();
				json.open_json_admin();

			} else {
				json.open_json_admin();
			}

			break;

		default:
			break;
		}

	}

	/**
	 * Menu que guarda ficheros de Admin a peticion del usuario y dependiendo
	 * del formato que haya en la configuracion.
	 */
	public static void Admin_save_files() {

		String file = " ";

		file = Classconfig.getInstance().getFile();

		switch (file) {

		case "xml":

			xml.save_xml_admin();

			break;
		case "txt":

			txt.save_txt_admin();

			break;
		case "json":

			json.save_json_admin();

			break;

		default:
			break;
		}

	}

	/**
	 * Menu que carga ficheros Client a peticion de usuario con el formato que
	 * haya en configuracion. Antes pregunta si quiere guardar lo actual.
	 */
	public static void Client_open_files() {

		String file = " ";
		int option = 0;

		file = Classconfig.getInstance().getFile();

		switch (file) {

		case "xml":

			option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_save_the_data_before_opening_another_file?"),
					Lang.getInstance().getProperty("Open_file"));

			if (option == 0) {

				xml.save_xml_client();
				xml.open_xml_client();

			} else {
				xml.open_xml_client();
			}

			break;
		case "txt":

			option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_save_the_data_before_opening_another_file?"),
					Lang.getInstance().getProperty("Open_file"));

			if (option == 0) {

				txt.save_txt_client();
				txt.open_txt_client();

			} else {
				txt.open_txt_client();
			}

			break;
		case "json":

			option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_save_the_data_before_opening_another_file?"),
					Lang.getInstance().getProperty("Open_file"));

			if (option == 0) {

				json.save_json_client();
				json.open_json_client();

			} else {
				json.open_json_client();
			}

			break;

		default:
			break;
		}

	}

	/**
	 * Menu que guarda ficheros de Client a peticion del usuario y dependiendo
	 * del formato que haya en la configuracion.
	 */
	public static void Client_save_files() {

		String file = " ";

		file = Classconfig.getInstance().getFile();

		switch (file) {

		case "xml":

			xml.save_xml_client();

			break;
		case "txt":

			txt.save_txt_client();

			break;
		case "json":

			json.save_json_client();

			break;

		default:
			break;
		}

	}

	/**
	 * Menu que carga ficheros User_reg a peticion de usuario con el formato que
	 * haya en configuracion. Antes pregunta si quiere guardar lo actual.
	 */
	public static void User_reg_open_files() {

		String file = " ";
		int option = 0;

		file = Classconfig.getInstance().getFile();

		switch (file) {

		case "xml":

			option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_save_the_data_before_opening_another_file?"),
					Lang.getInstance().getProperty("Open_file"));

			if (option == 0) {

				xml.save_xml_user_reg();
				xml.open_xml_user_reg();

			} else {
				xml.open_xml_user_reg();
			}

			break;
		case "txt":

			option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_save_the_data_before_opening_another_file?"),
					Lang.getInstance().getProperty("Open_file"));

			if (option == 0) {

				txt.save_txt_user_reg();
				txt.open_txt_user_reg();

			} else {
				txt.open_txt_user_reg();
			}

			break;
		case "json":

			option = Menu.menu_Yes_No(Lang.getInstance().getProperty("Do_you_want_to_save_the_data_before_opening_another_file?"),
					Lang.getInstance().getProperty("Open_file"));

			if (option == 0) {

				json.save_json_user_reg();
				json.open_json_user_reg();

			} else {
				json.open_json_user_reg();
			}

			break;

		default:
			break;
		}

	}

	/**
	 * Menu que guarda ficheros de User_reg a peticion del usuario y dependiendo
	 * del formato que haya en la configuracion.
	 */
	public static void User_reg_save_files() {

		String file = " ";

		file = Classconfig.getInstance().getFile();

		switch (file) {

		case "xml":

			xml.save_xml_user_reg();

			break;
		case "txt":

			txt.save_txt_user_reg();

			break;
		case "json":

			json.save_json_user_reg();

			break;

		default:
			break;
		}

	}

	/**
	 * public static void save_select_format_admin() {
	 * 
	 * // String PATH = " ";
	 * 
	 * JFileChooser fileChooser = new JFileChooser();
	 * 
	 * fileChooser.setAcceptAllFileFilterUsed(false);
	 * fileChooser.addChoosableFileFilter(new
	 * FileNameExtensionFilter("Xml (*.xml)", "xml"));
	 * fileChooser.addChoosableFileFilter(new
	 * FileNameExtensionFilter("Texto (*.txt)", "txt"));
	 * fileChooser.addChoosableFileFilter(new
	 * FileNameExtensionFilter("JSON (*.json)", "json"));
	 * 
	 * // fileChooser.setCurrentDirectory(new File(".").getCanonicalPath() + //
	 * "/src/Appweb/Modules/Users/Files/Admin_files/"); int seleccion =
	 * fileChooser.showSaveDialog(null); try { String PATH = new
	 * java.io.File(".").getCanonicalPath() +
	 * "/src/Appweb/Modules/Users/Files/Admin_files/adminusers"; } catch
	 * (IOException e) { e.printStackTrace(); }
	 * 
	 * // if(){
	 * 
	 * // fileChooser.getcho
	 * 
	 * // JOptionPane.showMessageDialog(null,"Hemos entrado"); if (seleccion ==
	 * JFileChooser.APPROVE_OPTION) {
	 * 
	 * String PATH = " ";
	 * 
	 * try {
	 * 
	 * OutputStream os = new ByteArrayOutputStream(); OutputStreamWriter osw =
	 * new OutputStreamWriter(os); XStream xstream = new XStream();
	 * Annotations.configureAliases(xstream, Admin.class);
	 * 
	 * String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING +
	 * "\"?>\n"; xstream.toXML(singleton.Admin_array, osw); StringBuffer xml =
	 * new StringBuffer(); xml.append(header); xml.append(os.toString());
	 * 
	 * File JFC = fileChooser.getSelectedFile(); PATH = JFC.getAbsolutePath();
	 * PATH = PATH + ".xml";
	 * 
	 * FileWriter fileXml = new FileWriter(PATH); fileXml.write(xml.toString());
	 * fileXml.close(); osw.close(); os.close();
	 * 
	 * JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito",
	 * "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
	 * 
	 * } catch (Exception e1) { JOptionPane.showMessageDialog(null,
	 * "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE); }
	 * 
	 * } else if (fileChooser.equals(new
	 * FileNameExtensionFilter("Texto (*.txt)", "txt"))) {
	 * 
	 * String PATH = " "; try { File f;
	 * 
	 * // int seleccion = fileChooser.showOpenDialog(null);
	 * 
	 * if (seleccion == JFileChooser.APPROVE_OPTION) { File JFC =
	 * fileChooser.getSelectedFile(); PATH = JFC.getAbsolutePath(); f = new
	 * File(PATH);
	 * 
	 * FileInputStream fi = new FileInputStream(f); ObjectInputStream oi = new
	 * ObjectInputStream(fi); singleton.Admin_array = (ArrayList<Admin>)
	 * oi.readObject(); oi.close();
	 * 
	 * JOptionPane.showMessageDialog(null, "Archivo txt cargado"); } } catch
	 * (Exception e) { JOptionPane.showMessageDialog(null,
	 * "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE); }
	 * 
	 * }
	 * 
	 * else if (fileChooser.equals(new FileNameExtensionFilter("JSON (*.json)",
	 * "json"))) {
	 * 
	 * String PATH = null; Admin e1 = new Admin("");
	 * 
	 * try { XStream xstream = new XStream(new JettisonMappedXmlDriver());
	 * xstream.setMode(XStream.NO_REFERENCES); xstream.alias("Admin",
	 * Admin.class);
	 * 
	 * // int seleccion = fileChooser.showOpenDialog(null); if (seleccion ==
	 * JFileChooser.APPROVE_OPTION) { File JFC = fileChooser.getSelectedFile();
	 * PATH = JFC.getAbsolutePath();
	 * 
	 * singleton.Admin_array.clear();
	 * 
	 * JsonReader lector = new JsonReader(new FileReader(PATH)); JsonParser
	 * parseador = new JsonParser(); JsonElement raiz = parseador.parse(lector);
	 * 
	 * Gson json = new Gson(); JsonArray lista = raiz.getAsJsonArray(); for
	 * (JsonElement elemento : lista) { e1 = json.fromJson(elemento,
	 * Admin.class); singleton.Admin_array.add(e1); }
	 * 
	 * JOptionPane.showMessageDialog(null, "Archivo json cargado"); } } catch
	 * (Exception e) { JOptionPane.showMessageDialog(null,
	 * "Error al leer el json", "Error", JOptionPane.ERROR_MESSAGE); } }
	 * 
	 * }
	 */

}
