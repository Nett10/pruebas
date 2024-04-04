package KameJavaHa;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private Scanner teclado = new Scanner(System.in);
    private MySQLJugador mySQLJugador;

    public Main(Connection conn) {
        this.mySQLJugador = new MySQLJugador(conn);
    }

    public static void main(String[] args) {
        try {
            Connection conn = null;
            try {
                System.out.println("Hello world!");
                Conexion conexion = new Conexion();
                conn = conexion.conectar(); // Conectar a la base de datos
                Main main = new Main(conn); // Pasar la conexión al constructor de Main
                main.insertarSocio();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        System.err.println("Error al cerrar la conexión: " + e.getMessage());
                    }
                }
            }
        } catch (DAOException e) {
            System.err.println("Error al insertar el jugador: " + e.getMessage());
        }
    }

    public void insertarSocio() throws DAOException {
        System.out.println("Introduce nombre:");
        String nombre = teclado.nextLine();
        System.out.println("Introduce apellidos:");
        String apellidos = teclado.nextLine();
        System.out.println("Introduce dorsal:");
        int dorsal = teclado.nextInt();
        System.out.println("Introduce puntos de media:");
        double puntosMedia = teclado.nextDouble();
        teclado.nextLine(); // Limpiar el buffer de entrada
        Jugador nuevoJugador = new Jugador(nombre, apellidos, dorsal, puntosMedia);
        mySQLJugador.insertar(nuevoJugador);
    }
}
