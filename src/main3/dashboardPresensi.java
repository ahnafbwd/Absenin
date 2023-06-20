/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main3;
import com.mysql.jdbc.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import main1.loginDosen;

/**
 *
 * @author USER
 */
public class dashboardPresensi extends javax.swing.JFrame {
int xMouse;
int yMouse;
    /**
     * Creates new form dashboardPresensi
     */
    public dashboardPresensi() {
        initComponents();
        this.setLocationRelativeTo(null);
        ambilData();
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
private void ambilData() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("NO");
        tbl.addColumn("ID PRESENSI");
        tbl.addColumn("ID JADWAL");
        tbl.addColumn("DOSEN");
        tbl.addColumn("NIM");
        tbl.addColumn("NAMA");
        tbl.addColumn("STATUS");
        tbl.addColumn("TANGGAL");
        tbl.addColumn("KETERANGAN");
        tbl.addColumn("ID JAM PELAJARAN");
        table_presensi.setModel(tbl);
        try{
            Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from presensi");
            int index = 1;
            while (res.next())
            {
                tbl.addRow(new Object []{
                    index,
                    res.getString("id_presensi"),
                    res.getString("id_jadwal"),
                    res.getString("nama"),
                    res.getString("nim"),
                    res.getString("nama_mahasiswa"),
                    res.getString("status"),
                    res.getString("tanggal"),
                    res.getString("keterangan"),
                    res.getString("id_jam_pelajaran"),
                });
                table_presensi.setModel(tbl);
                index++;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
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
        btndashboardDosen = new javax.swing.JLabel();
        btnPresensi = new javax.swing.JLabel();
        btnlogout = new javax.swing.JLabel();
        btnMulaiAbsen = new javax.swing.JLabel();
        btnPresensiMenu = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_presensi = new javax.swing.JTable();
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

        btndashboardDosen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btndashboardDosen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btndashboardDosen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btndashboardDosenMouseClicked(evt);
            }
        });
        getContentPane().add(btndashboardDosen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 150, 20));

        btnPresensi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPresensi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPresensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPresensiMouseClicked(evt);
            }
        });
        getContentPane().add(btnPresensi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 150, 20));

        btnlogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnlogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnlogoutMouseClicked(evt);
            }
        });
        getContentPane().add(btnlogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 150, 30));

        btnMulaiAbsen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnMulaiAbsen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMulaiAbsen.setText("MULAI ABSEN");
        btnMulaiAbsen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMulaiAbsen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMulaiAbsenMouseClicked(evt);
            }
        });
        getContentPane().add(btnMulaiAbsen, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 230, 100));

        btnPresensiMenu.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPresensiMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPresensiMenu.setText("DATABASE PRESENSI");
        btnPresensiMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPresensiMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPresensiMenuMouseClicked(evt);
            }
        });
        getContentPane().add(btnPresensiMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 230, 100));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 130, 20));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, 80, 20));

        table_presensi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID PRESENSI", "ID JADWAL", "DOSEN", "NIM", "MAHASISWA", "STATUS", "TANGGAL", "KETERANGAN", "ID JAM PELAJARAN"
            }
        ));
        table_presensi.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_presensi.setColumnSelectionAllowed(true);
        table_presensi.setGridColor(new java.awt.Color(255, 255, 255));
        table_presensi.setOpaque(false);
        table_presensi.setSelectionBackground(new java.awt.Color(153, 255, 255));
        table_presensi.setSelectionForeground(new java.awt.Color(153, 153, 153));
        table_presensi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_presensiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_presensi);
        table_presensi.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 470, 210));

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/PRESENSI MENU.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btndashboardDosenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndashboardDosenMouseClicked
        // TODO add your handling code here:
        dashboardDosen Dosen = new dashboardDosen();
        Dosen.setVisible(true);
        Dosen.pack();
        Dosen.setLocationRelativeTo(null);
        Dosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btndashboardDosenMouseClicked

    private void btnPresensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPresensiMouseClicked
        // TODO add your handling code here:
        dashboardPresensi Presensi = new dashboardPresensi();
        Presensi.setVisible(true);
        Presensi.pack();
        Presensi.setLocationRelativeTo(null);
        Presensi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnPresensiMouseClicked

    private void btnlogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlogoutMouseClicked
        // TODO add your handling code here:
        loginDosen Dosen = new loginDosen();
        Dosen.setVisible(true);
        Dosen.pack();
        Dosen.setLocationRelativeTo(null);
        Dosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnlogoutMouseClicked

    private void btnMulaiAbsenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMulaiAbsenMouseClicked
        // TODO add your handling code here:
        mulaiAbsen mulaiAbsen = new mulaiAbsen();
        mulaiAbsen.setVisible(true);
        mulaiAbsen.pack();
        mulaiAbsen.setLocationRelativeTo(null);
        mulaiAbsen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnMulaiAbsenMouseClicked

    private void btnPresensiMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPresensiMenuMouseClicked
        // TODO add your handling code here:
        databasePresensi Presensi = new databasePresensi();
        Presensi.setVisible(true);
        Presensi.pack();
        Presensi.setLocationRelativeTo(null);
        Presensi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_btnPresensiMenuMouseClicked

    private void table_presensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_presensiMouseClicked
        
    }//GEN-LAST:event_table_presensiMouseClicked

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
            java.util.logging.Logger.getLogger(dashboardPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardPresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashboardPresensi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnMulaiAbsen;
    private javax.swing.JLabel btnPresensi;
    private javax.swing.JLabel btnPresensiMenu;
    private javax.swing.JLabel btndashboardDosen;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel frameDrag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_presensi;
    // End of variables declaration//GEN-END:variables
}
