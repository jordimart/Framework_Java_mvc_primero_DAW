
package Appweb.Modules.Main.Model.Dummies.View;

import Appweb.Modules.Main.Model.Dummies.Model.BLL_Dummy.BLL_Dummies;
import Appweb.Modules.Users.Admin.View.task_Admin_view;
import javax.swing.JFrame;

/**
 *
 * @author ASUSG50V
 */
public class task_Dummy_view extends javax.swing.JFrame {

    /**
     * Creates new form task_Dummy_view
     */
    public task_Dummy_view() {
        initComponents();
        
        this.setTitle("Menu Login");
	this.setLocationRelativeTo(null);
	this.setSize(1000,650);//ancho x alto
	//this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        ///
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        panelRound1 = new org.edisoncor.gui.panel.PanelRound();
        labelRound1 = new org.edisoncor.gui.label.LabelRound();
        labelRound2 = new org.edisoncor.gui.label.LabelRound();
        labelRound3 = new org.edisoncor.gui.label.LabelRound();
        btnCreate_dummis_admin = new org.edisoncor.gui.button.ButtonRound();
        labStatus_dummie_admin = new javax.swing.JLabel();
        btnDelete_all_admin = new org.edisoncor.gui.button.ButtonRound();
        comboDummy_admin = new javax.swing.JComboBox<>();
        panelRound2 = new org.edisoncor.gui.panel.PanelRound();
        btnEntry_admin = new org.edisoncor.gui.button.ButtonRound();
        btnEntry_client = new org.edisoncor.gui.button.ButtonRound();
        btnEntry_user_reg = new org.edisoncor.gui.button.ButtonRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Appweb/General_tools/Img/Fondo_claro_1.jpg"))); // NOI18N

        labelRound1.setText("Dummies usuarios");

        labelRound2.setText("Administrador");

        labelRound3.setText("Numero:");

        btnCreate_dummis_admin.setText("Crear");
        btnCreate_dummis_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreate_dummis_adminActionPerformed(evt);
            }
        });

        btnDelete_all_admin.setText("Borrar todos");
        btnDelete_all_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelete_all_adminActionPerformed(evt);
            }
        });

        comboDummy_admin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cargar", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "100", "1000", "2000" }));

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(labelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labStatus_dummie_admin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                        .addComponent(btnDelete_all_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelRound1Layout.createSequentialGroup()
                        .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                            .addComponent(labelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCreate_dummis_admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboDummy_admin, 0, 135, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(labelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(labelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDummy_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCreate_dummis_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labStatus_dummie_admin, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete_all_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        btnEntry_admin.setText("Entrada Administrador");
        btnEntry_admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntry_adminActionPerformed(evt);
            }
        });

        btnEntry_client.setText("Entrada Cliente");

        btnEntry_user_reg.setText("Entrada Usuario registrado");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(btnEntry_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(btnEntry_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(btnEntry_user_reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntry_admin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntry_client, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntry_user_reg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addComponent(panelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 310, Short.MAX_VALUE)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreate_dummis_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreate_dummis_adminActionPerformed
        BLL_Dummies.create_Dummy_admin();
      
    }//GEN-LAST:event_btnCreate_dummis_adminActionPerformed

    private void btnEntry_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntry_adminActionPerformed
        this.dispose();
        task_Admin_view menu = new task_Admin_view();
        menu.setVisible(true);
    }//GEN-LAST:event_btnEntry_adminActionPerformed

    private void btnDelete_all_adminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelete_all_adminActionPerformed
        BLL_Dummies.Delete_all_admin_dummies();
    }//GEN-LAST:event_btnDelete_all_adminActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static org.edisoncor.gui.button.ButtonRound btnCreate_dummis_admin;
    public static org.edisoncor.gui.button.ButtonRound btnDelete_all_admin;
    public static org.edisoncor.gui.button.ButtonRound btnEntry_admin;
    public static org.edisoncor.gui.button.ButtonRound btnEntry_client;
    public static org.edisoncor.gui.button.ButtonRound btnEntry_user_reg;
    public static javax.swing.JComboBox<String> comboDummy_admin;
    public static javax.swing.JLabel labStatus_dummie_admin;
    public static org.edisoncor.gui.label.LabelRound labelRound1;
    public static org.edisoncor.gui.label.LabelRound labelRound2;
    public static org.edisoncor.gui.label.LabelRound labelRound3;
    public static org.edisoncor.gui.panel.PanelCurves panelCurves1;
    public static org.edisoncor.gui.panel.PanelImage panelImage1;
    public static org.edisoncor.gui.panel.PanelRound panelRound1;
    public static org.edisoncor.gui.panel.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
