package Appweb.Modules.Users.Client.Model.DAO_Client;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Client.Model.Classes.Client;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/**
 *
 * @author jorge
 */
public class DAO_Client_mongo {

    /**
     * Carga los clientes de la base de datos mongo a la Array de la aplicacion
     *
     * @param db
     */
    public static void load() {
        DBCursor cursor = null;
        Client c = new Client();

        try {

            cursor = singletonapp.collection.find();
            if (cursor.count() != 0) {
                while (cursor.hasNext()) {
                    BasicDBObject document = (BasicDBObject) cursor.next();

                    //c = c.Client_to_DB(document);//este metodo tal cual nofunciona de momento
                    singleclient.Client_array.add(c.Client_to_DB(document));

                }
            }

        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

    }

    /**
     * Inserta un cliente nuevo en mongo.
     *
     * @return
     */
    public static int save() {

        singletonapp.collection.insert(singleclient.c.to_DB_Client());

        return 0;
    }

    /**
     * Modifica los datos de un usuario en mongo seleccionado por dni.
     * @return 
     */
    public static int save_modified() {

        BasicDBObject updateclient = new BasicDBObject();
        BasicDBObject document = new BasicDBObject();
        
        updateclient.append("$set", singleclient.c.to_DB_Client());

        BasicDBObject searchById = new BasicDBObject();
        searchById.append("dni", singleclient.c.getDni());

        singletonapp.collection.updateMulti(searchById, updateclient);

        return 0;
    }

    /**
     * Borra un usuario de la base de datos mongo buscando por dni.
     *
     * @param dni
     *
     * @return
     */
    public static int delete(String dni) {

        singletonapp.collection.remove(new BasicDBObject().append("dni", dni));

        return 0;
    }

    public static int delete_all() {

        return 0;
    }

}
