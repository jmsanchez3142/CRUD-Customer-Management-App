package utility.config;

import utility.loader.PropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Implementación de la interfaz {@link DatabaseConfigLoader} para cargar la configuración de la base de datos
 * desde un archivo de propiedades.
 */
public class DatabaseConfigLoaderImpl implements DatabaseConfigLoader {

    // Logger para registrar eventos y errores.
    private static final Logger logger = LoggerFactory.getLogger(DatabaseConfigLoaderImpl.class);

    // Cargador de propiedades.
    private final PropertiesLoader propertiesLoader;

    // Nombre del archivo de propiedades.
    private final String propertiesFileName;

    /**
     * Constructor que inicializa el cargador de propiedades y el nombre del archivo de propiedades.
     *
     * @param propertiesLoader   La instancia de {@link PropertiesLoader} utilizada para cargar las propiedades.
     * @param propertiesFileName El nombre del archivo de propiedades que contiene la configuración de la base de datos.
     */
    public DatabaseConfigLoaderImpl(PropertiesLoader propertiesLoader, String propertiesFileName) {
        this.propertiesLoader = propertiesLoader;
        this.propertiesFileName = propertiesFileName;
    }

    /**
     * Obtiene la URL de la base de datos desde las propiedades cargadas.
     *
     * @return La URL de la base de datos.
     */
    @Override
    public String getDatabaseUrl() {
        return getProperty("db.url");
    }

    /**
     * Obtiene el nombre de usuario para la base de datos desde las propiedades cargadas.
     *
     * @return El nombre de usuario para la base de datos.
     */
    @Override
    public String getDatabaseUsername() {
        return getProperty("db.username");
    }

    /**
     * Obtiene la contraseña para la base de datos desde las propiedades cargadas.
     *
     * @return La contraseña para la base de datos.
     */
    @Override
    public String getDatabasePassword() {
        return getProperty("db.password");
    }

    /**
     * Obtiene el nombre de la clase del driver de la base de datos desde las propiedades cargadas.
     *
     * @return El nombre de la clase del driver de la base de datos.
     */
    @Override
    public String getDatabaseDriverClassName() {
        return getProperty("db.driverClassName");
    }

    /**
     * Obtiene las opciones adicionales de la base de datos desde las propiedades cargadas.
     *
     * @return Las opciones adicionales de la base de datos.
     */
    @Override
    public String getDatabaseOptions() {
        return getProperty("db.options");
    }

    /**
     * Obtiene el valor de la propiedad especificada desde el archivo de propiedades.
     *
     * @param key La clave de la propiedad a obtener.
     * @return El valor de la propiedad.
     * @throws IllegalStateException si la propiedad no se encuentra en el archivo.
     */
    private String getProperty(String key) {
        Properties properties = propertiesLoader.loadProperties(propertiesFileName);
        String value = properties.getProperty(key);
        if (value == null) {
            String errorMsg = "No se encontró la propiedad '" + key + "' en el archivo " + propertiesFileName;
            logger.error(errorMsg);
            throw new IllegalStateException(errorMsg);
        }
        return value;
    }
}
