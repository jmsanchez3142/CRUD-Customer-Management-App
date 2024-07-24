package utility.config;

/**
 * Interfaz para cargar la configuración de la base de datos.
 * Proporciona métodos para obtener los detalles de configuración necesarios para establecer una conexión a la base de datos.
 */
public interface DatabaseConfigLoader {

    /**
     * Obtiene la URL de la base de datos.
     *
     * @return La URL de la base de datos.
     */
    String getDatabaseUrl();

    /**
     * Obtiene el nombre de usuario para la base de datos.
     *
     * @return El nombre de usuario para la base de datos.
     */
    String getDatabaseUsername();

    /**
     * Obtiene la contraseña para la base de datos.
     *
     * @return La contraseña para la base de datos.
     */
    String getDatabasePassword();

    /**
     * Obtiene el nombre de la clase del driver de la base de datos.
     *
     * @return El nombre de la clase del driver de la base de datos.
     */
    String getDatabaseDriverClassName();

    /**
     * Obtiene las opciones adicionales de la base de datos.
     *
     * @return Las opciones adicionales de la base de datos.
     */
    String getDatabaseOptions();
}
