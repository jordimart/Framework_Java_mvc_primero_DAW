package Appweb.Modules.Users.Admin.Controller;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.Controller.ControllerMain;
import Appweb.Modules.Main.Model.Config.Classes.Classconfig;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Config.Model.BLL_config.BLL_config;
import Appweb.Modules.Main.Model.Config.View.menu_Settings;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_curr_euro;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_day_bar;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_lang_en;
import static Appweb.Modules.Main.Model.Config.View.menu_Settings.chk_one_d;
import Appweb.Modules.Main.Model.Dummies.Model.BLL_Dummy.BLL_Dummies;
import Appweb.Modules.Main.Model.Dummies.View.task_Dummy_view;
import Appweb.Modules.Main.View.menu_Input;
import Appweb.Modules.Users.Admin.Model.Classes.Table_Admin;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import Appweb.Modules.Users.Admin.Model.Tools.Pager.pagina;
import Appweb.Modules.Users.Admin.Model.Tools.autocomplete.AutocompleteJComboBox;
import Appweb.Modules.Users.Admin.Model.Tools.autocomplete.StringSearchable;
import Appweb.Modules.Users.Admin.View.create_Admin_view;
import Appweb.Modules.Users.Admin.View.edit_Admin_view;
import Appweb.Modules.Users.Admin.View.show_Admin_view;
import Appweb.Modules.Users.Admin.View.table_Admin_view;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.combo;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.comboActionPerformed;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.jLabel3;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.jPanel3;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.mini_Table_Admin;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.sorter;
import Appweb.Modules.Users.Admin.View.task_Admin_view;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jorge
 */
public class ControllerAdmin implements ActionListener, FocusListener, KeyListener, MouseListener {

    public static task_Admin_view Task_Admin = new task_Admin_view();
    public static table_Admin_view Table_Admin = new table_Admin_view();
    public static create_Admin_view Create_Admin = new create_Admin_view();
    public static edit_Admin_view Edit_Admin = new edit_Admin_view();
    public static show_Admin_view Show_Admin = new show_Admin_view();

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new Table_Admin());
    public static AutocompleteJComboBox combo = null;
    public static JTable tabla = null;

    public ControllerAdmin(JFrame start, int i) {

        if (i == 0) {
            Task_Admin = (task_Admin_view) start;
        }
        if (i == 1) {
            Table_Admin = (table_Admin_view) start;
        }
        if (i == 2) {
            Create_Admin = (create_Admin_view) start;
        }
        if (i == 3) {
            Edit_Admin = (edit_Admin_view) start;
        }
        if (i == 4) {
            Show_Admin = (show_Admin_view) start;
        }
    }

    public enum Action_Admin {

        //botones de Task_Admin//
        btn_Config,
        btn_Volver,
        btn_ges_users,
        btn_ges_inst,
        btn_ges_averias,
        //botones table Admin//

        btnAdd_admin,
        btnEditar_admin,
        btnBorrar_admin,
        btnMostrar_admin,
        btn_delete_all,
        btn_Volver_table,
        ANTERIOR,
        SIGUIENTE,
        primero,
        ultimo,
        jComboBox1,//combo filtrar
        mini_Table_Admin,
        //botones de menu Dummies//

        btnCreate_dummis_admin,
        btnDelete_all_admin,
        btnEntry_admin,
        btnEntry_client,
        btnEntry_user_reg

    }

    public void Start(int i) {
        if (i == 0) {

            Task_Admin.setTitle(Lang.getInstance().getProperty("Task Admin"));
            Task_Admin.setLocationRelativeTo(null);
            Task_Admin.setSize(1000, 650);//ancho x alto
            // this.setResizable(false);
            Task_Admin.setExtendedState(JFrame.MAXIMIZED_BOTH);

            Task_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Task_Admin.dispose();
                    new ControllerMain(new menu_Input(), 0).Start(0);

                }
            });

            Task_Admin.btn_Config.setActionCommand("btn_Config");
            Task_Admin.btn_Config.addActionListener(this);

            Task_Admin.btn_Volver.setActionCommand("btn_Volver");
            Task_Admin.btn_Volver.addActionListener(this);

            Task_Admin.btn_ges_users.setActionCommand("btn_ges_users");
            Task_Admin.btn_ges_users.addActionListener(this);

            Task_Admin.btn_ges_inst.setActionCommand("btn_ges_inst");
            Task_Admin.btn_ges_inst.addActionListener(this);

            Task_Admin.btn_ges_averias.setActionCommand("btn_ges_averias");
            Task_Admin.btn_ges_averias.addActionListener(this);

        }
        if (i == 1) {

            Table_Admin.setTitle("Table Admin");
            Table_Admin.setLocationRelativeTo(null);
            Table_Admin.setSize(1000, 650);//ancho x alto
            Table_Admin.setResizable(true);
            Table_Admin.setExtendedState(JFrame.MAXIMIZED_BOTH);

            singletonapp.singleton_vtna = "Admin";

            mini_Table_Admin.setModel(new Table_Admin());
            ((Table_Admin) mini_Table_Admin.getModel()).cargar();
            mini_Table_Admin.setFillsViewportHeight(true);
            mini_Table_Admin.setRowSorter(sorter);

            pagina.inicializa();
            pagina.initLinkBox();

            jLabel3.setText(String.valueOf(singleadmin.Admin_array.size()));

            Table_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Table_Admin.dispose();
                    task_Admin_view menu = new task_Admin_view();
                    menu.setVisible(true);

                }
            });

            List<String> myWords = new ArrayList<String>();
            for (int j = 0; j <= singleadmin.Admin_array.size() - 1; j++) {
                myWords.add(singleadmin.Admin_array.get(j).getName().toLowerCase());
                myWords.add(singleadmin.Admin_array.get(j).getName().toUpperCase());
            }

            StringSearchable searchable = new StringSearchable(myWords);
            combo = new AutocompleteJComboBox(searchable);

            jPanel3.setLayout(new java.awt.BorderLayout());
            jPanel3.add(combo);

            combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }

            });
        }

        if (i == 2) {

            Dummies.setTitle("Menu Login");
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

            Dummies.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    new ControllerMain(new menu_Input(), 0).Start(0);

                    Dummies.dispose();

                }
            });
        }
    }

    public void actionPerformed(ActionEvent ae) {
        switch (Action_menu.valueOf(ae.getActionCommand())) {

            case btnAdminlogin:

                break;
            case btnUser_reglogin:

                break;
            case btnTestlogin:

                break;
            case btnSettings:

                new ControllerMain(new menu_Settings(), 1).Start(1);

                Login.dispose();

                break;
            case btnExit:
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
                new ControllerMain(new menu_Input(), 0).Start(0);//abrimos ventana 

                Settings.dispose();
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
                task_Admin_view menu = new task_Admin_view();
                menu.setVisible(true);

                break;
            case btnEntry_client:

                break;
            case btnEntry_user_reg:

                break;
        }

    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("word selected: " + ((JComboBox) combo).getSelectedItem());
        pagina.currentPageIndex = 1;
        ((Table_Admin) mini_Table_Admin.getModel()).filtrar();
        combo.requestFocus();
    }
}
