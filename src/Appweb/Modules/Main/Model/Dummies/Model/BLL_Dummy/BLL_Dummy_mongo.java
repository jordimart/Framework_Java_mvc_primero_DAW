package Appweb.Modules.Main.Model.Dummies.Model.BLL_Dummy;

import Appweb.Modules.Main.Model.Dummies.Model.DAO_Dummy.DAO_Dummy_mongo;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;

/**
 *
 * @author jorge
 */
public class BLL_Dummy_mongo {

    /**
     * BLL que introduce todos los clientes del array list mediante un for
     * a la base de datos mongo utilizando un DAO_client_mongo.
     */
    public static void create_Dummy_client_mongo() {

        for (Client c : singleclient.Client_array) {

            DAO_Dummy_mongo.insert_Client(c);

        }
    }

}
