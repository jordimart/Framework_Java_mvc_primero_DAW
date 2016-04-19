
package Appweb.Modules.Main.Model.Dummies.Model.DAO_Dummy;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;

/**
 *
 * @author jorge
 */
public class DAO_Dummy_mongo {
    
    public static void create_Dummy_client_mongo(){
        
        for (Client c : singleclient.Client_array){
            
            DAO_Dummy_mongo.insert_Client( c);
            
        }
    }
    
    public static void insert_Client(Client c) {
        singletonapp.collection.insert(c.to_DB_Client());
        
    }
    
}
