package Appweb.Modules.Main.Model.Config.Classes;

import java.io.Serializable;
import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Config.Model.DAO_config.DAO_config;
import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;
import Appweb.Modules.Users.User_reg.Model.Classes.User_reg;
import Appweb.Modules.Users.User_reg.Model.Classes.singleuser_reg;

/**
 * @author Jorge Martines Frias
 *
 */
@XStreamAlias("Config")
public class Classconfig implements Serializable {

    private static Classconfig instance;

    public static Classconfig getInstance() {

        if (instance == null) {

            instance = new Classconfig();
            Lang.getInstance();

        }
        return instance;

    }

    @XStreamAlias("datef")
    private String datef;
    @XStreamAlias("num_dec")
    private String num_dec;
    @XStreamAlias("currency")
    private String currency;
    @XStreamAlias("language")
    private String language;
    @XStreamAlias("file")
    private String file;
    @XStreamAlias("theme")
    private String theme;
    @XStreamAlias("dummy")
    private boolean dummy;

    /**
     * Constructor all atributes. Se construye a�adiendo todos los atributos.
     *
     * @param currency
     * @param language
     * @param datef
     * @param num_dec
     * @param theme
     */
    public Classconfig(String datef, String num_dec, String currency, String language, String theme) {

        this.datef = datef;
        this.num_dec = num_dec;
        this.currency = currency;
        this.language = language;
        this.theme = theme;

    }

    /**
     * Constructor vacio que carga unos atributos predeterminados.
     * Carga los arrays de usuarios.
     * Carga el dni singleton.
     * Carga un array objeto que servira de apoyo.
     * Contine unos parametros predeterminados.
     */
    public Classconfig() {

        datef = "dd/MM/yyyy";
        num_dec = "0.0";
        currency = "euro";
        language = "english";
        file = "json";
        theme = "Nimbus";

        singleadmin.Admin_array = new ArrayList<Admin>();
        singleclient.Client_array = new ArrayList<Client>();
        singleuser_reg.User_reg_array = new ArrayList<User_reg>();

    }

    /**
     * Obtenemos valor
     *
     * @return String
     */
    public String getdatef() {
        return datef;
    }

    /**
     * Modifica
     *
     * @param datef string
     */
    public void setdatef(String datef) {
        this.datef = datef;
    }

    /**
     * Obtenemos valor
     *
     * @return String
     */
    public String getnum_dec() {
        return num_dec;
    }

    /**
     * Modifica
     *
     * @param num_dec string
     */
    public void setnum_dec(String num_dec) {
        this.num_dec = num_dec;
    }

    /**
     * Obtenemos valor
     *
     * @return String
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Modifica
     *
     * @param currency string
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Obtenemos valor
     *
     * @return String
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Modifica
     *
     * @param language
     */
    public void setLanguage(String language) {
        this.language = language;
        Lang.getInstance().setLanguage();

    }

    /**
     * Obtenemos valor
     *
     * @return String
     */
    public String getFile() {
        return file;
    }

    /**
     * Modifica
     *
     * @param file
     */
    public void setFile(String file) {
        this.file = file;
    }

    /**
     * Obtenemos valor
     *
     * @return String
     */
    public String getTheme() {
        return theme;
    }

    /**
     * Modifica
     *
     * @param theme
     */
    public void setTheme(String theme) {
        this.theme = theme;
        DAO_config.Function_theme();
    }

    /**
     * Print all attributes Tostring con peticion de salida de fecha. En la
     * ultima version utilizo el tostring date para imprimir tipos de formato.
     *
     * @return
     */
    public String tostring() {

        StringBuffer buffer = new StringBuffer();

        buffer.append(Lang.getInstance().getProperty("Date_format") + ": " + this.getdatef() + "\n");
        buffer.append(Lang.getInstance().getProperty("Number_of_decimals") + ": " + this.getnum_dec() + "\n");
        buffer.append(Lang.getInstance().getProperty("Currency") + ": " + this.getCurrency() + "\n");
        buffer.append(Lang.getInstance().getProperty("Language") + ": " + this.getLanguage() + "\n");
        buffer.append(Lang.getInstance().getProperty("File_format") + ": " + this.getFile() + "\n");
        buffer.append(Lang.getInstance().getProperty("Theme") + ": " + this.getTheme() + "\n");

        return buffer.toString();
    }

    /**
     * Imprime el atributo que selecionemos.
     *
     * @param i
     *          (0 is format_date,1 is decimal,2 is currency and 3 is
     *          language,4 is file format,5 is Language)
     *
     * @return String
     */
    public String tostring(int i) {

        String cad = "";

        switch (i) {

            case 0:
                cad = cad + Lang.getInstance().getProperty("Date_format") + ": " + this.getdatef() + "\n";
                break;
            case 1:
                cad = cad + Lang.getInstance().getProperty("Number_of_decimals") + ": " + this.getnum_dec() + "\n";
                break;
            case 2:
                cad = cad + Lang.getInstance().getProperty("Currency") + ": " + this.getCurrency() + "\n";
                break;
            case 3:
                cad = cad + Lang.getInstance().getProperty("Language") + ": " + this.getLanguage() + "\n";
                break;
            case 4:
                cad = cad + Lang.getInstance().getProperty("File_format") + ": " + this.getFile() + "\n";
                break;
            case 5:
                cad = cad + Lang.getInstance().getProperty("Theme") + ": " + this.getTheme() + "\n";
                break;

        }
        return cad;

    }

}
