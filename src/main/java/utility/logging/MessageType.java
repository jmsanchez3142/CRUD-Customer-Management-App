package utility.logging;

/**
 * Enumeración que define los diferentes tipos de mensajes de log que pueden ser utilizados en la aplicación.
 * Este enumerado ayuda a categorizar y estructurar los mensajes de log para facilitar su manejo y lectura.
 */
public enum MessageType {
    /**
     * Mensaje de error al intentar agregar una entidad.
     * Uso típico: cuando ocurre un error durante la operación de inserción de una nueva entidad en la base de datos.
     */
    ERROR_ADD,

    /**
     * Mensaje de error al intentar obtener una entidad por su ID.
     * Uso típico: cuando ocurre un error al recuperar una entidad específica utilizando su identificador único.
     */
    ERROR_GET_BY_ID,

    /**
     * Mensaje de error al intentar obtener todas las entidades.
     * Uso típico: cuando ocurre un error durante la operación de recuperación de todas las entidades de un tipo específico.
     */
    ERROR_GET_ALL,

    /**
     * Mensaje de error al intentar actualizar una entidad.
     * Uso típico: cuando ocurre un error durante la operación de actualización de una entidad existente.
     */
    ERROR_UPDATE,

    /**
     * Mensaje de error al intentar eliminar una entidad.
     * Uso típico: cuando ocurre un error durante la operación de eliminación de una entidad.
     */
    ERROR_DELETE,

    /**
     * Mensaje de éxito al agregar una entidad.
     * Uso típico: cuando una operación de inserción de una nueva entidad en la base de datos se completa con éxito.
     */
    SUCCESS_ADD,

    /**
     * Mensaje de éxito al obtener una entidad.
     * Uso típico: cuando una operación de recuperación de una entidad específica utilizando su identificador único se completa con éxito.
     */
    SUCCESS_GET,

    /**
     * Mensaje de éxito al obtener todas las entidades.
     * Uso típico: cuando una operación de recuperación de todas las entidades de un tipo específico se completa con éxito.
     */
    SUCCESS_GET_ALL,

    /**
     * Mensaje de éxito al actualizar una entidad.
     * Uso típico: cuando una operación de actualización de una entidad existente se completa con éxito.
     */
    SUCCESS_UPDATE,

    /**
     * Mensaje de éxito al eliminar una entidad.
     * Uso típico: cuando una operación de eliminación de una entidad se completa con éxito.
     */
    SUCCESS_DELETE,

    /**
     * Mensaje de advertencia cuando una entidad no se encuentra.
     * Uso típico: cuando una operación de búsqueda de una entidad específica utilizando su identificador único no encuentra resultados.
     */
    WARNING_NOT_FOUND
}
