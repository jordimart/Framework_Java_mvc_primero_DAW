package Appweb.Modules.Users.Classes;

import Appweb.Modules.Users.Admin.View.table_Admin_view;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUSG50V
 */
public class Table_Admin extends AbstractTableModel {

    public static ArrayList<Admin> datos = new ArrayList<Admin>();
    public static ArrayList<Admin> datosaux = new ArrayList<Admin>();
    String[] columnas = {"Dni", "Name", "Last name", "Age", "Antique", "Salary"};

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
                dev = fila.getAge();
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
                fila.setAge(Integer.parseInt(value.toString()));
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

        for (int i = 0; i <= singleton.Admin_array.size() - 1; i++) {

            admin = singleton.Admin_array.get(i);

            addRow(admin);
            datosaux.add(admin);

            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

}
