package Appweb.Classes.Date;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import Appweb.Modules.Main.Model.Config.Classes.Classconfig;

/**
 *
 * @author Jorge Martinez
 * @version 1.0 start 27_11_2015 Clase fecha
 * Clase fecha.
 *
 */
public class ClassDate implements Serializable {

    private int day;
    private int month;
    private int year;
    private String date;

    /**
     * Constructor one all attributes
     * Construye el objeto con los tres atributos individuales.
     *
     * @param day int
     * @param month int
     * @param year int
     */
    public ClassDate(int day, int month, int year) {

        this.day = day;
        this.month = month;
        this.year = year;
        this.date = day + "/" + month + "/" + year;

    }

    /**
     * Contstructor de fecha para que recoja la fecha en un unico formato de
     * barras.
     * Se utiliza para pintar la fecha en bases de datos y que no influya en la
     * configuracion de fecha.
     *
     * @param date String
     * @param i    int
     */
    public ClassDate(String date, int i) {

        String[] tool = new String[3];
        String datechoice = "";

        tool = date.split("/");
        this.day = Integer.parseInt(tool[0]);
        this.month = Integer.parseInt(tool[1]);
        this.year = Integer.parseInt(tool[2]);
        datechoice = day + "/" + month + "/" + year;
        this.date = datechoice;

    }

    /**
     * Constructor vacio
     */
    public ClassDate() {

    }

    /**
     * Constructor con formato heredado Acepta el formato de fecha de cada caso
     * pero devolvemos el que tenemos por defecto para trbajar con el
     * internamente.
     *
     * @param date String
     */
    public ClassDate(String date) {

        String[] tool = new String[3];
        String datechoice = "";

        switch (Classconfig.getInstance().getdatef()) {

            case "dd/MM/yyyy":
                tool = date.split("/");
                this.day = Integer.parseInt(tool[0]);
                this.month = Integer.parseInt(tool[1]);
                this.year = Integer.parseInt(tool[2]);
                datechoice = day + "/" + month + "/" + year;
                this.date = datechoice;

                break;

            case "dd-MM-yyyy":
                tool = date.split("-");
                this.day = Integer.parseInt(tool[0]);
                this.month = Integer.parseInt(tool[1]);
                this.year = Integer.parseInt(tool[2]);
                datechoice = day + "/" + month + "/" + year;
                this.date = datechoice;

                break;

            case "yyyy/MM/dd":
                tool = date.split("/");
                this.day = Integer.parseInt(tool[2]);
                this.month = Integer.parseInt(tool[1]);
                this.year = Integer.parseInt(tool[0]);
                datechoice = day + "/" + month + "/" + year;
                this.date = datechoice;

                break;

            case "yyyy-MM-dd":
                tool = date.split("-");
                this.day = Integer.parseInt(tool[2]);
                this.month = Integer.parseInt(tool[1]);
                this.year = Integer.parseInt(tool[0]);
                datechoice = day + "/" + month + "/" + year;
                this.date = datechoice;

                break;

            case "":

                datechoice = 01 + "/" + 01 + "/" + 2020;
                this.date = datechoice;

                break;
        }
    }

    /**
     *
     * Getter del dia.
     *
     * @return int dia
     */
    public int getDay() {
        return day;
    }

    /**
     * Setter del dia
     *
     * @param day int
     */
    public void setDay(int day) {
        this.day = day;

    }

    /**
     * Getter del mes
     *
     * @return int mes
     */
    public int getMonth() {
        return month;
    }

    /**
     * Setter del mes
     *
     * @param month int
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Getter del año
     *
     * @return int año
     */
    public int getYear() {
        return year;
    }

    /**
     * Setter del year
     *
     * @param year int year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Getter de la fecha
     *
     * @return string fecha
     */
    public String getDate() {
        return date;

    }

    /**
     * Estos sets añadidos modificaran los atributos cada vez que cambie la
     * fecha.
     * @param date string
     */
    public void setDate(String date) {

        this.date = date;
        this.setDay(Dayint(date));
        this.setMonth(Monthint(date));
        this.setYear(Yearint(date));

    }

    /**
     * En la ultima version utilizo el to string
     * para que imprima solo en formato de barras.
     *
     * @return string fecha en formato barras
     */
    public String toString() {

        StringBuffer buffer = new StringBuffer();

        buffer.append(getDay() + "/" + getMonth() + "/" + getYear());

        return buffer.toString();
    }

    /**
     * Print attribute date. Imprime la fecha en el formato que le digamos en
     * la configuracion.
     *
     * @return string fecha
     */
    public String todate() {

        String cad = "";

        switch (Classconfig.getInstance().getdatef()) {

            case "dd/MM/yyyy":
                cad = getDay() + "/" + getMonth() + "/" + getYear();
                break;
            case "dd-MM-yyyy":
                cad = getDay() + "-" + getMonth() + "-" + getYear();
                break;
            case "yyyy/MM/dd":
                cad = getYear() + "/" + getMonth() + "/" + getDay();
                break;
            case "yyyy-MM-dd":
                cad = getYear() + "-" + getMonth() + "-" + getDay();
                break;
        }

        return cad;
    }

    ////// Extract individual data of a string//////
    /**
     * Extrae el dia de una fecha y devuelve un int.
     *
     * @param date String
     *
     * @return int dia
     */
    public int Dayint(String date) {

        String[] SplitArray = null;
        int day = 0;

        SplitArray = date.split("/");
        day = Integer.parseInt(SplitArray[0]);

        return day;
    }

    /**
     * Extrae el mes de una fecha y devuelve un int.
     *
     * @param date String
     *
     * @return int mes
     */
    public int Monthint(String date) {

        String[] SplitArray = null;
        int month = 0;

        SplitArray = date.split("/");
        month = Integer.parseInt(SplitArray[1]);

        return month;

    }

