package Appweb.Modules.Users.Admin.Model.Classes;

import Appweb.Modules.Users.Admin.Model.Classes.Admin;
import Appweb.Classes.Date.ClassDate;
import Appweb.Modules.Users.Admin.Model.Tools.Pager.pagina;
import Appweb.Modules.Users.Admin.View.table_Admin_view;
import static Appweb.Modules.Users.Admin.View.table_Admin_view.combo;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUSG50V
 */
public class Table_Admin extends AbstractTableModel {

    public static ArrayList<Admin> datos = new ArrayList<Admin>();
    public static ArrayList<Admin> datosaux = new ArrayList<Admin>();
    String[] columnas = {"Dni", "Name", "Last name", "Date_birth", "Antique", "Salary"};

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
        Admin fila = (Admin) datos.get(row);

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
                dev = fila.getAntique();
                break;
            case 5:
                dev = fila.getSalary();
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
        Admin fila = (Admin) datos.get(row);

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
                fila.setSalary(Float.parseFloat(value.toString()));
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Admin usu) {
        datos.add(usu);

        ((Table_Admin) table_Admin_view.mini_Table_Admin.getModel()).fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();

        Admin admin = null;

        for (int i = 0; i <= singleadmin.Admin_array.size() - 1; i++) {

            admin = singleadmin.Admin_array.get(i);

            addRow(admin);
            datosaux.add(admin);

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
                //if(datosaux.get(i).getFirst_name().contains(nom)){
                if (datosaux.get(i).getName().toLowerCase().startsWith(nom.toLowerCase())) {
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            table_Admin_view.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + nom);
            pagina.initLinkBox();
        }
    }

    public Admin buscar(String u) {
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

    public int buscaUsuario(Admin u) {
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
        table_Admin_view.jLabel3.setText(String.valueOf(datos.size()));

        pagina.inicializa();
        pagina.initLinkBox();

    }

}
