package KameJavaHa;

public interface JugadorDAO extends DAO<Jugador> {

    Jugador mostrarJugador(Jugador jugador) throws DAOException;

}
