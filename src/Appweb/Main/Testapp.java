package Appweb.Main;

import javax.swing.JOptionPane;

import Appweb.Classes.Config.Classconfig;
import Appweb.Classes.Language.Lang;
import Appweb.Modules.Users.model.BLL.Crud_users;
import Appweb.Modules.Users.model.BLL.Dummy_array_add_users;
import Appweb.Modules.Users.model.BLL.Orderusers;
import Appweb.Modules.Users.model.Users_tools.Menu_users;
import Appweb.Modules.Users.model.Users_tools.User_files.Function_files;
import Appweb.Tools.Menu;
import Appweb.Tools.Menus_config;

/**
 * 
 * @author Jorge Martinez Frias 
 *         La aplicacion carga el fichero configuracion
 *         guardado, guardara en el la configuracion que este antes de salir. Si
 *         la opcion de dummies quedo activada preguntara si quiere continuar
 *         trabajando con dummies. Esta opcion se activa o desactiva en
 *         principal en el apartado dummies tambien. Si se crean dummies
 *         borraran todos los usuarios actuales para añadir nuevos, estos se
 *         guardaran en ficheros solo de dummies, en caso de querer recuperarlos
 *         puedes hacerlo en la opcion dummies cargar. Al salir de la aplicacion
 *         preguntara si quieres guardar configuracion y despues si quieres guardar los datos modificados.
 * 
 *
 */
public class Testapp {

