package utility.logging;

/**
 * Interfaz para la generación de mensajes de log personalizados.
 * Esta interfaz define un método para obtener mensajes de log basados en un tipo de mensaje y parámetros opcionales.
 *
 * @param <T> el tipo de entidad al que se refiere el mensaje de log.
 */
public interface LogMessages<T> {
    /**
     * Obtiene un mensaje de log basado en el tipo de mensaje y los parámetros proporcionados.
     * Este método permite generar mensajes de log dinámicos, formateando los parámetros según sea necesario.
     *
     * @param messageType el tipo de mensaje de log a generar.
     * @param params los parámetros opcionales que se incluirán en el mensaje de log.
     * @return el mensaje de log formateado como una cadena.
     */
    String getMessage(MessageType messageType, Object... params);
}
