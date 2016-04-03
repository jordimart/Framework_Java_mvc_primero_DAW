package Appweb.Modules.Users.Admin.Controller;

import Appweb.General_tools.singletonapp;
import static Appweb.General_tools.singletonapp.singleactiondate;
import Appweb.Modules.Main.Controller.ControllerMain;
import Appweb.Modules.Main.Model.Config.Classes.Classconfig;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.View.menu_Input;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin;
import Appweb.Modules.Users.Admin.Model.Classes.Table_Admin_class;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import Appweb.Modules.Users.Admin.Model.Tools.Pager.pagina;
import Appweb.Modules.Users.Admin.Model.Tools.autocomplete.AutocompleteJComboBox;
import Appweb.Modules.Users.Admin.Model.Tools.autocomplete.StringSearchable;
import Appweb.Modules.Users.Admin.View.create_Admin_view;
import Appweb.Modules.Users.Admin.View.edit_Admin_view;
import Appweb.Modules.Users.Admin.View.show_Admin_view;
import Appweb.Modules.Users.Admin.View.table_Admin_view;

import static Appweb.Modules.Users.Admin.View.table_Admin_view.jComboBox1;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.mini_Table_Admin;

import Appweb.Modules.Users.Admin.View.task_Admin_view;
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
import javax.swing.JTable;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jorge
 */
public class ControllerAdmin implements ActionListener, MouseListener, PropertyChangeListener, KeyListener {
    
    public static task_Admin_view Task_Admin;
    public static table_Admin_view Table_Admin;
    public static create_Admin_view Create_Admin;
    public static edit_Admin_view Edit_Admin;
    public static show_Admin_view Show_Admin;
    
    public static TableRowSorter<TableModel> sorter = new TableRowSorter<>(new Table_Admin_class());
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
    
    public enum Action_Admin {

        //botones de Task_Admin//
        
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
        btn_Save_file,
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
        txtActivity,
        txtDni,
        txtEmail,
        txtLast_name,
        txtMobile,
        txtName,
        txtPassword,
        txtSalary,
        txtUser,
        //botones edit Admin//

        btn_Aceptar_e,
        btn_cancelar_e,
        btnAvatar_e,
        pick_date_birth_e,
        pick_date_contr_e,
        txtActivity_e,
        txtEmail_e,
        txtLast_name_e,
        txtMobile_e,
        txtName_e,
        txtPassword_e,
        txtSalary_e,
        txtUser_e,
        //botones Mostrar//

        btnAccept_s,
    }
    
