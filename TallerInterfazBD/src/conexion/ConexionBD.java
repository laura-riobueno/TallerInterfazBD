package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static Connection connection = null;
    private static String jdbcURL = "jdbc:postgresql://localhost:5432/EnsambleModulo";
    private static String username = "postgres";
    private static String password = "hydro";

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("Connected to PostgreSQL server");

        } catch (SQLException e) {
            System.out.println("error in conecting to PostgreSQL server");
            e.printStackTrace();
        }
        return connection;
    }

    public static void dissconect() {
        connection = null;
    }
}