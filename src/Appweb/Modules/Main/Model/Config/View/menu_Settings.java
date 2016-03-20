/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appweb.Modules.Main.Model.Config.View;

import Appweb.Modules.Main.Model.Config.Classes.Classconfig;
import Appweb.Modules.Main.Model.Config.Classes.Language.Lang;
import Appweb.Modules.Main.Model.Config.Model.BLL_config.BLL_config;
import Appweb.Modules.Main.View.menu_Input;
import Appweb.Modules.Users.Admin.View.task_Admin_view;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author ASUSG50V
 */
public class menu_Settings extends javax.swing.JFrame {

    /**
     * Creates new form menu_Settings
     */
    public menu_Settings() {
        initComponents();
        this.setTitle("Menu Settings");
        this.setLocationRelativeTo(null);
        this.setSize(980, 800);//ancho x alto
        this.setResizable(false);
        chk_day_bar.setSelected(true);
        chk_one_d.setSelected(true);
        chk_curr_euro.setSelected(true);
        chk_lang_en.setSelected(true);
        ///
        
         this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
                menu_Input menu = new menu_Input();

                menu.setVisible(true);

            }
        });
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group_date = new javax.swing.ButtonGroup();
        group_dec = new javax.swing.ButtonGroup();
        group_currency = new javax.swing.ButtonGroup();
        group_language = new javax.swing.ButtonGroup();
        panelImage1 = new org.edisoncor.gui.panel.PanelImage();
        panelCurves1 = new org.edisoncor.gui.panel.PanelCurves();
        panelRectTranslucido1 = new org.edisoncor.gui.panel.PanelRectTranslucido();
        panelRound1 = new org.edisoncor.gui.panel.PanelRound();
        chk_day_bar = new javax.swing.JRadioButton();
        chk_day_bar2 = new javax.swing.JRadioButton();
        chk_year_bar = new javax.swing.JRadioButton();
        chk_year_bar2 = new javax.swing.JRadioButton();
        labelHeader1 = new org.edisoncor.gui.label.LabelHeader();
        panelRound2 = new org.edisoncor.gui.panel.PanelRound();
        chk_one_d = new javax.swing.JRadioButton();
        chk_two_d = new javax.swing.JRadioButton();
        chk_three_d = new javax.swing.JRadioButton();
        labelHeader2 = new org.edisoncor.gui.label.LabelHeader();
        panelRound3 = new org.edisoncor.gui.panel.PanelRound();
        chk_lang_en = new javax.swing.JRadioButton();
        chk_lang_es = new javax.swing.JRadioButton();
        chk_lang_val = new javax.swing.JRadioButton();
        labelHeader4 = new org.edisoncor.gui.label.LabelHeader();
        panelRound4 = new org.edisoncor.gui.panel.PanelRound();
        Combo_Theme = new javax.swing.JComboBox<>();
        labelHeader5 = new org.edisoncor.gui.label.LabelHeader();
        panelRound5 = new org.edisoncor.gui.panel.PanelRound();
        chk_curr_euro = new javax.swing.JRadioButton();
        chk_curr_dollar = new javax.swing.JRadioButton();
        chk_curr_pound = new javax.swing.JRadioButton();
        labelHeader3 = new org.edisoncor.gui.label.LabelHeader();
        btn_Accept_Settings = new org.edisoncor.gui.button.ButtonAction();
        btn_Load_Settings = new org.edisoncor.gui.button.ButtonAction();
        btn_Return_Settings = new org.edisoncor.gui.button.ButtonAction();
        btn_Save_setting = new org.edisoncor.gui.button.ButtonAction();
        btn_Show = new org.edisoncor.gui.button.ButtonAction();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Appweb/General_tools/Img/Fondo_claro_1.jpg"))); // NOI18N

        panelRectTranslucido1.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu Configuracion"));

        group_date.add(chk_day_bar);
        chk_day_bar.setText("dd/mm/yyyy");

        group_date.add(chk_day_bar2);
        chk_day_bar2.setText("dd-mm-yyyy");

        group_date.add(chk_year_bar);
        chk_year_bar.setText("yyyy/mm/dd");

        group_date.add(chk_year_bar2);
        chk_year_bar2.setText("yyyy-mm-dd");

        labelHeader1.setText("Formato fecha");

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_year_bar2)
                    .addComponent(chk_year_bar)
                    .addComponent(chk_day_bar2)
                    .addGroup(panelRound1Layout.createSequentialGroup()
                        .addComponent(chk_day_bar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_day_bar)
                    .addComponent(labelHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chk_day_bar2)
                .addGap(12, 12, 12)
                .addComponent(chk_year_bar)
                .addGap(12, 12, 12)
                .addComponent(chk_year_bar2)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        group_dec.add(chk_one_d);
        chk_one_d.setText("0.0");

        group_dec.add(chk_two_d);
        chk_two_d.setText("0.00");

        group_dec.add(chk_three_d);
        chk_three_d.setText("0.000");

        labelHeader2.setText("Formato decimales");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chk_three_d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chk_two_d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chk_one_d, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_one_d)
                    .addComponent(labelHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chk_two_d)
                .addGap(18, 18, 18)
                .addComponent(chk_three_d)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        group_language.add(chk_lang_en);
        chk_lang_en.setText("english");

        group_language.add(chk_lang_es);
        chk_lang_es.setText("español");

        group_language.add(chk_lang_val);
        chk_lang_val.setText("valencia");

        labelHeader4.setText("Lenguage");

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chk_lang_en, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chk_lang_val, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chk_lang_es, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelHeader4, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_lang_en)
                    .addComponent(labelHeader4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chk_lang_es)
                .addGap(18, 18, 18)
                .addComponent(chk_lang_val)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Combo_Theme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Metal", "System", "Motif", "Nimbus", "Windows classic", "Synthetica" }));

        labelHeader5.setText("Apariencia");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Combo_Theme, 0, 194, Short.MAX_VALUE)
                    .addComponent(labelHeader5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHeader5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Combo_Theme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );

        group_currency.add(chk_curr_euro);
        chk_curr_euro.setText("euro");

        group_currency.add(chk_curr_dollar);
        chk_curr_dollar.setText("dolar");

        group_currency.add(chk_curr_pound);
        chk_curr_pound.setText("pound");

        labelHeader3.setText("Moneda");

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(chk_curr_pound, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(chk_curr_dollar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(chk_curr_euro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(labelHeader3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chk_curr_euro)
                    .addComponent(labelHeader3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chk_curr_dollar)
                .addGap(18, 18, 18)
                .addComponent(chk_curr_pound)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btn_Accept_Settings.setText("Aplicar");
        btn_Accept_Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Accept_SettingsActionPerformed(evt);
            }
        });

        btn_Load_Settings.setText("Cargar");
        btn_Load_Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Load_SettingsActionPerformed(evt);
            }
        });

        btn_Return_Settings.setText("Volver");
        btn_Return_Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Return_SettingsActionPerformed(evt);
            }
        });

        btn_Save_setting.setText("Guardar");
        btn_Save_setting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Save_settingActionPerformed(evt);
            }
        });

        btn_Show.setText("Mostrar");
        btn_Show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRectTranslucido1Layout = new javax.swing.GroupLayout(panelRectTranslucido1);
        panelRectTranslucido1.setLayout(panelRectTranslucido1Layout);
        panelRectTranslucido1Layout.setHorizontalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                        .addComponent(panelRound3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btn_Accept_Settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Load_Settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Return_Settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Save_setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelRectTranslucido1Layout.setVerticalGroup(
            panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                        .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRectTranslucido1Layout.createSequentialGroup()
                        .addComponent(btn_Accept_Settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Load_Settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Save_setting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Show, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btn_Return_Settings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panelRectTranslucido1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelRound4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelImage1Layout = new javax.swing.GroupLayout(panelImage1);
        panelImage1.setLayout(panelImage1Layout);
        panelImage1Layout.setHorizontalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(panelCurves1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelImage1Layout.setVerticalGroup(
            panelImage1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelImage1Layout.createSequentialGroup()
                .addComponent(panelCurves1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRectTranslucido1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelImage1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Return_SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Return_SettingsActionPerformed

        this.dispose();
        task_Admin_view menu = new task_Admin_view();
        menu.setVisible(true);
    }//GEN-LAST:event_btn_Return_SettingsActionPerformed

    private void btn_Accept_SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Accept_SettingsActionPerformed

        BLL_config.Configuration_accept();
        BLL_config.auto_save_config_json();
    }//GEN-LAST:event_btn_Accept_SettingsActionPerformed

    private void btn_Load_SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Load_SettingsActionPerformed
        BLL_config.open_config_json();
    }//GEN-LAST:event_btn_Load_SettingsActionPerformed

    private void btn_Save_settingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Save_settingActionPerformed
        BLL_config.save_config_json();
    }//GEN-LAST:event_btn_Save_settingActionPerformed

    private void btn_ShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ShowActionPerformed
        JOptionPane.showMessageDialog(null, Classconfig.getInstance().tostring());
    }//GEN-LAST:event_btn_ShowActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JComboBox<String> Combo_Theme;
    public static org.edisoncor.gui.button.ButtonAction btn_Accept_Settings;
    public static org.edisoncor.gui.button.ButtonAction btn_Load_Settings;
    public static org.edisoncor.gui.button.ButtonAction btn_Return_Settings;
    public static org.edisoncor.gui.button.ButtonAction btn_Save_setting;
    public static org.edisoncor.gui.button.ButtonAction btn_Show;
    public static javax.swing.JRadioButton chk_curr_dollar;
    public static javax.swing.JRadioButton chk_curr_euro;
    public static javax.swing.JRadioButton chk_curr_pound;
    public static javax.swing.JRadioButton chk_day_bar;
    public static javax.swing.JRadioButton chk_day_bar2;
    public static javax.swing.JRadioButton chk_lang_en;
    public static javax.swing.JRadioButton chk_lang_es;
    public static javax.swing.JRadioButton chk_lang_val;
    public static javax.swing.JRadioButton chk_one_d;
    public static javax.swing.JRadioButton chk_three_d;
    public static javax.swing.JRadioButton chk_two_d;
    public static javax.swing.JRadioButton chk_year_bar;
    public static javax.swing.JRadioButton chk_year_bar2;
    public static javax.swing.ButtonGroup group_currency;
    public static javax.swing.ButtonGroup group_date;
    public static javax.swing.ButtonGroup group_dec;
    public static javax.swing.ButtonGroup group_language;
    public static org.edisoncor.gui.label.LabelHeader labelHeader1;
    public static org.edisoncor.gui.label.LabelHeader labelHeader2;
    public static org.edisoncor.gui.label.LabelHeader labelHeader3;
    public static org.edisoncor.gui.label.LabelHeader labelHeader4;
    public static org.edisoncor.gui.label.LabelHeader labelHeader5;
    public static org.edisoncor.gui.panel.PanelCurves panelCurves1;
    public static org.edisoncor.gui.panel.PanelImage panelImage1;
    public static org.edisoncor.gui.panel.PanelRectTranslucido panelRectTranslucido1;
    public static org.edisoncor.gui.panel.PanelRound panelRound1;
    public static org.edisoncor.gui.panel.PanelRound panelRound2;
    public static org.edisoncor.gui.panel.PanelRound panelRound3;
    public static org.edisoncor.gui.panel.PanelRound panelRound4;
    public static org.edisoncor.gui.panel.PanelRound panelRound5;
    // End of variables declaration//GEN-END:variables
}
