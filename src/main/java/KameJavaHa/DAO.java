package KameJavaHa;
import java.util.List;
public interface DAO <T>{
    void insertar(T t) throws DAOException;
    void modificar(T t);
    void eliminar(T t) throws DAOException;
    List<T> obtenerTodos() throws DAOException;
    T obtener() throws DAOException;

}



