package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static final String URL_BASE = "jdbc:mysql://localhost:3306/";
    private static final String URL = "jdbc:mysql://localhost:3306/veterinaria_system";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try {
                Connection connBase = DriverManager.getConnection(URL_BASE, USER, PASSWORD);
                Statement stmt = connBase.createStatement();
                stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS veterinaria_system");
                stmt.close();
                connBase.close();
            } catch (SQLException e) {

            }
            
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("Driver no encontrado");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error de conexión a la BD");
            e.printStackTrace();
        }
        return null;
    }
}