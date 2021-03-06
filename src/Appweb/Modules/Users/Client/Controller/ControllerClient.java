package Appweb.Modules.Users.Client.Controller;

import Appweb.Classes.Mongo_DB;
import Appweb.General_tools.singletonapp;
import static Appweb.General_tools.singletonapp.singleactiondate;
import Appweb.Modules.Main.Controller.ControllerMain;
import Appweb.Modules.Main.Model.Config.Classes.Classconfig;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Config.View.menu_Settings;
import Appweb.Modules.Main.Model.Login.View.menu_Input;
import Appweb.Modules.Users.Admin.Controller.ControllerAdmin;
import Appweb.Modules.Users.Admin.View.task_Admin_view;
import static Appweb.Modules.Users.Client.Controller.ControllerClient.Table_Client;
import Appweb.Modules.Users.Client.Model.BLL_Client.BLL_Client;
import Appweb.Modules.Users.Client.Model.Classes.Table_Client_class;
import static Appweb.Modules.Users.Client.Model.Classes.Table_Client_class.datos;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;
import Appweb.Modules.Users.Client.Model.DAO_Client.DAO_Client;
import Appweb.Modules.Users.Client.Model.Tools.Pager.pagina_client;
import Appweb.Modules.Users.Client.Model.Tools.autocomplete.AutocompleteJComboBox_client;
import Appweb.Modules.Users.Client.Model.Tools.autocomplete.StringSearchable_client;
import Appweb.Modules.Users.Client.View.create_Client_view;
import Appweb.Modules.Users.Client.View.edit_Client_view;
import Appweb.Modules.Users.Client.View.show_Client_view;
import Appweb.Modules.Users.Client.View.table_Client_view;
import static Appweb.Modules.Users.Client.View.table_Client_view.jComboBox1;
import static Appweb.Modules.Users.Client.View.table_Client_view.mini_Table_Client;
import Appweb.Modules.Users.Client.View.task_Client_view;
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
public class ControllerClient implements ActionListener, MouseListener, PropertyChangeListener, KeyListener {

    public static table_Client_view Table_Client;
    public static create_Client_view Create_Client;
    public static edit_Client_view Edit_Client;
    public static show_Client_view Show_Client;
    public static task_Client_view Task_Client;

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<>(new Table_Client_class());
    public static AutocompleteJComboBox_client combo = null;
    public static JTable tabla = null;

    public ControllerClient(JFrame start, int i) {

        if (i == 0) {
            Table_Client = (table_Client_view) start;
        }
        if (i == 1) {
            Create_Client = (create_Client_view) start;
        }
        if (i == 2) {
            Edit_Client = (edit_Client_view) start;
        }
        if (i == 3) {
            Show_Client = (show_Client_view) start;
        }
        if (i == 4) {
            Task_Client = (task_Client_view) start;
        }
    }

    public enum Action_Client {

        //botones table Client//
        btnAdd_client,
        btnEditar_client,
        btnBorrar_client,
        btnMostrar_client,
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
        //botones create Admin//

        btn_Aceptar,
        btn_Cancel_a,
        btnAvatar,
        pick_date_birth,
        pick_date_contr,
        txtDni,
        txtEmail,
        txtLast_name,
        txtMobile,
        txtName,
        txtPassword,
        txtPurchase,
        txtUser,
        //botones edit Client//

        btn_Aceptar_e,
        btn_cancelar_e,
        btnAvatar_e,
        pick_date_birth_e,
        pick_date_contr_e,
        txtEmail_e,
        txtLast_name_e,
        txtMobile_e,
        txtName_e,
        txtPassword_e,
        txtPurchase_e,
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

            Table_Client.setVisible(true);

            Table_Client.setTitle("Table Client");
            Table_Client.setLocationRelativeTo(null);
            Table_Client.setSize(1700, 1000);//ancho x alto
            Table_Client.setResizable(true);
            Table_Client.setExtendedState(JFrame.MAXIMIZED_BOTH);

