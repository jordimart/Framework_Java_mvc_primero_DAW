/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Users.Admin.Model.BLL_Admin;

import Appweb.Classes.ConectionBD;
import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Admin.Model.DAO_Admin.DAO_Admin_BD;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class BLL_Admin_BD {

    public static void cargarBD() {

        Connection con = null;

        ConectionBD conBD = new ConectionBD();

        con = conBD.AbrirConexion();

        try {

            DAO_Admin_BD.cargar(con);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger2!");

        }

        conBD.CerrarConexion(con);
    }

    public static int save_Admin() {

        int ok = 0;
        Connection con = null;
        ConectionBD conBD = new ConectionBD();

        con = conBD.AbrirConexion();

        singletonapp.singleactionBD = DAO_Admin_BD.save_Admin(con);

        conBD.CerrarConexion(con);

        return ok;
    }

    public static int save_modified_Admin() {

        int ok = 0;
        Connection con = null;
        ConectionBD conBD = new ConectionBD();

        con = conBD.AbrirConexion();

        ok = DAO_Admin_BD.save_modified_Admin(con);

        conBD.CerrarConexion(con);

        return ok;
    }

    public static int delete_Admin() {

        int ok = 0;
        Connection con = null;
        ConectionBD conBD = new ConectionBD();

        con = conBD.AbrirConexion();

        DAO_Admin_BD.delete_Admin(con);

        conBD.CerrarConexion(con);

        return ok;
    }
}
