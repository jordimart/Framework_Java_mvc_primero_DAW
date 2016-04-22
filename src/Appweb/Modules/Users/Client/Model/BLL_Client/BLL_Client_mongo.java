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
     * @param dni
     *
     * @return
     */
    public static int delete(String dni) {

        DAO_Client_mongo.delete(dni);

        return 0;
    }

    public static int delete_all() {

        return 0;
    }

}
