package Appweb.Modules.Users.User_reg.Model.Classes;


import Appweb.Classes.Date.ClassDate;
import static Appweb.Modules.Users.User_reg.Controller.ControllerUser.combo;
import Appweb.Modules.Users.User_reg.Model.Tools.Pager.pagina_user;
import Appweb.Modules.Users.User_reg.View.table_User_view;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUSG50V
 */
public class Table_User_reg extends AbstractTableModel {

    public static ArrayList<User_reg> datos = new ArrayList<User_reg>();
    public static ArrayList<User_reg> datosaux = new ArrayList<User_reg>();
    String[] columnas = {"Dni", "Name", "Last name", "Date_birth", "Benefits","Karma"};

    @Override
    public String getColumnName(int col) {
        return columnas[col];
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return datos.size();
    }

    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        Object dev = null;
        User_reg fila = (User_reg) datos.get(row);

        switch (col) {
            case 0:
                dev = fila.getDni();
                break;

            case 1:
                dev = fila.getName();
                break;

            case 2:
                dev = fila.getLast_name();
                break;

            case 3:
                dev = fila.getDate_birth().todate();
                break;

            case 4:
                dev = fila.toBenefits();
                break;
            case 5:
                dev = fila.getKarma();
                break;

        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        User_reg fila = (User_reg) datos.get(row);

        switch (col) {

            case 0:
                fila.setDni(value.toString());

                break;

            case 1:
                fila.setName(value.toString());
                break;

            case 2:
                fila.setLast_name(value.toString());
                break;

            case 3:

                fila.setDate_birth(new ClassDate(value.toString()));
                break;

            case 4:
                fila.setBenefits(Float.parseFloat(value.toString()));
                break;
                
                case 5:
                fila.setKarma(value.toString());
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(User_reg usu) {
        datos.add(usu);

        ((Table_User_reg) table_User_view.mini_Table_User.getModel()).fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();

        User_reg user = null;

        for (int i = 0; i <= singleuser_reg.User_reg_array.size() - 1; i++) {

            user = singleuser_reg.User_reg_array.get(i);

            addRow(user);
            datosaux.add(user);

            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
                System.out.println(e);
            }
        }
         
    }

    public void filtrar() {
        datos.clear();
        int cont = 0;

        String nom = (String) ((JComboBox) combo).getSelectedItem();
        if (nom != null) {
            for (int i = 0; i < datosaux.size(); i++) {
                
                if (datosaux.get(i).getName().toLowerCase().startsWith(nom.toLowerCase())) {
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            table_User_view.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + nom);
            pagina_user.initLinkBox();
        }
    }

    public User_reg buscar(String u) {
        datos.clear();
        cargar();

        String res;
        for (int i = 0; i < datos.size(); i++) {
            res = datos.get(i).toString();
            if (res.contains(u)) {
                return datos.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(User_reg u) {
        datos.clear();
        cargar();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        datos.remove(fila);

        fireTableDataChanged();
        table_User_view.jLabel3.setText(String.valueOf(datos.size()));

        pagina_user.inicializa();
        pagina_user.initLinkBox();

    }

}
