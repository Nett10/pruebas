package KameJavaHa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLJugador implements JugadorDAO{
    MySQLJugador mySQLJugador;
    final String DELETE = "DELETE from Jugador WHERE idJugador =?";
    final String GETONE = "SELECT idJugador, nombre, apellido, dorsal, promedioPuntos FROM jugador WHERE idJugador = ?";
    final String INSERT = " INSERT INTO jugador(nombre, apellidos, dorsal, mediaPuntos) VALUES(?,?,?,?)";
    private Connection conn;
    public MySQLJugador(Connection conn) {
       this.conn = conn;
       }

    @Override
    public void insertar(Jugador jugador) throws DAOException {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(INSERT);
            stat.setString(1,jugador.getNombre());
            stat.setString(2,jugador.getApellido());
            stat.setInt(3,jugador.getDorsal());
            stat.setDouble(4,jugador.getPromedioPuntos());
            System.out.println("Introducido correctamente.");
            if(stat.executeUpdate() == 0){
                throw new DAOException(("Error al guardar datos."));
            }
        }catch(SQLException ex){
            throw new DAOException("Error en SQL"+ ex.getMessage(),ex);
        } finally {
            if(stat != null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new DAOException("Error en SQL", ex);
                }
            }
        }
    }



    @Override
    public void modificar(Jugador jugador) {

    }

    @Override
    public void eliminar(Jugador jugador) throws DAOException {


        PreparedStatement stat = null;
        int idJugador = -1; // Valor por defecto si no se encuentra el ID
        ResultSet rs = null;
        try {
            String query = "DELETE FROM jugador WHERE nombre = ? AND apellidos = ?";
            stat = conn.prepareStatement(query);
            stat.setString(1, jugador.getNombre());
            stat.setString(2, jugador.getApellido());
            stat.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al eliminar el jugador", e);
        } finally {
            // Cierre de recursos
            try {
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException ex) {
                throw new DAOException("Error al cerrar PreparedStatement", ex);
            }
        }
        }





    @Override
    public List<Jugador> obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Jugador> jugadores = new ArrayList<>();

        try {
            String query = "SELECT idJugador, nombre, apellidos, dorsal, mediaPuntos FROM jugador";
            stat = conn.prepareStatement(query);
            rs = stat.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellidos");
                int dorsal = rs.getInt("dorsal");
                double promedioPuntos = rs.getDouble("mediaPuntos");

                Jugador jugador = new Jugador( nombre, apellido, dorsal, promedioPuntos);
                jugadores.add(jugador);
            }
        } catch (SQLException e) {
            throw new DAOException("Error al obtener todos los jugadores. "+  e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException ex) {
                throw new DAOException("Error al cerrar ResultSet o PreparedStatement", ex);
            }
        }

        return jugadores;
    }


    @Override
    public Jugador obtener() throws DAOException {
        return null;
    }

    @Override
    public Jugador mostrarJugador(Jugador jugador) throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        Jugador jugadorEncontrado = null;

        try {
            String query = "SELECT idJugador, nombre, apellido, dorsal, promedioPuntos FROM jugador WHERE nombre = ? AND apellido = ?";
            stat = conn.prepareStatement(query);
            stat.setString(1, jugador.getNombre());
            stat.setString(2, jugador.getApellido());
            rs = stat.executeQuery();

            if (rs.next()) {
                int idJugador = rs.getInt("idJugador");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dorsal = rs.getInt("dorsal");
                double promedioPuntos = rs.getDouble("mediaPuntos");

                jugadorEncontrado = new Jugador( nombre, apellido, dorsal, promedioPuntos);
            }
        } catch (SQLException e) {
            throw new DAOException("Error al mostrar jugador", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stat != null) {
                    stat.close();
                }
            } catch (SQLException ex) {
                throw new DAOException("Error al cerrar ResultSet o PreparedStatement", ex);
            }
        }

        if (jugadorEncontrado == null) {
            throw new DAOException("Jugador no encontrado en la base de datos");
        }

        return jugadorEncontrado;
    }


}
