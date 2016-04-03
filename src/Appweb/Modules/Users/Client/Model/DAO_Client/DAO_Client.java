package Appweb.Modules.Users.Client.Model.DAO_Client;

import Appweb.Classes.Date.ClassDate;
import Appweb.General_tools.Date_tools;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import static Appweb.General_tools.Date_tools.Date_min_max_condition_boolean;
import static Appweb.General_tools.Date_tools.Date_registered_boolean;
import Appweb.General_tools.Validate;
import Appweb.General_tools.singletonapp;
import static Appweb.General_tools.singletonapp.good_data;
import static Appweb.General_tools.singletonapp.wrong_data;
import Appweb.Modules.Users.Client.Model.BLL_Client.BLL_Client;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;
import Appweb.Modules.Users.Client.View.create_Client_view;
import Appweb.Modules.Users.Client.View.edit_Client_view;
import Appweb.Modules.Users.Client.View.show_Client_view;
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
public class DAO_Client {

    private static final String ENCODING = "UTF-8";

    /**
     * Fucion que valida que el dni pueda existir.Pero ademas comprueba que no
     * este repetido en los Admin.Implementada en grafica para validar etiqueta
     * de color.
     *
     * @return boolean ok.
     */
    public static boolean booleanEnterdnic() {

        String dni = "";
        boolean ok = false;
        //int pos = -1;
        int num = 0, rest = 0;
        char letter = ' ', pass = ' ';
        String aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";

        aux = "";

        dni = create_Client_view.txtDni.getText();
        dni = dni.toUpperCase();
        ok = Validate.okdni(dni);

        if (ok == false) {

            create_Client_view.labDni.setIcon(wrong_data);
            create_Client_view.labDni.setToolTipText("No has introducido los datos correctamente");
            create_Client_view.txtDni.setBackground(Color.red);
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

                singletonapp.pos = BLL_Client.Look_for_dni_client(dni);

                if (singletonapp.pos != -1) {

                    ok = false;

                    create_Client_view.labDni.setIcon(wrong_data);
                    create_Client_view.txtDni.setBackground(Color.RED);
                    create_Client_view.labDni.setToolTipText(Lang.getInstance().getProperty("You_can_not_repeat_dni"));

                } else {

                    ok = true;
                    create_Client_view.labDni.setToolTipText("");
                    create_Client_view.labDni.setIcon(good_data);
                    create_Client_view.txtDni.setBackground(Color.GREEN);
                }

            } else {
                ok = false;
                create_Client_view.labDni.setToolTipText("El Dni introducido no existe");
                create_Client_view.labDni.setIcon(wrong_data);
                create_Client_view.txtDni.setBackground(Color.RED);

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
    public static boolean booleanEntername_client() {

        boolean ok = false;
        String name = create_Client_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Client_view.labName.setIcon(wrong_data);
            create_Client_view.txtName.setBackground(Color.red);
            create_Client_view.labName.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_Client_view.labName.setToolTipText("");
            create_Client_view.labName.setIcon(good_data);
            create_Client_view.txtName.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * DAO que valida un apellido introducido por el usuario, no contendra
     * numeros por ejemplo.
     *
     * @return boolean
     */
    public static boolean booleanEnterlast_name_client() {

        boolean ok = false;
        String name = create_Client_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            create_Client_view.labLast_name.setIcon(wrong_data);
            create_Client_view.txtLast_name.setBackground(Color.red);
            create_Client_view.labLast_name.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_Client_view.labLast_name.setToolTipText("");
            create_Client_view.labLast_name.setIcon(good_data);
            create_Client_view.txtLast_name.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * DAO que valida un numero de telefono movil con nueve digitos.
     *
     * @return boolean
     */
    public static boolean booleanEntermobile_client() {

        String s = "";
        boolean ok = false;

        s = create_Client_view.txtMobile.getText();
        ok = Validate.okmobile(s);
        if (ok == false) {
            create_Client_view.labMobile.setIcon(wrong_data);
            create_Client_view.txtMobile.setBackground(Color.red);
            create_Client_view.labMobile.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_Client_view.labMobile.setToolTipText("");
            create_Client_view.labMobile.setIcon(good_data);
            create_Client_view.txtMobile.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * DAO que valida un correo electronico, debe tener caracteres @caracteres
     * "." y com
     *
     * @return boolean
     */
    public static boolean booleanEntermail_client() {

        String cad = "";
        boolean ok = false;

        cad = create_Client_view.txtEmail.getText();
        ok = Validate.okmail(cad);
        if (ok == false) {
            create_Client_view.labEmail.setIcon(wrong_data);
            create_Client_view.txtEmail.setBackground(Color.red);
            create_Client_view.labEmail.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_Client_view.labEmail.setToolTipText("");
            create_Client_view.labEmail.setIcon(good_data);
            create_Client_view.txtEmail.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * DAO que valida una palabra con letras y numeros
     *
     * @return boolean
     */
    public static boolean booleanEnteruser_client() {

        String cad = "";
        boolean ok = false;

        cad = create_Client_view.txtUser.getText();
        ok = Validate.okuser(cad);
        if (ok == false) {
            create_Client_view.labUser.setIcon(wrong_data);
            create_Client_view.txtUser.setBackground(Color.red);
            create_Client_view.labUser.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            create_Client_view.labUser.setToolTipText("");
            create_Client_view.labUser.setIcon(good_data);
            create_Client_view.txtUser.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * DAO que valida una introduccion que debe ser mayor a 8 caracteres y
     * pueden ser letras,numeros o caracteres.
     *
     * @return boolean
     */
    public static boolean booleanEnterpassword_client() {

        boolean ok = false;

        char passArray[] = create_Client_view.txtPassword.getPassword();
        String cad = new String(passArray);

        ok = Validate.okpassword(cad);
        if (ok == false) {
            create_Client_view.labPassword.setIcon(wrong_data);
            create_Client_view.txtPassword.setBackground(Color.red);
            create_Client_view.labPassword.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"));

        } else {
            ok = true;
            create_Client_view.labPassword.setToolTipText("");
            create_Client_view.labPassword.setIcon(good_data);
            create_Client_view.txtPassword.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * DAO que valida una entrada de salario float, debe estar entre 800 y 2500.
     *
     * @return boolean
     */
    public static boolean booleanEnterpurchase_client() {

        String s = "";
        float sal = 0.0f;

        boolean ok = false;

        s = create_Client_view.txtPurchase.getText();

        if (Validate.oksalary(s) == true) {
            sal = Float.parseFloat(s);
            ok = true;

            if ((sal >= 800) && (sal <= 2500)) {
                ok = true;
                create_Client_view.labPurchase.setToolTipText("");
                create_Client_view.labPurchase.setIcon(good_data);
                create_Client_view.txtPurchase.setBackground(Color.GREEN);

                // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
                //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            } else {
                ok = false;
                create_Client_view.labPurchase.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + ",debe estar comprendido entre 800 y 2500");
                create_Client_view.labPurchase.setIcon(wrong_data);
                create_Client_view.txtPurchase.setBackground(Color.RED);
            }
        } else {

            ok = false;
            create_Client_view.labPurchase.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_data_correctly") + ", quizas introdujo letras");
            create_Client_view.labPurchase.setIcon(wrong_data);
            create_Client_view.txtPurchase.setBackground(Color.RED);
        }

        return ok;
    }

    /**
     * DAO que valida una fecha de nac imiento que deb estar entre 16 y 65 años
     *
     * @return
     */
    public static boolean booleanEnterdate_birth_client() {

        String s = "";

        boolean ok = false;

        s = ((JTextFieldDateEditor) create_Client_view.pick_date_birth.getDateEditor()).getText();

        ok = Date_min_max_condition_boolean(s, 16, 65);

        if (ok == false) {

            if (singletonapp.passdate == 0) {
                create_Client_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"));
            }
            if (singletonapp.passdate == 1) {
                create_Client_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"));

            }
            if (singletonapp.passdate == 2) {
                create_Client_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_can_not_register,_you_must_be") + 16 + Lang.getInstance().getProperty("years"));

            }

            create_Client_view.pick_date_birth.setBackground(Color.red);
            create_Client_view.labdate_birth.setIcon(wrong_data);

        } else {
            create_Client_view.labdate_birth.setToolTipText("");
            create_Client_view.pick_date_birth.setBackground(Color.GREEN);
            create_Client_view.labdate_birth.setIcon(good_data);
        }

        return ok;
    }

    /**
     * DAO que valida una fecha de contratacion que debe validarse dependiendo
     * de la de nacimiento
     *
     * @return
     */
    public static boolean booleanEnterdate_reg_client() {

        String s = "";

        boolean ok = false;

        String date_reg;

        s = ((JTextFieldDateEditor) create_Client_view.pick_date_birth.getDateEditor()).getText();//coge la refernecia de la fecha de nacimiento.

        date_reg = ((JTextFieldDateEditor) create_Client_view.pick_date_reg.getDateEditor()).getText();

        if (s.equals("") || date_reg.equals("")) {

            create_Client_view.labdate_reg.setToolTipText("Revise las fechas algun campo esta en blanco");
            create_Client_view.pick_date_reg.setBackground(Color.red);
            create_Client_view.labdate_reg.setIcon(wrong_data);

        } else {
            ClassDate contr = new ClassDate(date_reg);

            ok = Date_registered_boolean(contr, s, 16);

            if (ok == false) {
                if (singletonapp.passdate == 4) {
                    create_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"));
                }
                if (singletonapp.passdate == 0) {
                    create_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"));
                }
                if (singletonapp.passdate == 1) {
                    create_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty("The_date_may_not_be_later_than_the_system"));
                }
                if (singletonapp.passdate == 2) {
                    create_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty("The_record_date_may_not_be_earlier_wing_of_birth"));
                }
                if (singletonapp.passdate == 3) {
                    create_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty("On_this_date_you_were_not_of_legal_age"));
                }

                create_Client_view.pick_date_reg.setBackground(Color.red);
                create_Client_view.labdate_reg.setIcon(wrong_data);

            } else {
                create_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty(""));
                create_Client_view.pick_date_reg.setBackground(Color.GREEN);
                create_Client_view.labdate_reg.setIcon(good_data);
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
    public static ClassDate Enter_date_birth_client() {

        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_Client_view.pick_date_birth.getCalendar();

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
    public static ClassDate Enter_date_reg_client() {

        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = create_Client_view.pick_date_reg.getCalendar();

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
    public static void EnterAvatar_client() {

        JFileChooser dlg = new JFileChooser();
        dlg.setCurrentDirectory(new File("src/Appweb/Modules/Users/Img/Avatares/"));
        dlg.setAcceptAllFileFilterUsed(false);
        dlg.addChoosableFileFilter(new FileNameExtensionFilter("JPG (*.jpg)", "jpg"));
        int option = dlg.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = dlg.getSelectedFile().getPath();
            String dir = dlg.getSelectedFile().toString();
            create_Client_view.labAvatar.setIcon(new ImageIcon(file));
            //Modificando la imagen
            ImageIcon icon = new ImageIcon(file);
            //Se extrae la imagen del icono
            Image img = icon.getImage();
            //Se modifica su tamaño
            Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            //Se coloca el nuevo icono modificado
            create_Client_view.labAvatar.setIcon(newIcon);
            //Se cambia el tamaño de la etiqueta
            create_Client_view.labAvatar.setSize(470, 290);

            try {

                File source = new File(dir);
                File dest = new File("src/Appweb/Modules/Users/Img/Avatares/" + source.getName());
                create_Client_view.labAvatar.setToolTipText(dest.toString());
                copyFileUsingJava7Files(source, dest);

            } catch (HeadlessException | IOException e) {

            }

        }
    }

    public static void copyFileUsingJava7Files(File source, File dest)
            throws IOException {

        Files.copy(source.toPath(), dest.toPath());

    }

    public static Client add_create_client() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", Premium = "", client_type = "";
        ClassDate date_reg = null;
        String Status = "";

        float purchase = 0.000f;
        ClassDate Date_birth = null;
        char[] password = create_Client_view.txtPassword.getPassword();
        Client c = null;
        String Avatar = null;

        boolean pass, pass1, pass2, pass3, pass4, pass5, pass6, pass7, pass8, pass9, pass10;

        pass = booleanEnterdnic();
        pass1 = booleanEntername_client();
        pass2 = booleanEnterlast_name_client();
        pass3 = booleanEntermobile_client();
        pass4 = booleanEntermail_client();
        pass5 = booleanEnteruser_client();
        pass6 = booleanEnterpassword_client();
        pass7 = booleanEnterpurchase_client();
        pass9 = booleanEnterdate_birth_client();
        pass10 = booleanEnterdate_reg_client();

        if (pass == true && pass1 == true && pass2 == true && pass3 == true && pass4 == true && pass5 == true && pass6 == true && pass7 == true && pass9 == true && pass10 == true) {
            // Enter User atributtes
            Dni = create_Client_view.txtDni.getText().toUpperCase();
            Name = create_Client_view.txtName.getText();
            Last_name = create_Client_view.txtLast_name.getText();
            Mobile = create_Client_view.txtMobile.getText();
            Date_birth = Enter_date_birth_client();
            Email = create_Client_view.txtEmail.getText();
            User = create_Client_view.txtUser.getText();
            Password = new String(password);
            Avatar = create_Client_view.labAvatar.getToolTipText();
            Status = create_Client_view.comboStatus.getSelectedItem().toString();
            Premium = create_Client_view.combo_premium.getSelectedItem().toString();
            client_type = create_Client_view.combo_client.getSelectedItem().toString();

            // Enter Admin attributes
            date_reg = Enter_date_reg_client();
            purchase = Float.parseFloat(create_Client_view.txtPurchase.getText());

            c = new Client(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_reg, purchase, Premium, client_type);
        } else {
            c = null;
        }
        return c;
    }

    //////////////Daos para la ventana de editar Admin ////////
    public static void Load_edit_client() {

        Client c = singleclient.Client_array.get(singletonapp.pos);

        Float sal = c.getPurchase();

        ClassDate date_birth = new ClassDate(c.getDate_birth().todate());
        ClassDate date_reg = new ClassDate(c.getEntry_date().todate());

        edit_Client_view.txtDni.setText(c.getDni());
        edit_Client_view.txtName.setText(c.getName());
        edit_Client_view.txtLast_name.setText(c.getLast_name());
        edit_Client_view.txtMobile.setText(c.getMobile());

        edit_Client_view.txtEmail.setText(c.getEmail());
        edit_Client_view.txtUser.setText(c.getUser());
        edit_Client_view.txtPassword.setText(c.getPassword());

        edit_Client_view.txtPurchase.setText("" + sal);

        load_EditAvatar_client(c.getAvatar());
        edit_Client_view.pick_date_birth.setCalendar(date_birth.string_to_cal());
        edit_Client_view.pick_date_reg.setCalendar(date_reg.string_to_cal());

    }

    public static void load_EditAvatar_client(String file) {

        edit_Client_view.labAvatar.setIcon(new ImageIcon(file));
        //Modificando la imagen
        ImageIcon icon = new ImageIcon(file);
        //Se extrae la imagen del icono
        Image img = icon.getImage();
        //Se modifica su tamaño
        Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
        //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
        ImageIcon newIcon = new ImageIcon(newimg);
        //Se coloca el nuevo icono modificado
        edit_Client_view.labAvatar.setIcon(newIcon);
        //Se cambia el tamaño de la etiqueta
        edit_Client_view.labAvatar.setSize(470, 290);
        edit_Client_view.labAvatar.setToolTipText(file);
    }

    public static boolean booleanEditname_client() {

        boolean ok = false;
        String name = edit_Client_view.txtName.getText();
        ok = Validate.okword(name);
        if (ok == false) {

            edit_Client_view.labName.setIcon(wrong_data);
            edit_Client_view.txtName.setBackground(Color.red);
            edit_Client_view.labName.setToolTipText("No ha introducido los datos correctamente");
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            edit_Client_view.labName.setToolTipText("");
            edit_Client_view.labName.setIcon(good_data);
            edit_Client_view.txtName.setBackground(Color.GREEN);

        }

        return ok;
    }

    public static boolean booleanEditlast_name_client() {

        boolean ok = false;
        String name = edit_Client_view.txtLast_name.getText();
        ok = Validate.okword(name);
        if (ok == false) {
            edit_Client_view.labLast_name.setIcon(wrong_data);
            edit_Client_view.txtLast_name.setBackground(Color.red);
            edit_Client_view.labLast_name.setToolTipText("No ha introducido los datos correctamente");
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            edit_Client_view.labLast_name.setToolTipText("");
            edit_Client_view.labLast_name.setIcon(good_data);
            edit_Client_view.txtLast_name.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pise un numero de telefono movil con nueve digitos.
     *
     * @return string movil
     */
    public static boolean booleanEditmobile_client() {

        String s = "";
        boolean ok = false;

        s = edit_Client_view.txtMobile.getText();
        ok = Validate.okmobile(s);
        if (ok == false) {
            edit_Client_view.labMobile.setIcon(wrong_data);
            edit_Client_view.txtMobile.setBackground(Color.red);
            edit_Client_view.labMobile.setToolTipText("No ha introducido los datos correctamente, solo puede contener 9 numeros");
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            edit_Client_view.labMobile.setToolTipText("");
            edit_Client_view.labMobile.setIcon(good_data);
            edit_Client_view.txtMobile.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide un email y valida su formato.
     *
     * @return
     */
    public static boolean booleanEditmail_client() {

        String cad = "";
        boolean ok = false;

        cad = edit_Client_view.txtEmail.getText();
        ok = Validate.okmail(cad);
        if (ok == false) {
            edit_Client_view.labEmail.setIcon(wrong_data);
            edit_Client_view.txtEmail.setBackground(Color.red);
            edit_Client_view.labEmail.setToolTipText("No ha introducido los datos correctamente,Ejemplo: xxxx@xxx.xxx");

            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            edit_Client_view.labEmail.setToolTipText("");
            edit_Client_view.labEmail.setIcon(good_data);
            edit_Client_view.txtEmail.setBackground(Color.GREEN);

        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEdituser_client() {

        String cad = "";
        boolean ok = false;

        cad = edit_Client_view.txtUser.getText();
        ok = Validate.okuser(cad);
        if (ok == false) {
            edit_Client_view.labUser.setIcon(wrong_data);
            edit_Client_view.txtUser.setBackground(Color.red);
            edit_Client_view.labUser.setToolTipText("No ha introducido los datos correctamente");
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            edit_Client_view.labUser.setToolTipText("");
            edit_Client_view.labUser.setIcon(good_data);
            edit_Client_view.txtUser.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEditpassword_client() {

        boolean ok = false;

        char passArray[];
        passArray = edit_Client_view.txtPassword.getPassword();
        String cad = new String(passArray);

        ok = Validate.okpassword(cad);
        if (ok == false) {
            edit_Client_view.labPassword.setIcon(wrong_data);
            edit_Client_view.txtPassword.setBackground(Color.red);
            edit_Client_view.labPassword.setToolTipText("No ha introducido los datos correctamente,Debe contener mayusculas,numeros y letras");
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        } else {
            ok = true;
            edit_Client_view.labPassword.setToolTipText("");
            edit_Client_view.labPassword.setIcon(good_data);
            edit_Client_view.txtPassword.setBackground(Color.GREEN);
        }

        return ok;
    }

    /**
     * Menu que pide una palabra que puede tener todo tipo de caracteres.
     *
     * @return
     */
    public static boolean booleanEditpurchase_client() {

        String s = "";
        float sal = 0.0f;

        boolean ok = false;

        s = edit_Client_view.txtPurchase.getText();
        // ok = ;

        if (Validate.oksalary(s) == true) {

            try {
                sal = Float.parseFloat(s);
            } catch (Exception e) {
                e.printStackTrace();
            }

            ok = true;

            if ((sal >= 0) && (sal <= 2500)) {
                ok = true;
                edit_Client_view.labPurchase.setToolTipText("");
                edit_Client_view.labPurchase.setIcon(good_data);
                edit_Client_view.txtPurchase.setBackground(Color.GREEN);
                // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
                //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            } else {
                ok = false;
                edit_Client_view.labPurchase.setToolTipText("No ha introducido los datos correctamente,Debe estar comprendido entre 0 y 2500");
                edit_Client_view.labPurchase.setIcon(wrong_data);
                edit_Client_view.txtPurchase.setBackground(Color.RED);
            }
        } else {
            ok = false;
            edit_Client_view.labPurchase.setToolTipText("No ha introducido los datos correctamente, quizas introdujo letras");
            edit_Client_view.labPurchase.setIcon(wrong_data);
            edit_Client_view.txtPurchase.setBackground(Color.RED);
        }

        return ok;
    }

    public static boolean booleanEditdate_birth_client() {

        String s = "";

        boolean ok = false;

        s = ((JTextFieldDateEditor) edit_Client_view.pick_date_birth.getDateEditor()).getText();

        ok = Date_tools.Date_min_condition_boolean(s, 18);

        if (ok == false) {

            if (singletonapp.passdate == 0) {
                edit_Client_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"));
            }
            if (singletonapp.passdate == 1) {
                edit_Client_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"));

            }
            if (singletonapp.passdate == 2) {
                edit_Client_view.labdate_birth.setToolTipText(Lang.getInstance().getProperty("You_can_not_register,_you_must_be") + 16 + Lang.getInstance().getProperty("years"));

            }

            edit_Client_view.pick_date_birth.setBackground(Color.red);
            edit_Client_view.labdate_birth.setIcon(wrong_data);

        } else {
            edit_Client_view.labdate_birth.setToolTipText("");
            edit_Client_view.pick_date_birth.setBackground(Color.GREEN);
            edit_Client_view.labdate_birth.setIcon(good_data);
        }

        return ok;
    }

    public static boolean booleanEditdate_reg_client() {

        String s = "";
        boolean ok = false;
        String date_reg;

        s = ((JTextFieldDateEditor) edit_Client_view.pick_date_birth.getDateEditor()).getText();

        date_reg = ((JTextFieldDateEditor) edit_Client_view.pick_date_reg.getDateEditor()).getText();

        if (s.equals("") || date_reg.equals("")) {

            edit_Client_view.labdate_reg.setToolTipText("Revise las fechas algun campo esta en blanco");
            edit_Client_view.pick_date_reg.setBackground(Color.red);
            edit_Client_view.labdate_reg.setIcon(wrong_data);

        } else {

            ClassDate reg = new ClassDate(date_reg);

            ok = Date_tools.Date_registered_boolean(reg, s, 18);

            if (ok == false) {

                if (singletonapp.passdate == 4) {
                    edit_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"));
                }
                if (singletonapp.passdate == 0) {
                    edit_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"));
                }
                if (singletonapp.passdate == 1) {
                    edit_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty("The_date_may_not_be_later_than_the_system"));
                }
                if (singletonapp.passdate == 2) {
                    edit_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty("The_record_date_may_not_be_earlier_wing_of_birth"));
                }
                if (singletonapp.passdate == 3) {
                    edit_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty("On_this_date_you_were_not_of_legal_age"));
                }

                edit_Client_view.pick_date_reg.setBackground(Color.red);
                edit_Client_view.labdate_reg.setIcon(wrong_data);

            } else {
                edit_Client_view.labdate_reg.setToolTipText(Lang.getInstance().getProperty(""));
                edit_Client_view.pick_date_reg.setBackground(Color.GREEN);
                edit_Client_view.labdate_reg.setIcon(good_data);
            }
        }

        return ok;
    }

    public static ClassDate Edit_date_birth_client() {

        Calendar date_birth;
        int dia = 0, mes = 0, anio = 0;

        date_birth = edit_Client_view.pick_date_birth.getCalendar();

        dia = date_birth.get(Calendar.DATE);
        mes = date_birth.get(Calendar.MONTH) + 1;
        anio = date_birth.get(Calendar.YEAR);

        return new ClassDate(dia, mes, anio);
    }

    public static ClassDate Edit_date_reg_client() {

        Calendar date_reg;
        int dia = 0, mes = 0, anio = 0;

        date_reg = edit_Client_view.pick_date_reg.getCalendar();

        dia = date_reg.get(Calendar.DATE);
        mes = date_reg.get(Calendar.MONTH) + 1;
        anio = date_reg.get(Calendar.YEAR);

        return new ClassDate(dia, mes, anio);
    }

    public static void EditAvatar_client() {

        JFileChooser dlg = new JFileChooser();
        dlg.setCurrentDirectory(new File("src/Appweb/Modules/Users/Img/Avatares/"));
        dlg.setAcceptAllFileFilterUsed(false);
        dlg.addChoosableFileFilter(new FileNameExtensionFilter("JPG (*.jpg)", "jpg"));
        int option = dlg.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            //Obtiene nombre del archivo seleccionado
            String file = dlg.getSelectedFile().getPath();
            String dir = dlg.getSelectedFile().toString();
            edit_Client_view.labAvatar.setIcon(new ImageIcon(file));
            //Modificando la imagen
            ImageIcon icon = new ImageIcon(file);
            //Se extrae la imagen del icono
            Image img = icon.getImage();
            //Se modifica su tamaño
            Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
            //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
            ImageIcon newIcon = new ImageIcon(newimg);
            //Se coloca el nuevo icono modificado
            edit_Client_view.labAvatar.setIcon(newIcon);
            //Se cambia el tamaño de la etiqueta
            edit_Client_view.labAvatar.setSize(470, 290);

            try {

                File source = new File(dir);
                File dest = new File("src/Appweb/Modules/Users/Img/Avatares/" + source.getName());
                edit_Client_view.labAvatar.setToolTipText(dest.toString());
                copyFileUsingJava7Files(source, dest);

            } catch (HeadlessException | IOException e) {

            }

        }
    }

    public static Client modify_edit_client() {

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", Premium = "", Client_type = "";
        ClassDate Date_reg = null;
        String Status = "";

        float Purchase = 0.000f;
        ClassDate Date_birth = null;
        char[] password = edit_Client_view.txtPassword.getPassword();
        Client c = null;
        String Avatar = null;
        boolean ok = false;

        boolean pass1, pass2, pass3, pass4, pass5, pass6, pass7, pass9, pass10;

        pass1 = booleanEditname_client();
        pass2 = booleanEditlast_name_client();
        pass3 = booleanEditmobile_client();
        pass4 = booleanEditmail_client();
        pass5 = booleanEdituser_client();
        pass6 = booleanEditpassword_client();
        pass7 = booleanEditpurchase_client();
        pass9 = booleanEditdate_birth_client();
        pass10 = booleanEditdate_reg_client();

        if (pass1 == true && pass2 == true && pass3 == true && pass4 == true && pass5 == true && pass6 == true && pass7 == true && pass9 == true && pass10 == true) {

            Dni = edit_Client_view.txtDni.getText();
            Name = edit_Client_view.txtName.getText();
            Last_name = edit_Client_view.txtLast_name.getText();
            Mobile = edit_Client_view.txtMobile.getText();
            Date_birth = Edit_date_birth_client();
            Email = edit_Client_view.txtEmail.getText();
            User = edit_Client_view.txtUser.getText();
            Password = new String(password);
            Avatar = edit_Client_view.labAvatar.getToolTipText();
            Status = edit_Client_view.comboStatus.getSelectedItem().toString();

            // Enter Admin attributes
            Premium = edit_Client_view.combo_premium.getSelectedItem().toString();
            Client_type = edit_Client_view.combo_client.getSelectedItem().toString();
            Date_reg = Edit_date_reg_client();
            Purchase = Float.parseFloat(edit_Client_view.txtPurchase.getText());

            c = new Client(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, Date_reg, Purchase, Premium, Client_type);
        } else {
            c = null;
        }
        return c;
    }

    public static void Load_show_client() {

        Client c = singleclient.Client_array.get(singletonapp.pos);

        int age = c.getAge();
        int ant = c.getAntique_c();

        show_Client_view.txtDni.setText(c.getDni());
        show_Client_view.txtName.setText(c.getName());
        show_Client_view.txtLast_name.setText(c.getLast_name());
        show_Client_view.txtMobile.setText(c.getMobile());
        show_Client_view.txtDate_birth.setText(c.getDate_birth().todate());
        show_Client_view.txtAge.setText("" + age);
        show_Client_view.txtEmail.setText(c.getEmail());
        show_Client_view.txtUser.setText(c.getUser());
        show_Client_view.txtPassword.setText(c.getPassword());
        show_Client_view.txtStatus.setText(c.getStatus());
        show_Client_view.txtDate_cont.setText(c.getEntry_date().todate());
        show_Client_view.txtAntique.setText("" + ant);
        show_Client_view.txtPurchase.setText(c.toPurchase());
        show_Client_view.txtBenefits.setText(c.toBenefits());
        show_Client_view.txt_premium.setText(c.getPremium());
        show_Client_view.txt_client.setText(c.getClient_type());
        ShowAvatar_client(c.getAvatar());

    }

    public static void ShowAvatar_client(String file) {

        show_Client_view.labAvatar.setIcon(new ImageIcon(file));
        //Modificando la imagen
        ImageIcon icon = new ImageIcon(file);
        //Se extrae la imagen del icono
        Image img = icon.getImage();
        //Se modifica su tamaño
        Image newimg = img.getScaledInstance(140, 170, java.awt.Image.SCALE_SMOOTH);
        //SE GENERA EL IMAGE ICON CON LA NUEVA IMAGEN
        ImageIcon newIcon = new ImageIcon(newimg);
        //Se coloca el nuevo icono modificado
        show_Client_view.labAvatar.setIcon(newIcon);
        //Se cambia el tamaño de la etiqueta
        show_Client_view.labAvatar.setSize(470, 290);
        show_Client_view.labAvatar.setToolTipText(file);

    }

    public static void save_json_client() {

        if (singleclient.Client_array.size() != 0) {

            String PATH = null;
            try {
                XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
                xstreamjson.setMode(XStream.NO_REFERENCES);
                xstreamjson.alias("Client", Client.class);

                JFileChooser fileChooser = new JFileChooser();

                fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("JSON (*.json)", "json"));

                int seleccion = fileChooser.showSaveDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File JFC = fileChooser.getSelectedFile();
                    PATH = JFC.getAbsolutePath();
                    PATH = PATH + ".json";

                    Gson gson = new Gson();
                    String json = gson.toJson(singleclient.Client_array);
                    FileWriter fileXml = new FileWriter(PATH);
                    fileXml.write(json.toString());
                    fileXml.close();

                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("User_file_saved") + " Client json",
                            Lang.getInstance().getProperty("File") + " json", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("Failed_to_save_user") + " Client json", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }

        } else {

            JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("No_data_to_save"), Lang.getInstance().getProperty("File") + " json",
                    JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void save_txt_client() {

        if (singleclient.Client_array.size() != 0) {

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
                    o.writeObject(singleclient.Client_array);
                    o.close();
                    JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {

            JOptionPane.showMessageDialog(null, "No hay datos para guardar", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);

        }
    }

    public static void save_xml_client() {

        if (singleclient.Client_array.size() != 0) {

            String PATH = " ";

            try {
                OutputStream os = new ByteArrayOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(os);
                XStream xstream = new XStream();
                Annotations.configureAliases(xstream, Client.class);

                String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
                xstream.toXML(singleclient.Client_array, osw);
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

    public static void auto_save_json_client() {

        String PATH = " ";

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/Client/Model/Client_files/clientusers";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
            xstreamjson.setMode(XStream.NO_REFERENCES);
            xstreamjson.alias("Client", Client.class);

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();
            PATH = PATH + ".json";

            Gson gson = new Gson();
            String json = gson.toJson(singleclient.Client_array);
            FileWriter fileXml = new FileWriter(PATH);
            fileXml.write(json.toString());
            fileXml.close();

            System.out.print(Lang.getInstance().getProperty("User_file_saved") + " Client json \n");

        } catch (Exception e) {
            System.out.print(Lang.getInstance().getProperty("Failed_to_save_user") + " Client json" + " \n");
        }
    }

    public static void auto_open_json_client() {

        String PATH = " ";

        Client c = new Client("");

        try {
            PATH = new java.io.File(".").getCanonicalPath() + "/src/Appweb/Modules/Users/Client/Model/Client_files/clientusers.json";
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            XStream xstream = new XStream(new JettisonMappedXmlDriver());
            xstream.setMode(XStream.NO_REFERENCES);
            xstream.alias("Client", Client.class);

            File JFC = new File(PATH);
            PATH = JFC.getAbsolutePath();

            singleclient.Client_array.clear();

            JsonReader lector = new JsonReader(new FileReader(PATH));
            JsonParser parseador = new JsonParser();
            JsonElement raiz = parseador.parse(lector);

            Gson json = new Gson();
            JsonArray lista = raiz.getAsJsonArray();
            for (JsonElement elemento : lista) {
                c = json.fromJson(elemento, Client.class);
                singleclient.Client_array.add(c);

            }
            System.out.print(Lang.getInstance().getProperty("Loaded_user_file") + " Client json" + " \n");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(Lang.getInstance().getProperty("Error_loading_user_file") + " json" + " \n");
        }
    }
}
