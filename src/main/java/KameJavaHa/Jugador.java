package KameJavaHa;

public class Jugador {
    private String nombre;
    private String apellido;
    private int dorsal;
    private double promedioPuntos;

    public Jugador(String nombre, String apellido, int dorsal, double promedioPuntos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dorsal = dorsal;
        this.promedioPuntos = promedioPuntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public double getPromedioPuntos() {
        return promedioPuntos;
    }

    public void setPromedioPuntos(double promedioPuntos) {
        this.promedioPuntos = promedioPuntos;
    }


        @Override
        public String toString() {
            return "Jugador{" +
                    "nombre='" + nombre + '\'' +
                    ", apellido='" + apellido + '\'' +
                    ", dorsal=" + dorsal +
                    ", promedioPuntos=" + promedioPuntos +
                    '}';
        }
    }

