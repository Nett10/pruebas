package KameJavaHa;
import java.sql.*;
import java.util.List;
import java.util.Scanner;
import KameJavaHa.MySQLJugador;

public class Main {
    private Scanner teclado = new Scanner(System.in);
    private MySQLJugador mySQLJugador;
    JugadorService jugadorService = new JugadorService();

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
                main.BorrarJugador();
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
    }public void BorrarJugador()throws DAOException{
        Jugador jugadorABorrar = null;
        System.out.println("vamos a borrar un jugador.selecciona por nombre.");
        List<Jugador> jugadores = mySQLJugador.obtenerTodos(); // Suponiendo que este método devuelve una lista de jugadores
        jugadorService.imprimirJugadores(jugadores);
        System.out.println("vamos a borrar un jugador.");
        String nombre = teclado.nextLine();
        for(Jugador jugador: jugadores){
            if (jugador.getNombre().equals(nombre)){
               jugadorABorrar = jugador;
               break;
            }
        }
        if(jugadorABorrar!= null){
            mySQLJugador.eliminar(jugadorABorrar);
            System.out.println("jugador borrado con éxito de la base de datos");
        }else{
            System.out.println("No se encontró un jugador con ese nombre");
        }
    }

}
