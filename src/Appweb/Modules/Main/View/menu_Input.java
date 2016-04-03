package Appweb.Modules.Main.View;

/**
 *
 * @author ASUSG50V
 */
public class menu_Input extends javax.swing.JFrame {

    
    public menu_Input() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelNice1 = new org.edisoncor.gui.panel.PanelNice();
        Login_Admin = new javax.swing.JButton();
        Login_User_reg = new javax.swing.JButton();
        Login_Client = new javax.swing.JButton();
        btn_Exit = new javax.swing.JButton();
        btn_Test = new javax.swing.JButton();
        btnSettings = new javax.swing.JButton();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        btn_valencian_main = new javax.swing.JButton();
        btn_spain_main = new javax.swing.JButton();
        btn_English_main = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Appweb/General_tools/Img/Fondo_claro_1.jpg"))); // NOI18N

        Login_Admin.setText("Entrada Administrador");
        Login_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_AdminActionPerformed(evt);
            }
        });

        Login_User_reg.setText("Entrada User_reg");

        Login_Client.setText("Entrada Cliente");

        btn_Exit.setText("Salir");
        btn_Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ExitActionPerformed(evt);
            }
        });

        btn_Test.setText("Entrada Test");
        btn_Test.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TestActionPerformed(evt);
            }
        });

        btnSettings.setText("Configuracion");
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNice1Layout = new javax.swing.GroupLayout(panelNice1);
        panelNice1.setLayout(panelNice1Layout);
        panelNice1Layout.setHorizontalGroup(
            panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNice1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Login_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(Login_User_reg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Login_Client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Test, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelNice1Layout.setVerticalGroup(
            panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNice1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Login_Admin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login_User_reg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login_Client)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Test)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Exit)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        btn_valencian_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Appweb/Modules/Main/img/BanderaValencia.png"))); // NOI18N
        btn_valencian_main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_valencian_mainActionPerformed(evt);
            }
        });

        btn_spain_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Appweb/Modules/Main/img/Spain48x48.png"))); // NOI18N
        btn_spain_main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_spain_mainActionPerformed(evt);
            }
        });

        btn_English_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Appweb/Modules/Main/img/United Kingdom48x48.png"))); // NOI18N
        btn_English_main.setPreferredSize(new java.awt.Dimension(48, 48));
        btn_English_main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_English_mainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap(707, Short.MAX_VALUE)
                .addComponent(btn_English_main, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_spain_main, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_valencian_main, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(panelNice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addComponent(panelCurves1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_valencian_main, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_spain_main, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_English_main, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelNice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 286, Short.MAX_VALUE)
                .addComponent(panelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login_AdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_AdminActionPerformed


    }//GEN-LAST:event_Login_AdminActionPerformed

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed


    }//GEN-LAST:event_btn_ExitActionPerformed

    private void btn_English_mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_English_mainActionPerformed


    }//GEN-LAST:event_btn_English_mainActionPerformed

    private void btn_spain_mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_spain_mainActionPerformed


    }//GEN-LAST:event_btn_spain_mainActionPerformed

    private void btn_valencian_mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_valencian_mainActionPerformed


    }//GEN-LAST:event_btn_valencian_mainActionPerformed

    private void btn_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TestActionPerformed

    }//GEN-LAST:event_btn_TestActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed

    }//GEN-LAST:event_btnSettingsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton Login_Admin;
    public static javax.swing.JButton Login_Client;
    public static javax.swing.JButton Login_User_reg;
    public static javax.swing.JButton btnSettings;
    public static javax.swing.JButton btn_English_main;
    public static javax.swing.JButton btn_Exit;
    public static javax.swing.JButton btn_Test;
    public static javax.swing.JButton btn_spain_main;
    public static javax.swing.JButton btn_valencian_main;
    public static org.edisoncor.gui.panel.PanelCurves panelCurves1;
    public static org.edisoncor.gui.panel.PanelImage panelImage1;
    public static org.edisoncor.gui.panel.PanelNice panelNice1;
    // End of variables declaration//GEN-END:variables
}
