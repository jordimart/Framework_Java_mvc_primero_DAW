package Appweb.Modules.Users.Admin.Model.Tools.Pager;

import Appweb.General_tools.singletonapp;
import Appweb.Modules.Users.Admin.View.table_Admin_view;
import Appweb.Modules.Users.Admin.Model.Classes.Table_Admin_class;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;

public class pagina {

    public static final LinkViewRadioButtonUI ui = new LinkViewRadioButtonUI();
    public static int LR_PAGE_SIZE = 5;
    public static Box box = Box.createHorizontalBox();

    public static int currentPageIndex = 1;
    public static int itemsPerPage = 5;
    public static int maxPageIndex;

    public static void inicializa() {
        int rowCount = 0;
        
                rowCount = ((Table_Admin_class) Appweb.Modules.Users.Admin.View.table_Admin_view.mini_Table_Admin.getModel()).getRowCount();
                

        int v = rowCount % itemsPerPage == 0 ? 0 : 1;
        maxPageIndex = rowCount / itemsPerPage + v;

        box.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
        
                table_Admin_view.jPanel4.setLayout(new BorderLayout());
                table_Admin_view.jPanel4.add(pagina.box);
                
    }

    public static void initLinkBox() {
        
                Appweb.Modules.Users.Admin.Controller.ControllerAdmin.sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                    @Override
                    public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                        int ti = currentPageIndex - 1;
                        int ei = entry.getIdentifier();
                        return ti * itemsPerPage <= ei && ei < ti * itemsPerPage + itemsPerPage;
                    }
                });
                

        int startPageIndex = currentPageIndex - LR_PAGE_SIZE;
        int endPageIndex = 0;
        if (startPageIndex <= 0) {
            startPageIndex = 1;
        }

        int rowCount = 0;
        
                rowCount = ((Table_Admin_class) Appweb.Modules.Users.Admin.View.table_Admin_view.mini_Table_Admin.getModel()).getRowCount();
               

        int v = rowCount % itemsPerPage == 0 ? 0 : 1;
        maxPageIndex = rowCount / itemsPerPage + v;
        endPageIndex = currentPageIndex + LR_PAGE_SIZE - 1;
        if (endPageIndex > maxPageIndex) {
            endPageIndex = maxPageIndex;
        }

        box.removeAll();
        if ((rowCount <= itemsPerPage) && (rowCount > 0)) { //caben todos los datos en la misma página
            
                    //actualizar botones y caja: desactivarlos
                    table_Admin_view.primero.setEnabled(false);
                    table_Admin_view.ANTERIOR.setEnabled(false);
                    table_Admin_view.ultimo.setEnabled(false);
                    table_Admin_view.SIGUIENTE.setEnabled(false);
                    table_Admin_view.CAJA.setText("");
                   
            //actualizar enlaces: sólo 1 enlace
            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            JRadioButton c = makeRadioButton(1);
            box.add(c);
            bg.add(c);
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();

        } else if (rowCount == 0) { //no hay rdos
            
                    //actualizar botones y caja: desactivarlos
                    table_Admin_view.primero.setEnabled(false);
                    table_Admin_view.ANTERIOR.setEnabled(false);
                    table_Admin_view.ultimo.setEnabled(false);
                    table_Admin_view.SIGUIENTE.setEnabled(false);
                    table_Admin_view.CAJA.setText("");
                    
            //actualizar enlaces: no hay enlaces
            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            JRadioButton c = makeRadioButton(0);
            box.add(c);
            bg.add(c);
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();

        } else if (rowCount > itemsPerPage) {
            

                    table_Admin_view.primero.setEnabled(currentPageIndex > 1);
                    table_Admin_view.ANTERIOR.setEnabled(currentPageIndex > 1);
                    table_Admin_view.ultimo.setEnabled(currentPageIndex < maxPageIndex);
                    table_Admin_view.SIGUIENTE.setEnabled(currentPageIndex < maxPageIndex);
                    table_Admin_view.CAJA.setText(Integer.toString(currentPageIndex) + String.format(" / %d", maxPageIndex));
                   

            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            for (int i = startPageIndex; i <= endPageIndex; i++) {
                JRadioButton c = makeRadioButton(i);
                box.add(c);
                bg.add(c);
            }
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();
        }
    }

    

    public static JRadioButton makeRadioButton(final int target) {
        JRadioButton radio = new JRadioButton(String.valueOf(target)) {
            @Override
            protected void fireStateChanged() {
                ButtonModel model1 = getModel();
                if (!model1.isEnabled()) {
                    setForeground(Color.GRAY);
                } else if (model1.isPressed() && model1.isArmed()) {
                    setForeground(Color.GREEN);
                } else if (model1.isSelected()) {
                    setForeground(Color.RED);
                }
                super.fireStateChanged();
            }
        };
        radio.setForeground(Color.BLUE);
        radio.setUI(ui);
        if (target == currentPageIndex) {
            radio.setSelected(true);
        }
        radio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentPageIndex = target;
                initLinkBox();
            }
        });
        return radio;
    }
}
