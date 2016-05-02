package Appweb.Modules.Main.Controller;

import Appweb.Classes.ConectionBD;
import Appweb.Classes.Mongo_DB;
import Appweb.General_tools.singletonapp;
import static Appweb.General_tools.singletonapp.singlecargar;
import Appweb.Modules.Main.Model.Config.Classes.Classconfig;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Config.Model.BLL_config.BLL_config;
import static Appweb.Modules.Main.Model.Config.Model.DAO_config.DAO_config.auto_open_config_json;
import Appweb.Modules.Main.Model.Config.View.menu_Settings;
import Appweb.Modules.Main.Model.Dummies.Model.BLL_Dummy.BLL_Dummies;
import Appweb.Modules.Main.Model.Dummies.View.task_Dummy_view;
import Appweb.Modules.Main.Model.Login.model.BLL_Login.BLL_Login;
import Appweb.Modules.Main.Model.Login.View.menu_Input;
import Appweb.Modules.Users.Admin.Controller.ControllerAdmin;
import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import Appweb.Modules.Users.Admin.View.task_Admin_view;
import Appweb.Modules.Users.Client.Controller.ControllerClient;
import Appweb.Modules.Users.Client.View.table_Client_view;
import Appweb.Modules.Users.Client.View.task_Client_view;
import Appweb.Modules.Users.User_reg.Controller.ControllerUser;
import Appweb.Modules.Users.User_reg.View.table_User_view;
import Appweb.Modules.Users.User_reg.View.task_User_view;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author ASUSG50V
 */
public class ControllerMain implements ActionListener {

    public static menu_Input Login;
    public static menu_Settings Settings;
    public static task_Dummy_view Dummies;

    public ControllerMain(JFrame start, int i) {

        if (i == 0) {
            Login = (menu_Input) start;
        }
        if (i == 1) {
            Settings = (menu_Settings) start;
        }
        if (i == 2) {
            Dummies = (task_Dummy_view) start;
        }
    }

    public enum Action_menu {

        //botones menu Input//
        btnAdminlogin,
        btnClientlogin,
        btnUser_reglogin,
        btnTestlogin,
        btnSettings,
        btnExit,
        btn_English_main,
        btn_spain_main,
        btn_valencian_main,
        btn_ini,
        //botones de menu config//

        btn_Accept_Settings,
        btn_Load_Settings,
        btn_Return_Settings,
        btn_Save_setting,
        btn_Show,
        //botones de menu Dummies//

        btnCreate_dummis_admin,
        btnDelete_all_admin,
        btnCreate_dummis_client,
        btnDelete_all_client,
        btnCreate_dummis_user,
        btnDelete_all_user,
        btnEntry_admin,

    }