    /**
     * Extrae el year de una fecha y devuelve un int.
     *
     * @param date String
     *
     * @return int year
     */
    public int Yearint(String date) {

        String[] SplitArray = null;
        int year = 0;

        SplitArray = date.split("/");
        year = Integer.parseInt(SplitArray[2]);

        return year;

    }

    ////// Class methods for different operations///////
    /**
     * Method to validate a date, valid year between 1900 and 2100 validates
     * month from 1 to 12 valid day of month 30,31,28 and 29 days
     *
     * @return boolean true/false
     */
    public boolean okdate() {

        boolean correcto = true;
        boolean okyear = true;
        boolean okmonth = true;
        boolean okday = true;
        GregorianCalendar fecha = new GregorianCalendar();

        // It is used to know the days of the month
        // We use an array.
        int[] daymonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // valid year between 1900 and 2100
        if ((this.year >= 1900) && (this.year <= 2100)) {

            okyear = true;

        } else {

            okyear = false;

        }

        // validates month from 1 to 12
        if ((this.month >= 1) && (this.month <= 12)) {

            okmonth = true;

        } else {
            okmonth = false;

        }

        // valid day of month 30,31,28 and 29 days
        if ((this.day < 1) || (this.day > daymonth[this.month])) {

            okday = false;
        } else {

            okday = true;

        }

        // Checks if the year is leap
        if (fecha.isLeapYear(this.year)) {// check with 29/02/2012

            // Check if the position two in the array corresponds to a leap year
            daymonth[2] = 29;
            okday = true;
        }
        // If all three conditions are correct return a true
        if ((okyear == true) && (okmonth == true) && (okday == true)) {

            correcto = true;

        } else {

            correcto = false;
        }

        return correcto;

    }

    /**
     * Subtract method in which the system date to our date
     *
     * @return int years
     */
    public int Diference_system_date() {

        int years = 0;
        Calendar system = Calendar.getInstance();// objeto calendar
        Calendar mydate = this.string_to_cal();// pasamos string de mi fecha a

        // objeto calendar
        long systemmilis = 0;
        long mydatemilis = 0;
        long diferencia = 0;

        // pasamos a milisegundos y restamos
        systemmilis = system.getTimeInMillis();
        mydatemilis = mydate.getTimeInMillis();
        diferencia = systemmilis - mydatemilis;

        // pasamos el resultado a a�os casteando a int
        years = (int) (diferencia / (24 * 60 * 60 * 1000)) / 365;

        return years;
    }

    /**
     * Method that subtracts two dates
     *
     * @param date Classdate
     * @return int years
     */
    public int Diference_two_dates(ClassDate date) {
        // en el metodo metermos la
        // fecha que queremos restar
        // a la anterior
        int years;
        long date1milis = 0;
        long date2milis = 0;
        long diferencia = 0;

        Calendar date1 = date.string_to_cal();// Fecha 1 la que restara
        Calendar date2 = this.string_to_cal();// Fecha dos a la que se le
        // restara

        // pasamos a milisegundos y restamos
        date1milis = date1.getTimeInMillis();
        date2milis = date2.getTimeInMillis();
        diferencia = date2milis - date1milis;

        // pasamos el resultado a años casteando a int
        years = (int) (diferencia / (24 * 60 * 60 * 1000)) / 365;

        return years;
    }

    /**
     * Method that compares a date to the system
     *
     * @return boolean true/false
     */
    public int Date_compare_system_date() {

        int ok = 0;
        // utilizamos metodo para pasar nuestra fecha a calendar
        Calendar mydate = this.string_to_cal();
        // Creamos objeto calendar con la fecha actual
        Calendar systemdate = Calendar.getInstance();

        if (mydate.before(systemdate)) {// con before comparamos si es anterior

            ok = 0;
        } else if (mydate.equals(systemdate)) {// con equals comparamos si es
            // igual

            ok = 1;

        } else if (mydate.after(systemdate)) {// con after comparamos si la
            // fecha es posterior, en este
            // caso devolvemos un false

            ok = 2;

        }
        return ok;
    }

    /**
     * Method that compares two dates
     * Devuelve un int 0,1,2 dependiendo la condicion si es anterior,igual o
     * posterior
     *
     * @param date2 ClassDate
     *
     * @return int
     */
    public int Date_compare_two_dates(ClassDate date2) {

        int ok = 0;

        Calendar firstdate = this.string_to_cal();
        Calendar seconddate = date2.string_to_cal();

        if (firstdate.before(seconddate)) {

            ok = 0;// devuelve 0 si es anterior
        } else if (firstdate.equals(seconddate)) {

            ok = 1;// devuelve 1 si es igual

        } else if (firstdate.after(seconddate)) {

            ok = 2;// devuelve 2 si es posterior

        }

        return ok;
    }

    /**
     * method to pass String to calendar
     *
     * @return Calendar
     */
    public Calendar string_to_cal() {

        // declaramos objeto calendar
        Calendar dat = Calendar.getInstance();

        try {

            // declaramos objeto simpleformat para que saque este formato
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            // pasamos el string date a simple format y de ahi a calendar
            dat.setTime(sdf.parse(this.date));

        } catch (Exception e) {

            return dat;

        }
        // retornamos un objeto calendar.
        return dat;
    }

    /**
     * method to pass Calendar a string
     *
     * @param c Calendar
     *
     * @return String s
     */
    public String cal_to_string(Calendar c) {

        String s = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        if (c != null) {

            // cogemos el objeto calendar y con format lo pasamos a un string
            s = sdf.format(c.getTime());
        }

        return s;
    }

}
