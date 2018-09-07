/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JdbcConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class JdbcConexion {

    private static final String USER = "sa";
    private static final String URL = "jdbc:sqlserver://DESKTOP-CS6VCNI:1433;databaseName=resespa";
    private static final String PASSWORD = "1234";
    private static transient Connection conexion=null;
    
    public static Connection conexion() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        return conexion;
    
    }
}
