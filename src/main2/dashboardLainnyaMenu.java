/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.Timer;
import main1.loginAdmin;

/**
 *
 * @author USER
 */
public class dashboardLainnyaMenu extends javax.swing.JFrame {
int xMouse;
int yMouse;
    /**
     * Creates new form dashboardLainnyaMenu
     */
    public dashboardLainnyaMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        showDate();
        showTime();
    }
void showDate(){
        Date d =  new Date();   //condtructor
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");  //constructor
        jLabel2.setText(s.format(d));
    }
 void showTime(){
        new Timer(0, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Date d = new Date();   //constructor
                SimpleDateFormat s = new SimpleDateFormat("hh:mm:ss a");
                jLabel3.setText(s.format(d));
            }

           }        
        ).start();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelClose = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        btnlogout = new javax.swing.JLabel();
        btnDashboardAdminMenu = new javax.swing.JLabel();
        btnDashboardPerkuliahanMenu = new javax.swing.JLabel();
        btnDashboardDosenMenu = new javax.swing.JLabel();
        btnDashboardMahasiswaMenu = new javax.swing.JLabel();
        btnDashboardHome = new javax.swing.JLabel();
        btnRuang = new javax.swing.JLabel();
        btnMataKuliah = new javax.swing.JLabel();
        btnProgramStudi = new javax.swing.JLabel();
        btnJurusan = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        frameDrag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelClose.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelClose.setForeground(new java.awt.Color(255, 255, 255));
        jLabelClose.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClose.setText("x");
        jLabelClose.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCloseMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jLabelMin.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabelMin.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMin.setText("-");
        jLabelMin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelMin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelMinMouseClicked(evt);
            }
        });
        getContentPane().add(jLabelMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 40));

        btnlogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
        });
        getContentPane().add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 284, 150, 30));

        btnDashboardAdminMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDashboardAdminMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashboardAdminMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardAdminMenuMouseClicked(evt);
            }
        });
        getContentPane().add(btnDashboardAdminMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 244, 150, 30));

        btnDashboardPerkuliahanMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDashboardPerkuliahanMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashboardPerkuliahanMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardPerkuliahanMenuMouseClicked(evt);
            }
        });
        getContentPane().add(btnDashboardPerkuliahanMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 210, 150, 30));

        btnDashboardDosenMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDashboardDosenMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashboardDosenMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardDosenMenuMouseClicked(evt);
            }
        });
        getContentPane().add(btnDashboardDosenMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 150, 30));

        btnDashboardMahasiswaMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDashboardMahasiswaMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashboardMahasiswaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMahasiswaMenuMouseClicked(evt);
            }
        });
        getContentPane().add(btnDashboardMahasiswaMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 134, 150, 30));

        btnDashboardHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDashboardHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardHomeMouseClicked(evt);
            }
        });
        getContentPane().add(btnDashboardHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, 30));

        btnRuang.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnRuang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRuang.setText("RUANG");
        btnRuang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRuang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRuangMouseClicked(evt);
            }
        });
        getContentPane().add(btnRuang, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 260, 90));

        btnMataKuliah.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnMataKuliah.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMataKuliah.setText("MATA KULIAH");
        btnMataKuliah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMataKuliah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMataKuliahMouseClicked(evt);
            }
        });
        getContentPane().add(btnMataKuliah, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 414, 250, 90));

        btnProgramStudi.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnProgramStudi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProgramStudi.setText("PROGRAM STUDI");
        btnProgramStudi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProgramStudi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProgramStudiMouseClicked(evt);
            }
        });
        getContentPane().add(btnProgramStudi, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 220, 260, 80));

        btnJurusan.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnJurusan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnJurusan.setText("JURUSAN");
        btnJurusan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnJurusanMouseClicked(evt);
            }
        });
        getContentPane().add(btnJurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 250, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 130, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, 80, 30));

        frameDrag.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                frameDragMouseDragged(evt);
            }
        });
        frameDrag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                frameDragMousePressed(evt);
            }
        });
        getContentPane().add(frameDrag, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 30));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/DASHBOARD ADMIN.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseClicked
        // TODO add your handling code here:
        loginAdmin Admin = new loginAdmin();
        Admin.setVisible(true);
        Admin.pack();
        Admin.setLocationRelativeTo(null);
        Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnlogoutMouseClicked

    private void btnDashboardAdminMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardAdminMenuMouseClicked
        // TODO add your handling code here:
        dashboardAdminMenu dshAdmin = new dashboardAdminMenu();
        dshAdmin.setVisible(true);
        dshAdmin.pack();
        dshAdmin.setLocationRelativeTo(null);
        dshAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnDashboardAdminMenuMouseClicked

    private void btnDashboardPerkuliahanMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardPerkuliahanMenuMouseClicked
        // TODO add your handling code here:
        dashboardPerkuliahanMenu dshPerkuliahan = new dashboardPerkuliahanMenu();
        dshPerkuliahan.setVisible(true);
        dshPerkuliahan.pack();
        dshPerkuliahan.setLocationRelativeTo(null);
        dshPerkuliahan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnDashboardPerkuliahanMenuMouseClicked

    private void btnDashboardDosenMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardDosenMenuMouseClicked
        // TODO add your handling code here:
        dashboardDosenMenu dshDosen = new dashboardDosenMenu();
        dshDosen.setVisible(true);
        dshDosen.pack();
        dshDosen.setLocationRelativeTo(null);
        dshDosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnDashboardDosenMenuMouseClicked

    private void btnDashboardMahasiswaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMahasiswaMenuMouseClicked
        // TODO add your handling code here:
        dashboardMahasiswaMenu dshMahasiswa = new dashboardMahasiswaMenu();
        dshMahasiswa.setVisible(true);
        dshMahasiswa.pack();
        dshMahasiswa.setLocationRelativeTo(null);
        dshMahasiswa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnDashboardMahasiswaMenuMouseClicked

    private void btnDashboardHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardHomeMouseClicked
        // TODO add your handling code here:
        dashboardAdmin dshAdmin = new dashboardAdmin();
        dshAdmin.setVisible(true);
        dshAdmin.pack();
        dshAdmin.setLocationRelativeTo(null);
        dshAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnDashboardHomeMouseClicked

    private void btnRuangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRuangMouseClicked
        // TODO add your handling code here:
        dashboardRuangMenu dshru = new dashboardRuangMenu();
        dshru.setVisible(true);
        dshru.pack();
        dshru.setLocationRelativeTo(null);
        dshru.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnRuangMouseClicked

    private void btnMataKuliahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMataKuliahMouseClicked
        // TODO add your handling code here:
        dashboardMataKuliah dshmatkul = new dashboardMataKuliah();
        dshmatkul.setVisible(true);
        dshmatkul.pack();
        dshmatkul.setLocationRelativeTo(null);
        dshmatkul.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnMataKuliahMouseClicked

    private void btnProgramStudiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProgramStudiMouseClicked
        // TODO add your handling code here:
        dashboardProgramStudiMenu dshprodi = new dashboardProgramStudiMenu();
        dshprodi.setVisible(true);
        dshprodi.pack();
        dshprodi.setLocationRelativeTo(null);
        dshprodi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnProgramStudiMouseClicked

    private void btnJurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnJurusanMouseClicked
        // TODO add your handling code here:
        dashboardJurusanMenu dshjur = new dashboardJurusanMenu();
        dshjur.setVisible(true);
        dshjur.pack();
        dshjur.setLocationRelativeTo(null);
        dshjur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnJurusanMouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void frameDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameDragMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_frameDragMouseDragged

    private void frameDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameDragMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_frameDragMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashboardLainnyaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardLainnyaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardLainnyaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardLainnyaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardLainnyaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnDashboardAdminMenu;
    private javax.swing.JLabel btnDashboardDosenMenu;
    private javax.swing.JLabel btnDashboardHome;
    private javax.swing.JLabel btnDashboardMahasiswaMenu;
    private javax.swing.JLabel btnDashboardPerkuliahanMenu;
    private javax.swing.JLabel btnJurusan;
    private javax.swing.JLabel btnMataKuliah;
    private javax.swing.JLabel btnProgramStudi;
    private javax.swing.JLabel btnRuang;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel frameDrag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    // End of variables declaration//GEN-END:variables
}
