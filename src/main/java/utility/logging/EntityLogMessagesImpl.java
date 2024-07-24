package utility.logging;

/**
 * Implementación de la interfaz {@link LogMessages} para proporcionar mensajes de log relacionados con entidades.
 * Esta clase se encarga de generar mensajes de log específicos para operaciones con entidades de tipo genérico.
 */
public class EntityLogMessagesImpl<T> implements LogMessages<T> {

    /**
     * Obtiene un mensaje de log basado en el tipo de mensaje y los parámetros proporcionados.
     * Este método permite generar mensajes de log dinámicos, formateando los parámetros según sea necesario.
     *
     * @param messageType el tipo de mensaje de log a generar.
     * @param params los parámetros opcionales que se incluirán en el mensaje de log.
     * @return el mensaje de log formateado como una cadena.
     * @throws IllegalArgumentException si el tipo de mensaje no es soportado.
     */
    @Override
    public String getMessage(MessageType messageType, Object... params) {
        switch (messageType) {
            case ERROR_ADD:
                return String.format("Error al agregar la entidad: %s", params);
            case ERROR_GET_BY_ID:
                return String.format("Error al obtener la entidad con ID: %s", params);
            case ERROR_GET_ALL:
                return "Error al obtener todas las entidades";
            case ERROR_UPDATE:
                return String.format("Error al actualizar la entidad: %s", params);
            case ERROR_DELETE:
                return String.format("Error al eliminar la entidad con ID: %s", params);
            case SUCCESS_ADD:
                return String.format("Entidad agregada con éxito: %s", params);
            case SUCCESS_GET:
                return String.format("Entidad obtenida con éxito: %s", params);
            case SUCCESS_GET_ALL:
                return "Todas las entidades obtenidas con éxito";
            case SUCCESS_UPDATE:
                return String.format("Entidad actualizada con éxito: %s", params);
            case SUCCESS_DELETE:
                return String.format("Entidad eliminada con éxito: ID=%s", params);
            case WARNING_NOT_FOUND:
                return String.format("Entidad no encontrada con ID: %s", params);
            default:
                throw new IllegalArgumentException("Tipo de mensaje no soportado");
        }
    }
}
