package Appweb.Modules.Users.Users_tools.User_files;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import Appweb.Classes.Language.Lang;
import Appweb.Modules.Dummies.View.task_Dummy_view;
import Appweb.Modules.Users.Classes.Admin;
import Appweb.Modules.Users.Classes.Client;
import Appweb.Modules.Users.Classes.User_reg;
import Appweb.Modules.Users.Classes.singleton;

public class json {

	public static void save_json_admin() {

		if (singleton.Admin_array.size() != 0) {

			String PATH = null;
			try {
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("empleafijo", Admin.class);

				JFileChooser fileChooser = new JFileChooser();

				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

				int seleccion = fileChooser.showSaveDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					File JFC = fileChooser.getSelectedFile();
					PATH = JFC.getAbsolutePath();
					PATH = PATH + ".json";

					Gson gson = new Gson();
					String json = gson.toJson(singleton.Admin_array);
					FileWriter fileXml = new FileWriter(PATH);
					fileXml.write(json.toString());
					fileXml.close();

					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("User_file_saved") + " Admin json",
							Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Failed_to_save_user") + " Admin json", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("No_data_to_save"), Lang.getInstance().getProperty("File") + " json",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public static void open_json_admin() {

		String PATH = null;
		Admin e1 = new Admin("");

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Admin", Admin.class);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				singleton.Admin_array.clear();

				JsonReader lector = new JsonReader(new FileReader(PATH));
				JsonParser parseador = new JsonParser();
				JsonElement raiz = parseador.parse(lector);

				Gson json = new Gson();
				JsonArray lista = raiz.getAsJsonArray();
				for (JsonElement elemento : lista) {
					e1 = json.fromJson(elemento, Admin.class);
					singleton.Admin_array.add(e1);
				}
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Loaded_user_file") + " Admin json",
						Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_user_file")+ "json", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void save_json_client() {

		if (singleton.Client_array.size() != 0) {

			String PATH = null;
			try {
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("empleafijo", Client.class);

				JFileChooser fileChooser = new JFileChooser();

				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

				int seleccion = fileChooser.showSaveDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					File JFC = fileChooser.getSelectedFile();
					PATH = JFC.getAbsolutePath();
					PATH = PATH + ".json";

					Gson gson = new Gson();
					String json = gson.toJson(singleton.Client_array);
					FileWriter fileXml = new FileWriter(PATH);
					fileXml.write(json.toString());
					fileXml.close();

					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("User_file_saved") + " Client json",
							Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Failed_to_save_user") + " Client json", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("No_data_to_save"), Lang.getInstance().getProperty("File") + " json",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public static void open_json_client() {
		String PATH = null;
		Client e1 = new Client("");

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Client", Client.class);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				singleton.Client_array.clear();

				JsonReader lector = new JsonReader(new FileReader(PATH));
				JsonParser parseador = new JsonParser();
				JsonElement raiz = parseador.parse(lector);

				Gson json = new Gson();
				JsonArray lista = raiz.getAsJsonArray();
				for (JsonElement elemento : lista) {
					e1 = json.fromJson(elemento, Client.class);
					singleton.Client_array.add(e1);
				}
				
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Loaded_user_file") + " Client json",
						Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_user_file")+ " json", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void save_json_user_reg() {

		if (singleton.User_reg_array.size() != 0) {

			String PATH = null;
			try {
				XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
				xstreamjson.setMode(XStream.NO_REFERENCES);
				xstreamjson.alias("empleafijo", Client.class);

				JFileChooser fileChooser = new JFileChooser();

				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

				int seleccion = fileChooser.showSaveDialog(null);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					File JFC = fileChooser.getSelectedFile();
					PATH = JFC.getAbsolutePath();
					PATH = PATH + ".json";

					Gson gson = new Gson();
					String json = gson.toJson(singleton.User_reg_array);
					FileWriter fileXml = new FileWriter(PATH);
					fileXml.write(json.toString());
					fileXml.close();

					JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("User_file_saved") + " User_reg json",
							Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Failed_to_save_user") + " User_reg json", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} else {

			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("No_data_to_save"), Lang.getInstance().getProperty("File") + " json",
					JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public static void open_json_user_reg() {
		String PATH = null;
		User_reg e1 = new User_reg("");

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("User_reg", User_reg.class);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();

				singleton.User_reg_array.clear();

				JsonReader lector = new JsonReader(new FileReader(PATH));
				JsonParser parseador = new JsonParser();
				JsonElement raiz = parseador.parse(lector);

				Gson json = new Gson();
				JsonArray lista = raiz.getAsJsonArray();
				for (JsonElement elemento : lista) {
					e1 = json.fromJson(elemento, User_reg.class);
					singleton.User_reg_array.add(e1);
				}
				
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Loaded_user_file") + " User reg json",
						Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_user_file")+ "json", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void auto_save_json_file() {

		String PATH = " ";

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Admin_files/adminusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("Admin", Admin.class);

			if (singleton.Admin_array.size() != 0) {
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".json";

				Gson gson = new Gson();
				String json = gson.toJson(singleton.Admin_array);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();

				System.out.print(Lang.getInstance().getProperty("User_file_saved") + " Admin json \n");
			}

		} catch (Exception e) {
			System.out.print(Lang.getInstance().getProperty("Failed_to_save_user") + " Admin json"+" \n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/clientusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("Client", Client.class);

			if (singleton.Client_array.size() != 0) {
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".json";

				Gson gson = new Gson();
				String json = gson.toJson(singleton.Client_array);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();

				System.out.print(Lang.getInstance().getProperty("User_file_saved") + " Client json \n");
			}

		} catch (Exception e) {
			System.out.print(Lang.getInstance().getProperty("Failed_to_save_user") + " Client json"+" \n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/useregusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("User_reg", User_reg.class);

			if (singleton.User_reg_array.size() != 0) {
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".json";

				Gson gson = new Gson();
				String json = gson.toJson(singleton.User_reg_array);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();

				System.out.print(Lang.getInstance().getProperty("User_file_saved") + " User_reg json \n");
			}

		} catch (Exception e) {
			System.out.print(Lang.getInstance().getProperty("Failed_to_save_user") + " user_reg json \n");
		}

	}

	public static void auto_open_json_file() {

		String PATH = " ";
		Admin a = new Admin("");
		Client c = new Client("");
		User_reg u = new User_reg("");

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Admin_files/adminusers.json";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Admin", Admin.class);

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();

			singleton.Admin_array.clear();

			JsonReader lector = new JsonReader(new FileReader(PATH));
			JsonParser parseador = new JsonParser();
			JsonElement raiz = parseador.parse(lector);

			Gson json = new Gson();
			JsonArray lista = raiz.getAsJsonArray();
			for (JsonElement elemento : lista) {
				a = json.fromJson(elemento, Admin.class);
				singleton.Admin_array.add(a);

			}
			System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " Admin json"+" \n");

		} catch (Exception e) {
                    e.printStackTrace();
			System.out.print(Lang.getInstance().getProperty("Error_loading_user_file")+ " json"+" \n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/clientusers.json";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Client", Admin.class);

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();

			singleton.Client_array.clear();

			JsonReader lector = new JsonReader(new FileReader(PATH));
			JsonParser parseador = new JsonParser();
			JsonElement raiz = parseador.parse(lector);

			Gson json = new Gson();
			JsonArray lista = raiz.getAsJsonArray();
			for (JsonElement elemento : lista) {
				c = json.fromJson(elemento, Client.class);
				singleton.Client_array.add(c);

			}
			System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " Client json"+" \n");

		} catch (Exception e) {
			System.out.print(Lang.getInstance().getProperty("Error_loading_user_file")+ " json"+" \n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/useregusers.json";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("User_reg", User_reg.class);

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();

			singleton.User_reg_array.clear();

			JsonReader lector = new JsonReader(new FileReader(PATH));
			JsonParser parseador = new JsonParser();
			JsonElement raiz = parseador.parse(lector);

			Gson json = new Gson();
			JsonArray lista = raiz.getAsJsonArray();
			for (JsonElement elemento : lista) {
				u = json.fromJson(elemento, User_reg.class);
				singleton.User_reg_array.add(u);

			}
			System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " User reg json"+" \n");

		} catch (Exception e) {
			System.out.print(Lang.getInstance().getProperty("Error_loading_user_file")+ " json"+" \n");
		}

	}

	public static void auto_save_json_file_dummy_admin() {

		String PATH = " ";

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Dummies/files/Admin_files/dummyadminusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("Admin", Admin.class);

			if (singleton.Admin_array.size() != 0) {
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".json";

				Gson gson = new Gson();
				String json = gson.toJson(singleton.Admin_array);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();

				System.out.print(Lang.getInstance().getProperty("User_file_saved") + " Dummy  Admin json \n");
			}

		} catch (Exception e) {
			System.out.print("Error_save_user_file "+ "json dummy Admin"+" \n");
		}
/**
		try {
			PATH = new java.io.File(".").getCanonicalPath() + "src/Appweb/Modules/Users/Dummies/files/dummyadminusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("Client", Client.class);

			if (singleton.Client_array.size() != 0) {
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".json";

				Gson gson = new Gson();
				String json = gson.toJson(singleton.Client_array);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();

				System.out.print(Lang.getInstance().getProperty("User_file_saved") + " Dummy Client json \n");
			}

		} catch (Exception e) {
			System.out.print(Lang.getInstance().getProperty("Error_loading_user_file")+ "json dummy Client"+" \n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/dummyuseregusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
			xstreamjson.setMode(XStream.NO_REFERENCES);
			xstreamjson.alias("User_reg", User_reg.class);

			if (singleton.User_reg_array.size() != 0) {
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".json";

				Gson gson = new Gson();
				String json = gson.toJson(singleton.User_reg_array);
				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(json.toString());
				fileXml.close();

				System.out.print(Lang.getInstance().getProperty("User_file_saved") + " Dummy user reg json \n");
			}

		} catch (Exception e) {
			System.out.print(Lang.getInstance().getProperty("Error_loading_user_file")+ "json dummy User_reg"+" \n");
		}
*/
	}

	public static void auto_open_json_file_dummy() {

		String PATH = " ";
		Admin a = null;
		Client c = null;
		User_reg u = null;

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Dummies/files/Admin_files/dummyadminusers.json";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Admin", Admin.class);

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();

			singleton.Admin_array.clear();

			JsonReader lector = new JsonReader(new FileReader(PATH));
			JsonParser parseador = new JsonParser();
			JsonElement raiz = parseador.parse(lector);

			Gson json = new Gson();
			JsonArray lista = raiz.getAsJsonArray();
			for (JsonElement elemento : lista) {
				a = json.fromJson(elemento, Admin.class);
				singleton.Admin_array.add(a);

			}
                        task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Loaded_user_file") + " Dummy  Admin json"+" \n");
			//System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " Dummy  Admin json"+" \n");

		} catch (Exception e) {
			//System.out.print(Lang.getInstance().getProperty("Error_loading_user_file")+ "json"+" \n");
                        task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Error_loading_user_file")+ "json"+" \n");
		}
/**
		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/dummyclientusers.json";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("Client", Admin.class);

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();

			singleton.Client_array.clear();

			JsonReader lector = new JsonReader(new FileReader(PATH));
			JsonParser parseador = new JsonParser();
			JsonElement raiz = parseador.parse(lector);

			Gson json = new Gson();
			JsonArray lista = raiz.getAsJsonArray();
			for (JsonElement elemento : lista) {
				c = json.fromJson(elemento, Client.class);
				singleton.Client_array.add(c);

			}
			System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " Dummy Client json"+" \n");

		} catch (Exception e) {
			System.out.print(Lang.getInstance().getProperty("Error_loading_user_file")+ "json"+" \n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/dummyuseregusers.json";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			XStream xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("User_reg", User_reg.class);

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();

			singleton.User_reg_array.clear();

			JsonReader lector = new JsonReader(new FileReader(PATH));
			JsonParser parseador = new JsonParser();
			JsonElement raiz = parseador.parse(lector);

			Gson json = new Gson();
			JsonArray lista = raiz.getAsJsonArray();
			for (JsonElement elemento : lista) {
				u = json.fromJson(elemento, User_reg.class);
				singleton.User_reg_array.add(u);

			}
			System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " Dummy user reg json"+" \n");

		} catch (Exception e) {
			System.out.print(Lang.getInstance().getProperty("Error_loading_user_file")+ "json"+" \n");
		}
*/
	}
}