	public static void main(String[] args) {

		int option = 0, sec = 0;

		String string = " ";

		Classconfig.getInstance();

		/////////// Inicio del Main ////////////////

		Menus_config.Main_start_1();

		do {

			/**
			 * Menu principal con opciones de test,configuracion e informacion
			 * de la version.
			 */

			option = Menu.menu_start(string, string);

			switch (option) {

			case 0:// Menu para users o products

				do {

					/**
					 * Menu para elegir entre trabajar con users o productos.
					 */
					sec = Menu.menu_object_type(string, string);

					switch (sec) {

					case 0:// users

						do {

							/**
							 * Menu para elegir entre admin,client o user_reg.
							 */
							sec = 0;
							option = Menu_users.menubotonesusers(string, string);

							switch (option) {

							case 0:// Admin//

								do {
									/**
									 * Menu para elegir entre
									 * crear,modificar,imprimir,borrar y
									 * ordenar.
									 */
									sec = Menu_users.menubotonestask_users(Lang.getInstance().getProperty("Admin"), string);

									switch (sec) {

									case 0:// Create Admin//

										/**
										 * Funcion para pedir datos de admin y
										 * crear, teniendo en cuenta que si el
										 * dni esta repetido vuelve a preguntar.
										 */
										Crud_users.Create_admin_and_add_array();

										break;

									case 1:// Edit Admin//

										/**
										 * Pedimos un dni del cual vamos a
										 * modificar datos.
										 */
										Crud_users.Modify_select_admin();

										break;

									case 2:// Menu print

										/**
										 * Menu para elegir entre imprimir todas
										 * las claves primarias,todos los
										 * usuarios entros admin,cualquier
										 * elemento que seleccionemos o el
										 * usuario que elijamos por deni.
										 */
										do {
											sec = Menu_users.menu_print(string, string);

											switch (sec) {

											case 0:// print only key element

												Crud_users.Print_Array_admin_dni();

												break;

											case 1:// print all user's element
													// and
													// all array's elements

												Crud_users.Print_Array_admin();

												break;

											case 2:// Print request attribute of
													// all
													// elements

												Crud_users.Print_Array_admin_all();

												break;

											case 3:// Print user from selected
													// dni

												Crud_users.Print_select_admin();

												break;

											}

										} while (sec != 4);

										break;

									case 3:// Menu Delete

										/**
										 * Menu para elegir entre borrar todo o
										 * un usuario a peticion de dni.
										 */
										do {
											sec = Menu_users.menu_delete(string, string);

											switch (sec) {

											case 0:// delete all element from
													// array
													// list

												Crud_users.Delete_all_admin();

												break;

											case 1:// Delete one element with
													// dni
													// request

												Crud_users.Delete_select_admin();

												break;
											case 2:// Delete one element with
													// dni
													// request

												break;

											}
										} while (sec != 2);
										break;

									case 4:// Menu order

										/**
										 * Esta funcion ordena los elementos por
										 * atributo que elijamos y los imprime.
										 */
										Orderusers.orderadmin();

										break;

									case 5:// Menu Open file

										Function_files.Admin_open_files();

										break;

									case 6:// Menu Save file

										// Function_files.save_select_format_admin();
										Function_files.Admin_save_files();

										break;

									case 7:// Back

										break;

									}

									// fin de admin
								} while (sec != 7);// Mientras no se pulse
													// 7(Back) repetimos menu
								sec = 4;

								break;

							case 1:// Client////

								do {

									sec = Menu_users.menubotonestask_users(Lang.getInstance().getProperty("Client"), string);

									switch (sec) {

									case 0:// Create Client//

										Crud_users.Create_client_and_add_array();

										break;

									case 1:// Edit Client////

										Crud_users.Modify_select_client();

										break;

									case 2:// Menu print Client

										sec = Menu_users.menu_print(string, string);

										switch (sec) {

										case 0:// print only key element

											Crud_users.Print_Array_client_dni();

											break;

										case 1:// print all user's element and
												// all array's elements

											Crud_users.Print_Array_client();

											break;

										case 2:// Print request attribute of all
												// elements

											Crud_users.Print_Array_client_all();

											break;

										case 3:// Print user from selected dni

											Crud_users.Print_select_client();

											break;

										}

										break;

									case 3:// Menu delete Client

										sec = Menu_users.menu_delete(string, string);

										switch (sec) {

										case 0:// delete all element from array
												// list

											Crud_users.Delete_all_client();

											break;

										case 1:// delete all element from array
												// list

											Crud_users.Delete_select_client();

											break;

										}

										break;

									case 4:// Order client

										Orderusers.orderclient();

										break;

									case 5:// Menu Open file

										Function_files.Client_open_files();

										break;

									case 6:// Menu Save file

										Function_files.Client_save_files();

										break;
									case 7:// Back

										break;

									}
									// fin de Client
								} while (sec != 7);

								sec = 4;

								break;

							case 2:// User_reg//

								do {
									sec = Menu_users.menubotonestask_users(Lang.getInstance().getProperty("Registered_User"), string);

									switch (sec) {

									case 0:// Create User_reg//

										Crud_users.Create_user_reg_and_add_array();

										break;

									case 1:// Edit user reg////

										Crud_users.Modify_select_user_reg();

										break;

									case 2:// Show all user reg attributes//

										sec = Menu_users.menu_print(string, string);

										switch (sec) {

										case 0:// print only key element

											Crud_users.Print_Array_user_reg_dni();

											break;

										case 1:// print all user's element and
												// all array's elements

											Crud_users.Print_Array_user_reg();

											break;

										case 2:// Print request attribute of all
												// elements

											Crud_users.Print_Array_user_reg_all();

											break;

										case 3:// Print user from selected dni

											Crud_users.Print_select_user_reg();

											break;

										}

										break;

									case 3:// Delete User reg

										sec = Menu_users.menu_delete(string, string);

										switch (sec) {

										case 0:// delete all element from array
												// list

											Crud_users.Delete_all_user_reg();

											break;

										case 1:// delete one element with
												// request dni
											Crud_users.Delete_select_user_reg();

											break;

										}

										break;

									case 4:

										Orderusers.orderuser_reg();

										break;

									case 5:// Menu Open file user_reg

										Function_files.User_reg_open_files();

										break;

									case 6:// Menu Save file user reg

										Function_files.User_reg_save_files();

										break;
									case 7:// Back

										break;

									}

									// Fin de user_reg
								} while (sec != 7);// para volver al menu
								sec = 4;

								break;

							}

						} while (sec == 4);// Cuando en un menu sec sea la
											// opcion 4(Back) vuelve al menu

						break;
					case 1:// products

						break;
					case 2:// back
						break;

					}

				} while (sec != 2);// Cuando en un menu sec sea diferente la
									// opcion 2(Back) vuelve al menu

				break;
			case 1:

				do {
					sec = Menus_config.menuselect_type_config(string, string);

					switch (sec) {

					case 0:
						// Entrada al menu configuracion de parametros
						Menus_config.Menu_pack_config();

						break;
					case 1:

						Menus_config.Menu_theme();

						break;

					}

				} while (sec != 2);

				break;

			case 2:// Creamos los tres usuarios con dummies

				Dummy_array_add_users.Dummyrequest();

				break;
			case 3:
				// Saldra informacion sobre las cosas actualizadas en la version
				JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Version_5.1"), Lang.getInstance().getProperty("Information"),
						JOptionPane.INFORMATION_MESSAGE);

				break;

			case 4:

				Menus_config.Main_exit_and_save();

				break;
			}

		} while ((sec == 2) || (sec == 0));// repite mientras la opcion del menu
											// secundario sea

	}

}
