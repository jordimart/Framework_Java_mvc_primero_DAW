package Appweb.Modules.Users.Client.Model.BLL_Client;

import Appweb.Modules.Users.Client.Model.DAO_Client.DAO_Client_mongo;

/**
 *
 * @author jorge
 */
public class BLL_Client_mongo {

    /**
     * Bll que utiliza un DAO mongo para cargar los datos de la base de datos
     * a la aplicacion.
     */
    public static void load() {

        DAO_Client_mongo.load();

    }

    /**
     * BLL que utiliza un DAO mongo para insertar un cliente en la base de datos
     * mongo
     *
     *
     */
    public static void save() {

        DAO_Client_mongo.save();

    }

    /**
     * BLL que modifica un cliente de mongo seleccionado previamente.
     */
    public static void save_modified() {

        DAO_Client_mongo.save_modified();

    }

    /**
     * BLL que utiliza un Dao mongo para borrar un cliente de la base de datos
     * mongo
     *
     * @param dni string
     */
    public static void delete(String dni) {

        DAO_Client_mongo.delete(dni);

    }

    /**
     * BLL que utiliza un DAO para borrar todos los elementos d ela coleccion.
     */
    public static void delete_all() {
        
        DAO_Client_mongo.delete_all();

    }

    /**
     * BLL que utiliza un DAO para buscar un cliente en la base de datos mongo.
     *
     * @return boolean true/false
     */
    public static boolean find_mongo() {

        boolean ok = DAO_Client_mongo.find_in_mongo();

        return ok;
    }

}
