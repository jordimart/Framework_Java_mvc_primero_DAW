/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.General_tools;

import javax.swing.ImageIcon;

/**
 *
 * @author ASUSG50V
 */
public class singletonapp {
    
    public static int pos=0;//Singleton para posicion de de elementos en array
    public static int num=0;//Se utiliza para pasar el numero de dummies.
    public static int passdate=0;//singleton que pasa los errores de los date tools genericos a las especificas de users,products
    public static int passdate2=0;//Se utilizan dos porque coinciden en la misma pantalla dos fechas
    public static ImageIcon wrong_data = new ImageIcon("src/Appweb/General_tools/Img/Imagen_no_ok_Delete_16x16.png");
    public static ImageIcon good_data = new ImageIcon("src/Appweb/General_tools/Img/Imagen_ok_16x16.png");
    //objeto singleton que contendrá la ventana activa
    public static String singleton_vtna="";
    public static boolean singlecargar=false;//se utiliza para que solo se cargue la configuracion al inicializar la aplicacion
    public static String singleactiondate="";//se utiliza para que el propertychange de fecha solo actue en la pantalla que este.
    public static int singleactionBD=0;
    
}
