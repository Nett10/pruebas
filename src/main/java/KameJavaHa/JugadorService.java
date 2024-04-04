package KameJavaHa;

import java.util.List;

public class JugadorService {

    public void imprimirJugadores(List<Jugador> jugadores) {
        for (Jugador jugador : jugadores) {
            System.out.println(jugadorToString(jugador));
        }
    }

    private String jugadorToString(Jugador jugador) {
        return ", Nombre: " + jugador.getNombre() + ", Apellido: " + jugador.getApellido() + ", Dorsal: " + jugador.getDorsal() ;
    }
}
