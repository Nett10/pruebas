package KameJavaHa;
import java.util.List;
public interface DAO <T>{
    void insertar(T t) throws DAOException;
    void modificar(T t);
    void eliminar(T t);
    List<T> obtenerTodos();
    T obtener();

}



