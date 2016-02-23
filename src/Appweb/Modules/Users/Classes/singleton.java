package Appweb.Modules.Users.Classes;

import java.util.ArrayList;
import javax.swing.ImageIcon;

public class singleton {

    public static ArrayList<Admin> Admin_array;
    public static ArrayList<Client> Client_array;
    public static ArrayList<User_reg> User_reg_array;
    public static ArrayList<Object> Object_array;
    public static int pos=0;
    public static int num=0;
    public static ImageIcon wrong_data = new ImageIcon("src/Appweb/General_tools/Img/Imagen_no_ok_Delete_16x16.png");
    public static ImageIcon good_data = new ImageIcon("src/Appweb/General_tools/Img/Imagen_ok_16x16.png");
    

}
