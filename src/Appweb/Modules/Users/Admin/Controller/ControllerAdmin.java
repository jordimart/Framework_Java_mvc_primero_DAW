package Appweb.Modules.Users.Admin.Controller;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.Controller.ControllerMain;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
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
import static Appweb.Modules.Users.Admin.View.table_Admin_view.jLabel3;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.jPanel3;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.mini_Table_Admin;
import Appweb.Modules.Users.Admin.View.task_Admin_view;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
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
    
    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        mini_Table_Admin,//mouseclicked
        //botones create Admin//

        btn_Aceptar,
        btn_cancelar,
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
            
            Table_Admin.mini_Table_Admin.setName("mini_Table_Admin");
            Table_Admin.mini_Table_Admin.addMouseListener(this);
        }
        
        if (i == 2) {
            
            Create_Admin.setTitle("Create Admin");
            Create_Admin.setLocationRelativeTo(null);
            Create_Admin.setSize(1000, 1200);//ancho x alto
            Create_Admin.setResizable(false);
            
            //Information_dialog.setLocationRelativeTo(null);
            //Information_dialog.setTitle("Information");
            //Information_dialog.setSize(1000, 200);
            //Information_dialog.setModal(true);
            //Information_dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

            Create_Admin.pick_date_birth.getDateEditor().setEnabled(false);
            Create_Admin.pick_date_contr.getDateEditor().setEnabled(false);

            // Conjunto de teclas que queremos que sirvan para pasar el foco 
            // al siguiente campo de texto: ENTER y TAB
            Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
            teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
            teclas.add(AWTKeyStroke.getAWTKeyStroke(
                    KeyEvent.VK_TAB, 0));

            // Se pasa el conjunto de teclas al panel principal 
            Create_Admin.panrect1.setFocusTraversalKeys(
                    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                    teclas);
            
            Create_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Create_Admin.dispose();
                }
            });
            
            Create_Admin.btn_Aceptar.setActionCommand("btn_Aceptar");
            Create_Admin.btn_Aceptar.addActionListener(this);
            
            Create_Admin.btn_cancelar.setActionCommand("btn_cancelar");
            Create_Admin.btn_cancelar.addActionListener(this);
            
            Create_Admin.btnAvatar.setActionCommand("btnAvatar");
            Create_Admin.btnAvatar.addActionListener(this);
            
            Create_Admin.pick_date_birth.setName("pick_date_birth");
            Create_Admin.pick_date_birth.addPropertyChangeListener(this);
            
            Create_Admin.pick_date_contr.setName("pick_date_contr");
            Create_Admin.pick_date_contr.addPropertyChangeListener(this);
            
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

            // Conjunto de teclas que queremos que sirvan para pasar el foco 
            // al siguiente campo de texto: ENTER y TAB
            Set<AWTKeyStroke> teclas = new HashSet<AWTKeyStroke>();
            teclas.add(AWTKeyStroke.getAWTKeyStroke(KeyEvent.VK_ENTER, 0));
            teclas.add(AWTKeyStroke.getAWTKeyStroke(
                    KeyEvent.VK_TAB, 0));
            
            Edit_Admin.panelRect1.setFocusTraversalKeys(
                    KeyboardFocusManager.FORWARD_TRAVERSAL_KEYS,
                    teclas);
            
            Edit_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Edit_Admin.dispose();
                }
            });
            
            Edit_Admin.btn_Aceptar.setActionCommand("btn_Aceptar_e");
            Edit_Admin.btn_Aceptar.addActionListener(this);
            
            Edit_Admin.btn_Cancelar.setActionCommand("btn_cancelar_e");
            Edit_Admin.btn_Cancelar.addActionListener(this);
            
            Edit_Admin.btnAvatar.setActionCommand("btnAvatar_e");
            Edit_Admin.btnAvatar.addActionListener(this);
            
            Edit_Admin.pick_date_birth.setName("pick_date_birth_e");
            Edit_Admin.pick_date_birth.addPropertyChangeListener(this);
            
            Edit_Admin.pick_date_contr.setName("pick_date_contr_e");
            Edit_Admin.pick_date_contr.addPropertyChangeListener(this);
            
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
            
            Show_Admin.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    Show_Admin.dispose();
                }
            });
            
            Show_Admin.btnAcept.setActionCommand("btnAccept_s");
            Show_Admin.btnAcept.addActionListener(this);
        }
    }
    
    public void actionPerformed(ActionEvent ae) {
        switch (Action_Admin.valueOf(ae.getActionCommand())) {
            
            case btn_Config:
                
                break;
            case btn_Volver:
                
                break;
            case btn_ges_inst:
                
                break;
            case btn_ges_averias:
                
                break;
            case btnAdd_admin:
                
                break;
            case btnEditar_admin:
                
                break;
            case btnBorrar_admin:
                
                break;
            case btnMostrar_admin:
                
                break;
            case btn_delete_all:
                
                break;
            case btn_Volver_table:
                
                break;
            case ANTERIOR:
                
                break;
            case SIGUIENTE:
                
                break;
            case primero:
                
                break;
            case ultimo:
                
                break;
            case jComboBox1:
                
                break;
            case btn_Aceptar:
                
                break;
            case btn_cancelar:
                
                break;
            case btnAvatar:
                
                break;
            case btn_Aceptar_e:
                
                break;
            case btn_cancelar_e:
                
                break;
            case btnAvatar_e:
                
                break;
            case btnAccept_s:
                
                break;
            
        }
        
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent ch) {
        
        switch (Action_Admin.valueOf(ch.getPropertyName())) {
            
            case pick_date_birth:
                
                break;
            case pick_date_contr:
                
                break;
            case pick_date_birth_e:
                
                break;
            case pick_date_contr_e:
                
                break;
            
        }
        
    }
    
    public void KeyReleased(KeyEvent et) {
        
        switch (Action_Admin.valueOf(et.getComponent().getName())) {
            
            case txtDni:
                
                break;
            case txtEmail:
                
                break;
            case txtLast_name:
                
                break;
            case txtMobile:
                
                break;
            case txtName:
                
                break;
            case txtPassword:
                
                break;
            case txtSalary:
                
                break;
            case txtUser:
                
                break;
            case txtActivity:
                
                break;
            case txtActivity_e:
                
                break;
            case txtEmail_e:
                
                break;
            case txtLast_name_e:
                
                break;
            case txtMobile_e:
                
                break;
            case txtName_e:
                
                break;
            case txtPassword_e:
                
                break;
            case txtSalary_e:
                
                break;
            case txtUser_e:
                
                break;
        }
        
    }
    
    public void KeyReleased(MouseEvent m) {
        
        switch (Action_Admin.valueOf(m.getComponent().getName())) {
            
            case mini_Table_Admin:
                
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
