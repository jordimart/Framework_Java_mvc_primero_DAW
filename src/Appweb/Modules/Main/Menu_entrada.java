/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Main;

import Appweb.Classes.Language.Lang;
import Appweb.Modules.Config.Classconfig;
import Appweb.Modules.Config.Config_tools;
import Appweb.Modules.Users.Admin.View.task_Admin_view;
import Appweb.Modules.Dummies.View.task_Dummy_view;
import Appweb.Modules.Users.Users_tools.User_files.json;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUSG50V
 */
public class Menu_entrada extends javax.swing.JFrame {

    /**
     * Creates new form Menu_entrada
     */
    public Menu_entrada() {
        initComponents();
        
        this.setTitle("Menu Login");
	this.setLocationRelativeTo(null);
	this.setSize(1000,650);//ancho x alto
	//this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
	
       
        
    }

    /**
     * eixir de l'aplicació
     */
    private void exit() {

        json.auto_save_json_file();
        Config_tools.auto_save_config_json();
       
        JOptionPane.showMessageDialog(null, Lang.getInstance().getProperty("I_to_exit_aplication"), Lang.getInstance().getProperty("Exit"),
                JOptionPane.INFORMATION_MESSAGE);
        dispose();
        System.exit(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelNice1 = new org.edisoncor.gui.panel.PanelNice();
        Login_Admin = new javax.swing.JButton();
        Login_Tecnic = new javax.swing.JButton();
        Login_Client = new javax.swing.JButton();
        btn_Exit = new javax.swing.JButton();
        btn_Test = new javax.swing.JButton();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        btn_valencian_main = new javax.swing.JButton();
        btn_spain_main = new javax.swing.JButton();
        btn_Ingles_main = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Appweb/General_tools/Img/Fondo_claro_1.jpg"))); // NOI18N

        Login_Admin.setText("Entrada Administrador");
        Login_Admin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_AdminActionPerformed(evt);
            }
        });

        Login_Tecnic.setText("Entrada Tecnico");

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

        javax.swing.GroupLayout panelNice1Layout = new javax.swing.GroupLayout(panelNice1);
        panelNice1.setLayout(panelNice1Layout);
        panelNice1Layout.setHorizontalGroup(
            panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNice1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Login_Admin, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(Login_Tecnic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Login_Client, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Test, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelNice1Layout.setVerticalGroup(
            panelNice1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNice1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(Login_Admin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login_Tecnic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Login_Client)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Test)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Exit)
                .addContainerGap(26, Short.MAX_VALUE))
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

        btn_Ingles_main.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Appweb/Modules/Main/img/United Kingdom48x48.png"))); // NOI18N
        btn_Ingles_main.setPreferredSize(new java.awt.Dimension(48, 48));
        btn_Ingles_main.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Ingles_mainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelImage1Layout.createSequentialGroup()
                .addContainerGap(640, Short.MAX_VALUE)
                .addComponent(btn_Ingles_main, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_spain_main, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_valencian_main, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addComponent(btn_Ingles_main, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelNice1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
                .addComponent(panelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
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
        
        this.dispose();
        task_Admin_view menu = new task_Admin_view();
        menu.setVisible(true);
       

    }//GEN-LAST:event_Login_AdminActionPerformed

    private void btn_ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ExitActionPerformed

        exit();
    }//GEN-LAST:event_btn_ExitActionPerformed

    private void btn_Ingles_mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Ingles_mainActionPerformed
        
        Classconfig.getInstance().setLanguage("english");
    }//GEN-LAST:event_btn_Ingles_mainActionPerformed

    private void btn_spain_mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_spain_mainActionPerformed
        
        Classconfig.getInstance().setLanguage("español");
    }//GEN-LAST:event_btn_spain_mainActionPerformed

    private void btn_valencian_mainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_valencian_mainActionPerformed
        
        Classconfig.getInstance().setLanguage("valencia");
    }//GEN-LAST:event_btn_valencian_mainActionPerformed

    private void btn_TestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TestActionPerformed
        this.dispose();
        task_Dummy_view menu = new task_Dummy_view();
        menu.setVisible(true);
    }//GEN-LAST:event_btn_TestActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Login_Admin;
    private javax.swing.JButton Login_Client;
    private javax.swing.JButton Login_Tecnic;
    private javax.swing.JButton btn_Exit;
    private javax.swing.JButton btn_Ingles_main;
    private javax.swing.JButton btn_Test;
    private javax.swing.JButton btn_spain_main;
    private javax.swing.JButton btn_valencian_main;
    private org.edisoncor.gui.panel.PanelCurves panelCurves1;
    private org.edisoncor.gui.panel.PanelImage panelImage1;
    private org.edisoncor.gui.panel.PanelNice panelNice1;
    // End of variables declaration//GEN-END:variables
}