    public void Start(int i) {
        if (i == 0) {

            //Funcion para que solo cargue archivos la primera vez
            if (singlecargar == false) {
                auto_open_config_json();
                ConectionBD.start_pool_conection();

                singletonapp.mongo = new Mongo_DB();
                singletonapp.nom_bd = singletonapp.mongo.getNom_bd();//coge el nombre de la base de datos
                singletonapp.nom_table = singletonapp.mongo.getNom_table();//coge el nombre de la tabla

                Mongo_DB.connect();//Abre la conexion a mongo
                if (singletonapp.client != null) {
                    singletonapp.db = singletonapp.mongo.getDb();
                    singletonapp.collection = singletonapp.mongo.getCollection();
                }

                singlecargar = true;
            }
            //Configuracion manual de la vista
            Login.setVisible(true);
            Login.setTitle("Menu Login ");
            Login.setLocationRelativeTo(null);
            Login.setSize(1000, 650);//ancho x alto
            Login.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Login.panelNice1.setLocation(500, 300);
            
            singleadmin.a=new Admin();//se inicializa para el retorno de log out
            
           

            // Conjunto de teclas que queremos que sirvan para pasar el foco 
            // al siguiente campo de texto: ENTER y TAB
            Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
            teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
            teclas.add(AWTKeyStroke.getAWTKeyStroke(
                    KeyEvent.VK_TAB, 0));

            //Traduccion de botones y labels
            Login.btn_Exit.setText(Lang.getInstance().getProperty("Exit"));

            //botones de accion
            Login.btn_Exit.setActionCommand("btnExit");
            Login.btn_Exit.addActionListener(this);

            Login.btn_English_main.setActionCommand("btn_English_main");
            Login.btn_English_main.addActionListener(this);

            Login.btn_spain_main.setActionCommand("btn_spain_main");
            Login.btn_spain_main.addActionListener(this);

            Login.btn_valencian_main.setActionCommand("btn_valencian_main");
            Login.btn_valencian_main.addActionListener(this);

            Login.btn_ini.setActionCommand("btn_ini");
            Login.btn_ini.addActionListener(this);

            // Login.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Login.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                            JOptionPane.INFORMATION_MESSAGE);
                    Mongo_DB.disconnect();
                    System.exit(0);
                }
            });
        }
        if (i == 1) {

            //Configuracion manual de la vista
            Settings.setVisible(true);
            Settings.setTitle("Menu Settings");
            Settings.setLocationRelativeTo(null);
            Settings.setSize(980, 800);//ancho x alto
            Settings.setResizable(false);

            BLL_config.charge_config();

            //Traduccion de botones y labels
            Settings.labelHeader1.setText(Lang.getInstance().getProperty("Date_format"));
            Settings.labelHeader2.setText(Lang.getInstance().getProperty("Number_of_decimals"));
            Settings.labelHeader4.setText(Lang.getInstance().getProperty("Language"));
            Settings.labelHeader5.setText(Lang.getInstance().getProperty("Theme"));
            Settings.labelHeader3.setText(Lang.getInstance().getProperty("Currency"));
            Settings.btn_Accept_Settings.setText(Lang.getInstance().getProperty("Apply"));
            Settings.btn_Load_Settings.setText(Lang.getInstance().getProperty("Load"));
            Settings.btn_Return_Settings.setText(Lang.getInstance().getProperty("Back"));
            Settings.btn_Save_setting.setText(Lang.getInstance().getProperty("Save"));
            Settings.btn_Show.setText(Lang.getInstance().getProperty("Show"));

            //botones de accion
            Settings.btn_Accept_Settings.setActionCommand("btn_Accept_Settings");
            Settings.btn_Accept_Settings.addActionListener(this);

            Settings.btn_Load_Settings.setActionCommand("btn_Load_Settings");
            Settings.btn_Load_Settings.addActionListener(this);

            Settings.btn_Return_Settings.setActionCommand("btn_Return_Settings");
            Settings.btn_Return_Settings.addActionListener(this);

            Settings.btn_Save_setting.setActionCommand("btn_Save_setting");
            Settings.btn_Save_setting.addActionListener(this);

            Settings.btn_Show.setActionCommand("btn_Show");
            Settings.btn_Show.addActionListener(this);

            this.Settings.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Settings.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {

                    Settings.dispose();
                    new ControllerMain(new menu_Input(), 0).Start(0);

                }
            });
        }

        if (i == 2) {

            //Configuracion manual de la vista
            Dummies.setVisible(true);
            Dummies.setTitle("Menu Test");
            Dummies.setLocationRelativeTo(null);
            Dummies.setSize(1100, 900);//ancho x alto
            //this.setResizable(false);
            //Dummies.setExtendedState(JFrame.MAXIMIZED_BOTH);

            //Traduccion de botones y labels
            Dummies.labelRound1.setText(Lang.getInstance().getProperty("Dummies_users"));
            Dummies.labelRound2.setText(Lang.getInstance().getProperty("Admin"));
            Dummies.labelRound3.setText(Lang.getInstance().getProperty("Number"));
            Dummies.btnCreate_dummis_admin.setText(Lang.getInstance().getProperty("Create"));
            Dummies.btnDelete_all_admin.setText(Lang.getInstance().getProperty("Delete_all"));

            Dummies.labelRound4.setText(Lang.getInstance().getProperty("Dummies_users"));
            Dummies.labelRound5.setText(Lang.getInstance().getProperty("Client"));
            Dummies.labelRound6.setText(Lang.getInstance().getProperty("Number"));
            Dummies.btnCreate_dummis_client.setText(Lang.getInstance().getProperty("Create"));
            Dummies.btnDelete_all_client.setText(Lang.getInstance().getProperty("Delete_all"));

            Dummies.labelRound7.setText(Lang.getInstance().getProperty("Dummies_users"));
            Dummies.labelRound8.setText(Lang.getInstance().getProperty("Registered_User"));
            Dummies.labelRound9.setText(Lang.getInstance().getProperty("Number"));
            Dummies.btnCreate_dummis_user.setText(Lang.getInstance().getProperty("Create"));
            Dummies.btnDelete_all_user.setText(Lang.getInstance().getProperty("Delete_all"));

            Dummies.btnEntry_admin.setText(Lang.getInstance().getProperty("Login_Administrator"));

            //botones de accion
            Dummies.btnCreate_dummis_admin.setActionCommand("btnCreate_dummis_admin");
            Dummies.btnCreate_dummis_admin.addActionListener(this);

            Dummies.btnDelete_all_admin.setActionCommand("btnDelete_all_admin");
            Dummies.btnDelete_all_admin.addActionListener(this);

            Dummies.btnCreate_dummis_client.setActionCommand("btnCreate_dummis_client");
            Dummies.btnCreate_dummis_client.addActionListener(this);

            Dummies.btnDelete_all_client.setActionCommand("btnDelete_all_client");
            Dummies.btnDelete_all_client.addActionListener(this);

            Dummies.btnCreate_dummis_user.setActionCommand("btnCreate_dummis_user");
            Dummies.btnCreate_dummis_user.addActionListener(this);

            Dummies.btnDelete_all_user.setActionCommand("btnDelete_all_user");
            Dummies.btnDelete_all_user.addActionListener(this);

            Dummies.btnEntry_admin.setActionCommand("btnEntry_admin");
            Dummies.btnEntry_admin.addActionListener(this);

            this.Dummies.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Dummies.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Dummies.dispose();
                    new ControllerMain(new menu_Input(), 0).Start(0);

                }
            });
        }
    }

    public void actionPerformed(ActionEvent ae) {
        switch (Action_menu.valueOf(ae.getActionCommand())) {

            case btnAdminlogin:

                Login.dispose();
                new ControllerAdmin(new task_Admin_view(), 0).Start(0);

                break;

            case btnUser_reglogin:

                Login.dispose();
                new ControllerUser(new table_User_view(), 0).Start(0);

                break;

            case btnClientlogin:

                Login.dispose();
                new ControllerClient(new table_Client_view(), 0).Start(0);

                break;

            case btnTestlogin:

                Login.dispose();
                new ControllerMain(new task_Dummy_view(), 2).Start(2);

                break;

            case btnSettings:

                Login.dispose();
                new ControllerMain(new menu_Settings(), 1).Start(1);

                break;
            case btn_English_main:

                BLL_config.language_english();
                Login.dispose();
                new ControllerMain(new menu_Input(), 0).Start(0);

                break;
            case btn_spain_main:

                BLL_config.language_spanish();
                Login.dispose();
                new ControllerMain(new menu_Input(), 0).Start(0);

                break;
            case btn_valencian_main:

                BLL_config.language_valencian();
                Login.dispose();
                new ControllerMain(new menu_Input(), 0).Start(0);

                break;

            case btn_ini:

                BLL_Login.collectdata();//recogemos los datos del Login
                BLL_Login.standard_login();//Comprobamos si la entrada es standard
                //Buscamos escalonadamente en cada tipo de ficheros de esta forma en caso de ser
                //Admin gastamos menos recursos

                if (singletonapp.type == 3) {

                    Login.dispose();
                    new ControllerMain(new task_Dummy_view(), 2).Start(2);

                } else if (BLL_Login.Login_Admin() == true || singletonapp.type == 0) {

                    Login.dispose();
                    new ControllerAdmin(new task_Admin_view(), 0).Start(0);

                } else if (BLL_Login.Login_Client() == true) {

                    Login.dispose();
                    new ControllerClient(new task_Client_view(), 4).Start(4);

                } else if (BLL_Login.Login_User() == true) {

                    Login.dispose();
                    new ControllerUser(new task_User_view(), 4).Start(4);

                } else {

                    menu_Input.txt_user.setColorDeBorde(Color.red);

                    menu_Input.txt_password.setColorDeBorde(Color.red);

                }

                break;

            case btnExit:

                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                        JOptionPane.INFORMATION_MESSAGE);
                Mongo_DB.disconnect();
                System.exit(0);

                break;

            case btn_Accept_Settings:

                BLL_config.Configuration_accept();
                BLL_config.auto_save_config_json();

                break;

            case btn_Load_Settings:

                BLL_config.open_config_json();

                break;

            case btn_Return_Settings:

                if (singletonapp.window.equals("Admin")) {
                    Settings.dispose();
                    new ControllerAdmin(new task_Admin_view(), 0).Start(0);
                }
                if (singletonapp.window.equals("Client")) {
                    Settings.dispose();
                    new ControllerClient(new task_Client_view(), 4).Start(4);
                }

                if (singletonapp.window.equals("User")) {
                    Settings.dispose();
                    new ControllerUser(new task_User_view(), 4).Start(4);
                }

                break;

            case btn_Save_setting:

                BLL_config.save_config_json();

                break;

            case btn_Show:

                JOptionPane.showMessageDialog(null, Classconfig.getInstance().tostring());

                break;

            case btnCreate_dummis_admin:

                BLL_Dummies.create_Dummy_admin();

                break;

            case btnDelete_all_admin:

                BLL_Dummies.Delete_all_admin_dummies();

                break;

            case btnCreate_dummis_client:

                BLL_Dummies.create_Dummy_client();

                break;

            case btnDelete_all_client:

                BLL_Dummies.Delete_all_client_dummies();

                break;

            case btnCreate_dummis_user:

                BLL_Dummies.create_Dummy_user();

                break;

            case btnDelete_all_user:

                BLL_Dummies.Delete_all_user_dummies();

                break;

            case btnEntry_admin:

                Dummies.dispose();
                new ControllerAdmin(new task_Admin_view(), 0).Start(0);

                break;

        }

    }
}
