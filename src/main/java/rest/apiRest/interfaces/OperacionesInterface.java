package rest.apiRest.interfaces;

import java.util.List;
import java.util.Optional;
/**
 *
 * @author Daniel Arias
 */
public interface OperacionesInterface<T, E> {

    public List<T> obtenerTodos();

    public Boolean agregar(T miObjeto);

    public Long cantidadRegistros();

    public Boolean eliminar(E llavePrimaria);

    public Boolean actualizar(T miObjeto);

    public Optional<T> buscarPorId(E llavePrimaria);
}
