package Appweb.Modules.Users.Client.Model.Classes;

import Appweb.Classes.Date.ClassDate;
import static Appweb.Modules.Users.Client.Controller.ControllerClient.combo;
import Appweb.Modules.Users.Client.Model.Tools.Pager.pagina_client;




import Appweb.Modules.Users.Client.View.table_Client_view;


import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUSG50V
 */
public class Table_Client_class extends AbstractTableModel {

    public static ArrayList<Client> datos = new ArrayList<Client>();
    public static ArrayList<Client> datosaux = new ArrayList<Client>();
    String[] columnas = {"Dni", "Name", "Last name", "Date_birth", "Antique","Purchase"};

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
        Client fila = (Client) datos.get(row);

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
                dev = fila.getAntique_c();
                break;
            case 5:
                dev = fila.getPurchase();
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
        Client fila = (Client) datos.get(row);

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
                fila.setPurchase(Float.parseFloat(value.toString()));
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(Client usu) {
        datos.add(usu);

        ((Table_Client_class) table_Client_view.mini_Table_Client.getModel()).fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();

        Client client = null;

        for (int i = 0; i <= singleclient.Client_array.size() - 1; i++) {

            client = singleclient.Client_array.get(i);

            addRow(client);
            datosaux.add(client);

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
            table_Client_view.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + nom);
            pagina_client.initLinkBox();
        }
    }

    public Client buscar(String u) {
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

    public int buscaUsuario(Client u) {
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
        table_Client_view.jLabel3.setText(String.valueOf(datos.size()));

        pagina_client.inicializa();
        pagina_client.initLinkBox();

    }

}
