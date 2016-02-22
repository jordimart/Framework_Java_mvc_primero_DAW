package Appweb.Modules.Users.Users_tools.User_files;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;

import Appweb.Modules.Users.Classes.Admin;
import Appweb.Modules.Users.Classes.Client;
import Appweb.Modules.Users.Classes.User_reg;
import Appweb.Modules.Users.Classes.singleton;

public class xml {

	private static final String ENCODING = "UTF-8";

	public static void save_xml_admin() {

		if (singleton.Admin_array.size() != 0) {

			String PATH = " ";

			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, Admin.class);

				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(singleton.Admin_array, osw);
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

	public static void open_xml_admin() {
		String PATH = " ";

		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Admin.class);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));
			

			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				singleton.Admin_array = (ArrayList<Admin>) xstream.fromXML(new FileReader(PATH));

				JOptionPane.showMessageDialog(null, "Archivo cargado");
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void save_xml_client() {

		if (singleton.Client_array.size() != 0) {

			String PATH = " ";
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, Client.class);

				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(singleton.Client_array, osw);
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
				JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else {

			JOptionPane.showMessageDialog(null, "No hay datos para guardar", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public static void open_xml_client() {
		String PATH = " ";
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Client.class);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				singleton.Client_array = (ArrayList<Client>) xstream.fromXML(new FileReader(PATH));

				JOptionPane.showMessageDialog(null, "Archivo cargado");
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void save_xml_user_reg() {

		if (singleton.User_reg_array.size() != 0) {

			String PATH = " ";
			
			try {
				OutputStream os = new ByteArrayOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				XStream xstream = new XStream();
				Annotations.configureAliases(xstream, User_reg.class);

				String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
				xstream.toXML(singleton.User_reg_array, osw);
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
				JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
			}

		} else {

			JOptionPane.showMessageDialog(null, "No hay datos para guardar", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public static void open_xml_user_reg() {
		String PATH = " ";
		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, User_reg.class);

			JFileChooser fileChooser = new JFileChooser();

			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

			int seleccion = fileChooser.showOpenDialog(null);
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				File JFC = fileChooser.getSelectedFile();
				PATH = JFC.getAbsolutePath();
				singleton.User_reg_array = (ArrayList<User_reg>) xstream.fromXML(new FileReader(PATH));

				JOptionPane.showMessageDialog(null, "Archivo cargado");
			}

		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static void auto_save_xml_file() {

		String PATH = " ";

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Admin_files/adminusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Admin.class);

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.Admin_array, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			if (singleton.Admin_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".xml";

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
				System.out.print( "Archivo XML admin guardado con exito \n");
			} else {

				File path = new File(PATH);

				path.delete();
			}
		} catch (Exception e1) {
			System.out.print( "Error al grabar Admin xml \n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/clientusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Client.class);

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.Client_array, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			if (singleton.Client_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".xml";

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
				System.out.print( "Archivo XML Client guardado con exito \n");
			} else {

				File path = new File(PATH);

				path.delete();
			}
		} catch (Exception e1) {
			System.out.print( "Error al grabar Client xml \n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/useregusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, User_reg.class);

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.User_reg_array, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			if (singleton.User_reg_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".xml";

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
				System.out.print( "Archivo XML User reg guardado con exito \n");
			} else {

				File path = new File(PATH);

				path.delete();
			}
		} catch (Exception e1) {
			System.out.print( "Error al grabar User_reg xml \n");
		}
	}

	public static void auto_open_xml_file() {

		String PATH = " ";

		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Admin.class);

			

				try {
					PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Admin_files/adminusers.xml";
				} catch (IOException e) {
					e.printStackTrace();
				}
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				singleton.Admin_array = (ArrayList<Admin>) xstream.fromXML(new FileReader(PATH));

				System.out.print( "Archivo cargado xml Admin \n");
			

		} catch (Exception e1) {
			System.out.print( "Error al leer Admin xml\n");
		}

		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Client.class);

			

				try {

					PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/clientusers.xml";
				} catch (IOException e) {
					e.printStackTrace();
				}
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				singleton.Client_array = (ArrayList<Client>) xstream.fromXML(new FileReader(PATH));

				System.out.print( "Archivo cargado xml Client \n");
			

		} catch (Exception e1) {
			System.out.print( "Error al leer Client xml \n");
		}

		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, User_reg.class);

			

				try {
					PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/useregusers.xml";
				} catch (IOException e) {
					e.printStackTrace();
				}
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				singleton.User_reg_array = (ArrayList<User_reg>) xstream.fromXML(new FileReader(PATH));

				System.out.print( "Archivo cargado xml User_reg \n");
			

		} catch (Exception e1) {
			System.out.print( "Error al leer User_reg xml\n");
		}

	}

	public static void auto_save_xml_file_dummy() {

		String PATH = " ";

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Admin_files/dummyadminusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Admin.class);

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.Admin_array, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			if (singleton.Admin_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".xml";

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
				System.out.print( "Archivo dummy xml admin guardado con exito \n");
			} else {

				File path = new File(PATH);

				path.delete();
			}
		} catch (Exception e1) {
			System.out.print( "Error al grabar dummy Admin xml \n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/dummyclientusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Client.class);

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.Client_array, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			if (singleton.Client_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".xml";

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
				System.out.print( "Archivo dummy xml Client guardado con exito \n");
			} else {

				File path = new File(PATH);

				path.delete();
			}
		} catch (Exception e1) {
			System.out.print( "Error al grabar dummy Client xml \n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/dummyuseregusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, User_reg.class);

			String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
			xstream.toXML(singleton.User_reg_array, osw);
			StringBuffer xml = new StringBuffer();
			xml.append(header);
			xml.append(os.toString());

			if (singleton.User_reg_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".xml";

				FileWriter fileXml = new FileWriter(PATH);
				fileXml.write(xml.toString());
				fileXml.close();
				osw.close();
				os.close();
				System.out.print( "Archivo dummy xml User reg guardado con exito \n");
			} else {

				File path = new File(PATH);

				path.delete();
			}
		} catch (Exception e1) {
			System.out.print( "Error al grabar dummy User_reg xml \n");
		}
	}
	
	public static void auto_open_xml_file_dummy() {

		String PATH = " ";

		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Admin.class);

			

				try {
					PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Admin_files/dummyadminusers.xml";
				} catch (IOException e) {
					e.printStackTrace();
				}
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				singleton.Admin_array = (ArrayList<Admin>) xstream.fromXML(new FileReader(PATH));

				System.out.print( "Archivo cargado dummy xml Admin \n");
			

		} catch (Exception e1) {
			System.out.print( "Error al leer dummy Admin xml\n");
		}

		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, Client.class);

			

				try {

					PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/dummyclientusers.xml";
				} catch (IOException e) {
					e.printStackTrace();
				}
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				singleton.Client_array = (ArrayList<Client>) xstream.fromXML(new FileReader(PATH));

				System.out.print( "Archivo cargado dummy xml Client \n");
			

		} catch (Exception e1) {
			System.out.print( "Error al leer dummy Client xml \n");
		}

		try {
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, User_reg.class);

			

				try {
					PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/dummyuseregusers.xml";
				} catch (IOException e) {
					e.printStackTrace();
				}
				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				singleton.User_reg_array = (ArrayList<User_reg>) xstream.fromXML(new FileReader(PATH));

				System.out.print( "Archivo cargado dummy xml User_reg \n");
			

		} catch (Exception e1) {
			System.out.print( "Error al leer dummy User_reg xml\n");
		}

	}
}
