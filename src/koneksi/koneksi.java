package koneksi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author USER
 */
public class koneksi {
    public static Connection getConnection(){
    

    Connection con = null;
    try {
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://Localhost/absenn","root","");
    
} catch (ClassNotFoundException | SQLException ex){
    JOptionPane.showMessageDialog(null, "Koneksi Gagal");
}
    return con;
}

  
    

  
}
