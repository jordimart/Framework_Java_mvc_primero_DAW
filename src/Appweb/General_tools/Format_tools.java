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

	public static String F_1dec(float number) {
		DecimalFormat format1 = new DecimalFormat(".#");// one decimal
		return format1.format(number);
	}

	public static String F_2dec(float number) {
		DecimalFormat format1 = new DecimalFormat(".##");// two decimales
		return format1.format(number);
	}

	public static String F_3dec(float number) {
		DecimalFormat format1 = new DecimalFormat(".###");// trhee decimales
		return format1.format(number);
	}

	public static String F_Dollar(float coins) {
		NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.US);// Dolar
																		// symbol
		return coin.format(coins);
	}

	public static String F_Libra(float coins) {
		NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.UK);// Libras
																		// symbol
		return coin.format(coins);
	}

	public static String F_Euro(float coins) {
		NumberFormat coin = NumberFormat.getCurrencyInstance(Locale.FRANCE);// Euro
																			// symbol
		return coin.format(coins);
	}

}
