package Appweb.Modules.Users.Client.Controller;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.Controller.ControllerMain;
import Appweb.Modules.Main.View.menu_Input;







import static Appweb.Modules.Users.Client.Controller.ControllerClient.Table_Client;
import Appweb.Modules.Users.Client.Model.BLL_Client.BLL_Client;
import Appweb.Modules.Users.Client.Model.Classes.Table_Client;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;
import Appweb.Modules.Users.Client.Model.Tools.Pager.pagina_client;
import Appweb.Modules.Users.Client.Model.Tools.autocomplete.AutocompleteJComboBox_client;
import Appweb.Modules.Users.Client.Model.Tools.autocomplete.StringSearchable_client;
import Appweb.Modules.Users.Client.View.create_Client_view;
import Appweb.Modules.Users.Client.View.edit_Client_view;
import Appweb.Modules.Users.Client.View.show_Client_view;
import Appweb.Modules.Users.Client.View.table_Client_view;
import static Appweb.Modules.Users.Client.View.table_Client_view.jComboBox1;
import static Appweb.Modules.Users.Client.View.table_Client_view.mini_Table_Client;
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

    //public static task_Admin_view Task_Admin;
    public static table_Client_view Table_Client;
    public static create_Client_view Create_Client;
    public static edit_Client_view Edit_Client;
    public static show_Client_view Show_Client;

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<>(new Table_Client());
    public static AutocompleteJComboBox_client combo = null;
    public static JTable tabla = null;

    public ControllerClient(JFrame start, int i) {

        
        //if (i == 0) {
           // Task_Admin = (task_Admin_view) start;
        //}
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
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public enum Action_Client {

        //botones de Task_Client//
        //btn_Config,
        //btn_Volver,
        //btn_ges_users,
        //btn_ges_inst,
        //btn_ges_averias,
        
        //botones table Client//

        btnAdd_client,
        btnEditar_client,
        btnBorrar_client,
        btnMostrar_client,
        btn_delete_all,
        btn_Return_table,
        ANTERIOR,
        SIGUIENTE,
        primero,
        ultimo,
        jComboBox1,//combo filtrar
        Tabla_pager,//mouseclicked

        //botones create Admin//

        btn_Aceptar,
        btn_Cancel_a,
        btnAvatar,
        pick_date_birth,
        pick_date_contr,
        //txtActivity,
        txtDni,
        txtEmail,
        txtLast_name,
        txtMobile,
        txtName,
        txtPassword,
        txtPurchase,
        txtUser,
        //botones edit Admin//

        btn_Aceptar_e,
        btn_cancelar_e,
        btnAvatar_e,
        pick_date_birth_e,
        pick_date_contr_e,
        //txtActivity_e,
        txtEmail_e,
        txtLast_name_e,
        txtMobile_e,
        txtName_e,
        txtPassword_e,
        txtPurchase_e,
        txtUser_e,
        //botones Mostrar//

        btnAccept_s,
    }

    public void Start(int i) {
        
        /**
        if (i == 0) {

            Task_Admin.setTitle(Lang.getInstance().getProperty("Task Admin"));
            Task_Admin.setLocationRelativeTo(null);
            Task_Admin.setSize(1000, 600);//ancho x alto
            // this.setResizable(false);

            Task_Admin.setExtendedState(JFrame.MAXIMIZED_BOTH);
            Task_Admin.setVisible(true);

            this.Task_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Task_Admin.addWindowListener(new WindowAdapter() {
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
         */
        if (i == 0) {

            Table_Client.setVisible(true);

            Table_Client.setTitle("Table Client");
            Table_Client.setLocationRelativeTo(null);
            Table_Client.setSize(1000, 650);//ancho x alto
            Table_Client.setResizable(true);
            Table_Client.setExtendedState(JFrame.MAXIMIZED_BOTH);

            //singletonapp.singleton_vtna = "Client";

            Table_Client.mini_Table_Client.setModel(new Table_Client());
            ((Table_Client) mini_Table_Client.getModel()).cargar();
            Table_Client.mini_Table_Client.setFillsViewportHeight(true);
            Table_Client.mini_Table_Client.setRowSorter(sorter);

            pagina_client.inicializa();
            pagina_client.initLinkBox();

            Table_Client.jLabel3.setText(String.valueOf(singleclient.Client_array.size()));

            this.Table_Client.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Table_Client.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Table_Client.dispose();
                    JOptionPane.showMessageDialog(null, " Ahora deberia abrir el login ");
                    new ControllerMain(new menu_Input(), 0).Start(0);

                }
            });

            List<String> myWords = new ArrayList<String>();

            for (int j = 0; j <= singleclient.Client_array.size() - 1; j++) {
                myWords.add(singleclient.Client_array.get(j).getName().toLowerCase());
                myWords.add(singleclient.Client_array.get(j).getName().toUpperCase());
            }

            StringSearchable_client searchable = new StringSearchable_client(myWords);
            this.combo = new AutocompleteJComboBox_client(searchable);
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

            Table_Client.btn_Return_client.setActionCommand("btn_Volver_table");
            Table_Client.btn_Return_client.addActionListener(this);

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
        }

        if (i == 1) {

            Create_Client.setVisible(true);
            Create_Client.setTitle("Create Client");
            Create_Client.setLocationRelativeTo(null);
            Create_Client.setSize(1000, 1200);//ancho x alto
            Create_Client.setResizable(false);

            //Information_dialog.setLocationRelativeTo(null);
            //Information_dialog.setTitle("Information");
            //Information_dialog.setSize(1000, 200);
            //Information_dialog.setModal(true);
            //Information_dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            Create_Client.pick_date_birth.getDateEditor().setEnabled(false);
            Create_Client.pick_date_reg.getDateEditor().setEnabled(false);

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
                }
            });

            Create_Client.btn_Aceptar.setActionCommand("btn_Aceptar");
            Create_Client.btn_Aceptar.addActionListener(this);

            Create_Client.btn_Cancel.setActionCommand("btn_Cancel_a");
            Create_Client.btn_Cancel.addActionListener(this);

            Create_Client.btnAvatar.setActionCommand("btnAvatar");
            Create_Client.btnAvatar.addActionListener(this);

            //Create_Admin.pick_date_birth.setName("pick_date_birth");
            //Create_Admin.pick_date_birth.addPropertyChangeListener(this);

            //Create_Admin.pick_date_contr.setName("pick_date_contr");
            //Create_Admin.pick_date_contr.addPropertyChangeListener(this);

            Create_Client.txtDni.setActionCommand("txtDni");
            Create_Client.txtDni.setName("txtDni");
            Create_Client.txtDni.addActionListener(this);
            Create_Client.txtDni.addKeyListener(this);

            //Create_Client.txtActivity.setActionCommand("txtActivity");
            //Create_Client.txtActivity.setName("txtActivity");
            //Create_Client.txtActivity.addActionListener(this);
            //Create_Client.txtActivity.addKeyListener(this);

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
            Edit_Client.setSize(1000, 1200);//ancho x alto
            Edit_Client.setResizable(false);
            Edit_Client.setBackground(Color.GRAY);
            Edit_Client.pick_date_birth.getDateEditor().setEnabled(false);
            Edit_Client.pick_date_reg.getDateEditor().setEnabled(false);
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
                    Edit_Client.dispose();
                }
            });

            Edit_Client.btn_Aceptar.setActionCommand("btn_Aceptar_e");
            Edit_Client.btn_Aceptar.addActionListener(this);

            Edit_Client.btn_Cancelar.setActionCommand("btn_cancelar_e");
            Edit_Client.btn_Cancelar.addActionListener(this);

            Edit_Client.btnAvatar.setActionCommand("btnAvatar_e");
            Edit_Client.btnAvatar.addActionListener(this);

            //Edit_Admin.pick_date_birth.setName("pick_date_birth_e");
            //Edit_Admin.pick_date_birth.addPropertyChangeListener(this);

            //Edit_Admin.pick_date_contr.setName("pick_date_contr_e");
           // Edit_Admin.pick_date_contr.addPropertyChangeListener(this);

           // Edit_Admin.txtActivity.setActionCommand("txtActivity_e");
           // Edit_Admin.txtActivity.setName("txtActivity_e");
           // Edit_Admin.txtActivity.addActionListener(this);
            //Edit_Admin.txtActivity.addKeyListener(this);

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

            Edit_Client.txtPurchase.setActionCommand("txtSalary_e");
            Edit_Client.txtPurchase.setName("txtSalary_e");
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
            Show_Client.setSize(1000, 650);//ancho x alto
            Show_Client.setResizable(false);
            Show_Client.setVisible(true);
            
            this.Show_Client.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Show_Client.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Show_Client.dispose();
                }
            });

            Show_Client.btnAcept.setActionCommand("btnAccept_s");
            Show_Client.btnAcept.addActionListener(this);
        }
    }

    public void actionPerformed(ActionEvent ae) {

        boolean ok = false;
        switch (Action_Client.valueOf(ae.getActionCommand())) {
/**
            case btn_ges_users:

                Task_Admin.dispose();
                new ControllerClient(new table_Admin_view(), 1).Start(1);

                break;
            case btn_Config:

                Task_Admin.dispose();
                new ControllerMain(new menu_Settings(), 1).Start(1);

                break;
            case btn_Volver:

                Task_Admin.dispose();
                new ControllerMain(new menu_Input(), 0).Start(0);

                break;

            case btn_ges_inst:
                //nulo
                break;
            case btn_ges_averias:
                //nulo
                break;
          */      
                
            case btnAdd_client:

                JOptionPane.showMessageDialog(null, "Entro a crear");
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
            case btnMostrar_client:

                BLL_Client.show_select_client();

                break;
            case btn_delete_all:

                BLL_Client.Delete_all_client();
                break;
            case btn_Return_table:

                Table_Client.dispose();
                new ControllerMain(new menu_Input(), 0).Start(0);

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

                    ((Table_Client) mini_Table_Client.getModel()).cargar();
                }
                break;

            case btn_Cancel_a:

               
                Create_Client.dispose();
                new ControllerClient(new table_Client_view(), 0).Start(0);

                break;
            case btnAvatar:

                BLL_Client.EnterAvatar_client();

                break;
            case btn_Aceptar_e:

                ok = BLL_Client.Enter_edited_client();
                if (ok == true) {
                    Edit_Client.dispose();
                    new ControllerClient(new table_Client_view(), 0).Start(0);
                    ((Table_Client) mini_Table_Client.getModel()).cargar();

                }

                break;
            case btn_cancelar_e:

                
                Edit_Client.dispose();
                new ControllerClient(new table_Client_view(), 0).Start(0);

                break;
            case btnAvatar_e:

                BLL_Client.EditAvatar_client();

                break;
            case btnAccept_s:

                Show_Client.dispose();
                new ControllerClient(new table_Client_view(), 0).Start(0);

                break;

        }

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

       

        BLL_Client.Enterdate_birth_client();
        BLL_Client.Enterdate_reg_client();
        BLL_Client.Editdate_birth_client();
        BLL_Client.Editdate_reg_client();
/**
        switch (Action_Admin.valueOf(evt.getPropertyName())) {

            case pick_date_birth:
                //BLL_Admin.Enterdate_birth_admin();

                break;
            case pick_date_contr:
                // BLL_Admin.Enterdate_contr_admin();

                break;
            case pick_date_birth_e:
                //BLL_Admin.Editdate_birth_admin();

                break;
            case pick_date_contr_e:
                //BLL_Admin.Editdate_contr_admin();

                break;

        }
        * */
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
        ((Table_Client) mini_Table_Client.getModel()).filtrar();
        combo.requestFocus();
    }
}
