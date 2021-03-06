package Appweb.Modules.Users.Admin.Model.DAO_Admin;

import Appweb.Classes.Date.ClassDate;
import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import Appweb.Modules.Users.Admin.Model.Classes.singleadmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author jorge
 *
 * DAO de Base de datos.
 * Se realizan todas las operaciones una vez estamos conectados a la base de
 * datos.
 * load:Carga en la aplicacion los Administradores de la base de datos.
 * save_Admin: Inserta un Administrador en la base de datos creado enla
 * aplicacion.
 * save_modified_Admin:Actualiza los datos de un Administrador modificado en la
 * aplicacion.
 * delete_Admin:Elimina un Administrador de la base de datos eliminado en la
 * aplicacion.
 */
public class DAO_Admin_BD {

    /**
     * Carga los administradores de la base de datos en el arraylist de admin.
     * Pasamos el parametro conexion a base de datos.
     *
     * @param con connection
     */
    public static void load(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("SELECT * FROM db_admin.admin");
            rs = stmt.executeQuery();

            Admin a = null;

            while (rs.next()) {

                a = new Admin();
                a.setDni(rs.getString("dni"));
                a.setName(rs.getString("name"));
                a.setLast_name(rs.getString("last_name"));
                a.setMobile(rs.getString("mobile"));
                a.setDate_birth(new ClassDate(rs.getString("date_birth"), 1));
                a.setAge(rs.getInt("age"));
                a.setEmail(rs.getString("email"));
                a.setUser(rs.getString("user"));
                a.setPassword(rs.getString("password"));
                a.setAvatar(rs.getString("avatar"));
                a.setBenefits(rs.getFloat("benefits"));
                a.setStatus(rs.getString("status"));
                a.setDate_cont(new ClassDate(rs.getString("date_cont"), 1));
                a.setAntique(rs.getInt("antique"));
                a.setSalary(rs.getFloat("salary"));
                a.setActivity(rs.getInt("activity"));

                singleadmin.Admin_array.add(a);

            }
        } catch (SQLException ex) {
            System.out.print("Ha habido un problema al cargar losusuarios de BD!\n");
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

    }

    /**
     * Insertamos un solo administrador en la base de datos.
     * Pasamos el parametro conexion.
     * Retornamos un integer si ha insertado bien.
     *
     * @param con connection
     *
     * @return int
     */
    public static int save_Admin(Connection con) {

        int ok = 0;
        PreparedStatement stmt = null;

        try {

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

            ok = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Ha habido un problema al insertar al nuevo usuario!\n");
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

        return ok;
    }

    /**
     * Modificamos un administardor en la base de datos.
     * Pasamos el parametro conexion.
     * Retornamos un integer si ha insertado bien.
     *
     * @param con connection
     *
     * @return int
     */
    public static int save_modified_Admin(Connection con) {

        int ok = 0;
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE db_admin.admin SET "
                    + "dni=?,name=?,last_name=?,mobile=?,date_birth=?,age=?"
                    + ",email=?,user=?,password=?,avatar=?,benefits=?,status=?,date_cont=?,antique=?,salary=?,activity=? WHERE dni=?");

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

            stmt.setString(17, singleadmin.a.getDni());
            ok = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Ha habido un problema al modificar al nuevo usuario!\n");
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

        return ok;
    }

    /**
     * Eliminamos un administrador de la base de datos.
     * Pasamos el parametro conexion.
     * Retornamos un integer si se ha insertado correctamente.
     *
     * @param con connection
     *
     * @return int
     */
    public static int delete_Admin(Connection con) {

        PreparedStatement stmt = null;
        int ok = 0;

        try {

            stmt = con.prepareStatement("DELETE FROM db_admin.admin WHERE dni=?");
            stmt.setString(1, singleadmin.Admin_array.get(singletonapp.pos).getDni());
            ok = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Ha habido un error al eliminar el usuario!\n");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger!");
                    ex.printStackTrace();
                }
            }
        }
        return ok;
    }

    
    /**
     * Borra todos los administradores d ela base de datos sql.
     * @param con connection
     * @return connection
     */
    public static int delete_all_Admin(Connection con) {

        PreparedStatement stmt = null;
        int ok = 0;

        try {

            stmt = con.prepareStatement("DELETE FROM db_admin.admin ");

            ok = stmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("Ha habido un error al eliminar los administradores!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger!");
                    ex.printStackTrace();
                }
            }
        }
        return ok;
    }

    /**
     * Funcion que busca en Base de datos sql un admin con los parametros recogidos
     * en el login.
     * @param con connection
     * @return  ture/false
     */
    public static boolean find_in_BD(Connection con) {

        ResultSet rs = null;
        PreparedStatement stmt = null;
        boolean ok = false;

        try {
            stmt = con.prepareStatement("SELECT * FROM  db_admin.admin WHERE user=? AND password=?");

            stmt.setString(1, singletonapp.user);
            stmt.setString(2, singletonapp.password);
            rs = stmt.executeQuery();

            while (rs.next()) {

                singleadmin.a.setDni(rs.getString("dni"));
                singleadmin.a.setName(rs.getString("name"));
                singleadmin.a.setLast_name(rs.getString("last_name"));
                singleadmin.a.setMobile(rs.getString("mobile"));
                singleadmin.a.setDate_birth(new ClassDate(rs.getString("date_birth"), 1));
                singleadmin.a.setAge(rs.getInt("age"));
                singleadmin.a.setEmail(rs.getString("email"));
                singleadmin.a.setUser(rs.getString("user"));
                singleadmin.a.setPassword(rs.getString("password"));
                singleadmin.a.setAvatar(rs.getString("avatar"));
                singleadmin.a.setBenefits(rs.getFloat("benefits"));
                singleadmin.a.setStatus(rs.getString("status"));
                singleadmin.a.setDate_cont(new ClassDate(rs.getString("date_cont"), 1));
                singleadmin.a.setAntique(rs.getInt("antique"));
                singleadmin.a.setSalary(rs.getFloat("salary"));
                singleadmin.a.setActivity(rs.getInt("activity"));

            }

            if (singleadmin.a.getPassword() != null) {

                ok = true;
               
            } else {

                ok = false;

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al buscar el usuario por User");
            
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger");
                }
            }
        }

        return ok;
    }
}
