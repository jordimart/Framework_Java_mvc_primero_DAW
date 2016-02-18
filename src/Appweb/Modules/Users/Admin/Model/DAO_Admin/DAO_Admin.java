/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Users.Admin.Model.DAO_Admin;

import Appweb.Classes.Date.ClassDate;
import Appweb.Modules.Users.Admin.View.create_Admin;
import static Appweb.Modules.Users.Admin.View.create_Admin.labAvatar_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin.txtActivity_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin.txtDni_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin.txtEmail_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin.txtLast_name_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin.txtMobile_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin.txtName_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin.txtPassword_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin.txtSalary_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin.txtUser_create_admin;
import Appweb.Modules.Users.model.BLL.Look_for_dni;
import Appweb.Modules.Users.model.Classes.Admin;
import static Appweb.Modules.Users.model.Users_tools.Core_users.real_dni;
import Appweb.Tools.Date_tools;
import static Appweb.Tools.Date_tools.Date_min_max_condition_boolean;
import static Appweb.Tools.Date_tools.Date_registered_boolean;
import Appweb.Tools.Validate;
import java.awt.Color;
import java.util.Calendar;

/**
 *
 * @author ASUSG50V
 */
public class DAO_Admin {
    
    /**
     * Fucion que valida que el dni pueda existir.Pero ademas comprueba que no
     * este repetido en los Admin.Implementada en grafica para validar etiqueta
     * de color.
     *
     * @return boolean ok.
     */
    public static boolean Enterdnia() {

        String dni = "";
        boolean ok = false;
        int pos = -1;

        dni = create_Admin.txtDni_create_admin.getText().toString();
        dni = dni.toUpperCase();
        ok = Validate.okdni(dni);

        if (ok == false) {
            create_Admin.labDni_create_admin.setText("wrong data");
            create_Admin.txtDni_create_admin.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {

            pos = Look_for_dni.Look_for_dni_admin(dni);
            if (real_dni(dni) != true) {

                ok = false;
                create_Admin.labDni_create_admin.setText("wrong data");
                create_Admin.txtDni_create_admin.setBackground(Color.RED);
                //JOptionPane.showMessageDialog(null,
                //Lang.getInstance().getProperty("You_can_not_repeat_dni"));
            } else {
                pos = Look_for_dni.Look_for_dni_admin(dni);

                if (pos != -1) {
                    ok = false;
                    create_Admin.labDni_create_admin.setText("wrong data");
                    create_Admin.txtDni_create_admin.setBackground(Color.RED);

                } else {

                    ok = true;
                    create_Admin.labDni_create_admin.setText("ok");
                    create_Admin.txtDni_create_admin.setBackground(Color.GREEN);
                }
            }

        }
        return ok;
    }

    public static boolean Entername_admin() {

        boolean ok = false;
        String name = create_Admin.txtName_create_admin.getText().toString();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Admin.labName_create_admin.setText("wrong data");
            create_Admin.txtName_create_admin.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labName_create_admin.setText("ok");
            create_Admin.txtName_create_admin.setBackground(Color.GREEN);

        }

        return ok;
    }

