package Appweb.Modules.Main.Model.Login.model.DAO_Login;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Main.View.menu_Input;
import Appweb.Modules.Users.Client.Model.Classes.singleclient;
import Appweb.Modules.Users.Client.Model.DAO_Client.DAO_Client_mongo;

/**
 *
 * @author jorge
 */
public class DAO_Login {

    /**
     * Funcion que recoge los datos de los txtfield del login y los guarda en 
     * variables singleton user y password para utilizarlas despues.
     */
    
    
    public static void collectdata() {

        char[] password = menu_Input.txt_password.getPassword();

        singletonapp.user = menu_Input.txt_user.getText();
        singletonapp.password = new String(password);

    }

    /**
     * Funcion de entrada standard para entrar en cada tipo de usuario con una entrada
     * sin usuario.
     */
    public static void standard_login() {

        if (singletonapp.user.equals("Admin") && singletonapp.password.equals("Admin")) {

            singletonapp.type = 0;
        } else if (singletonapp.user.equals("Client") && singletonapp.password.equals("Client")) {

            singletonapp.type = 1;
        } else if (singletonapp.user.equals("User") && singletonapp.password.equals("User")) {

            singletonapp.type = 2;
        } else if (singletonapp.user.equals("Test") && singletonapp.password.equals("Test")) {

            singletonapp.type = 3;
        } else {

            singletonapp.type = -1;
        }

    }

    /**
     * Funcion que utilizaremos para comprar las entradas del login con la base de
     * datos mongo y con ello saber si existe el usuario y es correcta la contraseña.
     * @return 
     */
    public static boolean find_and_compare_mongo() {

        boolean ok = false;

        ok = DAO_Client_mongo.find_in_mongo();

        if (ok == true && (singleclient.c.getUser().equals(singletonapp.user)) && (singleclient.c.getPassword().equals(singletonapp.password))) {

            ok = true;

        }else{
            
            ok=false;
        }

        return ok;
    }

}