    public void Start(int i) {
        if (i == 0) {
            
            Task_Admin.setTitle(Lang.getInstance().getProperty("Task Admin"));
            Task_Admin.setLocationRelativeTo(null);
            Task_Admin.setSize(1600, 1100);//ancho x alto
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
            
            Table_Admin.setVisible(true);
            
            Table_Admin.setTitle("Table Admin");
            Table_Admin.setLocationRelativeTo(null);
            Table_Admin.setSize(1700, 1000);//ancho x alto
            Table_Admin.setResizable(true);
            //Table_Admin.setExtendedState(JFrame.MAXIMIZED_BOTH);

            singletonapp.singleton_vtna = "Admin";
            
            Table_Admin.mini_Table_Admin.setModel(new Table_Admin_class());
            ((Table_Admin_class) mini_Table_Admin.getModel()).cargar();
            Table_Admin.mini_Table_Admin.setFillsViewportHeight(true);
            Table_Admin.mini_Table_Admin.setRowSorter(sorter);
            
            pagina.inicializa();
            pagina.initLinkBox();
            
            Table_Admin.jLabel3.setText(String.valueOf(singleadmin.Admin_array.size()));
            
            this.Table_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Table_Admin.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Table_Admin.dispose();
                    new ControllerAdmin(new task_Admin_view(), 0).Start(0);
                    
                }
            });
            
            List<String> myWords = new ArrayList<String>();
            
            for (int j = 0; j <= singleadmin.Admin_array.size() - 1; j++) {
                myWords.add(singleadmin.Admin_array.get(j).getName().toLowerCase());
                myWords.add(singleadmin.Admin_array.get(j).getName().toUpperCase());
            }
            
            StringSearchable searchable = new StringSearchable(myWords);
            this.combo = new AutocompleteJComboBox(searchable);
            Table_Admin.jPanel3.setLayout(new java.awt.BorderLayout());
            Table_Admin.jPanel3.add(combo);
            
            combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }
                
            });
            
            Table_Admin.btnAdd_admin.setActionCommand("btnAdd_admin");
            Table_Admin.btnAdd_admin.addActionListener(this);
            
            Table_Admin.btnEditar_admin.setActionCommand("btnEditar_admin");
            Table_Admin.btnEditar_admin.addActionListener(this);
            
            Table_Admin.btnBorrar_admin.setActionCommand("btnBorrar_admin");
            Table_Admin.btnBorrar_admin.addActionListener(this);
            
            Table_Admin.btnMostrar_admin.setActionCommand("btnMostrar_admin");
            Table_Admin.btnMostrar_admin.addActionListener(this);
            
            Table_Admin.btn_delete_all.setActionCommand("btn_delete_all");
            Table_Admin.btn_delete_all.addActionListener(this);
            
            Table_Admin.btn_Volver.setActionCommand("btn_Volver_table");
            Table_Admin.btn_Volver.addActionListener(this);
            
            Table_Admin.btn_Save_file.setActionCommand("btn_Save_file");
            Table_Admin.btn_Save_file.addActionListener(this);
            
            Table_Admin.ANTERIOR.setActionCommand("ANTERIOR");
            Table_Admin.ANTERIOR.addActionListener(this);
            
            Table_Admin.SIGUIENTE.setActionCommand("SIGUIENTE");
            Table_Admin.SIGUIENTE.addActionListener(this);
            
            Table_Admin.primero.setActionCommand("primero");
            Table_Admin.primero.addActionListener(this);
            
            Table_Admin.ultimo.setActionCommand("ultimo");
            Table_Admin.ultimo.addActionListener(this);
            
            Table_Admin.jComboBox1.setActionCommand("jComboBox1");
            Table_Admin.jComboBox1.addActionListener(this);
            
            Table_Admin.mini_Table_Admin.setName("Tabla_pager");
            Table_Admin.mini_Table_Admin.addMouseListener(this);
        }
        
        if (i == 2) {
            
            Create_Admin.setVisible(true);
            Create_Admin.setTitle("Create Admin");
            Create_Admin.setLocationRelativeTo(null);
            Create_Admin.setSize(1000, 1200);//ancho x alto
            Create_Admin.setResizable(false);
            singleactiondate="add";
            

            //Information_dialog.setLocationRelativeTo(null);
            //Information_dialog.setTitle("Information");
            //Information_dialog.setSize(1000, 200);
            //Information_dialog.setModal(true);
            //Information_dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            Create_Admin.pick_date_birth.getDateEditor().setEnabled(false);
            Create_Admin.pick_date_contr.getDateEditor().setEnabled(false);
            Create_Admin.pick_date_birth.setDateFormatString(Classconfig.getInstance().getdatef());
            Create_Admin.pick_date_contr.setDateFormatString(Classconfig.getInstance().getdatef());

            // Conjunto de teclas que queremos que sirvan para pasar el foco 
            // al siguiente campo de texto: ENTER y TAB
            Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
            teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
            teclas.add(AWTKeyStroke.getAWTKeyStroke(
                    KeyEvent.VK_TAB, 0));

            // Se pasa el conjunto de teclas al panel principal 
            Create_Admin.panelRect1.setFocusTraversalKeys(
                    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                    teclas);
            
            this.Create_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Create_Admin.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Create_Admin.dispose();
                    new ControllerAdmin(new table_Admin_view(), 1).Start(1);
                    
                }
            });
            
            Create_Admin.btn_Aceptar.setActionCommand("btn_Aceptar");
            Create_Admin.btn_Aceptar.addActionListener(this);
            
            Create_Admin.btn_Cancel.setActionCommand("btn_Cancel_a");
            Create_Admin.btn_Cancel.addActionListener(this);
            
            Create_Admin.btnAvatar.setActionCommand("btnAvatar");
            Create_Admin.btnAvatar.addActionListener(this);
            
            Create_Admin.txtDni.setActionCommand("txtDni");
            Create_Admin.txtDni.setName("txtDni");
            Create_Admin.txtDni.addActionListener(this);
            Create_Admin.txtDni.addKeyListener(this);
            
            Create_Admin.txtActivity.setActionCommand("txtActivity");
            Create_Admin.txtActivity.setName("txtActivity");
            Create_Admin.txtActivity.addActionListener(this);
            Create_Admin.txtActivity.addKeyListener(this);
            
            Create_Admin.txtEmail.setActionCommand("txtEmail");
            Create_Admin.txtEmail.setName("txtEmail");
            Create_Admin.txtEmail.addActionListener(this);
            Create_Admin.txtEmail.addKeyListener(this);
            
            Create_Admin.txtLast_name.setActionCommand("txtLast_name");
            Create_Admin.txtLast_name.setName("txtLast_name");
            Create_Admin.txtLast_name.addActionListener(this);
            Create_Admin.txtLast_name.addKeyListener(this);
            
            Create_Admin.txtMobile.setActionCommand("txtMobile");
            Create_Admin.txtMobile.setName("txtMobile");
            Create_Admin.txtMobile.addActionListener(this);
            Create_Admin.txtMobile.addKeyListener(this);
            
            Create_Admin.txtName.setActionCommand("txtName");
            Create_Admin.txtName.setName("txtName");
            Create_Admin.txtName.addActionListener(this);
            Create_Admin.txtName.addKeyListener(this);
            
            Create_Admin.txtPassword.setActionCommand("txtPassword");
            Create_Admin.txtPassword.setName("txtPassword");
            Create_Admin.txtPassword.addActionListener(this);
            Create_Admin.txtPassword.addKeyListener(this);
            
            Create_Admin.txtSalary.setActionCommand("txtSalary");
            Create_Admin.txtSalary.setName("txtSalary");
            Create_Admin.txtSalary.addActionListener(this);
            Create_Admin.txtSalary.addKeyListener(this);
            
            Create_Admin.txtUser.setActionCommand("txtUser");
            Create_Admin.txtUser.setName("txtUser");
            Create_Admin.txtUser.addActionListener(this);
            Create_Admin.txtUser.addKeyListener(this);
            
        }
        
        if (i == 3) {
            
            Edit_Admin.setTitle("Edit Admin");
            Edit_Admin.setLocationRelativeTo(null);
            Edit_Admin.setSize(1000, 1200);//ancho x alto
            Edit_Admin.setResizable(false);
            Edit_Admin.setBackground(Color.GRAY);
            Edit_Admin.pick_date_birth.getDateEditor().setEnabled(false);
            Edit_Admin.pick_date_contr.getDateEditor().setEnabled(false);
            Edit_Admin.pick_date_birth.setDateFormatString(Classconfig.getInstance().getdatef());
            Edit_Admin.pick_date_contr.setDateFormatString(Classconfig.getInstance().getdatef());
            
            singleactiondate="edit";
            Edit_Admin.setVisible(true);

            // Conjunto de teclas que queremos que sirvan para pasar el foco 
            // al siguiente campo de texto: ENTER y TAB
            Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
            teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
            teclas.add(AWTKeyStroke.getAWTKeyStroke(
                    KeyEvent.VK_TAB, 0));
            
            Edit_Admin.panelRect1.setFocusTraversalKeys(
                    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                    teclas);
            
            this.Edit_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Edit_Admin.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Edit_Admin.dispose();
                    new ControllerAdmin(new table_Admin_view(), 1).Start(1);
                }
            });
            
            Edit_Admin.btn_Aceptar.setActionCommand("btn_Aceptar_e");
            Edit_Admin.btn_Aceptar.addActionListener(this);
            
            Edit_Admin.btn_Cancelar.setActionCommand("btn_cancelar_e");
            Edit_Admin.btn_Cancelar.addActionListener(this);
            
            Edit_Admin.btnAvatar.setActionCommand("btnAvatar_e");
            Edit_Admin.btnAvatar.addActionListener(this);
            
            Edit_Admin.txtActivity.setActionCommand("txtActivity_e");
            Edit_Admin.txtActivity.setName("txtActivity_e");
            Edit_Admin.txtActivity.addActionListener(this);
            Edit_Admin.txtActivity.addKeyListener(this);
            
            Edit_Admin.txtEmail.setActionCommand("txtEmail_e");
            Edit_Admin.txtEmail.setName("txtEmail_e");
            Edit_Admin.txtEmail.addActionListener(this);
            Edit_Admin.txtEmail.addKeyListener(this);
            
            Edit_Admin.txtLast_name.setActionCommand("txtLast_name_e");
            Edit_Admin.txtLast_name.setName("txtLast_name_e");
            Edit_Admin.txtLast_name.addActionListener(this);
            Edit_Admin.txtLast_name.addKeyListener(this);
            
            Edit_Admin.txtMobile.setActionCommand("txtMobile_e");
            Edit_Admin.txtMobile.setName("txtMobile_e");
            Edit_Admin.txtMobile.addActionListener(this);
            Edit_Admin.txtMobile.addKeyListener(this);
            
            Edit_Admin.txtName.setActionCommand("txtName_e");
            Edit_Admin.txtName.setName("txtName_e");
            Edit_Admin.txtName.addActionListener(this);
            Edit_Admin.txtName.addKeyListener(this);
            
            Edit_Admin.txtPassword.setActionCommand("txtPassword_e");
            Edit_Admin.txtPassword.setName("txtPassword_e");
            Edit_Admin.txtPassword.addActionListener(this);
            Edit_Admin.txtPassword.addKeyListener(this);
            
            Edit_Admin.txtSalary.setActionCommand("txtSalary_e");
            Edit_Admin.txtSalary.setName("txtSalary_e");
            Edit_Admin.txtSalary.addActionListener(this);
            Edit_Admin.txtSalary.addKeyListener(this);
            
            Edit_Admin.txtUser.setActionCommand("txtUser_e");
            Edit_Admin.txtUser.setName("txtUser_e");
            Edit_Admin.txtUser.addActionListener(this);
            Edit_Admin.txtUser.addKeyListener(this);
        }
        
        if (i == 4) {
            
            Show_Admin.setTitle("Admin data");
            Show_Admin.setLocationRelativeTo(null);
            Show_Admin.setSize(1000, 650);//ancho x alto
            Show_Admin.setResizable(false);
            Show_Admin.setVisible(true);
            
            this.Show_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.Show_Admin.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Show_Admin.dispose();
                    new ControllerAdmin(new table_Admin_view(), 1).Start(1);
                }
            });
            
            Show_Admin.btnAcept.setActionCommand("btnAccept_s");
            Show_Admin.btnAcept.addActionListener(this);
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        boolean ok = false;
        switch (Action_Admin.valueOf(ae.getActionCommand())) {
            
            case btn_ges_users:
                
                Task_Admin.dispose();
                new ControllerAdmin(new table_Admin_view(), 1).Start(1);
                
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
            case btnAdd_admin:
                
                Table_Admin.dispose();
                new ControllerAdmin(new create_Admin_view(), 2).Start(2);
                
                break;
            case btnEditar_admin:
                
                ok = BLL_Admin.modifity_select_admin();
                if (true == ok) {
                    
                    Table_Admin.dispose();
                }
                
                break;
            case btnBorrar_admin:
                
                BLL_Admin.delete_select_admin();
                break;
            case btnMostrar_admin:
                
                BLL_Admin.show_select_admin();
                
                break;
            case btn_delete_all:
                
                BLL_Admin.Delete_all_admin();
                break;
            case btn_Volver_table:
                
                Table_Admin.dispose();
                new ControllerAdmin(new task_Admin_view(), 0).Start(0);
                
                break;
            
            case btn_Save_file:
                
                if (Table_Admin.combo_file.getSelectedItem().equals("Json")) {
                    BLL_Admin.save_json_admin();
                }
                if (Table_Admin.combo_file.getSelectedItem().equals("Xml")) {
                    BLL_Admin.save_xml_admin();
                }
                if (Table_Admin.combo_file.getSelectedItem().equals("Txt")) {
                    BLL_Admin.save_txt_admin();
                }
                
                break;
            
            case ANTERIOR:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                break;
            case SIGUIENTE:
                pagina.currentPageIndex += 1;
                pagina.initLinkBox();
                break;
            case primero:
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;
            case ultimo:
                pagina.currentPageIndex = pagina.maxPageIndex;
                pagina.initLinkBox();
                break;
            case jComboBox1:
                
                pagina.itemsPerPage = Integer.parseInt(jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                
                break;
            case btn_Aceptar:
                
                ok = BLL_Admin.Enter_new_admin();
                
                if (ok == true) {
                    
                    Create_Admin.dispose();
                    new ControllerAdmin(new table_Admin_view(), 1).Start(1);
                    
                    ((Table_Admin_class) mini_Table_Admin.getModel()).cargar();
                }
                break;
            
            case btn_Cancel_a:
                
                Create_Admin.dispose();
                new ControllerAdmin(new table_Admin_view(), 1).Start(1);
                
                break;
            case btnAvatar:
                
                BLL_Admin.EnterAvatar_admin();
                
                break;
            case btn_Aceptar_e:
                
                ok = BLL_Admin.Enter_edited_admin();
                if (ok == true) {
                    Edit_Admin.dispose();
                    new ControllerAdmin(new table_Admin_view(), 1).Start(1);
                    ((Table_Admin_class) mini_Table_Admin.getModel()).cargar();
                    
                }
                
                break;
            case btn_cancelar_e:
                
                Edit_Admin.dispose();
                new ControllerAdmin(new table_Admin_view(), 1).Start(1);
                
                break;
            case btnAvatar_e:
                
                BLL_Admin.EditAvatar_admin();
                
                break;
            case btnAccept_s:
                
                Show_Admin.dispose();
                new ControllerAdmin(new table_Admin_view(), 1).Start(1);
                
                break;
            
        }
        
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        if (singleactiondate.equals("add")) {
            BLL_Admin.Enterdate_birth_admin();
            BLL_Admin.Enterdate_contr_admin();
        }
        
        if (singleactiondate.equals("edit")) {
            BLL_Admin.Editdate_birth_admin();
            BLL_Admin.Editdate_contr_admin();
        }
    }
    
    @Override
    public void keyPressed(KeyEvent es) {
        
        switch (Action_Admin.valueOf(es.getComponent().getName())) {
            
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
            case txtSalary:
                // BLL_Admin.Entersalary_admin();
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
            case txtSalary_e:
                // BLL_Admin.Editsalary_admin();
                break;
            case txtUser_e:
                // BLL_Admin.Edituser_admin();
                break;
        }
        
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        switch (Action_Admin.valueOf(e.getComponent().getName())) {
            
            case txtDni:
                BLL_Admin.Enterdni_admin();
                break;
            case txtEmail:
                BLL_Admin.Entermail_admin();
                break;
            case txtLast_name:
                BLL_Admin.Enterlast_name_admin();
                break;
            case txtMobile:
                BLL_Admin.Entermobile_admin();
                break;
            case txtName:
                BLL_Admin.Entername_admin();
                break;
            case txtPassword:
                BLL_Admin.Enterpassword_admin();
                break;
            case txtSalary:
                BLL_Admin.Entersalary_admin();
                break;
            case txtUser:
                BLL_Admin.Enteruser_admin();
                break;
            case txtActivity:
                BLL_Admin.Enteractivity_admin();
                break;
            case txtActivity_e:
                BLL_Admin.Editactivity_admin();
                break;
            case txtEmail_e:
                BLL_Admin.Editmail_admin();
                break;
            case txtLast_name_e:
                BLL_Admin.Editlast_name_admin();
                break;
            case txtMobile_e:
                BLL_Admin.Editmobile_admin();
                break;
            case txtName_e:
                BLL_Admin.Editname_admin();
                break;
            case txtPassword_e:
                BLL_Admin.Editpassword_admin();
                break;
            case txtSalary_e:
                BLL_Admin.Editsalary_admin();
                break;
            case txtUser_e:
                BLL_Admin.Edituser_admin();
                break;
        }
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        switch (Action_Admin.valueOf(e.getComponent().getName())) {
            
            case Tabla_pager:
                boolean ok=false;
                if (e.getClickCount() == 2) {
                   ok = BLL_Admin.modifity_select_admin();
                if (true == ok) {
                    
                    Table_Admin.dispose();
                }
                }
                break;
            
        }
    }
    
    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("word selected: " + ((JComboBox) combo).getSelectedItem());
        pagina.currentPageIndex = 1;
        pagina.initLinkBox();
        ((Table_Admin_class) mini_Table_Admin.getModel()).filtrar();
        combo.requestFocus();
    }
}
