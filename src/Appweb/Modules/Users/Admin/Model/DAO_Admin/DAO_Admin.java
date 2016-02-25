/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Users.Admin.Model.DAO_Admin;

import Appweb.Classes.Date.ClassDate;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin;
import Appweb.Modules.Users.Admin.View.create_Admin_view;
import Appweb.Modules.Users.Classes.Admin;
import static Appweb.General_tools.Date_tools.Date_min_max_condition_boolean;
import static Appweb.General_tools.Date_tools.Date_registered_boolean;
import Appweb.General_tools.Validate;
import Appweb.General_tools.singletonapp;
import static Appweb.General_tools.singletonapp.good_data;
import static Appweb.General_tools.singletonapp.pos;
import static Appweb.General_tools.singletonapp.wrong_data;
import Appweb.Modules.Users.Admin.View.edit_Admin_view;
import Appweb.Modules.Users.Admin.View.show_Admin_view;
import Appweb.Modules.Users.Classes.singleton;
import java.awt.Color;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import Appweb.Modules.Users.Users_tools.User_files.json;
import com.toedter.calendar.JTextFieldDateEditor;
import java.io.File;
import javax.swing.JOptionPane;

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

        dni = create_Admin_view.txtDni.getText();
        dni = dni.toUpperCase();
        ok = Validate.okdni(dni);

        if (ok == false) {

            create_Admin_view.labDni.setIcon(wrong_data);
            create_Admin_view.labDni.setToolTipText("No has introducido los datos correctamente");
            create_Admin_view.txtDni.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {

            ok = true;
            for (int i = 0; i < 8; i++) {
                aux += dni.charAt(i);

            }

            num = Integer.parseInt(aux);
            rest = num % 23;
            pass = car.charAt(rest);

            letter = dni.charAt(8);

            if (pass == letter) {
                ok = true;

                pos = BLL_Admin.Look_for_dni_admin(dni);

                if (pos != -1) {
                    ok = false;
                    create_Admin_view.labDni.setIcon(wrong_data);
                    create_Admin_view.txtDni.setBackground(Color.RED);
                    create_Admin_view.labDni.setToolTipText("Ya existe este Dni en la base de datos");
                    //JOptionPane.showMessageDialog(null,
                    //Lang.getInstance().getProperty("You_can_not_repeat_dni"));
                } else {

                    ok = true;
                    create_Admin_view.labDni.setIcon(good_data);
                    create_Admin_view.txtDni.setBackground(Color.GREEN);
                }

            } else {
                ok = false;
                create_Admin_view.labDni.setToolTipText("El Dni introducido no existe");
                create_Admin_view.labDni.setIcon(wrong_data);
                create_Admin_view.txtDni.setBackground(Color.RED);

            }

        }
        return ok;
    }

    public static boolean booleanEntername_admin() {

        boolean ok = false;
        String name = create_Admin_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Admin_view.labName.setIcon(wrong_data);
            create_Admin_view.txtName.setBackground(Color.red);
            create_Admin_view.labName.setToolTipText("No ha introducido los datos correctamente");
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labName.setIcon(good_data);
            create_Admin_view.txtName.setBackground(Color.GREEN);

        }

        return ok;
    }

    public static boolean booleanEnterlast_name_admin() {

        boolean ok = false;
        String name = create_Admin_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Admin_view.labLast_name.setIcon(wrong_data);
            create_Admin_view.txtLast_name.setBackground(Color.red);
            create_Admin_view.labLast_name.setToolTipText("No ha introducido los datos correctamente");
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labLast_name.setIcon(good_data);
            create_Admin_view.txtLast_name.setBackground(Color.GREEN);

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

        s = create_Admin_view.txtMobile.getText();
        ok = Validate.okmobile(s);
        if (ok == false) {
            create_Admin_view.labMobile.setIcon(wrong_data);
            create_Admin_view.txtMobile.setBackground(Color.red);
            create_Admin_view.labMobile.setToolTipText("No ha introducido los datos correctamente, solo puede contener 9 numeros");
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labMobile.setIcon(good_data);
            create_Admin_view.txtMobile.setBackground(Color.GREEN);
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

        cad = create_Admin_view.txtEmail.getText();
        ok = Validate.okmail(cad);
        if (ok == false) {
            create_Admin_view.labEmail.setIcon(wrong_data);
            create_Admin_view.txtEmail.setBackground(Color.red);
            create_Admin_view.labEmail.setToolTipText("No ha introducido los datos correctamente,Ejemplo: xxxx@xxx.xxx");
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labEmail.setIcon(good_data);
            create_Admin_view.txtEmail.setBackground(Color.GREEN);

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

        cad = create_Admin_view.txtUser.getText();
        ok = Validate.okuser(cad);
        if (ok == false) {
            create_Admin_view.labUser.setIcon(wrong_data);
            create_Admin_view.txtUser.setBackground(Color.red);
            create_Admin_view.labUser.setToolTipText("No ha introducido los datos correctamente");
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            create_Admin_view.labUser.setIcon(good_data);
            create_Admin_view.txtUser.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEnterpassword_admin() {

        boolean ok = false;

        char passArray[] = create_Admin_view.txtPassword.getPassword();
        String cad = new String(passArray);

        ok = Validate.okpassword(cad);
        if (ok == false) {
            create_Admin_view.labPassword.setIcon(wrong_data);
            create_Admin_view.txtPassword.setBackground(Color.red);
            create_Admin_view.labPassword.setToolTipText("No ha introducido los datos correctamente,Debe contener mayusculas,numeros y letras");
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            create_Admin_view.labPassword.setIcon(good_data);
            create_Admin_view.txtPassword.setBackground(Color.GREEN);
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

        s = create_Admin_view.txtSalary.getText();

        if (Validate.oksalary(s) == true) {
            sal = Float.parseFloat(s);
            ok = true;

            if ((sal >= 800) && (sal <= 2500)) {
                ok = true;
                create_Admin_view.labSalary.setIcon(good_data);
                create_Admin_view.txtSalary.setBackground(Color.GREEN);

                // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
                //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            } else {
                ok = false;
                create_Admin_view.labSalary.setToolTipText("No ha introducido los datos correctamente,Debe estar comprendido entre 800 y 2500");
                create_Admin_view.labSalary.setIcon(wrong_data);
                create_Admin_view.txtSalary.setBackground(Color.RED);
            }
        } else {

            ok = false;
            create_Admin_view.labSalary.setToolTipText("No ha introducido los datos correctamente, quizas introdujo letras");
            create_Admin_view.labSalary.setIcon(wrong_data);
            create_Admin_view.txtSalary.setBackground(Color.RED);
        }

        return ok;
    }

    public static boolean booleanEnteractivity_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;

        s = create_Admin_view.txtActivity.getText();

        if (Validate.oksalary(s) == true) {

            act = Integer.parseInt(s);

            if ((act >= 0) && (act <= 100)) {
                ok = true;
                create_Admin_view.labActivity.setIcon(good_data);
                create_Admin_view.txtActivity.setBackground(Color.GREEN);
            } else {
                ok = false;
                create_Admin_view.labActivity.setToolTipText("No ha introducido los datos correctamente,Debe estar comprendido entre 0 y 100");
                create_Admin_view.labActivity.setIcon(wrong_data);
                create_Admin_view.txtActivity.setBackground(Color.red);
            }
        } else {
            create_Admin_view.labActivity.setToolTipText("No ha introducido los datos correctamente, quizas introdujo letras");
            create_Admin_view.labActivity.setIcon(wrong_data);
            create_Admin_view.txtActivity.setBackground(Color.RED);

        }
        return ok;
    }

    public static boolean booleanEnterdate_birth_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        s = ((JTextFieldDateEditor) create_Admin_view.pick_date_birth.getDateEditor()).getText();

        ok = Date_min_max_condition_boolean(s, 16, 65);

        if (ok == false) {

            create_Admin_view.pick_date_birth.setBackground(Color.red);
            create_Admin_view.pick_date_birth.setIcon(wrong_data);

        } else {
            create_Admin_view.pick_date_birth.setBackground(Color.GREEN);
            create_Admin_view.pick_date_birth.setIcon(good_data);
        }

        return ok;
    }

    public static boolean booleanEnterdate_contr_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;
        Calendar date_birth;
        String date_contr;
        int dia = 0, mes = 0, anio = 0;
        int diac = 0, mesc = 0, anioc = 0;

        s = ((JTextFieldDateEditor) create_Admin_view.pick_date_birth.getDateEditor()).getText();

        date_contr = ((JTextFieldDateEditor) create_Admin_view.pick_date_contr.getDateEditor()).getText();

        ClassDate contr = new ClassDate(date_contr);

        ok = Date_registered_boolean(contr, s, 16);

        if (ok == false) {
            create_Admin_view.pick_date_contr.setBackground(Color.red);
            create_Admin_view.pick_date_contr.setIcon(wrong_data);

        } else {
            create_Admin_view.pick_date_contr.setBackground(Color.GREEN);
            create_Admin_view.pick_date_contr.setIcon(good_data);
        }

        return ok;
    }

    public static ClassDate Enter_date_birth_admin() {

        String date = "";
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_Admin_view.pick_date_birth.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        return new ClassDate(dia, mes, anio);
    }

    public static ClassDate Enter_date_cntr_admin() {

        String date = "";
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_Admin_view.pick_date_contr.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        return new ClassDate(dia, mes, anio);
    }

    public static void EnterAvatar_admin() {

        JFileChooser dlg = new JFileChooser();
        dlg.setCurrentDirectory(new File("src/Appweb/Modules/Users/Img/Avatares/"));
        dlg.setAcceptAllFileFilterUsed(false);
        dlg.addChoosableFileFilter(new FileNameExtensionFilter("JPG (*.jpg)", "jpg"));
        int option = dlg.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = dlg.getSelectedFile().getPath();
            create_Admin_view.labAvatar.setIcon(new ImageIcon(file));
            //Modificando la imagen
            ImageIcon icon = new ImageIcon(file);
            //Se extrae la imagen del icono
            Image img = icon.getImage();
            //Se modifica su tamaño
            Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            //Se coloca el nuevo icono modificado
            create_Admin_view.labAvatar.setIcon(newIcon);
            //Se cambia el tamaño de la etiqueta
            create_Admin_view.labAvatar.setSize(470, 290);
            create_Admin_view.labAvatar.setToolTipText(file);
        }
    }

    public static Admin add_create_Admin() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
        ClassDate date_cont = null;
        String Status = "";
        int activity = 0;
        float salary = 0.000f;
        ClassDate Date_birth = null;
        char[] password = create_Admin_view.txtPassword.getPassword();
        Admin a = null;
        String Avatar = null;

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
            Dni = create_Admin_view.txtDni.getText();
            Name = create_Admin_view.txtName.getText();
            Last_name = create_Admin_view.txtLast_name.getText();
            Mobile = create_Admin_view.txtMobile.getText();
            Date_birth = Enter_date_birth_admin();
            Email = create_Admin_view.txtEmail.getText();
            User = create_Admin_view.txtUser.getText();
            Password = new String(password);
            Avatar = create_Admin_view.labAvatar.getToolTipText();
            Status = create_Admin_view.comboStatus.getSelectedItem().toString();
            // Enter Admin attributes
            date_cont = Enter_date_cntr_admin();
            salary = Float.parseFloat(create_Admin_view.txtSalary.getText());
            activity = Integer.parseInt(create_Admin_view.txtActivity.getText());

            a = new Admin(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_cont, salary, activity);
        } else {
            a = null;
        }
        return a;
    }

    //////////////Daos para la ventana de editar Admin ////////
    public static void Load_edit_admin() {

        Admin a = singleton.Admin_array.get(singletonapp.pos);

        Float sal = a.getSalary();
        int act = a.getActivity();
        ClassDate date_birth = new ClassDate(a.getDate_birth().todate());
        ClassDate date_cont = new ClassDate(a.getDate_cont().todate());

        edit_Admin_view.txtDni.setText(a.getDni());
        edit_Admin_view.txtName.setText(a.getName());
        edit_Admin_view.txtLast_name.setText(a.getLast_name());
        edit_Admin_view.txtMobile.setText(a.getMobile());
        edit_Admin_view.pick_date_birth.setCalendar(date_birth.string_to_cal());
        edit_Admin_view.txtEmail.setText(a.getEmail());
        edit_Admin_view.txtUser.setText(a.getUser());
        edit_Admin_view.txtPassword.setText(a.getPassword());
        edit_Admin_view.pick_date_contr.setCalendar(date_cont.string_to_cal());
        edit_Admin_view.txtSalary.setText("" + sal);
        edit_Admin_view.txtActivity.setText("" + act);
        load_EditAvatar_admin(a.getAvatar());

    }

    public static void load_EditAvatar_admin(String file) {

        edit_Admin_view.labAvatar.setIcon(new ImageIcon(file));
        //Modificando la imagen
        ImageIcon icon = new ImageIcon(file);
        //Se extrae la imagen del icono
        Image img = icon.getImage();
        //Se modifica su tamaño
        Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
        //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
        ImageIcon newIcon = new ImageIcon(newimg);
        //Se coloca el nuevo icono modificado
        edit_Admin_view.labAvatar.setIcon(newIcon);
        //Se cambia el tamaño de la etiqueta
        edit_Admin_view.labAvatar.setSize(470, 290);
        edit_Admin_view.labAvatar.setToolTipText(file);
    }

    public static boolean booleanEditname_admin() {

        boolean ok = false;
        String name = edit_Admin_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {

            edit_Admin_view.labName.setIcon(wrong_data);
            edit_Admin_view.txtName.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            edit_Admin_view.labName.setIcon(good_data);
            edit_Admin_view.txtName.setBackground(Color.GREEN);

        }

        return ok;
    }

    public static boolean booleanEditlast_name_admin() {

        boolean ok = false;
        String name = edit_Admin_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            edit_Admin_view.labLast_name.setIcon(wrong_data);
            edit_Admin_view.txtLast_name.setBackground(Color.red);
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            edit_Admin_view.labLast_name.setIcon(good_data);
            edit_Admin_view.txtLast_name.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pise un numero de telefono movil con nueve digitos.
     *
     * @return string movil
     */
    public static boolean booleanEditmobile_admin() {

        String s = "";
        boolean ok = false;

        s = edit_Admin_view.txtMobile.getText();
        ok = Validate.okmobile(s);
        if (ok == false) {
            edit_Admin_view.labMobile.setIcon(wrong_data);
            edit_Admin_view.txtMobile.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            edit_Admin_view.labMobile.setIcon(good_data);
            edit_Admin_view.txtMobile.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide un email y valida su formato.
     *
     * @return
     */
    public static boolean booleanEditmail_admin() {

        String cad = "";
        boolean ok = false;

        cad = edit_Admin_view.txtEmail.getText();
        ok = Validate.okmail(cad);
        if (ok == false) {
            edit_Admin_view.labEmail.setIcon(wrong_data);
            edit_Admin_view.txtEmail.setBackground(Color.red);

            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            edit_Admin_view.labEmail.setIcon(good_data);
            edit_Admin_view.txtEmail.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEdituser_admin() {

        String cad = "";
        boolean ok = false;

        cad = edit_Admin_view.txtUser.getText();
        ok = Validate.okuser(cad);
        if (ok == false) {
            edit_Admin_view.labUser.setIcon(wrong_data);
            edit_Admin_view.txtUser.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            edit_Admin_view.labUser.setIcon(good_data);
            edit_Admin_view.txtUser.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEditpassword_admin() {

        boolean ok = false;

        char passArray[];
        passArray = edit_Admin_view.txtPassword.getPassword();
        String cad = new String(passArray);

        ok = Validate.okpassword(cad);
        if (ok == false) {
            edit_Admin_view.labPassword.setIcon(wrong_data);
            edit_Admin_view.txtPassword.setBackground(Color.red);
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            edit_Admin_view.labPassword.setIcon(good_data);
            edit_Admin_view.txtPassword.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEditsalary_admin() {

        String s = "";
        float sal = 0.0f;

        boolean ok = false;

        s = edit_Admin_view.txtSalary.getText();
        // ok = ;

        if (Validate.oksalary(s) == true) {
            sal = Float.parseFloat(s);
            ok = true;

            if ((sal >= 800) && (sal <= 2500)) {
                ok = true;
                edit_Admin_view.labSalary.setIcon(good_data);
                edit_Admin_view.txtSalary.setBackground(Color.GREEN);
                // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
                //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            } else {
                ok = false;

                edit_Admin_view.labSalary.setIcon(wrong_data);
                edit_Admin_view.txtSalary.setBackground(Color.RED);
            }
        } else {
            ok = false;
            edit_Admin_view.labSalary.setIcon(wrong_data);
            edit_Admin_view.txtSalary.setBackground(Color.RED);
        }

        return ok;
    }

    public static boolean booleanEditactivity_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;

        s = edit_Admin_view.txtActivity.getText();

        if (Validate.oksalary(s) == true) {

            act = Integer.parseInt(s);

            if ((act >= 0) && (act <= 100)) {
                ok = true;
                edit_Admin_view.labActivity.setIcon(good_data);
                edit_Admin_view.txtActivity.setBackground(Color.GREEN);
            } else {
                ok = false;
                edit_Admin_view.labActivity.setIcon(wrong_data);
                edit_Admin_view.txtActivity.setBackground(Color.red);
            }
        } else {
            edit_Admin_view.labActivity.setIcon(wrong_data);
            edit_Admin_view.txtActivity.setBackground(Color.RED);

        }
        return ok;
    }

    public static boolean booleanEditdate_birth_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        s = ((JTextFieldDateEditor) create_Admin_view.pick_date_birth.getDateEditor()).getText();

        ok = Date_min_max_condition_boolean(s, 16, 65);

        if (ok == false) {
            if(singletonapp.passdate==0){
                edit_Admin_view.labdate_birth.setToolTipText("You_haven't_introduced_format_data_correctly");
                
            }
            if(singletonapp.passdate==1){
                edit_Admin_view.labdate_birth.setToolTipText("No tienes la edad minima permitida o maxima");
                
            }
            edit_Admin_view.pick_date_birth.setBackground(Color.red);
            edit_Admin_view.labdate_birth.setIcon(wrong_data);

        } else {
            edit_Admin_view.pick_date_birth.setBackground(Color.GREEN);
            edit_Admin_view.pick_date_birth.setIcon(good_data);
        }

        return ok;
    }

    public static boolean booleanEditdate_contr_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;
        Calendar date_birth;
        String date_contr;
        int dia = 0, mes = 0, anio = 0;
        int diac = 0, mesc = 0, anioc = 0;

        s = ((JTextFieldDateEditor) create_Admin_view.pick_date_birth.getDateEditor()).getText();

        date_contr = ((JTextFieldDateEditor) create_Admin_view.pick_date_contr.getDateEditor()).getText();

        ClassDate contr = new ClassDate(date_contr);

        ok = Date_registered_boolean(contr, s, 16);

        if (ok == false) {
            
            edit_Admin_view.pick_date_contr.setBackground(Color.red);
            edit_Admin_view.pick_date_contr.setIcon(wrong_data);

        } else {
            edit_Admin_view.pick_date_contr.setBackground(Color.GREEN);
            edit_Admin_view.pick_date_contr.setIcon(good_data);
        }

        return ok;
    }

    public static ClassDate Edit_date_birth_admin() {

        String date = "";
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = edit_Admin_view.pick_date_birth.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        return new ClassDate(dia, mes, anio);
    }

    public static ClassDate Edit_date_cntr_admin() {

        String date = "";
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = edit_Admin_view.pick_date_contr.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        return new ClassDate(dia, mes, anio);
    }

    public static void EditAvatar_admin() {

        JFileChooser dlg = new JFileChooser();
        dlg.setCurrentDirectory(new File("src/Appweb/Modules/Users/Img/Avatares/"));
        dlg.setAcceptAllFileFilterUsed(false);
        dlg.addChoosableFileFilter(new FileNameExtensionFilter("JPG (*.jpg)", "jpg"));
        int option = dlg.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = dlg.getSelectedFile().getPath();
            edit_Admin_view.labAvatar.setIcon(new ImageIcon(file));
            //Modificando la imagen
            ImageIcon icon = new ImageIcon(file);
            //Se extrae la imagen del icono
            Image img = icon.getImage();
            //Se modifica su tamaño
            Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            //Se coloca el nuevo icono modificado
            edit_Admin_view.labAvatar.setIcon(newIcon);
            //Se cambia el tamaño de la etiqueta
            edit_Admin_view.labAvatar.setSize(470, 290);
            edit_Admin_view.labAvatar.setToolTipText(file);
        }
    }

    public static boolean modify_edit_Admin() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
        ClassDate date_cont = null;
        String Status = "";
        int activity = 0;
        float salary = 0.000f;
        ClassDate Date_birth = null;
        char[] password = edit_Admin_view.txtPassword.getPassword();
        Admin a = null;
        String Avatar = null;
        boolean ok = false;

        boolean pass, pass1, pass2, pass3, pass4, pass5, pass6, pass7, pass8, pass9, pass10;

        // pass = booleanEditdnia();
        pass1 = booleanEditname_admin();
        pass2 = booleanEditlast_name_admin();
        pass3 = booleanEditmobile_admin();
        pass4 = booleanEditmail_admin();
        pass5 = booleanEdituser_admin();
        pass6 = booleanEditpassword_admin();
        pass7 = booleanEditsalary_admin();
        pass8 = booleanEditactivity_admin();
        pass9 = booleanEditdate_birth_admin();
        pass10 = booleanEditdate_contr_admin();

        if (pass1 == true && pass2 == true && pass3 == true && pass4 == true && pass5 == true && pass6 == true && pass7 == true && pass8 == true && pass9 == true && pass10 == true) {
            // Enter User atributtes
            //Dni = edit_Admin_view.txtDni.getText();

            Name = edit_Admin_view.txtName.getText();
            singleton.Admin_array.get(pos).setName(Name);
            Last_name = edit_Admin_view.txtLast_name.getText();
            singleton.Admin_array.get(pos).setLast_name(Last_name);
            Mobile = edit_Admin_view.txtMobile.getText();
            singleton.Admin_array.get(pos).setMobile(Mobile);
            Date_birth = Edit_date_birth_admin();
            Email = edit_Admin_view.txtEmail.getText();
            singleton.Admin_array.get(pos).setEmail(Email);
            User = edit_Admin_view.txtUser.getText();
            singleton.Admin_array.get(pos).setUser(User);
            Password = new String(password);
            singleton.Admin_array.get(pos).setPassword(Password);
            Avatar = edit_Admin_view.labAvatar.getToolTipText();
            singleton.Admin_array.get(pos).setAvatar(Avatar);
            Status = edit_Admin_view.comboStatus.getSelectedItem().toString();
            singleton.Admin_array.get(pos).setStatus(Status);
            // Enter Admin attributes
            date_cont = Edit_date_cntr_admin();
            salary = Float.parseFloat(edit_Admin_view.txtSalary.getText());
            singleton.Admin_array.get(pos).setSalary(salary);
            activity = Integer.parseInt(edit_Admin_view.txtActivity.getText());
            singleton.Admin_array.get(pos).setActivity(activity);

            JOptionPane.showMessageDialog(null, "Usuario modificado");
            json.auto_save_json_file();
            ok = true;
        } else {

            JOptionPane.showMessageDialog(null, "Hay algun campo incorrecto por favor reviselos");
        }
        return ok;
    }

    public static void Load_show_admin() {

        Admin a = singleton.Admin_array.get(singletonapp.pos);

        Float sal = a.getSalary();
        int act = a.getActivity();
        int age = a.getAge();
        int ant = a.getAntique();
        Float ben = a.getBenefits();

        show_Admin_view.txtDni.setText(a.getDni());
        show_Admin_view.txtName.setText(a.getName());
        show_Admin_view.txtLast_name.setText(a.getLast_name());
        show_Admin_view.txtMobile.setText(a.getMobile());
        show_Admin_view.txtDate_birth.setText(a.getDate_birth().todate());
        show_Admin_view.txtAge.setText("" + age);
        show_Admin_view.txtEmail.setText(a.getEmail());
        show_Admin_view.txtUser.setText(a.getUser());
        show_Admin_view.txtPassword.setText(a.getPassword());
        show_Admin_view.txtStatus.setText(a.getStatus());
        show_Admin_view.txtDate_cont.setText(a.getDate_cont().todate());
        show_Admin_view.txtAntique.setText("" + ant);
        show_Admin_view.txtSalary.setText("" + sal);
        show_Admin_view.txtActivity.setText("" + act);
        show_Admin_view.txtBenefits.setText("" + ben);
        ShowAvatar_admin(a.getAvatar());

    }

    public static void ShowAvatar_admin(String file) {

        show_Admin_view.labAvatar.setIcon(new ImageIcon(file));
        //Modificando la imagen
        ImageIcon icon = new ImageIcon(file);
        //Se extrae la imagen del icono
        Image img = icon.getImage();
        //Se modifica su tamaño
        Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
        //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
        ImageIcon newIcon = new ImageIcon(newimg);
        //Se coloca el nuevo icono modificado
        show_Admin_view.labAvatar.setIcon(newIcon);
        //Se cambia el tamaño de la etiqueta
        show_Admin_view.labAvatar.setSize(470, 290);
        show_Admin_view.labAvatar.setToolTipText(file);

    }
}
