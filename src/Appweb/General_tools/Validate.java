package Appweb.General_tools;

import Appweb.Modules.Config.Classes.Classconfig;

/**
 *
 * @author Jorge Martinez Frias Funciones para validar parametros de entrada con
 * formas regulares.
 */
public class Validate {

    private static final String okdni = "^([0-9]{8}+[a-zA-Z]{1})";
    private static final String okword = "^([A-Za-z ÑñÁÀÉÈÓÒÚàáéàíóàú]{1,60})";
    private static final String okmobile = "^[0-9]{9}$";
    private static final String okmail = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final String okpassword = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    private static final String oksalary = "^(\\d|-)?(\\d|,)*\\.?\\d*$";
    private static final String okuser = "[a-zA-Z1-9À-ÖØ-öø-ÿ]{4,15}";
     

    /**
     * Valida un dni devolviendo un boolean.
     *
     * @param dni
     * @return true|false
     */
    public static boolean okdni(String dni) {
        return dni.matches(okdni);
    }

    /**
     * Valida un nombre con espacios devolviendo un boolean.
     *
     * @param word
     * @return true|false
     */
    public static boolean okword(String word) {
        return word.matches(okword);
    }

    /**
     * Valida un numero de movil de nueve digitos devolviendo un boolean.
     *
     * @param mobile
     * @return true|false
     */
    public static boolean okmobile(String mobile) {
        return mobile.matches(okmobile);
    }

    /**
     * Valida un formato de fecha devolviendo un boolean. Los formatos pueden
     * ser: dd/mm/yyyy,dd-mm-yyyy,yyyy/mm/dd,yyyy-mm-dd.
     *
     * @param date
     * @return true|false
     */
    public static boolean okdate(String date) {

        String okdate = "";

        switch (Classconfig.getInstance().getdatef()) {

            case "dd/mm/yyyy":

                okdate = "(0[1-9]|1[0-9]|3[01]|[0-9]|2[0-9])[/](0[1-9]|1[1-9]|[0-9])[/]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";
                break;

            case "dd-mm-yyyy":

                okdate = "(0[1-9]|1[0-9]|3[01]|[0-9]|2[0-9])[-](0[1-9]|1[1-9]|[0-9])[-]((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))";

                break;

            case "yyyy/mm/dd":

                okdate = "((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))[/](0[1-9]|1[1-9]|[0-9])[/](0[1-9]|1[0-9]|3[01]|[0-9]|2[0-9])";

                break;

            case "yyyy-mm-dd":

                okdate = "((175[7-9])|(17[6-9][0-9])|(1[8-9][0-9][0-9])|([2-9][0-9][0-9][0-9]))[-](0[1-9]|1[1-9]|[0-9])[-](0[1-9]|1[0-9]|3[01]|[0-9]|2[0-9])";

                break;

        }

        return date.matches(okdate);
    }

   

    /**
     * Valida un correo electronico devolviendo un boolean.
     *
     * @param mail
     * @return true|false
     */
    public static boolean okmail(String mail) {
        return mail.matches(okmail);
    }

    /**
     * Valida una palabra con todo tipo de caracteres devolviendo un boolean.
     *
     * @param password
     * @return true|false
     */
    public static boolean okpassword(String password) {
        return password.matches(okpassword);
    }

    public static boolean oksalary(String salary) {
        return salary.matches(oksalary);
    }
    
     public static boolean okuser(String user) {
        return user.matches(okuser);
    }
}
