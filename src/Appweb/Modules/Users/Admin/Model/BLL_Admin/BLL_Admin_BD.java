/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Users.Admin.Model.BLL_Admin;

import Appweb.Classes.ConectionBD;
import Appweb.Modules.Users.Admin.Model.DAO_Admin.DAO_Admin_BD;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class BLL_Admin_BD {

    /**
     * BLL que abre la conexion a base de datos y utiliza el DAO
     * load para cargar los administradores de la base de datos a la aplicacion
     */
    public static void load_BD() {

        Connection con = null;

        con=ConectionBD.getConexion();

        try {

            DAO_Admin_BD.load(con);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger2!");
            ex.printStackTrace();

        }

       ConectionBD.liberaConexion(con);
    }

    /**
     * BLL que abre la conexion a base de datos y mediante un DAO inserta un
     * Administrador en la base de datos.
     * Si se ha insertado correctamente nos devuelve un integer 1.
     *
     * @return int
     */
    public static int save_Admin() {

        int ok = 0;
        Connection con = null;
       con = ConectionBD.getConexion();

        ok = DAO_Admin_BD.save_Admin(con);

        ConectionBD.liberaConexion(con);

        return ok;
    }

    /**
     * BLL que abre la conexion a base de datos y mediante un DAO modifica un
     * Administrador de la base de datos.
     * Si se ha modificado correctamente devuleve un integer 1.
     *
     * @return int
     */
    public static int save_modified_Admin() {

        int ok = 0;
        Connection con = null;
        

        con = ConectionBD.getConexion();

        ok = DAO_Admin_BD.save_modified_Admin(con);

        ConectionBD.liberaConexion(con);

        return ok;
    }

    /**
     * BLL que abre la conexion a base dedatos y mediante un DAO elimina un
     * Administrador de la base de datos.
     * Si se ha eliminado correctamente devuelve un integer 1.
     *
     * @return
     */
    public static int delete_Admin() {

        int ok = 0;
        Connection con = null;
       

        con = ConectionBD.getConexion();

        ok = DAO_Admin_BD.delete_Admin(con);

       ConectionBD.liberaConexion(con);

        return ok;
    }
    
     public static int delete_all_Admin() {

        int ok = 0;
        Connection con = null;
        ConectionBD conBD = new ConectionBD();

        con = ConectionBD.getConexion();

        ok = DAO_Admin_BD.delete_all_Admin(con);

       ConectionBD.liberaConexion(con);

        return ok;
    }
}
