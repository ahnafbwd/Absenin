/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main3;

import static com.microsoft.schemas.office.excel.STObjectType.Enum.table;
import main2.*;
import com.mysql.jdbc.Statement;
import java.awt.Color;
import java.awt.Component;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
import main1.loginAdmin;
import main1.loginDosen;
import java.awt.Desktop;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

/**
 *
 * @author USER
 */
public class databasePresensi extends javax.swing.JFrame {
    int xMouse;
    int yMouse;    
  
    JasperReport JasRep;
    JasperPrint JasPrn;
    JasperDesign JasDsgn;
    private Object string;
    /**
     * Creates new form dashboardDosenMenu
     */
    public databasePresensi() {
        initComponents();
        refresh();
        this.setLocationRelativeTo(null);
        ambilData();
         theader();
    }
    private void theader(){
        
        JTableHeader tabelHeader = table_presensi.getTableHeader();
        tabelHeader.setBackground(Color.YELLOW);
        tabelHeader.setForeground(Color.BLACK);
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
        table_presensi.getTableHeader().setOpaque(false);
        table_presensi.getTableHeader().setBackground(Color.BLACK);
        table_presensi.getTableHeader().setForeground(Color.WHITE);
        theader();
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
                table_presensi.getTableHeader().setOpaque(false);
                table_presensi.getTableHeader().setBackground(Color.BLACK);
                table_presensi.getTableHeader().setForeground(Color.WHITE);
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
        btnCari = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_presensi = new javax.swing.JTable();
        btndashboardDosen = new javax.swing.JLabel();
        btnPresensi = new javax.swing.JLabel();
        btnlogout = new javax.swing.JLabel();
        btnprint = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        frameDrag = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        table_presensi.setModel(new javax.swing.table.DefaultTableModel(
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 470, 410));

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

        btnprint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnprint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnprint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnprintMouseClicked(evt);
            }
        });
        getContentPane().add(btnprint, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 160, 70, 30));

        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 70, 20));

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

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/database presensi DOSENN.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCariMouseClicked
        // TODO add your handling code here:
        try{
            Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from presensi where "
                + "id_jadwal like'%" + txtCari.getText() + "%'OR nama like'%" + txtCari.getText() + "%'OR nama_mahasiswa like'%" + txtCari.getText() + "%'OR status like'%" + txtCari.getText() + "%'OR tanggal like'%" + txtCari.getText() + "%'OR nim like'%" + txtCari.getText() + "%'");
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
            
        table_presensi.getTableHeader().setOpaque(false);
        table_presensi.getTableHeader().setBackground(Color.BLACK);
        table_presensi.getTableHeader().setForeground(Color.WHITE);

            int index = 1;
            while (res.next()){
                tbl.addRow(new Object[]{
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
                
        table_presensi.getTableHeader().setOpaque(false);
        table_presensi.getTableHeader().setBackground(Color.BLACK);
        table_presensi.getTableHeader().setForeground(Color.WHITE);
                index++;
            }

        }catch (SQLException e){
            JOptionPane.showMessageDialog(rootPane, "Gagal mencari: " +
                    e.getMessage());
        }
    }//GEN-LAST:event_btnCariMouseClicked

    private void table_presensiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_presensiMouseClicked
        int i = table_presensi.getSelectedRow();
        if (i == -1){
            return;
        }
        String id_ruang = (String) table_presensi.getValueAt(i, 1);
        txtCari.setText(id_ruang);
        String ruang = (String) table_presensi.getValueAt(i, 2);
        txtCari.setText(ruang);
    }//GEN-LAST:event_table_presensiMouseClicked

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

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        dashboardPresensi Dosen = new dashboardPresensi();
        Dosen.setVisible(true);
        Dosen.pack();
        Dosen.setLocationRelativeTo(null);
        Dosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabelCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCloseMouseClicked

        System.exit(0);
    }//GEN-LAST:event_jLabelCloseMouseClicked

    private void jLabelMinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelMinMouseClicked

        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabelMinMouseClicked

    private void btnprintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprintMouseClicked
    String jdbc_driver = "com.mysql.jdbc.Driver";
    String user = "root";
    String pass = "";
    String url = "jdbc:mysql://localhost:3306/absenn";
    File reportFile = new File(".");
    String dirr = "";
    
        try {
            Class.forName(jdbc_driver);
            Connection con = (Connection)DriverManager.getConnection(url,user,
                    pass);
           
            Statement stat = (Statement) koneksi.getConnection().createStatement();
            String sql = "SELECT * FROM presensi";
            dirr = reportFile.getCanonicalFile() + "/src/laporan/";
            JasperDesign design = JRXmlLoader.load(dirr + "laporan.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(design);
            ResultSet rs = stat.executeQuery(sql);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(rs);
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(),
                    rsDataSource);
            JasperViewer.viewReport(jp);
        } catch (ClassNotFoundException | SQLException | IOException | 
                JRException ex ) {
            JOptionPane.showMessageDialog(null, "\nGagal Mencetak\n" + ex, 
                    "Kesalahan", JOptionPane.ERROR_MESSAGE);
        } 
            
      
        
    
    }//GEN-LAST:event_btnprintMouseClicked

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
            java.util.logging.Logger.getLogger(databasePresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(databasePresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(databasePresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(databasePresensi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                    new databasePresensi().setVisible(true);
                    
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCari;
    private javax.swing.JLabel btnPresensi;
    private javax.swing.JLabel btndashboardDosen;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JLabel btnprint;
    private javax.swing.JLabel frameDrag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_presensi;
    private javax.swing.JTextField txtCari;
    // End of variables declaration//GEN-END:variables
}