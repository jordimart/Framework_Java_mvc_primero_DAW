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
            //propiedades.load(new FileInputStream("src/config/datasource_config.properties"));
            singletonapp.singlepool = (BasicDataSource) BasicDataSourceFactory.createDataSource(propiedades);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public static Connection getConexion() {
        Connection conexion = null;
        try {
            conexion = singletonapp.singlepool.getConnection();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return conexion;
    }

    public static void liberaConexion(Connection conexion) {
        try {
            if (null != conexion) // En realidad no cierra, solo libera la conexion.
            {
                conexion.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

//    /**
//     * abrimos conexion en la base de datos
//     *
//     * @return
//     */
//    public Connection AbrirConexion() {
//
//        Connection con = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            String urlOdbc = "jdbc:mysql://127.0.0.1:3306/db_admin";
//            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", ""));
//
//        } catch (Exception e) {
//
//            JOptionPane.showMessageDialog(null, "Ha sido imposible establecer la conexion!");
//        }
//        return con;
//    }
//
//    /**
//     * cerramos la conexion en la bd
//     *
//     * @param con
//     */
//    public void CerrarConexion(Connection con) {
//        try {
//            if (con != null) {
//                con.close();
//
//            }
//        } catch (SQLException e) {
//
//            JOptionPane.showMessageDialog(null, "Ha sido imposible cerrar la conexion!");
//        }
//    }
}
