package Appweb.Classes;

import Appweb.General_tools.singletonapp;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 *
 * @author jorge
 */
public class ConectionBD {

    /**
     * Inicializa el pool de conexiones de sql.
     * Dentro estanlos parametros necesarios para que funcione la base de datos.
     */
    public static void start_pool_conection() {

        Properties propiedades = new Properties();

        propiedades.setProperty("driverClassName", "com.mysql.jdbc.Driver");
        propiedades.setProperty("url", "jdbc:mysql://localhost:3306/db_admin");
        propiedades.setProperty("maxActive", "10");
        propiedades.setProperty("maxIdle", "8");
        propiedades.setProperty("minIdle", "0");
        propiedades.setProperty("maxWait", "500");
        propiedades.setProperty("initialSize", "5");
        propiedades.setProperty("defaultAutoCommit", "true");
        propiedades.setProperty("username", "root");
        propiedades.setProperty("password", "");
        propiedades.setProperty("validationQuery", "select 1");
        propiedades.setProperty("validationQueryTimeout", "100");
        propiedades.setProperty("initConnectionSqls", "SELECT 1;SELECT 2");
        propiedades.setProperty("poolPreparedStatements", "true");
        propiedades.setProperty("maxOpenPreparedStatements", "10");

        try {

            singletonapp.singlepool = (BasicDataSource) BasicDataSourceFactory.createDataSource(propiedades);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    /**
     * Funcion que ocupa una conexion del pool.
     *
     * @return Connection
     */
    public static Connection getConexion() {
        Connection con = null;
        try {
            con = singletonapp.singlepool.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return con;
    }

    /**
     * Funcion que libera una conexion que estaba en uso del pool.
     *
     * @param conexion Connection
     */
    public static void liberaConexion(Connection conexion) {
        try {
            if (null != conexion) // En realidad no cierra, solo libera la conexion.
            {
                conexion.close();
            }
        } catch (SQLException e) {

        }
    }

}
