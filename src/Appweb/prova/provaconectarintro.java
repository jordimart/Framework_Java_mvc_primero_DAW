/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.prova;

import Appweb.Classes.ConectionBD;
import java.sql.PreparedStatement;



/**
 *
 * @author jorge
 */
public class provaconectarintro {
    
    public static void admin(){

    //Connection _con = null;
        ConectionBD conect = new ConectionBD();
        PreparedStatement stmt = null;
        int resultado = 0;
        
        conect.AbrirConexion();
    }
        

    }
