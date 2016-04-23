package Appweb.Modules.Main.Model.Dummies.Model.DAO_Dummy;

import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 */
public class DAO_Dummy_BD {

    public static int create_Dummy_adminBD(Connection con) {

        int resultado = 0;

        PreparedStatement stmt = null;

        try {

            singleadmin.a = DAO_Dummies.Dummyadmin();

            stmt = con.prepareStatement("INSERT INTO db_admin.admin"
                    + "(dni,name,last_name,mobile,date_birth,age"
                    + ",email,user,password,avatar,benefits,status,date_cont,antique,salary,activity) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            stmt.setString(1, singleadmin.a.getDni());
            stmt.setString(2, singleadmin.a.getName());
            stmt.setString(3, singleadmin.a.getLast_name());
            stmt.setString(4, singleadmin.a.getMobile());
            stmt.setString(5, singleadmin.a.getDate_birth().toString());
            stmt.setInt(6, singleadmin.a.getAge());
            stmt.setString(7, singleadmin.a.getEmail());
            stmt.setString(8, singleadmin.a.getUser());
            stmt.setString(9, singleadmin.a.getPassword());
            stmt.setString(10, singleadmin.a.getAvatar());
            stmt.setFloat(11, singleadmin.a.getBenefits());
            stmt.setString(12, singleadmin.a.getStatus());
            stmt.setString(13, singleadmin.a.getDate_cont().toString());
            stmt.setInt(14, singleadmin.a.getAntique());
            stmt.setFloat(15, singleadmin.a.getSalary());
            stmt.setInt(16, singleadmin.a.getActivity());

            resultado = stmt.executeUpdate();

            System.out.print("El usuario ha sido dado de alta correctamente!\n");

        } catch (SQLException ex) {
            System.out.print("Ha habido un error al insertarel nuevo usuario!\n");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                    ex.printStackTrace();
                }
            }
        }

        return resultado;

    }

}
