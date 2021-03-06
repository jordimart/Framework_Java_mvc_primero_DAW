package Appweb.Modules.Users.Client.Model.Classes;

import java.io.Serializable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import Appweb.Modules.Main.Model.Config.Classes.Classconfig;
import Appweb.Classes.Date.ClassDate;
import Appweb.General_tools.Format_tools;
import Appweb.Modules.Users.Classes.User;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

/**
 *
 * @author Jorge Martinez Frias
 * @version 1.0 start 19_11_2015
 *
 */
// create a class Admin(its son of User) and writte extends User
@XStreamAlias("Client")
public class Client extends User implements Serializable {

    @XStreamAlias("entry_date")
    private ClassDate entry_date;
    @XStreamAlias("antique_c")
    private int antique_c;
    @XStreamAlias("purchase")
    private float purchase;
    @XStreamAlias("premium")
    private String premium;
    @XStreamAlias("client_type")
    private String client_type;

    // Constructor type one all Attributes
    public Client(String Dni, String Name, String Last_name, String Mobile, ClassDate Date_birth, String Email, String User, String Password,
            String Avatar, String Status, ClassDate entry_date, float purchase, String premium, String client_type) {
        super(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status);

        this.entry_date = entry_date;
        this.setAntique_c(entry_date.Diference_system_date());
        this.purchase = purchase;
        this.premium = premium;
        this.client_type = client_type;
        super.setBenefits(Cal_benefits());
    }

    /**
     * Constructor basado en los datos extraidos de una BD mongo.
     *
     * @param dBObjectClient dbobject
     *
     * @return Objeto Client
     */
    public Client Client_to_DB(DBObject dBObjectClient) {

        this.setDni((String) dBObjectClient.get("dni"));
        this.setName((String) dBObjectClient.get("name"));
        this.setLast_name((String) dBObjectClient.get("last_name"));
        this.setMobile((String) dBObjectClient.get("mobile"));
        this.setDate_birth(new ClassDate((String) dBObjectClient.get("date_birth").toString()));
        this.setEmail((String) dBObjectClient.get("email"));
        this.setUser((String) dBObjectClient.get("user"));
        this.setPassword((String) dBObjectClient.get("password"));
        this.setAvatar((String) dBObjectClient.get("avatar"));
        this.setStatus((String) dBObjectClient.get("status"));
        this.setBenefits(Float.parseFloat(dBObjectClient.get("benefits").toString()));
        this.entry_date = new ClassDate((String) dBObjectClient.get("entry_date"));
        this.antique_c = (int) (dBObjectClient.get("antique_c"));
        this.purchase = Float.parseFloat(dBObjectClient.get("purchase").toString());
        this.premium = (String) dBObjectClient.get("premium");
        this.client_type = (String) dBObjectClient.get("client_type");

        return new Client(this.getDni(), this.getName(), this.getLast_name(), this.getMobile(), this.getDate_birth(),
                this.getEmail(), this.getUser(), this.getPassword(), this.getAvatar(), this.getStatus(),
                this.entry_date, this.purchase, this.premium, this.client_type);
    }

    /**
     * Introduce los datos de un cliente en un objeto BasicDBObject.
     *
     * @return dbobject
     */
    public BasicDBObject to_DB_Client() {

        BasicDBObject dBObjectClient = new BasicDBObject();

        dBObjectClient.append("dni", super.getDni());
        dBObjectClient.append("name", super.getName());
        dBObjectClient.append("last_name", super.getLast_name());
        dBObjectClient.append("mobile", super.getMobile());
        dBObjectClient.append("date_birth", super.getDate_birth().toString());
        dBObjectClient.append("email", super.getEmail());
        dBObjectClient.append("user", super.getUser());
        dBObjectClient.append("password", super.getPassword());
        dBObjectClient.append("avatar", super.getAvatar());
        dBObjectClient.append("status", super.getStatus());
        dBObjectClient.append("benefits", super.getBenefits());
        dBObjectClient.append("entry_date", this.getEntry_date().toString());
        dBObjectClient.append("antique_c", this.getAntique_c());
        dBObjectClient.append("purchase", this.getPurchase());
        dBObjectClient.append("premium", this.getPremium());
        dBObjectClient.append("client_type", this.getClient_type());

        return dBObjectClient;
    }

    // Constructor type two nothing
    public Client() {
        super();
    }

    // constructor trhee
    // constructor get primary key
    public Client(String Dni) {

        super(Dni);

    }

    // constructor four // constructor users request
    public Client(int i, String s, int n, float f, ClassDate c) {

        switch (i) {

            case 0:

                super.setDni(s);

                break;
            case 1:

                super.setName(s);

                break;
            case 2:

                super.setLast_name(s);

                break;
            case 3:

                super.setMobile(s);

                break;
            case 4:

                super.setDate_birth(c);

                break;
            case 5:

                super.setAge(n);

                break;
            case 6:

                super.setEmail(s);

                break;
            case 7:

                super.setUser(s);

                break;
            case 8:

                super.setPassword(s);

                break;
            case 9:

                super.setAvatar(s);

                break;
            case 10:

                super.setStatus(s);

                break;
            case 11:

                super.setBenefits(f);

                break;

            case 12:

                this.entry_date = c;

                break;

            case 13:

                this.antique_c = n;

                break;

            case 14:

                this.purchase = f;

                break;

            case 15:

                this.premium = s;

                break;

            case 16:

                this.client_type = s;

                break;

        }

    }

    // Getters and setters
    public ClassDate getEntry_date() {
        return entry_date;
    }

