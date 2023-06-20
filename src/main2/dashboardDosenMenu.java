/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main2;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import main1.loginAdmin;

/**
 *
 * @author USER
 */
public class dashboardDosenMenu extends javax.swing.JFrame {
int xMouse;
int yMouse;
    /**
     * Creates new form dashboardDosenMenu
     */
    public dashboardDosenMenu() {
        initComponents();
        refresh();
        this.setLocationRelativeTo(null);
        ambilData();
    }
private void ambilData() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("NO");
        tbl.addColumn("ID");
        tbl.addColumn("NIP");
        tbl.addColumn("NAMA");
        tbl.addColumn("JENIS KELAMIN");
        tbl.addColumn("JABATAN");
        tbl.addColumn("JURUSAN");
        tbl.addColumn("MATA KULIAH");
        tbl.addColumn("USERNAME");
        tbl.addColumn("PASSWORD");
        table_dosen.setModel(tbl);
        try{
            Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from dosen");
            int index = 1;
            while (res.next())
            {
                tbl.addRow(new Object []{
                    index,
                    res.getString("id_dosen"),
                    res.getString("nip"),
                    res.getString("nama"),
                    res.getString("jenis_kelamin"),
                    res.getString("jabatan"),
                    res.getString("jurusan"),
                    res.getString("mata_kuliah"),
                    res.getString("username"),
                    res.getString("password"),
                });
                table_dosen.setModel(tbl);
                index++;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
        }
    }
    
    private void refresh()
    {
        txtCari.setText("");
        txtCari.requestFocus();
        
        ambilData();
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
        btnCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        btnPengaturanDatabaseMahasiswa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_dosen = new javax.swing.JTable();
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

        btnCari.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCari.setToolTipText("");
        btnCari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCariMouseClicked(evt);
            }
        });
        getContentPane().add(btnCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 70, 40, 40));

        txtCari.setBackground(new java.awt.Color(115, 115, 115));
        txtCari.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCari.setForeground(new java.awt.Color(255, 255, 255));
        txtCari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCari.setBorder(null);
        getContentPane().add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 470, 20));

        btnPengaturanDatabaseMahasiswa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPengaturanDatabaseMahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPengaturanDatabaseMahasiswaMouseClicked(evt);
            }
        });
        getContentPane().add(btnPengaturanDatabaseMahasiswa, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 50, 40));

        table_dosen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        table_dosen.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_dosen.setColumnSelectionAllowed(true);
        table_dosen.setGridColor(new java.awt.Color(255, 255, 255));
        table_dosen.setOpaque(false);
        table_dosen.setSelectionBackground(new java.awt.Color(153, 255, 255));
        table_dosen.setSelectionForeground(new java.awt.Color(153, 153, 153));
        table_dosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_dosenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_dosen);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 470, 410));

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/MAHASISWA UTAMA ADMIN.png"))); // NOI18N
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

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        // TODO add your handling code here:
        try{
            Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from dosen where "
                + "nip like'%" + txtCari.getText() + "%'OR nama like'%" + txtCari.getText() + "%'");
            DefaultTableModel tbl = new DefaultTableModel();
            tbl.addColumn("NO");
            tbl.addColumn("ID");
            tbl.addColumn("NIP");
            tbl.addColumn("NAMA");
            tbl.addColumn("JENIS KELAMIN");
            tbl.addColumn("JABATAN");
            tbl.addColumn("JURUSAN");
            tbl.addColumn("MATA KULIAH");
            tbl.addColumn("USERNAME");
            tbl.addColumn("PASSWORD");
            table_dosen.setModel(tbl);

            int index = 1;
            while (res.next()){
                tbl.addRow(new Object[]{
                    index,
                    res.getString("id_dosen"),
                    res.getString("nip"),
                    res.getString("nama"),
                    res.getString("jenis_kelamin"),
                    res.getString("jabatan"),
                    res.getString("jurusan"),
                    res.getString("mata_kuliah"),
                    res.getString("username"),
                    res.getString("password"),
                });
                table_dosen.setModel(tbl);
                index++;
            }

        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Gagal mencari: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCariMouseClicked

    private void btnPengaturanDatabaseMahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPengaturanDatabaseMahasiswaMouseClicked
        // TODO add your handling code here:
        databaseDosen databaseMahasiswa = new databaseDosen();
        databaseMahasiswa.setVisible(true);
        databaseMahasiswa.pack();
        databaseMahasiswa.setLocationRelativeTo(null);
        databaseMahasiswa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnPengaturanDatabaseMahasiswaMouseClicked

    private void table_dosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_dosenMouseClicked
        int i = table_dosen.getSelectedRow();
        if (i == -1){
            return;
        }
        String id_dosen = (String) table_dosen.getValueAt(i, 1);
        txtCari.setText(id_dosen);
        String nip = (String) table_dosen.getValueAt(i, 2);
        txtCari.setText(nip);
        String nama = (String) table_dosen.getValueAt(i, 3);
        txtCari.setText(nama);
        String jabatan = (String) table_dosen.getValueAt(i, 4);
        txtCari.setText(jabatan);
        String jenis_kelamin = (String) table_dosen.getValueAt(i, 5);
        txtCari.setText(jenis_kelamin);
        String jurusan = (String) table_dosen.getValueAt(i, 6);
        txtCari.setText(jurusan);
        String id_mata_kuliah = (String) table_dosen.getValueAt(i, 7);
        txtCari.setText(id_mata_kuliah);
        String username = (String) table_dosen.getValueAt(i, 8);
        txtCari.setText(username);
        String password = (String) table_dosen.getValueAt(i, 9);
        txtCari.setText(password);
    }//GEN-LAST:event_table_dosenMouseClicked

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
            java.util.logging.Logger.getLogger(dashboardDosenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardDosenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardDosenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardDosenMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardDosenMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCari;
    private javax.swing.JLabel btnDashboardAdminMenu;
    private javax.swing.JLabel btnDashboardDosenMenu;
    private javax.swing.JLabel btnDashboardHome;
    private javax.swing.JLabel btnDashboardMahasiswaMenu;
    private javax.swing.JLabel btnDashboardPerkuliahanMenu;
    private javax.swing.JLabel btnPengaturanDatabaseMahasiswa;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel frameDrag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_dosen;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}
