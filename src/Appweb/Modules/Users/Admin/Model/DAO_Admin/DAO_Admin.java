package Appweb.Modules.Users.Admin.Model.DAO_Admin;

import Appweb.Classes.Date.ClassDate;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Users.Admin.Model.BLL_Admin.BLL_Admin;
import Appweb.Modules.Users.Admin.View.create_Admin_view;
import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import static Appweb.General_tools.Date_tools.Date_min_max_condition_boolean;
import static Appweb.General_tools.Date_tools.Date_registered_boolean;
import Appweb.General_tools.Validate;
import Appweb.General_tools.singletonapp;
import static Appweb.General_tools.singletonapp.good_data;
import static Appweb.General_tools.singletonapp.wrong_data;
import Appweb.Modules.Users.Admin.View.edit_Admin_view;
import Appweb.Modules.Users.Admin.View.show_Admin_view;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import java.awt.Color;
import java.awt.Image;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUSG50V
 */
public class DAO_Admin {

    private static final String ENCODING = "UTF-8";

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
        //int pos = -1;
        int num = 0, rest = 0;
        char letter = ' ', pass = ' ';
        String aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";

        aux = "";

        dni = create_Admin_view.txtDni.getText();
        dni = dni.toUpperCase();
        ok = Validate.okdni(dni);

