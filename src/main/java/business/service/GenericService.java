package business.service;

import java.util.List;

/**
 * Interfaz genérica para definir operaciones básicas de un servicio CRUD.
 *
 * @param <T> El tipo de entidad con la que trabaja el servicio.
 */
public interface GenericService<T> {

    /**
     * Agrega una entidad al servicio.
     *
     * @param entity La entidad que se va a agregar.
     */
    void add(T entity);

    /**
     * Actualiza una entidad en el servicio.
     *
     * @param entity La entidad que se va a actualizar.
     */
    void update(T entity);

    /**
     * Elimina una entidad del servicio basándose en su identificador único.
     *
     * @param id El identificador único de la entidad que se va a eliminar.
     */
    void delete(String id);

    /**
     * Obtiene una entidad del servicio basándose en su identificador único.
     *
     * @param id El identificador único de la entidad que se va a obtener.
     * @return La entidad correspondiente al identificador proporcionado, o {@code null} si no se encuentra.
     */
    T get(String id);

    /**
     * Obtiene todas las entidades almacenadas en el servicio.
     *
     * @return Una lista con todas las entidades almacenadas en el servicio.
     */
    List<T> getAll();
}
