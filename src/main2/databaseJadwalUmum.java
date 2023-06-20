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
public class databaseJadwalUmum extends javax.swing.JFrame {
int xMouse;
int yMouse;
    /**
     * Creates new form databaseDosen
     */
    public databaseJadwalUmum() {
        initComponents();
        this.setLocationRelativeTo(null);
        refresh();
        txtid.setVisible(false);
        tampil_combo_nama_dosen();
        tampil_combo_golongan();
        tampil_combo_mata_kuliah();
        tampil_combo_id_jam_pelajaran();
        tampil_combo_ruang();
        tampil_combo_hari();
    }
private void ambilData() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("NO");
        tbl.addColumn("ID JADWAL");
        tbl.addColumn("DOSEN");
        tbl.addColumn("GOLONGAN");
        tbl.addColumn("MATA KULIAH");
        tbl.addColumn("ID JAM PELAJARAN");
        tbl.addColumn("RUANG");
        tbl.addColumn("HARI");
        table_jadwal.setModel(tbl);
        try{
            Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from jadwal");
            int index = 1;
            while (res.next())
            {
                tbl.addRow(new Object []{
                    index,
                    res.getString("id_jadwal"),
                    res.getString("nama"),
                    res.getString("golongan"),
                    res.getString("mata_kuliah"),
                    res.getString("id_jam_pelajaran"),
                    res.getString("ruang"),
                    res.getString("hari"),
                });
                table_jadwal.setModel(tbl);
                index++;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
        }
    }
    
    private void refresh()
    {
        txtid.setText("");
        cmbnama.setSelectedItem("");
        cmbgolongan.setSelectedItem("");
        cmbmatakuliah.setSelectedItem("");
        cmbidpelajaran.setSelectedItem("");
        cmbruang.setSelectedItem("");
        cmbhari.setSelectedItem("");
        cmbnama.requestFocus();
        
        ambilData();
    }
    public void tampil_combo_nama_dosen(){
       try{
           
           Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from dosen");
           
           while(res.next()){
               cmbnama.addItem(res.getString("nama"));
               
           }
           
           res.last();
           int jumlahdata = res.getRow();
           res.first();
           
       }catch(Exception e){
           
       }
   }
    public void tampil_combo_golongan(){
       try{
           
           Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from golongan");
           
           while(res.next()){
               cmbgolongan.addItem(res.getString("golongan"));
               
           }
           
           res.last();
           int jumlahdata = res.getRow();
           res.first();
           
       }catch(Exception e){
           
       }
   }
    
