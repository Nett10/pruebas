package KameJavaHa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    String url = "jdbc:mysql://127.0.0.1:3306/pruebaBasquet?user=root";
    String user = "root";
    String password = "Oria2606";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection cx;

    public Conexion() {

    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            cx = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Se conectó a la base de datos.");

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a la BBDD ");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE,null,ex);
        }

        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
            System.out.println("Se ha desconectado de la base de datos.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
