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
public class databaseRuang extends javax.swing.JFrame {
int xMouse;
int yMouse;
    /**
     * Creates new form databaseDosen
     */
    public databaseRuang() {
        initComponents();
        this.setLocationRelativeTo(null);
        refresh();
    }
private void ambilData() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("NO");
        tbl.addColumn("ID RUANG");
        tbl.addColumn("RUANG");
        table_jurusan.setModel(tbl);
        try{
            Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from ruang");
            int index = 1;
            while (res.next())
            {
                tbl.addRow(new Object []{
                    index,
                    res.getString("id_ruang"),
                    res.getString("ruang"),
                });
                table_jurusan.setModel(tbl);
                index++;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
        }
    }
    
    private void refresh()
    {
        txtidruang.setText("");
        txtruang.setText("");
        txtidruang.requestFocus();
        
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

        btnCreate = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnlogout = new javax.swing.JLabel();
        btnDashboardAdminMenu = new javax.swing.JLabel();
        btnDashboardPerkuliahanMenu = new javax.swing.JLabel();
        btnDashboardDosenMenu = new javax.swing.JLabel();
        btnDashboardMahasiswaMenu = new javax.swing.JLabel();
        btnDashboardHome = new javax.swing.JLabel();
        txtidruang = new javax.swing.JTextField();
        txtruang = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_jurusan = new javax.swing.JTable();
        frameDrag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateMouseClicked(evt);
            }
        });
        getContentPane().add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 70, 20));

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

        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });
        getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 70, 20));

        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 70, 20));

        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 70, 30));

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

        txtidruang.setBackground(new java.awt.Color(166, 166, 166));
        txtidruang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtidruang.setForeground(new java.awt.Color(255, 255, 255));
        txtidruang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtidruang.setBorder(null);
        getContentPane().add(txtidruang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 340, 220, 20));

        txtruang.setBackground(new java.awt.Color(166, 166, 166));
        txtruang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtruang.setForeground(new java.awt.Color(255, 255, 255));
        txtruang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtruang.setBorder(null);
        getContentPane().add(txtruang, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 230, 20));

        table_jurusan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_jurusan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_jurusanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_jurusan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 480, 200));

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/DATABASE RUANG.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_jurusanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_jurusanMouseClicked
        // TODO add your handling code here:
        int i = table_jurusan.getSelectedRow();
        if (i == -1){
            return;
        }
        String id_ruang = (String) table_jurusan.getValueAt(i, 1);
        txtidruang.setText(id_ruang);
        String ruang = (String) table_jurusan.getValueAt(i, 2);
        txtruang.setText(ruang);
    }//GEN-LAST:event_table_jurusanMouseClicked

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

    private void btnCreateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCreateMouseClicked
        // TODO add your handling code here:
        if(txtidruang.getText().equals("")){
            JOptionPane.showMessageDialog(null,
                "Silahkan refresh terlebih dahulu!");
        }
        else{
            String id_ruang = txtidruang.getText();
            String ruang = txtruang.getText();
            

            try{
                Statement statement = (Statement) koneksi.getConnection().createStatement();
                statement.executeUpdate("insert into ruang VALUES (null,'" + ruang +"')");
                statement.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");

                refresh();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan: " + e.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnCreateMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        if(txtidruang.getText().equals("")){
            JOptionPane.showMessageDialog(null,
                "Silahkan pilih terlebih dahulu data yang akan dihapus!");
        }
        else{
            String id = txtidruang.getText();

            try{
                Statement statement = (Statement) koneksi.getConnection().createStatement();
                statement.executeUpdate("delete from ruang where id_ruang = '" + id + "'");
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");

                refresh();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data Gagal di Hapus: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        if(txtidruang.getText().equals("")){
            JOptionPane.showMessageDialog(null,
                "Silahkan pilih terlebih dahulu data yang akan  diupdate!");
        }
        else{
            String id_ruang = txtidruang.getText();
            String ruang = txtruang.getText();
           
            
            try{
                Statement statement = (Statement) koneksi.getConnection().createStatement();
                statement.executeUpdate("update ruang SET id_ruang='"+id_ruang+"'," + "ruang='"+ruang+"'");
                statement.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah");

                refresh();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data Gagal diubah: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

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
            java.util.logging.Logger.getLogger(databaseRuang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(databaseRuang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(databaseRuang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(databaseRuang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new databaseRuang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCreate;
    private javax.swing.JLabel btnDashboardAdminMenu;
    private javax.swing.JLabel btnDashboardDosenMenu;
    private javax.swing.JLabel btnDashboardHome;
    private javax.swing.JLabel btnDashboardMahasiswaMenu;
    private javax.swing.JLabel btnDashboardPerkuliahanMenu;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnRefresh;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel frameDrag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_jurusan;
    private javax.swing.JTextField txtidruang;
    private javax.swing.JTextField txtruang;
    // End of variables declaration//GEN-END:variables
}