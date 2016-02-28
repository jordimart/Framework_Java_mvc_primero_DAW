package Appweb.General_tools;

import Appweb.Classes.Date.ClassDate;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge Martinez Frias
 *
 *
 */
public class Date_tools {

    public static boolean Date_min_condition_boolean(String date, int min) {

        boolean val1 = false;
        int age = 0;
        
        

        // validamos el formato con forma regular.
        val1 = Validate.okdate(date);

        if (val1 == true) {

            ClassDate c = new ClassDate(date);

            if (c.okdate() == true) {

                val1 = true;

                // calculamos la edad
                age = c.Diference_system_date();

            } else {

                val1 = false;
                singletonapp.passdate = 1;
                //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"),
                // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            }

            if (age >= min) {

                val1 = true;

            } else {
                val1 = false;
                singletonapp.passdate = 2;
                // JOptionPane.showMessageDialog(null,
                // Lang.getInstance().getProperty("You_can_not_register,_you_must_be") + min + Lang.getInstance().getProperty("years"),
                // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            }
        } // end first if
        else {

            val1 = false;
            singletonapp.passdate = 0;
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        }

        return val1;
    }

    public static boolean Date_min_max_condition_boolean(String date, int min, int max) {

        int age = 0;

        boolean val1 = false;

        val1 = Validate.okdate(date);

        if (val1 == true) {

            ClassDate c = new ClassDate(date);

            // aplicamos metodo de validar fecha existente
            if (c.okdate() == true) {

                val1 = true;
                // calculamos la edad
                age = c.Diference_system_date();
            } // fin okdate
            else {

                val1 = false;
                singletonapp.passdate = 2;
                // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"),
                // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            }
            // Controlamos que la edad este entre 16 y 18 a�os
            if ((age >= min) && (age <= max)) {

                val1 = true;

            } else {
                singletonapp.passdate = 1;
                val1 = false;
                //JOptionPane.showMessageDialog(null,
                // Lang.getInstance().getProperty("The_working_age_must_be_between") + min + Lang.getInstance().getProperty("and") + max
                // + Lang.getInstance().getProperty("years"),
                //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);

            }

        } // fin del if 1
        else {

            val1 = false;
            singletonapp.passdate = 0;
            // JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"),
            // Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        }

        return val1;
    }

    public static boolean Date_registered_boolean(ClassDate d, String date, int min) {

        boolean val1 = false;
        boolean valok = true;
        boolean valcomps = true;
        boolean valcomp = true;
        boolean valadult = true;
        boolean valbirth=true;
        int age = 0;

        // validamos el formato con forma regular.
        val1 = Validate.okdate(date);

        if (val1 == true) {

            ClassDate c = new ClassDate(date);

            // aplicamos los metodos de validar la fecha,comparar que no sea
            // posterior a la del sistema y compara que no sea anterior a la
            // fecha de nacimiento
            if (c.okdate() == false) {

                valok = false;
                // calculamos la edad
                singletonapp.passdate = 0;
                //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("This_date_does_not_exist_in_the_calendar"),
                //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            } else {
                if(d==null){
                    valbirth=false;
                    
                    JOptionPane.showMessageDialog(null,"no hay fecha de nacimiento");
                    
                }else{

                age = d.Diference_two_dates(c);
                }
            }

            if (d.Date_compare_system_date() == 2) {
                singletonapp.passdate = 1;
                valcomps = false;
                //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_date_may_not_be_later_than_the_system"),
                //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            }
            if (d.Date_compare_two_dates(c) == 0) {
                singletonapp.passdate = 2;
                valcomp = false;
                //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("The_record_date_may_not_be_earlier_wing_of_birth"),
                //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            }
            if (age < min) {

                valadult = false;
                singletonapp.passdate = 3;
                //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("On_this_date_you_were_not_of_legal_age"),
                //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
            }

            if ((valok == true) && (valcomps == true) && (valcomp == true) && (valadult == true)&&(valbirth==true)) {

                val1 = true;

            } else {
                val1 = false;
            }

        } // fin del if 1
        else {

            val1 = false;
            singletonapp.passdate = 4;
            //JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("You_haven't_introduced_format_data_correctly"),
            //Lang.getInstance().getProperty("Information"), JOptionPane.INFORMATION_MESSAGE);
        }

        return val1;
    }
}// fin del funciones