        if (ok == false) {

            create_Admin_view.labDni.setIcon(wrong_data);
            create_Admin_view.labDni.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));
            create_Admin_view.txtDni.setBackground(Color.red);

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

                singletonapp.pos = BLL_Admin.Look_for_dni_admin(dni);

                if (singletonapp.pos != -1) {

                    ok = false;

                    create_Admin_view.labDni.setIcon(wrong_data);
                    create_Admin_view.txtDni.setBackground(Color.RED);
                    create_Admin_view.labDni.setToolTipText(Lang.getInstance().getProperty("You_can_not_repeat_dni"));

                } else {

                    ok = true;
                    create_Admin_view.labDni.setToolTipText("");
                    create_Admin_view.labDni.setIcon(good_data);
                    create_Admin_view.txtDni.setBackground(Color.GREEN);
                }

            } else {
                ok = false;
                create_Admin_view.labDni.setToolTipText(Lang.getInstance().getProperty("This_Dni_don't_exist"));
                create_Admin_view.labDni.setIcon(wrong_data);
                create_Admin_view.txtDni.setBackground(Color.RED);

            }

        }
        return ok;
    }

    /**
     * DAO que valida un nombre introducido por el usuario, no contendra numeros
     * por ejemplo.
     *
     * @return boolean
     */
    public static boolean booleanEntername_admin() {

        boolean ok = false;
        String name = create_Admin_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Admin_view.labName.setIcon(wrong_data);
            create_Admin_view.txtName.setBackground(Color.red);
            create_Admin_view.labName.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_Admin_view.labName.setToolTipText("");
            create_Admin_view.labName.setIcon(good_data);
            create_Admin_view.txtName.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * DAO que valida un apellido introducido por el usuario, no contendra
     * numeros por ejemplo.
     *
     * @return boolean
     */
    public static boolean booleanEnterlast_name_admin() {

        boolean ok = false;
        String name = create_Admin_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Admin_view.labLast_name.setIcon(wrong_data);
            create_Admin_view.txtLast_name.setBackground(Color.red);
            create_Admin_view.labLast_name.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_Admin_view.labLast_name.setToolTipText("");
            create_Admin_view.labLast_name.setIcon(good_data);
            create_Admin_view.txtLast_name.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * DAO que valida un numero de telefono movil con nueve digitos.
     *
     * @return boolean
     */
    public static boolean booleanEntermobile_admin() {

        String s = "";
        boolean ok = false;

        s = create_Admin_view.txtMobile.getText();
        ok = Validate.okmobile(s);
        if (ok == false) {
            create_Admin_view.labMobile.setIcon(wrong_data);
            create_Admin_view.txtMobile.setBackground(Color.red);
            create_Admin_view.labMobile.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly")+","+ Lang.getInstance().getProperty("It_can_only_contain_9_numbers"));

        } else {
            create_Admin_view.labMobile.setToolTipText("");
            create_Admin_view.labMobile.setIcon(good_data);
            create_Admin_view.txtMobile.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * DAO que valida un correo electronico, debe tener caracteres @caracteres
     * "." y com
     *
     * @return boolean
     */
    public static boolean booleanEntermail_admin() {

        String cad = "";
        boolean ok = false;

        cad = create_Admin_view.txtEmail.getText();
        ok = Validate.okmail(cad);
        if (ok == false) {
            create_Admin_view.labEmail.setIcon(wrong_data);
            create_Admin_view.txtEmail.setBackground(Color.red);
            create_Admin_view.labEmail.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly")+","+ Lang.getInstance().getProperty("Example")+": xxxx@xxxx.xxx");

        } else {
            create_Admin_view.labEmail.setToolTipText("");
            create_Admin_view.labEmail.setIcon(good_data);
            create_Admin_view.txtEmail.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * DAO que valida una palabra con letras y numeros
     *
     * @return boolean
     */
    public static boolean booleanEnteruser_admin() {

        String cad = "";
        boolean ok = false;

        cad = create_Admin_view.txtUser.getText();
        ok = Validate.okuser(cad);
        if (ok == false) {
            create_Admin_view.labUser.setIcon(wrong_data);
            create_Admin_view.txtUser.setBackground(Color.red);
            create_Admin_view.labUser.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_Admin_view.labUser.setToolTipText("");
            create_Admin_view.labUser.setIcon(good_data);
            create_Admin_view.txtUser.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * DAO que valida una introduccion que debe ser mayor a 8 caracteres y
     * pueden ser letras,numeros o caracteres.
     *
     * @return boolean
     */
    public static boolean booleanEnterpassword_admin() {

        boolean ok = false;

        char passArray[] = create_Admin_view.txtPassword.getPassword();
        String cad = new String(passArray);

        ok = Validate.okpassword(cad);
        if (ok == false) {
            create_Admin_view.labPassword.setIcon(wrong_data);
            create_Admin_view.txtPassword.setBackground(Color.red);
            create_Admin_view.labPassword.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly")+","+ Lang.getInstance().getProperty("The_password_should_contain_letters_,mayus_letters_and_numbers"));

        } else {
            ok = true;
            create_Admin_view.labPassword.setToolTipText("");
            create_Admin_view.labPassword.setIcon(good_data);
            create_Admin_view.txtPassword.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * DAO que valida una entrada de salario float, debe estar entre 800 y 2500.
     *
     * @return boolean
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
                create_Admin_view.labSalary.setToolTipText("");
                create_Admin_view.labSalary.setIcon(good_data);
                create_Admin_view.txtSalary.setBackground(Color.GREEN);

            } else {
                ok = false;
                create_Admin_view.labSalary.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + "," + Lang.getInstance().getProperty("The_number_must_be_between_800_and_2500"));
                create_Admin_view.labSalary.setIcon(wrong_data);
                create_Admin_view.txtSalary.setBackground(Color.RED);
            }
        } else {

            ok = false;
            create_Admin_view.labSalary.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + "," + Lang.getInstance().getProperty("Maybe_ontroduced_lyrics"));
            create_Admin_view.labSalary.setIcon(wrong_data);
            create_Admin_view.txtSalary.setBackground(Color.RED);
        }

        return ok;
    }

    /**
     * DAO que valida un entrada de actividad que debe estar comprendida entre 0
     * y 100
     *
     * @return boolean
     */
    public static boolean booleanEnteractivity_admin() {

        String s = "";
        int act = 0;
        boolean ok = false;

        s = create_Admin_view.txtActivity.getText();

        if (Validate.oksalary(s) == true) {

            act = Integer.parseInt(s);

            if ((act >= 0) && (act <= 100)) {
                ok = true;
                create_Admin_view.labActivity.setToolTipText("");
                create_Admin_view.labActivity.setIcon(good_data);
                create_Admin_view.txtActivity.setBackground(Color.GREEN);
            } else {
                ok = false;
                create_Admin_view.labActivity.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + "," + Lang.getInstance().getProperty("The_number_must_be_between_0_and_100"));
                create_Admin_view.labActivity.setIcon(wrong_data);
                create_Admin_view.txtActivity.setBackground(Color.red);
            }
        } else {
            create_Admin_view.labActivity.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + "," + Lang.getInstance().getProperty("Maybe_ontroduced_lyrics"));
            create_Admin_view.labActivity.setIcon(wrong_data);
            create_Admin_view.txtActivity.setBackground(Color.RED);

        }
        return ok;
    }

    /**
     * DAO que valida una fecha de nac imiento que deb estar entre 16 y 65 años
     *
     * @return
     */
    public static boolean booleanEnterdate_birth_admin() {

        String s = "";  
        boolean ok = false;
     
       

        s = ((JTextFieldDateEditor) create_Admin_view.pick_date_birth.getDateEditor()).getText();

        ok = Date_min_max_condition_boolean(s, 16, 65);

        if (ok == false) {

            if (singletonapp.passdate == 0) {
                create_Admin_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"));
            }
            if (singletonapp.passdate == 1) {
                create_Admin_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"));

            }
            if (singletonapp.passdate == 2) {
                create_Admin_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_can_not_register,_you_must_be") + 16 + Lang.getInstance().getProperty("years"));

            }

            create_Admin_view.pick_date_birth.setBackground(Color.red);
            create_Admin_view.labdate_birth.setIcon(wrong_data);

        } else {
            create_Admin_view.labdate_birth.setToolTipText("");
            create_Admin_view.pick_date_birth.setBackground(Color.GREEN);
            create_Admin_view.labdate_birth.setIcon(good_data);
        }

        return ok;
    }

    /**
     * DAO que valida una fecha de contratacion que debe validarse dependiendo
     * de la de nacimiento
     *
     * @return
     */
    public static boolean booleanEnterdate_contr_admin() {

        String s = "";
        boolean ok = false;

        String date_contr;

        s = ((JTextFieldDateEditor) create_Admin_view.pick_date_birth.getDateEditor()).getText();

        date_contr = ((JTextFieldDateEditor) create_Admin_view.pick_date_contr.getDateEditor()).getText();

        if (s.equals("") || date_contr.equals("")) {

            create_Admin_view.labdate_contr.setToolTipText(Lang.getInstance().getProperty("Check_the_dates_there_is_a_blank_field"));
            create_Admin_view.pick_date_contr.setBackground(Color.red);
            create_Admin_view.labdate_contr.setIcon(wrong_data);

        } else {
            ClassDate contr = new ClassDate(date_contr);

            ok = Date_registered_boolean(contr, s, 16);

            if (ok == false) {
                if (singletonapp.passdate2 == 4) {
                    create_Admin_view.labdate_contr.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"));
                }
                if (singletonapp.passdate2 == 0) {
                    create_Admin_view.labdate_contr.setToolTipText(Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"));
                }
                if (singletonapp.passdate2 == 1) {
                    create_Admin_view.labdate_contr.setToolTipText(Lang.getInstance().getProperty("The_date_may_not_be_later_than_the_system"));
                }
                if (singletonapp.passdate2 == 2) {
                    create_Admin_view.labdate_contr.setToolTipText(Lang.getInstance().getProperty("The_record_date_may_not_be_earlier_wing_of_birth"));
                }
                if (singletonapp.passdate2 == 3) {
                    create_Admin_view.labdate_contr.setToolTipText(Lang.getInstance().getProperty("On_this_date_you_were_not_of_legal_age"));
                }

                create_Admin_view.pick_date_contr.setBackground(Color.red);
                create_Admin_view.labdate_contr.setIcon(wrong_data);

            } else {
                create_Admin_view.labdate_contr.setToolTipText(Lang.getInstance().getProperty(""));
                create_Admin_view.pick_date_contr.setBackground(Color.GREEN);
                create_Admin_view.labdate_contr.setIcon(good_data);
            }
        }
        return ok;
    }

    /**
     * Esta funcion se utiliza para entrarle el dato de fecha de nacimiento al
     * DAO de crear y en formato de calendar a mi clase fecha.
     *
     * @return CLassDate
     */
    public static ClassDate Enter_date_birth_admin() {

        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_Admin_view.pick_date_birth.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        return new ClassDate(dia, mes, anio);
    }

    /**
     * Esta funcion se utiliza para entrarle el dato de fecha de contratacion al
     * DAO de crear y en formato de calendar a mi clase fecha.
     *
     * @return CLassDate
     */
    public static ClassDate Enter_date_cntr_admin() {

   
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_Admin_view.pick_date_contr.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        return new ClassDate(dia, mes, anio);
    }

    /**
     * Esta funcion se utiliza para que el usuario mediante un filechocer de jpg
     * busque una imagen d eavatar.La imagen si es externa se guarda en la
     * carpeta avatares.
     */
    public static void EnterAvatar_admin() {

        JFileChooser dlg = new JFileChooser();
        dlg.setCurrentDirectory(new File("src/Appweb/Modules/Users/Img/Avatares/"));
        dlg.setAcceptAllFileFilterUsed(false);
        dlg.addChoosableFileFilter(new FileNameExtensionFilter("JPG (*.jpg)", "jpg"));
        int option = dlg.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = dlg.getSelectedFile().getPath();
            String dir = dlg.getSelectedFile().toString();
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

            try {

                File source = new File(dir);
                File dest = new File("src/Appweb/Modules/Users/Img/Avatares/" + source.getName());
                create_Admin_view.labAvatar.setToolTipText(dest.toString());
                copyFileUsingJava7Files(source, dest);

            } catch (HeadlessException | IOException e) {

            }

        }
    }

    public static void copyFileUsingJava7Files(File source, File dest)
            throws IOException {

        Files.copy(source.toPath(), dest.toPath());

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
            Dni = create_Admin_view.txtDni.getText().toUpperCase();
            Name = create_Admin_view.txtName.getText();
            Last_name = create_Admin_view.txtLast_name.getText();
            Mobile = create_Admin_view.txtMobile.getText();
            Date_birth = Enter_date_birth_admin();
            Email = create_Admin_view.txtEmail.getText();
            User = create_Admin_view.txtUser.getText();
            Password = new String(password);
            Avatar = create_Admin_view.labAvatar.getToolTipText();

            // Enter Admin attributes
            date_cont = Enter_date_cntr_admin();
            salary = Float.parseFloat(create_Admin_view.txtSalary.getText());
            activity = Integer.parseInt(create_Admin_view.txtActivity.getText());
            Status = create_Admin_view.comboStatus.getSelectedItem().toString();

            a = new Admin(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_cont, salary, activity);
        } else {
            a = null;
        }
        return a;
    }

    //////////////Daos para la ventana de editar Admin ////////
    public static void Load_edit_admin() {

        Admin a = singleadmin.Admin_array.get(singletonapp.pos);

        Float sal = a.getSalary();
        int act = a.getActivity();
        ClassDate date_birth = new ClassDate(a.getDate_birth().todate());
        ClassDate date_cont = new ClassDate(a.getDate_cont().todate());

        edit_Admin_view.txtDni.setText(a.getDni());
        edit_Admin_view.txtName.setText(a.getName());
        edit_Admin_view.txtLast_name.setText(a.getLast_name());
        edit_Admin_view.txtMobile.setText(a.getMobile());

        edit_Admin_view.txtEmail.setText(a.getEmail());
        edit_Admin_view.txtUser.setText(a.getUser());
        edit_Admin_view.txtPassword.setText(a.getPassword());

        edit_Admin_view.txtSalary.setText("" + sal);
        edit_Admin_view.txtActivity.setText("" + act);
        load_EditAvatar_admin(a.getAvatar());
        edit_Admin_view.pick_date_birth.setCalendar(date_birth.string_to_cal());
        edit_Admin_view.pick_date_contr.setCalendar(date_cont.string_to_cal());

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
            edit_Admin_view.labName.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));
            
        } else {
            ok = true;
            edit_Admin_view.labName.setToolTipText("");
            edit_Admin_view.labName.setIcon(good_data);
            edit_Admin_view.txtName.setBackground(Color.GREEN);

        }

        return ok;
    }

    public static boolean booleanEditlast_name_admin() {

        boolean ok = false;
        String name = edit_Admin_view.txtLast_name.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            edit_Admin_view.labLast_name.setIcon(wrong_data);
            edit_Admin_view.txtLast_name.setBackground(Color.red);
            edit_Admin_view.labLast_name.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));
            
        } else {
            edit_Admin_view.labLast_name.setToolTipText("");
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
            edit_Admin_view.labMobile.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly")+","+ Lang.getInstance().getProperty("It_can_only_contain_9_numbers"));
            // J
        } else {
            edit_Admin_view.labMobile.setToolTipText("");
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
            edit_Admin_view.labEmail.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly")+","+ Lang.getInstance().getProperty("Example")+": xxxx@xxxx.xxx");

           
        } else {
            edit_Admin_view.labEmail.setToolTipText("");
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
            edit_Admin_view.labUser.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));
           
        } else {
            ok = true;
            edit_Admin_view.labUser.setToolTipText("");
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
            edit_Admin_view.labPassword.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly")+","+ Lang.getInstance().getProperty("The_password_should_contain_letters_,mayus_letters_and_numbers"));
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            edit_Admin_view.labPassword.setToolTipText("");
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
      

        if (Validate.oksalary(s) == true) {

            try {
                sal = Float.parseFloat(s);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ok = true;

            if ((sal >= 800) && (sal <= 2500)) {
                ok = true;
                edit_Admin_view.labSalary.setToolTipText("");
                edit_Admin_view.labSalary.setIcon(good_data);
                edit_Admin_view.txtSalary.setBackground(Color.GREEN);
               
            } else {
                ok = false;
                edit_Admin_view.labSalary.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + "," + Lang.getInstance().getProperty("The_number_must_be_between_800_and_2500"));
                edit_Admin_view.labSalary.setIcon(wrong_data);
                edit_Admin_view.txtSalary.setBackground(Color.RED);
            }
        } else {
            ok = false;
            edit_Admin_view.labSalary.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + "," + Lang.getInstance().getProperty("Maybe_ontroduced_lyrics"));
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
                edit_Admin_view.labActivity.setToolTipText("");
                edit_Admin_view.labActivity.setIcon(good_data);
                edit_Admin_view.txtActivity.setBackground(Color.GREEN);
            } else {
                edit_Admin_view.labActivity.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + "," + Lang.getInstance().getProperty("The_number_must_be_between_0_and_100"));
                ok = false;
                edit_Admin_view.labActivity.setIcon(wrong_data);
                edit_Admin_view.txtActivity.setBackground(Color.red);
            }
        } else {
            edit_Admin_view.labActivity.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + "," + Lang.getInstance().getProperty("Maybe_ontroduced_lyrics"));
            edit_Admin_view.labActivity.setIcon(wrong_data);
            edit_Admin_view.txtActivity.setBackground(Color.RED);

        }
        return ok;
    }

    public static boolean booleanEditdate_birth_admin() {

        String s = "";
        boolean ok = false;
        

        s = ((JTextFieldDateEditor) edit_Admin_view.pick_date_birth.getDateEditor()).getText();

        ok = Date_min_max_condition_boolean(s, 16, 65);

        if (ok == false) {

            if (singletonapp.passdate == 0) {
                edit_Admin_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"));
            }
            if (singletonapp.passdate == 1) {
                edit_Admin_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"));

            }
            if (singletonapp.passdate == 2) {
                edit_Admin_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_can_not_register,_you_must_be") + 16 + Lang.getInstance().getProperty("years"));

            }

            edit_Admin_view.pick_date_birth.setBackground(Color.red);
            edit_Admin_view.labdate_birth.setIcon(wrong_data);

        } else {
            edit_Admin_view.labdate_birth.setToolTipText("");
            edit_Admin_view.pick_date_birth.setBackground(Color.GREEN);
            edit_Admin_view.labdate_birth.setIcon(good_data);
        }

        return ok;
    }

    public static boolean booleanEditdate_contr_admin() {

        String s = "";
        boolean ok = false;
        String date_contr;
        

        s = ((JTextFieldDateEditor) edit_Admin_view.pick_date_birth.getDateEditor()).getText();

        date_contr = ((JTextFieldDateEditor) edit_Admin_view.pick_date_contr.getDateEditor()).getText();

        if (s.equals("") || date_contr.equals("")) {

            edit_Admin_view.labdate_cont.setToolTipText(Lang.getInstance().getProperty("Check_the_dates_there_is_a_blank_field"));
            edit_Admin_view.pick_date_contr.setBackground(Color.red);
            edit_Admin_view.labdate_cont.setIcon(wrong_data);

        } else {

            ClassDate contr = new ClassDate(date_contr);

            ok = Date_registered_boolean(contr, s, 16);

            if (ok == false) {

                if (singletonapp.passdate == 4) {
                    edit_Admin_view.labdate_cont.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"));
                }
                if (singletonapp.passdate == 0) {
                    edit_Admin_view.labdate_cont.setToolTipText(Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"));
                }
                if (singletonapp.passdate == 1) {
                    edit_Admin_view.labdate_cont.setToolTipText(Lang.getInstance().getProperty("The_date_may_not_be_later_than_the_system"));
                }
                if (singletonapp.passdate == 2) {
                    edit_Admin_view.labdate_cont.setToolTipText(Lang.getInstance().getProperty("The_record_date_may_not_be_earlier_wing_of_birth"));
                }
                if (singletonapp.passdate == 3) {
                    edit_Admin_view.labdate_cont.setToolTipText(Lang.getInstance().getProperty("On_this_date_you_were_not_of_legal_age"));
                }

                edit_Admin_view.pick_date_contr.setBackground(Color.red);
                edit_Admin_view.labdate_cont.setIcon(wrong_data);

            } else {
                edit_Admin_view.labdate_cont.setToolTipText(Lang.getInstance().getProperty(""));
                edit_Admin_view.pick_date_contr.setBackground(Color.GREEN);
                edit_Admin_view.labdate_cont.setIcon(good_data);
            }
        }

        return ok;
    }

    public static ClassDate Edit_date_birth_admin() {

      
        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = edit_Admin_view.pick_date_birth.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        return new ClassDate(dia, mes, anio);
    }

    public static ClassDate Edit_date_cntr_admin() {

     
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
            String dir = dlg.getSelectedFile().toString();
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

            try {

                File source = new File(dir);
                File dest = new File("src/Appweb/Modules/Users/Img/Avatares/" + source.getName());
                edit_Admin_view.labAvatar.setToolTipText(dest.toString());
                copyFileUsingJava7Files(source, dest);

            } catch (HeadlessException | IOException e) {

            }

        }
    }

    public static Admin modify_edit_Admin() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
        ClassDate date_cont = null;
        String Status = "";
        int activity = 0;
        float salary = 0.000f;
        ClassDate Date_birth = null;
        char[] password = edit_Admin_view.txtPassword.getPassword();
        Admin a = null;
        String Avatar = null;
       

        boolean  pass1, pass2, pass3, pass4, pass5, pass6, pass7, pass8, pass9, pass10;

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

            Dni = edit_Admin_view.txtDni.getText();
            Name = edit_Admin_view.txtName.getText();
            Last_name = edit_Admin_view.txtLast_name.getText();
            Mobile = edit_Admin_view.txtMobile.getText();
            Date_birth = Edit_date_birth_admin();
            Email = edit_Admin_view.txtEmail.getText();
            User = edit_Admin_view.txtUser.getText();
            Password = new String(password);
            Avatar = edit_Admin_view.labAvatar.getToolTipText();
            Status = edit_Admin_view.comboStatus.getSelectedItem().toString();
            // Enter Admin attributes
            date_cont = Edit_date_cntr_admin();
            salary = Float.parseFloat(edit_Admin_view.txtSalary.getText());
            activity = Integer.parseInt(edit_Admin_view.txtActivity.getText());

            a = new Admin(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_cont, salary, activity);
        } else {
            a = null;
        }
        return a;
    }

    public static void Load_show_admin() {

        Admin a = singleadmin.Admin_array.get(singletonapp.pos);

        int act = a.getActivity();
        int age = a.getAge();
        int ant = a.getAntique();
     

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
        show_Admin_view.txtSalary.setText(a.toSalary());
        show_Admin_view.txtActivity.setText("" + act);
        show_Admin_view.txtBenefits.setText(a.toBenefits());
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

    public static void save_json_admin() {

        if (singleadmin.Admin_array.size() != 0) {

            String PATH = null;
            try {
                XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
                xstreamjson.setMode(XStream.NO_REFERENCES);
                xstreamjson.alias("empleafijo", Admin.class);

                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

                int seleccion = fileChooser.showSaveDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File JFC = fileChooser.getSelectedFile();
                    PATH = JFC.getAbsolutePath();
                    PATH = PATH + ".json";

                    Gson gson = new Gson();
                    String json = gson.toJson(singleadmin.Admin_array);
                    FileWriter fileXml = new FileWriter(PATH);
                    fileXml.write(json.toString());
                    fileXml.close();

                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("User_file_saved") + " Admin json",
                            Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Failed_to_save_user") + " Admin json", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("No_data_to_save"), Lang.getInstance().getProperty("File") + " json",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void save_txt_admin() {

        if (singleadmin.Admin_array.size() != 0) {

            String PATH = " ";
            try {
                File f;
                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Texto (*.txt)", "txt"));

                int seleccion = fileChooser.showSaveDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File JFC = fileChooser.getSelectedFile();
                    PATH = JFC.getAbsolutePath();
                    PATH = PATH + ".txt";
                    f = new File(PATH);

                    FileOutputStream fo = new FileOutputStream(f);
                    ObjectOutputStream o = new ObjectOutputStream(fo);
                    o.writeObject(singleadmin.Admin_array);
                    o.close();
                    JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            JOptionPane.showMessageDialog(null, "No hay datos para guardar", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void save_xml_admin() {

        if (singleadmin.Admin_array.size() != 0) {

            String PATH = " ";

            try {
                OutputStream os = new ByteArrayOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                XStream xstream = new XStream();
                Annotations.configureAliases(xstream, Admin.class);

                String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
                xstream.toXML(singleadmin.Admin_array, osw);
                StringBuffer xml = new StringBuffer();
                xml.append(header);
                xml.append(os.toString());

                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("XML (*.xml)", "xml"));

                int seleccion = fileChooser.showSaveDialog(null);

                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File JFC = fileChooser.getSelectedFile();
                    PATH = JFC.getAbsolutePath();
                    PATH = PATH + ".xml";

                    FileWriter fileXml = new FileWriter(PATH);
                    fileXml.write(xml.toString());
                    fileXml.close();
                    osw.close();
                    os.close();
                    JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {

            JOptionPane.showMessageDialog(null, "No hay datos para guardar", "Archivo XML", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void auto_save_json_admin() {

        String PATH = " ";

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/Admin/Model/Admin_files/adminusers";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("Admin", Admin.class);

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();
            PATH = PATH + ".json";

            Gson gson = new Gson();
            String json = gson.toJson(singleadmin.Admin_array);
            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(json.toString());
            fileXml.close();

            System.out.print(Lang.getInstance().getProperty("User_file_saved") + " Admin json \n");

        } catch (Exception e) {
            System.out.print(Lang.getInstance().getProperty("Failed_to_save_user") + " Admin json" + " \n");
        }
    }

    public static void auto_open_json_admin() {

        String PATH = " ";
        Admin a = new Admin("");
       

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/Admin/Model/Admin_files/adminusers.json";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Admin", Admin.class);

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();

            singleadmin.Admin_array.clear();

            JsonReader lector = new JsonReader(new FileReader(PATH));
            JsonParser parseador = new JsonParser();
            JsonElement raiz = parseador.parse(lector);

            Gson json = new Gson();
            JsonArray lista = raiz.getAsJsonArray();
            for (JsonElement elemento : lista) {
                a = json.fromJson(elemento, Admin.class);
                singleadmin.Admin_array.add(a);

            }
            System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " Admin json" + " \n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(Lang.getInstance().getProperty("Error_loading_user_file") + " json" + " \n");
        }
    }
}
