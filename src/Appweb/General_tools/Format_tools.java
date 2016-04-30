package Appweb.General_tools;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Jorge Martinez Frias
 *
 */
public class Format_tools {

    /**
     * Aplica el formato de float a un decimal.
     *
     * @param number float
     *
     * @return String
     */
    public static String F_1dec(float number) {
        DecimalFormat format1 = new DecimalFormat(".#");// one decimal
        return format1.format(number);
    }

    /**
     * Aplica el formato de float a dos decimal.
     *
     * @param number float
     *
     * @return String
     */
    public static String F_2dec(float number) {
        DecimalFormat format1 = new DecimalFormat(".##");// two decimales
        return format1.format(number);
    }

    /**
     * Aplica el formato de float a tres decimal.
     *
     * @param number float
     *
     * @return String
     */
    public static String F_3dec(float number) {
        DecimalFormat format1 = new DecimalFormat(".###");// trhee decimales
        return format1.format(number);
    }

    /**
     * Aplica un formato de moneda dolar a un numero float.
     *
     * @param coins float
     *
     * @return string
     */
    public static String F_Dollar(float coins) {
        NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.US);// Dolar

        return coin.format(coins);
    }

    /**
     * Aplica un formato de moneda libras a un numero float.
     *
     * @param coins float
     *
     * @return string
     */
    public static String F_Libra(float coins) {
        NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.UK);// Libras

        return coin.format(coins);
    }

    /**
     * Aplica un formato de moneda euro a un numero float.
     *
     * @param coins float
     *
     * @return string
     */
    public static String F_Euro(float coins) {
        NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.FRANCE);// Euro

        return coin.format(coins);
    }

}
