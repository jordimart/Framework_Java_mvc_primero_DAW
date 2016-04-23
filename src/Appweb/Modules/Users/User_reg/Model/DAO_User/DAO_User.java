package Appweb.Modules.Users.User_reg.Model.DAO_User;

import Appweb.Classes.Date.ClassDate;
import Appweb.General_tools.Date_tools;
import Appweb.General_tools.Validate;
import Appweb.General_tools.singletonapp;
import static Appweb.General_tools.singletonapp.good_data;
import static Appweb.General_tools.singletonapp.wrong_data;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Users.User_reg.Model.BLL_User.BLL_User;
import Appweb.Modules.Users.User_reg.Model.Classes.User_reg;
import Appweb.Modules.Users.User_reg.Model.Classes.singleuser_reg;
import Appweb.Modules.Users.User_reg.View.create_User_view;
import Appweb.Modules.Users.User_reg.View.edit_User_view;
import Appweb.Modules.Users.User_reg.View.show_User_view;
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
public class DAO_User {

    private static final String ENCODING = "UTF-8";

    /**
     * Fucion que valida que el dni pueda existir.Pero ademas comprueba que no
     * este repetido en los Admin.Implementada en grafica para validar etiqueta
     * de color.
     *
     * @return boolean ok.
     */
    public static boolean booleanEnterdni() {

        String dni = "";
        boolean ok = false;
        //int pos = -1;
        int num = 0, rest = 0;
        char letter = ' ', pass = ' ';
        String aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";

        aux = "";

        dni = create_User_view.txtDni.getText();
        dni = dni.toUpperCase();
        ok = Validate.okdni(dni);

        if (ok == false) {

            create_User_view.labDni.setIcon(wrong_data);
            create_User_view.labDni.setToolTipText("No has introducido los datos correctamente");
            create_User_view.txtDni.setBackground(Color.red);
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

                singletonapp.pos = BLL_User.Look_for_dni_user(dni);

                if (singletonapp.pos != -1) {

                    ok = false;

                    create_User_view.labDni.setIcon(wrong_data);
                    create_User_view.txtDni.setBackground(Color.RED);
                    create_User_view.labDni.setToolTipText(Lang.getInstance().getProperty("You_can_not_repeat_dni"));

                } else {

                    ok = true;
                    create_User_view.labDni.setToolTipText("");
                    create_User_view.labDni.setIcon(good_data);
                    create_User_view.txtDni.setBackground(Color.GREEN);
                }

            } else {
                ok = false;
                create_User_view.labDni.setToolTipText("El Dni introducido no existe");
                create_User_view.labDni.setIcon(wrong_data);
                create_User_view.txtDni.setBackground(Color.RED);

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
    public static boolean booleanEntername() {

        boolean ok = false;
        String name = create_User_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            create_User_view.labName.setIcon(wrong_data);
            create_User_view.txtName.setBackground(Color.red);
            create_User_view.labName.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_User_view.labName.setToolTipText("");
            create_User_view.labName.setIcon(good_data);
            create_User_view.txtName.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * DAO que valida un apellido introducido por el usuario, no contendra
     * numeros por ejemplo.
     *
     * @return boolean
     */
    public static boolean booleanEnterlast_name() {

        boolean ok = false;
        String name = create_User_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            create_User_view.labLast_name.setIcon(wrong_data);
            create_User_view.txtLast_name.setBackground(Color.red);
            create_User_view.labLast_name.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_User_view.labLast_name.setToolTipText("");
            create_User_view.labLast_name.setIcon(good_data);
            create_User_view.txtLast_name.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * DAO que valida un numero de telefono movil con nueve digitos.
     *
     * @return boolean
     */
    public static boolean booleanEntermobile() {

        String s = "";
        boolean ok = false;

        s = create_User_view.txtMobile.getText();
        ok = Validate.okmobile(s);
        if (ok == false) {
            create_User_view.labMobile.setIcon(wrong_data);
            create_User_view.txtMobile.setBackground(Color.red);
            create_User_view.labMobile.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_User_view.labMobile.setToolTipText("");
            create_User_view.labMobile.setIcon(good_data);
            create_User_view.txtMobile.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * DAO que valida un correo electronico, debe tener caracteres @caracteres
     * "." y com
     *
     * @return boolean
     */
    public static boolean booleanEntermail() {

        String cad = "";
        boolean ok = false;

        cad = create_User_view.txtEmail.getText();
        ok = Validate.okmail(cad);
        if (ok == false) {
            create_User_view.labEmail.setIcon(wrong_data);
            create_User_view.txtEmail.setBackground(Color.red);
            create_User_view.labEmail.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_User_view.labEmail.setToolTipText("");
            create_User_view.labEmail.setIcon(good_data);
            create_User_view.txtEmail.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * DAO que valida una palabra con letras y numeros
     *
     * @return boolean
     */
    public static boolean booleanEnteruser() {

        String cad = "";
        boolean ok = false;

        cad = create_User_view.txtUser.getText();
        ok = Validate.okuser(cad);
        if (ok == false) {
            create_User_view.labUser.setIcon(wrong_data);
            create_User_view.txtUser.setBackground(Color.red);
            create_User_view.labUser.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_User_view.labUser.setToolTipText("");
            create_User_view.labUser.setIcon(good_data);
            create_User_view.txtUser.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * DAO que valida una introduccion que debe ser mayor a 8 caracteres y
     * pueden ser letras,numeros o caracteres.
     *
     * @return boolean
     */
    public static boolean booleanEnterpassword() {

        boolean ok = false;

        char passArray[] = create_User_view.txtPassword.getPassword();
        String cad = new String(passArray);

        ok = Validate.okpassword(cad);
        if (ok == false) {
            create_User_view.labPassword.setIcon(wrong_data);
            create_User_view.txtPassword.setBackground(Color.red);
            create_User_view.labPassword.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            ok = true;
            create_User_view.labPassword.setToolTipText("");
            create_User_view.labPassword.setIcon(good_data);
            create_User_view.txtPassword.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * DAO que valida un entrada de actividad que debe estar comprendida entre 0
     * y 100
     *
     * @return boolean
     */
    public static boolean booleanEnteractivity() {

        String s = "";
        int act = 0;
        boolean ok = false;

        s = create_User_view.txtActivity.getText();

        if (Validate.oksalary(s) == true) {

            act = Integer.parseInt(s);

            if ((act >= 0) && (act <= 100)) {
                ok = true;
                create_User_view.labActivity.setToolTipText("");
                create_User_view.labActivity.setIcon(good_data);
                create_User_view.txtActivity.setBackground(Color.GREEN);
            } else {
                ok = false;
                create_User_view.labActivity.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + ",Debe estar comprendido entre 0 y 100");
                create_User_view.labActivity.setIcon(wrong_data);
                create_User_view.txtActivity.setBackground(Color.red);
            }
        } else {
            create_User_view.labActivity.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + ", quizas introdujo letras");
            create_User_view.labActivity.setIcon(wrong_data);
            create_User_view.txtActivity.setBackground(Color.RED);

        }
        return ok;
    }

    /**
     * DAO que valida una fecha de nac imiento que deb estar entre 16 y 65 años
     *
     * @return
     */
    public static boolean booleanEnterdate_birth() {

        String s = "";

        boolean ok = false;

        s = ((JTextFieldDateEditor) create_User_view.pick_date_birth.getDateEditor()).getText();

        ok = Date_tools.Date_min_condition_boolean(s, 18);

        if (ok == false) {

            if (singletonapp.passdate == 0) {
                create_User_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"));
            }
            if (singletonapp.passdate == 1) {
                create_User_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"));

            }
            if (singletonapp.passdate == 2) {
                create_User_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_can_not_register,_you_must_be") + 16 + Lang.getInstance().getProperty("years"));

            }

            create_User_view.pick_date_birth.setBackground(Color.red);
            create_User_view.labdate_birth.setIcon(wrong_data);

        } else {
            create_User_view.labdate_birth.setToolTipText("");
            create_User_view.pick_date_birth.setBackground(Color.GREEN);
            create_User_view.labdate_birth.setIcon(good_data);
        }

        return ok;
    }

    /**
     * Esta funcion se utiliza para entrarle el dato de fecha de nacimiento al
     * DAO de crear y en formato de calendar a mi clase fecha.
     *
     * @return CLassDate
     */
    public static ClassDate Enter_date_birth() {

        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_User_view.pick_date_birth.getCalendar();

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
    public static void EnterAvatar() {

        JFileChooser dlg = new JFileChooser();
        dlg.setCurrentDirectory(new File("src/Appweb/Modules/Users/Img/Avatares/"));
        dlg.setAcceptAllFileFilterUsed(false);
        dlg.addChoosableFileFilter(new FileNameExtensionFilter("JPG (*.jpg)", "jpg"));
        int option = dlg.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = dlg.getSelectedFile().getPath();
            String dir = dlg.getSelectedFile().toString();
            create_User_view.labAvatar.setIcon(new ImageIcon(file));
            //Modificando la imagen
            ImageIcon icon = new ImageIcon(file);
            //Se extrae la imagen del icono
            Image img = icon.getImage();
            //Se modifica su tamaño
            Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            //Se coloca el nuevo icono modificado
            create_User_view.labAvatar.setIcon(newIcon);
            //Se cambia el tamaño de la etiqueta
            create_User_view.labAvatar.setSize(470, 290);

            try {

                File source = new File(dir);
                File dest = new File("src/Appweb/Modules/Users/Img/Avatares/" + source.getName());
                create_User_view.labAvatar.setToolTipText(dest.toString());
                copyFileUsingJava7Files(source, dest);

            } catch (HeadlessException | IOException e) {

            }

        }
    }

    public static void copyFileUsingJava7Files(File source, File dest)
            throws IOException {

        Files.copy(source.toPath(), dest.toPath());

    }

    public static User_reg add_create() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
        ClassDate date_cont = null;
        String Status = "";
        int activity = 0;
        float salary = 0.000f;
        ClassDate Date_birth = null;
        char[] password = create_User_view.txtPassword.getPassword();
        User_reg a = null;
        String Avatar = null;

        boolean pass, pass1, pass2, pass3, pass4, pass5, pass6, pass8, pass9;

        pass = booleanEnterdni();
        pass1 = booleanEntername();
        pass2 = booleanEnterlast_name();
        pass3 = booleanEntermobile();
        pass4 = booleanEntermail();
        pass5 = booleanEnteruser();
        pass6 = booleanEnterpassword();
        // pass7 = booleanEntersalary();
        pass8 = booleanEnteractivity();
        pass9 = booleanEnterdate_birth();
        //pass10 = booleanEnterdate_contr_admin();

        if (pass == true && pass1 == true && pass2 == true && pass3 == true && pass4 == true && pass5 == true && pass6 == true && pass8 == true && pass9 == true) {
            // Enter User atributtes
            Dni = create_User_view.txtDni.getText().toUpperCase();
            Name = create_User_view.txtName.getText();
            Last_name = create_User_view.txtLast_name.getText();
            Mobile = create_User_view.txtMobile.getText();
            Date_birth = Enter_date_birth();
            Email = create_User_view.txtEmail.getText();
            User = create_User_view.txtUser.getText();
            Password = new String(password);
            Avatar = create_User_view.labAvatar.getToolTipText();
            Status = create_User_view.comboStatus.getSelectedItem().toString();
            // Enter Admin attributes
            // date_cont = Enter_date_cntr_admin();
            //salary = Float.parseFloat(create_Admin_view.txtSalary.getText());
            activity = Integer.parseInt(create_User_view.txtActivity.getText());

            a = new User_reg(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, activity);
        } else {
            a = null;
        }
        return a;
    }

    //////////////Daos para la ventana de editar Admin ////////
    public static void Load_edit_user() {

        User_reg a = singleuser_reg.User_reg_array.get(singletonapp.pos);

        //Float sal = a.getSalary();
        int act = a.getActivity_u();
        ClassDate date_birth = new ClassDate(a.getDate_birth().todate());
        //ClassDate date_cont = new ClassDate(a.getDate_cont().todate());

        edit_User_view.txtDni.setText(a.getDni());
        edit_User_view.txtName.setText(a.getName());
        edit_User_view.txtLast_name.setText(a.getLast_name());
        edit_User_view.txtMobile.setText(a.getMobile());

        edit_User_view.txtEmail.setText(a.getEmail());
        edit_User_view.txtUser.setText(a.getUser());
        edit_User_view.txtPassword.setText(a.getPassword());

        //edit_User_view.txtSalary.setText("" + sal);
        edit_User_view.txtActivity.setText("" + act);
        load_EditAvatar(a.getAvatar());
        edit_User_view.pick_date_birth.setCalendar(date_birth.string_to_cal());
        // edit_Admin_view.pick_date_contr.setCalendar(date_cont.string_to_cal());

    }

    public static void load_EditAvatar(String file) {

        edit_User_view.labAvatar.setIcon(new ImageIcon(file));
        //Modificando la imagen
        ImageIcon icon = new ImageIcon(file);
        //Se extrae la imagen del icono
        Image img = icon.getImage();
        //Se modifica su tamaño
        Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
        //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
        ImageIcon newIcon = new ImageIcon(newimg);
        //Se coloca el nuevo icono modificado
        edit_User_view.labAvatar.setIcon(newIcon);
        //Se cambia el tamaño de la etiqueta
        edit_User_view.labAvatar.setSize(470, 290);
        edit_User_view.labAvatar.setToolTipText(file);
    }

    public static boolean booleanEditname() {

        boolean ok = false;
        String name = edit_User_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {

            edit_User_view.labName.setIcon(wrong_data);
            edit_User_view.txtName.setBackground(Color.red);
            edit_User_view.labName.setToolTipText("No ha introducido los datos correctamente");
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            edit_User_view.labName.setToolTipText("");
            edit_User_view.labName.setIcon(good_data);
            edit_User_view.txtName.setBackground(Color.GREEN);

        }

        return ok;
    }

    public static boolean booleanEditlast_name() {

        boolean ok = false;
        String name = edit_User_view.txtLast_name.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            edit_User_view.labLast_name.setIcon(wrong_data);
            edit_User_view.txtLast_name.setBackground(Color.red);
            edit_User_view.labLast_name.setToolTipText("No ha introducido los datos correctamente");
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            edit_User_view.labLast_name.setToolTipText("");
            edit_User_view.labLast_name.setIcon(good_data);
            edit_User_view.txtLast_name.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pise un numero de telefono movil con nueve digitos.
     *
     * @return string movil
     */
    public static boolean booleanEditmobile() {

        String s = "";
        boolean ok = false;

        s = edit_User_view.txtMobile.getText();
        ok = Validate.okmobile(s);
        if (ok == false) {
            edit_User_view.labMobile.setIcon(wrong_data);
            edit_User_view.txtMobile.setBackground(Color.red);
            edit_User_view.labMobile.setToolTipText("No ha introducido los datos correctamente, solo puede contener 9 numeros");
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            edit_User_view.labMobile.setToolTipText("");
            edit_User_view.labMobile.setIcon(good_data);
            edit_User_view.txtMobile.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide un email y valida su formato.
     *
     * @return
     */
    public static boolean booleanEditmail() {

        String cad = "";
        boolean ok = false;

        cad = edit_User_view.txtEmail.getText();
        ok = Validate.okmail(cad);
        if (ok == false) {
            edit_User_view.labEmail.setIcon(wrong_data);
            edit_User_view.txtEmail.setBackground(Color.red);
            edit_User_view.labEmail.setToolTipText("No ha introducido los datos correctamente,Ejemplo: xxxx@xxx.xxx");

            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            edit_User_view.labEmail.setToolTipText("");
            edit_User_view.labEmail.setIcon(good_data);
            edit_User_view.txtEmail.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEdituser() {

        String cad = "";
        boolean ok = false;

        cad = edit_User_view.txtUser.getText();
        ok = Validate.okuser(cad);
        if (ok == false) {
            edit_User_view.labUser.setIcon(wrong_data);
            edit_User_view.txtUser.setBackground(Color.red);
            edit_User_view.labUser.setToolTipText("No ha introducido los datos correctamente");
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            edit_User_view.labUser.setToolTipText("");
            edit_User_view.labUser.setIcon(good_data);
            edit_User_view.txtUser.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEditpassword() {

        boolean ok = false;

        char passArray[];
        passArray = edit_User_view.txtPassword.getPassword();
        String cad = new String(passArray);

        ok = Validate.okpassword(cad);
        if (ok == false) {
            edit_User_view.labPassword.setIcon(wrong_data);
            edit_User_view.txtPassword.setBackground(Color.red);
            edit_User_view.labPassword.setToolTipText("No ha introducido los datos correctamente,Debe contener mayusculas,numeros y letras");
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            edit_User_view.labPassword.setToolTipText("");
            edit_User_view.labPassword.setIcon(good_data);
            edit_User_view.txtPassword.setBackground(Color.GREEN);
        }

        return ok;
    }

    public static boolean booleanEditactivity() {

        String s = "";
        int act = 0;
        boolean ok = false;

        s = edit_User_view.txtActivity.getText();

        if (Validate.oksalary(s) == true) {

            act = Integer.parseInt(s);

            if ((act >= 0) && (act <= 100)) {
                ok = true;
                edit_User_view.labActivity.setToolTipText("");
                edit_User_view.labActivity.setIcon(good_data);
                edit_User_view.txtActivity.setBackground(Color.GREEN);
            } else {
                edit_User_view.labActivity.setToolTipText("No ha introducido los datos correctamente,Debe estar comprendido entre 0 y 100");
                ok = false;
                edit_User_view.labActivity.setIcon(wrong_data);
                edit_User_view.txtActivity.setBackground(Color.red);
            }
        } else {
            edit_User_view.labActivity.setToolTipText("No ha introducido los datos correctamente, quizas introdujo letras");
            edit_User_view.labActivity.setIcon(wrong_data);
            edit_User_view.txtActivity.setBackground(Color.RED);

        }
        return ok;
    }

    public static boolean booleanEditdate_birth() {

        String s = "";

        boolean ok = false;

        s = ((JTextFieldDateEditor) edit_User_view.pick_date_birth.getDateEditor()).getText();

        ok = Date_tools.Date_min_condition_boolean(s, 18);

        if (ok == false) {

            if (singletonapp.passdate == 0) {
                edit_User_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"));
            }
            if (singletonapp.passdate == 1) {
                edit_User_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"));

            }
            if (singletonapp.passdate == 2) {
                edit_User_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_can_not_register,_you_must_be") + 16 + Lang.getInstance().getProperty("years"));

            }

            edit_User_view.pick_date_birth.setBackground(Color.red);
            edit_User_view.labdate_birth.setIcon(wrong_data);

        } else {
            edit_User_view.labdate_birth.setToolTipText("");
            edit_User_view.pick_date_birth.setBackground(Color.GREEN);
            edit_User_view.labdate_birth.setIcon(good_data);
        }

        return ok;
    }

    public static ClassDate Edit_date_birth() {

        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = edit_User_view.pick_date_birth.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        return new ClassDate(dia, mes, anio);
    }

    public static void EditAvatar() {

        JFileChooser dlg = new JFileChooser();
        dlg.setCurrentDirectory(new File("src/Appweb/Modules/Users/Img/Avatares/"));
        dlg.setAcceptAllFileFilterUsed(false);
        dlg.addChoosableFileFilter(new FileNameExtensionFilter("JPG (*.jpg)", "jpg"));
        int option = dlg.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = dlg.getSelectedFile().getPath();
            String dir = dlg.getSelectedFile().toString();
            edit_User_view.labAvatar.setIcon(new ImageIcon(file));
            //Modificando la imagen
            ImageIcon icon = new ImageIcon(file);
            //Se extrae la imagen del icono
            Image img = icon.getImage();
            //Se modifica su tamaño
            Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            //Se coloca el nuevo icono modificado
            edit_User_view.labAvatar.setIcon(newIcon);
            //Se cambia el tamaño de la etiqueta
            edit_User_view.labAvatar.setSize(470, 290);

            try {

                File source = new File(dir);
                File dest = new File("src/Appweb/Modules/Users/Img/Avatares/" + source.getName());
                edit_User_view.labAvatar.setToolTipText(dest.toString());
                copyFileUsingJava7Files(source, dest);

            } catch (HeadlessException | IOException e) {

            }

        }
    }

    public static User_reg modify_edit() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "";
        ClassDate date_cont = null;
        String Status = "";
        int activity = 0;
        float salary = 0.000f;
        ClassDate Date_birth = null;
        char[] password = edit_User_view.txtPassword.getPassword();
        User_reg a = null;
        String Avatar = null;
        boolean ok = false;

        boolean pass1, pass2, pass3, pass4, pass5, pass6, pass7, pass8, pass9, pass10;

        pass1 = booleanEditname();
        pass2 = booleanEditlast_name();
        pass3 = booleanEditmobile();
        pass4 = booleanEditmail();
        pass5 = booleanEdituser();
        pass6 = booleanEditpassword();
        // pass7 = booleanEditsalary();
        pass8 = booleanEditactivity();
        pass9 = booleanEditdate_birth();
        // pass10 = booleanEditdate_contr_admin();

        if (pass1 == true && pass2 == true && pass3 == true && pass4 == true && pass5 == true && pass6 == true && pass8 == true && pass9 == true) {

            Dni = edit_User_view.txtDni.getText();
            Name = edit_User_view.txtName.getText();
            Last_name = edit_User_view.txtLast_name.getText();
            Mobile = edit_User_view.txtMobile.getText();
            Date_birth = Edit_date_birth();
            Email = edit_User_view.txtEmail.getText();
            User = edit_User_view.txtUser.getText();
            Password = new String(password);
            Avatar = edit_User_view.labAvatar.getToolTipText();
            Status = edit_User_view.comboStatus.getSelectedItem().toString();
            // Enter Admin attributes
            //date_cont = Edit_date_cntr_admin();
            //salary = Float.parseFloat(edit_Admin_view.txtSalary.getText());
            activity = Integer.parseInt(edit_User_view.txtActivity.getText());

            a = new User_reg(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, activity);
        } else {
            a = null;
        }
        return a;
    }

    public static void Load_show() {

        User_reg a = singleuser_reg.User_reg_array.get(singletonapp.pos);

        int act = a.getActivity_u();
        int age = a.getAge();

        show_User_view.txtDni.setText(a.getDni());
        show_User_view.txtName.setText(a.getName());
        show_User_view.txtLast_name.setText(a.getLast_name());
        show_User_view.txtMobile.setText(a.getMobile());
        show_User_view.txtDate_birth.setText(a.getDate_birth().todate());
        show_User_view.txtAge.setText("" + age);
        show_User_view.txtEmail.setText(a.getEmail());
        show_User_view.txtUser.setText(a.getUser());
        show_User_view.txtPassword.setText(a.getPassword());
        show_User_view.txtStatus.setText(a.getStatus());

        show_User_view.txtActivity.setText("" + act);
        show_User_view.txtBenefits.setText(a.toBenefits());
        show_User_view.txtKarma.setText(a.getKarma());
        ShowAvatar(a.getAvatar());

    }

    public static void ShowAvatar(String file) {

        show_User_view.labAvatar.setIcon(new ImageIcon(file));
        //Modificando la imagen
        ImageIcon icon = new ImageIcon(file);
        //Se extrae la imagen del icono
        Image img = icon.getImage();
        //Se modifica su tamaño
        Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
        //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
        ImageIcon newIcon = new ImageIcon(newimg);
        //Se coloca el nuevo icono modificado
        show_User_view.labAvatar.setIcon(newIcon);
        //Se cambia el tamaño de la etiqueta
        show_User_view.labAvatar.setSize(470, 290);
        show_User_view.labAvatar.setToolTipText(file);

    }

    public static void save_json() {

        if (singleuser_reg.User_reg_array.size() != 0) {

            String PATH = null;
            try {
                XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
                xstreamjson.setMode(XStream.NO_REFERENCES);
                xstreamjson.alias("User_reg", User_reg.class);

                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

                int seleccion = fileChooser.showSaveDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File JFC = fileChooser.getSelectedFile();
                    PATH = JFC.getAbsolutePath();
                    PATH = PATH + ".json";

                    Gson gson = new Gson();
                    String json = gson.toJson(singleuser_reg.User_reg_array);
                    FileWriter fileXml = new FileWriter(PATH);
                    fileXml.write(json.toString());
                    fileXml.close();

                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("User_file_saved") + " User registered json",
                            Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Failed_to_save_user") + " User registered json", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("No_data_to_save"), Lang.getInstance().getProperty("File") + " json",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void save_txt() {

        if (singleuser_reg.User_reg_array.size() != 0) {

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
                    o.writeObject(singleuser_reg.User_reg_array);
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

    public static void save_xml() {

        if (singleuser_reg.User_reg_array.size() != 0) {

            String PATH = " ";

            try {
                OutputStream os = new ByteArrayOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                XStream xstream = new XStream();
                Annotations.configureAliases(xstream, User_reg.class);

                String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
                xstream.toXML(singleuser_reg.User_reg_array, osw);
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

    public static void auto_save_json() {

        String PATH = " ";

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/User_reg/Model/User_reg_files/useregusers";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("User_reg", User_reg.class);

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();
            PATH = PATH + ".json";

            Gson gson = new Gson();
            String json = gson.toJson(singleuser_reg.User_reg_array);
            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(json.toString());
            fileXml.close();

            System.out.print(Lang.getInstance().getProperty("User_file_saved") + " User_registered json \n");

        } catch (Exception e) {
            System.out.print(Lang.getInstance().getProperty("Failed_to_save_user") + " User registered json" + " \n");
        }
    }

    public static void auto_open_json() {

        String PATH = " ";
        User_reg a = new User_reg("");

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/User_reg/Model/User_reg_files/useregusers.json";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("User_reg", User_reg.class);

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();

            singleuser_reg.User_reg_array.clear();

            JsonReader lector = new JsonReader(new FileReader(PATH));
            JsonParser parseador = new JsonParser();
            JsonElement raiz = parseador.parse(lector);

            Gson json = new Gson();
            JsonArray lista = raiz.getAsJsonArray();
            for (JsonElement elemento : lista) {
                a = json.fromJson(elemento, User_reg.class);
                singleuser_reg.User_reg_array.add(a);

            }
            System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " User registered json" + " \n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(Lang.getInstance().getProperty("Error_loading_user_file") + "User registered json" + " \n");
        }
    }
}
