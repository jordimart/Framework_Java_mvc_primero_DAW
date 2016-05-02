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
     *
     */
    public static void load() {
        DBCursor cursor = null;
        Client c = new Client();

        try {

            cursor = singletonapp.collection.find();
            if (cursor.count() != 0) {
                while (cursor.hasNext()) {

                    BasicDBObject document = (BasicDBObject) cursor.next();
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
     *
     */
    public static void save() {

        singletonapp.collection.insert(singleclient.c.to_DB_Client());

    }

    /**
     * Modifica los datos de un usuario en mongo seleccionado por dni.
     *
     *
     */
    public static void save_modified() {

        BasicDBObject updateclient = new BasicDBObject();

        updateclient.append("$set", singleclient.c.to_DB_Client());//modificara todos los valores

        BasicDBObject searchById = new BasicDBObject();
        searchById.append("dni", singleclient.c.getDni());//modificara en el dni seleccionado

        singletonapp.collection.updateMulti(searchById, updateclient);
        //sentencia completa
        //que utiliza los dos tipos de objetos busqueda y actualizacion

    }

    /**
     * DAO que busca a un cliente en la base de datos mongo por el nombre de
     * usuario recogido previamente.
     * Si existe crea un objeto client singleton y si este no es null
     * devolvemos un boolean true.
     *
     * @return boolean true/false.
     */
    public static boolean find_in_mongo() {

        DBCursor cursor = null;
        boolean ok = false;

        try {
            BasicDBObject query = new BasicDBObject();
            query.put("user", singletonapp.user);
            query.put("password", singletonapp.password);
            cursor = singletonapp.collection.find(query);
            if (cursor.count() != 0) {

                while (cursor.hasNext()) {
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    singleclient.c.Client_to_DB(document);
                }

                if (singleclient.c != null) {

                    ok = true;
                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return ok;

    }

    /**
     * Borra un usuario de la base de datos mongo buscando por dni.
     *
     * @param dni
     *
     *
     */
    public static void delete(String dni) {

        singletonapp.collection.remove(new BasicDBObject().append("dni", dni));

    }

    /**
     * Boirra todos los elementos de la coleccion.
     * @return 
     */
    public static int delete_all() {
        
         singletonapp.collection.remove(new BasicDBObject());

        return 0;
    }

}
