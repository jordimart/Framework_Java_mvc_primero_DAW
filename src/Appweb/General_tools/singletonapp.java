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
    public static ImageIcon wrong_data = new ImageIcon("src/Appweb/General_tools/Img/Imagen_no_ok_Delete_16x16.png");
    public static ImageIcon good_data = new ImageIcon("src/Appweb/General_tools/Img/Imagen_ok_16x16.png");
    
}
