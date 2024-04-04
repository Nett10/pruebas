package KameJavaHa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USUARIO = "usuario";
    private static final String CONTRASEÑA = "contraseña";
    private Connection conn;

    public Conexion() {
        cargarControlador();
        this.conn = establecerConexion();
    }

    private void cargarControlador() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private Connection establecerConexion() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void cerrarConexion() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
