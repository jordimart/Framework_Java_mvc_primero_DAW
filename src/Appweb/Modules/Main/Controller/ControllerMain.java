package Appweb.Modules.Main.Controller;

import Appweb.Modules.Main.Model.Config.Classes.Classconfig;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Config.Model.BLL_config.BLL_config;
import static Appweb.Modules.Main.Model.Config.Model.DAO_config.DAO_config.auto_open_config_json;
import Appweb.Modules.Main.Model.Config.View.menu_Settings;
import Appweb.Modules.Main.Model.Dummies.Model.BLL_Dummy.BLL_Dummies;
import Appweb.Modules.Main.Model.Dummies.View.task_Dummy_view;
import Appweb.Modules.Main.View.menu_Input;
import Appweb.Modules.Users.Admin.Controller.ControllerAdmin;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin;
import Appweb.Modules.Users.Admin.View.task_Admin_view;
import Appweb.Modules.Users.Client.Controller.ControllerClient;
import Appweb.Modules.Users.Client.Model.BLL_Client.BLL_Client;
import Appweb.Modules.Users.Client.View.table_Client_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
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

        //botones de cambio de menu//
        btnAdminlogin,
        btnClientlogin,
        btnUser_reglogin,
        btnTestlogin,
        btnSettings,
        btnExit,
        //botones de menu config//

        btn_Accept_Settings,
        btn_Load_Settings,
        btn_Return_Settings,
        btn_Save_setting,
        btn_Show,
        //botones de menu Dummies//

        btnCreate_dummis_admin,
        btnDelete_all_admin,
        btnEntry_admin,
        btnEntry_client,
        btnEntry_user_reg

    }

    public void Start(int i) {
        if (i == 0) {

            auto_open_config_json();
            BLL_Admin.auto_open_json_admin();
            BLL_Client.auto_open_json_client();

            Login.setVisible(true);
            Login.setTitle("Menu Login ");
            Login.setLocationRelativeTo(null);
            Login.setSize(1000, 650);//ancho x alto
            Login.setExtendedState(JFrame.MAXIMIZED_BOTH);

            Login.Login_Admin.setActionCommand("btnAdminlogin");
            Login.Login_Admin.addActionListener(this);

            Login.btnSettings.setActionCommand("btnSettings");
            Login.btnSettings.addActionListener(this);

            Login.btn_Test.setActionCommand("btnTestlogin");
            Login.btn_Test.addActionListener(this);

            Login.Login_Client.setActionCommand("btnClientlogin");
            Login.Login_Client.addActionListener(this);

            Login.Login_User_reg.setActionCommand("btnUser_reglogin");
            Login.Login_User_reg.addActionListener(this);

            Login.btn_Exit.setActionCommand("btnExit");
            Login.btn_Exit.addActionListener(this);

            Login.btn_English_main.setActionCommand("btnLanguage_English");
            Login.btn_English_main.addActionListener(this);

            // Login.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Login.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                            JOptionPane.INFORMATION_MESSAGE);

                    System.exit(0);
                }
            });
        }
        if (i == 1) {

            Settings.setVisible(true);
            Settings.setTitle("Menu Settings");
            Settings.setLocationRelativeTo(null);
            Settings.setSize(980, 800);//ancho x alto
            Settings.setResizable(false);
            Settings.chk_day_bar.setSelected(true);
            Settings.chk_one_d.setSelected(true);
            Settings.chk_curr_euro.setSelected(true);
            Settings.chk_lang_en.setSelected(true);

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

            Dummies.setVisible(true);
            Dummies.setTitle("Menu Test");
            Dummies.setLocationRelativeTo(null);
            Dummies.setSize(1000, 650);//ancho x alto
            //this.setResizable(false);
            Dummies.setExtendedState(JFrame.MAXIMIZED_BOTH);

            Dummies.btnCreate_dummis_admin.setActionCommand("btnCreate_dummis_admin");
            Dummies.btnCreate_dummis_admin.addActionListener(this);

            Dummies.btnDelete_all_admin.setActionCommand("btnDelete_all_admin");
            Dummies.btnDelete_all_admin.addActionListener(this);

            Dummies.btnEntry_admin.setActionCommand("btnEntry_admin");
            Dummies.btnEntry_admin.addActionListener(this);

            Dummies.btnEntry_client.setActionCommand("btnEntry_client");
            Dummies.btnEntry_client.addActionListener(this);

            Dummies.btnEntry_user_reg.setActionCommand("btnEntry_user_reg");
            Dummies.btnEntry_user_reg.addActionListener(this);

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
            case btnExit:

                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                        JOptionPane.INFORMATION_MESSAGE);

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

                Settings.dispose();
                new ControllerMain(new menu_Input(), 0).Start(0);

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
            case btnEntry_admin:

                Dummies.dispose();
                new ControllerAdmin(new task_Admin_view(), 0).Start(0);

                break;
            case btnEntry_client:

                break;
            case btnEntry_user_reg:

                break;
        }

    }
}