    public void tampil_combo_mata_kuliah(){
       try{
           
           Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from mata_kuliah");
           
           while(res.next()){
               cmbmatakuliah.addItem(res.getString("mata_kuliah"));
               
           }
           
           res.last();
           int jumlahdata = res.getRow();
           res.first();
           
       }catch(Exception e){
           
       }
   }
    public void tampil_combo_id_jam_pelajaran(){
       try{
           
           Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from jam_pelajaran");
           
           while(res.next()){
               cmbidpelajaran.addItem(res.getString("id_jam_pelajaran"));
               
           }
           
           res.last();
           int jumlahdata = res.getRow();
           res.first();
           
       }catch(Exception e){
           
       }
   }
    public void tampil_combo_ruang(){
       try{
           
           Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from ruang");
           
           while(res.next()){
               cmbruang.addItem(res.getString("ruang"));
               
           }
           
           res.last();
           int jumlahdata = res.getRow();
           res.first();
           
       }catch(Exception e){
           
       }
   }
    public void tampil_combo_hari(){
       try{
           
           Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from hari");
           
           while(res.next()){
               cmbhari.addItem(res.getString("hari"));
               
           }
           
           res.last();
           int jumlahdata = res.getRow();
           res.first();
           
       }catch(Exception e){
           
       }
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
        btnCreate = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnlogout = new javax.swing.JLabel();
        btnDashboardAdminMenu = new javax.swing.JLabel();
        btnDashboardPerkuliahanMenu = new javax.swing.JLabel();
        btnDashboardDosenMenu = new javax.swing.JLabel();
        btnDashboardMahasiswaMenu = new javax.swing.JLabel();
        btnDashboardHome = new javax.swing.JLabel();
        cmbhari = new javax.swing.JComboBox<>();
        cmbruang = new javax.swing.JComboBox<>();
        cmbidpelajaran = new javax.swing.JComboBox<>();
        cmbmatakuliah = new javax.swing.JComboBox<>();
        cmbgolongan = new javax.swing.JComboBox<>();
        cmbnama = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_jadwal = new javax.swing.JTable();
        frameDrag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
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

        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateMouseClicked(evt);
            }
        });
        getContentPane().add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 70, 20));

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
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 140, 80, 30));

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

        cmbhari.setBorder(null);
        getContentPane().add(cmbhari, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 230, 30));

        cmbruang.setBorder(null);
        getContentPane().add(cmbruang, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 410, 230, 30));

        cmbidpelajaran.setBorder(null);
        getContentPane().add(cmbidpelajaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 340, 230, 30));

        cmbmatakuliah.setBorder(null);
        getContentPane().add(cmbmatakuliah, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 480, 230, 30));

        cmbgolongan.setBorder(null);
        getContentPane().add(cmbgolongan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 410, 230, 30));

        cmbnama.setBorder(null);
        getContentPane().add(cmbnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 230, 30));

        table_jadwal.setModel(new javax.swing.table.DefaultTableModel(
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
        table_jadwal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_jadwalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_jadwal);

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database jadwal umum.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 50, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_jadwalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_jadwalMouseClicked
        // TODO add your handling code here:
        int i = table_jadwal.getSelectedRow();
        if (i == -1){
            return;
        }
        String id_jadwal = (String) table_jadwal.getValueAt(i, 1);
        txtid.setText(id_jadwal);
        String nama = (String) table_jadwal.getValueAt(i, 2);
        cmbnama.setSelectedItem(nama);
        String golongan = (String) table_jadwal.getValueAt(i, 3);
        cmbgolongan.setSelectedItem(golongan);
        String mata_kuliah = (String) table_jadwal.getValueAt(i, 4);
        cmbmatakuliah.setSelectedItem(mata_kuliah);
        String id_jam_pelajaran = (String) table_jadwal.getValueAt(i, 5);
        cmbidpelajaran.setSelectedItem(id_jam_pelajaran);
        String ruang = (String) table_jadwal.getValueAt(i, 6);
        cmbruang.setSelectedItem(ruang);
        String hari = (String) table_jadwal.getValueAt(i, 7);
        cmbhari.setSelectedItem(hari);
    }//GEN-LAST:event_table_jadwalMouseClicked

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
        if(cmbnama.getSelectedItem().equals("")){
            JOptionPane.showMessageDialog(null,
                "Silahkan refresh terlebih dahulu!");
        }
        else{
            String id_jadwal = txtid.getText();
            String nama =  (String)cmbnama.getSelectedItem();
            String golongan = (String)cmbgolongan.getSelectedItem();
            String mata_kuliah = (String) cmbmatakuliah.getSelectedItem();
            String id_jam_pelajaran = (String)cmbidpelajaran.getSelectedItem();
            String ruang = (String) cmbruang.getSelectedItem();
            String hari = (String) cmbhari.getSelectedItem();
            
            try{
                Statement statement = (Statement) koneksi.getConnection().createStatement();
                statement.executeUpdate("insert into jadwal VALUES (null, '" + nama + "','"
                    + golongan +"','"+ mata_kuliah +"','"+ id_jam_pelajaran +"','"+ ruang +"','"+ hari +"')");
                statement.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");

                refresh();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan: " + e.getMessage());
            }
        }
        tampil_combo_nama_dosen();
        tampil_combo_golongan();
        tampil_combo_mata_kuliah();
        tampil_combo_id_jam_pelajaran();
        tampil_combo_ruang();
        tampil_combo_hari();
    }//GEN-LAST:event_btnCreateMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        if(txtid.getText().equals("")){
            JOptionPane.showMessageDialog(null,
                "Silahkan pilih terlebih dahulu data yang akan dihapus!");
        }
        else{
            String id = txtid.getText();

            try{
                Statement statement = (Statement) koneksi.getConnection().createStatement();
                statement.executeUpdate("delete from jadwal where id_jadwal = '" + id + "'");
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");

                refresh();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data Gagal di Hapus: " + e.getMessage());
            }
        }
        tampil_combo_nama_dosen();
        tampil_combo_golongan();
        tampil_combo_mata_kuliah();
        tampil_combo_id_jam_pelajaran();
        tampil_combo_ruang();
        tampil_combo_hari();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        if(txtid.getText().equals("")){
            JOptionPane.showMessageDialog(null,
                "Silahkan pilih terlebih dahulu data yang akan  diupdate!");
        }
        else{
            String id_jadwal = txtid.getText();
            String nama =  (String)cmbnama.getSelectedItem();
            String golongan = (String)cmbgolongan.getSelectedItem();
            String mata_kuliah = (String) cmbmatakuliah.getSelectedItem();
            String id_jam_pelajaran = (String)cmbidpelajaran.getSelectedItem();
            String ruang = (String) cmbruang.getSelectedItem();
            String hari = (String) cmbhari.getSelectedItem();
            try{
                Statement statement = (Statement) koneksi.getConnection().createStatement();
                statement.executeUpdate("update jadwal SET nama='"+nama+"'," + "golongan='"+golongan+"',"
                    + "mata_kuliah='"+mata_kuliah+"',"
                    +"id_jam_pelajaran='"+id_jam_pelajaran+"',"
                    + "ruang='"+ruang+"',"
                    + "hari='"+hari+"',"  + "WHERE id_jadwal = '"+id_jadwal+"'");
                statement.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah");

                refresh();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data Gagal diubah: " + e.getMessage());
            }
        }
        tampil_combo_nama_dosen();
        tampil_combo_golongan();
        tampil_combo_mata_kuliah();
        tampil_combo_id_jam_pelajaran();
        tampil_combo_ruang();
        tampil_combo_hari();
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
            java.util.logging.Logger.getLogger(databaseJadwalUmum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(databaseJadwalUmum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(databaseJadwalUmum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(databaseJadwalUmum.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new databaseJadwalUmum().setVisible(true);
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
    private javax.swing.JComboBox<String> cmbgolongan;
    private javax.swing.JComboBox<String> cmbhari;
    private javax.swing.JComboBox<String> cmbidpelajaran;
    private javax.swing.JComboBox<String> cmbmatakuliah;
    private javax.swing.JComboBox<String> cmbnama;
    private javax.swing.JComboBox<String> cmbruang;
    private javax.swing.JLabel frameDrag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_jadwal;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
