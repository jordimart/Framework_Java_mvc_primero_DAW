/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Users.Classes;

import Appweb.Modules.Users.Admin.View.table_Admin_view;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUSG50V
 */
public class Table_Admin extends AbstractTableModel{
    
   

    public static ArrayList<Admin> datos = new ArrayList<Admin>();
    public static ArrayList<Admin> datosaux = new ArrayList<Admin>();
    String[] columnas = {"DNI", "Name", "Last name", "Mobile", "Date birth", "Date contraitment", "Salary"};

    
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
                dev = fila.getMobile();
                break;
           
            case 4:
                dev = fila.getDate_birth().todate();
                break;
            case 5:
                dev = fila.getDate_cont().todate();
                break;
            case 6:
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
                fila.getDni(value.toString());
                break;

            case 1:
                fila.setNombre(value.toString());
                break;

            case 2:
                fila.setApellidos(value.toString());
                break;

            case 3:
                fila.setDireccion(value.toString());
                break;

            case 4:
                fila.setPoblacion(value.toString());
                break;
            case 5:
                fila.setTelefono(value.toString());
                break;
            case 6:
                fila.setDepartamento(value.toString());
                break;
            case 7:
                fila.setFechaNacimiento((Fecha) value);
                break;
            case 8:
                fila.setFechaContratacion((Fecha) value);
                break;
            case 9:
                fila.setAntiguedad(Integer.parseInt(value.toString()));
                break;
            case 10:
                fila.setEdad(Integer.parseInt(value.toString()));
                break;

            case 11:
                fila.setSueldo(Float.parseFloat(value.toString()));
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Admin usu) {
        datos.add(usu);

         ((Table_Admin) table_Admin_view.Table_Admin.getModel()).fireTableDataChanged();
    }
/**
    public void cargar() {
        datos.clear();
        datosaux.clear();
        int resultado;
        int restanyos;
        int restaanyos2;
        Fecha nac = null;
        Fecha cont = null;

        Empleadofijo fijo = null;
        java.util.Date date = new java.util.Date();

        for (int i = 0; i <= 2000; i++) {

            Fecha d = Fnes.getFechaAleatoria();
            Fecha r = Fnes.getFechaAleatoria();

            resultado = d.comparafechas(r);
            // compara con el sistema y
            // calcula la edad

            if (resultado == -1) {
                restanyos = d.restarAnyos(0, null);

                if ((restanyos > 15) && (restanyos < 66)) {

                    restaanyos2 = r.restarAnyos(1, d); // resto
                    // la
                    // entre
                    // ambas
                    if ((restaanyos2 > 15) && (restaanyos2 < 66))// rango de
                    {
                        nac = d;
                        cont = r;
                 // de
                        // nacimiento

                    //JOptionPane.showMessageDialog(null,
                        //"La diferencia entre las dos fechas ha de ser mínimo 16 años", "Atención",
                        //JOptionPane.WARNING_MESSAGE);
                // el empleado debe estar
                        // entre este rango de
                        // edad
                        //  (String nombre, String apellidos, String dni, String direccion, String poblacion, String telefono, String departamento, Fecha fechaNacimiento, Fecha fechaContratacion)
                        fijo = new Empleadofijo(getCadenaAleatoriaprueba(i), Fnes.getCadenaAleatoria1(4), Fnes.getCadenaAleatoria1(6), Fnes.getCadenaAleatoria2(4), Fnes.getCadenaAleatoria1(4), Fnes.getCadenaAleatoria6(9), Fnes.getCadenaAleatoria2(4), nac, cont);

                        if (fijo != null) {
                            addRow(fijo);
                            datosaux.add(fijo);
                            ArraylistEF.efi.add(fijo);
                        }

                    }
                }
            }

            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public void cargarB() {

        datos.clear();

        datosaux.clear();
        //EFBLLgrafico.AbrirSilencioso();

        //cargar el arraylist datos dvd
        Empleadofijo ef = new Empleadofijo("48290929Z", "Antonio", "Gómez", "625860765", "Av.Almansa", "Ontinyent", "Informática", new Fecha("07/08/1987", "dd/MM/yyyy"), new Fecha("07/08/2009", "dd/MM/yyyy"));
        addRow(ef);
        datosaux.add(ef);

        ArraylistEF.efi.add(ef);
        Empleadofijo ef1 = new Empleadofijo("48290929S", "Antonio", "Gómez", "625860765", "Av.Almansa", "Ontinyent", "Informática", new Fecha("07/08/1987", "dd/MM/yyyy"), new Fecha("07/08/2009", "dd/MM/yyyy"));
        addRow(ef1);
        datosaux.add(ef1);

        ArraylistEF.efi.add(ef1);

    }

    public void cargarA() {

        datos.clear();

        datosaux.clear();
        EFBLLgrafico.Abrir();

        //cargar el arraylist datos 
        for (int i = 0; i < ArraylistEF.efi.size(); i++) {
            addRow(ArraylistEF.efi.get(i));
            datosaux.add(ArraylistEF.efi.get(i));
        }
    }
*/
    
    /**
    public void filtrar() {
        datos.clear();

        int cont = 0;
        String nom = (String) table_Admin_view.filtrar.getText();
        for (int i = 0; i < datosaux.size(); i++) {
            if (datosaux.get(i).getLast_name().contains(nom)) {
                addRow(datosaux.get(i));
                cont++;
            }
        }
        JOptionPane.showMessageDialog(null, cont);
        pagina.initLinkBox();
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
    }
     */
}