            Table_Client.mini_Table_Client.setModel(new Table_Client_class());
            ((Table_Client_class) mini_Table_Client.getModel()).cargar();
            table_Client_view.jLabel3.setText(String.valueOf(datos.size()));
            Table_Client.mini_Table_Client.setFillsViewportHeight(true);
            Table_Client.mini_Table_Client.setRowSorter(sorter);

            pagina_client.inicializa();
            pagina_client.initLinkBox();

            Table_Client.jLabel3.setText(String.valueOf(singleclient.Client_array.size()));

            this.Table_Client.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Table_Client.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Table_Client.dispose();

                    new ControllerMain(new menu_Input(), 0).Start(0);

                }
            });

            List<String> myWords = new ArrayList<String>();

            for (int j = 0; j <= singleclient.Client_array.size() - 1; j++) {
                myWords.add(singleclient.Client_array.get(j).getName().toLowerCase());
                myWords.add(singleclient.Client_array.get(j).getName().toUpperCase());
            }

            StringSearchable_client searchable = new StringSearchable_client(myWords);

            combo = new AutocompleteJComboBox_client(searchable);
            Table_Client.jPanel3.setLayout(new java.awt.BorderLayout());
            Table_Client.jPanel3.add(combo);

            combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }

            });

            Table_Client.btnAdd_client.setActionCommand("btnAdd_client");
            Table_Client.btnAdd_client.addActionListener(this);

            Table_Client.btnEditar_client.setActionCommand("btnEditar_client");
            Table_Client.btnEditar_client.addActionListener(this);

            Table_Client.btnBorrar_client.setActionCommand("btnBorrar_client");
            Table_Client.btnBorrar_client.addActionListener(this);

            Table_Client.btnMostrar_client.setActionCommand("btnMostrar_client");
            Table_Client.btnMostrar_client.addActionListener(this);

            Table_Client.btn_delete_all.setActionCommand("btn_delete_all");
            Table_Client.btn_delete_all.addActionListener(this);

            Table_Client.btn_Return_client.setActionCommand("btn_Return_table");
            Table_Client.btn_Return_client.addActionListener(this);

            Table_Client.btn_Save_file.setActionCommand("btn_Save_file");
            Table_Client.btn_Save_file.addActionListener(this);

            Table_Client.ANTERIOR.setActionCommand("ANTERIOR");
            Table_Client.ANTERIOR.addActionListener(this);

            Table_Client.SIGUIENTE.setActionCommand("SIGUIENTE");
            Table_Client.SIGUIENTE.addActionListener(this);

            Table_Client.primero.setActionCommand("primero");
            Table_Client.primero.addActionListener(this);

            Table_Client.ultimo.setActionCommand("ultimo");
            Table_Client.ultimo.addActionListener(this);

            Table_Client.jComboBox1.setActionCommand("jComboBox1");
            Table_Client.jComboBox1.addActionListener(this);

            Table_Client.mini_Table_Client.setName("Tabla_pager");
            Table_Client.mini_Table_Client.addMouseListener(this);

            Table_Client.btnchange_user.setActionCommand("btnchange_user");
            Table_Client.btnchange_user.addActionListener(this);
        }

        if (i == 1) {

            Create_Client.setVisible(true);
            Create_Client.setTitle("Create Client");
            Create_Client.setLocationRelativeTo(null);
            Create_Client.setSize(950, 1030);//ancho x alto
            Create_Client.setResizable(false);
            singleactiondate = "add";

            //Information_dialog.setLocationRelativeTo(null);
            //Information_dialog.setTitle("Information");
            //Information_dialog.setSize(1000, 200);
            //Information_dialog.setModal(true);
            //Information_dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            Create_Client.pick_date_birth.getDateEditor().setEnabled(false);
            Create_Client.pick_date_reg.getDateEditor().setEnabled(false);
            Create_Client.pick_date_birth.setDateFormatString(Classconfig.getInstance().getdatef());
            Create_Client.pick_date_reg.setDateFormatString(Classconfig.getInstance().getdatef());

            // Conjunto de teclas que queremos que sirvan para pasar el foco 
            // al siguiente campo de texto: ENTER y TAB
            Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
            teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
            teclas.add(AWTKeyStroke.getAWTKeyStroke(
                    KeyEvent.VK_TAB, 0));

            // Se pasa el conjunto de teclas al panel principal 
            Create_Client.panelRect1.setFocusTraversalKeys(
                    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                    teclas);

            this.Create_Client.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Create_Client.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Create_Client.dispose();
                    new ControllerClient(new table_Client_view(), 0).Start(0);
                }
            });

            Create_Client.btn_Aceptar.setActionCommand("btn_Aceptar");
            Create_Client.btn_Aceptar.addActionListener(this);

            Create_Client.btn_Cancel.setActionCommand("btn_Cancel_a");
            Create_Client.btn_Cancel.addActionListener(this);

            Create_Client.btnAvatar.setActionCommand("btnAvatar");
            Create_Client.btnAvatar.addActionListener(this);

            Create_Client.txtDni.setActionCommand("txtDni");
            Create_Client.txtDni.setName("txtDni");
            Create_Client.txtDni.addActionListener(this);
            Create_Client.txtDni.addKeyListener(this);

            Create_Client.txtEmail.setActionCommand("txtEmail");
            Create_Client.txtEmail.setName("txtEmail");
            Create_Client.txtEmail.addActionListener(this);
            Create_Client.txtEmail.addKeyListener(this);

            Create_Client.txtLast_name.setActionCommand("txtLast_name");
            Create_Client.txtLast_name.setName("txtLast_name");
            Create_Client.txtLast_name.addActionListener(this);
            Create_Client.txtLast_name.addKeyListener(this);

            Create_Client.txtMobile.setActionCommand("txtMobile");
            Create_Client.txtMobile.setName("txtMobile");
            Create_Client.txtMobile.addActionListener(this);
            Create_Client.txtMobile.addKeyListener(this);

            Create_Client.txtName.setActionCommand("txtName");
            Create_Client.txtName.setName("txtName");
            Create_Client.txtName.addActionListener(this);
            Create_Client.txtName.addKeyListener(this);

            Create_Client.txtPassword.setActionCommand("txtPassword");
            Create_Client.txtPassword.setName("txtPassword");
            Create_Client.txtPassword.addActionListener(this);
            Create_Client.txtPassword.addKeyListener(this);

            Create_Client.txtPurchase.setActionCommand("txtPurchase");
            Create_Client.txtPurchase.setName("txtPurchase");
            Create_Client.txtPurchase.addActionListener(this);
            Create_Client.txtPurchase.addKeyListener(this);

            Create_Client.txtUser.setActionCommand("txtUser");
            Create_Client.txtUser.setName("txtUser");
            Create_Client.txtUser.addActionListener(this);
            Create_Client.txtUser.addKeyListener(this);

        }

        if (i == 2) {

            Edit_Client.setTitle("Edit Client");
            Edit_Client.setLocationRelativeTo(null);
            Edit_Client.setSize(950, 1030);//ancho x alto
            Edit_Client.setResizable(false);
            Edit_Client.setBackground(Color.GRAY);
            Edit_Client.pick_date_birth.getDateEditor().setEnabled(false);
            Edit_Client.pick_date_reg.getDateEditor().setEnabled(false);
            Edit_Client.pick_date_birth.setDateFormatString(Classconfig.getInstance().getdatef());
            Edit_Client.pick_date_reg.setDateFormatString(Classconfig.getInstance().getdatef());
            singleactiondate = "edit";
            Edit_Client.setVisible(true);

            // Conjunto de teclas que queremos que sirvan para pasar el foco 
            // al siguiente campo de texto: ENTER y TAB
            Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
            teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
            teclas.add(AWTKeyStroke.getAWTKeyStroke(
                    KeyEvent.VK_TAB, 0));

            Edit_Client.panelRect1.setFocusTraversalKeys(
                    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                    teclas);

            this.Edit_Client.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Edit_Client.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {

                    if (singletonapp.window.equals("Admin")) {
                        //si es un Admin vuelve al table.
                        Edit_Client.dispose();
                        new ControllerClient(new table_Client_view(), 0).Start(0);
                    } else {
                        //Si es un client salede la aplicacion
                        JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                                JOptionPane.INFORMATION_MESSAGE);
                        Mongo_DB.disconnect();
                        System.exit(0);
                    }

                }
            });

            Edit_Client.btn_Aceptar.setActionCommand("btn_Aceptar_e");
            Edit_Client.btn_Aceptar.addActionListener(this);

            Edit_Client.btn_Cancelar.setActionCommand("btn_cancelar_e");
            Edit_Client.btn_Cancelar.addActionListener(this);

            Edit_Client.btnAvatar.setActionCommand("btnAvatar_e");
            Edit_Client.btnAvatar.addActionListener(this);

            Edit_Client.txtEmail.setActionCommand("txtEmail_e");
            Edit_Client.txtEmail.setName("txtEmail_e");
            Edit_Client.txtEmail.addActionListener(this);
            Edit_Client.txtEmail.addKeyListener(this);

            Edit_Client.txtLast_name.setActionCommand("txtLast_name_e");
            Edit_Client.txtLast_name.setName("txtLast_name_e");
            Edit_Client.txtLast_name.addActionListener(this);
            Edit_Client.txtLast_name.addKeyListener(this);

            Edit_Client.txtMobile.setActionCommand("txtMobile_e");
            Edit_Client.txtMobile.setName("txtMobile_e");
            Edit_Client.txtMobile.addActionListener(this);
            Edit_Client.txtMobile.addKeyListener(this);

            Edit_Client.txtName.setActionCommand("txtName_e");
            Edit_Client.txtName.setName("txtName_e");
            Edit_Client.txtName.addActionListener(this);
            Edit_Client.txtName.addKeyListener(this);

            Edit_Client.txtPassword.setActionCommand("txtPassword_e");
            Edit_Client.txtPassword.setName("txtPassword_e");
            Edit_Client.txtPassword.addActionListener(this);
            Edit_Client.txtPassword.addKeyListener(this);

            Edit_Client.txtPurchase.setActionCommand("txtPurchase_e");
            Edit_Client.txtPurchase.setName("txtPurchase_e");
            Edit_Client.txtPurchase.addActionListener(this);
            Edit_Client.txtPurchase.addKeyListener(this);

            Edit_Client.txtUser.setActionCommand("txtUser_e");
            Edit_Client.txtUser.setName("txtUser_e");
            Edit_Client.txtUser.addActionListener(this);
            Edit_Client.txtUser.addKeyListener(this);
        }

        if (i == 3) {

            Show_Client.setTitle("Client data");
            Show_Client.setLocationRelativeTo(null);
            Show_Client.setSize(1000, 700);//ancho x alto
            Show_Client.setResizable(false);
            Show_Client.setVisible(true);

            this.Show_Client.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Show_Client.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {

                    if (singletonapp.window.equals("Admin")) {
                        //si es un Admin vuelve al table.
                        Show_Client.dispose();
                        new ControllerClient(new table_Client_view(), 0).Start(0);
                    } else {
                        //Si es un client salede la aplicacion
                        JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                                JOptionPane.INFORMATION_MESSAGE);
                        Mongo_DB.disconnect();
                        System.exit(0);
                    }
                }
            });

            Show_Client.btnAcept.setActionCommand("btnAccept_s");
            Show_Client.btnAcept.addActionListener(this);
        }

        if (i == 4) {

            Task_Client.setVisible(true);
            Task_Client.setTitle("Task Client");
            Task_Client.setLocationRelativeTo(null);
            Task_Client.setSize(1600, 1100);//ancho x alto
            Task_Client.setResizable(false);
            Task_Client.setExtendedState(JFrame.MAXIMIZED_BOTH);

            Task_Client.btn_show.setText(Lang.getInstance().getProperty("MY_PROFILE"));
            Task_Client.btn_modify.setText(Lang.getInstance().getProperty("MODIFY_MY_PROFILE"));
            Task_Client.btn_config.setText(Lang.getInstance().getProperty("CONFIGURATION"));
            Task_Client.btn_Exit.setText(Lang.getInstance().getProperty("EXIT"));

            singletonapp.window = "Client";
            Task_Client.lab_username.setText(Lang.getInstance().getProperty("WELCOME") + ": " + singletonapp.user);

            this.Task_Client.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Task_Client.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                            JOptionPane.INFORMATION_MESSAGE);
                    Mongo_DB.disconnect();
                    System.exit(0);
                }
            });

            Task_Client.btn_show.setActionCommand("btn_showtask");
            Task_Client.btn_show.addActionListener(this);

            Task_Client.btn_modify.setActionCommand("btn_modifytask");
            Task_Client.btn_modify.addActionListener(this);

            Task_Client.btn_config.setActionCommand("btn_configtask");
            Task_Client.btn_config.addActionListener(this);

            Task_Client.btn_Exit.setActionCommand("btn_exit");
            Task_Client.btn_Exit.addActionListener(this);

            Task_Client.btn_log_out.setActionCommand("btn_log_out");
            Task_Client.btn_log_out.addActionListener(this);
        }

    }

    public void actionPerformed(ActionEvent ae) {

        boolean ok = false;
        switch (Action_Client.valueOf(ae.getActionCommand())) {

            case btnAdd_client:

                Table_Client.dispose();
                new ControllerClient(new create_Client_view(), 1).Start(1);

                break;
            case btnEditar_client:

                ok = BLL_Client.modifity_select_client();
                if (true == ok) {

                    Table_Client.dispose();
                }

                break;
            case btnBorrar_client:

                BLL_Client.delete_select_client();
                break;

            case btnchange_user:

                BLL_Client.change_table_user();
                break;
            case btnMostrar_client:

                BLL_Client.show_select_client();

                break;
            case btn_delete_all:

                BLL_Client.Delete_all_client();
                break;
            case btn_Return_table:

                Table_Client.dispose();
                new ControllerAdmin(new task_Admin_view(), 0).Start(0);

                break;

            case btn_Save_file:

                if (Table_Client.combo_file.getSelectedItem().equals("Json")) {
                    BLL_Client.save_json_client();
                }
                if (Table_Client.combo_file.getSelectedItem().equals("Xml")) {
                    BLL_Client.save_xml_client();
                }
                if (Table_Client.combo_file.getSelectedItem().equals("Txt")) {
                    BLL_Client.save_txt_client();
                }

                break;

            case ANTERIOR:
                pagina_client.currentPageIndex -= 1;
                pagina_client.initLinkBox();
                break;
            case SIGUIENTE:
                pagina_client.currentPageIndex += 1;
                pagina_client.initLinkBox();
                break;
            case primero:
                pagina_client.currentPageIndex = 1;
                pagina_client.initLinkBox();
                break;
            case ultimo:
                pagina_client.currentPageIndex = pagina_client.maxPageIndex;
                pagina_client.initLinkBox();
                break;
            case jComboBox1:

                pagina_client.itemsPerPage = Integer.parseInt(jComboBox1.getSelectedItem().toString());
                pagina_client.currentPageIndex = 1;
                pagina_client.initLinkBox();

                break;
            case btn_Aceptar:

                ok = BLL_Client.Enter_new_client();

                if (ok == true) {

                    Create_Client.dispose();
                    new ControllerClient(new table_Client_view(), 0).Start(0);

                    ((Table_Client_class) mini_Table_Client.getModel()).cargar();
                }
                break;

            case btn_Cancel_a:

                if (singletonapp.window.equals("Admin")) {
                    Create_Client.dispose();
                    new ControllerClient(new table_Client_view(), 0).Start(0);
                } else {

                    //ventana client
                }
                break;
            case btnAvatar:

                BLL_Client.EnterAvatar_client();

                break;
            case btn_Aceptar_e:

                ok = BLL_Client.Enter_edited_client();
                if ((ok == true) && (singletonapp.window.equals("Admin"))) {
                    Edit_Client.dispose();
                    new ControllerClient(new table_Client_view(), 0).Start(0);
                    //((Table_Client_class) mini_Table_Client.getModel()).cargar();

                } else if ((ok == true) && (singletonapp.window.equals("Client"))) {
                    Edit_Client.dispose();
                    new ControllerClient(new task_Client_view(), 4).Start(4);
                }

                break;
            case btn_cancelar_e:

                if (singletonapp.window.equals("Admin")) {
                    Edit_Client.dispose();
                    new ControllerClient(new table_Client_view(), 0).Start(0);
                } else if (singletonapp.window.equals("Client")) {
                    Edit_Client.dispose();
                    new ControllerClient(new task_Client_view(), 4).Start(4);
                }

                break;
            case btnAvatar_e:

                BLL_Client.EditAvatar_client();

                break;
            case btnAccept_s:

                if (singletonapp.window.equals("Admin")) {
                    Show_Client.dispose();
                    new ControllerClient(new table_Client_view(), 0).Start(0);
                } else if (singletonapp.window.equals("Client")) {
                    Show_Client.dispose();
                    new ControllerClient(new task_Client_view(), 4).Start(4);

                }

                break;
            case btn_showtask:

                Task_Client.dispose();
                new ControllerClient(new show_Client_view(), 3).Start(3);
                DAO_Client.Load_show_client_mongo();

                break;

            case btn_modifytask:

                Task_Client.dispose();
                new ControllerClient(new edit_Client_view(), 2).Start(2);
                DAO_Client.Load_edit_client_mongo();

                break;

            case btn_configtask:

                Task_Client.dispose();
                new ControllerMain(new menu_Settings(), 1).Start(1);

                break;

            case btn_exit:

                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                        JOptionPane.INFORMATION_MESSAGE);
                Mongo_DB.disconnect();
                System.exit(0);

                break;

            case btn_log_out:

                Task_Client.dispose();
                new ControllerMain(new menu_Input(), 0).Start(0);

                break;
        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if (singleactiondate.equals("add")) {
            BLL_Client.Enterdate_birth_client();
            BLL_Client.Enterdate_reg_client();
        }

        if (singleactiondate.equals("edit")) {
            BLL_Client.Editdate_birth_client();
            BLL_Client.Editdate_reg_client();
        }
    }

    @Override
    public void keyPressed(KeyEvent es) {

        switch (Action_Client.valueOf(es.getComponent().getName())) {

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
            case txtPurchase:
                // BLL_Admin.Entersalary_admin();
                break;
            case txtUser:
                // BLL_Admin.Enteruser_admin();
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
            case txtPurchase_e:
                // BLL_Admin.Editsalary_admin();
                break;
            case txtUser_e:
                // BLL_Admin.Edituser_admin();
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        switch (Action_Client.valueOf(e.getComponent().getName())) {

            case txtDni:
                BLL_Client.Enterdni_client();
                break;
            case txtEmail:
                BLL_Client.Entermail_client();
                break;
            case txtLast_name:
                BLL_Client.Enterlast_name_client();
                break;
            case txtMobile:
                BLL_Client.Entermobile_client();
                break;
            case txtName:
                BLL_Client.Entername_client();
                break;
            case txtPassword:
                BLL_Client.Enterpassword_client();
                break;
            case txtPurchase:
                BLL_Client.Enterpurchase_client();
                break;
            case txtUser:
                BLL_Client.Enteruser_client();
                break;

            case txtEmail_e:
                BLL_Client.Editmail_client();
                break;
            case txtLast_name_e:
                BLL_Client.Editlast_name_client();
                break;
            case txtMobile_e:
                BLL_Client.Editmobile_client();
                break;
            case txtName_e:
                BLL_Client.Editname_client();
                break;
            case txtPassword_e:
                BLL_Client.Editpassword_client();
                break;
            case txtPurchase_e:
                BLL_Client.Editsalary_client();
                break;
            case txtUser_e:
                BLL_Client.Edituser_client();
                break;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        switch (Action_Client.valueOf(e.getComponent().getName())) {

            case Tabla_pager:

                if (e.getClickCount() == 2) {
                    BLL_Client.modifity_select_client();
                }
                break;

        }
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("word selected: " + ((JComboBox) combo).getSelectedItem());
        pagina_client.currentPageIndex = 1;
        pagina_client.initLinkBox();
        ((Table_Client_class) mini_Table_Client.getModel()).filtrar();
        combo.requestFocus();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
