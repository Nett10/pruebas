package KameJavaHa;
import java.sql.*;
import java.sql.Connection;

public class Main {


    public static void main(String[] args) throws DAOException {
        Connection conn = null;
        try {

            System.out.println("Hello world!");
            MySQLJugador mySQLJugador = new MySQLJugador(conn);
            Jugador nuevoJugador = new Jugador("ferran", "Diez", 10, 15.5);
            mySQLJugador.insertar(nuevoJugador);
        }catch (DAOException e){
            throw new DAOException("Error al insertar el jugador." + e.getLocalizedMessage());
        }finally {
            if(conn == null){
                try{
                    conn.close();
                }catch(SQLException e){
                    throw new DAOException("Error");
                }
            }
        }




    }
}