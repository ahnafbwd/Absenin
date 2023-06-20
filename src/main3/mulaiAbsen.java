package main3;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.Result;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import javax.swing.JFrame;
import java.sql.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import main1.loginDosen;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.chainsaw.Main;

public class mulaiAbsen extends javax.swing.JFrame implements Runnable, ThreadFactory{
private WebcamPanel panel = null;
    private Webcam webcam = null;
  
    private static final long serialVersionUID = 6441489157408381878L;
    private Executor executor = Executors.newSingleThreadExecutor(this);
    
    DefaultTableModel tabModel;
    ResultSet Rsnim=null;
    int xMouse;
int yMouse;
    public mulaiAbsen() {
        super();
        initComponents();
        initWebcam();
        this.setLocationRelativeTo(null);
        tampilData();
        ambilData();
        tampil_combo_id_jadwal();
        tampil_combo_nama_dosen();
        tampil_combo_jam_pelajaran();
        jTextField1.requestFocus();;
    }
private void tampilData(){
        try{
            Object[] judul_kolom = {"NIM", "NAMA"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            tabel_nim.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.getConnection();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            Rsnim=stt.executeQuery("SELECT * from mahasiswa ");  
            while(Rsnim.next()){
                Object[] data={
                    Rsnim.getString("nim"),
                    Rsnim.getString("nama"),         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    private void cariData(String key){
        try{
            Object[] judul_kolom = {"NIM", "NAMA"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            tabel_nim.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.getConnection();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            Rsnim=stt.executeQuery("SELECT * from mahasiswa WHERE nim LIKE '%"+key+"%'");  
            while(Rsnim.next()){
                Object[] data={
                    Rsnim.getString("nim"),
                    Rsnim.getString("nama"),         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
    }
    private void ambilData() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("NIM");
        tbl.addColumn("NAMA");
        tabel_nim.setModel(tbl);
        try{
            com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from mahasiswa");
            int index = 1;
            while (res.next())
            {
                tbl.addRow(new Object []{
                    index,
                    res.getString("nim"),
                    res.getString("nama"),
                    
                });
                tabel_nim.setModel(tbl);
                index++;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
        }
    }
        public void tampil_combo_id_jadwal(){
       try{
           
           com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from jadwal");
           
           while(res.next()){
               cmbidjadwal.addItem(res.getString("id_jadwal"));
               
           }
           
           res.last();
           int jumlahdata = res.getRow();
           res.first();
           
       }catch(Exception e){
           
       }
   }
          public void tampil_combo_nama_dosen(){
       try{
           
           com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from dosen");
           
           while(res.next()){
               cmbdosen.addItem(res.getString("nama"));
               
           }
           
           res.last();
           int jumlahdata = res.getRow();
           res.first();
           
       }catch(Exception e){
           
       }
   }
          
     public void tampil_combo_jam_pelajaran(){
       try{
           
           com.mysql.jdbc.Statement statement = (com.mysql.jdbc.Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from jam_pelajaran");
           
           while(res.next()){
               cmbjampelajaran.addItem(res.getString("id_jam_pelajaran"));
               
           }
           
           res.last();
           int jumlahdata = res.getRow();
           res.first();
           
       }catch(Exception e){
           
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JLabel();
        jLabelClose = new javax.swing.JLabel();
        jLabelMin = new javax.swing.JLabel();
        txtketerangan = new javax.swing.JTextField();
        cmbidjadwal = new javax.swing.JComboBox<>();
        cmbjampelajaran = new javax.swing.JComboBox<>();
        cmbdosen = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_nim = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_absensi = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btntambah = new javax.swing.JLabel();
        cmbstatus = new javax.swing.JComboBox<>();
        frameDrag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtidpresensi = new javax.swing.JTextField();
        txtisiannim = new javax.swing.JTextField();
        txtisiannama = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 160, -1));

        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 30));

        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 20));

        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, 20));

        btnsimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsimpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsimpanMouseClicked(evt);
            }
        });
        getContentPane().add(btnsimpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 100, 40));

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
        getContentPane().add(txtketerangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 180, 80));

        cmbidjadwal.setBorder(null);
        getContentPane().add(cmbidjadwal, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, 160, -1));

        cmbjampelajaran.setBorder(null);
        getContentPane().add(cmbjampelajaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 160, -1));

        cmbdosen.setBorder(null);
        getContentPane().add(cmbdosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 160, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ID JADWAL");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, -1, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("NAMA DOSEN");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, -1, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TANGGAL");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, -1, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("JAM PELAJARAN");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("KETERANGAN");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, 20));

        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 220, -1));

        tabel_nim.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_nim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_nimMouseClicked(evt);
            }
        });
        tabel_nim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabel_nimKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_nim);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 360, 220, 50));

        tabel_absensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PRESENSI", "IDJADWAL", "DOSEN", "NIM", "NAMA", "STATUS", "TANGGAL", "KETERANGAN", "JAM PELAJARAN"
            }
        ));
        tabel_absensi.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                tabel_absensiComponentAdded(evt);
            }
        });
        tabel_absensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_absensiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_absensi);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 510, 130));

        jPanel2.setMaximumSize(new java.awt.Dimension(200, 200));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 240, 210));

        btntambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btntambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btntambahMouseClicked(evt);
            }
        });
        getContentPane().add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 330, 80, 20));

        cmbstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "hadir", "alpha", "sakit", "ijin" }));
        cmbstatus.setBorder(null);
        getContentPane().add(cmbstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, 90, 30));

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/MULAI ABSENSI (1).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));
        getContentPane().add(txtidpresensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));
        getContentPane().add(txtisiannim, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 120, -1));
        getContentPane().add(txtisiannama, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 120, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
         String key=jTextField1.getText();
         int i = tabel_nim.getSelectedRow();
        System.out.println(key);  
        
        if(key!=""){
            cariData(key);
        }else{
            tampilData();
        }
        
        
        if (i == -1){
            return;
        }
        String nim = (String) tabel_nim.getValueAt(i, 0);
        txtisiannim.setText(nim);
        String nama = (String) tabel_nim.getValueAt(i, 1);
        txtisiannama.setText(nama);
    }//GEN-LAST:event_jTextField1KeyReleased

    private void tabel_nimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_nimMouseClicked
        // TODO add your handling code here:
        int i = tabel_nim.getSelectedRow();
        if (i == -1){
            return;
        }
        String nim = (String) tabel_nim.getValueAt(i, 0);
        txtisiannim.setText(nim);
        String nama = (String) tabel_nim.getValueAt(i, 1);
        txtisiannama.setText(nama);
    }//GEN-LAST:event_tabel_nimMouseClicked

    private void btnsimpanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsimpanMouseClicked
        DefaultTableModel tblModel = (DefaultTableModel) tabel_absensi.getModel();
        if((txtidpresensi.getText().equals(""))&&(tblModel.getRowCount()==-1)){
            JOptionPane.showMessageDialog(null,
                "Silahkan refresh terlebih dahulu!");
        }
        else{
            String id_presensi,id_jadwal,nama,nim,nama_mahasiswa,status,keterangan,id_jam_pelajaran;
            
            String tanggal ;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://Localhost/absenn","root","");
                for(int i=0;i<tblModel.getRowCount();i++){
                        id_presensi      = tblModel.getValueAt(i, 0).toString();
                        id_jadwal        = tblModel.getValueAt(i, 1).toString();
                        nama             = tblModel.getValueAt(i, 2).toString();
                        nim              = tblModel.getValueAt(i, 3).toString();
                        nama_mahasiswa   = tblModel.getValueAt(i, 4).toString();
                        status           = tblModel.getValueAt(i, 5).toString();
                        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
                        tanggal          = dateformat.format(jDateChooser1.getDate());
                        tanggal          =tblModel.getValueAt(i, 6).toString();
                        keterangan       = tblModel.getValueAt(i, 7).toString();
                        id_jam_pelajaran = tblModel.getValueAt(i, 8).toString();
                        
                        String query="INSERT INTO presensi (id_presensi, id_jadwal, nama, nim, nama_mahasiswa, status, tanggal, keterangan, id_jam_pelajaran)VALUES (?,?,?,?,?,?,?,?,?)";
                        
                        PreparedStatement pstmt = con.prepareStatement(query);
                        pstmt.setString(1,null);
                        pstmt.setString(2,id_jadwal);
                        pstmt.setString(3,nama);
                        pstmt.setString(4,nim);
                        pstmt.setString(5,nama_mahasiswa);
                        pstmt.setString(6,status);
                        pstmt.setString(7,tanggal);
                        pstmt.setString(8,keterangan);
                        pstmt.setString(9,id_jam_pelajaran);
                        
                        pstmt.execute();
                }
                
                JOptionPane.showMessageDialog(this, "Data berhasil Disimpan");
                
                tblModel.setRowCount(0);
            } catch (Exception e) {
                
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan: " + e.getMessage());
            }
        }
        
        tampil_combo_id_jadwal();
        tampil_combo_nama_dosen();
        tampil_combo_jam_pelajaran();
    }//GEN-LAST:event_btnsimpanMouseClicked

    private void tabel_absensiComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_tabel_absensiComponentAdded
       
    }//GEN-LAST:event_tabel_absensiComponentAdded

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        dashboardDosen dashboardDosen = new dashboardDosen();
        dashboardDosen.setVisible(true);
        dashboardDosen.pack();
        dashboardDosen.setLocationRelativeTo(null);
        dashboardDosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        webcam.close();
        this.dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        dashboardPresensi dashboardDosen = new dashboardPresensi();
        dashboardDosen.setVisible(true);
        dashboardDosen.pack();
        dashboardDosen.setLocationRelativeTo(null);
        dashboardDosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        webcam.close();
        this.dispose();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        loginDosen dashboardDosen = new loginDosen();
        dashboardDosen.setVisible(true);
        dashboardDosen.pack();
        dashboardDosen.setLocationRelativeTo(null);
        dashboardDosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        webcam.close();
        this.dispose();
    }//GEN-LAST:event_jLabel9MouseClicked

    private void tabel_absensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_absensiMouseClicked
        // TODO add your handling code here:
        int i = tabel_nim.getSelectedRow();
        if (i == -1){
            return;
        }
        String id_presensi = (String) tabel_nim.getValueAt(i, 0);
        txtidpresensi.setText(id_presensi);
        String id_jadwal = (String) tabel_nim.getValueAt(i, 1);
        cmbidjadwal.setSelectedItem(id_jadwal);
        String dosen = (String) tabel_nim.getValueAt(i, 2);
        cmbdosen.setSelectedItem(dosen);
        String nim = (String) tabel_nim.getValueAt(i, 3);
        txtisiannim.setText(nim);
        String mahasiswa = (String) tabel_nim.getValueAt(i, 4);
        txtisiannama.setText(mahasiswa);
        String status = (String) tabel_nim.getValueAt(i, 5);
        cmbstatus.setSelectedItem(status);
        String tanggal = (String) tabel_nim.getValueAt(i, 6);
        jDateChooser1.setDateFormatString(tanggal);
        String keterangan = (String) tabel_nim.getValueAt(i, 7);
        txtketerangan.setText(keterangan);
        String id_jadwal_pelajaran = (String) tabel_nim.getValueAt(i, 8);
        cmbjampelajaran.setSelectedItem(id_jadwal_pelajaran);
    }//GEN-LAST:event_tabel_absensiMouseClicked

    private void btntambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntambahMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)tabel_absensi.getModel();
        model.addRow(new Object[]{txtidpresensi.getText(),cmbidjadwal.getSelectedItem(),cmbdosen.getSelectedItem(),txtisiannim.getText(),txtisiannama.getText(),cmbstatus.getSelectedItem(),jDateChooser1.getDate(),txtketerangan.getText(),cmbjampelajaran.getSelectedItem()});
    }//GEN-LAST:event_btntambahMouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
       if(evt.getKeyCode() == KeyEvent.VK_ENTER){ 
       tabel_absensi.getSelectedColumn();
       
         DefaultTableModel model = (DefaultTableModel)tabel_absensi.getModel();
        model.addRow(new Object[]{txtidpresensi.getText(),cmbidjadwal.getSelectedItem(),cmbdosen.getSelectedItem(),txtisiannim.getText(),txtisiannama.getText(),cmbstatus.getSelectedItem(),jDateChooser1.getDate(),txtketerangan.getText(),cmbjampelajaran.getSelectedItem()});
    }
        if(evt.getKeyCode() == KeyEvent.VK_UP) {
       int o = tabel_nim.getSelectedColumnCount();
        if (o == -1){
            return;
        }
        String nim = (String) tabel_nim.getValueAt(o, 0);
        txtisiannim.setText(nim);
        String nama = (String) tabel_nim.getValueAt(o, 1);
        txtisiannama.setText(nama);
        }
        if(evt.getKeyCode() == KeyEvent.VK_DOWN) {
       int i = tabel_nim.getSelectedColumnCount();
        if (i == -1){
            return;
        }
        String nim = (String) tabel_nim.getValueAt(i, 0);
        txtisiannim.setText(nim);
        String nama = (String) tabel_nim.getValueAt(i, 1);
        txtisiannama.setText(nama);
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void frameDragMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameDragMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();

        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_frameDragMouseDragged

    private void frameDragMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frameDragMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_frameDragMousePressed

    private void tabel_nimKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabel_nimKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tabel_nimKeyPressed

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
            java.util.logging.Logger.getLogger(mulaiAbsen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mulaiAbsen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mulaiAbsen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mulaiAbsen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        BasicConfigurator.configure();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mulaiAbsen().setVisible(true);
                BasicConfigurator.configure();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnsimpan;
    private javax.swing.JLabel btntambah;
    private javax.swing.JComboBox<String> cmbdosen;
    private javax.swing.JComboBox<String> cmbidjadwal;
    private javax.swing.JComboBox<String> cmbjampelajaran;
    private javax.swing.JComboBox<String> cmbstatus;
    private javax.swing.JLabel frameDrag;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tabel_absensi;
    private javax.swing.JTable tabel_nim;
    private javax.swing.JTextField txtidpresensi;
    private javax.swing.JTextField txtisiannama;
    private javax.swing.JTextField txtisiannim;
    private javax.swing.JTextField txtketerangan;
    // End of variables declaration//GEN-END:variables
  
    private void initWebcam() {
        Dimension size = WebcamResolution.QVGA.getSize();
   webcam = Webcam.getWebcams().get(0); //0 adalah default webcam
   webcam.setViewSize(size);
   
   panel = new WebcamPanel(webcam);
   panel.setPreferredSize(size);
   panel.setFPSDisplayed(true);
   
   jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0,240, 240));
   
   executor.execute(this);
    }
  
    @Override
    public void run() {
        do { 
        try {
        Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        
        Result result = null;
        BufferedImage image = null;
        
        if(webcam.isOpen()){
            if((image = webcam.getImage()) == null){
                continue;
                 }
        
        
        LuminanceSource source = new BufferedImageLuminanceSource(image);
        BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
         Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();
         hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
        try {
            result = new MultiFormatReader().decode(bitmap);
            
        } catch (NotFoundException e){
            //NO result...
        }
        if (result !=null) {
            jTextField1.setText(result.getText());
        }
        }
       }while (true); 
    } 
        

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r, "example-runner");
        t.setDaemon(true);
        return t;
    }//To change body of generated methods, choose Tools | Templates.
    

}
