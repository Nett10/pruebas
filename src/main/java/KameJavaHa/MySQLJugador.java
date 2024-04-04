package KameJavaHa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MySQLJugador implements JugadorDAO{
    final String INSERT = " INSERT INTO jugador(nombre, apellidos, dorsal, promedioPuntos) VALUES(?,?,?,?)";
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
            throw new DAOException("Error en SQL", ex);
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
    public void eliminar(Jugador jugador) {

    }

    @Override
    public List<Jugador> obtenerTodos() {
        return null;
    }

    @Override
    public Jugador obtener() {
        return null;
    }
}