    public void setEntry_date(ClassDate entry_date) {
        this.entry_date = entry_date;
        this.setAntique_c(entry_date.Diference_system_date());
    }

    public int getAntique_c() {
        return antique_c;
    }

    public void setAntique_c(int antique_c) {
        this.antique_c = antique_c;
        super.setBenefits(Cal_benefits());
    }

    public float getPurchase() {
        return purchase;
    }

    public void setPurchase(float purchase) {
        this.purchase = purchase;

    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
        super.setBenefits(Cal_benefits());
    }

    public String getClient_type() {
        return client_type;
    }

    public void setClient_type(String client_type) {
        this.client_type = client_type;
    }

    public float Cal_benefits() {

        float ben = 0.0000f;

        if ((getPremium() == "Yes") && ((getAntique_c() >= 5) && (getAntique_c() <= 10))) {
            ben = (float) 100.123;
        }

        if ((getPremium() == "Yes") && ((getAntique_c() > 10))) {
            ben = (float) 200.123;
        }

        if ((getPremium() == "No")) {
            ben = (float) 0;
        }

        return ben;
    }

    // String type one
    // to string all attributes mum and son
    /**
     * public String toString() {
     *
     * StringBuffer buffer = new StringBuffer();
     *
     * buffer.append("Datos User \n" + super.toString() + "\n");
     * buffer.append("Datos de Client \n" + "Registered date" +
     * this.getEntry_date().todate() + "\n"); buffer.append("Antique: " +
     * this.getAntique_c() + " years \n"); buffer.append(this.toPurchase());
     * buffer.append("Premium: " + this.getPremium() + "\n");
     * buffer.append("Client type: " + this.getClient_type() + "\n");
     *
     * return buffer.toString();
     *
     * }
     *
     */
    public String toString() {
        return "client{" + "Dni=" + super.getDni() + "Last_name=" + super.getLast_name() + "Date_birth=" + super.getDate_birth() + "Antique=" + antique_c + "Purchase=" + purchase + '}';
    }

    public String toPurchase() {

        String money = "";

        switch (Classconfig.getInstance().getCurrency()) {

            case "euro":

                if (Classconfig.getInstance().getnum_dec() == "0.0") {

                    money = money + Format_tools.F_1dec(getPurchase()) + " € \n";

                }

                if (Classconfig.getInstance().getnum_dec() == "0.00") {

                    money = money + Format_tools.F_Euro(getPurchase()) + " \n";

                }

                if (Classconfig.getInstance().getnum_dec() == "0.000") {

                    money = money + Format_tools.F_3dec(getPurchase()) + " € \n";

                }

                break;

            case "dolar":

                float cald = 0.000f;

                cald = (float) (1.09922 * (getPurchase()));

                if (Classconfig.getInstance().getnum_dec() == "0.0") {

                    money = money + "$" + Format_tools.F_1dec(cald) + "\n";
                }

                if (Classconfig.getInstance().getnum_dec() == "0.00") {

                    money = money + Format_tools.F_Dollar(cald) + "\n";

                }

                if (Classconfig.getInstance().getnum_dec() == "0.000") {

                    money = money + "$" + Format_tools.F_3dec(cald) + "\n";

                }

                break;

            case "pound":

                float calp = 0.000f;

                calp = (float) (0.728500 * (getPurchase()));

                if (Classconfig.getInstance().getnum_dec() == "0.0") {

                    money = money + "£" + Format_tools.F_1dec(calp) + "\n";
                }

                if (Classconfig.getInstance().getnum_dec() == "0.00") {

                    money = money + Format_tools.F_Libra(calp) + "\n";

                }

                if (Classconfig.getInstance().getnum_dec() == "0.000") {

                    money = money + "£" + Format_tools.F_3dec(calp) + "\n";
                }

                break;

        }

        return money;
    }

    // String type two
    // only show key attribute
    public String toString(String Dni) {

        return super.toString(Dni);
    }

    // String type three
    // Only show users request
    public String toString(int i) {

        String cad = "";

        switch (i) {

            case 0:
                cad = cad + "Dni: " + super.getDni() + "\n";
                break;
            case 1:
                cad = cad + "Name: " + super.getName() + "\n";
                break;
            case 2:
                cad = cad + "Last name: " + super.getLast_name() + "\n";
                break;
            case 3:
                cad = cad + "Mobile: " + super.getMobile() + "\n";
                break;
            case 4:
                cad = cad + "Date birth: " + super.getDate_birth() + "\n";
                break;
            case 5:
                cad = cad + "Age: " + super.getAge() + "\n";
                break;
            case 6:
                cad = cad + "Email: " + super.getEmail() + "\n";
                break;
            case 7:
                cad = cad + "User: " + super.getUser() + "\n";
                break;
            case 8:
                cad = cad + "Password: " + super.getPassword() + "\n";
                break;
            case 9:
                cad = cad + "Avatar: " + super.getAvatar() + "\n";
                break;
            case 10:
                cad = cad + "Status: " + super.getStatus() + "\n";
                break;
            case 11:
                cad = cad + "Benefits: " + super.getBenefits() + "\n";
                break;

            case 12:
                cad = cad + "Entry date: " + this.getEntry_date().getDate() + "\n";
                break;
            case 13:
                cad = cad + "Antique: " + this.getAntique_c() + "\n";
                break;
            case 14:
                cad = cad + "Purchase: " + Format_tools.F_Euro(getPurchase()) + "\n";
                break;

            case 15:
                cad = cad + "Premium: " + this.getPremium() + "\n";
                break;
            case 16:
                cad = cad + "Client type: " + this.getClient_type() + "\n";
                break;

        }
        return cad;

    }

}