    public static boolean Enterlast_name_admin() {

        boolean ok = false;
        String name = create_Admin.txtName_create_admin.getText().toString();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Admin.labLast_name_create_admin.setText("wrong data");
            create_Admin.txtLast_name_create_admin.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labLast_name_create_admin.setText("ok");
            create_Admin.txtLast_name_create_admin.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pise un numero de telefono movil con nueve digitos.
     *
     * @return string movil
     */
    public static boolean Entermobile_admin() {

        String s = "";
        boolean ok = false;

        s = create_Admin.txtMobile_create_admin.getText();
        ok = Validate.okmobile(s);
        if (ok == false) {
            create_Admin.labMobile_create_admin.setText("wrong data");
            create_Admin.txtMobile_create_admin.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labMobile_create_admin.setText("ok");
            create_Admin.txtMobile_create_admin.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide un email y valida su formato.
     *
     * @return
     */
    public static boolean Entermail_admin() {

        String cad = "";
        boolean ok = false;

        cad = create_Admin.txtEmail_create_admin.getText();
        ok = Validate.okmail(cad);
        if (ok == false) {
            create_Admin.labEmail_create_admin.setText("wrong data");
            create_Admin.txtEmail_create_admin.setBackground(Color.red);

            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labEmail_create_admin.setText("ok");
            create_Admin.txtEmail_create_admin.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean Enteruser_admin() {

        String cad = "";
        boolean ok = false;

        cad = create_Admin.txtUser_create_admin.getText();
        ok = Validate.okwordfull(cad);
        if (ok == false) {
            create_Admin.labUser_create_admin.setText("wrong data");
            create_Admin.txtUser_create_admin.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labUser_create_admin.setText("ok");
            create_Admin.txtUser_create_admin.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean Enterpassword_admin() {

        String cad = "";
        boolean ok = false;

        cad = create_Admin.txtPassword_create_admin.getPassword().toString();
        ok = Validate.okwordfull(cad);
        if (ok == false) {
            create_Admin.labPassword_create_admin.setText("wrong data");
            create_Admin.txtPassword_create_admin.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labPassword_create_admin.setText("ok");
            create_Admin.txtPassword_create_admin.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean Entersalary_admin() {

        String s = "";
        float sal = 0.0f;

        boolean ok = false;

        s = create_Admin.txtSalary_create_admin.getText();

        sal = Float.parseFloat(s);

        if ((sal > 800) && (sal < 2500)) {
            create_Admin.labSalary_create_admin.setText("ok");
            create_Admin.txtSalary_create_admin.setBackground(Color.GREEN);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin.labSalary_create_admin.setText("wrong data");
            create_Admin.txtSalary_create_admin.setBackground(Color.RED);
        }

        return ok;
    }

    public static boolean Enteractivity_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;

        s = create_Admin.txtActivity_create_admin.getText();
        act = Integer.parseInt(s);

        if ((act > 0) && (act < 100)) {
            create_Admin.labActivity_create_admin.setText("ok");
            create_Admin.txtActivity_create_admin.setBackground(Color.GREEN);
        } else {

            create_Admin.labActivity_create_admin.setText("wrong data");
            create_Admin.txtActivity_create_admin.setBackground(Color.red);
        }

        return ok;
    }

    public static boolean Enterdate_birth_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_Admin.pick_date_birth_create_admin.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        ClassDate c = new ClassDate(dia,mes,anio);
        
        s = c.todate();
       ok= Date_min_max_condition_boolean(s, 16, 65);

        if(ok==false){
            create_Admin.pick_date_birth_create_admin.setBackground(Color.red);
            create_Admin.labDate_birth_create_admin.setText("wrong data");
            
        }else{
            create_Admin.pick_date_birth_create_admin.setBackground(Color.GREEN);
            create_Admin.labDate_birth_create_admin.setText("ok");
        }

        return ok;
    }
    
    public static boolean Enterdate_contr_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;
        Calendar date_birth;
        Calendar date_contr;
        int dia = 0, mes = 0, anio = 0;
        int diac = 0, mesc = 0, anioc = 0;

        date_birth = create_Admin.pick_date_birth_create_admin.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        ClassDate birth = new ClassDate(dia,mes,anio);
        s = birth.todate();
        
         date_contr = create_Admin.pick_date_contr_create_admin.getCalendar();

        diac = date_contr.get(Calendar.DATE);
        mesc = date_contr.get(Calendar.MONTH) + 1;
        anioc = date_contr.get(Calendar.YEAR);

        ClassDate contr = new ClassDate(diac,mesc,anioc);
        //s = contr.todate();
        
       ok= Date_registered_boolean(contr,s, 16);

        if(ok==false){
            create_Admin.pick_date_contr_create_admin.setBackground(Color.red);
            create_Admin.labDate_contr_create_admin.setText("wrong data");
            
        }else{
            create_Admin.pick_date_contr_create_admin.setBackground(Color.GREEN);
            create_Admin.labDate_contr_create_admin.setText("ok");
        }

        return ok;
    }
    
     /**
     * Admin request claim Admins attributes and Users.
     *
     * @param datef string date format)
     * @param language string language
     *
     * @return object Admin
     */
    public static Admin Adminrequest() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", Avatar = "";
        ClassDate date_cont = null;
        String Status = "";
        int activity = 0;
        float salary = 0.000f;
        ClassDate Date_birth = null;

        // Enter User atributtes
        Dni = txtDni_create_admin.getText().toString();

        Name = txtName_create_admin.getText().toString();
        Last_name = txtLast_name_create_admin.getText().toString();
        Mobile = txtMobile_create_admin.getText().toString();
        Date_birth = Date_tools.Date_min_max_condition(16, 65);
        Email = txtEmail_create_admin.getText().toString();
        User = txtUser_create_admin.getText().toString();
        Password = txtPassword_create_admin.getPassword().toString();
        Avatar = labAvatar_create_admin.getText().toString();
        Status = create_Admin.comboStatus_create_admin.getSelectedItem().toString();

        // Enter Admin attributes
        date_cont = Date_tools.Date_registered(Date_birth, 16);
        salary = Float.parseFloat(txtSalary_create_admin.getText().toString());
        activity = Integer.parseInt(txtActivity_create_admin.getText().toString());

        return new Admin(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_cont, salary, activity);
    }
    
}
