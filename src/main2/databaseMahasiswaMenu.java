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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.PrintJob;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.util.EnumMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.lang.String;
import main1.loginAdmin;
/**
 *
 * @author USER
 */
public class databaseMahasiswaMenu extends javax.swing.JFrame {
int xMouse;
int yMouse;
                String qrCodeData;
		String filePath = "(txtnim.getText()).png";
		String charset = "UTF-8"; // or "ISO-8859-1"
		File imageFile =null;
                String ID = "idmahasiswa()";
    /**
     * Creates new form databaseMahasiswaMenu
     */
    public databaseMahasiswaMenu() {
        initComponents();
        this.setLocationRelativeTo(null);
        refresh();
        txtid.setVisible(false);
        tampil_combo_jurusan();
        tampil_combo_program_studi();
        tampil_combo_golongan();
        tampil_combo_semester();
    }
public static BufferedImage loadImage(String ref){
        BufferedImage bimg =null;
        
        try {
            bimg = ImageIO.read(new File(ref));
        } catch (IOException e) {
        }
        
        return bimg;
    
    }
    public static BufferedImage resize(BufferedImage img, int newW,int newH){
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

    public static void createQRCode(String qrCodeData, String filePath,
			String charset, Map hintMap, int qrCodeheight, int qrCodewidth)
			throws WriterException, IOException {
                @SuppressWarnings("unchecked")
		BitMatrix matrix = new MultiFormatWriter().encode(
				new String(qrCodeData.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, qrCodewidth, qrCodeheight, hintMap);
		MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
				.lastIndexOf('.') + 1), new File(filePath));
	}

