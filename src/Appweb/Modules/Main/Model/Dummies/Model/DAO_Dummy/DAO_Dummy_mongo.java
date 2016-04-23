
package Appweb.Modules.Main.Model.Dummies.Model.DAO_Dummy;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Client.Model.Classes.Client;

/**
 *
 * @author jorge
 */
public class DAO_Dummy_mongo {
    
    
    /**
     * DAO que inserta un usuario en la  base de datos mongo.
     * @param c le pasamos un cliente creado.
     * 
     */
    public static void insert_Client(Client c) {
        singletonapp.collection.insert(c.to_DB_Client());
        
    }
    
}
