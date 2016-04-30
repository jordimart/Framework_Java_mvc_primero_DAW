package Appweb.General_tools;

import Appweb.Classes.Date.ClassDate;

/**
 *
 * @author Jorge Martinez Frias
 *
 *
 */
public class Date_tools {

    /**
     * Valida un fecha de entrada en string y con una condicion minimaque puede
     * ser la edad.
     *
     * @param date String
     * @param min  int
     *
     * @return true/false
     */
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

            }

            if (age >= min) {

                val1 = true;

            } else {
                val1 = false;
                singletonapp.passdate = 2;

            }
        } // end first if
        else {

            val1 = false;
            singletonapp.passdate = 0;

        }

        return val1;
    }

    /**
     * Validamos una fecha de entrada teniendo en cuenta que que cumpla un
     * maximo
     * de años y un minimo.
     *
     * @param date String
     * @param min  int
     * @param max  int
     *
     * @return true/false
     */
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

            }
            // Controlamos que la edad este entre 16 y 18 a�os
            if ((age >= min) && (age <= max)) {

                val1 = true;

            } else {
                singletonapp.passdate = 1;
                val1 = false;

            }

        } // fin del if 1
        else {

            val1 = false;
            singletonapp.passdate = 0;

        }

        return val1;
    }

    /**
     * Validar una fecha de registro que tenga en cuenta otra fecha introducida
     * previamente.
     *
     * @param d    ClassDate
     * @param date String
     * @param min  int
     *
     * @return boolean true/false
     */
    public static boolean Date_registered_boolean(ClassDate d, String date, int min) {

        boolean val1 = false;
        boolean valok = true;
        boolean valcomps = true;
        boolean valcomp = true;
        boolean valadult = true;
        boolean valbirth = true;
        int age = 0;

        // validamos el formato con forma regular.
        val1 = Validate.okdate(date);

        if (val1 == true) {

            ClassDate c = new ClassDate(date);

            if (c.okdate() == false) {

                valok = false;
                // calculamos la edad
                singletonapp.passdate2 = 0;

            } else if (d == null) {
                valbirth = false;

            } else {

                age = d.Diference_two_dates(c);
            }

            if (d.Date_compare_system_date() == 2) {
                singletonapp.passdate2 = 1;
                valcomps = false;

            }
            if (d.Date_compare_two_dates(c) == 0) {
                singletonapp.passdate2 = 2;
                valcomp = false;

            }
            if (age < min) {

                valadult = false;
                singletonapp.passdate2 = 3;

            }

            if ((valok == true) && (valcomps == true) && (valcomp == true) && (valadult == true) && (valbirth == true)) {

                val1 = true;

            } else {
                val1 = false;
            }

        } // fin del if 1
        else {

            val1 = false;
            singletonapp.passdate2 = 4;

        }

        return val1;
    }
}// fin del funciones