	public static String readQRCode(String filePath, String charset, Map hintMap)
			throws FileNotFoundException, IOException, NotFoundException {
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(
				new BufferedImageLuminanceSource(
						ImageIO.read(new FileInputStream(filePath)))));
                @SuppressWarnings("unchecked")
		Result qrCodeResult = new MultiFormatReader().decode(binaryBitmap,
				hintMap);
		return qrCodeResult.getText();
	}
        private void tampilQrCode(){
            qrCodeData=txtnim.getText();
        
        Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new EnumMap<>(EncodeHintType.class);
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

        try {
            createQRCode(qrCodeData, filePath, charset, hintMap, 800, 800);
            BufferedImage loadImg = loadImage(filePath);
            ImageIcon imageIcon = new ImageIcon(resize(loadImg,lbQrCode.getWidth(),lbQrCode.getHeight()));
            lbQrCode.setIcon(imageIcon);
        } catch (   WriterException | IOException ex) {
            Logger.getLogger(databaseMahasiswaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
		System.out.println("QR Code image created successfully!");

        try {
            System.out.println("Data read from QR Code: "
                    + readQRCode(filePath, charset, hintMap));
        } catch (   IOException | NotFoundException ex) {
            Logger.getLogger(databaseMahasiswaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    
    private void ambilData() {
        DefaultTableModel tbl = new DefaultTableModel();
        tbl.addColumn("NO");
        tbl.addColumn("ID");
        tbl.addColumn("NIM");
        tbl.addColumn("NAMA");
        tbl.addColumn("JURUSAN");
        tbl.addColumn("PROGRAM STUDI");
        tbl.addColumn("GOLONGAN");
        tbl.addColumn("SEMESTER");
        tbl.addColumn("JENIS KELAMIN");
        tbl.addColumn("NO TELEPON");
        tbl.addColumn("EMAIL");
        tbl.addColumn("ALAMAT");
        table_mahasiswa.setModel(tbl);
        try{
            Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from mahasiswa");
            int index = 1;
            while (res.next())
            {
                tbl.addRow(new Object []{
                    index,
                    res.getString("id_mahasiswa"),
                    res.getString("nim"),
                    res.getString("nama"),
                    res.getString("jurusan"),
                    res.getString("program_studi"),
                    res.getString("golongan"),
                    res.getString("semester"),
                    res.getString("jenis_kelamin"),
                    res.getString("no_telepon"),
                    res.getString("email"),
                    res.getString("alamat"),
                    
                });
                table_mahasiswa.setModel(tbl);
                index++;
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(rootPane, "Gagal Mengambil Data: " + e.getMessage());
        }
    }
    
    private void refresh()
    {
        txtnama.setText("");
        txtnim.setText("");
        txtnama.setText("");
        cmbjurusan.setSelectedItem("");
        cmbprogramstudi.setSelectedItem("");
        cmbgolongan.setSelectedItem("");
        cmbsemester.setSelectedItem("");
        cmbjeniskelamin.setSelectedItem("");
        txtnotelepon.setText("");
        txtemail.setText("");
        txtalamat.setText("");
        txtnim.requestFocus();
        
        ambilData();
    }
    public void tampil_combo_jurusan(){
       try{
           
           Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from jurusan");
           
           while(res.next()){
               cmbjurusan.addItem(res.getString("jurusan"));
               
           }
           
           res.last();
           int jumlahdata = res.getRow();
           res.first();
           
       }catch(Exception e){
           
       }
   }
    public void tampil_combo_program_studi(){
       try{
           
           Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from program_studi");
           
           while(res.next()){
               cmbprogramstudi.addItem(res.getString("program_studi"));
               
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
    public void tampil_combo_semester(){
       try{
           
           Statement statement = (Statement) koneksi.getConnection().createStatement();
            ResultSet res = statement.executeQuery("Select * from semester");
           
           while(res.next()){
               cmbsemester.addItem(res.getString("semester"));
               
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
        cmbjeniskelamin = new javax.swing.JComboBox<>();
        btnlogout = new javax.swing.JLabel();
        btnDashboardAdminMenu = new javax.swing.JLabel();
        btnDashboardPerkuliahanMenu = new javax.swing.JLabel();
        btnDashboardDosenMenu = new javax.swing.JLabel();
        btnDashboardMahasiswaMenu = new javax.swing.JLabel();
        btnDashboardHome = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_mahasiswa = new javax.swing.JTable();
        txtalamat = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtnim = new javax.swing.JTextField();
        cmbgolongan = new javax.swing.JComboBox<>();
        txtnama = new javax.swing.JTextField();
        cmbprogramstudi = new javax.swing.JComboBox<>();
        txtnotelepon = new javax.swing.JTextField();
        cmbsemester = new javax.swing.JComboBox<>();
        cmbjurusan = new javax.swing.JComboBox<>();
        panelid = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblnama = new javax.swing.JLabel();
        lbQrCode = new javax.swing.JLabel();
        lblnim = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JLabel();
        btnBuatEKTM = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnPrintEKTM = new javax.swing.JLabel();
        frameDrag = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
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

        cmbjeniskelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));
        getContentPane().add(cmbjeniskelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, 200, 30));

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

        table_mahasiswa.setModel(new javax.swing.table.DefaultTableModel(
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
        table_mahasiswa.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table_mahasiswa.setColumnSelectionAllowed(true);
        table_mahasiswa.setGridColor(new java.awt.Color(255, 255, 255));
        table_mahasiswa.setOpaque(false);
        table_mahasiswa.setSelectionBackground(new java.awt.Color(153, 255, 255));
        table_mahasiswa.setSelectionForeground(new java.awt.Color(153, 153, 153));
        table_mahasiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_mahasiswaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_mahasiswa);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 390, 330, 190));

        txtalamat.setBackground(new java.awt.Color(236, 236, 236));
        txtalamat.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtalamat.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtalamat.setBorder(null);
        getContentPane().add(txtalamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, 290, 40));

        txtemail.setBackground(new java.awt.Color(234, 229, 229));
        txtemail.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtemail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtemail.setBorder(null);
        getContentPane().add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 200, 30));

        txtnim.setBackground(new java.awt.Color(236, 236, 236));
        txtnim.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnim.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnim.setToolTipText("");
        txtnim.setBorder(null);
        getContentPane().add(txtnim, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 200, -1));

        getContentPane().add(cmbgolongan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 200, 30));

        txtnama.setBackground(new java.awt.Color(236, 236, 236));
        txtnama.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnama.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnama.setBorder(null);
        getContentPane().add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 148, 210, 20));

        cmbprogramstudi.setBorder(null);
        getContentPane().add(cmbprogramstudi, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 200, 30));

        txtnotelepon.setBackground(new java.awt.Color(234, 229, 229));
        txtnotelepon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtnotelepon.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtnotelepon.setBorder(null);
        getContentPane().add(txtnotelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 500, 200, 30));

        getContentPane().add(cmbsemester, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 380, 200, 30));

        cmbjurusan.setBorder(null);
        getContentPane().add(cmbjurusan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 200, 30));

        panelid.setMaximumSize(new java.awt.Dimension(133, 233));
        panelid.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ABSENN.2021");
        panelid.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 130, 10));

        lblnama.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        lblnama.setForeground(new java.awt.Color(255, 255, 255));
        lblnama.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnama.setText("nama");
        panelid.add(lblnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 130, 40));

        lbQrCode.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelid.add(lbQrCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 100));

        lblnim.setFont(new java.awt.Font("Tahoma", 1, 7)); // NOI18N
        lblnim.setForeground(new java.awt.Color(255, 255, 255));
        lblnim.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnim.setText("no.nim");
        panelid.add(lblnim, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 130, 40));

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/E-KTM (1).png"))); // NOI18N
        panelid.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, -1));

        getContentPane().add(panelid, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, 230));

        btnCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCreateMouseClicked(evt);
            }
        });
        getContentPane().add(btnCreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 144, 70, 20));

        btnBuatEKTM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuatEKTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuatEKTMMouseClicked(evt);
            }
        });
        getContentPane().add(btnBuatEKTM, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 70, 30));

        btnRefresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRefreshMouseClicked(evt);
            }
        });
        getContentPane().add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 70, 30));

        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        getContentPane().add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 220, 70, 30));

        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });
        getContentPane().add(btnUpdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 70, 20));

        btnPrintEKTM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintEKTM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPrintEKTMMouseClicked(evt);
            }
        });
        getContentPane().add(btnPrintEKTM, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 344, 70, 20));

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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/DATABASE MAHASISWA ADMIN.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtid.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 51, 51), null, null));
        getContentPane().add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 80, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_mahasiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_mahasiswaMouseClicked
        int i = table_mahasiswa.getSelectedRow();
        if (i == -1){
            return;
        }
        String id = (String) table_mahasiswa.getValueAt(i, 1);
        txtid.setText(id);
        String nim = (String) table_mahasiswa.getValueAt(i, 2);
        txtnim.setText(nim);
        String nama = (String) table_mahasiswa.getValueAt(i, 3);
        txtnama.setText(nama);
        String jurusan = (String) table_mahasiswa.getValueAt(i, 4);
        cmbjurusan.setSelectedItem(jurusan);
        String program_studi = (String) table_mahasiswa.getValueAt(i, 5);
        cmbprogramstudi.setSelectedItem(program_studi);
        String golongan = (String) table_mahasiswa.getValueAt(i, 6);
        cmbgolongan.setSelectedItem(golongan);
        String semester = (String) table_mahasiswa.getValueAt(i, 7);
        cmbsemester.setSelectedItem(semester);
        String jenis_kelamin = (String) table_mahasiswa.getValueAt(i, 8);
        cmbjeniskelamin.setSelectedItem(jenis_kelamin);
        String no_telepon = (String) table_mahasiswa.getValueAt(i, 9);
        txtnotelepon.setText(no_telepon);
        String email = (String) table_mahasiswa.getValueAt(i, 10);
        txtemail.setText(email);
        String alamat = (String) table_mahasiswa.getValueAt(i, 11);
        txtalamat.setText(alamat);
    }//GEN-LAST:event_table_mahasiswaMouseClicked

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
        if(!txtid.getText().equals("")){
            JOptionPane.showMessageDialog(null,
                "Silahkan refresh terlebih dahulu!");
        }
        else{
            String id = txtid.getText();
            String nim = txtnim.getText();
            String nama = txtnama.getText();
            String jurusan=(String)cmbjurusan.getSelectedItem();
            String program_studi=(String)cmbprogramstudi.getSelectedItem();
            String golongan = (String)cmbgolongan.getSelectedItem();
            String semester = (String) cmbsemester.getSelectedItem();
            String jenis_kelamin = (String) cmbjeniskelamin.getSelectedItem();
            String no_telepon = txtnotelepon.getText();
            String email = txtemail.getText();
            String alamat = txtalamat.getText();

            try{
                Statement statement = (Statement) koneksi.getConnection().createStatement();
                statement.executeUpdate("insert into mahasiswa VALUES ( null, '" + nim + "','"
                    + nama +"','"+ jurusan +"','"+ program_studi +"','"+ golongan +"','"+ semester +"','"+ jenis_kelamin +"','"+ no_telepon +"','"+ email +"','"+ alamat +"')");
                statement.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil disimpan");

                refresh();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data Gagal Disimpan: " + e.getMessage());
            }
        }
        tampil_combo_jurusan();
        tampil_combo_program_studi();
        tampil_combo_golongan();
        tampil_combo_semester();
    }//GEN-LAST:event_btnCreateMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        if(txtid.getText().equals("")){
            String id = txtid.getText();
            String nim = txtnim.getText();
            String nama = txtnama.getText();
            String jurusan = (String) cmbjurusan.getSelectedItem();
            String program_studi = (String) cmbprogramstudi.getSelectedItem();
            String golongan = (String) cmbgolongan.getSelectedItem();
            String semester = (String) cmbsemester.getSelectedItem();
            String jenis_kelamin = (String) cmbjeniskelamin.getSelectedItem();
            String no_telepon = txtnotelepon.getText();
            String email = txtemail.getText();
            String alamat = txtalamat.getText();

            try{
                Statement statement = (Statement) koneksi.getConnection().createStatement();
                statement.executeUpdate("update mahasiswa SET nim='"+nim+"'," + "nama='"+nama+"',"
                        + "jurusan='"+jurusan+"',"
                                + "program_studi='"+program_studi+"',"
                                        + "golongan='"+golongan+"',"
                                                + "semester='"+semester+"',"
                                                        + "jenis_kelamin='"+jenis_kelamin+"',"
                                                                + "no_telepon='"+no_telepon+"',"
                                                                        + "email='"+email+"',"
                                                                                + "alamat='"+alamat+"' " + "WHERE id_mahasiswa = '"+id+"'");
                statement.close();
                JOptionPane.showMessageDialog(null, "Data Berhasil diubah");

                refresh();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data Gagal diubah: " + e.getMessage());
            }
        }
        else{
            JOptionPane.showMessageDialog(null,
                    "Silahkan pilih terlebih dahulu data yang akan  diupdate!");
        }
        tampil_combo_jurusan();
        tampil_combo_program_studi();
        tampil_combo_golongan();
        tampil_combo_semester();
    }//GEN-LAST:event_btnUpdateMouseClicked

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
                statement.executeUpdate("delete from mahasiswa where id_mahasiswa = '" + id + "'");
                JOptionPane.showMessageDialog(null, "Data Berhasil di Hapus");

                refresh();
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Data Gagal di Hapus: " + e.getMessage());
            }
        }
        tampil_combo_jurusan();
        tampil_combo_program_studi();
        tampil_combo_golongan();
        tampil_combo_semester();
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRefreshMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnRefreshMouseClicked

    private void btnBuatEKTMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuatEKTMMouseClicked
        // TODO add your handling code here:
        tampilQrCode();
        String nama= txtnama.getText();
        String nim= txtnim.getText();

        lblnim.setText(nama);
        lblnama.setText(nim);
    }//GEN-LAST:event_btnBuatEKTMMouseClicked

    private void btnPrintEKTMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPrintEKTMMouseClicked
        // TODO add your handling code here:
        try {
            Toolkit tkp = panelid.getToolkit();
            PrintJob pjp = tkp.getPrintJob(this, null, null);
            Graphics g = pjp.getGraphics();
            panelid.print(g);
            g.dispose();
            pjp.end();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnPrintEKTMMouseClicked

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
            java.util.logging.Logger.getLogger(databaseMahasiswaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(databaseMahasiswaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(databaseMahasiswaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(databaseMahasiswaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new databaseMahasiswaMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBuatEKTM;
    private javax.swing.JLabel btnCreate;
    private javax.swing.JLabel btnDashboardAdminMenu;
    private javax.swing.JLabel btnDashboardDosenMenu;
    private javax.swing.JLabel btnDashboardHome;
    private javax.swing.JLabel btnDashboardMahasiswaMenu;
    private javax.swing.JLabel btnDashboardPerkuliahanMenu;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JLabel btnPrintEKTM;
    private javax.swing.JLabel btnRefresh;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JLabel btnlogout;
    private javax.swing.JComboBox<String> cmbgolongan;
    private javax.swing.JComboBox<String> cmbjeniskelamin;
    private javax.swing.JComboBox<String> cmbjurusan;
    private javax.swing.JComboBox<String> cmbprogramstudi;
    private javax.swing.JComboBox<String> cmbsemester;
    private javax.swing.JLabel frameDrag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelClose;
    private javax.swing.JLabel jLabelMin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbQrCode;
    private javax.swing.JLabel lblnama;
    private javax.swing.JLabel lblnim;
    private javax.swing.JPanel panelid;
    private javax.swing.JTable table_mahasiswa;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnim;
    private javax.swing.JTextField txtnotelepon;
    // End of variables declaration//GEN-END:variables
}
