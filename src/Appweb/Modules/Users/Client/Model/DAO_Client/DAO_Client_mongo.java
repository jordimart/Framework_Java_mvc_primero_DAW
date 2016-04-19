package Appweb.Modules.Users.Client.Model.DAO_Client;

import Appweb.Classes.Date.ClassDate;
import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCursor;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class DAO_Client_mongo {

    public static void load(DB db) {
        DBCursor cursor = null;

        String Dni = "", Name = "", Last_name = "", Mobile = "", Email = "", User = "", Password = "", Premium = "", client_type = "";
        ClassDate date_reg = null;
        String Status = "";
        

        float purchase = 0;
        ClassDate Date_birth = null;

        Client c = null;
        String Avatar = null;

        try {

            cursor = singletonapp.collection.find();
            if (cursor.count() != 0) {
                while (cursor.hasNext()) {
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    //c = c.Client_to_DB(document);
                    String P=  document.get("purchase").toString();

                    Dni = (String) document.get("dni");
                    Name = (String) document.get("name");
                    Last_name = (String) document.get("last_name");
                    Mobile = (String) document.get("mobile");
                    Date_birth = new ClassDate( document.get("date_birth").toString());
                    Email = (String) document.get("email");
                    User = (String) document.get("user");
                    Password = (String) document.get("password");
                    Avatar = (String) document.get("avatar");
                    Status = (String) document.get("status");
                    Premium = (String) document.get("premium");
                    client_type = (String) document.get("client_type");
                    date_reg = new ClassDate( document.get("entry_date").toString());
                    purchase = Float.parseFloat(P);

                    c = new Client(Dni, Name, Last_name, Mobile, Date_birth, Email, User, Password, Avatar, Status, date_reg, purchase, Premium, client_type);

                    JOptionPane.showMessageDialog(null, "Imprimimos dni del objeto" + c.toString(Dni));
                    singleclient.Client_array.add(c);

                }
            }

        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

    }

    public static int save() {

        return 0;
    }

    public static int save_modified() {

        return 0;
    }

    public static int delete() {

        return 0;
    }

    public static int delete_all() {

        return 0;
    }

}
