
package Appweb.Modules.Users.Admin.Model.BLL_Admin;

import Appweb.Classes.Language.Lang;
import Appweb.Modules.Users.Admin.Model.DAO_Admin.DAO_Admin;
import Appweb.Modules.Users.Admin.View.create_Admin_view;
import Appweb.Modules.Users.Admin.View.edit_Admin;
import Appweb.Modules.Users.Admin.View.table_Admin;
import Appweb.Modules.Users.model.BLL.Look_for_dni;
import Appweb.Modules.Users.model.Classes.Admin;
import Appweb.Modules.Users.model.Classes.singleton;
import Appweb.Modules.Users.model.DAO.Dao_users;
import Appweb.Tools.Menu;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author ASUSG50V
 */
public class BLL_Admin {
    
    public static void Enterdni_admin() {
        DAO_Admin.booleanEnterdnia();
    }
    
    public static void Entername_admin() {
        DAO_Admin.booleanEntername_admin();
    }
    
    public static void Enterlast_name_admin() {
        DAO_Admin.booleanEnterlast_name_admin();
    }
    
    public static void Entermobile_admin() {
        DAO_Admin.booleanEntermobile_admin();
    }
    
    public static void Entermail_admin() {
        DAO_Admin.booleanEntermail_admin();
    }
    
    public static void Enteruser_admin() {
        DAO_Admin.booleanEnteruser_admin();
    }
    
    public static void Enterpassword_admin() {
        DAO_Admin.booleanEnterpassword_admin();
    }
    
    public static void Entersalary_admin() {
        DAO_Admin.booleanEntersalary_admin();
    }
    
    public static void Enteractivity_admin() {
        DAO_Admin.booleanEnteractivity_admin();
        
    }
    
    public static void Enterdate_birth_admin() {
        DAO_Admin.booleanEnterdate_birth_admin();
    }
    
    public static void Enterdate_contr_admin() {
        DAO_Admin.booleanEnterdate_contr_admin();
    }
    
    public static boolean Enter_new_admin() {
        
        
        boolean ok = false;
        
       Admin a = DAO_Admin.create_Admin();
        //JOptionPane.showMessageDialog(null, a.toString());
        if (a != null) {
            singleton.Admin_array.add(a);
            JOptionPane.showMessageDialog(null, "Usuario añadidio");
            ok = true;
        } else {
            
            JOptionPane.showMessageDialog(null, "Revise los datos, no puede guardar si hay algun dato incorrecto");
        }
        return ok;
    }

    /**
     * Imprime un usuario seleccionado admin
     */
    public static void Print_select_admin() {
        
        Admin a;
        String s = " ";
        String dni = "";
        int pos = 0;
        int n = singleton.Admin_array.size();
        String cli[] = new String[n];
        
        if (singleton.Admin_array.size() != 0) {
            for (int i = 0; i < n; i++) {
                a = (Admin) singleton.Admin_array.get(i);
                s = a.getDni() + " - " + a.getName() + " " + a.getLast_name();
                cli[i] = s;
            }
            String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));
            
            for (int j = 0; j < 9; j++) {
                
                dni += se.charAt(j);
            }
            
            pos = Look_for_dni_admin(dni);
            
            JOptionPane.showMessageDialog(null, singleton.Admin_array.get(pos));
            
        } else {
            
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_administrator_type"));
        }
    }

    /**
     * Busca un dni introducido en una arraylist Admin y nos devuelve la
     * posicion.
     *
     * @param dni (string)
     * @return pos (int posicion en el array)
     */
    public static int Look_for_dni_admin(String dni) {
        
        int pos = -1;
        
        for (int i = 0; i < singleton.Admin_array.size(); i++) {
            
            if (singleton.Admin_array.get(i).getDni().equals(dni)) {
                pos = i;
            }
            
        }
        
        return pos;
        
    }

    /**
     * Modifica un usuario seleccionado admin
     */
    public static void Modify_select_admin() {
        
        Admin a;
        String s = " ";
        String dni = "";
        int pos = 0;
        int n = singleton.Admin_array.size();
        String cli[] = new String[n];
        if (singleton.Admin_array.size() != 0) {
            for (int i = 0; i < n; i++) {
                a = (Admin) singleton.Admin_array.get(i);
                s = a.getDni() + " - " + a.getName() + " " + a.getLast_name();
                cli[i] = s;
            }
            String se = Menu.Menu_carga_array(cli, Lang.getInstance().getProperty("Select_user"));
            
            for (int j = 0; j < 9; j++) {
                
                dni += se.charAt(j);
            }
            
            pos = Look_for_dni_admin(dni);
            
            new edit_Admin(pos).setVisible(true);
            
        } else {
            
            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("There_are_elements_of_administrator_type"));
            new table_Admin().setVisible(true);
        }
        
    }
}
