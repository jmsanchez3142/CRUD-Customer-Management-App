package business.validation;

/**
 * Interfaz para validar entidades genéricas.
 *
 * @param <T> Tipo de entidad que se valida.
 */
public interface GenericValidator<T> {

    /**
     * Método para validar una entidad específica.
     *
     * @param entity La entidad que se va a validar.
     */
    void validate(T entity);
}
