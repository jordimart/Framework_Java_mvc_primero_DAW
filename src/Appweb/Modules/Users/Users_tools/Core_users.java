package Appweb.Modules.Users.Users_tools;

import javax.swing.JOptionPane;

import Appweb.Modules.Config.Classes.Language.Lang;
import Appweb.Modules.Users.Antic_codic.BLL.Look_for_dni;
import Appweb.General_tools.Request_variable;
import Appweb.General_tools.Validate;
import java.awt.Color;

/**
 *
 * @author Jorge Martinez Frias
 * @version 1.0
 *
 */
public class Core_users {

    /**
     * Fucion que valida que el dni pueda existir.Valida para dni generico.
     *
     * @param message
     * @param title
     * @return string dni
     */
    public static String Enterdni(String message, String title) {

        int num = 0, rest = 0;
        char letter = ' ', pass = ' ';
        String dni = "", aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";
        boolean ok = false;

        do {

            dni = Request_variable.damestring(message, title);
            dni = dni.toUpperCase();
            ok = Validate.okdni(dni);

            if (ok == false) {
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
                        Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            } else {

                aux = "";

                for (int i = 0; i < 8; i++) {
                    aux += dni.charAt(i);
                }

                letter = dni.charAt(8);
                num = Integer.parseInt(aux);
                rest = num % 23;

                pass = car.charAt(rest);

                if (pass == letter) {
                    ok = true;
                } else {
                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_Dni_don't_exist"),
                            Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
                    ok = false;
                }
            } // end else

        } while (ok == false);

        return dni;
    }

    

    /**
     * Fucion que valida que el dni pueda existir.Pero ademas comprueba que no
     * este repetido en los Client.
     *
     * @param message
     * @param title
     * @return string dni
     */
    public static String Enterdnic(String message, String title) {

        int num = 0, rest = 0;
        char letter = ' ', pass = ' ';
        String dni = "", aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";
        boolean ok = false;
        int pos = -1;

        do {

            dni = Request_variable.damestring(message, title);
            dni = dni.toUpperCase();
            ok = Validate.okdni(dni);
            if (ok == false) {
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
                        Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            } else {

                aux = "";

                for (int i = 0; i < 8; i++) {
                    aux += dni.charAt(i);
                }

                letter = dni.charAt(8);
                num = Integer.parseInt(aux);
                rest = num % 23;

                pass = car.charAt(rest);

                if (pass == letter) {
                    ok = true;
                } else {
                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_Dni_don't_exist"),
                            Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
                    ok = false;
                }
            } // end else

            if (ok == true) {

                pos = Look_for_dni.Look_for_dni_client(dni);

                if (pos != -1) {

                    ok = false;

                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_repeat_dni"));
                } else {

                    ok = true;
                }

            }

        } while (ok == false);

        return dni;
    }

    /**
     * Fucion que valida que el dni pueda existir.Pero ademas comprueba que no
     * este repetido en los User_reg.
     *
     * @param message
     * @param title
     * @return string dni
     */
    public static String Enterdniu(String message, String title) {

        int num = 0, rest = 0;
        char letter = ' ', pass = ' ';
        String dni = "", aux = "", car = "TRWAGMYFPDXBNJZSQVHLCKET";
        boolean ok = false;
        int pos = -1;

        do {

            dni = Request_variable.damestring(message, title);
            dni = dni.toUpperCase();
            ok = Validate.okdni(dni);
            if (ok == false) {
                JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_data_correctly"),
                        Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            } else {

                aux = "";

                for (int i = 0; i < 8; i++) {
                    aux += dni.charAt(i);
                }

                letter = dni.charAt(8);
                num = Integer.parseInt(aux);
                rest = num % 23;

                pass = car.charAt(rest);

                if (pass == letter) {
                    ok = true;
                } else {
                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_Dni_don't_exist"),
                            Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
                    ok = false;
                }
            } // end else

            if (ok == true) {

                pos = Look_for_dni.Look_for_dni_user_reg(dni);

                if (pos != -1) {

                    ok = false;
                    JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_can_not_repeat_dni"));
                } else {

                    ok = true;
                }

            }

        } while (ok == false);

        return dni;
    }

}
