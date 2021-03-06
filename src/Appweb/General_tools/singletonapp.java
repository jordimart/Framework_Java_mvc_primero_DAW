package Appweb.General_tools;

import Appweb.Classes.Mongo_DB;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import javax.swing.ImageIcon;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author ASUSG50V
 */
public class singletonapp {

    public static int pos = 0;//Singleton para posicion de de elementos en array
    public static int num = 0;//Se utiliza para pasar el numero de dummies.
    public static int passdate = 0;//singleton que pasa los errores de los date tools genericos a las especificas de users,products
    public static int passdate2 = 0;//Se utilizan dos porque coinciden en la misma pantalla dos fechas
    public static ImageIcon wrong_data = new ImageIcon("src/Appweb/General_tools/Img/Imagen_no_ok_Delete_16x16.png");
    public static ImageIcon good_data = new ImageIcon("src/Appweb/General_tools/Img/Imagen_ok_16x16.png");

    public static String window = "";//objeto singleton que contendrá la table activa
    public static boolean singlecargar = false;//se utiliza para que solo se cargue la configuracion al inicializar la aplicacion
    public static String singleactiondate = "";//se utiliza para que el propertychange de fecha solo actue en la pantalla que este.
    public static BasicDataSource singlepool = null;

    //Singletons Mongo///Se utilizan en las conexiones mongo//
    public static Mongo_DB mongo = null;
    public static Mongo client = null;
    public static DB db = null;
    public static String nom_bd = null;
    public static DBCollection collection = null;
    public static String nom_table = "";

    //Singletons Login
    public static String user;//usuario que recoge del login
    public static String password;//usuario que recoge del password
    public static int type = -1;//Tipo de usuario que entra Admin,Client,User reg o Test

}
