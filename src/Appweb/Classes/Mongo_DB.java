package Appweb.Classes;

import Appweb.General_tools.singletonapp;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class Mongo_DB {

    private static Properties prop = new Properties();
    private static InputStream input = null;
    private static String machine = null;
    private static String port = null;

    /**
     * Funcion mongo que que recoge las propiedades de la conexion para
     * trabajar en la base de datos.
     */
    public Mongo_DB() {
        try {
            input = new FileInputStream("src/Appweb/Classes/mongo.properties");
            try {
                prop.load(input);
            } catch (Exception e) {
                System.out.println("Unable to open mongo.properties");
                e.printStackTrace();
            }
            machine = prop.getProperty("machine");
            port = prop.getProperty("port");
            singletonapp.nom_bd = prop.getProperty("db");
            singletonapp.nom_table = prop.getProperty("collection");
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open mongo.properties");
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Unable to close mongo.properties");
                }
            }
        }
    }

    /**
     * Funcion que abre una conexion en mongo client.
     */
    public static void connect() {
        try {
            singletonapp.client = new Mongo(getMachine(), Integer.parseInt(getPort()));
            singletonapp.db = singletonapp.client.getDB(getNom_bd());
            singletonapp.collection = singletonapp.db.getCollection(getNom_table());
        } catch (Exception e) {
            System.out.println("Unable to open client");
            e.printStackTrace();
            if (singletonapp.client != null) {
                try {
                    singletonapp.client.close();
                } catch (Exception ex) {
                    System.out.println("Unable to close client");
                    ex.printStackTrace();
                }
            }
        }

    }

    /**
     * Funcion que desconecta de la base de datos mongo.
     */
    public static void disconnect() {
        singletonapp.client.close();
    }

    /**
     * Coge las propiedades de la conexion.
     *
     * @return prop
     */
    public static Properties getProp() {
        return prop;
    }

    /**
     * Coge el valor de Input Stream.
     *
     * @return input
     */
    public static InputStream getInput() {
        return input;
    }

    /**
     * Coge el valor del objeto Mongo.
     *
     * @return client
     */
    public static Mongo getClient() {
        return singletonapp.client;
    }

    /**
     * Coge el valor de la base de datos.
     *
     * @return db
     */
    public static DB getDb() {
        return singletonapp.db;
    }

    /**
     * Coge el valor de la coleccion
     *
     * @return coleccion
     */
    public static DBCollection getCollection() {
        return singletonapp.collection;
    }

    /**
     * Modifica el properties
     *
     * @param prop
     */
    public static void setProp(Properties prop) {
        Mongo_DB.prop = prop;
    }

    /**
     * Modifica el InputStream
     *
     * @param input
     */
    public static void setInput(InputStream input) {
        Mongo_DB.input = input;
    }

    /**
     * Modifica el objeto Mongo.
     *
     * @param client
     */
    public static void setClient(Mongo client) {
        singletonapp.client = client;
    }

    /**
     * Modifica el valor de la base de datos.
     *
     * @param db
     */
    public static void setDb(DB db) {
        singletonapp.db = db;
    }

    /**
     * Modifica el valor de la coleccion.
     *
     * @param collection
     */
    public static void setCollection(DBCollection collection) {
        singletonapp.collection = collection;
    }

    /**
     * Coge el valor del nombre de la base de datos.
     *
     * @return
     */
    public static String getNom_bd() {
        return singletonapp.nom_bd;
    }

    /**
     * Modifica el valor del nombre de la base de datos.
     *
     * @param nom_bd
     */
    public static void setNom_bd(String nom_bd) {
        singletonapp.nom_bd = nom_bd;
    }

    /**
     * Coge el valor del nombre de la base de datos.
     *
     * @return
     */
    public static String getNom_table() {
        return singletonapp.nom_table;
    }

    /**
     * Modifica el valor del nombre de la base de datos.
     *
     * @param nom_table
     */
    public static void setNom_table(String nom_table) {
        singletonapp.nom_table = nom_table;
    }

    /**
     * Coge el valor de machine.
     *
     * @return
     */
    public static String getMachine() {
        return machine;
    }

    /**
     * Coge el valor del puerto.
     *
     * @return
     */
    public static String getPort() {
        return port;
    }

    /**
     * Modifica el valor de machine
     *
     * @param machine
     */
    public static void setMachine(String machine) {
        Mongo_DB.machine = machine;
    }

    /**
     * Modifica el valor del puerto.
     *
     * @param port
     */
    public static void setPort(String port) {
        Mongo_DB.port = port;
    }
}
