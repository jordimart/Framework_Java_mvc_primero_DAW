/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Main.Controller;

import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Config.View.menu_Settings;
import Appweb.Modules.Main.Model.Dummies.View.task_Dummy_view;
import Appweb.Modules.Main.View.Menu_entrada;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
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

    public static Menu_entrada Login = new Menu_entrada();
    public static menu_Settings Settings = new menu_Settings();
    public static task_Dummy_view Dummies = new task_Dummy_view();

    public ControllerMain(JFrame start, int i) {

        if (i == 0) {
            Login = (Menu_entrada) start;
        }
        if (i == 1) {
            Settings = (menu_Settings) start;
        }
        if (i == 2) {
            Dummies = (task_Dummy_view) start;
        }
    }

    public enum Action {

        //botones de cambio de vista//
        btnAdminlogin,
        // btnClientlogin,
        // btnUser_reglogin,
        btnTestlogin,
        btnSettings
    }

    public void start(int i) {
        if (i == 0) {

            Login.setTitle("Menu Login");
            Login.setLocationRelativeTo(null);
            Login.setSize(1000, 650);//ancho x alto
            Login.setExtendedState(JFrame.MAXIMIZED_BOTH);

            Login.Login_Admin.setActionCommand("btnAdminlogin");
            Login.Login_Admin.addActionListener(this);
            
            Login.btnSettings.setActionCommand("btnSettings");
            Login.btnSettings.addActionListener(this);
            
            Login.btn_Test.setActionCommand("btnTestlogin");
            Login.btn_Test.addActionListener(this);
            
            
            
            Login.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                            JOptionPane.INFORMATION_MESSAGE);

                    System.exit(0);
                }
            });
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
