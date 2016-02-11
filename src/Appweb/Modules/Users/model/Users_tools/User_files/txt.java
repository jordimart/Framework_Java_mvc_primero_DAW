package Appweb.Modules.Users.model.Users_tools.User_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import Appweb.Modules.Users.model.Classes.Admin;
import Appweb.Modules.Users.model.Classes.Client;
import Appweb.Modules.Users.model.Classes.User_reg;
import Appweb.Modules.Users.model.Classes.singleton;

public class txt {

	public static void save_txt_admin() {

		if (singleton.Admin_array.size() != 0) {

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
					o.writeObject(singleton.Admin_array);
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

	public static void open_txt_admin() {
		String PATH = " ";
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
				singleton.Admin_array = (ArrayList<Admin>) oi.readObject();
				oi.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void save_txt_client() {

		if (singleton.Client_array.size() != 0) {

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
					o.writeObject(singleton.Client_array);
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

	public static void open_txt_client() {
		String PATH = " ";
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
				singleton.Client_array = (ArrayList<Client>) oi.readObject();
				oi.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void save_txt_user_reg() {

		if (singleton.User_reg_array.size() != 0) {

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
					o.writeObject(singleton.User_reg_array);
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

	public static void open_txt_user_reg() {

		String PATH = " ";

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
				singleton.User_reg_array = (ArrayList<User_reg>) oi.readObject();
				oi.close();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
		}

	}
	
	public static void auto_save_txt_file() {

		String PATH = " ";

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Admin_files/adminusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File f;

			if (singleton.Admin_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".txt";
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton.Admin_array);
				o.close();
				System.out.print("Archivo TXT Admin guardado con exito\n");
			}
		} catch (Exception e) {
			System.out.print("Error al grabar Admin txt\n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/clientusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File f;

			if (singleton.Client_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".txt";
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton.Client_array);
				o.close();
				System.out.print("Archivo txt Client guardado con exito\n");
			}
		} catch (Exception e) {
			System.out.print("Error al grabar Client txt\n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/useregusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File f;

			if (singleton.User_reg_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".txt";
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton.User_reg_array);
				o.close();
				System.out.print("Archivo txt User_reg guardado con exito\n");
			}
		} catch (Exception e) {
			System.out.print("Error al grabar user_reg txt \n");
		}
	}

	public static void auto_open_txt_file() {

		String PATH = " ";

		try {

			File f;

			try {
				PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Admin_files/adminusers.txt";
			} catch (IOException e) {
				e.printStackTrace();
			}

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();
			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			singleton.Admin_array = (ArrayList<Admin>) oi.readObject();
			oi.close();

			System.out.print("Archivo cargado txt admin \n");

		} catch (Exception e) {
			System.out.print("Error al leer Admin txt \n");
		}

		try {

			File f;

			try {
				PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/clientusers.txt";
			} catch (IOException e) {
				e.printStackTrace();
			}

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();
			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			singleton.Client_array = (ArrayList<Client>) oi.readObject();
			oi.close();

			System.out.print("Archivo cargado txt client \n");

		} catch (Exception e) {
			System.out.print("Error al leer Client txt \n");
		}

		try {

			File f;

			try {
				PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/useregusers.txt";
			} catch (IOException e) {
				e.printStackTrace();
			}

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();
			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			singleton.User_reg_array = (ArrayList<User_reg>) oi.readObject();
			oi.close();

			System.out.print("Archivo cargado txt user reg \n");

		} catch (Exception e) {
			System.out.print("Error al leer User_reg txt \n");
		}

	}
	
	public static void auto_save_txt_file_dummy() {

		String PATH = " ";

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Admin_files/dummyadminusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File f;

			if (singleton.Admin_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".txt";
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton.Admin_array);
				o.close();
				System.out.print("Archivo dummy txt Admin guardado con exito\n");
			}
		} catch (Exception e) {
			System.out.print("Error al grabar dummy Admin txt\n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/dummyclientusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File f;

			if (singleton.Client_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".txt";
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton.Client_array);
				o.close();
				System.out.print("Archivo dummy txt Client guardado con exito\n");
			}
		} catch (Exception e) {
			System.out.print("Error al grabar dummy Client txt\n");
		}

		try {
			PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/dummyuseregusers";
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			File f;

			if (singleton.User_reg_array.size() != 0) {

				File JFC = new File(PATH);
				PATH = JFC.getAbsolutePath();
				PATH = PATH + ".txt";
				f = new File(PATH);

				FileOutputStream fo = new FileOutputStream(f);
				ObjectOutputStream o = new ObjectOutputStream(fo);
				o.writeObject(singleton.User_reg_array);
				o.close();
				System.out.print("Archivo dummy txt User_reg guardado con exito\n");
			}
		} catch (Exception e) {
			System.out.print("Error al grabar dummy user_reg txt \n");
		}
	}
	
	public static void auto_open_txt_file_dummy() {

		String PATH = " ";

		try {

			File f;

			try {
				PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Admin_files/dummyadminusers.txt";
			} catch (IOException e) {
				e.printStackTrace();
			}

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();
			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			singleton.Admin_array = (ArrayList<Admin>) oi.readObject();
			oi.close();

			System.out.print("Archivo cargado dummy txt admin \n");

		} catch (Exception e) {
			System.out.print("Error al leer dummy Admin txt \n");
		}

		try {

			File f;

			try {
				PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/Client_files/dummyclientusers.txt";
			} catch (IOException e) {
				e.printStackTrace();
			}

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();
			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			singleton.Client_array = (ArrayList<Client>) oi.readObject();
			oi.close();

			System.out.print("Archivo cargado dummy txt client \n");

		} catch (Exception e) {
			System.out.print("Error al leer dummy Client txt \n");
		}

		try {

			File f;

			try {
				PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/model/Files/User_reg_files/dummyuseregusers.txt";
			} catch (IOException e) {
				e.printStackTrace();
			}

			File JFC = new File(PATH);
			PATH = JFC.getAbsolutePath();
			f = new File(PATH);

			FileInputStream fi = new FileInputStream(f);
			ObjectInputStream oi = new ObjectInputStream(fi);
			singleton.User_reg_array = (ArrayList<User_reg>) oi.readObject();
			oi.close();

			System.out.print("Archivo cargado dummy txt user reg \n");

		} catch (Exception e) {
			System.out.print("Error al leer dummy User_reg txt \n");
		}
	}
}