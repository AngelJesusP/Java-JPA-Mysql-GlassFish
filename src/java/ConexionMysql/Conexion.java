/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionMysql;

/**
 *
 * @author angel
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    
    private Connection conexion;
    private String URL = "jdbc:mysql://localhost:3306/testJPACRUD";
    private String USER = "root";
    private String PASSWORD = "";
    
    public Connection getConexionMysql() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            return this.conexion;
        } catch (Exception e) {
            return null;
        }
    }
}
