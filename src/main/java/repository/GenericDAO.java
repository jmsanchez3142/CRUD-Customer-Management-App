package repository;

import java.util.List;

/**
 * Interfaz genérica para las operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
 * Esta interfaz proporciona métodos estándar para interactuar con entidades persistentes en la base de datos.
 *
 * @param <T> Tipo de la entidad con la que interactúa este DAO.
 */
public interface GenericDAO<T> {

    /**
     * Crea un nuevo objeto en la base de datos.
     *
     * @param entity El objeto que se va a crear en la base de datos.
     */
    void add(T entity);

    /**
     * Actualiza un objeto en la base de datos.
     *
     * @param entity El objeto que se va a actualizar en la base de datos.
     */
    void update(T entity);

    /**
     * Elimina un objeto de la base de datos por su identificador.
     *
     * @param id El identificador del objeto que se va a eliminar.
     */
    void delete(String id);

    /**
     * Obtiene un objeto de la base de datos por su identificador.
     *
     * @param id El identificador del objeto que se desea obtener.
     * @return El objeto encontrado, o null si no se encontró ningún objeto con el identificador especificado.
     */
    T get(String id);

    /**
     * Obtiene todos los objetos de la base de datos.
     *
     * @return Una lista que contiene todos los objetos recuperados de la base de datos.
     */
    List<T> getAll();
}
