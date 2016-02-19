/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Users.Admin.Model.DAO_Admin;

import Appweb.Classes.Date.ClassDate;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin;
import Appweb.Modules.Users.Admin.View.create_Admin_view;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.labAvatar_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtActivity_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtDni_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtEmail_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtLast_name_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtMobile_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtName_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtPassword_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtSalary_create_admin;
import static Appweb.Modules.Users.Admin.View.create_Admin_view.txtUser_create_admin;
import Appweb.Modules.Users.model.Classes.Admin;
import static Appweb.Modules.Users.model.Classes.singleton.mal;
import static Appweb.Tools.Date_tools.Date_min_max_condition_boolean;
import static Appweb.Tools.Date_tools.Date_registered_boolean;
import Appweb.Tools.Validate;
import java.awt.Color;
import java.awt.Image;
import java.util.Arrays;
import java.util.Calendar;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    public static boolean booleanEnterdnia() {

        String dni = "";
        boolean ok = false;
        int pos = -1;
        int num = 0, rest = 0;
        char letter = ' ', pass = ' ';
        String aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";

        aux = "";

        dni = create_Admin_view.txtDni_create_admin.getText();
        dni = dni.toUpperCase();
        ok = Validate.okdni(dni);

        if (ok == false) {
            create_Admin_view.labDni_create_admin.setIcon(mal);

            create_Admin_view.txtDni_create_admin.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {

            for (int i = 0; i < 8; i++) {
                aux += dni.charAt(i);

            }

            letter = dni.charAt(8);
            num = Integer.parseInt(aux);
            rest = num % 23;
            pass = car.charAt(rest);

            if (pass == letter) {
                ok = true;
            }

                if (ok != true) {

                    ok = false;
                    create_Admin_view.labDni_create_admin.setIcon(mal);
                    create_Admin_view.txtDni_create_admin.setBackground(Color.RED);
                    //JOptionPane.showMessageDialog(null,
                    //Lang.getInstance().getProperty("You_can_not_repeat_dni"));
                } else {
                    pos = BLL_Admin.Look_for_dni_admin(dni);

                    if (pos != -1) {
                        ok = false;
                        create_Admin_view.labDni_create_admin.setIcon(mal);
                        create_Admin_view.txtDni_create_admin.setBackground(Color.RED);

                    } else {

                        ok = true;
                        create_Admin_view.labDni_create_admin.setText("ok");
                        create_Admin_view.txtDni_create_admin.setBackground(Color.GREEN);
                    }
                }

            }
            return ok;
        }

    

    public static boolean booleanEntername_admin() {

        boolean ok = false;
        String name = create_Admin_view.txtName_create_admin.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Admin_view.labName_create_admin.setIcon(mal);
            create_Admin_view.txtName_create_admin.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labName_create_admin.setText("ok");
            create_Admin_view.txtName_create_admin.setBackground(Color.GREEN);

        }

        return ok;
    }

    public static boolean booleanEnterlast_name_admin() {

        boolean ok = false;
        String name = create_Admin_view.txtName_create_admin.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Admin_view.labLast_name_create_admin.setIcon(mal);
            create_Admin_view.txtLast_name_create_admin.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labLast_name_create_admin.setText("ok");
            create_Admin_view.txtLast_name_create_admin.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pise un numero de telefono movil con nueve digitos.
     *
     * @return string movil
     */
    public static boolean booleanEntermobile_admin() {

        String s = "";
        boolean ok = false;

        s = create_Admin_view.txtMobile_create_admin.getText();
        ok = Validate.okmobile(s);
        if (ok == false) {
            create_Admin_view.labMobile_create_admin.setIcon(mal);
            create_Admin_view.txtMobile_create_admin.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labMobile_create_admin.setText("ok");
            create_Admin_view.txtMobile_create_admin.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide un email y valida su formato.
     *
     * @return
     */
    public static boolean booleanEntermail_admin() {

        String cad = "";
        boolean ok = false;

        cad = create_Admin_view.txtEmail_create_admin.getText();
        ok = Validate.okmail(cad);
        if (ok == false) {
            create_Admin_view.labEmail_create_admin.setIcon(mal);
            create_Admin_view.txtEmail_create_admin.setBackground(Color.red);

            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labEmail_create_admin.setText("ok");
            create_Admin_view.txtEmail_create_admin.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEnteruser_admin() {

        String cad = "";
        boolean ok = false;

        cad = create_Admin_view.txtUser_create_admin.getText();
        ok = Validate.okwordfull(cad);
        if (ok == false) {
            create_Admin_view.labUser_create_admin.setIcon(mal);
            create_Admin_view.txtUser_create_admin.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labUser_create_admin.setText("ok");
            create_Admin_view.txtUser_create_admin.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEnterpassword_admin() {

        String cad = "";
        boolean ok = false;

        cad = Arrays.toString(create_Admin_view.txtPassword_create_admin.getPassword());
        ok = Validate.okwordfull(cad);
        if (ok == false) {
            create_Admin_view.labPassword_create_admin.setIcon(mal);
            create_Admin_view.txtPassword_create_admin.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labPassword_create_admin.setText("ok");
            create_Admin_view.txtPassword_create_admin.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEntersalary_admin() {

        String s = "";
        float sal = 0.0f;

        boolean ok = false;

        s = create_Admin_view.txtSalary_create_admin.getText();

        sal = Float.parseFloat(s);

        if ((sal > 800) && (sal < 2500)) {
            ok = true;
            create_Admin_view.labSalary_create_admin.setText("ok");
            create_Admin_view.txtSalary_create_admin.setBackground(Color.GREEN);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labSalary_create_admin.setText("wrong data");
            create_Admin_view.txtSalary_create_admin.setBackground(Color.RED);
        }

        return ok;
    }

    public static boolean booleanEnteractivity_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;

        s = create_Admin_view.txtActivity_create_admin.getText();
        act = Integer.parseInt(s);

        if ((act > 0) && (act < 100)) {
            ok = true;
            create_Admin_view.labActivity_create_admin.setText("ok");
            create_Admin_view.txtActivity_create_admin.setBackground(Color.GREEN);
        } else {

            create_Admin_view.labActivity_create_admin.setText("wrong data");
            create_Admin_view.txtActivity_create_admin.setBackground(Color.red);
        }

        return ok;
    }

    public static boolean booleanEnterdate_birth_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_Admin_view.pick_date_birth_create_admin.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        ClassDate c = new ClassDate(dia, mes, anio);

        s = c.todate();
        ok = Date_min_max_condition_boolean(s, 16, 65);

        if (ok == false) {
            create_Admin_view.pick_date_birth_create_admin.setBackground(Color.red);
            create_Admin_view.labDate_birth_create_admin.setText("wrong data");

        } else {
            create_Admin_view.pick_date_birth_create_admin.setBackground(Color.GREEN);
            create_Admin_view.labDate_birth_create_admin.setText("ok");
        }

        return ok;
    }

    public static boolean booleanEnterdate_contr_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;
        Calendar date_birth;
        Calendar date_contr;
        int dia = 0, mes = 0, anio = 0;
        int diac = 0, mesc = 0, anioc = 0;

        date_birth = create_Admin_view.pick_date_birth_create_admin.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        ClassDate birth = new ClassDate(dia, mes, anio);
        s = birth.todate();

        date_contr = create_Admin_view.pick_date_contr_create_admin.getCalendar();

        diac = date_contr.get(Calendar.DATE);
        mesc = date_contr.get(Calendar.MONTH) + 1;
        anioc = date_contr.get(Calendar.YEAR);

        ClassDate contr = new ClassDate(diac, mesc, anioc);
        //s = contr.todate();

        ok = Date_registered_boolean(contr, s, 16);

        if (ok == false) {
            create_Admin_view.pick_date_contr_create_admin.setBackground(Color.red);
            create_Admin_view.labDate_contr_create_admin.setText("wrong data");

        } else {
            create_Admin_view.pick_date_contr_create_admin.setBackground(Color.GREEN);
            create_Admin_view.labDate_contr_create_admin.setText("ok");
        }

        return ok;
    }

    public static ClassDate Enter_date_birth_admin() {

        String date = "";
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_Admin_view.pick_date_birth_create_admin.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        ClassDate c = new ClassDate(dia, mes, anio);
        date = c.todate();

        return new ClassDate(date);
    }

    public static ClassDate Enter_date_cntr_admin() {

        String date = "";
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_Admin_view.pick_date_contr_create_admin.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        ClassDate c = new ClassDate(dia, mes, anio);
        date = c.todate();

        return new ClassDate(date);
    }

    public static void EnterAvatar_admin() {

        JFileChooser dlg = new JFileChooser();
        dlg.setAcceptAllFileFilterUsed(false);
        dlg.addChoosableFileFilter(new FileNameExtensionFilter("JPG (*.jpg)", "jpg"));
        int option = dlg.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = dlg.getSelectedFile().getPath();
            labAvatar_create_admin.setIcon(new ImageIcon(file));
            //Modificando la imagen
            ImageIcon icon = new ImageIcon(file);
            //Se extrae la imagen del icono
            Image img = icon.getImage();
            //Se modifica su tamaño
            Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            //Se coloca el nuevo icono modificado
            labAvatar_create_admin.setIcon(newIcon);
            //Se cambia el tamaño de la etiqueta
            labAvatar_create_admin.setSize(470, 290);
        }
    }

    public static Admin create_Admin() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
        ClassDate date_cont = null;
        String Status = "";
        int activity = 0;
        float salary = 0.000f;
        ClassDate Date_birth = null;
        char[] password = txtPassword_create_admin.getPassword();
        Admin a = null;
        Icon Avatar = null;

        boolean pass, pass1, pass2, pass3, pass4, pass5, pass6, pass7, pass8, pass9, pass10;

        pass = booleanEnterdnia();
        pass1 = booleanEntername_admin();
        pass2 = booleanEnterlast_name_admin();
        pass3 = booleanEntermobile_admin();
        pass4 = booleanEntermail_admin();
        pass5 = booleanEnteruser_admin();
        pass6 = booleanEnterpassword_admin();
        pass7 = booleanEntersalary_admin();
        pass8 = booleanEnteractivity_admin();
        pass9 = booleanEnterdate_birth_admin();
        pass10 = booleanEnterdate_contr_admin();

        if (pass == true && pass1 == true && pass2 == true && pass3 == true && pass4 == true && pass5 == true && pass6 == true && pass7 == true && pass8 == true && pass9 == true && pass10 == true) {
            // Enter User atributtes
            Dni = txtDni_create_admin.getText();
            Name = txtName_create_admin.getText();
            Last_name = txtLast_name_create_admin.getText();
            Mobile = txtMobile_create_admin.getText();
            Date_birth = Enter_date_birth_admin();
            Email = txtEmail_create_admin.getText();
            User = txtUser_create_admin.getText();
            Password = new String(password);
            Avatar = labAvatar_create_admin.getIcon();
            Status = create_Admin_view.comboStatus_create_admin.getSelectedItem().toString();
            // Enter Admin attributes
            date_cont = Enter_date_cntr_admin();
            salary = Float.parseFloat(txtSalary_create_admin.getText());
            activity = Integer.parseInt(txtActivity_create_admin.getText());

            a = new Admin(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_cont, salary, activity);
        } else {
            a = null;
        }
        return a;
    }
}
