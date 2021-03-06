package Appweb.Modules.Users.User_reg.Controller;

import Appweb.Classes.Mongo_DB;
import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.Controller.ControllerMain;
import Appweb.Modules.Main.Model.Config.Classes.Classconfig;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Config.View.menu_Settings;
import Appweb.Modules.Main.Model.Login.View.menu_Input;
import Appweb.Modules.Users.Admin.Controller.ControllerAdmin;
import static Appweb.Modules.Users.Admin.Model.Classes.Table_Admin_class.datos;
import Appweb.Modules.Users.Admin.View.task_Admin_view;
import static Appweb.Modules.Users.User_reg.Controller.ControllerUser.Table_User;
import Appweb.Modules.Users.User_reg.Model.BLL_User.BLL_User;
import Appweb.Modules.Users.User_reg.Model.BLL_User.BLL_User_file;
import Appweb.Modules.Users.User_reg.Model.Classes.Table_User_reg;
import Appweb.Modules.Users.User_reg.Model.Classes.singleuser_reg;
import Appweb.Modules.Users.User_reg.Model.DAO_User.DAO_User;
import Appweb.Modules.Users.User_reg.Model.Tools.Pager.pagina_user;
import Appweb.Modules.Users.User_reg.Model.Tools.autocomplete.AutocompleteJComboBox_user;
import Appweb.Modules.Users.User_reg.Model.Tools.autocomplete.StringSearchable_user;
import Appweb.Modules.Users.User_reg.View.create_User_view;
import Appweb.Modules.Users.User_reg.View.edit_User_view;
import Appweb.Modules.Users.User_reg.View.show_User_view;
import Appweb.Modules.Users.User_reg.View.table_User_view;
import static Appweb.Modules.Users.User_reg.View.table_User_view.jComboBox1;
import static Appweb.Modules.Users.User_reg.View.table_User_view.mini_Table_User;
import Appweb.Modules.Users.User_reg.View.task_User_view;
import java.awt.AWTKeyStroke;
import java.awt.Color;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class ControllerUser implements ActionListener, MouseListener, PropertyChangeListener, KeyListener {

    public static table_User_view Table_User;
    public static create_User_view Create_User;
    public static edit_User_view Edit_User;
    public static show_User_view Show_User;
    public static task_User_view Task_User;

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<>(new Table_User_reg());
    public static AutocompleteJComboBox_user combo = null;
    public static JTable tabla = null;

    public ControllerUser(JFrame start, int i) {

        if (i == 0) {
            Table_User = (table_User_view) start;
        }
        if (i == 1) {
            Create_User = (create_User_view) start;
        }
        if (i == 2) {
            Edit_User = (edit_User_view) start;
        }
        if (i == 3) {
            Show_User = (show_User_view) start;
        }
        if (i == 4) {
            Task_User = (task_User_view) start;
        }
    }

    public enum Action_User {

        //botones table User registered//
        btnAdd,
        btnEditar,
        btnBorrar,
        btnMostrar,
        btn_delete_all,
        btn_Return_table,
        btn_Save_file,
        ANTERIOR,
        SIGUIENTE,
        primero,
        ultimo,
        jComboBox1,//combo filtrar
        Tabla_pager,//mouseclicked
        btnchange_user,
        //botones create User registered//

        btn_Aceptar,
        btn_Cancel_a,
        btnAvatar,
        pick_date_birth,
        txtActivity,
        txtDni,
        txtEmail,
        txtLast_name,
        txtMobile,
        txtName,
        txtPassword,
        txtUser,
        //botones edit User registered//

        btn_Aceptar_e,
        btn_cancelar_e,
        btnAvatar_e,
        pick_date_birth_e,
        txtActivity_e,
        txtEmail_e,
        txtLast_name_e,
        txtMobile_e,
        txtName_e,
        txtPassword_e,
        txtUser_e,
        //botones Mostrar//

        btnAccept_s,
        //botones task//

        btn_exit,
        btn_modifytask,
        btn_showtask,
        btn_configtask,
        btn_log_out,

    }

    public void Start(int i) {

        if (i == 0) {

            Table_User.setVisible(true);

            Table_User.setTitle("Table User registered");
            Table_User.setLocationRelativeTo(null);
            Table_User.setSize(1700, 1000);//ancho x alto
            Table_User.setResizable(true);
            Table_User.setExtendedState(JFrame.MAXIMIZED_BOTH);

            Table_User.mini_Table_User.setModel(new Table_User_reg());
            ((Table_User_reg) mini_Table_User.getModel()).cargar();
            table_User_view.jLabel3.setText(String.valueOf(datos.size()));
            Table_User.mini_Table_User.setFillsViewportHeight(true);
            Table_User.mini_Table_User.setRowSorter(sorter);

            pagina_user.inicializa();
            pagina_user.initLinkBox();

            Table_User.jLabel3.setText(String.valueOf(singleuser_reg.User_reg_array.size()));

            this.Table_User.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Table_User.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Table_User.dispose();
                    new ControllerUser(new menu_Input(), 0).Start(0);

                }
            });

            List<String> myWords = new ArrayList<String>();

            for (int j = 0; j <= singleuser_reg.User_reg_array.size() - 1; j++) {
                myWords.add(singleuser_reg.User_reg_array.get(j).getName().toLowerCase());
                myWords.add(singleuser_reg.User_reg_array.get(j).getName().toUpperCase());
            }

            StringSearchable_user searchable = new StringSearchable_user(myWords);
            this.combo = new AutocompleteJComboBox_user(searchable);
            Table_User.jPanel3.setLayout(new java.awt.BorderLayout());
            Table_User.jPanel3.add(combo);

            combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }

            });

            Table_User.btnAdd_user.setActionCommand("btnAdd");
            Table_User.btnAdd_user.addActionListener((ActionListener) this);

            Table_User.btnEditar_user.setActionCommand("btnEditar");
            Table_User.btnEditar_user.addActionListener(this);

            Table_User.btnBorrar_user.setActionCommand("btnBorrar");
            Table_User.btnBorrar_user.addActionListener(this);

            Table_User.btnMostrar_user.setActionCommand("btnMostrar");
            Table_User.btnMostrar_user.addActionListener(this);

            Table_User.btn_delete_all.setActionCommand("btn_delete_all");
            Table_User.btn_delete_all.addActionListener(this);

            Table_User.btn_Return.setActionCommand("btn_Return_table");
            Table_User.btn_Return.addActionListener(this);

            Table_User.btn_Save_file.setActionCommand("btn_Save_file");
            Table_User.btn_Save_file.addActionListener(this);

            Table_User.ANTERIOR.setActionCommand("ANTERIOR");
            Table_User.ANTERIOR.addActionListener(this);

            Table_User.SIGUIENTE.setActionCommand("SIGUIENTE");
            Table_User.SIGUIENTE.addActionListener(this);

            Table_User.primero.setActionCommand("primero");
            Table_User.primero.addActionListener(this);

            Table_User.ultimo.setActionCommand("ultimo");
            Table_User.ultimo.addActionListener(this);

            Table_User.jComboBox1.setActionCommand("jComboBox1");
            Table_User.jComboBox1.addActionListener(this);

            Table_User.mini_Table_User.setName("Tabla_pager");
            Table_User.mini_Table_User.addMouseListener(this);

            Table_User.btnchange_user.setActionCommand("btnchange_user");
            Table_User.btnchange_user.addActionListener(this);
        }

        if (i == 1) {

            Create_User.setVisible(true);
            Create_User.setTitle("Create User registered");
            Create_User.setLocationRelativeTo(null);
            Create_User.setSize(950, 950);//ancho x alto
            Create_User.setResizable(false);

            //Information_dialog.setLocationRelativeTo(null);
            //Information_dialog.setTitle("Information");
            //Information_dialog.setSize(1000, 200);
            //Information_dialog.setModal(true);
            //Information_dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            Create_User.pick_date_birth.getDateEditor().setEnabled(false);
            Create_User.pick_date_birth.setDateFormatString(Classconfig.getInstance().getdatef());

            // Conjunto de teclas que queremos que sirvan para pasar el foco 
            // al siguiente campo de texto: ENTER y TAB
            Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
            teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
            teclas.add(AWTKeyStroke.getAWTKeyStroke(
                    KeyEvent.VK_TAB, 0));

            // Se pasa el conjunto de teclas al panel principal 
            Create_User.panelRect1.setFocusTraversalKeys(
                    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                    teclas);

            this.Create_User.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Create_User.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Create_User.dispose();
                    new ControllerUser(new table_User_view(), 0).Start(0);

                }
            });

            Create_User.btn_Aceptar.setActionCommand("btn_Aceptar");
            Create_User.btn_Aceptar.addActionListener(this);

            Create_User.btn_Cancel.setActionCommand("btn_Cancel_a");
            Create_User.btn_Cancel.addActionListener(this);

            Create_User.btnAvatar.setActionCommand("btnAvatar");
            Create_User.btnAvatar.addActionListener(this);

            Create_User.txtDni.setActionCommand("txtDni");
            Create_User.txtDni.setName("txtDni");
            Create_User.txtDni.addActionListener(this);
            Create_User.txtDni.addKeyListener(this);

            Create_User.txtActivity.setActionCommand("txtActivity");
            Create_User.txtActivity.setName("txtActivity");
            Create_User.txtActivity.addActionListener(this);
            Create_User.txtActivity.addKeyListener(this);

            Create_User.txtEmail.setActionCommand("txtEmail");
            Create_User.txtEmail.setName("txtEmail");
            Create_User.txtEmail.addActionListener(this);
            Create_User.txtEmail.addKeyListener(this);

            Create_User.txtLast_name.setActionCommand("txtLast_name");
            Create_User.txtLast_name.setName("txtLast_name");
            Create_User.txtLast_name.addActionListener(this);
            Create_User.txtLast_name.addKeyListener(this);

            Create_User.txtMobile.setActionCommand("txtMobile");
            Create_User.txtMobile.setName("txtMobile");
            Create_User.txtMobile.addActionListener(this);
            Create_User.txtMobile.addKeyListener(this);

            Create_User.txtName.setActionCommand("txtName");
            Create_User.txtName.setName("txtName");
            Create_User.txtName.addActionListener(this);
            Create_User.txtName.addKeyListener(this);

            Create_User.txtPassword.setActionCommand("txtPassword");
            Create_User.txtPassword.setName("txtPassword");
            Create_User.txtPassword.addActionListener(this);
            Create_User.txtPassword.addKeyListener(this);

            Create_User.txtUser.setActionCommand("txtUser");
            Create_User.txtUser.setName("txtUser");
            Create_User.txtUser.addActionListener(this);
            Create_User.txtUser.addKeyListener(this);

        }

        if (i == 2) {

            Edit_User.setTitle("Edit User registered");
            Edit_User.setLocationRelativeTo(null);
            Edit_User.setSize(950, 950);//ancho x alto
            Edit_User.setResizable(false);
            Edit_User.setBackground(Color.GRAY);
            Edit_User.pick_date_birth.getDateEditor().setEnabled(false);
            Edit_User.pick_date_birth.setDateFormatString(Classconfig.getInstance().getdatef());

            Edit_User.setVisible(true);

            // Conjunto de teclas que queremos que sirvan para pasar el foco 
            // al siguiente campo de texto: ENTER y TAB
            Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
            teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
            teclas.add(AWTKeyStroke.getAWTKeyStroke(
                    KeyEvent.VK_TAB, 0));

            Edit_User.panelRect1.setFocusTraversalKeys(
                    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                    teclas);

            this.Edit_User.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Edit_User.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {

                    if (singletonapp.window.equals("Admin")) {
                        //si es un Admin vuelve al table.
                        Edit_User.dispose();
                        new ControllerUser(new table_User_view(), 0).Start(0);
                    } else {
                        //Si es un client salede la aplicacion
                        JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                                JOptionPane.INFORMATION_MESSAGE);
                        Mongo_DB.disconnect();
                        System.exit(0);
                    }
                }
            });

            Edit_User.btn_Aceptar.setActionCommand("btn_Aceptar_e");
            Edit_User.btn_Aceptar.addActionListener(this);

            Edit_User.btn_Cancelar.setActionCommand("btn_cancelar_e");
            Edit_User.btn_Cancelar.addActionListener(this);

            Edit_User.btnAvatar.setActionCommand("btnAvatar_e");
            Edit_User.btnAvatar.addActionListener(this);

            Edit_User.txtActivity.setActionCommand("txtActivity_e");
            Edit_User.txtActivity.setName("txtActivity_e");
            Edit_User.txtActivity.addActionListener(this);
            Edit_User.txtActivity.addKeyListener(this);

            Edit_User.txtEmail.setActionCommand("txtEmail_e");
            Edit_User.txtEmail.setName("txtEmail_e");
            Edit_User.txtEmail.addActionListener(this);
            Edit_User.txtEmail.addKeyListener(this);

            Edit_User.txtLast_name.setActionCommand("txtLast_name_e");
            Edit_User.txtLast_name.setName("txtLast_name_e");
            Edit_User.txtLast_name.addActionListener(this);
            Edit_User.txtLast_name.addKeyListener(this);

            Edit_User.txtMobile.setActionCommand("txtMobile_e");
            Edit_User.txtMobile.setName("txtMobile_e");
            Edit_User.txtMobile.addActionListener(this);
            Edit_User.txtMobile.addKeyListener(this);

            Edit_User.txtName.setActionCommand("txtName_e");
            Edit_User.txtName.setName("txtName_e");
            Edit_User.txtName.addActionListener(this);
            Edit_User.txtName.addKeyListener(this);

            Edit_User.txtPassword.setActionCommand("txtPassword_e");
            Edit_User.txtPassword.setName("txtPassword_e");
            Edit_User.txtPassword.addActionListener(this);
            Edit_User.txtPassword.addKeyListener(this);

            Edit_User.txtUser.setActionCommand("txtUser_e");
            Edit_User.txtUser.setName("txtUser_e");
            Edit_User.txtUser.addActionListener(this);
            Edit_User.txtUser.addKeyListener(this);
        }

        if (i == 3) {

            Show_User.setTitle("User registered data");
            Show_User.setLocationRelativeTo(null);
            Show_User.setSize(1000, 650);//ancho x alto
            Show_User.setResizable(false);
            Show_User.setVisible(true);

            this.Show_User.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Show_User.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    if (singletonapp.window.equals("Admin")) {
                        //si es un Admin vuelve al table.
                        Show_User.dispose();
                        new ControllerUser(new table_User_view(), 0).Start(0);
                    } else {
                        //Si es un client salede la aplicacion
                        JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                                JOptionPane.INFORMATION_MESSAGE);
                        Mongo_DB.disconnect();
                        System.exit(0);
                    }
                }
            });

            Show_User.btnAcept.setActionCommand("btnAccept_s");
            Show_User.btnAcept.addActionListener(this);
        }

        if (i == 4) {

            Task_User.setVisible(true);
            Task_User.setTitle("Task User registered");
            Task_User.setLocationRelativeTo(null);
            Task_User.setSize(1600, 1100);//ancho x alto
            Task_User.setResizable(false);
            Task_User.setExtendedState(JFrame.MAXIMIZED_BOTH);

            Task_User.btn_show.setText(Lang.getInstance().getProperty("MY_PROFILE"));
            Task_User.btn_modify.setText(Lang.getInstance().getProperty("MODIFY_MY_PROFILE"));
            Task_User.btn_config.setText(Lang.getInstance().getProperty("CONFIGURATION"));
            Task_User.btn_Exit.setText(Lang.getInstance().getProperty("EXIT"));

            singletonapp.window = "User";
            Task_User.lab_username.setText(Lang.getInstance().getProperty("WELCOME") + ": " + singleuser_reg.User_reg_array.get(singletonapp.pos).getUser());

            this.Task_User.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Task_User.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                            JOptionPane.INFORMATION_MESSAGE);
                    Mongo_DB.disconnect();
                    System.exit(0);
                }
            });

            Task_User.btn_show.setActionCommand("btn_showtask");
            Task_User.btn_show.addActionListener(this);

            Task_User.btn_modify.setActionCommand("btn_modifytask");
            Task_User.btn_modify.addActionListener(this);

            Task_User.btn_config.setActionCommand("btn_configtask");
            Task_User.btn_config.addActionListener(this);

            Task_User.btn_Exit.setActionCommand("btn_exit");
            Task_User.btn_Exit.addActionListener(this);

            Task_User.btn_log_out.setActionCommand("btn_log_out");
            Task_User.btn_log_out.addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent ae) {

        boolean ok = false;
        switch (Action_User.valueOf(ae.getActionCommand())) {

            case btnAdd:

                Table_User.dispose();
                new ControllerUser(new create_User_view(), 1).Start(1);

                break;
            case btnEditar:

                ok = BLL_User.modifity_select();
                if (true == ok) {

                    Table_User.dispose();
                }

                break;
            case btnBorrar:

                BLL_User.delete_select();
                break;

            case btnchange_user:

                BLL_User.change_table_user();
                break;
            case btnMostrar:

                BLL_User.show_select();

                break;
            case btn_delete_all:

                BLL_User.Delete_all();
                break;
            case btn_Return_table:

                Table_User.dispose();
                new ControllerAdmin(new task_Admin_view(), 0).Start(0);

                break;

            case btn_Save_file:

                if (Table_User.combo_file.getSelectedItem().equals("Json")) {
                    BLL_User_file.save_json();
                }
                if (Table_User.combo_file.getSelectedItem().equals("Xml")) {
                    BLL_User_file.save_xml();
                }
                if (Table_User.combo_file.getSelectedItem().equals("Txt")) {
                    BLL_User_file.save_txt();
                }

                break;

            case ANTERIOR:
                pagina_user.currentPageIndex -= 1;
                pagina_user.initLinkBox();
                break;
            case SIGUIENTE:
                pagina_user.currentPageIndex += 1;
                pagina_user.initLinkBox();
                break;
            case primero:
                pagina_user.currentPageIndex = 1;
                pagina_user.initLinkBox();
                break;
            case ultimo:
                pagina_user.currentPageIndex = pagina_user.maxPageIndex;
                pagina_user.initLinkBox();
                break;
            case jComboBox1:

                pagina_user.itemsPerPage = Integer.parseInt(jComboBox1.getSelectedItem().toString());
                pagina_user.currentPageIndex = 1;
                pagina_user.initLinkBox();

                break;
            case btn_Aceptar:

                ok = BLL_User.Enter_new();

                if (ok == true) {

                    Create_User.dispose();
                    new ControllerUser(new table_User_view(), 0).Start(0);

                    ((Table_User_reg) mini_Table_User.getModel()).cargar();
                }
                break;

            case btn_Cancel_a:

                Create_User.dispose();
                new ControllerUser(new table_User_view(), 0).Start(0);

                break;
            case btnAvatar:

                BLL_User.EnterAvatar();

                break;
            case btn_Aceptar_e:

                ok = BLL_User.Enter_edited();
                if ((ok == true) && (singletonapp.window.equals("Admin"))) {
                    Edit_User.dispose();
                    new ControllerUser(new table_User_view(), 0).Start(0);

                } else if ((ok == true) && (singletonapp.window.equals("User"))) {
                    Edit_User.dispose();
                    new ControllerUser(new task_User_view(), 4).Start(4);

                }

                break;
            case btn_cancelar_e:

                if (singletonapp.window.equals("Admin")) {
                    Edit_User.dispose();
                    new ControllerUser(new table_User_view(), 0).Start(0);
                } else if (singletonapp.window.equals("User")) {
                    Edit_User.dispose();
                    new ControllerUser(new task_User_view(), 4).Start(4);

                }
                break;
            case btnAvatar_e:

                BLL_User.EditAvatar();

                break;
            case btnAccept_s:

                if (singletonapp.window.equals("Admin")) {
                    Show_User.dispose();
                    new ControllerUser(new table_User_view(), 0).Start(0);
                } else if (singletonapp.window.equals("User")) {
                    Show_User.dispose();
                    new ControllerUser(new task_User_view(), 4).Start(4);

                }

                break;
            case btn_showtask:

                Task_User.dispose();
                new ControllerUser(new show_User_view(), 3).Start(3);
                DAO_User.Load_show();

                break;

            case btn_modifytask:

                Task_User.dispose();
                new ControllerUser(new edit_User_view(), 2).Start(2);
                DAO_User.Load_edit_user();

                break;

            case btn_configtask:

                Task_User.dispose();
                new ControllerMain(new menu_Settings(), 1).Start(1);

                break;

            case btn_exit:

                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                        JOptionPane.INFORMATION_MESSAGE);
                Mongo_DB.disconnect();
                System.exit(0);

                break;
            case btn_log_out:

                Task_User.dispose();
                new ControllerMain(new menu_Input(), 0).Start(0);

                break;
        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        BLL_User.Enterdate_birth();

        BLL_User.Editdate_birth();

    }

    @Override
    public void keyPressed(KeyEvent es) {

        switch (Action_User.valueOf(es.getComponent().getName())) {

            case txtDni:
                // BLL_Admin.Enterdni_admin();
                break;
            case txtEmail:
                // BLL_Admin.Entermail_admin();
                break;
            case txtLast_name:
                // BLL_Admin.Enterlast_name_admin();
                break;
            case txtMobile:
                // BLL_Admin.Entermobile_admin();
                break;
            case txtName:
                // BLL_Admin.Entername_admin();
                break;
            case txtPassword:
                //BLL_Admin.Enterpassword_admin();
                break;

            case txtUser:
                // BLL_Admin.Enteruser_admin();
                break;
            case txtActivity:
                // BLL_Admin.Enteractivity_admin();
                break;
            case txtActivity_e:
                // BLL_Admin.Editactivity_admin();
                break;
            case txtEmail_e:
                // BLL_Admin.Editmail_admin();
                break;
            case txtLast_name_e:
                // BLL_Admin.Editlast_name_admin();
                break;
            case txtMobile_e:
                // BLL_Admin.Editmobile_admin();
                break;
            case txtName_e:
                //BLL_Admin.Editname_admin();
                break;
            case txtPassword_e:
                // BLL_Admin.Editpassword_admin();
                break;

            case txtUser_e:
                // BLL_Admin.Edituser_admin();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (Action_User.valueOf(e.getComponent().getName())) {

            case txtDni:
                BLL_User.Enterdni();
                break;
            case txtEmail:
                BLL_User.Entermail();
                break;
            case txtLast_name:
                BLL_User.Enterlast_name();
                break;
            case txtMobile:
                BLL_User.Entermobile();
                break;
            case txtName:
                BLL_User.Entername();
                break;
            case txtPassword:
                BLL_User.Enterpassword();
                break;

            case txtUser:
                BLL_User.Enteruser();
                break;
            case txtActivity:
                BLL_User.Enteractivity();
                break;
            case txtActivity_e:
                BLL_User.Editactivity();
                break;
            case txtEmail_e:
                BLL_User.Editmail();
                break;
            case txtLast_name_e:
                BLL_User.Editlast_name();
                break;
            case txtMobile_e:
                BLL_User.Editmobile();
                break;
            case txtName_e:
                BLL_User.Editname();
                break;
            case txtPassword_e:
                BLL_User.Editpassword();
                break;

            case txtUser_e:
                BLL_User.Edituser();
                break;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        switch (Action_User.valueOf(e.getComponent().getName())) {

            case Tabla_pager:

                if (e.getClickCount() == 2) {
                    BLL_User.modifity_select();
                }
                break;

        }
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("word selected: " + ((JComboBox) combo).getSelectedItem());
        pagina_user.currentPageIndex = 1;
        pagina_user.initLinkBox();
        ((Table_User_reg) mini_Table_User.getModel()).filtrar();
        combo.requestFocus();
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

}
