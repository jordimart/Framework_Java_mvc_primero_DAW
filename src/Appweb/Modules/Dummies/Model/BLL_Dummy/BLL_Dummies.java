/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Dummies.Model.BLL_Dummy;

import Appweb.Classes.Language.Lang;
import Appweb.Modules.Dummies.Model.DAO_Dummy.Dummy_tools;
import Appweb.Modules.Dummies.View.task_Dummy_view;
import Appweb.Modules.Users.Classes.Admin;
import Appweb.Modules.Users.Classes.singleton;
import Appweb.Modules.Users.Users_tools.User_files.json;

/**
 *
 * @author ASUSG50V
 */
public class BLL_Dummies {
    
     public static void Dummy_admin() {
        Admin a = null;

        String combo = (String) task_Dummy_view.comboDummy_admin.getSelectedItem();
        //

        if (combo.equals(Lang.getInstance().getProperty("Upload_files"))) {

            json.auto_open_json_file_dummy();
            
            

        } else {
            int num = Integer.parseInt(combo);

            for (int j = 0; j < num; j++) {

                try {

                    a = Dummy_tools.Dummyadmin();
                    singleton.Admin_array.add(a);
                    

                } catch (Exception e) {
                    e.printStackTrace();
                    task_Dummy_view.labStatus_dummie_admin.setText(Lang.getInstance().getProperty("Error_loading_dummies"));
                    //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Error_loading_dummies"), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            json.auto_save_json_file_dummy_admin();

        }
    }
    
}
